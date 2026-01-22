package com.klu.HibernateProductApp.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.HibernateProductApp.entity.Product;
import com.klu.HibernateProductApp.util.HibernateUtil;

public class InsertProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "HP", 60000, 5);
        Product p2 = new Product("Mobile", "Samsung", 30000, 10);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        System.out.println("Inserted Successfully");
    }
}
