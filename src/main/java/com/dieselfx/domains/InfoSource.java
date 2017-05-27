package com.dieselfx.domains;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by macbook on 5/27/17.
 */

@Data
@Entity
@Table(name = "infosources")
public class InfoSource {
}
