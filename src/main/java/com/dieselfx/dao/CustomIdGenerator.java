package com.dieselfx.dao;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import com.dieselfx.interfaces.Customizable;

import java.io.Serializable;

/**
 * Created by emmanuel on 3/27/17.
 */
public class CustomIdGenerator implements IdentifierGenerator {
    public Serializable generate(SessionImplementor si, Object entity) {

        Class clazz = entity.getClass();

        Customizable myEntity = (Customizable) entity;
        if (myEntity.retrieveId() != null && myEntity.retrieveId() > 0) {
            // the identifier has been set manually => use it
            return myEntity.retrieveId();
        } else {

            // the identifier is not provided => generate it
            return getMyNextKey(clazz);
        }
    }

    public Long getMyNextKey(Class clazz){
        return Accessor.lastId(clazz) + 1;
    }
}
