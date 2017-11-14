package dominio;

import java.util.ArrayList;

public class Estado {
        private Distribucion accion;
	private Terreno terreno;
	private int costo;
	
	public Estado(Distribucion accion,Terreno terreno, int costo){
		this.accion = accion;
                this.terreno = terreno;
                this.costo = costo;
	}
        
        public Terreno getTerreno(){
            return terreno;
        }
        
        public int Costo(ArrayList<Distribucion> accion){
            int suma = 0;
            for(int i=0;i<accion.size();i++){
                suma+=accion.get(i).getCantidad()+1;
            }
            return suma;
        }
	
}
