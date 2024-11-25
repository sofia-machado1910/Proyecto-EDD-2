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
        String resultStr = "Coincidencias con su busqueda:\n";
        for (int i = 0; i < resultado.length; i++) {
            resultStr += i + ") " + "Mote: " + resultado[i].getKnownAs() + "\n Nombre y numeral en familia: " + resultado[i].getFullName() + " the " + resultado[i].getOfHisName() + "\n";
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

    public ArbolBase descendencia(Persona persona) {
        ArbolBase arbolDescendencia = new ArbolBase();
        arbolDescendencia.setRaiz(this.arbol.buscarConNombre(persona.getNombreUnico()));
        return arbolDescendencia;
    }
    
    public ArbolBase descendencia2(Persona[] arreglo, int index) {
        if (index >= 0 && index < arreglo.length) {
            String clave = "";

            if (arreglo[index].getKnownAs() != null) {
                clave = arreglo[index].getKnownAs();
            } else {
                clave = arreglo[index].getFullName() + " " + arreglo[index].getOfHisName();
            }

            NodoArbol raiz2 = this.getArbol().buscarConNombreDistintivo(clave);

            ArbolBase arbolDesc = new ArbolBase();
            arbolDesc.setRaiz(raiz2);

            
            return arbolDesc;
        } else {
           
            return null;
        }
    }
        
    public String mostrarBusquedaSoloNombre(Persona[] resultado) {
        String resultadoStr = "";
        for (int i = 0; i < resultado.length; i++) {
            resultadoStr += "Indice: " + i + ", Nombre: " + resultado[i].getNombreNumeral() + "\n";
        }
        return resultadoStr;
    }
    
    public Persona[] buscarSoloNombre(String nombre) {
        ListaEnlazada resultados = this.hashTable.buscarSoloConNombre(nombre);

        if (!resultados.estaVacia()) {
            Persona[] resultadoBusq = new Persona[resultados.getCantidad()];
            for (int i = 0; i < resultados.getCantidad(); i++) {
                resultadoBusq[i] = (Persona) resultados.getValor(i);
            }
            return resultadoBusq;
        }
        return null;
    }
    
    public Persona[] buscarGeneracion(int numGen) {
        ListaEnlazada generacion = this.arbol.obtenerNodosDeNivel(numGen);
        if (!generacion.estaVacia()) {
            Persona[] resultadoBusq = new Persona[generacion.getCantidad()];
            for (int i = 0; i < generacion.getCantidad(); i++) {
                resultadoBusq[i] = (Persona) generacion.getValor(i);
            }

            return resultadoBusq;
        }
        return null;
    }
    
    public ListaEnlazada generacionesExistentes() {
        ListaEnlazada generaciones = new ListaEnlazada();
        int maxGen = this.arbol.mayorNivel();
        for (int i = 0; i < maxGen; i++) {
            generaciones.agregarAlFinal(i + 1);
        }

        return generaciones;
    }
        
    public String mostrarGeneracion(Persona[] resultados, int numeroGen) {
        String resultadosStr = "Generacion: " + numeroGen;
        for (Persona resultado : resultados) {
            resultadosStr += resultado.toString() + "\n\n";
        }

        return resultadosStr;
    }
    
    public ListaEnlazada alternativasDeGeneracion() {
        return null;
    }
    
    public ListaEnlazada antepasados(Persona persona) {
        NodoArbol nodo = this.arbol.buscarConNombre(persona.getNombreUnico());
        return this.getArbol().obtenerAntepasados(nodo);
    }
        
    public ListaEnlazada mostrarAntepasados(Persona[] arreglo, int index) {
        if (index >= 0 && index < arreglo.length) {
            String clave = arreglo[index].getKnownAs() != null ? arreglo[index].getKnownAs() : 
                           arreglo[index].getFullName() + " " + arreglo[index].getOfHisName();

            NodoArbol raiz = arbol.buscarConNombreDistintivo(clave);
            if (raiz != null) {
                return arbol.listaAncestros(raiz);
            }
        }
        return null;
    }
}
