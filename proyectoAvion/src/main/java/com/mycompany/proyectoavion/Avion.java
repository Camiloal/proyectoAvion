/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoavion;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CamiloAlvarez
 */
public class Avion {
    private int capasidad;
    private String estadoA;
    private Map<Integer,Silla> mapaSilla = new HashMap<>();

    public Avion() {
    }

   
    public Avion(int capasidad, String estadoA) {
        this.capasidad = capasidad;
        this.estadoA = estadoA;
    }
    
    
    public int getCapasidad() {
        return capasidad;
    }

    public void setCapasidad(int capasidad) {
        this.capasidad = capasidad;
    }

    public String getEstadoA() {
        return estadoA;
    }

    public void setEstadoA(String estadoA) {
        this.estadoA = estadoA;
    }

    public Map<Integer, Silla> getMapaSilla() {
        return mapaSilla;
    }

    public void setMapaSilla(Map<Integer, Silla> mapaSilla) {
        this.mapaSilla = mapaSilla;
    }
    
    
}
