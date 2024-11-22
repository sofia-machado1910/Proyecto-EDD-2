/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 *
 * @author Andrea Villasmil
 */
public class NodoArbol {
    private Object valor; // Almacena el valor del nodo
    private NodoArbol padre; // Referencia al nodo padre
    private ListaEnlazada hijos; // Lista que contiene los nodos hijos

    /**
     * Constructor que inicializa un nodo con un valor específico.
     * @param valor El valor que se asignará al nodo.
     */
    public NodoArbol(Object valor) {
        this.valor = valor; // Asigna el valor proporcionado al nodo
        this.padre = null; // Inicializa el padre como nulo
        this.hijos = new ListaEnlazada(); // Crea una nueva lista para los hijos
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     * @return El valor del nodo.
     */
    public Object obtenerValor() {
        return valor; // Retorna el valor del nodo
    }

    /**
     * Establece un nuevo valor para el nodo.
     * @param valor El nuevo valor a asignar.
     */
    public void establecerValor(Object valor) {
        this.valor = valor; // Asigna el nuevo valor al nodo
    }

    /**
     * Obtiene la referencia al nodo padre.
     * @return El nodo padre.
     */
    public NodoArbol obtenerPadre() {
        return padre; // Retorna el nodo padre
    }

    /**
     * Establece un nuevo nodo padre para este nodo.
     * @param padre El nuevo nodo padre a asignar.
     */
    public void establecerPadre(NodoArbol padre) {
        this.padre = padre; // Asigna el nuevo padre al nodo
    }

    /**
     * Obtiene la lista de nodos hijos de este nodo.
     * @return La lista de nodos hijos.
     */
    public ListaEnlazada obtenerHijos() {
        return hijos; // Retorna la lista de hijos
    }

    /**
     * Establece una nueva lista de nodos hijos para este nodo.
     * @param hijos La nueva lista de nodos hijos a asignar.
     */
    public void establecerHijos(ListaEnlazada hijos) {
        this.hijos = hijos; // Asigna la nueva lista de hijos
    }
    
    /**
     * Agrega un hijo a este nodo, estableciendo este nodo como su padre.
     * @param hijo El nodo hijo a agregar.
     */
    public void agregarHijo(NodoArbol hijo) {
        hijo.establecerPadre(this); // Establece este nodo como padre del hijo
        this.hijos.agregarAlFinal(hijo); // Agrega el hijo a la lista de hijos
    }
    
    /**
     * Determina si este nodo es una hoja (no tiene hijos).
     * @return true si es hoja, false en caso contrario.
     */
    public boolean esHoja() {
        return hijos.estaVacia(); // Retorna verdadero si no tiene hijos
    }
}

