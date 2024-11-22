/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 *
 * @author Andrea Villasmil
 */
/**
 * Clase ArbolGnral que representa un árbol general.
 * Permite crear, modificar y buscar nodos en el árbol.
 */
public class ArbolBase {

    private NodoArbol raiz; // Nodo raíz del árbol

    /**
     * Constructor de la clase ArbolGnral.
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
        return raiz; // Retorna la raíz
    }

    /**
     * Establece un nuevo nodo raíz para el árbol.
     * @param raiz Nodo que se establecerá como raíz.
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz; // Cambia la raíz del árbol
    }

    /**
     * Verifica si el árbol está vacío.
     * @return true si el árbol no tiene nodos, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.raiz == null; // Retorna verdadero si la raíz es nula
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
     * Agrega un hijo a un nodo padre existente en el árbol.
     * @param padre Nodo al que se le agregará el hijo.
     * @param dato Dato que contendrá el nuevo hijo.
     * @return Nodo creado como hijo del nodo padre.
     */
    public NodoArbol agregarHijo(NodoArbol padre, Object dato) {
        NodoArbol hijo = new NodoArbol(dato); // Crea un nuevo hijo
        padre.agregarHijo(hijo); // Agrega el hijo al padre
        return hijo; // Retorna el nuevo hijo
    }

    /**
     * Busca un nodo por el nombre de la persona asociada a él.
     * @param nombre Nombre de la persona a buscar.
     * @return Nodo encontrado o null si no se encuentra.
     */
    public NodoArbol buscarPorNombre(String nombre) {
        if (this.isEmpty()) { // Verifica si el árbol está vacío
            return null; // Retorna nulo si está vacío
        }

        Cola cola = new Cola(); // Crea una cola para la búsqueda
        cola.encolar(raiz); // Encola la raíz

        while (!cola.estaVacia()) { // Mientras haya nodos en la cola
            NodoArbol nodoActual = (NodoArbol) cola.desencolar(); // Desencola un nodo
            Persona persona = (Persona) nodoActual.getDato(); // Obtiene la persona del nodo

            if (persona.getNombreCompleto().equalsIgnoreCase(nombre)) { // Compara nombres
                return nodoActual; // Retorna el nodo si se encuentra
            }

            NodoPrimitivo hijoNodo = nodoActual.getHijos().getpFirst(); // Obtiene los hijos del nodo actual
            while (hijoNodo != null) { // Mientras haya hijos
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato(); // Obtiene cada hijo
                cola.encolar(hijo); // Encola cada hijo para seguir buscando
                hijoNodo = hijoNodo.getpNext(); // Avanza al siguiente hijo
            }
        }

        return null; // Retorna nulo si no se encuentra la persona
    }

    /**
     * Busca un nodo por el mote o nombre completo con numeral de la persona asociada a él.
     * @param nombre Nombre o mote de la persona a buscar.
     * @return Nodo encontrado o null si no se encuentra.
     */
    public NodoArbol buscarPorNombreClave(String nombre) {
        if (this.isEmpty()) { // Verifica si el árbol está vacío
            return null; // Retorna nulo si está vacío
        }

        Cola cola = new Cola(); // Crea una cola para la búsqueda
        cola.encolar(raiz); // Encola la raíz

        while (!cola.estaVacia()) { // Mientras haya nodos en la cola
            NodoArbol nodoActual = (NodoArbol) cola.desencolar(); // Desencola un nodo
            Persona persona = (Persona) nodoActual.getDato(); // Obtiene la persona del nodo

            if (persona.getMote() != null) { 
                if (persona.getMote().equalsIgnoreCase(nombre)) { 
                    return nodoActual; 
                } else {
                    String nombreComparar = persona.getNombreCompleto() + " " + persona.getNumeral(); 

                    if (nombreComparar.equalsIgnoreCase(nombre)) { 
                        return nodoActual; 
                    }
                }
            } else {
                String nombreComparar = persona.getNombreCompleto() + " " + persona.getNumeral();

                if (nombreComparar.equalsIgnoreCase(nombre)) { 
                    return nodoActual;
                }
            }
            
            NodoPrimitivo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) { 
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(hijo); 
                hijoNodo = hijoNodo.getpNext(); 
            }
        }

        return null; 
    }

    /**
     * Muestra todos los nodos del árbol por nivel en la consola.
     */
    public void mostrarPorNivel() {
        if (this.isEmpty()) { 
            JOptionPane.showMessageDialog(null, "El árbol está vacío."); 
        } else {
            String arbolStr = "Árbol:\n"; 
            Cola cola = new Cola(); 
            cola.encolar(raiz); 

            while (!cola.isEmpty()) { 
                NodoArbol nodoActual = (NodoArbol) cola.desencolar(); 
                Persona persona = (Persona) nodoActual.getDato();

                arbolStr += persona + "\n\n"; 

                Nodo hijoNodo = nodoActual.getHijos().getpFirst();
                while (hijoNodo != null) { 
                    NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                    cola.encolar(hijo); 
                    hijoNodo = hijoNodo.getpNext(); 
                }
            }

            System.out.println(arbolStr); 

        }
    }

    /**
     * Calcula el nivel máximo del árbol.
     * @return El nivel máximo del árbol, o 0 si está vacío.
     */
    public int maximoNivel() {
        if (this.isEmpty()) { 
            return 0; 
        }

        int maxNivel = 0; 

        Cola cola = new Cola(); 
        cola.encolar(new Nivel(raiz, 1)); 

        while (!cola.estaVacia()) { 
            Nivel nodoActual = (Nivel) cola.desencolar();

            maxNivel = Math.max(maxNivel, nodoActual.getNivel()); 

            NodoPrimitivo hijoNodo = nodoActual.getNodo().getHijos().getpFirst();
            while (hijoNodo != null) { 
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(new Nivel(hijo, nodoActual.getNivel() + 1)); 
                hijoNodo = hijoNodo.getpNext(); 
            }
        }

        return maxNivel; 
    }

    /**
     * Obtiene todos los nodos en un nivel específico del árbol.
     * @param nivelBuscado Nivel que se desea obtener.
     * @return Lista de nodos en el nivel buscado.
     */
    public ListaEnlazada obtenerNodosEnNivel(int nivelBuscado) {
        ListaEnlazada nodosEnNivel = new ListaEnlazada();

        if (this.isEmpty()) { 
            return nodosEnNivel; 
        }

        Cola cola = new Cola();
        cola.encolar(new Nivel(raiz, 1)); 

        while (!cola.estaVacia()) { 
            Nivel nodoActual = (Nivel) cola.desencolar();

            if (nodoActual.getNivel() == nivelBuscado) { 
                nodosEnNivel.insertarFinal(nodoActual.getNodo().getDato()); 
            }

            NodoPrimitivo hijoNodo = nodoActual.getNodo().getHijos().getpFirst();
            while (hijoNodo != null) { 
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(new Nivel(hijo, nodoActual.getNivel() + 1)); 
                hijoNodo = hijoNodo.getpNext(); 
            }
        }

        return nodosEnNivel; 
    }
}
