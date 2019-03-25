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
public class Sprefencial extends Silla{
    private int tamano;
    
    private Map<Integer,Sprefencial> mapaSilla = new HashMap<>();

    public Sprefencial() {
    }

    public Sprefencial(int tamano, int numero, double valor, String estado) {
        super(numero, valor, estado);
        this.tamano = tamano;
    }

    public  Map<Integer,Sprefencial> cargarSillaP(int cantidad,double precio,int tamano){
       
        for(int i=1;i<=cantidad;i++){
            Sprefencial cargar;
            
            cargar = new Sprefencial(tamano,i,precio,"d");
            
          mapaSilla.put(i, cargar);
        }  
     return mapaSilla;
    }
    
    
    
    
}
