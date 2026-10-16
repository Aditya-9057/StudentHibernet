package com.Adityabhosale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class SelectStudent
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
       // config.configure("hibernate.cfg.xml");

       config.addAnnotatedClass(Student.class);

      SessionFactory factory = config.buildSessionFactory();


       Session session = factory.openSession();

       // Eager fetching
          Student st = session.find(Student.class,101); //get()

        //Eager fetching
//          Student st = session.byId(Student.class).load(101);

        //Lazy fetching
      //  Student st = session.byId(Student.class).getReference(102);

            if(st!=null){
//                System.out.println("Name : "+st.getName());
//                System.out.println("RollNo :"+st.getRoll());
//                System.out.println("Marks :"+st.getMarks());
                  System.out.println(st);

            }else
                System.out.println("Student not found");

       session.close();
       factory.close();
    }
}
