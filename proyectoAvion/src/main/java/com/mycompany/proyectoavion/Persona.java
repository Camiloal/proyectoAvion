/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoavion;

/**
 *
 * @author CamiloAlvarez
 */
public class Persona {
    private int cc;
    private String nombre;

    public Persona(int cc, String nombre) {
        this.cc = cc;
        this.nombre = nombre;
    }

   

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    
}
