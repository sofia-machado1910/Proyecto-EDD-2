/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import javax.swing.JOptionPane;

/**
 * Clase que representa una lista enlazada.
 * Permite insertar, eliminar, buscar y mostrar elementos en la lista.
 * 
 * @author Andrea Villasmil
 */

public class ListaEnlazada {
    private NodoPrimitivo cabeza; // Atributo que apunta al primer nodo de la lista
    private int cantidad; // Atributo que almacena el tamaño de la lista
 
    // Constructor que inicializa la lista vacía
    public ListaEnlazada() {
        this.cabeza = null; // Inicializa cabeza como nula
        this.cantidad = 0; // Inicializa cantidad como 0
    }

    // Método para obtener el primer nodo de la lista
    public NodoPrimitivo getCabeza() {
        return cabeza;
    }

    // Método para obtener el tamaño de la lista
    public int getCantidad() {
        return cantidad;
    }

    // Método para establecer el primer nodo de la lista
    public void setCabeza(NodoPrimitivo cabeza) {
        this.cabeza = cabeza;
    }

    // Método para establecer el tamaño de la lista
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return this.cabeza == null;
    }

    // Método para insertar un nuevo dato al final de la lista
    public void agregarAlFinal(Object dato) {
        NodoPrimitivo nuevoNodo = new NodoPrimitivo(dato);
        
        if (this.estaVacia()) {
            this.setCabeza(nuevoNodo); // Si está vacía, establece cabeza como nuevo nodo
        } else {
            NodoPrimitivo temporal = this.cabeza; // Inicia en el primer nodo
            
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente(); // Itera hasta llegar al último nodo
            }
            temporal.setSiguiente(nuevoNodo);
        }
        this.setCantidad(this.getCantidad() + 1); // Incrementa el tamaño de la lista
    }

    
    // Método para eliminar el último elemento de la lista
    public void eliminarDelFinal() {
        if (!this.estaVacia()) { // Verifica si la lista no está vacía
            if (this.getCantidad() == 1) {
                this.setCabeza(null); // Si solo hay un elemento, se establece cabeza como nula
            } else {
                NodoPrimitivo temporal = this.cabeza;
                
                while (temporal.getSiguiente().getSiguiente() != null) {
                    temporal = temporal.getSiguiente(); // Itera hasta el penúltimo nodo
                }
                temporal.setSiguiente(null); // Elimina el último nodo estableciendo su siguiente como nulo
            }
            this.setCantidad(this.getCantidad() - 1); // Decrementa el tamaño de la lista
        }
    }

    // Método para buscar un dato en la lista
    public boolean buscar(Object dato) {
        if (!this.estaVacia()) { 
            NodoPrimitivo temporal = this.cabeza;
            
            while (temporal != null) {
                if (temporal.getValorPrimitivo().equals(dato)) {
                    return true; // Retorna verdadero si se encuentra el dato
                }
                temporal = temporal.getSiguiente(); // Avanza al siguiente nodo
            }
        }
        return false; // Retorna falso si no se encuentra el dato
    }

    
    // Método para mostrar todos los elementos de la lista en un cuadro de diálogo
    public void mostrar() {
        if (!this.estaVacia()) { 
            StringBuilder listaString = new StringBuilder(); // Utiliza StringBuilder para construir la cadena
            
            NodoPrimitivo temporal = this.cabeza;
            while (temporal != null) {
                listaString.append(temporal.getValorPrimitivo()).append("\n"); // Agrega cada valor a la cadena
                temporal = temporal.getSiguiente(); // Avanza al siguiente nodo
            }
            
            JOptionPane.showMessageDialog(null, listaString.toString()); // Muestra los elementos en un cuadro de diálogo
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía."); // Mensaje si no hay elementos en la lista
        }
    }
    
    // Método para destruir toda la lista y liberar memoria
    public void destruir() {
        this.cabeza = null; // Establece cabeza como nula para liberar los nodos
        this.cantidad = 0;  // Reinicia el tamaño a 0
    }
}