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
     Map<Integer,Snormal> mapaSillaN = new HashMap<>();
     Map<Integer,Sprefencial> mapaSillaP = new HashMap<>();
     
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
      
        Snormal cargarSilla = new Snormal();
        mapaSillaN = cargarSilla.cargarSilla(capacidad, precio);
        
        for(Integer key:mapaSillaN.keySet()){
            cargarSilla = mapaSillaN.get(key);
            cargarAvionN.getMapaSilla().put(cargarSilla.getNumero(), cargarSilla);
        }
          mapaAvion.put(op, cargarAvionN);
 }
 
 public void cargarAvionPrefrencial(int op, int capacidad,double precio,int tamano){

        Avion cargarAvionN = new Avion(capacidad, "d");

       Sprefencial cargarSilla = new Sprefencial();
       mapaSillaP = cargarSilla.cargarSillaP(capacidad, precio, tamano);
        
        for(Integer key:mapaSillaP.keySet()){
            cargarSilla = mapaSillaP.get(key);
            cargarAvionN.getMapaSilla().put(cargarSilla.getNumero(), cargarSilla);
            
        }
          mapaAvion.put(op, cargarAvionN);
          
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
      
             if(silla instanceof Snormal){
                 
             
            if(silla.getEstado().equals("d")){
                i++;
                verDisponibles="\033[32m"+((Snormal)silla).getNumero()+"n"+" ";
                agrupar=agrupar+verDisponibles;
            }else{
                i++;
                verOcupados="\033[31m"+((Snormal)silla).getNumero()+"n"+" ";
                agrupar=agrupar+verOcupados;
            }
          if(i==4){
                
                System.out.println("* "+agrupar+"*");
                i=0;
                agrupar="";
          }
          
             }
              
             if(silla instanceof Sprefencial){
                     
                     if(silla.getEstado().equals("d")){
                i++;
                verDisponibles="\033[32m"+((Sprefencial)silla).getNumero()+"p"+" ";
                agrupar=agrupar+verDisponibles;
            }else{
                i++;
                verOcupados="\033[31m"+((Sprefencial)silla).getNumero()+"p"+" ";
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
         }
     
     
 

public String comprar(int idAvion){
    
    
    
  String mensaje = "";
   Scanner scan = new Scanner(System.in);
   int cc=0;
   try{
   System.out.println("Ingrese cedula: ");
    cc=scan.nextInt();
   }catch(ArithmeticException ex){
       System.err.println("Error.. No es un numero");
   }
    
        for(Integer keyp: persona.keySet()){
            Persona mostrar = persona.get(keyp);
            if(cc==mostrar.getCc()){
                
      
   for(Integer keya:mapaAvion.keySet()){
       Avion avion= mapaAvion.get(keya);
       if(idAvion==keya && avion.getEstadoA().equals("d")){
           verAvion(idAvion);
           int selec = 0;
           
           try{ 
            System.err.println("Ingrese # de silla: ");
            selec = scan.nextInt();
           }catch(Exception ex){
               System.err.println("Error.. No es un numero");
               
           }
        for(Integer key :avion.getMapaSilla().keySet()){
         Silla comprar=avion.getMapaSilla().get(key);
         if(key==selec && comprar.getEstado().equals("d")){
             
             comprar.setEstado("o");
             mensaje ="Compra Exitosa";
             
             verAvion(idAvion);
             break;
         }else{
             mensaje ="No existe o Esta ocupada";
             
         }
        
         
     }
           
       }else{
           mensaje="Avion no disponible";
       }
   }
         }else{
                mensaje="Usuario No Registrado.";
                }
           
        }
   
     return mensaje;
   }
    
      


public String despegar(int idAvion){
    double suma = 0;
    String ms="";
    for(Integer key : mapaAvion.keySet()){
        Avion despegar = mapaAvion.get(key);
        if(key==idAvion){ 
        if(despegar.getEstadoA().equals("o")){
            ms="El avion ya Despego";
            break;
        }else{
        
            
            despegar.setEstadoA("o");
            
            for(Integer keySilla: despegar.getMapaSilla().keySet()){
                Silla silla = despegar.getMapaSilla().get(keySilla);
                if(silla.getEstado().equals("o")){
                    suma=suma+silla.getValor();
                }
            }
        }
         ms="Despego con una ganancia de: "+suma;
           
    }
        
    }
    return ms;
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

