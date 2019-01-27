/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.Conexion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Alumnes;
import model.Grups;
import org.hibernate.Query;

/**
 *
 * @author sportak
 */
public class AlumnesDAO {

    public static void insertar(Alumnes alum) {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Conexion.sesion.save(alum);
        Conexion.guardarTransaccion();
    }

    public static void eliminar(Alumnes alum) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.delete(alum);
        Conexion.guardarTransaccion();
    }

    public static Alumnes getByID(int nexp) {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Alumnes alum = Conexion.sesion.get(Alumnes.class, nexp);
        Conexion.guardarTransaccion();
        return alum;
    }

    public static ArrayList devolverListaAlumnos() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT * FROM alumnes");
        List<Alumnes[]> listaAlumnes = query.list();
        Conexion.guardarTransaccion();
        return (ArrayList) listaAlumnes;
    }

    public static void actualizar(Alumnes alum) {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Conexion.sesion.update(alum);
        Conexion.guardarTransaccion();
    }

    //"\t 1.-Seleccionar el nombre de los alumnos que son hombre y mayores de 18 años");
    public static void mayoresDeEdadHombres() throws ParseException {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createQuery("SELECT a.nom,a.datanaix FROM Alumnes a  WHERE sexe=:sexe");
        query.setParameter("sexe", 1);
        List<Alumnes[]> listaAlumnes = query.list();

        for (Object[] datos : listaAlumnes) {
            Date d0 = new Date();
            Date d1 = new SimpleDateFormat("yyyy-M-dd").parse(datos[1].toString());
            long diff = d0.getTime() - d1.getTime();
            diff = diff / (1000 * 60 * 60 * 24);
            //calculo la diferencia en dias , para saber si teine más de 18 años debe tener más de 6480 dias de vida

            if (diff > 6480) {
                System.out.println("[" + datos[0] + "] " + datos[1]);
            }
        }

        Conexion.guardarTransaccion();
    }

    public static void suspendidoMismaLetraF() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT nom FROM alumnes WHERE susp=(SELECT susp FROM alumnes WHERE nom LIKE 'F%')");
        List<String> listaAlumnes = query.list();
        for (String datos : listaAlumnes) {
            System.out.println(datos);
        }
        Conexion.guardarTransaccion();
    }

    public static void seleccionarDelegados() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT nexp , nom FROM alumnes,grups WHERE alumnes.grup = grups.codi");
        List<Object[]> listaAlumnes = query.list();
        for (Object[] datos : listaAlumnes) {
            System.out.println(datos[0] + " " + datos[1]);
        }
        Conexion.guardarTransaccion();
    }

    public static void suspensosMediaMayor() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT nexp , nom FROM alumnes WHERE susp>(SELECT AVG(susp) FROM alumnes)");
        List<Object[]> listaAlumnes = query.list();
        for (Object[] datos : listaAlumnes) {
            System.out.println(datos[0] + " " + datos[1]);
        }
        Conexion.guardarTransaccion();
    }

    public static void suspensosMasDeDos() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT nom FROM alumnes WHERE susp>2");
        List<String> listaAlumnes = query.list();
        for (String datos : listaAlumnes) {
            System.out.println(datos);
        }
        Conexion.guardarTransaccion();
    }
    
    public static void alumnosMatriculadosEnGrupo() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT COUNT(*) ,codi FROM grups,alumnes WHERE grups.codi=alumnes.grup GROUP BY codi");
        List<Object[]> listaAlumnes = query.list();
        for (Object[] datos : listaAlumnes) {
            System.out.println(datos[0] + " " + datos[1]);
        }
        Conexion.guardarTransaccion();
    }

}
