package com.Adityabhosale;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class SelectStudent1 {

    public static void main(String[] args) {
//          Properties p = new Properties();
//        p.setProperty("hibernate.connection.username", "root");
//        p.setProperty("hibernate.connection.driver_class", "com.postgresql.Driver");
//        p.setProperty("hibernate.connection.url", "");
//        p.setProperty("hibernate.connection.password", "root@123");
//        p.setProperty("hibernate.hbm2ddl.auto", "update");
//        p.setProperty("hibernate.show_sql", "true");
//        p.setProperty("hibernate.format_sql", "true");
//        p.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        Configuration cfg = new Configuration();  //auto configure hibernate.properties
//        cfg.setProperties(p);
//        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);

//        Scanner sc = new Scanner(System.in);
//        float x;

        try(SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession()) {

//            String hql = "from Student s WHERE marks>=:m";
            String hql = "Select name, marks from Student ";
//            Query query = session.createQuery(hql,Student.class);
            Query query = session.createQuery(hql,Object[].class);

//            System.out.println("Enter Marks:");
//            x =  sc.nextFloat();
//            query.setParameter("m", x);

//            List<Student> list = query.getResultList();
              List<Object[]> list = query.getResultList();

            System.out.println("NAME\tMARKS");
            for (Object[] row : list) {
                System.out.println(row[0] + "\t" + row[1]);
            }

        } catch (Exception e) {
            System.err.println("Exception : "+e.getMessage());
        }
    }
}
