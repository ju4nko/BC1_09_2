/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import utilidades.leer;

/**
 *
 * @author juanjo
 */
public class Terreno {
    private int k; //Cantidad deseada en cada casilla
    private int s; //Cantidad a distribuir entre casillas vecinas
    private int V; //Cantidad total de arena del terreno
    private Tractor t;
    private int filas;
    private int columnas;
    private int [][] casillas;
    
    
    private void colocarTractor(){
        
    }
    public Terreno(int filas,int columnas){
        this.filas = filas;
        this.columnas=columnas;
        casillas = new int[filas][columnas];
        k = 5;
        if(crearTerreno()){
            imprimirTerreno();
        }else{
            System.out.println("Error");
        }
    }
    
    public boolean crearTerreno(){
        System.out.println("Creando el terreno...");
        int valor = 0;
        int suma_valor = 0;
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                try{
                    valor =leer.entero("Introduzca un valor para la casilla: ["+i+","+j+"]");
                }catch(Exception e){
                    System.out.println("Valor fuera de rango");
                }
                
                casillas[i][j] = valor;
                suma_valor=suma_valor+valor;
            }
            
        }
        if(suma_valor!=filas*columnas*k){
            return false;
        }else{
            return true;
        }
    }
    public void imprimirTerreno(){
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.print(casillas[i][j]);
            }
            System.out.println("");
        }
    }
    public int [][]getCasillas(){
        return casillas;
    }

    
}
