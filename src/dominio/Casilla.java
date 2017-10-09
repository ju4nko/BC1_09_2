package dominio;

/**
 *
 * @author Juan José, Guillermo y Raquel
 */
public class Casilla {
    // Atributos
    private int fila,columna;
    private boolean visitado;
    private int cant_arena;
    private int MAX;
    
    // Constructor
    public Casilla(int fila,int columna){
        this.fila=fila;
        this.columna=columna;
        this.visitado=false;
        this.MAX = 8;
        this.cant_arena=genAleatorioArena(0,MAX);
    }

    // Devolver una fila
    public int getFila() {
        return fila;
    }

    // Poner una valor fila
    public void setFila(int fila) {
        this.fila = fila;
    }

    // Devolver una columna
    public int getColumna() {
        return columna;
    }
    public int getCantArena(){
        return cant_arena;
    }
    public void setCantArena(int cant_arena){
        this.cant_arena=cant_arena;
    }

    // Poner una valor columna
    public void setColumna(int columna) {
        this.columna = columna;
    }

    // Devolver si una casilla esta Visitada
    public boolean isVisitado() {
        return visitado;
    }

    // Poner una casilla a visitado true o false
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    // Metodo que comprueba si hay comunicación en diagonal entre dos casillas
    public boolean existeCamino(Casilla casilla){
        return((casilla.getColumna()+casilla.getFila())%2 == (getColumna()+getFila())%2);
    }
    
    // Devuelve la distancia Manhattan entre dos casillas
    public int distanciaM(Casilla c) {
        return Math.max(Math.abs(getFila()-c.getFila()),Math.abs(getColumna()-c.getColumna()));
    }
    
    // Compara dos objetos casilla
    @Override
    public boolean equals(Object obj) {
        Casilla c=(Casilla) obj;
        if(getColumna()==c.getColumna() && getFila()==c.getFila()){
            return true;
        }
        return false;
    }
    public int genAleatorioArena(int min,int max){
        return (int)(Math.random()*max+min);
    }

    // Muestra las coordenadas de una casilla
    @Override
    public String toString() {
        return "(" + getFila() + "," + getColumna() + ')';
    }   
}
