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
 * @author Sofia Machado
 */
public class Descendencia extends JFrame{
    private ArbolBase arbol; 
    private Viewer visor;
    private ViewPanel panel;
    private BuscarNombre buscarNombre;

    
    public Descendencia(ArbolBase arbol, BuscarNombre buscarNombre) {
        this.arbol = arbol;
        this.buscarNombre = buscarNombre;
        buscarNombre.setVisible(false);
        detallesGrafo();
        inicializar();
    }

    
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

    
    private void construirArbol(Graph arbolVisual) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }
        insertarSubarbol(arbol.getRaiz(), null, arbolVisual);
        arbolVisual.setAttribute("ui.stylesheet", "node { text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen; }"  
                + "edge { size: 4px; fill-color: brown; }"); 
    }

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

    private void volverDescendencia() {
        buscarNombre.setVisible(true); // Mostrar el menú
    }
}
