package com.Adityabhosale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");


        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

//        Student st = session.find(Student.class, 101);
//        if (st!=null){
//            st.setMarks(60);
//            st.setName("aaa");
//
//            session.merge(st); //update()
//
//            tx.commit(); //query execution
//            System.out.println("Student Updated Successfully");
//        }else {
//            System.out.println("Student not found");
//        }

        Student student = new Student(115,"abcd",99);

        session.merge(student); //if record not found then insert otherwise update

        tx.commit();

        session.close();
        factory.close();
    }
}
