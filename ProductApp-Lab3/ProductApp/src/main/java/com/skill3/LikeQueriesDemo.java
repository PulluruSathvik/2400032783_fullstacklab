package com.skill3;

import java.util.List;

import org.hibernate.Session;

import com.entity.Product;
import com.util.HibernateUtil;

public class LikeQueriesDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list =
                session.createQuery(
                        "FROM Product WHERE name LIKE '%phone%'",
                        Product.class)
                       .list();

        for (Product p : list) {
            System.out.println(p.getName());
        }

        session.close();
    }
}
