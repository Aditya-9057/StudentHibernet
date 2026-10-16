package com.Adityabhosale;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudent1 {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();  //auto configure hibernate.properties

        cfg.addAnnotatedClass(Student.class);


        Transaction tx = null;
        try(SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession()) {

           tx = session.beginTransaction();

           String hql = "DELETE FROM Student WHERE marks < 100";
           Query query = session.createQuery(hql);
           int ans =  query.executeUpdate();
           if(ans > 0) {

               tx.commit();
               System.out.println("Record Deleted Successfully");
           } else {
               System.out.println("Record Not Deleted Successfully");
           }


        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Exception : "+e.getMessage());
        }
    }
}
