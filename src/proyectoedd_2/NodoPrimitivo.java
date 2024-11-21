/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 *
 * @author Andrea Villasmil
 */

// Clase que representa el nodo en la lista enlazada

public class NodoPrimitivo {
    private Object valor; // Atributo que almacena el valor del nodo
    private NodoPrimitivo siguiente; // Atributo que apunta al siguiente nodo en la lista

    
    
    // Constructor por defecto que inicializa el nodo sin valor ni siguiente
    
    public NodoPrimitivo() {
        this.valor = null; // Inicializa el valor como nulo
        this.siguiente = null; // Inicializa el siguiente nodo como nulo
    }
    
    
    // Constructor que permite establecer un valor al nodo
    
    public NodoPrimitivo(Object valor) {
        this.valor = valor; // Asigna el valor proporcionado al nodo
        this.siguiente = null; // Inicializa el siguiente nodo como nulo
    }

    
    
    // Método para obtener el valor del nodo
    
    public Object obtenerValor() {
        return valor; // Retorna el valor almacenado en el nodo
    }

    // Método para establecer un nuevo valor al nodo
    
    public void establecerValor(Object valor) {
        this.valor = valor; // Asigna un nuevo valor al nodo
    }

    // Método para obtener el siguiente nodo en la lista
    
    public NodoPrimitivo obtenerSiguiente() {
        return siguiente; // Retorna el siguiente nodo enlazado
    }

    // Método para establecer el siguiente nodo en la lista
    
    public void establecerSiguiente(NodoPrimitivo siguiente) {
        this.siguiente = siguiente; // Asigna un nuevo nodo como siguiente
    }
}