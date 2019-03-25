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
    
    public Silla() {
    }

    public Silla(int numero, double valor, String estado) {
        this.numero = numero;
        this.valor = valor;
        this.estado = estado;
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

}
