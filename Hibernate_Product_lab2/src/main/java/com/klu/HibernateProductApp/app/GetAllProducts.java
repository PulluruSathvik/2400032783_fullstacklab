package com.klu.HibernateProductApp.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.klu.HibernateProductApp.entity.Product;
import com.klu.HibernateProductApp.util.HibernateUtil;

public class GetAllProducts {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> products = query.list();

        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            for (Product p : products) {
                System.out.println(
                        p.getId() + " | " +
                        p.getName() + " | " +
                        p.getPrice() + " | " +
                        p.getQuantity()
                );
            }
        }

        session.close();
    }
}
