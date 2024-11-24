/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import proyectoedd_2.ArbolGenealogico;
import proyectoedd_2.ArbolGenealogico;
import proyectoedd_2.CargaDeArchivo;
import proyectoedd_2.CargaDeArchivo;
import proyectoedd_2.NodoPrimitivo;
import proyectoedd_2.ListaEnlazada;
import proyectoedd_2.hashTable;
import proyectoedd_2.Persona;
import proyectoedd_2.hashTable;

/**
 * Clase Ventana1 para crear una interfaz gráfica de usuario en la que se pueda cargar archivos JSON desde el dispositivo, 
 * leer el mismo y buscar la información de alguna persona en específico.
 * 
 * @author Sofia Machado
 */

public class Json extends javax.swing.JFrame {
    private hashTable hashTable; // Instancia de la tabla de dispersión
    public static ArbolGenealogico arbolGenealogico; 
    private FileChooser fileChooser = new FileChooser();
    
    /**
     * Constructor de la clase Ventana1.
     * Este constructor lo que hace es inicializar los componentes de la ventana y a la vez centra la ventana en la pantalla.
     */
    public Json() {
        initComponents();
        this.setLocationRelativeTo(null);
        hashTable = new hashTable(100);
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
        CargarJSON = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 238, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 84, 67));
        jLabel1.setText("*asegúrese que efectivamente su archivo sea de formato JSON, de lo contrario el programa no lo leerá*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        CargarJSON.setBackground(new java.awt.Color(43, 86, 25));
        CargarJSON.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        CargarJSON.setForeground(new java.awt.Color(255, 255, 255));
        CargarJSON.setText("Cargar JSON");
        CargarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarJSONActionPerformed(evt);
            }
        });
        jPanel1.add(CargarJSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 110, 30));

        jLabel2.setBackground(new java.awt.Color(170, 143, 102));
        jLabel2.setFont(new java.awt.Font("ScriptC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(43, 86, 25));
        jLabel2.setText("Árbol Genealógico");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 50));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(43, 86, 25));
        jLabel3.setText("Bienvenido/a  al proyecto Árbol genealógico, programa que te ofrecerá");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 20));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(43, 86, 25));
        jLabel4.setText("una  visualización gráfica de cualquier familia, así como diversas maneras");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(43, 86, 25));
        jLabel5.setText("de obtener información de ella y de sus integrantes.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 20));

        jLabel6.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(177, 112, 54));
        jLabel6.setText("Carga de Archivo JSON");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(177, 112, 54));
        jLabel7.setText("Cargue el archivo JSON que contenga la información");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, 20));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(177, 112, 54));
        jLabel8.setText("del linaje del cual desea ver su árbol genealógico");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
class FileChooser {
    public String seleccionarJSON(JFrame ventana){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JSON", "json"));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();

        } else {
            // Si el usuario no seleccionó ningún archivo, muestra un mensaje
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");
            return null;
        }
    }
}
  
    private void CargarJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarJSONActionPerformed
        String rutaJSON = fileChooser.seleccionarJSON(this);
        CargaDeArchivo cargar = new CargaDeArchivo();
        cargar.cargarJSON(rutaJSON);
        arbolGenealogico = cargar.getArbolGenealogico();
    }//GEN-LAST:event_CargarJSONActionPerformed


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
            java.util.logging.Logger.getLogger(Json.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Json.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Json.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Json.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Json().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarJSON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}