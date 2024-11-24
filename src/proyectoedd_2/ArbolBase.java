/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import javax.swing.JOptionPane;

/**
 *
 * @author Andrea Villasmil
 */
/**
 * Clase ArbolBase que representa un árbol general.
 * Permite crear, modificar y buscar nodos en el árbol.
 */
public class ArbolBase {

    private NodoArbol raiz; // Nodo raíz del árbol

    /**
     * Constructor de la clase ArbolBase.
     * Inicializa el árbol con la raíz como nula.
     */
    public ArbolBase() {
        this.raiz = null; // La raíz comienza vacía
    }

    /**
     * Obtiene el nodo raíz del árbol.
     * @return Nodo raíz del árbol.
     */
    public NodoArbol getRaiz() {
        return raiz;
    }

    /**
     * Establece un nuevo nodo raíz para el árbol.
     * @param raiz Nodo que se establecerá como raíz.
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    /**
     * Crea la raíz del árbol con un dato específico.
     * @param dato Dato que contendrá la nueva raíz.
     * @return Nodo creado como raíz del árbol.
     */
    public NodoArbol crearRaiz(Object dato) {
        this.raiz = new NodoArbol(dato); // Crea un nuevo nodo como raíz
        return this.raiz; // Retorna la nueva raíz
    }

    /**
     * Verifica si el árbol está vacío.
     * @return true si el árbol no tiene nodos, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.raiz == null;
    }
    
    /**
     * Agrega un hijo a un nodo padre existente en el árbol.
     * @param padre Nodo al que se le agregará el hijo.
     * @param dato Dato que contendrá el nuevo hijo.
     * @return Nodo creado como hijo del nodo padre.
     */
    public NodoArbol agregarHijo(NodoArbol padre, Object dato) {
        NodoArbol hijo = new NodoArbol(dato); // Crea un nuevo hijo
        padre.agregarHijo(hijo); // Agrega el hijo al padre
        return hijo;
    }

    /**
     * Busca un nodo por el nombre de la persona asociada a él.
     * @param nombre Nombre de la persona a buscar.
     * @return Nodo encontrado o null si no se encuentra.
     */
    public NodoArbol buscarConNombre(String nombre) {
        if (this.isEmpty()) { // Verifica si el árbol está vacío
            return null;
        }

        Cola cola = new Cola(); // Crea una cola para el recorrido
        cola.encolar(raiz); // Encola la raíz del árbol

        while (!cola.estaVacia()) { // Mientras haya nodos en la cola
            NodoArbol nodoActual = (NodoArbol) cola.desencolar(); // Desencola un nodo
            Persona persona = (Persona) nodoActual.getValor(); // Obtiene la persona del nodo

            if (persona.getFullName().equalsIgnoreCase(nombre)) { // Compara nombres
                return nodoActual; // Retorna el nodo si se encuentra
            }

            NodoPrimitivo hijoNodo = nodoActual.getNodosHijos().getCabeza(); // Obtiene los hijos del nodo actual
            while (hijoNodo != null) { // Mientras haya hijos
                NodoArbol hijo = (NodoArbol) hijoNodo.getValorPrimitivo(); // Obtiene cada hijo
                cola.encolar(hijo); // Encola cada hijo para seguir buscando
                hijoNodo = hijoNodo.getSiguiente(); // Avanza al siguiente hijo
            }
        }
        return null; 
    }

    /**
     * Busca un nodo por el mote o nombre completo con numeral de la persona asociada a él.
     * @param nombre Nombre o mote de la persona a buscar.
     * @return Nodo encontrado o null si no se encuentra.
     */
    public NodoArbol buscarConNombreDistintivo(String nombre) {
        if (this.isEmpty()) {
            return null;
        }

        Cola cola = new Cola();
        cola.encolar(raiz);

        while (!cola.estaVacia()) {
            NodoArbol nodoActual = (NodoArbol) cola.desencolar(); // Desencola un nodo
            Persona persona = (Persona) nodoActual.getValor(); // Obtiene la persona del nodo

            // Verifica si el nombre conocido coincide con el nombre buscado
            if (persona.getKnownAs() != null) {
                if (persona.getKnownAs().equalsIgnoreCase(nombre)) {
                    return nodoActual; // Retorna el nodo si se encuentra
                } else {
                    String nombreRelacionado = persona.getFullName() + " " + persona.getOfHisName();

                    if (nombreRelacionado.equalsIgnoreCase(nombre)) {
                        return nodoActual; // Retorna el nodo si se encuentra
                    }
                }
            } else {
                String nombreRelacionado = persona.getFullName() + " " + persona.getOfHisName();

                if (nombreRelacionado.equalsIgnoreCase(nombre)) {
                    return nodoActual; // Retorna el nodo si se encuentra
                }
            }

            NodoPrimitivo hijoNodo = nodoActual.getNodosHijos().getCabeza(); // Obtiene los hijos del nodo actual
            while (hijoNodo != null) { // Mientras haya hijos
                NodoArbol hijo = (NodoArbol) hijoNodo.getValorPrimitivo(); // Obtiene cada hijo
                cola.encolar(hijo); // Encola cada hijo para seguir buscando
                hijoNodo = hijoNodo.getSiguiente(); // Avanza al siguiente hijo
            }
        }
        return null;
    }

    /**
     * Calcula el nivel máximo del árbol.
     * @return El nivel máximo del árbol, o 0 si está vacío.
     */
    public int mayorNivel() {
        if (this.isEmpty()) { 
            return 0; // Retorna 0 si el árbol está vacío
        }

        int nivelMayor = 0; // Inicializa el nivel máximo

        Cola cola = new Cola(); // Crea una cola para el recorrido
        cola.encolar(new Nivel(raiz, 1)); // Encola la raíz con nivel 1

        while (!cola.estaVacia()) { // Mientras haya nodos en la cola
            Nivel nodoActual = (Nivel) cola.desencolar(); // Desencola un nodo

            nivelMayor = Math.max(nivelMayor, nodoActual.getProfundidad()); // Actualiza el nivel máximo

            NodoPrimitivo hijoNodo = nodoActual.getNodoArbol().getNodosHijos().getCabeza(); // Obtiene los hijos del nodo actual
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getValorPrimitivo(); // Obtiene cada hijo
                cola.encolar(new Nivel(hijo, nodoActual.getProfundidad() + 1)); // Encola el hijo con el nivel incrementado
                hijoNodo = hijoNodo.getSiguiente(); // Avanza al siguiente hijo
            }
        }
        return nivelMayor; // Retorna el nivel máximo encontrado
    }

    /**
     * Obtiene todos los nodos en un nivel específico del árbol.
     * @param nivelBuscado Nivel que se desea obtener.
     * @return Lista de nodos en el nivel buscado.
     */
    public ListaEnlazada obtenerNodosDeNivel(int nivelBuscado) {
        ListaEnlazada nodosEnNivel = new ListaEnlazada(); // Inicializa la lista para nodos en el nivel buscado

        if (this.isEmpty()) { 
            return nodosEnNivel; // Retorna la lista vacía si el árbol está vacío
        }

        Cola cola = new Cola();
        cola.encolar(new Nivel(raiz, 1));

        while (!cola.estaVacia()) {
            Nivel nodoActual = (Nivel) cola.desencolar(); // Mientras haya nodos en la cola, desencola un nodo

            if (nodoActual.getProfundidad() == nivelBuscado) { 
                nodosEnNivel.agregarAlFinal(nodoActual.getNodoArbol().getValor()); // Agrega el nodo a la lista si está en el nivel buscado
            }

            NodoPrimitivo hijoNodo = nodoActual.getNodoArbol().getNodosHijos().getCabeza(); // Obtiene los hijos del nodo actual
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getValorPrimitivo(); // Obtiene cada hijo
                cola.encolar(new Nivel(hijo, nodoActual.getProfundidad() + 1)); // Encola el hijo con el nivel incrementado
                hijoNodo = hijoNodo.getSiguiente(); // Avanza al siguiente hijo
            }
        }
        return nodosEnNivel;
    }
    
    /**
     * Muestra todos los nodos del árbol por nivel en la consola.
     */
    public void mostrarNiveles() {
        if (this.isEmpty()) { 
            JOptionPane.showMessageDialog(null, "El árbol está vacío.");
        } else {
            String arbolString = "Árbol genealógico:\n";
            Cola cola = new Cola();
            cola.encolar(raiz);

            while (!cola.estaVacia()) {
                NodoArbol nodoActual = (NodoArbol) cola.desencolar();
                Persona persona = (Persona) nodoActual.getValor(); // Obtiene la persona del nodo

                arbolString += persona + "\n\n"; // Agrega la persona a la cadena

                NodoPrimitivo hijoNodo = nodoActual.getNodosHijos().getCabeza(); // Obtiene los hijos del nodo actual
                while (hijoNodo != null) {
                    NodoArbol hijo = (NodoArbol) hijoNodo.getValorPrimitivo(); // Obtiene cada hijo
                    cola.encolar(hijo); // Encola cada hijo para seguir mostrando
                    hijoNodo = hijoNodo.getSiguiente(); // Avanza al siguiente hijo
                }
            }
            System.out.println(arbolString); // Imprime el árbol por consola
        }
    }
}
