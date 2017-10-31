package dominio;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Frontera{
    
	private PriorityQueue<Nodo> frontera;
	
	public Frontera(){
		crearFrontera();
	}
        
        public void crearFrontera(){
            this.frontera = new PriorityQueue<Nodo>();
        }
	public PriorityQueue<Nodo> getFrontera() {
		return frontera;
	}
	public void setFrontera(PriorityQueue<Nodo> frontera) {
		this.frontera = frontera;
	}
	
	public void insertar(Nodo nodo){
		this.frontera.offer(nodo);
	}
	/**
	 * Inserta nodos en la PriorityQueue de una lista que contiene los sucesores de un estado
	 * @param list
	 */
	public void insertarLista(LinkedList<Nodo> list){
		
		int longitud = list.size();
                for(int i = 0; i<longitud;i++){
                    this.frontera.offer(list.get(i));
                }
		
	}
	public Nodo eliminar(){
		return this.frontera.poll();
	}
	public boolean esVacia(){
		return this.frontera.isEmpty();
	}
}

