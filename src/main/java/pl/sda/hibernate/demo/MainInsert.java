package pl.sda.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession();) {

       Transaction transaction =  session.beginTransaction();
       Student student= new Student();
       student.setImie("Paweł");
       student.setKierunekNauczania("informatyka");
       student.setDataUrodzenia(LocalDate.of(1990,1,3));
       student.setIndeks("12345");
       Student student =Student.builder()
               .dataUrodzenia(LocalDate.of(1990,1,3))
               .kierunekNauczania("informatyka")
               .indeks("1234")
               .imie("Gaweł")
               .build();
       session.persist(student);
       transaction.commit();

        }catch (Exception ioe){

        }
    }
}
