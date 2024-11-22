/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 * Clase que representa un nodo que vincula un objeto NodoArbol con su nivel correspondiente en la estructura del arbol.
 * 
 * @author Sofia Machado
 */
public class Nivel {
    private NodoArbol nodoArbol; // Almacena la referencia a un nodo del árbol
    private int profundidad; // Almacena el nivel del nodo en el árbol

    /**
     * Constructor que inicializa un objeto Nivel con un nodo y su profundidad.
     * @param nodoArbol El nodo del árbol asociado a este nivel.
     * @param profundidad El nivel del nodo en el árbol.
     */
    public Nivel(NodoArbol nodoArbol, int profundidad) {
        this.nodoArbol = nodoArbol; // Asigna el nodo del árbol
        this.profundidad = profundidad; // Asigna la profundidad del nodo
    }

    /**
     * Obtiene el nodo del árbol asociado a este nivel.
     * @return El nodo del árbol.
     */
    public NodoArbol obtenerNodo() {
        return nodoArbol; // Retorna el nodo del árbol
    }

    /**
     * Establece un nuevo nodo para este nivel.
     * @param nodoArbol El nuevo nodo del árbol a asignar.
     */
    public void establecerNodo(NodoArbol nodoArbol) {
        this.nodoArbol = nodoArbol; // Asigna un nuevo nodo al nivel
    }

    /**
     * Obtiene la profundidad de este nivel.
     * @return La profundidad del nivel.
     */
    public int obtenerProfundidad() {
        return profundidad; // Retorna la profundidad del nivel
    }

    /**
     * Establece una nueva profundidad para este nivel.
     * @param profundidad La nueva profundidad a asignar.
     */
    public void establecerProfundidad(int profundidad) {
        this.profundidad = profundidad; // Asigna una nueva profundidad al nivel
    }
}