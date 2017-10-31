package dominio;

public class Nodo {

	private Nodo padre;
	private Estado estado; 
	private int costo; 
	private Accion accion; 
	private int valor; 
	
	public Nodo(Nodo padre, Estado estado, int costo, Accion accion, int valor, int profundidad){
		this.padre = padre;
		this.estado = estado;
		this.costo = costo;
		this.accion = accion;
		this.valor = valor;
	}
	
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public Accion getAccion() {
		return accion;
	}
	public void setAccion(Accion accion) {
		this.accion = accion;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * Comparacion de los nodos en la estructura
	 * @param nodo
	 * @return
	 */
	public int compareTo(Nodo nodo){
		int r = 0;
        if (nodo.getValor() < getValor())
            r = 1;
        else if(nodo.getValor() > getValor())
        	r = -1;
        
        return r;
    }
	@Override
	public String toString() {
		return "Nodo [Padre=" + getPadre() + ", Estado=" + getEstado() + ", Costo=" + getCosto() 
		+ ", Accion=" + getAccion() + ", Valor=" + getValor() + "]";
	}
}
