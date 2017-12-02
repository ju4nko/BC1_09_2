package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerFichero {

     /**
      * Constructor que lee el CSV
      * @param ruta // la ruta relativa del fichero
      * @throws FileNotFoundException 
      */
    String ruta;
     public LeerFichero(String ruta){
         this.ruta = ruta;
         //lecturaCompleta();
     }
     
     public boolean esNumero(String string){
         try{
             Integer.parseInt(string);
         }catch(Exception e){
             return false;
         }
         return true;
     }
    
       public void lecturaCompleta(){
           // Fichero del que queremos leer
                //String ruta = "/resources/Terreno.txt";
		File fichero = new File(ruta);
                Reader fr;
		Scanner s = null;

		try {
                    
                        fr = new InputStreamReader(getClass().getResourceAsStream(ruta));
                       
			// Leemos el contenido del fichero
			System.out.println("... LECTURA COMPLETA DEL FICHERO ...");
			s = new Scanner(fr);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				System.out.println(linea);      // Imprimimos la linea
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
       }
       
       public ArrayList<Integer> listaDatos(String ruta){
           // Fichero del que queremos leer
                //String ruta = "/resources/Terreno.txt";
		File fichero = new File(ruta);
                ArrayList<Integer> array = new ArrayList();
                Reader fr;
		Scanner s = null;
                String numero="";

		try {
                        fr = new InputStreamReader(getClass().getResourceAsStream(ruta));
			// Leemos el contenido del fichero
			System.out.println("... Leemos las características del terreno ...");
			s = new Scanner(fr);
                        s.nextLine(); // Nos saltamos la cabecera
			while (s.hasNextLine()) {
                                    array.add(Integer.parseInt(s.next()));
                                    //System.out.print(s.next());
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
                return array;
       }
       
       public ArrayList<Integer> leerTerreno(String ruta){
            // Fichero del que queremos leer
                //String ruta = "/resources/Terreno.txt";
		File fichero = new File(ruta);
                Reader fr;
		Scanner s = null;
                ArrayList<Integer> lista = new ArrayList<Integer>();

		try {
                    
                        fr = new InputStreamReader(getClass().getResourceAsStream(ruta));
                       
			// Leemos el contenido del fichero
			System.out.println("... Leemos la cantidad de arena del terreno ...");
			s = new Scanner(fr);
			// Leemos linea a linea el fichero
                        // Obviamos las dos primeras líneas
                        s.nextLine();
                        s.nextLine();
			while (s.hasNextLine()) {
                                lista.add(s.nextInt());// Imprimimos la linea
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
                return lista;
       }
       
      
}
		
	
