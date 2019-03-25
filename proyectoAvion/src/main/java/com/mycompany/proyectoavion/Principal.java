/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoavion;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author CamiloAlvarez
 */
public class Principal {
     Map<Integer,Avion> mapaAvion = new HashMap<>();
     Map<Integer,Silla> mapaSilla = new HashMap<>();
     Map<Integer,Persona> persona = new HashMap<>();
    public Principal() {
    }
   
public void agregarPersona(){
        Scanner scan = new Scanner(System.in);
        int cc;
        String nombre;
        
        try{
    
        System.out.println("Ingrese Cedula: ");
        cc = scan.nextInt();
        System.out.println("Ingrese Nombre: ");
        nombre = scan.next();
        persona.put(cc, new Persona(cc,nombre));
        }catch(InputMismatchException ex){
            System.out.println("Error.. Cedula no valida");
    
        }
        
        System.out.println("---------------------");
        System.out.println("Lista de Usuarios");
        for(Integer key: persona.keySet()){
            Persona mostrar = persona.get(key);
            
            System.out.println("CC: "+mostrar.getCc()+"  Nombre: "+mostrar.getNombre());
        }
       
    }

 public void cargarAvionNormal(int op, int capacidad,double precio){
        
     
        Avion cargarAvionN = new Avion(capacidad, "d");
      
        if(op==1){
        Silla cargarSilla = new Snormal();
        mapaSilla = cargarSilla.cargarSilla(capacidad, precio);
        
        for(Integer key:mapaSilla.keySet()){
            cargarSilla = mapaSilla.get(key);
            cargarAvionN.getMapaSilla().put(cargarSilla.getNumero(), cargarSilla);
        }
          mapaAvion.put(op, cargarAvionN);
    }
 }
 
 public void verAvion(int nAvion){
     for(Integer key:mapaAvion.keySet()){
         
         if(key==nAvion){
         Avion ver = mapaAvion.get(key);
            String verDisponibles = "";
            String verOcupados="";
            String  agrupar ="";
            int i=0;
         for(Integer keysilla: ver.getMapaSilla().keySet()){
            Silla silla = ver.getMapaSilla().get(keysilla);
             
            if(silla.getEstado().equals("d")){
                i++;
                verDisponibles="\033[32m"+silla.getNumero()+"n"+" ";
                agrupar=agrupar+verDisponibles;
            }else{
                i++;
                verOcupados="\033[31m"+silla.getNumero()+"n"+" ";
                agrupar=agrupar+verOcupados;
            }
          if(i==4){
                
                System.out.println("* "+agrupar+"*");
                i=0;
                agrupar="";
          }
          
          
    } 
             
         }
         }
     }
     
 

public String comprar(int idAvion){
  String mensaje = "";
   Scanner scan = new Scanner(System.in);
   for(Integer keya:mapaAvion.keySet()){
       Avion avion= mapaAvion.get(keya);
       if(idAvion==keya && avion.getEstadoA().equals("d")){
           verAvion(keya);
           
           
            
            System.err.println("Ingrese # de silla: ");
            int selec = scan.nextInt();

        for(Integer key :avion.getMapaSilla().keySet()){
         Silla comprar=avion.getMapaSilla().get(key);
         if(key==selec && comprar.getEstado().equals("d")){
             
             comprar.setEstado("o");
             mensaje ="Compra Exitosa";
             
             verAvion(1);
             break;
         }else{
             mensaje ="No existe o Esta ocupada";
             
         }
        
         
     }
           
       }else{
           System.err.println("Avion No Disponible");
       }
   }
   
     return mensaje;
   }
    
      


public void despegar(int idAvion){
    double suma = 0;
    for(Integer key : mapaAvion.keySet()){
        
        if(key==idAvion){
            Avion despegar = mapaAvion.get(key);
            despegar.setEstadoA("o");
            
            for(Integer keySilla: despegar.getMapaSilla().keySet()){
                Silla silla = despegar.getMapaSilla().get(keySilla);
                if(silla.getEstado().equals("o")){
                    suma=suma+silla.getValor();
                }
            }
        }
    }
    System.err.println("Despego con una ganancia de: "+suma);
 
}

public String aterrizar(int idAvion){
    
    String ms="";
 for(Integer key: mapaAvion.keySet()){
     Avion aterrizar = mapaAvion.get(key);
     if(key==idAvion && aterrizar.getEstadoA().equals("o")){
         aterrizar.setEstadoA("d");
         for(Integer keysilla:aterrizar.getMapaSilla().keySet()){
             Silla silla = aterrizar.getMapaSilla().get(keysilla);
             if(silla.getEstado().equals("o")){
                 silla.setEstado("d");
             }
             
            ms="El avion a aterrizado";
         }
         
     }else{
         ms="El Avion No A Despegado";
     }
 }
    return  ms;
}
}

