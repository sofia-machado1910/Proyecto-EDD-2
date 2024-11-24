/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import static Interfaces.Json.arbolGenealogico;
/**
 * Clase que representa el árbol genealógico.
 * Permite gestionar el árbol de las personas de la respectiva familia y realizar búsquedas de los mismos por se nombre o su título nobiliario.
 * 
 * @author Sofia Machado
 */
public class ArbolGenealogico {
    private ArbolBase arbol;
    private String linajeFamilia;
    private hashTable hashTable; // HashTable para almacenar y buscar personas.

    /**
     * Constructor que inicializa el árbol genealógico y la hashtable.
     */
    public ArbolGenealogico() {
        this.arbol = new ArbolBase();
        this.hashTable = new hashTable(100);
    }

    // Getters y setters para los atributos de la clase.
    public ArbolBase getArbol() {
        return arbol;
    }

    public String getLinajeFamilia() {
        return linajeFamilia;
    }

    public hashTable getHashTable() {
        return hashTable;
    }

    public void setArbol(ArbolBase arbol) {
        this.arbol = arbol;
    }

    public void setLinajeFamilia(String linajeFamilia) {
        this.linajeFamilia = linajeFamilia;
    }

    public void setHashTable(hashTable hashTable) {
        this.hashTable = hashTable;
    }

    /**
     * Busca personas en el árbol genealógico por un respectivo nombre.
     * 
     * @param nombre El nombre a buscar.
     * @return Un arreglo de personas que coinciden con el nombre, o null si no hay hallazgos.
     */
    public Persona[] buscarConNombre(String nombre) {
        ListaEnlazada hallazgos = arbolGenealogico.getHashTable().buscarPorNombre(nombre);
        if (!hallazgos.estaVacia()) {
           return this.crearArregloPersonas(hallazgos);
        }
        return null;
    }

    /**
     * Busca personas en el árbol genealógico por título nobiliario.
     * 
     * @param titulo El título nobiliario a buscar.
     * @return Un arreglo de personas que tengan el título nobiliario, o null si no hay hallazgos.
     */
    public Persona[] buscarConTitulo(String titulo) {
        ListaEnlazada hallazgos = arbolGenealogico.getHashTable().buscarPorTitulo(titulo);
        if (!hallazgos.estaVacia()) {
           return this.crearArregloPersonas(hallazgos);
        }
        return null;
    }

    /**
     * Crea un arreglo de personas a partir de la lista enlazada de los hallazgos de la búsqueda.
     * 
     * @param hallazgos Lista enlazada de hallazgos.
     * @return Un arreglo de personas.
     */
    public Persona[] crearArregloPersonas(ListaEnlazada hallazgos) {
        Persona[] hallazgosStr = new Persona[hallazgos.getCantidad()];

        NodoPrimitivo temp = hallazgos.getCabeza();
        int count = 0;
        while (temp != null) {
            Persona personaActual = (Persona) temp.getValorPrimitivo();
            hallazgosStr[count] = personaActual;
            temp = temp.getSiguiente();
            count++;
        }
        return hallazgosStr;
    }

    /**
     * Muestra los hallazgos de una búsqueda.
     * 
     * @param resultado Arreglo de personas resultantes de la búsqueda.
     * @return Cadena con los resultados obtenidos.
     */
    public String mostrarHallazgos(Persona[] resultado) {
        String resultStr = "Resultados obtenidos de la Busqueda:\n";
        for (int i = 0; i < resultado.length; i++) {
            resultStr += i + " " + "Conocido como: " + resultado[i].getKnownAs() + " Nombre: " + resultado[i].getFullName() + " the " + resultado[i].getOfHisName() + "\n";
        }
        return resultStr;
    }

    /**
     * Proporciona información sobre una persona específica.
     * 
     * @param persona La persona de la cual se desea obtener información.
     * @return Cadena con la información de la persona.
     */
    public String infoPersona(Persona persona) {
        String clave = "";
        if (persona.getKnownAs() != null) {
            clave = persona.getKnownAs();
        } else {
            clave = persona.getFullName() + " " + persona.getOfHisName();
        }
        return this.hashTable.buscarEnTabla(clave).toString();
    }


    public ListaEnlazada alternativasDeGeneracion() {
        return null;
    }
}
