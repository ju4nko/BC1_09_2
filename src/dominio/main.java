/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import persistencia.EscribirFichero;
import utilidades.leer;

/**
 *
 * @author juanjo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // LECTURA POR TECLADO
        int x = leer.entero("Introduzca la posicion en filas del tractor");
        int y = leer.entero("Introduzca la posicion en columnas del tractor");
        int k = leer.entero("Introduzca el número deseado de arena a distribuir de cada casilla");
        int MAX = leer.entero("Introduzca el número máximo de arena en cada casilla: ");
        int C = leer.entero("Ingrese el numero de filas del terreno: ");
        int F = leer.entero("Ingrese el numero de columnas del terreno: ");
        /**
         * Crear objeto terreno con longitud dada y un maximo dado
         */
        Terreno t = new Terreno(C,F,MAX);
        // Guardamos los datos en una lista
        int arrayDatos[] ={x,y,k,MAX,C,F};
        // Escribimos en el fichero con la lista y la matriz
        EscribirFichero.introducirDatosFichero(arrayDatos,t.getCasillas());
    }
    
    
    
}
