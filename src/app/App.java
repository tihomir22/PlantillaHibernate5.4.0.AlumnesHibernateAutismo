/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.AlumnesDAO;
import controller.GrupsDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import model.Alumnes;
import model.Grups;
import model.componentes.NIF;
import model.enumerado.Nivel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Maite
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Conexion.conectarse();
        int opcion = 999, seleccionInt;
        String seleccion = "";
        Scanner teclado = new Scanner(System.in);
        ArrayList<Alumnes[]> listaAlumnos = null;
        ArrayList<Grups[]> listaGrupos = null;
        Grups grp = null;

        Alumnes alum = new Alumnes("MechetoTopcho", "Stoychev", 1, Calendar.getInstance().getTime(), 0, null);
        NIF nif = new NIF("X5514136R");
        alum.setNif(nif);

        Grups grupoNuevo = new Grups("DAM", Nivel.CF, alum);
        Set<Alumnes> listaAlumnosN = new HashSet<>();
        listaAlumnosN.add(alum);
        grupoNuevo.setListaAlum(listaAlumnosN);
        System.out.println("");
        System.out.println("Que consultas quieres hacer ? [1]Basicas o [2] de Maite?");
        if (teclado.nextInt() == 1) {
            while (opcion != 0) {
                mostrarMenu();
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        AlumnesDAO.insertar(alum);
                        break;

                    case 2:
                        AlumnesDAO.eliminar(alum);
                        break;

                    case 3:
                        System.out.println("Elige el grupo , introduce sus siglas ");
                        listaGrupos = GrupsDAO.devolverListaGrupos();
                        for (Object[] datos : listaGrupos) {
                            System.out.println("[" + datos[0] + "]  " + datos[1] + " " + datos[2]);
                        }
                        teclado.nextLine();
                        seleccion = teclado.nextLine();
                        grp = GrupsDAO.getByID(seleccion);

                        if (grp != null) {
                            System.out.println("Seleccionado " + grp.toString());
                            System.out.println("A que alumno le deseas añadir el grupo?");
                            listaAlumnos = AlumnesDAO.devolverListaAlumnos();
                            for (Object[] datos : listaAlumnos) {
                                System.out.println("[" + datos[0] + "] " + datos[1] + " " + datos[2] + " " + datos[3]);
                            }
                            seleccionInt = teclado.nextInt();
                            Alumnes alumRec = AlumnesDAO.getByID(seleccionInt);
                            if (alumRec != null) {
                                System.out.println("Recuperado alumno " + alumRec.getNom());
                                alumRec.setGrup(grp);
                                AlumnesDAO.actualizar(alumRec);
                            } else {
                                System.out.println("No se ha encontrado el alumno");
                            }
                        } else {
                            System.out.println("No se ha encontrado el grupo");
                        }

                        break;

                    case 4:
                        GrupsDAO.insertarGrupo(grupoNuevo);
                        break;
                    case 5:
                        GrupsDAO.eliminar(grupoNuevo);
                        break;

                    case 6:
                        System.out.println("Elige el grupo , introduce sus siglas ");
                        listaGrupos = GrupsDAO.devolverListaGrupos();
                        for (Object[] datos : listaGrupos) {
                            System.out.println("[" + datos[0] + "]  " + datos[1] + " " + datos[2]);
                        }
                        teclado.nextLine();
                        seleccion = teclado.nextLine();
                        grp = GrupsDAO.getByID(seleccion);

                        if (grp != null) {
                            System.out.println("Seleccionado " + grp.toString());
                            System.out.println("Que alumno quieres que sea el delegado?");
                            listaAlumnos = AlumnesDAO.devolverListaAlumnos();
                            for (Object[] datos : listaAlumnos) {
                                System.out.println("[" + datos[0] + "] " + datos[1] + " " + datos[2] + " " + datos[3]);
                            }
                            seleccionInt = teclado.nextInt();
                            Alumnes alumRec = AlumnesDAO.getByID(seleccionInt);
                            if (alumRec != null) {
                                System.out.println("Recuperado alumno " + alumRec.getNom());
                                grp.setAlum(alumRec);
                                GrupsDAO.actualizar(grp);
                                // AlumnesDAO.actualizar(alumRec);
                            } else {
                                System.out.println("No se ha encontrado el alumno");
                            }
                        } else {
                            System.out.println("No se ha encontrado el grupo");
                        }
                        break;
                }
            }
        } else {
            while (opcion != 0) {
                mostrarMenuMaite();
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        AlumnesDAO.mayoresDeEdadHombres();
                        break;
                    case 2:
                        AlumnesDAO.suspendidoMismaLetraF();
                        break;
                    case 3:
                        AlumnesDAO.seleccionarDelegados();
                        break;
                    case 4:
                        AlumnesDAO.suspensosMediaMayor();
                        break;
                    case 5:
                        AlumnesDAO.suspensosMasDeDos();
                        break;

                    case 6:
                        AlumnesDAO.alumnosMatriculadosEnGrupo();
                        break;
                }
            }
        }

        Conexion.cerrarSesion();

    }

    public static void mostrarMenu() {
        System.out.println("Relacionados con alumno");
        System.out.println(" \t 1.- Añadir el alumno");
        System.out.println(" \t 2.- Eliminar el usuario creado anteriormente");
        System.out.println(" \t 3.- Modificar, añadir un usuario a un grupo");
        System.out.println("Relacionados con grupos");
        System.out.println(" \t 4.- Añadir el grupo");
        System.out.println(" \t 5.- Eliminar el grupo creado anteriormente");
        System.out.println(" \t 6.- Modificar el delegado");
        System.out.println("0.-Salir");
    }

    public static void mostrarMenuMaite() {
        System.out.println("\t 1.-Seleccionar el nombre de los alumnos que son hombre y mayores de 18 años");
        System.out.println("\t 2.-Selecciona el nombre de los alumnos que han suspendido las mismas asignaturas que\n"
                + "aquellos cuyo apellido empieza por F");
        System.out.println("\t 3.-Mostrar alumnos delegados");
        System.out.println("\t 4.- Mostrar alumnos que han suspendido más que la media ");
        System.out.println("\t 5.- Mostrar alumnos que han suspendido mas de dos");
        System.out.println("\t 6.- Mostrar alumnos matriculados en grupo");
    }

}
