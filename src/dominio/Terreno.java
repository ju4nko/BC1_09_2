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
    private Casilla [][] casillas;
    
    
    private void colocarTractor(){
        
    }
    public Terreno(int filas,int columnas,int MAX){
        this.filas = filas;
        this.MAX = MAX;
        this.columnas=columnas;
        casillas=new Casilla[filas][columnas];
        crearTerreno();
        //casillas = inicializarTerreno();
        k = 5;
        t = new Tractor();
    }
    
    public Casilla[][] crearTerreno(){
              casillas = rellenarTerrenoAleatorio(0,MAX);  
              return casillas;
    }
    
//    public void inicializarTerreno(){
//        for(int i=0;i<filas;i++){
//            for(int j=0;j<filas;j++){
//                casillas[i][j]=0;
//            }
//        }
//    }
    
    // Metodo para comprobar si una casilla esta dentro del terreno
    public boolean estaDentro(Casilla aux){
        return aux.getFila() >=0 && aux.getFila()<=filas && aux.getColumna() >=0 && aux.getColumna()<=(columnas);
    }
    
    public Casilla[][] getCasillas(){
        return casillas;
    }
    
    
    public String imprimirTerreno(){
        String texto="\n TERRENO \n\n";
        for(int i=0; i<casillas.length;i++){
            for(int j=0; j<casillas[0].length;j++){
               texto+= casillas[i][j].getCantArena()+ " ";
            }
            texto+="\n";
        }
        return texto;
    }
    
    
    /**
     * Rellena un array con números aleatorios entre min y max
     * @param tam
     * @param min
     * @param max
     * @return 
     */
    public Casilla[][] rellenarTerrenoAleatorio(int min,int max){
        
        int cantidad = 0;
        for(int i = 0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                  casillas[i][j]= new Casilla(i,j);
                  //System.out.println(casillas[i][j].getCantArena());
            }
            
        }
        return casillas;
    }
   
    
    public boolean estaDentroAdyacente(int[] adyacente){
        if(adyacente[0]>0 && adyacente[0]<columnas-1
                && adyacente[1]>0 && adyacente[1]<filas-1){
                    return true;
         
        }
       return false;
    }
     // Metodo para comprobar si una casilla del tablero esta a Visitado=true
    public boolean EstaVisitado(Casilla aux){
        return casillas[aux.getFila()][aux.getColumna()].isVisitado();
    }
    
    // Metodo para poner una casilla del tablero a Visitado
    public void PonerVisitado(Casilla aux){
        casillas[aux.getFila()][aux.getColumna()].setVisitado(true);
    }
    
    // Metodo para poner una casilla del tablero a NO Visitado
    public void QuitarVisitado(Casilla aux){
        casillas[aux.getFila()][aux.getColumna()].setVisitado(false);
    }
    
     // Metodo para imprimir el tablero inicialmente
    public String toString (){
        String texto="\n TERRENO \n\n";
        for(int i=0; i<casillas.length;i++){
            for(int j=0; j<casillas[0].length;j++){
               texto+= " ["+casillas[i][j].getFila()+","+casillas[i][j].getColumna()+"] ";
            }
            texto+="\n";
        }
        return texto;
    }
    
//    public static void main(String[] args){
//        Terreno t = new Terreno(3,3,8);
//        System.out.println(t);
//    }

    
}
