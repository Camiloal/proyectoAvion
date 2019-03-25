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
                 int op;
                do{
                    op=menuAvion();
                    
                    switch(op){
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
                            
                           agregar.despegar(1);
                            break;
                        case 4:
                         String msa= agregar.aterrizar(1);
                         System.out.println("-->"+msa);
                         break;
                   }
                    
                    
                }while(op!=5);
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
