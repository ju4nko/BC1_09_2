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
    private int s; //Cantidad de arena a distribuir
    private int k; //Cantidad deseada en cada casilla
    private int MAX;
    //ACCIONES
    
    public Tractor(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void moverTractor(){
        // Mover el tractor N,S,E,O
    }
    public void distribuirTractor(int k,int MAX,int cant_distribuir){
        // Distribuir arena de una casilla 
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    /**
     * Método backtracking
     * @param etapa
     * @param Sol
     * @param s
     * @param adyacentes
     * @param MAX 
     */
    public void backtracking(int etapa,int Sol[],int s,
                               ArrayList<Casilla> adyacentes,int MAX){
        int i;
        if(etapa==Sol.length){
            if(esSolucion(Sol,etapa,s)){
                 // IMPRIMIMOS LAS COMBINACIONES POSIBLES DE DISTRIBUIR ARENA
                 System.out.println(imprimirSol(Sol));
                 // SUMAMOS LA ARENA A LA CASILLA A DISTRIBUIR
                 imprimeLista(sumarListas(Sol,adyacentes,MAX));
                 System.out.println();
            }           
        }else{
            for(i=0;i<=s;i++){
                    Sol[etapa] = i;
                    backtracking(etapa+1,Sol,s,adyacentes,MAX); 
            }
        }       
    }
    /**
     * Método Que suma dos listas para dar una resultado de la suma de ambas
     * @param sol
     * @param adyacentes
     * @param MAX
     * @return 
     */
    public ArrayList<Integer> sumarListas(int[] sol,ArrayList<Casilla> adyacentes,int MAX){
        ArrayList<Integer> listaSuma = new ArrayList<Integer>();
        int suma =0;
        for(int i=0;i<sol.length;i++){
            suma= sol[i]+adyacentes.get(i).getCantArena();
            if(suma>MAX){
                return new ArrayList(); // Descartamos la lista
            }else{
                listaSuma.add(sol[i]+adyacentes.get(i).getCantArena());   
            }
                  
        }
        return listaSuma;
    }
    public boolean listaValida(ArrayList<Casilla> adyacentes,int MAX){
        for(int i=0;i<adyacentes.size();i++){
            return adyacentes.get(i).getCantArena()>MAX;
        }
        return true;
    }
     
   /**
    * COMPARAMOS SI ES IGUAL A LA CANTIDAD DESEADA 
    * @param sol
    * @param etapa
    * @param valor cantidad deseada
    * @return 
    */ 
   public boolean esSolucion(int sol[],int etapa,int valor){
       int suma=0;
       for(int i=0;i<sol.length;i++){
           suma+=sol[i];
       }
       return suma==valor;
   }
    public String imprimirSol(int [] vector){
       String cadena="";
       cadena+="[ ";
       for(int i=0;i<vector.length;i++){
           cadena+=vector[i]+" ";
       }
       cadena+="] ";
       System.out.println();
       return cadena;
   }
    /**
     * Método que comprueba los adyacentes del tractor y los mete en una lista
     * @param x
     * @param y
     * @param t
     * @return 
     */
    public ArrayList<Casilla> accionTractor(Terreno t){
        int i,j;
        Casilla aux;
        //Casilla posTractor = new Casilla(x,y); // Obtenemos la casilla donde está el tractor
        Casilla posTractor = t.getCasilla(x, y);
        t.PonerVisitado(posTractor);
        ArrayList<Casilla> listaAdyacentes = new ArrayList();
        for(i=-1;i<=1;i++){ // Todos los adyacentes de la casilla
            for(j=-1;j<=1;j++){                
                    //Obtenemos la posición en el terreno de los adyacentes
                    //aux=new Casilla(x+i,y+j); 
                    aux = t.getCasilla(x+i, y+j);
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
        System.out.println("LAS CANTIDADES DE ARENA DE LOS ADYACENTES SON: ");
        System.out.print("[ ");
        for(int i=0;i<lista.size();i++){
            System.out.print(lista.get(i).getCantArena()+ " ");
        }
        System.out.print(" ]");
    }
    
    public void imprimeLista(ArrayList lista){
        System.out.println("DISTRIBUYENDO... ");
        System.out.print("[ ");
        for(int i=0;i<lista.size();i++){
            System.out.print(lista.get(i)+ " ");
        }
        System.out.println("] ");
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
            System.out.print(t.imprimirTerreno());
            System.out.println("COMBINACIONES");
            Tractor tractor = new Tractor(1,1);
            ArrayList<Casilla> lista = tractor.accionTractor(t);
            tractor.imprimirLista(lista);
            int sol[] = new int[4];
            int MAX = 8;
            tractor.backtracking(0, sol, 3, lista,8);
        }
        
        public int genAleatorio(int min,int max){
               return (int)(Math.random()*max+min);
        }
        
}
