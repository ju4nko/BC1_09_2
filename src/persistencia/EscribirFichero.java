/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.FileWriter;
import java.util.ArrayList;

public class EscribirFichero {

    /**
     * 
     * @param arrayDatos
     * @param arrayTerreno 
     */
        public static void introducirDatosFichero(int[] arrayDatos,int[][] arrayTerreno){
               
		//String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };
                //
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("src/resources/fichero_escritura.txt");
                        // Cabecera
                        fichero.write("X Y K M C F \n");
                        // Datos
                        
			// Escribimos linea a linea en el fichero
			for (int i=0;i<arrayDatos.length;i++) {
				//fichero.write(linea + "\n");
                                fichero.write(arrayDatos[i]+ " ");
			}
                        fichero.write("\n");
                        for(int j=0;j<arrayTerreno.length;j++){
                            for(int k=0;k<arrayTerreno.length;k++){
                                fichero.write(" "+arrayTerreno[j][k]+ " ");
                            }
                            fichero.write("\n");
                        }

			fichero.close(); // Cerramos el fichero

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		} 
        }
	
}
