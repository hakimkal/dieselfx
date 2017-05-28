package com.dieselfx.domains;

import lombok.Data;

import java.util.List;

/**
 * Created by ozo on 28/05/2017.
 */
@Data
public class InfoResponse {
    private String type;
    private List<Feature> features;
}