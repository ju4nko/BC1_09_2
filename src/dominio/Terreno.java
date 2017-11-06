/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import persistencia.LeerFichero;

/**
 *
 * @author juanjo,guillermo y raquel
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
    private Casilla[][] casillas;
    private Casilla casillaTractor;
    private boolean aleatorio; //True si quieres que sea un terreno aleatorio

    public Terreno(int filas,int columnas,int MAX,boolean aleatorio){
        this.filas = filas;
        this.MAX = MAX;
        this.columnas = columnas;
        this.aleatorio = aleatorio;
        casillas = new Casilla[filas][columnas];
        crearTerreno(aleatorio);
        t = new Tractor(genAleatorio(0, filas - 1), genAleatorio(0, columnas - 1));
        //casillas = inicializarTerreno();
        k = 5;
    }
    
    
    public Tractor getTractor() {
       return t;
    }
    public Casilla getCasillaTractor(){
        return casillas[t.getX()][t.getY()];
    }
    
    public Casilla[][] getCasillas() {
        return casillas;
    }
    
    public Casilla getCasilla(int x, int y){
        return casillas[x][y];
    }
    
    /**
     * Si quieres que se cree de forma aleatoria se pone el valor a true 
     */
    public void crearTerreno(boolean Aleatorio) {
        if(aleatorio){
            casillas = rellenarTerrenoAleatorio(0, MAX); 
        }else{
            casillas = rellenaTerreno(0,MAX);
        }
        //Colocar Tractor
        
    }

    public void comprobarAleatorio() {
        int suma=0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma+= casillas[i][j].getCantArena();
            }
        }
        if(suma>(filas*columnas*k)){ //COMPROBAR QUE LA CANTIDAD DE ARENA NO SUPERA LA CANTIDAD DEBIDA
            int sobra;
            sobra=(filas*columnas*k)-suma;
            for (int i = 0; i < filas && sobra!=0; i++) {
                for (int j = 0; j < columnas && sobra!=0; j++) {
                    int valorC=casillas[i][j].getCantArena();
                    while(valorC >0 && valorC<MAX && sobra!=0){
                        valorC--;
                        sobra--;
                        casillas[i][j].setCantArena(valorC);
                    }
                   
                }
            } 
        }
        
        else if(suma<(filas*columnas*k)){//COMPROBAR QUE LA CANTIDAD DE ARENA NO ES MENOR LA CANTIDAD DEBIDA
            int falta;
            falta=suma-(filas*columnas*k);
            for (int i = 0; i < filas && falta!=0; i++) {
                for (int j = 0; j < columnas && falta!=0; j++) {
                    int valorC=casillas[i][j].getCantArena();
                    while(valorC >0 && valorC<MAX && falta!=0){
                        valorC--;
                        falta--;
                        casillas[i][j].setCantArena(valorC);
                    }
                   
                }
            } 
        }
    }
    
    public ArrayList<Casilla> accionTractor() {
        int i, j;
        Casilla aux;
        //Casilla posTractor = new Casilla(x,y); // Obtenemos la casilla donde está el tractor
        Casilla posTractor = getCasilla(t.getX(), t.getY());
        System.out.println("COORDENADAS: " + t.getX() + " " + t.getY());
        PonerVisitado(posTractor);
        ArrayList<Casilla> listaAdyacentes = new ArrayList();
        for (i = -1; i <= 1; i++) { // Todos los adyacentes de la casilla
            for (j = -1; j <= 1; j++) {
                //Obtenemos la posición en el terreno de los adyacentes
                aux = new Casilla(t.getX() + i, t.getY() + j,genAleatorioArena(0,1));
                //aux = getCasilla(0+i, 0+j);
                if (estaDentro(aux)) {
                    if (!EstaVisitado(aux)) {
                        aux = getCasilla(t.getX() + i, t.getY() + j);
                        if ((Math.abs(i) + Math.abs(j)) != 2) { // Cogemos los adyacentes que no sean diagonales
                            listaAdyacentes.add(aux);
                        }
                    }
                }
            }
        }
        return listaAdyacentes;
    }

  


    // Metodo para comprobar si una casilla esta dentro del terreno
    public boolean estaDentro(Casilla aux) {
        return aux.getFila() >= 0 && aux.getFila() <= filas && aux.getColumna() >= 0 && aux.getColumna() <= (columnas);
    }
    
    public String imprimirTerreno() {
        String texto = "\n TERRENO \n\n";
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                texto += casillas[i][j].getCantArena() + " ";
            }
            texto += "\n";
        }
        return texto;
    }

    /**
     * Rellena un array con números aleatorios entre min y max
     *
     * @param tam
     * @param min
     * @param max
     * @return
     */
    public Casilla[][] rellenarTerrenoAleatorio(int min, int max) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(i, j,genAleatorioArena(min,max));
            }
        }
        return casillas;
    }
    
    public Casilla[][] rellenaTerreno(int min,int max){
        ArrayList<Integer> listaArena = new ArrayList<Integer>();
        String ruta = "/resources/Terreno.txt";
        LeerFichero lectura = new LeerFichero(ruta);
        listaArena = lectura.leerTerreno(ruta);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(i, j,listaArena.get(0));
                System.out.print(listaArena.get(0));
                listaArena.remove(0);
            }
        }
        return casillas;
    }
    public int genAleatorioArena(int min,int max){
        return (int)(Math.random()*max+min);
    }

    public boolean estaDentroAdyacente(int[] adyacente) {
        if (adyacente[0] > 0 && adyacente[0] < columnas - 1
                && adyacente[1] > 0 && adyacente[1] < filas - 1) {
            return true;

        }
        return false;
    }
    // Metodo para comprobar si una casilla del tablero esta a Visitado=true

    public boolean EstaVisitado(Casilla aux) {
        return casillas[aux.getFila()][aux.getColumna()].isVisitado();
    }

    // Metodo para poner una casilla del tablero a Visitado
    public void PonerVisitado(Casilla aux) {
        casillas[aux.getFila()][aux.getColumna()].setVisitado(true);
    }

    // Metodo para poner una casilla del tablero a NO Visitado
    public void QuitarVisitado(Casilla aux) {
        casillas[aux.getFila()][aux.getColumna()].setVisitado(false);
    }

    public int genAleatorio(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    // Metodo para imprimir el tablero inicialmente
    public String toString() {
        String texto = "\n TERRENO \n\n";
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                texto += " [" + casillas[i][j].getFila() + "," + casillas[i][j].getColumna() + "] ";
            }
            texto += "\n";
        }
        return texto;
    }
}
