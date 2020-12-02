
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author carol
 */
public class Principal extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Principal
     */
    private Tablero tablero;
    private JButton bReiniciar;
    private JButton mover;
    private BufferedImage img;
    
    
    public Principal() {
        
        this.initComponents();
        this.myInitComponents();
        this.tablero = new Tablero(this.jpTablero, this.jpInterfaz);
        
        try{
            img = ImageIO.read(new FileInputStream("Images/Jugador.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        
        
    }
    
    public void myInitComponents(){
        this.jpTablero.setLayout(new GridLayout(8,8));
        this.jpInterfaz.setLayout(new FlowLayout());
        this.bReiniciar = new JButton("Reiniciar");
        this.bReiniciar.addActionListener(this);
        this.jpInterfaz.add(this.bReiniciar);
        this.mover = new JButton("Mover");
        this.mover.addActionListener(this);
        this.jpInterfaz.add(this.mover);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpInterfaz = new javax.swing.JPanel();
        jpTablero = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        jButton2.setText("Reiniciar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpInterfazLayout = new javax.swing.GroupLayout(jpInterfaz);
        jpInterfaz.setLayout(jpInterfazLayout);
        jpInterfazLayout.setHorizontalGroup(
            jpInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jpInterfazLayout.setVerticalGroup(
            jpInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpTableroLayout = new javax.swing.GroupLayout(jpTablero);
        jpTablero.setLayout(jpTableroLayout);
        jpTableroLayout.setHorizontalGroup(
            jpTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpTableroLayout.setVerticalGroup(
            jpTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Principal().setVisible(true);
                
            }
            
        }); 
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jpInterfaz;
    private javax.swing.JPanel jpTablero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reiniciar")){
            this.jpTablero.removeAll();
            
            this.tablero = new Tablero(this.jpTablero, this.jpInterfaz);
            
            this.jpTablero.updateUI();
            this.repaint();

        }
        
        if(e.getActionCommand().equals("Mover")){
            this.jugar();
        }
    }
    
    @Override
    public void paint(Graphics g){
       super.paint(g);
        //x=20 y=70
       int x = ((tablero.jugador.getX()-1)*(this.jpTablero.getWidth()/8))+30;
       int y = ((tablero.jugador.getY()-1)*(this.jpTablero.getHeight()/8))+80;
       g.drawImage(this.img,x, y,50,50, null);
    }
    
    public void jugar(){
        
        if(tablero != null){
            int menor = 1000;
            Casilla casMenor = null;
                while(!tablero.ganaste){
                    if(tablero.jugador != null){
                        
                        
                        //busca la casilla optima
                        
                        if(tablero.jugador.der != null && (tablero.jugador.der.getH() + tablero.g) < menor){
                            menor = (tablero.jugador.der.getH() + tablero.g);
                            casMenor = tablero.jugador.der;
                        }
                        if(tablero.jugador.aba != null && (tablero.jugador.aba.getH() + tablero.g) < menor){
                            menor = (tablero.jugador.aba.getH() + tablero.g);
                            casMenor = tablero.jugador.aba;
                        }
                        if(tablero.jugador.izq != null && (tablero.jugador.izq.getH() + tablero.g) < menor){
                            menor = (tablero.jugador.izq.getH() + tablero.g);
                            casMenor = tablero.jugador.izq;
                        }
                        if(tablero.jugador.arr != null && (tablero.jugador.arr.getH() + tablero.g) < menor){
                            menor = (tablero.jugador.arr.getH() + tablero.g);
                            casMenor = tablero.jugador.arr;
                        }

                        tablero.redNeuronal.agregarConexion(casMenor, menor);
                        tablero.jugador = casMenor;
                        if(tablero.jugador != null && tablero.jugador.getTipo() == 5){
                            tablero.ganaste = true;
                        }
                       
                        this.repaint();
                        
                        System.out.println("enttro");
                        menor = 1000;
                        
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
                }
        }   
    
    }
}
