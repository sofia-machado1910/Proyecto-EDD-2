/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.graph.implementations.SingleGraph;
import javax.swing.*;  
import java.awt.*;  

public class GrafoArbol extends JFrame {  

    private ArbolBase arbol;  
    private Viewer viewer;
    private ViewPanel ventana;  

    public GrafoArbol(ArbolBase arbol) {  
        this.arbol = arbol;  
        iniciarInterfaz();  
        iniciarViewer();  
        agregarBotonRegresar();  
    }  

    private void iniciarInterfaz() {  
        setTitle("Viewer de Árbol");  
        setSize(700, 500);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(new BorderLayout());  
        setLocationRelativeTo(null);  
    }  

    private void iniciarViewer() {  
        Graph arbolVisual = new SingleGraph("Árbol");  
        formarArbol(arbolVisual);  

        viewer = arbolVisual.display(false);  
        viewer.enableAutoLayout();  

        if (ventana == null) {  
            ventana = (ViewPanel) viewer.getDefaultView();  
            add(ventana, BorderLayout.CENTER);  
        }  
    }  

    private void estiloArbol(Graph arbolVisual) {  
        arbolVisual.setAttribute("ui.stylesheet", "node { text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen; }"  
                + "edge { size: 4px; fill-color: brown; }");  
    } 
    
    private void formarArbol(Graph arbolVisual) {  
        if (arbol.isEmpty()) {  
            mostrarMensaje("El árbol no contiene nada.");  
            return;  
        }  

        generarSubarboles(arbol.getRaiz(), null, arbolVisual);  
        estiloArbol(arbolVisual);  
    }  

    private void generarSubarboles(NodoArbol nodoActual, String padreId, Graph arbolVisual) {  
        Persona persona = (Persona) nodoActual.getValor();  
        String nodoId = persona.distinctiveName();  

        if (arbolVisual.getNode(nodoId) == null) {  
            org.graphstream.graph.Node nodoVisual = arbolVisual.addNode(nodoId);  
            nodoVisual.setAttribute("ui.label", persona.distinctiveName());  
            nodoVisual.setAttribute("persona", persona);  
        }  

        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {  
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);  
        }  

        for (int i = 0; i < nodoActual.getNodosHijos().getCantidad(); i++) {  
            NodoArbol hijo = (NodoArbol) nodoActual.getNodosHijos().getValor(i);  
            generarSubarboles(hijo, nodoId, arbolVisual);  
        }  
    }  

    private void mostrarMensaje(String mensaje) {  
        JOptionPane.showMessageDialog(this, mensaje);  
    }  

    private void mostrarInfoPersona(Persona persona) {  
        String info = String.format("Información de la Persona:\nNombre: %s\nPadre: %s\nMadre: %s",  
                persona.getFullName(), persona.getFather(), persona.getMother());  
        JOptionPane.showMessageDialog(this, info, "Detalles de Persona", JOptionPane.INFORMATION_MESSAGE);  
    }  

    private void agregarBotonRegresar() {  
        JButton botonRegresar = new JButton("Regresar");  
        botonRegresar.addActionListener(e -> {  
            cerrarViewer();  
            dispose();  
            abrirMenu();  
        });  
        add(botonRegresar, BorderLayout.SOUTH);  
    }  

    private void cerrarViewer() {  
        if (viewer != null) {  
            viewer.disableAutoLayout();  
            viewer.close();  
        }  
        if (ventana != null) {  
            remove(ventana);  
            ventana = null;  
        }  
    }  

    private void abrirMenu() {  
        Menu menuPrincipal = new Menu();  
        menuPrincipal.setVisible(true);  
    }  
} 

