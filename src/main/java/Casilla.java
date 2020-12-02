
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carol
 */
public class Casilla {
    public Casilla der,izq,arr,aba;
    //1 = trap, 4 = Milla Jovovich, 3 = fire, 0 = empty, 2 = hunter, 5 = treasure
    private int tipo;
    //g = peso casillas, H = Sumatoria de X y Y
    private int h,f,x,y;
    private int num;
    
    private boolean marcada, peligro , brillo, pintarP,optima;
    
    
    Casilla(boolean whompus, boolean treasure, int x, int y){
        //adyacentes
        this.der = null;
        this.izq = null;
        this.arr = null;
        this.aba = null;
        //random num
        Random rand = new Random();
        tipo = rand.nextInt(45);
        //pregunta si ya existe un whompus o un tesoro
        if(tipo > 5 || (tipo == 4 && whompus) || (tipo == 5 && treasure)){
         tipo = 0;
        }
        
        this.marcada = false;
        this.optima = false;
        
        this.peligro = false;
        this.pintarP = false;
       
        this.brillo = false;
        
        this.x = x;
        this.y = y;
        
        this.f = -1;
        //System.out.println("tipo: " + tipo);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

    

    public boolean isBrillo() {
        return brillo;
    }

    public void setBrillo(boolean brillo) {
        this.brillo = brillo;
    }

    public boolean isPeligro() {
        return peligro;
    }

    public void setPeligro(boolean peligro) {
        this.peligro = peligro;
    }

 
    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public boolean isPintarP() {
        return pintarP;
    }

    public void setPintarP(boolean pintarP) {
        this.pintarP = pintarP;
    }

    public boolean isOptima() {
        return optima;
    }

    public void setOptima(boolean optima) {
        this.optima = optima;
    }
    
    

    @Override
    public String toString() {
        return "Casilla{" + "der=" + der + ", izq=" + izq + ", arr=" + arr + ", aba=" + aba + ", tipo=" + tipo + ", h=" + h + ", f=" + f + ", num=" + num + ", marcada=" + marcada + ", peligro=" + peligro + ", brillo=" + brillo + '}';
    }
    
    
    
}
