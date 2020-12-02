/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carol
 */
public class RedNeuronal {
    
    Neurona head,apuntadorU,apuntadorPU;
    
    RedNeuronal(Casilla casillaInicial){
    
        head = new Neurona(casillaInicial, casillaInicial.getH());
        apuntadorU = head;
        apuntadorPU = head;
    }
    
    public void agregarConexion(Casilla newCasilla, int f){
    
        if (apuntadorU != null){
            Neurona newNeurona = new Neurona(newCasilla, f);
            apuntadorU.abajo = newNeurona;
            newNeurona.arriba = apuntadorU;
            apuntadorU = apuntadorU.abajo;
            apuntadorPU = newNeurona.arriba;
            if(apuntadorU.casilla != null){
                apuntadorU.casilla.setOptima(true);
                apuntadorU.casilla.setMarcada(true);
            }
            
            
        }
    }
    
    public void quitarConexion(){
    
        if (head != null){
        
            this.apuntadorU.arriba = null;
            this.apuntadorPU.abajo = null;
            
            
            this.apuntadorU.casilla.setOptima(false);
            
            this.apuntadorU =this.apuntadorPU;
            
            if(this.apuntadorPU.arriba != null){
                
                this.apuntadorPU = this.apuntadorPU.arriba;
                
            }
            
        }
    }
}
