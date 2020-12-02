
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carol
 */
public class Tablero {
    public Casilla apuntador,apuntadorSup,apuntadorIni,head, jugador, aputadorT;
    public boolean whompus = false, treasure = false, ganaste;
    public int vidas,g;
    public RedNeuronal redNeuronal;
    
    Tablero(JPanel tablero, JPanel interfaz){
        
        this.crearTablero(tablero);
        this.ponerPistas();
        this.imprimirTablero();
        this.setJugador();
        this.asignarH();
        this.imprimirTablero();
       
        vidas = 5;
        g = 0;
        this.ganaste = false;
        
    }
    
    public void crearTablero(JPanel tablero){
        //asegrarse de que el mapa contenga un monstruo y un tesoro
        while(!whompus || !treasure){
            int x = 1;
            int y = 1;
            head = null;
            whompus = false;
            treasure = false;
            tablero.removeAll();

            while(y <= 8){
                if(head == null){
                    head = new Casilla(whompus, treasure,x,y);
                    System.out.println("x:"+head.getX()+" y:"+head.getY());
                    ponerIcono(head,tablero);
                    
                    apuntador = head;
                    apuntadorSup = head;
                    apuntadorIni = head;
                     x++;
                }else{
                    while(x <= 8){
                       if(apuntador != null){
                           Casilla newCasilla = new Casilla(whompus, treasure,x,y);
                           System.out.println("x:"+newCasilla.getX()+" y:"+newCasilla.getY());
                           ponerIcono(newCasilla,tablero);
                           apuntador.der = newCasilla;
                           newCasilla.izq = apuntador;
                           if(y > 1 && apuntadorSup != null){
                               newCasilla.arr = apuntadorSup;
                               apuntadorSup.aba = newCasilla;
                               apuntadorSup = apuntadorSup.der;
                           }
                           apuntador = apuntador.der;

                           //marcar si  ya creo al whompus o el tesoro
                           if(newCasilla.getTipo() == 4){
                               whompus = true;
                           }
                           if(newCasilla.getTipo() == 5){
                               treasure = true;
                               this.aputadorT = newCasilla;
                           }
                       }
                       x++;
                    }

                    x = 1;
                    y++;
                    if(y <= 8){
                        
                        Casilla newCasilla = new Casilla(whompus, treasure,x,y);
                        System.out.println("x:"+newCasilla.getX()+" y:"+newCasilla.getY());
                        ponerIcono(newCasilla,tablero);
                        apuntadorIni.aba = newCasilla;
                        newCasilla.arr = apuntadorIni;
                        apuntador = apuntadorIni.aba;
                        apuntadorIni = apuntador;
                        apuntadorSup = apuntador.arr;
                        apuntadorSup = apuntadorSup.der;

                        //marcar siya creo al whompus o el tesoro
                        if(newCasilla.getTipo() == 4){
                               whompus = true;
                        }
                        if(newCasilla.getTipo() == 5){
                            treasure = true;
                            this.aputadorT = newCasilla;
                        }
                        x++;
                        
                    }
                    
                    
                        
                }  
            } 
            System.out.println("ACABOOOOOOOOOOOOOOOOO");
        }
        
    }
    //asigana las pistas al rededor de las casillas que contengan un ente
    public void ponerPistas(){
        if(head != null){
            apuntadorIni = head;
            apuntador = head;
            
            while(apuntadorIni != null){
                while(apuntador != null){
                    
                    if(apuntador.getTipo() == 0){
                        for(int x = 0; x < 4; x++){

                            if(apuntador.der != null && apuntador.der.getTipo() > 0 && apuntador.der.getTipo() < 5){
                                apuntador.setPeligro(true);
                            }else if(apuntador.aba != null && apuntador.aba.getTipo() > 0 && apuntador.aba.getTipo() < 5){
                                apuntador.setPeligro(true);
                            }else if(apuntador.izq != null && apuntador.izq.getTipo() > 0 && apuntador.izq.getTipo() < 5){
                                apuntador.setPeligro(true);
                            }else if(apuntador.arr != null && apuntador.arr.getTipo() > 0 && apuntador.arr.getTipo() < 5){
                                apuntador.setPeligro(true);
                            }

                        }
                    }
                    
                    apuntador = apuntador.der;
                }
                
                apuntador = apuntadorIni.aba;
                apuntadorIni = apuntador;
            }
        }
    }
    
    public void setJugador(){
        boolean fin = false;
        Random rand = new Random();
        
        if(head != null){
            while(!fin){
                apuntadorIni = head;
                apuntador = head;

                while(apuntadorIni != null){
                    while(apuntador != null){
                        if(apuntador.getTipo() == 0 && !apuntador.isPeligro() && !fin){
                            int random = rand.nextInt(40);
                            if(random >= 0 && random < 5){
                                jugador = apuntador;
                                this.redNeuronal = new RedNeuronal(this.jugador);
                                fin = true;
                            }
                        }
                        
                        apuntador = apuntador.der;
                    }
                    
                    apuntador = apuntadorIni.aba;
                    apuntadorIni = apuntador;
                }
            }
        }
    }
    
    public void ponerIcono(Casilla newCasilla, JPanel tablero){
        if(newCasilla.getTipo() != 0 ){
            String url = "Images/"+newCasilla.getTipo()+".png";
            ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            JLabel label =new JLabel(icon, JLabel.CENTER);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            label.setBorder(border);
            tablero.add(label);
        }else{
            JLabel label =new JLabel();
            label.setBackground(Color.DARK_GRAY);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            label.setBorder(border);
            tablero.add(label);
        }
    }
    
    public void asignarH(){
       apuntadorIni = head;
       
       while(apuntadorIni != null){
           apuntador = apuntadorIni;
           while(apuntador != null){
               
               if(this.aputadorT != null){
                   //asiganar la eholistica
                   int res = Math.abs(this.apuntador.getX() - this.aputadorT.getX()) + Math.abs(this.apuntador.getY() - this.aputadorT.getY());
                   this.apuntador.setH(res);
                   System.out.println("H = " + res);
               }
               apuntador = apuntador.der;
           }
           System.out.println("");
           apuntadorIni = apuntadorIni.aba;
       }
       
    }
    
    public void imprimirTablero(){
       apuntadorIni = head;
       
       while(apuntadorIni != null){
           apuntador = apuntadorIni;
           while(apuntador != null){
               if(apuntador.equals(this.jugador)){
                   System.out.print("J ");
               }else if(apuntador.isPeligro()){
                   System.out.print("P ");
               }else{
                   System.out.print(apuntador.getTipo() + " ");
               }
               
               apuntador = apuntador.der;
           }
           System.out.println("");
           apuntadorIni = apuntadorIni.aba;
       }
       
       System.out.println("vacio  = 0  agujero = 1" + "\n"+
                          "fuego  = 3  whompus = 4" + "\n"+
                          "tesoro = 5  vidas = "+this.vidas + "\n"+
                          "casilla peligrosa = P"+ "\n"+
                          "jugador = J");
    }
}
