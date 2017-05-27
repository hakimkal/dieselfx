package com.dieselfx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.lang3.StringUtils;
import com.dieselfx.dao.Param;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by emmanuel on 12/6/16.
 */
public class Utility {

    /**
     * Convert errors in binding result to a Map
     * @param bindingResult
     * @return
     */
    public static Map<String, String> errors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });
        return errors;
    }

    /**
     * Convert request Parameters in HttpServletRequest object to a map
     * @param r
     * @return
     */
    public static Map<String, String> getRequestParams(HttpServletRequest r){
        Map<String, String> params = new HashMap<>();
        Enumeration<String> e = r.getParameterNames();
        while(e.hasMoreElements()){
            String name = e.nextElement();
            params.put(name, r.getParameter(name));
        }
        return params;
    }

    /**
     * create a db pagination statement from parameters supplied in HttpServletRequest object
     * @param req
     * @return
     */
    public static Param getParam(HttpServletRequest req){
        Param p = new Param(0, 50);
        String page = req.getParameter("page");
        if(StringUtils.isNumeric(page)){
            p.setPage(Integer.valueOf(page));
        }

        String size = req.getParameter("size");
        if(StringUtils.isNumeric(size)){
            p.setSize(Integer.valueOf(size));
        }

        String sort = req.getParameter("sort");
        p.setSort("created_at DESC");//Default;
        if(StringUtils.isNotEmpty(sort)){
            p.setSort(sort);
        }

        return p;
    }


    public  static String generateClassName(String classLevelName, String classArm) throws IllegalArgumentException{
        if(classLevelName == null || StringUtils.isBlank(classArm)){
            throw new IllegalArgumentException("class Type must not be null, classLevel cannot be zero and classArm cannot be empty");
        }

        StringBuilder sb = new StringBuilder(classLevelName);
        sb.append(" ").append(classArm);

        return sb.toString();
    }


    public static String createJsonStringFromObject(Object object){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return json;
    }


    private static Path buildPath(final Path root, final Path child) {
        if (root == null) {
            return child;
        } else {
            return Paths.get(root.toString(), child.toString());
        }
    }

    /**
     *
     * @param out
     * @param root
     * @param dir
     * @throws IOException
     */
    private static void addZipDir(final ZipOutputStream out, final Path root, final Path dir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path child : stream) {
                Path entry = buildPath(root, child.getFileName());
                if (Files.isDirectory(child)) {
                    addZipDir(out, entry, child);
                } else {
                    out.putNextEntry(new ZipEntry(entry.toString()));
                    Files.copy(child, out);
                    out.closeEntry();
                }
            }
        }
    }

    /**
     * Compress the given path to a zip
     * @param path
     * @throws IOException
     */
    public static void zipDir(final Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory.");
        }

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toString() + ".zip"));

        try (ZipOutputStream out = new ZipOutputStream(bos)) {
            addZipDir(out, path.getFileName(), path);
        }
    }



}
