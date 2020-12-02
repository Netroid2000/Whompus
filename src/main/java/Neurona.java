/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carol
 */

//guarda el camino optimo
public class Neurona {
    public Casilla casilla;
    public Neurona abajo,arriba;
    public int f;
    
    Neurona(Casilla casilla, int f){
        
        this.casilla = casilla;
        this.abajo = null;
        this.arriba = null;
        this.f = f;
    
    }
    
}
