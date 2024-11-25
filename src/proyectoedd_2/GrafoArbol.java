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

import Interfaces.Menu;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;


/**
 * Clase GrafoArbol que extiende JFrame para mostrar un árbol visualmente.
 * Utiliza la biblioteca GraphStream para la visualización del grafo.
 * 
 * @author Sofia Machado
 */

public class GrafoArbol extends JFrame {  

    private ArbolBase arbol; // Estructura de datos que contiene el árbol
    private Viewer viewer; // Objeto para visualizar el grafo
    private ViewPanel ventana; // Panel de visualización del grafo

    /**
     * Constructor de la clase GrafoArbol.
     * 
     * @param arbol El árbol base que se va a visualizar.
     */
    
    public GrafoArbol(ArbolBase arbol) {  
        this.arbol = arbol;  
        iniciarInterfaz();  
        iniciarViewer();  
        agregarBotonRegresar();  
    }  

    /**
     * Configura los detalles de la interfaz de usuario.
     */
    
    private void iniciarInterfaz() {  
        setTitle("Viewer de Árbol");  
        setSize(800, 600);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(new BorderLayout());  
        setLocationRelativeTo(null);  
    }  

    /**
     * Inicializa el visor del grafo y lo muestra en la ventana.
     */
    
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

    /**
     * Aplica un estilo visual al grafo.
     * 
     * @param arbolVisual El grafo al que se aplicará el estilo.
     */
    
    private void estiloArbol(Graph arbolVisual) {  
        arbolVisual.setAttribute("ui.stylesheet", "node { text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen; }"  
                + "edge { size: 4px; fill-color: brown; }");  
    } 
    
    /**
     * Forma el grafo del árbol a partir de la estructura de datos.
     * 
     * @param arbolVisual El grafo donde se construirá el árbol.
     */
    
    private void formarArbol(Graph arbolVisual) {  
        if (arbol.isEmpty()) {  
            mostrarMensaje("El árbol no contiene nada.");  
            return;  
        }  

        generarSubarboles(arbol.getRaiz(), null, arbolVisual);  
        estiloArbol(arbolVisual);  
    }  

    /**
     * Genera subárboles en el grafo visual.
     * 
     * @param nodoActual El nodo actual del árbol.
     * @param padreId El identificador del nodo padre en el grafo.
     * @param arbolVisual El grafo donde se insertará el subárbol.
     */
    
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

    /**
     * Muestra un mensaje en un cuadro de diálogo.
     * 
     * @param mensaje El mensaje a mostrar.
     */
    
    private void mostrarMensaje(String mensaje) {  
        JOptionPane.showMessageDialog(this, mensaje);  
    }  

    /**
     * Agrega un botón para regresar al menú principal.
     */
    
    private void agregarBotonRegresar() {  
        JButton botonRegresar = new JButton("Regresar");  
        botonRegresar.addActionListener(e -> {  
            cerrarViewer();  
            dispose();  
            abrirMenu();  
        });  
        add(botonRegresar, BorderLayout.SOUTH);  
    }  

    /**
     * Cierra el visor del grafo y limpia el panel.
     */
    
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

    /**
     * Abre el menú principal.
     */
    
    private void abrirMenu() {  
        Menu menuPrincipal = new Menu();  
        menuPrincipal.setVisible(true);  
    }  
} 

