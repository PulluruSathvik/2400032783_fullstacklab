package com.skill3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.entity.Product;
import com.util.HibernateUtil;

public class PaginationDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query =
                session.createQuery("FROM Product", Product.class);

        // First 3 products
        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Product> list = query.list();
        System.out.println("First 3 products:");
        for (Product p : list) {
            System.out.println(p.getName());
        }

        // Next 3 products
        query.setFirstResult(3);
        query.setMaxResults(3);

        list = query.list();
        System.out.println("Next 3 products:");
        for (Product p : list) {
            System.out.println(p.getName());
        }

        session.close();
    }
}
