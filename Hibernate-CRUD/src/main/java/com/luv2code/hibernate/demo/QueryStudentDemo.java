package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);
            System.out.println("**************************************************");
            System.out.println(theStudents.get(0).getId());
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        System.out.println("*****************************************************");
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
        System.out.println("*****************************************************");
    }

}





