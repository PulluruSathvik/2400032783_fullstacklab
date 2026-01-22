package com.skill3;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class AggregateDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // 1️⃣ Count total products
        Long total =
                session.createQuery(
                        "SELECT COUNT(p) FROM Product p",
                        Long.class)
                       .uniqueResult();

        // 2️⃣ Count products where quantity > 0
        Long available =
                session.createQuery(
                        "SELECT COUNT(p) FROM Product p WHERE quantity > 0",
                        Long.class)
                       .uniqueResult();

        // 3️⃣ Min and Max price
        Object[] minMax =
                session.createQuery(
                        "SELECT MIN(price), MAX(price) FROM Product",
                        Object[].class)
                       .uniqueResult();

        System.out.println("Total products: " + total);
        System.out.println("Available products: " + available);
        System.out.println("Min price: " + minMax[0]);
        System.out.println("Max price: " + minMax[1]);

        session.close();
    }
}
