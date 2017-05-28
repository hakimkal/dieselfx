package com.dieselfx.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by ozo on 28/05/2017.
 */
@Data
@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private Geometry geometry;
    @Column(insertable = false, updatable = false)
    private String type;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
    private List<Property> properties;
}
