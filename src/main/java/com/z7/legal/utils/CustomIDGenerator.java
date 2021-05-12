package com.z7.legal.utils;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * @Classname CustomIDGenerator
 * @Description TODO
 * @Date 2021/5/12 11:55 上午
 * @Author z7-x
 */
public class CustomIDGenerator extends UUIDGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
        Object id = new ObjectId().toHexString();
        if (id != null) {
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}
