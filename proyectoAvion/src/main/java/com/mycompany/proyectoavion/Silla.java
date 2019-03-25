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
public class  Silla {
    private int numero;
    private double valor;
    private String estado;
    
    private Map<Integer,Silla> mapaSilla = new HashMap<>();

    public Silla() {
    }

    public Silla(int numero, double valor, String estado) {
        this.numero = numero;
        this.valor = valor;
        this.estado = estado;
    }

   
    public  Map<Integer,Silla> cargarSilla(int cantidad,double precio){
       
        for(int i=1;i<=cantidad;i++){
            Silla cargar;
            
            cargar = new Silla(i,precio,"d");
            
          mapaSilla.put(i, cargar);
        }  
     return mapaSilla;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Map<Integer, Silla> getMapaSilla() {
        return mapaSilla;
    }

    public void setMapaSilla(Map<Integer, Silla> mapaSilla) {
        this.mapaSilla = mapaSilla;
    }
    
    
}
