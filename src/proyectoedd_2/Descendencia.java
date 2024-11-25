/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;


import Interfaces.BuscarNombre;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * Clase Descendencia que extiende JFrame para mostrar un árbol genealógico.
 * Utiliza la biblioteca GraphStream para la visualización del grafo.
 * 
 * @author Sofia Machado
 */
public class Descendencia extends JFrame{
    private ArbolBase arbol; 
    private Viewer visor;
    private ViewPanel panel;
    private BuscarNombre buscarNombre;

    
    /**
     * Constructor de la clase Descendencia.
     * 
     * @param arbol El árbol base que contiene la estructura genealógica.
     * @param buscarNombre Interfaz para buscar nombres en el árbol.
     */
    
    public Descendencia(ArbolBase arbol, BuscarNombre buscarNombre) {
        this.arbol = arbol;
        this.buscarNombre = buscarNombre;
        buscarNombre.setVisible(false);
        detallesGrafo();
        inicializar();
    }

    
    /**
     * Configura los detalles de la ventana del grafo.
     */
    
    private void detallesGrafo() {
        setTitle("Árbol Genealógico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                close();
                volverDescendencia();
            }
        });
    }

   
    /**
     * Inicializa el grafo visual y lo muestra en la ventana.
     */
    
    private void inicializar() {
        Graph arbolVisual = new MultiGraph("Árbol Genealógico");
        construirArbol(arbolVisual);

        visor = arbolVisual.display(false);
        visor.enableAutoLayout();

        if (panel == null) {
            panel = (ViewPanel) visor.getDefaultView();
            add(panel, BorderLayout.CENTER);
        }
    }

    
    /**
     * Construye el grafo del árbol genealógico.
     * 
     * @param arbolVisual El grafo donde se construirá el árbol.
     */
    
    private void construirArbol(Graph arbolVisual) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }
        insertarSubarbol(arbol.getRaiz(), null, arbolVisual);
        arbolVisual.setAttribute("ui.stylesheet", "node { text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen; }"  
                + "edge { size: 4px; fill-color: brown; }"); 
    }

    
    /**
     * Inserta un subárbol en el grafo visual.
     * 
     * @param nodoActual El nodo actual del árbol.
     * @param padreId El identificador del nodo padre en el grafo.
     * @param arbolVisual El grafo donde se insertará el subárbol.
     */
    
    private void insertarSubarbol(NodoArbol nodoActual, String padreId, Graph arbolVisual) {
        Persona persona = nodoActual.getPersonaNodo();
        String nodoId = persona.getNombreUnico();

        // Verificar si el nodo ya existe en el grafo
        if (arbolVisual.getNode(nodoId) == null) {
            org.graphstream.graph.Node nodoVisual = arbolVisual.addNode(nodoId);
            nodoVisual.setAttribute("ui.label", persona.getNombreUnico());
            nodoVisual.setAttribute("persona", persona);
        }

        // Crear la relación (arista) con el nodo padre
        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);
        }

        // Recorrer los hijos del nodo actual y agregarlos al grafo
        for (int i = 0; i < nodoActual.getNodosHijos().getCantidad(); i++) {
            NodoArbol hijo = (NodoArbol) nodoActual.getNodosHijos().getValor(i);
            insertarSubarbol(hijo, nodoId, arbolVisual);
        }
    }

    /**
     * Cierra el visor del grafo y limpia el panel.
     */
    
    private void close() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panel != null) {
            remove(panel);
            panel = null;
        }
    }

    /**
     * Vuelve a mostrar la interfaz de búsqueda de nombres.
     */
    
    private void volverDescendencia() {
        buscarNombre.setVisible(true); // Mostrar el menú
    }
}
