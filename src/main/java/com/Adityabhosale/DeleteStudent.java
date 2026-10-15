package com.Adityabhosale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

      Session session = factory.openSession();


      Transaction tx = session.beginTransaction();

      Student st = session.find(Student.class,99);
      if(st!=null){
          session.remove(st); //delete query execute
          System.out.println("Student deleted successfully");
      }else {
          System.out.println("Student not found");
      }

      tx.commit();


      session.close();

        factory.close();
    }
}
