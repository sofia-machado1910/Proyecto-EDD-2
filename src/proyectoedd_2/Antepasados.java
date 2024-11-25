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
 * 
 * @author Sofia Machado
 */
public class Antepasados extends JFrame {
    private ListaEnlazada antepasados;
    private Viewer visor;
    private ViewPanel panel;

    public Antepasados(ListaEnlazada antepasados) {
        this.antepasados = antepasados;
        configurarInterfaz();
        inicializarVisor();
        botonSalir();
    }

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
        
    private void configurarInterfaz() {
        setTitle("Visualizador de Antepasados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    private void formacionDeGrafo(Graph grafo) {
        if (antepasados == null || antepasados.estaVacia()) {
            JOptionPane.showMessageDialog(this, "Esta persona no cuenta con antepasados", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        NodoPrimitivo aux = antepasados.getCabeza();
        Node nodoAnterior = null;

        while (aux != null) {
            Persona persona = (Persona) aux.getValorPrimitivo();
            String id = persona.distinctiveName();

            Node nodoActual = grafo.addNode(id);
            nodoActual.setAttribute("ui.label", persona.distinctiveName());
            nodoActual.setAttribute("ui.style", "text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen;");

            if (nodoAnterior != null) {
                String edgeId = nodoAnterior.getId() + "-" + nodoActual.getId();
                grafo.addEdge(edgeId, nodoAnterior.getId(), nodoActual.getId());
            }
            nodoAnterior = nodoActual;
            aux = aux.getSiguiente();
        }
        grafo.setAttribute("ui.stylesheet", "node { text-size: 15px; size: 70px, 30px; text-alignment: center; fill-color: lightgreen; }"  
                + "edge { size: 4px; fill-color: brown; }"); 
    }

    private void botonSalir() {
        JButton botonCerrar = new JButton("Salir");
        botonCerrar.addActionListener(e -> cerrarVentana());
        add(botonCerrar, BorderLayout.SOUTH);
    }

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