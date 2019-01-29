/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import model.componentes.NIF;

/**
 *
 * @author sportak
 */
public class Alumnes implements Serializable {

    private int nexp;
    private NIF nif;
    private String nom;
    private String telefon;
    private int sexe;
    private Date datanaix;
    private int susp;
    private Grups grup;
    private Set listaGrupos = new HashSet(0);
    

    public Alumnes(String nom, String telefon, int sexe, Date datanaix, int susp, Grups grup) {
        this.nom = nom;
        this.telefon = telefon;
        this.sexe = sexe;
        this.datanaix = datanaix;
        this.susp = susp;
        this.grup = grup;
    }

    public Alumnes() {
    }

    public Set getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(Set listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public NIF getNif() {
        return nif;
    }

    public void setNif(NIF nif) {
        this.nif = nif;
    }

    public int getNexp() {
        return nexp;
    }

    public void setNexp(int nexp) {
        this.nexp = nexp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public Date getDatanaix() {
        return datanaix;
    }

    public void setDatanaix(Date datanaix) {
        this.datanaix = datanaix;
    }

    public int getSusp() {
        return susp;
    }

    public void setSusp(int susp) {
        this.susp = susp;
    }

    public Grups getGrup() {
        return grup;
    }

    public void setGrup(Grups grup) {
        this.grup = grup;
    }

    @Override
    public String toString() {
        return "Alumnes{" + "nexp=" + nexp + ", nif=" + nif + ", nom=" + nom + ", telefon=" + telefon + ", sexe=" + sexe + ", datanaix=" + datanaix + ", susp=" + susp + ", grup=" + grup + ", listaGrupos=" + listaGrupos + '}';
    }

}
