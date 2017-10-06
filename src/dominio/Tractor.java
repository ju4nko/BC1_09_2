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
public class Tractor {
    //Coordenadas del tractor
    private int x;
    private int y;
    //ACCIONES
    public void moverTractor(){
        // Mover el tractor N,S,E,O
    }
    public void distribuirTractor(int k,int MAX,int cant_distribuir){
        // Distribuir arena de una casilla 
    }
    /**
     * Método que comprueba los adyacentes del tractor y los mete en una lista
     * @param x
     * @param y
     * @param t
     * @return 
     */
    public ArrayList<Casilla> accionTractor(int x,int y,Terreno t){
        int i,j;
        Casilla aux;
        Casilla posTractor = new Casilla(x,y); // Obtenemos la casilla donde está el tractor
        t.PonerVisitado(posTractor);
        ArrayList<Casilla> listaAdyacentes = new ArrayList();
        for(i=-1;i<=1;i++){ // Todos los adyacentes de la casilla
            for(j=-1;j<=1;j++){                
                    //Obtenemos la posición en el terreno de los adyacentes
                    aux=new Casilla(x+i,y+j);                   
                    if(t.estaDentro(aux)){
                        if(!t.EstaVisitado(aux)){
                            if((Math.abs(i)+Math.abs(j))!=2){ // Cogemos los adyacentes que no sean diagonales
                            listaAdyacentes.add(aux);
                            }
                        }                       
                    }               
            }
        }
        return listaAdyacentes;
    }
    
    public void imprimirLista(ArrayList<Casilla> lista){
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i));
        }
    }
    
    
      
    public int[] moverN(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		
			newPos[0]=x;
			newPos[1]=y-1;
		
		return newPos;
	}
	
    
	public int[] moverS(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		
			newPos[0]=x;
			newPos[1]=y+1;
		
		return newPos;
	}
	
	
	public int[] moverE(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		
			newPos[0]=x+1;
			newPos[1]=y;
		
		return newPos;
	}
	
	
	public int[] moverO(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		
			newPos[0]=x-1;
			newPos[1]=y;
		
		return newPos;
	}
        
        public static void main(String[]args){
            Terreno t = new Terreno(3,3,8);
            Tractor tractor = new Tractor();
            ArrayList<Casilla> lista = tractor.accionTractor(1,1,t);
            tractor.imprimirLista(lista);           
        }
}
