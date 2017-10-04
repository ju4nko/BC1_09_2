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
public class Tractor {
    //Coordenadas del tractor
    private int x;
    private int y;
    //ACCIONES
    public void moverTractor(){
        // Mover el tractor N,S,E,O
    }
    public void distribuirTractor(int cantidad){
        // Distribuir arena de una casilla
    }
      
    private int[] moverN(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		if(y<=terreno.length && y!=0){
			newPos[0]=x;
			newPos[1]=y-1;
		}
		return newPos;
	}
	
    
	private int[] moverS(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		if(y<=terreno.length && y!=terreno.length){
			newPos[0]=x;
			newPos[1]=y+1;
		}
		return newPos;
	}
	
	
	private int[] moverE(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		if(y<=terreno.length && y!=terreno.length){
			newPos[0]=x+1;
			newPos[1]=y;
		}
		return newPos;
	}
	
	
	private int[] moverO(int x, int y,int [][] terreno){
		int[] newPos=new int[2];
		if(x<=terreno.length && x!=0){
			newPos[0]=x-1;
			newPos[1]=y;
		}
		return newPos;
	}
}
