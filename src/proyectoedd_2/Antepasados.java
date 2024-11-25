/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import Interfaces.Menu;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana para visualizar un grafo de antepasados.
 * Extiende JFrame para crear una interfaz gráfica.
 * Utiliza GraphStream para la visualización del grafo.
 * @author Sofia Machado
 */


public class Antepasados extends JFrame {
    private ListaEnlazada antepasados; // Lista de antepasados a visualizar
    private Viewer visor; // Visor para mostrar el grafo
    private ViewPanel panel; // Panel donde se muestra el grafo

    
    /**
     * Constructor de la clase Antepasados.
     * @param antepasados ListaEnlazada que contiene los antepasados a visualizar.
     */
    
    public Antepasados(ListaEnlazada antepasados) {
        this.antepasados = antepasados;
        configurarInterfaz();
        inicializarVisor();
        botonSalir();
    }

     /**
     * Inicializa el visor del grafo y configura su visualización.
     */
    
    private void inicializarVisor() {
        Graph grafo = new MultiGraph("Antepasados");
        formacionDeGrafo(grafo);

        visor = grafo.display(false);
        visor.enableAutoLayout();
        
        if (panel == null) {
            panel = (ViewPanel) visor.getDefaultView();
            add(panel, BorderLayout.CENTER);
        }
    }
        
    /**
     * Configura la interfaz gráfica de la ventana.
     */
    
    private void configurarInterfaz() {
        setTitle("Visualizador de Antepasados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    /**
     * Forma el grafo a partir de la lista de antepasados.
     * @param grafo Grafo donde se añadirán los nodos y aristas.
     */
    
    private void formacionDeGrafo(Graph grafo) {
        if (antepasados == null || antepasados.estaVacia()) {
            JOptionPane.showMessageDialog(this, "Esta persona no cuenta con antepasados", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        NodoPrimitivo aux = antepasados.getCabeza(); // Nodo actual en la lista de antepasados
        Node nodoAnterior = null; // Nodo anterior en el grafo

        while (aux != null) {
            Persona persona = (Persona) aux.getValorPrimitivo(); // Obtiene la persona del nodo actual
            String id = persona.distinctiveName(); // Obtiene un identificador único para la persona

            Node nodoActual = grafo.addNode(id); // Añade un nuevo nodo al grafo
            nodoActual.setAttribute("ui.label", persona.distinctiveName()); // Establece la etiqueta del nodo
            nodoActual.setAttribute("ui.style", "text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen;");

            if (nodoAnterior != null) {
                String edgeId = nodoAnterior.getId() + "-" + nodoActual.getId(); // Crea un identificador para la arista
                grafo.addEdge(edgeId, nodoAnterior.getId(), nodoActual.getId()); // Añade una arista entre el nodo anterior y el actual
            }
            nodoAnterior = nodoActual; // Actualiza el nodo anterior
            aux = aux.getSiguiente(); // Avanza al siguiente nodo en la lista
        }
        grafo.setAttribute("ui.stylesheet", "node { text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen; }"  
                + "edge { size: 4px; fill-color: brown; }"); 
    }

    /**
     * Añade un botón para cerrar la ventana y volver al menú principal.
     */
    
    private void botonSalir() {
        JButton botonCerrar = new JButton("Salir");
        botonCerrar.addActionListener(e -> cerrarVentana()); // Añade un listener para cerrar la ventana al hacer clic
        add(botonCerrar, BorderLayout.SOUTH);
    }

     /**
     * Cierra la ventana actual y vuelve al menú principal.
     */
    
    private void cerrarVentana() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panel != null) {
            remove(panel);
            panel = null;
        }
        dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}