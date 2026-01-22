package com.skill3;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Product;
import com.util.HibernateUtil;

public class InsertProducts {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Table", "Furniture", 12000, 5));
        session.save(new Product("Keyboard", "Electronics", 2500, 30));
        session.save(new Product("Monitor", "Electronics", 15000, 8));
        session.save(new Product("Sofa", "Furniture", 45000, 2));
        session.save(new Product("Headphones", "Electronics", 3000, 50));

        tx.commit();
        session.close();

        System.out.println("Additional products inserted successfully!");
    }
}
