package com.Adityabhosale;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent1 {
    public static void main(String[] args) {


        Configuration cfg = new Configuration();  //auto configure hibernate.properties

        cfg.addAnnotatedClass(Student.class);


        Transaction tx = null;
        try(SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession()) {

            tx = session.beginTransaction();

            String hql = "Update Student set marks = 77 where roll = 101";
            Query query = session.createQuery(hql);

            int ans =  query.executeUpdate();
            if(ans > 0) {

                tx.commit();
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("Record Not Updated Successfully");
            }


        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Exception : "+e.getMessage());
        }
    }
}
