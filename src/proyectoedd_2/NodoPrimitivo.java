/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 * Clase que representa un nodo en una lista enlazada.
 * Cada nodo almacena un valor y una referencia al siguiente nodo en la lista.
 * 
 * @author Andrea Villasmil
 */

// Clase que representa el nodo en la lista enlazada
public class NodoPrimitivo {

    private Object valorPrimitivo; // Atributo que almacena el valor del nodo
    private NodoPrimitivo siguiente; // Atributo que apunta al siguiente nodo en la lista

    // Constructor por defecto que inicializa el nodo sin valor ni siguiente
    public NodoPrimitivo() {
        this.valorPrimitivo = null; // Inicializa el valor como nulo
        this.siguiente = null; // Inicializa el siguiente nodo como nulo
    }
    
    // Constructor que permite establecer un valor al nodo
    public NodoPrimitivo(Object valorPrimitivo) {
        this.valorPrimitivo = valorPrimitivo; // Asigna el valor proporcionado al nodo
        this.siguiente = null; // Inicializa el siguiente nodo como nulo
    }

    // Método para obtener el valor del nodo
    public Object getValorPrimitivo() {
        return valorPrimitivo;
    }

    // Método para obtener el siguiente nodo en la lista
    public NodoPrimitivo getSiguiente() {
        return siguiente;
    }
    
    // Método para establecer un nuevo valor al nodo
    public void setValorPrimitivo(Object valorPrimitivo) {
        this.valorPrimitivo = valorPrimitivo;
    }

    // Método para establecer el siguiente nodo en la lista
    public void setSiguiente(NodoPrimitivo siguiente) {
        this.siguiente = siguiente;
    }
}