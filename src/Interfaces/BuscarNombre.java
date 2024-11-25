/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import proyectoedd_2.ArbolBase;
import proyectoedd_2.NodoArbol;
import proyectoedd_2.GrafoArbol;
import proyectoedd_2.Persona;
import static Interfaces.Json.arbolGenealogico;
import javax.swing.JOptionPane;
import static Interfaces.Json.validar;
import javax.swing.*;

/**
 * Clase que representa la interfaz gráfica para buscar una persona por su nombre.
 * Extiende de JFrame para crear una ventana de aplicación.
 * 
 * @author Andrea Villasmil
 */
public class BuscarNombre extends javax.swing.JFrame {

    private Persona[] coincidencias;

    /**
     * Creates new form BuscarNombre
     */
    public BuscarNombre() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void mostrarInformacionConScroll(String info) {
        // Crear un JTextArea y configurarlo  
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(info);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false); // Hacer que el área de texto no sea editable  

        // Agregar el JTextArea a un JScrollPane  
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Crear el diálogo  
        JOptionPane.showMessageDialog(null, scrollPane, "Información de Descendencia", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        personaTF = new javax.swing.JTextArea();
        botonRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NumeroPersona = new javax.swing.JTextField();
        DetallesPersona = new javax.swing.JButton();
        descendenciaPersona = new javax.swing.JButton();
        infoDescendencia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Escriba el nombre de la persona que busca:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Elephant", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Persona por Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escriba el nombre de la persona que busca:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        nombreTF.setForeground(new java.awt.Color(153, 153, 153));
        nombreTF.setText("nombre...");
        jPanel1.add(nombreTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 330, -1));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        personaTF.setColumns(20);
        personaTF.setRows(5);
        jScrollPane1.setViewportView(personaTF);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 410, 170));

        botonRegresar.setText("<Regresar al Menú");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Escriba el nombre de la persona que busca:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Escriba el nombre de la persona que busca:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Escriba el nombre de la persona que busca:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingrese el número correspondiente a la persona:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        NumeroPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(NumeroPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 60, -1));

        DetallesPersona.setText("Ver detalles");
        DetallesPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(DetallesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 100, -1));

        descendenciaPersona.setText("Ver árbol descendencia");
        descendenciaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descendenciaPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(descendenciaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        infoDescendencia.setText("Ver info descendencia");
        infoDescendencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDescendenciaActionPerformed(evt);
            }
        });
        jPanel1.add(infoDescendencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/arbolbg.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            personaTF.setText(resultados);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron nombres o motes que coincidan con la búsqueda");
        }
        nombreTF.setText("");
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void NumeroPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroPersonaActionPerformed

    private void DetallesPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesPersonaActionPerformed
        String indiceStr = NumeroPersona.getText();
        if (validar.validarNumeros(indiceStr) != -1) {
            int index = validar.validarNumeros(indiceStr);
            if (validar.validarIndice(coincidencias.length, index)) {
                JOptionPane.showMessageDialog(null, coincidencias[index].toString());
            } else {
                JOptionPane.showMessageDialog(null, "Indice Invalido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ser un numero entero");
        }
        NumeroPersona.setText("");
    }//GEN-LAST:event_DetallesPersonaActionPerformed

    private void descendenciaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descendenciaPersonaActionPerformed
        String indexStr = NumeroPersona.getText();

        if (validar.validarNumeros(indexStr) != -1) {
            int index = validar.validarNumeros(indexStr);

            ArbolBase arbolDesc = arbolGenealogico.descendencia2(coincidencias, index);
            if (arbolDesc != null) {
                System.setProperty("org.graphstream.ui", "swing");
                GrafoArbol verArbol = new GrafoArbol(arbolDesc);
                verArbol.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "El indice ingresado debe ser de 0 a " + coincidencias.length);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El input solo pueder un numero entero.");
        }
        NumeroPersona.setText("");
    }//GEN-LAST:event_descendenciaPersonaActionPerformed

    private void infoDescendenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoDescendenciaActionPerformed
        String indexStr = NumeroPersona.getText();

        if (validar.validarNumeros(indexStr) != -1) {
            int index = validar.validarNumeros(indexStr);

            String clave = "";

            if (coincidencias[index].getKnownAs() != null) {
                clave = coincidencias[index].getKnownAs();
            } else {
                clave = coincidencias[index].getFullName() + " " + coincidencias[index].getOfHisName();
            }

            NodoArbol raiz2 = arbolGenealogico.getArbol().buscarConNombreDistintivo(clave);

            ArbolBase arbolDesc = new ArbolBase();
            arbolDesc.setRaiz(raiz2);

            String infoNiveles = arbolDesc.mostrarNivelesComoString();
            mostrarInformacionConScroll(infoNiveles);

        } else {
            JOptionPane.showMessageDialog(null, "El input solo puede ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        NumeroPersona.setText("");

    }//GEN-LAST:event_infoDescendenciaActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarNombre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DetallesPersona;
    private javax.swing.JTextField NumeroPersona;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton descendenciaPersona;
    private javax.swing.JButton infoDescendencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTextArea personaTF;
    // End of variables declaration//GEN-END:variables
}
