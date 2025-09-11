package com.ricardo.practica2.other.examples;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection loadProductsByName(String name) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("select * from products where name=?")
                .setParameter(0, name)
                .list();
    }
}
