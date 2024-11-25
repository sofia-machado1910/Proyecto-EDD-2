/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import proyectoedd_2.Persona;
import javax.swing.JOptionPane;
import static Interfaces.Json.validar;
import static Interfaces.Json.arbolGenealogico;
import proyectoedd_2.Antepasados;
import proyectoedd_2.ListaEnlazada;

/**
 *
 * @author Andrea
 */
public class ListaAnt extends javax.swing.JFrame {
    private Persona[] coincidencias;
    
    public ListaAnt() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        coincidenciasTF = new javax.swing.JTextArea();
        botonRegresar = new javax.swing.JButton();
        arbolAntepasados = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        numeroPersona = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Antepasados de una Persona");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el número correspondiente a la persona:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        nombreTF.setForeground(new java.awt.Color(204, 204, 204));
        nombreTF.setText("nombre...");
        jPanel1.add(nombreTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, -1));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        coincidenciasTF.setColumns(20);
        coincidenciasTF.setRows(5);
        jScrollPane1.setViewportView(coincidenciasTF);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 380, 180));

        botonRegresar.setText("< Regresar al Menú");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        arbolAntepasados.setText("Ver árbol de antepasados");
        arbolAntepasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arbolAntepasadosActionPerformed(evt);
            }
        });
        jPanel1.add(arbolAntepasados, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Escribe el nombre de la persona a la que desee ver sus antepasados: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        numeroPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(numeroPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 60, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/arbolbg.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String nombre = nombreTF.getText();

        coincidencias = arbolGenealogico.buscarConNombre(nombre);

        if (coincidencias != null) {
            String resultados = arbolGenealogico.mostrarHallazgos(coincidencias);
            coincidenciasTF.setText(resultados);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron nombres o motes que coincidan con la búsqueda");
        }
        nombreTF.setText("");
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void numeroPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroPersonaActionPerformed

    private void arbolAntepasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbolAntepasadosActionPerformed
        if (!numeroPersona.getText().isEmpty()) {
            String indexStr = numeroPersona.getText();

            if (validar.validarNumeros(indexStr) != -1) {
                int index = validar.validarNumeros(indexStr);

                ListaEnlazada listaAencestros = arbolGenealogico.mostrarAntepasados(coincidencias, index);
                if (listaAencestros != null) {

                    System.setProperty("org.graphstream.ui", "swing");
                    Antepasados verAntepasados = new Antepasados(listaAencestros);
                    verAntepasados.setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "El indice ingresado debe ser de 0 a " + coincidencias.length);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El input solo pueder un numero entero.");
            }
            numeroPersona.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Input vacio");
        }
    }//GEN-LAST:event_arbolAntepasadosActionPerformed

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
            java.util.logging.Logger.getLogger(ListaAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAnt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arbolAntepasados;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextArea coincidenciasTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTextField numeroPersona;
    // End of variables declaration//GEN-END:variables
}
