/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;


/**
 * Clase que implementa una tabla de dispersión (HashTable).
 * 
 * @author Sofia Machado
 */
public class hashTable {
    private ListaEnlazada[] tabla; // Arreglo de listas enlazadas para almacenar los elementos
    private int size; // Tamaño de la tabla

    /**
     * Constructor que inicializa la tabla de dispersión con un tamaño específico.
     * 
     * @param size Tamaño de la tabla
     */
    public hashTable(int size) {
        this.size = size;
        this.tabla = new ListaEnlazada[size];
        this.iniciar(); // Inicializa las listas enlazadas en cada índice
    }
    
    public ListaEnlazada[] getTabla() {
        return tabla;
    }

    public int getSize() {
        return size;
    }

    public void setTabla(ListaEnlazada[] tabla) {
        this.tabla = tabla;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Función hash que calcula el índice en la tabla basado en la clave.
     * 
     * @param key Clave para calcular el índice
     * @return Índice calculado
     */
    private int hash(Object key) {
        return Math.abs(key.hashCode()) % size;
    }

    /**
     * Inicializa cada índice de la tabla de dispersión con una nueva lista enlazada.
     */
    private void iniciar() {
        for (int i = 0; i < this.size; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    /**
     * Agrega un nuevo dato a la tabla utilizando la clave dada.
     * 
     * @param key Clave para el dato
     * @param dato Dato a agregar
     */
    public void put(Object key, Object dato) {
        int index = hash(key);
        ListaEnlazada listaEnIndex = tabla[index];

        if (!listaEnIndex.buscar(dato)) {
            listaEnIndex.agregarAlFinal(dato);
        }
    }
    
    /**
     * Busca un objeto Persona en la tabla utilizando su clave.
     * 
     * @param key Clave del objeto
     * @return Objeto Persona encontrado o null si no se encuentra
     */
    public Object buscarEnTabla(String key) {
        int indice = hash(key);
        ListaEnlazada listaEnIndex = tabla[indice];

        if (!listaEnIndex.estaVacia()) {
            NodoPrimitivo aux = listaEnIndex.getCabeza();
            while (aux != null) {
                Persona personaActual = (Persona) aux.getValorPrimitivo();
                if (personaActual.distinctiveName().equalsIgnoreCase(key)) {
                    return personaActual;
                }
                aux = aux.getSiguiente();
            }
            return null;
        }
        return null;
    }

    /**
     * Busca objetos Persona por su respectivo título nobiliario.
     * 
     * @param titulo Título
     * @return Lista de objetos Persona que coinciden con el título
     */
    public ListaEnlazada buscarPorTitulo(String titulo) {
        ListaEnlazada personasFiltradas = new ListaEnlazada();
        for (int i = 0; i < this.size; i++) {
            if (!tabla[i].estaVacia()) {
                NodoPrimitivo aux = tabla[i].getCabeza();
                while (aux != null) {
                    Persona personaAct = (Persona) aux.getValorPrimitivo();
                    if (personaAct.getTitle() != null) {
                        if (personaAct.getTitle().contains(titulo)) {
                            personasFiltradas.agregarAlFinal(personaAct);
                        }
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return personasFiltradas;
    }

    /**
     * Busca objetos Persona por su nombre completo, o en su defecto, su nombre con su numeral en la familia.
     * 
     * @param nombre Nombre 
     * @return Lista de objetos Persona que coinciden con el nombre
     */
    public ListaEnlazada buscarPorNombre(String nombre) {
        ListaEnlazada resultado = new ListaEnlazada();
        for (int i = 0; i < this.size; i++) {
            if (!tabla[i].estaVacia()) {
                NodoPrimitivo aux = tabla[i].getCabeza();
                while (aux != null) {
                    Persona personaAct = (Persona) aux.getValorPrimitivo();
                    if (personaAct.getKnownAs() != null) {
                        if (personaAct.getKnownAs().contains(nombre)) {
                            resultado.agregarAlFinal(personaAct);
                        } else if (personaAct.getFullName().contains(nombre)) {
                            String nombreConNumeral = personaAct.getFullName() + " " + personaAct.getOfHisName();
                            resultado.agregarAlFinal(personaAct);
                        }
                    } else {
                        if (personaAct.getFullName().contains(nombre)) {
                            String nombreConNumeral = personaAct.getFullName() + " " + personaAct.getOfHisName();
                            resultado.agregarAlFinal(personaAct);
                        }
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return resultado;
    }
    
    public ListaEnlazada buscarSoloConNombre(String nombre) {
        ListaEnlazada resultados = new ListaEnlazada();

        for (int i = 0; i < size; i++) {
            ListaEnlazada lista = tabla[i];

            for (int j = 0; j < lista.getCantidad(); j++) {
                Persona persona = (Persona) lista.getValor(j);

                if (persona.getFullName().toLowerCase().contains(nombre.toLowerCase())) {
                    resultados.agregarAlFinal(persona);
                }
            }
        }
        return resultados;
    }
    
    /**
     * Muestra el contenido de la tabla de dispersión.
     */
    public void mostrarTabla() {
        for (int i = 0; i < size; i++) {
            if (!tabla[i].estaVacia()) {
                System.out.println("\nIndice " + i + ":");
                NodoPrimitivo aux = tabla[i].getCabeza();
                while (aux != null) {
                    Persona personaAct = (Persona) aux.getValorPrimitivo();
                    System.out.print(personaAct.distinctiveName() + "->");
                    aux = aux.getSiguiente();
                }
                System.out.println("null");
            }
        }
    }
    
    /**
     * Reinicia la tabla de dispersión, eliminando todos los elementos contenidos en ella.
     */
    public void deshacerLista() {
        for (int i = 0; i < this.size; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }
}
