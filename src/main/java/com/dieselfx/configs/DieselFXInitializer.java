package com.dieselfx.configs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.MultiValueMap;
import com.dieselfx.dao.Accessor;
import com.dieselfx.dao.Filter;
import com.dieselfx.domains.*;
import com.dieselfx.domains.constants.UserType;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by abdulhakim on 10/14/16.
 */

@Component
public class DieselFXInitializer implements CommandLineRunner {




    @Override
    // @Transactional
    public void run(String... strings) throws Exception {



    }

}
