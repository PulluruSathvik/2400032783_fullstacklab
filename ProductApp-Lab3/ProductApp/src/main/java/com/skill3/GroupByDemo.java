package com.skill3;

import java.util.List;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class GroupByDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Object[]> list =
                session.createQuery(
                        "SELECT description, COUNT(*) FROM Product GROUP BY description",
                        Object[].class)
                       .list();

        for (Object[] row : list) {
            System.out.println(row[0] + " : " + row[1]);
        }

        session.close();
    }
}
