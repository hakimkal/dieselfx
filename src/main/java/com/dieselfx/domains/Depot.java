package com.dieselfx.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ozo on 28/05/2017.
 */

@Entity
@Data
@Table(name = "depot")
public class Depot extends Model {
    private String name;
    private String location;
}
