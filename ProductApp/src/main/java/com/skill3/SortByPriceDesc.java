package com.skill3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.entity.Product;
import com.util.HibernateUtil;

public class SortByPriceDesc {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query =
                session.createQuery("FROM Product ORDER BY price DESC", Product.class);

        List<Product> list = query.list();

        for (Product p : list) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        session.close();
    }
}
