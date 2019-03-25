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
public class Menu {
    Principal agregar = new Principal();
    int opcion;
    public Menu() {
        
    }
    
    
    public void menuInicial(){
          
        do {
        Scanner scan = new Scanner(System.in);
              
        System.out.println("...Biembenido...");
        System.out.println("------------------- ");
        System.out.println("1.Agregar Persona.");
        System.out.println("2.Avion Normal.");
        System.out.println("3.Avion Prefenrencial.");
        System.out.println("4.Avion Normar y Preferencial");
        System.out.println("5.Salir");
        System.out.println("ingrese opcion: ");
        try{ 
        opcion = scan.nextInt();
       
         switch (opcion) {
             case 1:
                 
                 agregar.agregarPersona();
                 break;
                 
             case 2:
                
                do{
                    opcion=menuAvion();
                    
                    switch(opcion){
                        case 1:
                            
                            System.out.println("Avion Normal..Cargar");
                            System.out.println("--------------------------------------");
                                 System.err.println("CAPACIDAD: Ingrese # de sillas: ");
                                 int nSillas = scan.nextInt();
                                 System.err.println("Precio Sillas: ");
                                 double precio = scan.nextInt();
                                 agregar.cargarAvionNormal(1, nSillas, precio);
                                 System.err.println("Avion Cargado Exitosamente");
                                 break;
                                
                        case 2:
                            String ms= agregar.comprar(1);
                            System.out.println("-->"+ms);
                            break;
                        case 3:
                            
                          String msd=  agregar.despegar(1);
                          System.out.println("-->"+msd);
                            break;
                        case 4:
                         String msa= agregar.aterrizar(1);
                         System.out.println("-->"+msa);
                         break;
                         
                        case 5:
                            menuInicial();
                   }
                    
                    
                }while(opcion!=5);
                
             case 3: 
                  
                do{
                    opcion=menuAvion();
                    
                    switch(opcion){
                        case 1:
                            
                            System.out.println("Avion Preferencial..Cargar");
                            System.out.println("--------------------------------------");
                                 System.err.println("CAPACIDAD: Ingrese # de sillas preferenciales: ");
                                 int nSillas = scan.nextInt();
                                 System.err.println("Precio Sillas: ");
                                 double precio = scan.nextInt();
                                 System.err.println("Tamaño de Pantalla");
                                 int tamano=scan.nextInt();
                                 agregar.cargarAvionPrefrencial(2, nSillas, precio,tamano);
                                 System.err.println("Avion Cargado Exitosamente");
                                 break;
                                
                        case 2:
                            String ms= agregar.comprar(2);
                            System.out.println("-->"+ms);
                            break;
                        case 3:
                            
                          String msd=  agregar.despegar(2);
                          System.out.println("-->"+msd);
                            break;
                        case 4:
                         String msa= agregar.aterrizar(2);
                         System.out.println("-->"+msa);
                         break;
                         
                        case 5:
                            menuInicial();
                   }
                    
                    
                }while(opcion!=5);
                
             case 4:
                           do{
                    opcion=menuAvion();
                    
                    switch(opcion){
                        case 1:
                            System.out.println("Avion Mixto..Cargar");
                            System.out.println("--------------------------------------");
                                 System.err.println("CAPACIDAD: Ingrese # de sillas Normales: ");
                                 int nSillas = scan.nextInt();
                                 System.err.println("Precio Sillas: ");
                                 double precio = scan.nextInt();
                                 agregar.cargarAvionNormal(3, nSillas, precio);
                      
                            System.out.println(" ");
                            System.out.println("--------------------------------------");
                                 System.err.println("CAPACIDAD: Ingrese # de sillas preferenciales: ");
                                 int  nSillasm = scan.nextInt();
                                 System.err.println("Precio Sillas: ");
                                 double preciom = scan.nextInt();
                                 System.err.println("Tamaño de Pantalla");
                                 int tamano=scan.nextInt();
                                 agregar.cargarAvionPrefrencial(3, nSillasm, preciom,tamano);
                                 System.err.println("Avion Cargado Exitosamente");
                                 break;
                                
                        case 2:
                            String ms= agregar.comprar(3);
                            System.out.println("-->"+ms);
                            break;
                        case 3:
                            
                          String msd=  agregar.despegar(3);
                          System.out.println("-->"+msd);
                            break;
                        case 4:
                         String msa= agregar.aterrizar(3);
                         System.out.println("-->"+msa);
                         break;
                         
                        case 5:
                            menuInicial();
                   }
                    
                    
                }while(opcion!=5);
                  
         }
         
          
         } catch(InputMismatchException ex){
            System.out.println("Error.. opcion no valida");
        
        }  
         }while(opcion!=5);
             
    }
    
    
    public int menuAvion(){
            Scanner scan = new Scanner(System.in);
            System.err.println("..Avion..");
            System.err.println("1.Cargar Avion");
            System.err.println("2.Comprar");
            System.err.println("3.Despegar");
            System.err.println("4.Aterrizar");
            System.err.println("5.Salir");
            opcion = scan.nextInt();
        return opcion;
    }
}
