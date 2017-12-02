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
   
     public void imprimeSucesores(){
         for(int i=0;i<listaSucesores.size();i++){
             System.out.print(listaSucesores.get(i));
         }
     }
}
