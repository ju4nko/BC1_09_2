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
    
    
}
