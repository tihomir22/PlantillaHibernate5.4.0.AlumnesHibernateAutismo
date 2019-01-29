/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mati
 */
public class Aula {

    private String codi;
    private String nombrecompleto;

    public Aula(String codi, String nombrecompleto) {
        this.codi = codi;
        this.nombrecompleto = nombrecompleto;
    }

    public Aula() {
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }
    

}
