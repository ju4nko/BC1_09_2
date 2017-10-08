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
    
    public ArrayList backtracking(int etapa,int Sol[],int s,ArrayList listaDist,
                                        ArrayList<Casilla> adyacentes){
        int i;
        //ArrayList lista = new ArrayList();
        if(etapa==Sol.length){
            if(esSolucion(Sol,etapa,s)){
                 //Mostrar solución
                 //System.out.println(imprimirSol(Sol));
                 listaDist.add(Sol);//Añadimos a la lista el vector
                 //Sumamos con la lista
            }
           
        }else{
            for(i=0;i<=s;i++){
                    Sol[etapa] = i;
                    backtracking(etapa+1,Sol,s,listaDist,adyacentes); 
            }
        }
       return listaDist;
    }
    
    public void sumarListas(ArrayList listaDist,ArrayList<Casilla> adyacentes){
        ArrayList<Integer> listaSuma = new ArrayList<Integer>();
        for(int i=0;i<listaDist.size();i++){
            //listaSuma.add(listaDist.get(i)+adyacentes.get(i).getCantArena());
        }
    }
    
    
   public boolean esSolucion(int sol[],int etapa,int valor){
       int suma=0;
       for(int i=0;i<sol.length;i++){
           suma+=sol[i];
       }
       return suma<=valor;
   }
    public String imprimirSol(int [] vector){
       String cadena="";
       for(int i=0;i<vector.length;i++){
           cadena+=vector[i];
       }
       return cadena;
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
    
    public ArrayList<Integer> getListaArenaAdyacentes(ArrayList<Casilla> casillas){
        ArrayList<Integer> cantidades = new ArrayList();
        for(int i=0; i<casillas.size();i++){
            cantidades.add(casillas.get(i).getCantArena());
        }
        return cantidades;
    }
    
    public void imprimirLista(ArrayList<Casilla> lista){
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i).getCantArena());
        }
    }
    
    public void imprimeLista(ArrayList lista){
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
            //t.imprimirMatrizAleatorios();
            Tractor tractor = new Tractor();
            ArrayList<Casilla> lista = tractor.accionTractor(1,1,t);
            tractor.imprimirLista(lista);
//            int sol[] = new int[4];
//            ArrayList array = new ArrayList();
//            array = tractor.backtracking(0, sol, 3, array);
//            tractor.imprimeLista(array);
        }
}
