package dominio;


public class Sucesor {

	private Accion accion;
	private Estado estado;
	private int coste;
	public Sucesor(Accion accion, Estado padre, int nuevo_coste){
		this.accion = accion;
		this.coste = 0;
		//this.nuevo_coste = padre.Costo(accion);
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
