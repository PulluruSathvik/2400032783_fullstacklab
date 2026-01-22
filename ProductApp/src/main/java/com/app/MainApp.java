package com.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Product;
import com.util.HibernateUtil;

public class MainApp {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        // ================= INSERT =================
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 75000, 10));
        session.save(new Product("Mobile", "Electronics", 30000, 15));
        session.save(new Product("Chair", "Furniture", 5000, 20));
        
        tx.commit();
        System.out.println("Products inserted successfully!");

        // ================= UPDATE =================
        Transaction tx1 = session.beginTransaction();

        Product p = session.get(Product.class, 2L);
        if (p != null) {
            p.setPrice(28000);
            p.setQuantity(12);
        }

        tx1.commit();
        System.out.println("Product updated successfully!");

        // ================= DELETE =================
        Transaction tx2 = session.beginTransaction();

        Product p1 = session.get(Product.class, 3L);
        if (p1 != null) {
            session.delete(p1);
        }

        tx2.commit();
        System.out.println("Product deleted successfully!");

        // ================= RETRIEVE =================
        Product p2 = session.get(Product.class, 1L);

        if (p2 != null) {
            System.out.println("Retrieved Product Name: " + p2.getName());
        } else {
            System.out.println("Product not found");
        }

              session.close();
    }
}
