/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author juanjo
 */
public class Problema {
    private EspacioEstados espacioEstados;
    private Estado estadoInicial;
    
    public Problema(EspacioEstados espacioEstados,Estado estadoInicial){
        this.espacioEstados = espacioEstados;
        this.estadoInicial = estadoInicial;
    }
    
    public Problema(Estado estadoInicial){
        this.estadoInicial= estadoInicial;
    }
    
     public boolean esObjetivo(Estado estado){
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
    
    public Estado estadoInicial(){
        return estadoInicial;
    }
    
    public EspacioEstados getEspacioEstados(){
        return espacioEstados;
    }
    public LinkedList<Nodo> crearListaNodos(ArrayList<Distribucion> ls,Nodo n_actual,int prof_maxima,String estrategia){
        String opcion = "";
        int valor = 0;
        
        LinkedList<Nodo> listaNodos = new LinkedList<Nodo>();
        for(int i=0;i<ls.size();i++){
            switch(opcion){
                case "anchura":
                    valor = n_actual.getProfundidad()+1;
                    break;
                case "costeUniforme":
                    valor = n_actual.getCosto();
                    break;
                case "profundidad":
                    valor=(1/n_actual.getProfundidad()+1);  
                    break;
            }
            if(n_actual.getProfundidad()<prof_maxima){
                //listaNodos.add(new Nodo(n_actual,estado,estado.Costo(ls),accion,valor,n_actual.getProfundidad()+1));
            }
        }
        
        return listaNodos;
    }
    
    public LinkedList<Nodo> crearSolucion(Nodo n_actual){
        LinkedList<Nodo> listaSolucion = new LinkedList<Nodo>();
        listaSolucion.add(n_actual);
        Nodo nodo = n_actual.getPadre();
        while(nodo.getPadre()!=null){
            listaSolucion.add(nodo);
            nodo = nodo.getPadre();
            listaSolucion.add(nodo);
        }
        
        return listaSolucion;
        
    }
    
     
     public LinkedList<Nodo> busquedaAcotada(Problema problema,String estrategia,int prof_max){
        //Inicialización
        Nodo n_actual;
        ArrayList<Distribucion> LS = new ArrayList<Distribucion>();
        LinkedList<Nodo> LN = new LinkedList<Nodo>();
        
        Frontera frontera = new Frontera();
        frontera.crearFrontera();
        Nodo n_inicial = new Nodo(null,problema.estadoInicial(),0,null,0,0);
        frontera.insertar(n_inicial);
        boolean solucion = false;
        n_actual = n_inicial;
        
        while(!solucion && !frontera.esVacia() ){
            n_actual= frontera.eliminar();
            if(problema.esObjetivo(n_actual.getEstado())){
                solucion = true;
            }else{
                LS = problema.getEspacioEstados().listaSucesores;
                LN = problema.crearListaNodos(LS, n_actual, prof_max, estrategia);
                frontera.insertarLista(LN);
            }
            
        }
        if(solucion==true){
            return problema.crearSolucion(n_actual);
        }else{
            return null;
        }
    }
     
     public LinkedList<Nodo> busquedaA(Problema problema,String estrategia,int prof_max,int inc_prof){
         int prof_actual = inc_prof;
         LinkedList<Nodo> ListaSolucion = null;
         while(ListaSolucion==null && (prof_actual<=prof_max)){
             ListaSolucion = busquedaAcotada(problema,estrategia,prof_actual);
             prof_actual=prof_actual+inc_prof;
         }
         return ListaSolucion;
     }
    
    
}
