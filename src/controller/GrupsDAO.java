/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.Conexion;
import java.util.ArrayList;
import java.util.List;
import model.Alumnes;
import model.Grups;
import org.hibernate.Query;

/**
 *
 * @author sportak
 */
public class GrupsDAO {

    public static ArrayList devolverListaGrupos() {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Query query = Conexion.sesion.createSQLQuery("SELECT * FROM grups");
        List<Grups[]> listaGrupos = query.list();
        Conexion.guardarTransaccion();
        return (ArrayList) listaGrupos;
    }

    public static Grups getByID(String codigo) {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Grups grup = Conexion.sesion.get(Grups.class, codigo);

        Conexion.guardarTransaccion();
        return grup;
    }

    public static void insertarGrupo(Grups g) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.saveOrUpdate(g);
        Conexion.guardarTransaccion();
    }

    public static void eliminar(Grups g) {
        Conexion.iniciarTransaccion();
        Conexion.sesion.delete(g);
        Conexion.guardarTransaccion();
    }

    public static void actualizar(Grups grp) {
        Conexion.conectarse();
        Conexion.iniciarTransaccion();
        Conexion.sesion.update(grp);
        Conexion.guardarTransaccion();
    }
}
