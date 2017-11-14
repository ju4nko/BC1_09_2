/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author juanjo
 */
public class EspacioEstados {
    Estado estado_final;
    Estado estado_actual;
    ArrayList<Distribucion> listaSucesores;
    
    public EspacioEstados(Estado estado_final,Estado estado_actual){
        this.estado_actual = estado_actual;
        this.estado_final = estado_final;
        listaSucesores = new ArrayList<Distribucion>();
        
    }
    
    public boolean estadoMeta(Estado estado){
        Casilla[][] casillas = estado.getTerreno().getCasillas();
        int k = estado.getTerreno().getK();
        for(int i=0;i<casillas.length;i++){
            for(int j=0;j<casillas[i].length;j++){
                if(casillas[i][j].getCantArena()!=k){
                    return false;
                }
            }
        }
        return true;
    }
    
     public ArrayList<Casilla> accionTractor(Estado estado) {
        int i, j;
        Casilla aux;
        //Casilla posTractor = new Casilla(x,y); // Obtenemos la casilla donde está el tractor
        Casilla posTractor = estado.getTerreno().getCasilla(estado.getTerreno().getTractor().getX(),
                                        estado.getTerreno().getTractor().getY());
        //System.out.println("COORDENADAS: " + .getX() + " " + t.getY());
        PonerVisitado(posTractor,estado);
        ArrayList<Casilla> listaAdyacentes = new ArrayList();
        for (i = -1; i <= 1; i++) { // Todos los adyacentes de la casilla
            for (j = -1; j <= 1; j++) {
                //Obtenemos la posición en el terreno de los adyacentes
                aux = new Casilla(estado.getTerreno().getTractor().getX() + i, estado.getTerreno().getTractor().getY()
                                    + j,genAleatorioArena(0,1));
                //aux = getCasilla(0+i, 0+j);
                if (estaDentro(aux,estado)) {
                    if (!EstaVisitado(aux,estado)) {
                        aux = estado.getTerreno().getCasilla(estado.getTerreno().getTractor().getX() +
                                i, estado.getTerreno().getTractor().getY() + j);
                        if ((Math.abs(i) + Math.abs(j)) != 2) { // Cogemos los adyacentes que no sean diagonales
                            listaAdyacentes.add(aux);
                        }
                    }
                }
            }
        }
        return listaAdyacentes;
    }
     // Metodo para poner una casilla del tablero a Visitado
    public void PonerVisitado(Casilla aux,Estado estado) {
        estado.getTerreno().getCasillas()[aux.getFila()][aux.getColumna()].setVisitado(true);
    }
     public int genAleatorioArena(int min,int max){
        return (int)(Math.random()*max+min);
    }
     public boolean estaDentroAdyacente(int[] adyacente,Estado estado) {
        if (adyacente[0] > 0 && adyacente[0] < estado.getTerreno().getColumnas() - 1
                && adyacente[1] > 0 && adyacente[1] < estado.getTerreno().getFilas() - 1) {
            return true;

        }
        return false;
    }
     // Metodo para comprobar si una casilla esta dentro del terreno
    public boolean estaDentro(Casilla aux,Estado estado) {
        return aux.getFila() >= 0 && aux.getFila() <= estado.getTerreno().getFilas() 
                && aux.getColumna() >= 0 && aux.getColumna() <= (estado.getTerreno().getColumnas());
    }
     public boolean EstaVisitado(Casilla aux,Estado estado) {
        return estado.getTerreno().getCasillas()[aux.getFila()][aux.getColumna()].isVisitado();
    }
     
     public void backtracking(int etapa,int Sol[],int s,
                               ArrayList<Casilla> adyacentes,int MAX){
        int i;
        if(etapa==Sol.length){
            if(esSolucion(Sol,etapa,s)){
                 // IMPRIMIMOS LAS COMBINACIONES POSIBLES DE DISTRIBUIR ARENA
                 //imprimirSol(Sol,adyacentes);
                 if(sumaValida(Sol,adyacentes,MAX)){
                     
                        System.out.print("[");
                            for(int j=0;j<Sol.length;j++){
                                 
                                listaSucesores.add(new Distribucion(Sol[j],adyacentes.get(j)));
                                //System.out.print(listaSucesores.get(j));
                            } 
                            System.out.print("]");
                            System.out.println();
                     
                 }              
                 //System.out.println();
            }           
        }else{
            for(i=0;i<=s;i++){
                    Sol[etapa] = i;
                    backtracking(etapa+1,Sol,s,adyacentes,MAX); 
            }
        }       
    }
     public boolean sumaValida(int[] sol, ArrayList<Casilla> adyacentes,int MAX){
        int suma = 0;
        for(int i=0;i<sol.length;i++){
            suma = sol[i]+adyacentes.get(i).getCantArena();
            if(suma>MAX){
                return false;
            }
        }
        return true;
    }
     public boolean esSolucion(int sol[],int etapa,int valor){
       int suma=0;
       for(int i=0;i<sol.length;i++){
           suma+=sol[i];
       }
       return suma==valor;
   }
     public ArrayList<Distribucion> crearListaDistribucion(int[] cantidades,ArrayList<Casilla> casillas,int MAX){
        ArrayList<Distribucion> listaDistribucion = new ArrayList();
        //Accion[] listaAcciones = new Accion[cantidades.length];
        System.out.print("[");
            for(int i=0;i<cantidades.length;i++){
                //llistaDistribucion[i] = new Distribucion(cantidades[i],casillas.get(i));
                //System.out.print(listaDistribucion[i]);  
                listaDistribucion.add(new Distribucion(cantidades[i],casillas.get(i)));
                System.out.print(listaDistribucion.get(i));
            } 
        System.out.print("]");
        System.out.println();
        return listaDistribucion;
    }
     public void imprimeSucesores(){
         for(int i=0;i<listaSucesores.size();i++){
             System.out.print(listaSucesores.get(i));
         }
     }
}
