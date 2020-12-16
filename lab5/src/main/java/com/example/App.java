package com.example;

import com.example.util.HibernateUtil;
import com.example.view.View;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        try (Session SESSION = HibernateUtil.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}
