/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author juanjo
 */
public class Distribucion {
    private int cantidad;
    private Casilla casilla;
    
    public Distribucion(int cantidad,Casilla casilla){
        this.cantidad = cantidad;
        this.casilla = casilla;
    }
    public int getCantidad(){
        return cantidad;
    }
    public Casilla getCasilla(){
        return casilla;
    }
    
    @Override
    public String toString(){
        return "("+cantidad+", ("+casilla.getFila()+", "+casilla.getColumna()+"))";
    }
}
