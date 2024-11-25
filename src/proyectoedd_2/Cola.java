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
    public NodoPrimitivo getFin() {
        return fin;
    }

    // Método para obtener el primer nodo de la cola
    public NodoPrimitivo getInicio() {
        return inicio;
    }

    // Método para obtener el tamaño de la cola
    public int getTamaño() {
        return tamaño;
    }

    // Método para establecer el último nodo de la cola
    public void setFin(NodoPrimitivo fin) {
        this.fin = fin;
    }

    // Método para establecer el primer nodo de la cola
    public void setInicio(NodoPrimitivo inicio) {
        this.inicio = inicio;
    }

    // Método para establecer el tamaño de la cola
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return this.inicio == null; // Retorna verdadero si inicio es nulo
    }

    // Método para encolar un nuevo dato al final de la cola
    public void encolar(Object dato) {
        NodoPrimitivo nuevoNodo = new NodoPrimitivo(dato); // Crea un nuevo nodo con el dato a insertar
        
        if (this.estaVacia()) { 
            this.setInicio(nuevoNodo); // Si está vacía, establece inicio como nuevo nodo
            this.setFin(nuevoNodo); // También establece fin como nuevo nodo
        } else {
            this.fin.setSiguiente(nuevoNodo); // Enlaza el nuevo nodo al final de la cola
            this.setFin(nuevoNodo); // Actualiza fin al nuevo nodo
        }
        tamaño++; // Incrementa el tamaño de la cola
    }

    public Object desencolar(){
        if(!this.estaVacia()) {
           Object datoEliminar = this.inicio.getValorPrimitivo();
           this.setInicio(this.inicio.getSiguiente());
           return datoEliminar;
        }
        return null;
    }

    // Método para mostrar todos los elementos de la cola en un cuadro de diálogo
    public void mostrar(){
        if(!this.estaVacia()){
            String listaString = "";
            
            NodoPrimitivo temp = this.inicio;
            while(temp != null){
                listaString += temp.getValorPrimitivo() + "\n";
                temp = temp.getSiguiente();
            }
            
            JOptionPane.showMessageDialog(null, listaString);
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
        }
    }
}