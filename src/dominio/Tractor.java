/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author juanjo, guillermo y raquel
 */
public class Tractor {
    //Coordenadas del tractor
    private int x;
    private int y;
    private int s; //Cantidad de arena a distribuir
    private int k; //Cantidad deseada en cada casilla
    private int MAX;
    private Casilla casillaTractor;
    //ACCIONES
    
    public Tractor(int x,int y){
        this.x = x;
        this.y = y;
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
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
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
                 //imprimirSol(Sol,adyacentes);
                 if(sumaValida(Sol,adyacentes,MAX)){
                     crearListaDistribucion(Sol,adyacentes,MAX);
                     //generarAcciones(crearListaDistribucion(Sol,adyacentes,MAX),adyacentes); 
                 }              
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
            listaSuma.add(sol[i]+adyacentes.get(i).getCantArena());   
                      
        }
        return listaSuma;
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
    public boolean listaValida(ArrayList<Casilla> adyacentes,int MAX){
        for(int i=0;i<adyacentes.size();i++){
            return adyacentes.get(i).getCantArena()>MAX;
        }
        return true;
    }
    
    public void generarAcciones(Distribucion[] listaDist,ArrayList<Casilla> adyacentes,
                                 int[] Sol,int MAX){  
        Accion acciones[] = new Accion[listaDist.length];
        for(int i=0;i<adyacentes.size();i++){
            //crearListaDistribucion(Sol,adyacentes,MAX,adyacentes);
        }       
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
    public void imprimirSol(int [] vector,ArrayList<Casilla> lista){
       System.out.print("[(");          
           for(int j=0;j<vector.length;j++){
                System.out.print(vector[j]+",");
                System.out.print("("+lista.get(j).getFila()+","+lista.get(j).getColumna()+")");
           }
       System.out.print(")]");
       System.out.println();    
   }
    
    public Distribucion[] crearListaDistribucion(int[] cantidades,ArrayList<Casilla> casillas,int MAX){
        Distribucion[] listaDistribucion = new Distribucion[cantidades.length];
        Accion[] listaAcciones = new Accion[cantidades.length];
        System.out.print("[");
        
            for(int i=0;i<cantidades.length;i++){
                //listaSuma.add(sol[i]+adyacentes.get(i).getCantArena());   
                listaDistribucion[i] = new Distribucion(cantidades[i],casillas.get(i));
                //listaAcciones[i] = new Accion(casillas.get(j),listaDistribucion,1);
                //System.out.print(listaDistribucion[i]);//Imprime la lista de distribucion
                System.out.print(listaDistribucion[i]);          
            }
        
             
        System.out.print("]");
        return listaDistribucion;
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
        System.out.println("]");
    }
    
    public void imprimeLista(ArrayList lista){
        System.out.print("[ ");
        for(int i=0;i<lista.size();i++){
            System.out.print(lista.get(i)+ " ");
        }
        System.out.println("] ");
    }
        
        
    public int genAleatorio(int min,int max){
           return (int)(Math.random()*max+min);
    }
        
}
