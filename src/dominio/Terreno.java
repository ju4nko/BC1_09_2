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
    private int MAX;
    private Tractor t;
    private int filas;
    private int columnas;
    private int [][] casillas;
    
    
    private void colocarTractor(){
        
    }
    public Terreno(int filas,int columnas,int MAX){
        this.filas = filas;
        this.MAX = MAX;
        this.columnas=columnas;
        casillas=rellenarMatrizAleatorios(filas,columnas,0,MAX);
        k = 5;
    }
    
    public void crearTerreno(){
        System.out.println("Creando el terreno...");
        int valor = 0;
        int suma_valor = 0;
                     
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
    
    /**
     * Rellena un array con números aleatorios entre min y max
     * @param tam
     * @param min
     * @param max
     * @return 
     */
    public static int[][] rellenarMatrizAleatorios(int x,int y,int min,int max){
        int[][] matriz = new int[x][y];
        for(int i = 0;i<x;i++){
            for(int j=0;j<y;j++){
                matriz[i][j] = (int)(Math.random()*max+min);
            }
            
        }
        return matriz;
    }
    /**
     * Imprimir la matriz para pruebas
     */
    public static void imprimirMatrizAleatorios(){
        int [][]matriz = rellenarMatrizAleatorios(5,5,0,8);
        for(int i = 0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                System.out.println(matriz[i][j]);
            }
            
        }
    }
    public static void main(String[] args){
        imprimirMatrizAleatorios();
    }

    
}
