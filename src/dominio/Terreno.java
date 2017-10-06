/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import utilidades.leer;

/**
 *
 * @author juanjo
 */
public class Terreno {
                      //O,N,E,S
    // ArrayList<Int> {0,1,2,3}
    
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
        casillas=new int[filas][columnas];
        //casillas = inicializarTerreno();
        k = 5;
        t = new Tractor();
    }
    
    public void crearTerreno(){
        casillas = rellenarMatrizAleatorios(filas,columnas,0,MAX);             
    }
    
    public void inicializarTerreno(){
        for(int i=0;i<filas;i++){
            for(int j=0;j<filas;j++){
                casillas[i][j]=0;
            }
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
    
    public ArrayList<Adyacente> buscarAdyacentes(int x,int y){
       Adyacente ad1= new Adyacente();//Izquierda
       Adyacente ad2= new Adyacente();
       Adyacente ad3= new Adyacente();
       Adyacente ad4= new Adyacente();
       ArrayList<Adyacente> lista = new ArrayList();
       //ad1 = t.moverO(x, y, casillas);
       //ad2 = t.moverN(x, y, casillas);
       //ad3 = t.moverE(x, y, casillas);
       //ad4 = t.moverS(x, y, casillas);
//       if(estaDentroAdyacente(ad1)){
//           // Llamada Metodo Distribuir
//           lista.add(ad1);
//       }
//       if(estaDentroAdyacente(ad2)){
//           // Llamada Metodo Distribuir
//       }
//       if(estaDentroAdyacente(ad3)){
//           // Llamada Metodo Distribuir
//       }
//       if(estaDentroAdyacente(ad4)){
//           // Llamada Metodo Distribuir
//       }
       
       return lista;
    }
    
    public boolean estaDentroAdyacente(int[] adyacente){
        if(adyacente[0]>0 && adyacente[0]<columnas-1
                && adyacente[1]>0 && adyacente[1]<filas-1){
                    return true;
         
        }
       return false;
    }
    
    public static void main(String[] args){
        imprimirMatrizAleatorios();
    }

    
}
