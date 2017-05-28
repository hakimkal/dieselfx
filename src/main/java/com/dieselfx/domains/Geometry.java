package com.dieselfx.domains;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.List;

/**
 * Created by ozo on 28/05/2017.
 */
@Data
@Embeddable
public class Geometry {
    private String type;
    private String coordinates;
}
