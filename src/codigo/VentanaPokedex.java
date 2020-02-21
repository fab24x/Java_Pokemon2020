/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    static int contador = 0;
    
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    //estructura para guardar todo el contenido de la base de datos de golpe
    HashMap<String, Pokemon> listaPokemons = new HashMap();
    
    
    public void paint(Graphics g){
           super.paintComponents(g);
           Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
           g2.drawImage(buffer1, 0, 0, 
           imagenPokemon.getWidth(), imagenPokemon.getHeight(),
           null);
           
           
    }
    
    
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        Color bgColor = Color.BLACK;
        UIDefaults defaults = new UIDefaults();
        defaults.put("TextPane.background", new ColorUIResource(bgColor));
        defaults.put("TextPane[Enabled].backgroundPainter", bgColor);
        descripcion.putClientProperty("Nimbus.Overrides", defaults);
        descripcion.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        descripcion.setBackground(bgColor);
        
        try {
        imagen1 = ImageIO.read((getClass()
                .getResource("/imagenes/black-white.png")));
        } catch (IOException ex) {    
        }
        
        buffer1 = (BufferedImage) 
                imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
        
       
        
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        
        
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","fabio","");
           estado = conexion.createStatement();
           resultadoConsulta = estado.executeQuery("Select * from pokemon");
           //recoremos el array del resultado duno a uno
           //para ir cargandolo en el Hashmap
           
           while (resultadoConsulta.next()){
               Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString(2);
                p.numPokedex = resultadoConsulta.getString(1);
                p.altura = resultadoConsulta.getString(3);
                p.peso = resultadoConsulta.getString(4);
                p.habitat = resultadoConsulta.getString(6);
                p.especie = resultadoConsulta.getString(5);
                p.descripcionPokemon = resultadoConsulta.getString(16);
                p.tipo1 = resultadoConsulta.getString(7);
                p.tipo2 = resultadoConsulta.getString(8);
                p.habilidad = resultadoConsulta.getString(9);
                p.mov1 = resultadoConsulta.getString(10);
                p.mov2 = resultadoConsulta.getString(11);
                p.mov3 = resultadoConsulta.getString(12);
                p.mov4 = resultadoConsulta.getString(13);
                
                
                listaPokemons.put(resultadoConsulta.getString(1), p);
           }
           informacion(contador);
           
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
    }
    
    public void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        //pinta el fondo del jpanel negro
        g2.setColor(Color.black);      
        g2.fillRect(0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight());
        g2.drawImage(imagen1,
                0,//posicion X inicial dentro del panel
                0,//posicion Y inicial dentro del panel 
                imagenPokemon.getWidth(),//ancho del panel
                imagenPokemon.getHeight(),//alto del panel 
                columna*96,//posicion X inicial dentro de la imagen 
                fila*96,//posicion Y inicial dentro de la imagen
                columna*96 + 96,//posicion X final 
                fila*96 + 96,//posicion Y final 
                null//si no lo pones no va
                );
        repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        der = new javax.swing.JButton();
        izq = new javax.swing.JButton();
        der1 = new javax.swing.JButton();
        izq1 = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();
        numPokedex = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        habitat = new javax.swing.JLabel();
        especie = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        habilidad = new javax.swing.JLabel();
        mov1 = new javax.swing.JLabel();
        mov2 = new javax.swing.JLabel();
        mov3 = new javax.swing.JLabel();
        mov4 = new javax.swing.JLabel();
        negro = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextPane();
        imagenPokemon = new javax.swing.JPanel();
        Interfaz = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        der.setBorderPainted(false);
        der.setContentAreaFilled(false);
        der.setOpaque(false);
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        getContentPane().add(der, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 50, 30));

        izq.setBorderPainted(false);
        izq.setContentAreaFilled(false);
        izq.setOpaque(false);
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 50, 30));

        der1.setBorderPainted(false);
        der1.setContentAreaFilled(false);
        der1.setOpaque(false);
        der1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                der1ActionPerformed(evt);
            }
        });
        getContentPane().add(der1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 50, 10));

        izq1.setBorderPainted(false);
        izq1.setContentAreaFilled(false);
        izq1.setOpaque(false);
        izq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izq1ActionPerformed(evt);
            }
        });
        getContentPane().add(izq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 50, 10));

        nombrePokemon.setBackground(new java.awt.Color(102, 153, 255));
        nombrePokemon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePokemon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombrePokemon.setOpaque(true);
        getContentPane().add(nombrePokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 210, 20));

        numPokedex.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        getContentPane().add(numPokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 50, 50));

        altura.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 80, 10));

        peso.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 80, 20));

        habitat.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(habitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 130, 20));

        especie.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 130, 20));

        tipo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 170, 40));

        habilidad.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(habilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 170, 40));

        mov1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(mov1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 120, 20));

        mov2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(mov2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 120, 20));

        mov3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(mov3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 120, 30));

        mov4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(mov4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 120, 30));

        negro.setBackground(new java.awt.Color(0, 0, 0));
        negro.setForeground(new java.awt.Color(255, 255, 255));
        negro.setOpaque(true);
        getContentPane().add(negro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 300, 70));

        descripcion.setEditable(false);
        descripcion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        descripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 280, 80));

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        getContentPane().add(imagenPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 210, -1));

        Interfaz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex2.jpg"))); // NOI18N
        getContentPane().add(Interfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        
       contador ++;
        if (contador >=150){
            contador = 150;
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        informacion(contador);
        
    }//GEN-LAST:event_derActionPerformed

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador --;
        if (contador <=0){
            contador = 0;
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        informacion(contador);
        
        
        
        
    }//GEN-LAST:event_izqActionPerformed

    private void der1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_der1ActionPerformed
        contador +=15;
        if (contador >=150){
            contador = 150;
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        informacion(contador);
    }//GEN-LAST:event_der1ActionPerformed

    private void izq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izq1ActionPerformed
        contador -=15;
        if (contador <=0){
            contador = 0;
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        informacion(contador);
    }//GEN-LAST:event_izq1ActionPerformed
public void informacion(int _contador) {
        Pokemon p = listaPokemons.get(String.valueOf(_contador + 1));
        if (p != null) {
            nombrePokemon.setText(p.nombre);
            numPokedex.setText(p.numPokedex + "º");
            altura.setText(" Altura: " + p.altura + " m.");
            peso.setText(" Peso: " + p.peso + " Kg.");
            habitat.setText("Habitat: " + p.habitat);
            especie.setText("Especie: " + p.especie);
            descripcion.setText(p.descripcionPokemon);
            if (p.tipo2 != "") {
                tipo.setText("Tipo: " + p.tipo1 + "/" + p.tipo2);
            } else {
                tipo.setText("Tipo: " + p.tipo1);
            }
            habilidad.setText("Habilidad: " + p.habilidad);
            
            mov1.setText(" " + p.mov1);
            mov2.setText(p.mov2);
            mov3.setText(" " + p.mov3);
            mov4.setText(p.mov4);
            
        }
    }
    
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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Interfaz;
    private javax.swing.JLabel altura;
    private javax.swing.JButton der;
    private javax.swing.JButton der1;
    private javax.swing.JTextPane descripcion;
    private javax.swing.JLabel especie;
    private javax.swing.JLabel habilidad;
    private javax.swing.JLabel habitat;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JButton izq1;
    private javax.swing.JLabel mov1;
    private javax.swing.JLabel mov2;
    private javax.swing.JLabel mov3;
    private javax.swing.JLabel mov4;
    private javax.swing.JLabel negro;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JLabel numPokedex;
    private javax.swing.JLabel peso;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
