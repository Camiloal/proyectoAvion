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
public class Snormal extends Silla{

    private Map<Integer,Snormal> mapaSilla = new HashMap<>();
    public Snormal() {
    }

    public Snormal(int numero, double valor, String estado) {
        super(numero, valor, estado);
    }
    
      
    public  Map<Integer,Snormal> cargarSilla(int cantidad,double precio){
       
        for(int i=1;i<=cantidad;i++){
            Snormal cargar;
            
            cargar = new Snormal(i,precio,"d");
            
          mapaSilla.put(i, cargar);
        }  
     return mapaSilla;
    }
}
