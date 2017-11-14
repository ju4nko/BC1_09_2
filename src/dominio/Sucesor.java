package dominio;


public class Sucesor {

	private Accion accion;
	private Estado estado;
	private int coste;
	public Sucesor(Accion accion, Estado padre, int k_objetivo){
		this.accion = accion;
		this.coste = 0;
		//generarEstadoSucesor(padre, k_objetivo);
	}
	///////////////////////
	////Metodos Get-Set////
	///////////////////////
	public Accion getAccion(){
		return accion;
	}
	public Estado getEstado(){
		return estado;
	}
	public int getCoste(){
		return coste;
	}
	public void setAccion(Accion accion){
		this.accion = accion;
	}
	public void setEstado(Estado estado){
		this.estado = estado;
	}
	public void setCoste(int coste){
		this.coste = coste;
	}
	@Override
	public String toString(){
		return ">"+accion+"\n>"+estado+"\n>"+coste;
	}
	
	
}
