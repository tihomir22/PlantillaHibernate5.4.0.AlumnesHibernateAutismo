/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sportak
 */
public class Conexion {

    public static Session sesion = null;
    public static SessionFactory factory = null;

    public static void conectarse() {
        if (factory == null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        if (sesion == null) {
            sesion = factory.openSession();
        }
    }

    public static void iniciarTransaccion() {
        if (!sesion.isOpen()) {
            sesion = factory.openSession();
        }
        sesion.beginTransaction();
    }

    public static void guardarTransaccion() {
        sesion.getTransaction().commit();
    }

    public static void cerrarSesion() {
        if (sesion.isOpen()) {
            sesion.close();
            factory.close();
        }
    }

}
