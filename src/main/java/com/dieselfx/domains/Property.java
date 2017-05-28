package com.dieselfx.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by ozo on 28/05/2017.
 */
@Data
@Entity
public class Property {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String category;
    private String hours;
    private String description;
    private String name;
    private String phone;
}
