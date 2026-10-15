package com.Adityabhosale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;

public class InsertStudent {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = cfg.buildSessionFactory();

            session = sessionFactory.openSession();

            try {

                tx = session.beginTransaction();

                Student student = new Student(77, "rock", 62);
                session.persist(student);
                tx.commit();
                System.out.println("Student has been saved successfully");
            }catch(ConstraintViolationException cve){
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Student already Exist"+cve.getMessage());
                tx.rollback();
            }catch(HibernateException he) {
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Transaction Failed"+he.getMessage());
            }catch(Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Exception Happened"+e.getMessage());
            }

        }catch(JDBCConnectionException jce){

            System.out.println("Connection Error "+jce.getMessage());


        }catch(HibernateException e){
            System.err.println("Hibernate Related Error"+e.getMessage());
        }catch(Exception e){
            System.err.println("Unexpected Error"+e.getMessage());

        }finally{
            if(session!=null){

                try {
                    session.close();

                }catch (HibernateException he){
                    System.err.println("Exception Happened"+he.getMessage());
                }
            if(sessionFactory!=null){

                try {
                    sessionFactory.close();

                }catch (HibernateException he){
                    System.err.println("Exception Happened"+he.getMessage());
                }
            }

            }
        }
    }
}
