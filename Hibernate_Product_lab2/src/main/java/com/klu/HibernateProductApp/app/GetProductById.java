package com.klu.HibernateProductApp.app;

import org.hibernate.Session;
import com.klu.HibernateProductApp.entity.Product;
import com.klu.HibernateProductApp.util.HibernateUtil;

public class GetProductById {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Product product = session.get(Product.class, 1); // change ID if needed

        if (product != null) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found");
        }

        session.close();
    }
}
