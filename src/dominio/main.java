/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import persistencia.EscribirFichero;
import persistencia.LeerFichero;
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
        int x,y,k,MAX,C,F;
        boolean op=true;
	int opcion=0;
	do{
            System.out.println("\n\n+++++++ MENU PRINCIPAL +++++++");
            System.out.print("1 ---> Introducir datos por tecaldo");
            System.out.print("\n2 ---> Leer datos de un fichero");
            System.out.print("\n3 ---> Salir");
            System.out.print("\n");
                opcion=leer.entero("\nElija una opcion:");
            System.out.println("");
            switch(opcion){ // LECTURA POR TECLADO
                case 1:
                    x = leer.entero("Introduzca la posicion en filas del tractor");
                    y = leer.entero("Introduzca la posicion en columnas del tractor");
                    k = leer.entero("Introduzca el número deseado de arena a distribuir de cada casilla");
                    MAX = leer.entero("Introduzca el número máximo de arena en cada casilla: ");
                    C = leer.entero("Ingrese el numero de filas del terreno: ");
                    F = leer.entero("Ingrese el numero de columnas del terreno: ");
                /**
                 * Crear objeto terreno con longitud dada y un maximo dado
                 */
                Terreno t = new Terreno(C,F,MAX);
                // Guardamos los datos en una lista
                int arrayDatos[] ={x,y,k,MAX,C,F};
                // Escribimos en el fichero con la lista y la matriz
                EscribirFichero.introducirDatosFichero(arrayDatos,t.getCasillas());
                break;    
                
                case 2: //LECTURA POR FICHERO
                    String ruta = "/resources/Terreno.txt";
                    LeerFichero leer = new LeerFichero(ruta);
                    ArrayList<Integer> lista = new ArrayList();
                    lista = leer.listaDatos(ruta);
                    x = lista.get(0);
                    y = lista.get(1);
                    k = lista.get(2);
                    MAX = lista.get(3);
                    C = lista.get(4);
                    F = lista.get(5);
                    break;
                
                case 3: //SALIR
                op=false;
                System.out.print("Gracias por sus consutlas");
                break;
            }
        }while(op==true);
    
    
    }
}