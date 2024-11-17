/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import javax.swing.JOptionPane;

/**
 * Clase que implementa una tabla de dispersión para almacenar objetos Persona.
 * 
 * @author Sofia Machado
 */
public class hashTable {

    private Persona[][] tabla; // Array bidimensional para almacenar las personas
    private int size;

    /**
     * Constructor que inicializa la tabla de dispersión con una capacidad dada.
     * 
     * @param capacity Capacidad inicial de la tabla
     */
    public hashTable(int capacity) {
        tabla = new Persona[capacity][10];  
        size = 0;
    }

    /**
     * Método hash que calcula el índice para una clave dada.
     * 
     * @param key Clave para calcular el índice
     * @return Índice calculado
     */
    private int hash(String key) {
        return (key.hashCode() % tabla.length + tabla.length) % tabla.length;
    }

    /**
     * Agrega una persona a la tabla de dispersión.
     * 
     * @param persona Persona a agregar
     */
    public void put(Persona persona) {
        int index = hash(persona.nombreCompleto);
        for (int i = 0; i < tabla[index].length; i++) {
            if (tabla[index][i] == null) { // Encuentra el primer lugar vacío  
                tabla[index][i] = persona;
                size++;
                return;
            }
        }
        // Si no hay espacio, se muestra un mensaje de error 
        JOptionPane.showMessageDialog(null, "No se puede agregar más personas con el mismo nombre.");
    }

    /**
     * Obtiene una persona de la tabla de dispersión según el nombre completo y el numeral.
     * 
     * @param nombreCompleto Nombre completo de la persona
     * @param ofHisName Numeral de la persona en la familia
     * @return Persona encontrada o null si no se encuentra
     */
    public Persona get(String nombreCompleto, String ofHisName) {
        int index = hash(nombreCompleto);
        for (int i = 0; i < tabla[index].length; i++) {
            if (tabla[index][i] != null && tabla[index][i].nombreCompleto.equals(nombreCompleto)) {
                // Si ofHisName es null, retorna la primera coincidencia  
                if (ofHisName == null || (tabla[index][i].ofHisName != null && tabla[index][i].ofHisName.equals(ofHisName))) {
                    return tabla[index][i];
                }
            }
        }
        return null; // Retorna null si no se encuentra la persona
    }

    /**
     * Verifica si la tabla contiene una persona con el nombre completo y el numeral dados.
     * 
     * @param nombreCompleto Nombre completo de la persona
     * @param ofHisName Numeral de la persona
     * @return true si la persona está en la tabla, false si no
     */
    public boolean contains(String nombreCompleto, String ofHisName) {
        return get(nombreCompleto, ofHisName) != null;
    }

    /**
     * Devuelve el tamaño actual de la tabla de dispersión.
     * 
     * @return Tamaño de la tabla
     */
    public int getSize() {
        return size;
    }
}
