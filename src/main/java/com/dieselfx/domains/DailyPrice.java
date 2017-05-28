package com.dieselfx.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by macbook on 5/27/17.
 */

@Entity
@Data
@Table(name = "dailyprices")
public class DailyPrice extends Model {

    private InfoSource infoSource;
    private  float price;
    private float quality;
    private Date date;

}
