/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import model.enumerado.Nivel;

/**
 *
 * @author sportak
 */
public class Grups implements Serializable {

    private String codi;
    private Nivel nivell;
    private Alumnes alum;
    private Set listaAlum = new HashSet(0);
    private Aula aula;

    public Grups(String codi, Nivel nivell, Alumnes alum) {
        this.codi = codi;
        this.nivell = nivell;
        this.alum = alum;
    }

    public Grups() {
    }

    public String getCodi() {
        return codi;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Nivel getNivell() {
        return nivell;
    }

    public void setNivell(Nivel nivell) {
        this.nivell = nivell;
    }

    public Alumnes getAlum() {
        return alum;
    }

    public void setAlum(Alumnes alum) {
        this.alum = alum;
    }

    public Set getListaAlum() {
        return listaAlum;
    }

    public void setListaAlum(Set listaAlum) {
        this.listaAlum = listaAlum;
    }

    @Override
    public String toString() {
        return "Grups{" + "codi=" + codi + ", nivell=" + nivell + ", alum=" + alum + ", listaAlum=" + listaAlum + '}';
    }

}
