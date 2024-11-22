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
 * Clase que representa una cola utilizando una lista enlazada.
 * Permite encolar (agregar) y desencolar (quitar) elementos.
 */
public class Cola {
    private NodoPrimitivo fin; // Atributo que apunta al último nodo de la cola
    private NodoPrimitivo inicio; // Atributo que apunta al primer nodo de la cola
    private int tamaño; // Atributo que almacena el tamaño de la cola

    
    // Constructor que inicializa la cola vacía
    
    public Cola() {
        this.fin = this.inicio = null; // Inicializa fin e inicio como nulos
        this.tamaño = 0; // Inicializa tamaño como 0
    }

    
    // Método para obtener el último nodo de la cola
    
    public NodoPrimitivo obtenerFin() {
        return fin; // Retorna el último nodo
    }

    // Método para establecer el último nodo de la cola
    
    public void establecerFin(NodoPrimitivo fin) {
        this.fin = fin; // Asigna un nuevo último nodo
    }

    // Método para obtener el primer nodo de la cola
    
    public NodoPrimitivo obtenerInicio() {
        return inicio; // Retorna el primer nodo
    }

    // Método para establecer el primer nodo de la cola
    
    public void establecerInicio(NodoPrimitivo inicio) {
        this.inicio = inicio; // Asigna un nuevo primer nodo
    }

    // Método para obtener el tamaño de la cola
    
    public int obtenerTamaño() {
        return tamaño; // Retorna el tamaño actual de la cola
    }

    // Método para establecer el tamaño de la cola
    
    public void establecerTamaño(int tamaño) {
        this.tamaño = tamaño; // Asigna un nuevo tamaño a la cola
    }

    // Método para verificar si la cola está vacía
    
    public boolean estaVacia() {
        return this.inicio == null; // Retorna verdadero si inicio es nulo
    }

    // Método para encolar un nuevo dato al final de la cola
    
    public void encolar(Object dato) {
        NodoPrimitivo nuevoNodo = new NodoPrimitivo(dato); // Crea un nuevo nodo con el dato a insertar
        
        if (this.estaVacia()) { 
            this.establecerInicio(nuevoNodo); // Si está vacía, establece inicio como nuevo nodo
            this.establecerFin(nuevoNodo); // También establece fin como nuevo nodo
        } else {
            this.fin.establecerSiguiente(nuevoNodo); // Enlaza el nuevo nodo al final de la cola
            this.establecerFin(nuevoNodo); // Actualiza fin al nuevo nodo
        }
        
        establecerTamaño(obtenerTamaño() + 1); // Incrementa el tamaño de la cola
    }

    // Método para desencolar (quitar) el primer elemento de la cola
    public Object desencolar() {
        // Primero, revisa si la cola no está vacía
        if (this.estaVacia() == false) { 
            // Obtiene el valor del primer nodo
            Object datoEliminar = this.inicio.obtenerValor(); 

            // Mueve el inicio al siguiente nodo
            this.inicio = this.inicio.obtenerSiguiente(); 

            // Si el nuevo inicio es nulo, eso significa que la cola está vacía ahora
            if (this.inicio == null) { 
                this.fin = null; // Entonces también pongo fin como nulo
            }

            // Disminuyo el tamaño de la cola en uno
            this.tamaño = this.tamaño - 1; 

            // Retorno el dato que eliminé
            return datoEliminar; 
        }

        // Si la cola estaba vacía, retorno nulo
        return null; 
    }

    // Método para mostrar todos los elementos de la cola en un cuadro de diálogo
    public void mostrar() {
        // Primero, reviso si la cola no está vacía
        if (this.estaVacia() == false) { 
            String listaString = ""; // Inicializo una cadena vacía para los elementos

            // Creo una variable temporal para recorrer la cola
            NodoPrimitivo temp = this.inicio; 

            // Mientras temp no sea nulo, sigo recorriendo
            while (temp != null) {
                // Agrego el valor del nodo actual a la cadena
                listaString += temp.obtenerValor() + "\n"; 
                // Muevo temp al siguiente nodo
                temp = temp.obtenerSiguiente(); 
            }

            // Muestro todos los elementos en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, listaString); 
        } else {
            // Si la cola está vacía, muestro un mensaje
            JOptionPane.showMessageDialog(null, "La cola está vacía."); 
        }
    }