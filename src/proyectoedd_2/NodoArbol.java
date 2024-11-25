/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 * Clase que representa un nodo en un árbol.
 * Cada nodo puede contener un valor y referencias a su padre y a sus hijos.
 * Además, puede almacenar una instancia de la clase Persona.
 * 
 * @author Andrea Villasmil
 */
public class NodoArbol {
    private Object valor; // Almacena el valor del nodo
    private Persona personaNodo;
    private NodoArbol nodoPadre; // Referencia al nodo padre
    private ListaEnlazada nodosHijos; // Lista que contiene los nodos hijos

    /**
     * Constructor que inicializa un nodo con un valor específico.
     * @param valor El valor que se asignará al nodo.
     */
    public NodoArbol(Object valor) {
        this.valor = valor; // Asigna el valor proporcionado al nodo
        this.nodoPadre = null; // Inicializa el padre como nulo
        this.nodosHijos = new ListaEnlazada(); // Crea una nueva lista para los hijos
    }
    
    public NodoArbol(Persona persona) {
        this.personaNodo = persona;
        this.nodoPadre = null;
        this.nodosHijos = new ListaEnlazada();
    }
    
    /**
     * Obtiene el valor almacenado en el nodo.
     * @return El valor del nodo.
     */
    public Object getValor() {
        return valor; // Retorna el valor del nodo
    }
    
    public Persona getPersonaNodo() {
        return personaNodo;
    }

    public void setPersonaNodo(Persona personaNodo) {
        this.personaNodo = personaNodo;
    }

    /**
     * Obtiene la referencia al nodo padre.
     * @return El nodo padre.
     */
    public NodoArbol getNodoPadre() {
        return nodoPadre;
    }
    
    /**
     * Obtiene la lista de nodos hijos de este nodo.
     * @return La lista de nodos hijos.
     */
    public ListaEnlazada getNodosHijos() {
        return nodosHijos; // Retorna la lista de hijos
    }
    
    public Object obtenerValor() {
        return valor; 
    }
    
    /**
     * Establece un nuevo valor para el nodo.
     * @param valor El nuevo valor a asignar.
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    /**
     * Establece un nuevo nodo padre para este nodo.
     * @param nodoPadre El nuevo nodo padre a asignar.
     */
    public void setNodoPadre(NodoArbol nodoPadre) {
        this.nodoPadre = nodoPadre;// Asigna el nuevo padre al nodo
    }

    /**
     * Establece una nueva lista de nodos hijos para este nodo.
     * @param nodosHijos La nueva lista de nodos hijos a asignar.
     */
    public void setNodosHijos(ListaEnlazada nodosHijos) {
        this.nodosHijos = nodosHijos;
    }

    /**
     * Agrega un hijo a este nodo, estableciendo este nodo como su padre.
     * @param hijo El nodo hijo a agregar.
     */
    public void agregarHijo(NodoArbol hijo) {
        // Primero, establezco este nodo como padre del hijo
        hijo.setNodoPadre(this); 
        // Luego, agrego el hijo a la lista de hijos
        this.nodosHijos.agregarAlFinal(hijo); 
    }
    
    public boolean tieneHijo(Persona personaNodo) {
        NodoPrimitivo aux = this.nodosHijos.getCabeza();

        while (aux != null) {
            NodoArbol nodoHijo = (NodoArbol) aux.getValorPrimitivo();
            if (nodoHijo.getPersonaNodo().getNombreUnico().equalsIgnoreCase(personaNodo.getNombreUnico())) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    /**
     * Determina si este nodo es una hoja (no tiene hijos).
     * @return true si es hoja, false en caso contrario.
     */
    public boolean esHoja() {
        // Verifico si la lista de hijos está vacía
        if (nodosHijos.estaVacia()) {
            return true; // Si está vacía, retorno verdadero
        } else {
            return false; // Si no está vacía, retorno falso
        }
    }
    
    @Override
    public String toString() {
        return "Persona:" + personaNodo.getNombreUnico();
    }
}