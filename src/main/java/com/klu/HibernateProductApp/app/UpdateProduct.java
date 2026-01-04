package com.klu.HibernateProductApp.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.HibernateProductApp.entity.Product;
import com.klu.HibernateProductApp.util.HibernateUtil;

public class UpdateProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, 1); // existing ID

        if (product != null) {
            product.setPrice(75000);
            product.setQuantity(20);

            session.update(product);
            System.out.println("Product Updated Successfully");
        } else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }
}
