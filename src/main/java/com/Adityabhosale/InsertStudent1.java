package com.Adityabhosale;



import jakarta.transaction.TransactionalException;
import jdk.internal.org.jline.utils.DiffHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;

public class InsertStudent1 {

    public static void main(String[] args) {

//        OPERATION                    HIBERNATE 7 / JAKARTA       OLDER HIBERNATE
//
//        Insert                       persist()                  save()
//        Read                         find()                     get() / load()
//        Update                       Modify managed entity      update() / saveOrUpdate()
//        Delete                       remove()                   delete()
//        Begin transaction            beginTransaction()         beginTransaction()
//        Commit transaction           commit()                   commit()






        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");


        Transaction tx = null;
        try(SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession()) {


            try {

                tx = session.beginTransaction();

                Student student = new Student(77, "rock", 62);
                session.persist(student); //save()
                tx.commit();
                System.out.println("Student has been saved successfully");
            }catch(ConstraintViolationException cve){
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Student already Exist"+cve.getMessage());
                tx.rollback();
            }catch(TransactionalException te){
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Transaction Failed"+te.getMessage());

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

        }

        }
    }


