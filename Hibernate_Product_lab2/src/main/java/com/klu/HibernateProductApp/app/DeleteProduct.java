package com.klu.HibernateProductApp.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.HibernateProductApp.entity.Product;
import com.klu.HibernateProductApp.util.HibernateUtil;

public class DeleteProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, 2); // ID to delete

        if (product != null) {
            session.delete(product);
            System.out.println("Product Deleted Successfully");
        } else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }
}
