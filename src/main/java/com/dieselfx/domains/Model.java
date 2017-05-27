package com.dieselfx.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;


@Getter
@Setter
@MappedSuperclass
public class Model implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date created_at = new Date();

    private Date updated_at = new Date();




    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;



    @PrePersist
    void createdAt() {
        this.created_at = this.updated_at = new Date();


    }

    @PreUpdate
    void updatedAt() {
        this.updated_at = new Date();

    }


}




