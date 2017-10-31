package dominio;

public class Estado {
        private Accion accion;
	private Terreno terreno;
	private int costo;
	
	public Estado(Accion accion,Terreno terreno, int costo){
		this.accion = accion;
                this.terreno = terreno;
                this.costo = costo;
	}
	
}
