/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author juanjo
 */
public class Accion {
    private Casilla destinoTractor;
    private Distribucion listaDistribucion[];
    private int coste;
    
    public Accion(Casilla destinoTractor,Distribucion listaDistribucion[]
                    ,int coste){
        this.destinoTractor = destinoTractor;
        this.listaDistribucion = listaDistribucion;
        this.coste = coste;
    }
    @Override
    public String toString(){
        String cadena = "";
        cadena+="[";
        for(int i=0;i<listaDistribucion.length;i++){
            cadena+="("+destinoTractor.getFila()+","+destinoTractor.getColumna()+")"+listaDistribucion[i]+" ,"+coste;
        }
        cadena+="]";
        return cadena;
    }
    
    
    public static void main(String[] args){
        Casilla destino = new Casilla(1,0,6);
        Casilla c1 = new Casilla(0,0,3);
        Casilla c2 = new Casilla(0,0,5);
        //Distribucion d1 = new Distribucion();
        //ListaDistribucion();
        //new Accion(destino,);
    }
}
