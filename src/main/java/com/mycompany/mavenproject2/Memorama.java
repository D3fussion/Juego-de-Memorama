package com.mycompany.mavenproject2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Diego
 */
public class Memorama extends javax.swing.JFrame {
    int valor1 = 99;
    int valor2 = 99;
    int valor21 = 99;
    int valor22 = 99;
    int score = 0;
    int movimientos = 0;
    int numeroE;
    int scoreMax;
    int pDC = 99;
    
    ImageIcon a00; //Imagen inicial
    ImageIcon a0; //El numero depende del numero que le toque a cada jlabel
    ImageIcon fondo;
    
    /**
     * Creates new form Memorama
     */
    public Memorama() {
        initComponents();
        cargarImagenes();
        numeroDeCartas();
        setLocationRelativeTo(null);
        establecerValoresAleatorios();
    }
    
    void numeroDeCartas(){
        String[] eleccion = {"6", "12", "20"};
        int n;
        while (true) {
            try{
            n = JOptionPane.showOptionDialog(null,
                    "Antes de iniciar\n¿Cuantas cartas quieres que tenga el juego?",
                    "Elige",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    eleccion,
                    eleccion[0]);
                    numeroE = Integer.parseInt(eleccion[n]);
                    scoreMax = numeroE/2;
            if(JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "¿Seguro?",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) break;
            } catch (Exception e) {JOptionPane.showMessageDialog(null, "Antes de salir debes elegir una opcion","Advertencia",1); }
        }
    }
    
    void cargarImagenes(){
        a00 = new javax.swing.ImageIcon(getClass().getResource("/00.jpg"));
        jLabel3.setIcon(a00);
        jLabel4.setIcon(a00);
        jLabel5.setIcon(a00);
        jLabel6.setIcon(a00);
        jLabel7.setIcon(a00);
        jLabel8.setIcon(a00);
        jLabel9.setIcon(a00);
        jLabel10.setIcon(a00);
        jLabel11.setIcon(a00);
        jLabel12.setIcon(a00);
        jLabel13.setIcon(a00);
        jLabel14.setIcon(a00);
        jLabel15.setIcon(a00);
        jLabel16.setIcon(a00);
        jLabel17.setIcon(a00);
        jLabel18.setIcon(a00);
        jLabel19.setIcon(a00);
        jLabel20.setIcon(a00);
        jLabel21.setIcon(a00);
        jLabel22.setIcon(a00);
    }
    
    void informacion(){
        switch (valor1){
            case 0: {
                jTextArea1.setText("General Winfield Scott\nGeneral al mando de las fuerzas estadounidenses que realizaron un intenso asalto al castillo de Chapultepec.");
                break;
            }
            case 1: {
                jTextArea1.setText("Castillo de Chapultepec\nSimbolo de la resistencia y el nacionalismo mexicano, y una posicion defensiva naturalmente ventajosa, fue donde se dio la batalla culminante de la invasion estadounidense a Mexico.");
                break;
            }
            case 2: {
                jTextArea1.setText("Juan de la Barrera (Niño heroe)\nNacido el 23 de diciembre de 1828, fue uno de los primeros cadetes en unirse a la resistencia en Chapultepec. Murió durante la batalla, luchando valientemente contra las tropas estadounidenses.");
                break;
            }
            case 3: {
                jTextArea1.setText("Juan Escutia (Niño heroe)\nNacido en 1827, según la leyenda, en lugar de rendirse o ser capturado por los estadounidenses, se envolvió en la bandera mexicana y se arrojó desde lo alto de Chapultepec para evitar su profanación.");
                break;
            }
            case 4: {
                jTextArea1.setText("Francisco Márquez (Niño heroe)\nNacido en 1834, fue uno de los defensores más jóvenes del castillo. Se cree que murió durante la batalla, pero su participación exacta no está completamente documentada.");
                break;
            }
            case 5: {
                jTextArea1.setText("Agustin Melgar (Niño heroe)\nNacido en 1828, participo activamente en la defensa de Chapultepec y murio durante la batalla. Se le atribuye haber mostrado valentia y coraje.");
                break;
            }
            case 6: {
                jTextArea1.setText("Fernando Montes de Oca (Niño heroe)\nNacido en 1832, defendió el castillo y murio en combate. Se dice que su cuerpo fue utilizado para bloquear una entrada al castillo, impidiendo el avance de las tropas invasoras.");
                break;
            }
            case 7: {
                jTextArea1.setText("Vicente Suarez (Niño heroe)\nNacido en 1834, participo en la defensa de Chapultepec y murio durante la batalla. Al igual que Marquez, su participación exacta no esta completamente documentada.");
                break;
            }
            case 8: {
                jTextArea1.setText("Tratado de Guadalupe Hidalgo\n Este tratado establecio los terminos de paz entre los dos paises, donde Mexico cedia más de la mitad de su territorio original.");
                break;
            }
            case 9: {
                jTextArea1.setText("Antonio Lopez de Santa Anna\nAsumio el liderazgo del ejército mexicano y participo en varias batallas. Tuvo algunas victorias iniciales, pero sufrio derrotas significativas y fue criticado por su manejo de la guerra.");
                break;
            }
        }
    }
    
    void reiniciar(boolean gano){
        score = 0;
        valor1 = 99;
        valor2 = 99;
        valor21 = 99;
        valor22 = 99;
        pDC = 99;
        setVisible(false);
        if(gano){
        if (JOptionPane.showConfirmDialog(null, "Lo lograste! Lo hiciste en " + movimientos + " movimientos\n¿Quieres intentarlo de nuevo?", "Ganaste!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            numeroDeCartas();
            establecerValoresAleatorios();
            habilitarTodasTarjetas();
            movimientos = 0;
            jTextArea1.setText("");
            jTextField21.setText("");
            setVisible(true);
        } else {
            dispose();
        }
        } else {
            numeroDeCartas();
            establecerValoresAleatorios();
            habilitarTodasTarjetas();
            movimientos = 0;
            jTextArea1.setText("");
            jTextField21.setText("");
            setVisible(true);
        }
    }
    
    void habilitarTodasTarjetas(){
        cargarImagenes();
        jLabel3.setEnabled(true);
        jLabel4.setEnabled(true);
        jLabel5.setEnabled(true);
        jLabel6.setEnabled(true);
        jLabel7.setEnabled(true);
        jLabel8.setEnabled(true);
        jLabel9.setEnabled(true);
        jLabel10.setEnabled(true);
        jLabel11.setEnabled(true);
        jLabel12.setEnabled(true);
        jLabel13.setEnabled(true);
        jLabel14.setEnabled(true);
        jLabel15.setEnabled(true);
        jLabel16.setEnabled(true);
        jLabel17.setEnabled(true);
        jLabel18.setEnabled(true);
        jLabel19.setEnabled(true);
        jLabel20.setEnabled(true);
        jLabel21.setEnabled(true);
        jLabel22.setEnabled(true);
    }
    
    void habilitarTarjetas(boolean v){
        for (int i = 0; i < 2; i++) {
            int x;
            if(i == 0) x = valor21;
            else x = valor22;
        switch (x) {
            case 0: {
                if(!v) jLabel3.setEnabled(false);
                else jLabel3.setIcon(a00);
                break;
            }
            case 1: {
                if(!v) jLabel4.setEnabled(false);
                else jLabel4.setIcon(a00);
                break;
            }
            case 2: {
                if(!v) jLabel5.setEnabled(false);
                else jLabel5.setIcon(a00);
                break;
            }
            case 3: {
                if(!v) jLabel6.setEnabled(false);
                else jLabel6.setIcon(a00);
                break;
            }
            case 4: {
                if(!v) jLabel7.setEnabled(false);
                else jLabel7.setIcon(a00);
                break;
            }
            case 5: {
                if(!v) jLabel8.setEnabled(false);
                else jLabel8.setIcon(a00);
                break;
            }
            case 6: {
                if(!v) jLabel9.setEnabled(false);
                else jLabel9.setIcon(a00);
                break;
            }
            case 7: {
                if(!v) jLabel10.setEnabled(false);
                else jLabel10.setIcon(a00);
                break;
            }
            case 8: {
                if(!v) jLabel11.setEnabled(false);
                else jLabel11.setIcon(a00);
                break;
            }
            case 9: {
                if(!v) jLabel12.setEnabled(false);
                else jLabel12.setIcon(a00);
                break;
            }
            case 10: {
                if(!v) jLabel13.setEnabled(false);
                else jLabel13.setIcon(a00);
                break;
            }
            case 11: {
                if(!v) jLabel14.setEnabled(false);
                else jLabel14.setIcon(a00);
                break;
            }
            case 12: {
                if(!v) jLabel15.setEnabled(false);
                else jLabel15.setIcon(a00);
                break;
            }
            case 13: {
                if(!v) jLabel16.setEnabled(false);
                else jLabel16.setIcon(a00);
                break;
            }
            case 14: {
                if(!v) jLabel17.setEnabled(false);
                else jLabel17.setIcon(a00);
                break;
            }
            case 15: {
                if(!v) jLabel18.setEnabled(false);
                else jLabel18.setIcon(a00);
                break;
            }
            case 16: {
                if(!v) jLabel19.setEnabled(false);
                else jLabel19.setIcon(a00);
                break;
            }
            case 17: {
                if(!v) jLabel20.setEnabled(false);
                else jLabel20.setIcon(a00);
                break;
            }
            case 18: {
                if(!v) jLabel21.setEnabled(false);
                else jLabel21.setIcon(a00);
                break;
            }
            case 19: {
                if(!v) jLabel22.setEnabled(false);
                else jLabel22.setIcon(a00);
                break;
            }
        }
        }
    }
    
    
    void establecerValoresAleatorios() {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < numeroE; i++) {
            myList.add(i);
        }
        
        int eleccion = 0;
        int rando; Integer texto;
        int divi = numeroE/2;
        int divi2 = divi - 1;
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel9.setName(texto+"");
        myList.remove(rando);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel10.setName(texto+"");
        myList.remove(rando);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel11.setName(texto+"");
        myList.remove(rando);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel13.setName(texto+"");
        myList.remove(rando);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel15.setName(texto+"");
        myList.remove(rando);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel17.setName(texto+"");
        myList.remove(rando);
        
        if(numeroE>=12){
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel4.setName(texto+"");
        myList.remove(rando);
        jLabel4.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel5.setName(texto+"");
        myList.remove(rando);
        jLabel5.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel7.setName(texto+"");
        myList.remove(rando);
        jLabel7.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel19.setName(texto+"");
        myList.remove(rando);
        jLabel19.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel20.setName(texto+"");
        myList.remove(rando);
        jLabel20.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel21.setName(texto+"");
        myList.remove(rando);
        jLabel21.setVisible(true);
        
        if(numeroE==20){
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel3.setName(texto+"");
        myList.remove(rando);
        jLabel3.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel8.setName(texto+"");
        myList.remove(rando);
        jLabel8.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel16.setName(texto+"");
        myList.remove(rando);
        jLabel16.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel22.setName(texto+"");
        myList.remove(rando);
        jLabel22.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel6.setName(texto+"");
        myList.remove(rando);
        jLabel6.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel12.setName(texto+"");
        myList.remove(rando);
        jLabel12.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel14.setName(texto+"");
        myList.remove(rando);
        jLabel14.setVisible(true);
        
        rando = (int) ((Math.random() * myList.size()));
        texto = myList.get(rando);
        if(texto>divi2) texto = texto - divi; 
        jLabel18.setName(texto+"");
        myList.remove(rando);
        jLabel18.setVisible(true);
        
        } else eleccion = 2;
        } else eleccion = 1; 
        if(eleccion == 1 || eleccion == 2) {
            jLabel3.setVisible(false);
            jLabel8.setVisible(false);
            jLabel16.setVisible(false);
            jLabel22.setVisible(false);
            jLabel6.setVisible(false);
            jLabel12.setVisible(false);
            jLabel14.setVisible(false);
            jLabel18.setVisible(false);
            if(eleccion == 1){
                jLabel4.setVisible(false);
                jLabel7.setVisible(false);
                jLabel5.setVisible(false);
                jLabel20.setVisible(false);
                jLabel21.setVisible(false);
                jLabel19.setVisible(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Memorama");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Small", 0, 23)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Memorama de la Batalla de Chapultepec");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 486, 47));

        jTextField21.setEditable(false);
        getContentPane().add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 622, 90, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Movimientos");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 596, 90, 20));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 90, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 577, 282, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel3.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel3.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel4.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 59, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel5.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel5.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 59, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel6.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel6.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 59, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel7.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 59, -1, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel8.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel8.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 185, -1, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel9.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel9.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 185, -1, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel10.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel10.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 185, -1, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel11.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel11.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 185, -1, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel12.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel12.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel12.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 185, -1, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel13.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel13.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel13.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 311, -1, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel14.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel14.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel14.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 311, -1, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel15.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel15.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 311, -1, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel16.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel16.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel16.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 311, -1, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel17.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel17.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 311, -1, -1));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel18.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel18.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 437, -1, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel19.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel19.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 437, -1, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel20.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel20.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel20.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 437, -1, -1));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel21.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel21.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel21.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 437, -1, -1));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel22.setMaximumSize(new java.awt.Dimension(90, 120));
        jLabel22.setMinimumSize(new java.awt.Dimension(90, 120));
        jLabel22.setPreferredSize(new java.awt.Dimension(90, 120));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 437, -1, -1));

        jButton2.setText("Cambiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 590, 80, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ladrillo.jpg"))); // NOI18N
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?\nSolamente te faltan "+(numeroE/2 - score)+" pares para ganar", "Advertencia",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if(pDC != 0) {
        pDC=0;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel3.getName()+".jpg"));
        jLabel3.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel3.getName());
            valor21 = 0; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel3.getName());
            valor22 = 0; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if(pDC != 1) {
        pDC=1;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel4.getName()+".jpg"));
        jLabel4.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel4.getName());
            valor21 = 1; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel4.getName());
            valor22 = 1; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if(pDC != 4) {
        pDC=4;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel7.getName()+".jpg"));
        jLabel7.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel7.getName());
            valor21 = 4; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel7.getName());
            valor22 = 4; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if(pDC != 2) {
        pDC=2;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel5.getName()+".jpg"));
        jLabel5.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel5.getName());
            valor21 = 2; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel5.getName());
            valor22 = 2; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if(pDC != 3) {
        pDC=3;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel6.getName()+".jpg"));
        jLabel6.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel6.getName());
            valor21 = 3; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel6.getName());
            valor22 = 3; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if(pDC != 5) {
        pDC=5;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel8.getName()+".jpg"));
        jLabel8.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel8.getName());
            valor21 = 5; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel8.getName());
            valor22 = 5; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if(pDC != 6) {
        pDC=6;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel9.getName()+".jpg"));
        jLabel9.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel9.getName());
            valor21 = 6; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel9.getName());
            valor22 = 6; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if(pDC != 7) {
        pDC=7;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel10.getName()+".jpg"));
        jLabel10.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel10.getName());
            valor21 = 7; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel10.getName());
            valor22 = 7; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        if(pDC != 8) {
        pDC=8;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel11.getName()+".jpg"));
        jLabel11.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel11.getName());
            valor21 = 8; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel11.getName());
            valor22 = 8; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if(pDC != 9) {
        pDC=9;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel12.getName()+".jpg"));
        jLabel12.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel12.getName());
            valor21 = 9; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel12.getName());
            valor22 = 9; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        if(pDC != 13) {
        pDC=13;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel16.getName()+".jpg"));
        jLabel16.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel16.getName());
            valor21 = 13; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel16.getName());
            valor22 = 13; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if(pDC != 10) {
        pDC=10;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel13.getName()+".jpg"));
        jLabel13.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel13.getName());
            valor21 = 10; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel13.getName());
            valor22 = 10; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        if(pDC != 12) {
        pDC=12;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel15.getName()+".jpg"));
        jLabel15.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel15.getName());
            valor21 = 12; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel15.getName());
            valor22 = 12; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        if(pDC != 14) {
        pDC=14;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel17.getName()+".jpg"));
        jLabel17.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel17.getName());
            valor21 = 14; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel17.getName());
            valor22 = 14; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        if(pDC != 11) {
        pDC=11;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel14.getName()+".jpg"));
        jLabel14.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel14.getName());
            valor21 = 11; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel14.getName());
            valor22 = 11; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        if(pDC != 19) {
        pDC=19;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel22.getName()+".jpg"));
        jLabel22.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel22.getName());
            valor21 = 19; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel22.getName());
            valor22 = 19; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        if(pDC != 17) {
        pDC=17;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel20.getName()+".jpg"));
        jLabel20.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel20.getName());
            valor21 = 17; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel20.getName());
            valor22 = 17; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        if(pDC != 18) {
        pDC=18;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel21.getName()+".jpg"));
        jLabel21.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel21.getName());
            valor21 = 18; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel21.getName());
            valor22 = 18; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        if(pDC != 16) {
        pDC=16;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel19.getName()+".jpg"));
        jLabel19.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel19.getName());
            valor21 = 16; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel19.getName());
            valor22 = 16; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        if(pDC != 15) {
        pDC=15;
        a0 = new javax.swing.ImageIcon(getClass().getResource("/" + jLabel18.getName()+".jpg"));
        jLabel18.setIcon(a0); // cambiar
        movimientos++;
        jTextField21.setText(movimientos + "");
        ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(valor1 == 99)  {
            valor1 = Integer.parseInt(jLabel18.getName());
            valor21 = 15; //Depende del numero del jLabel
        }
        else {
            valor2 = Integer.parseInt(jLabel18.getName());
            valor22 = 15; //Depende del numero del jLabel
            if(valor1 == valor2) {
                informacion();
                habilitarTarjetas(false);
                score++;
            } else {
                habilitarTarjetas(true);
            }
            valor1 = 99;
            pDC = 99;
            if(score == scoreMax) reiniciar(true);
        }
        }
        };
        Timer timer = new Timer(1000, listener);
        timer.setRepeats(false);
        timer.start();
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cambiar de modo?\nSolamente te faltan "+(numeroE/2 - score)+" pares para ganar", "¿Seguro?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) reiniciar(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Memorama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField21;
    // End of variables declaration//GEN-END:variables
}
