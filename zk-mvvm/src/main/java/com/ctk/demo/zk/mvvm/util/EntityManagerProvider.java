package com.ctk.demo.zk.mvvm.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerFactory entityManagerFactory;

//    static {
//        try {
//            entityManagerFactory = Persistence.createEntityManagerFactory("sakilaDS");
//        }
//        catch(Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
 
    public static void shutdown() {
        getEntityManagerFactory().close();
    }

}
