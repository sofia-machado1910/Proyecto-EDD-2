/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
/**
 * Clase encargada de cargar en un árbol genealógico los datos del JSON que ingrese el usuario.
 * 
 * @author Sofia Machado
 */
public class CargaDeArchivo {
    private ArbolGenealogico arbolGenealogico; // Instancia del árbol genealógico.

    /**
     * Constructor que inicializa el árbol genealógico.
     */
    public CargaDeArchivo() {
        this.arbolGenealogico = new ArbolGenealogico();
    }

    // Getters y setters para el árbol genealógico.
    public ArbolGenealogico getArbolGenealogico() {
        return arbolGenealogico;
    }

    public void setArbolGenealogico(ArbolGenealogico arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }

    /**
     * Carga datos del archivo JSON en el árbol genealógico.
     * 
     * @param rutaJSON Ruta del archivo JSON.
     */
    public void cargarJSON(String rutaJSON) {
        try (FileReader reader = new FileReader(rutaJSON)) {
            Gson gson = new Gson();
            JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
            
            // Procesa cada casa y sus familiares para incorporarlos a la tabla hash.
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray familiares = jsonObj.getAsJsonArray(nombreCasa);
                arbolGenealogico.setLinajeFamilia(nombreCasa);
                for (JsonElement miembro : familiares) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.incorporarHashTable(personaObj);
                }
            }
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray familiares = jsonObj.getAsJsonArray(nombreCasa);
                for (JsonElement miembro : familiares) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.incorporarArbol(personaObj);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el JSON: " + e.getMessage());
        }
    }
    
    /**
     * Incorpora a la persona a la tabla hash a partir de un objeto JSON.
     * 
     * @param personaObj Objeto JSON que representa a la persona.
     */
    private void incorporarHashTable(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray personDetails = personaObj.getAsJsonArray(nombreCompleto);
        Persona nuevaPersona = establecerPersona(nombreCompleto, personDetails);
        
        // Se utiliza el mote o el nombre completo con el ordinal de su nombre en su familia como clave en la tabla hash.
        String clave = (nuevaPersona.getKnownAs() != null) ? nuevaPersona.getKnownAs() : nuevaPersona.getFullName() + " " + nuevaPersona.getOfHisName();
        this.arbolGenealogico.getHashTable().put(clave, nuevaPersona);
    }
    
    /**
     * Incorpora a la persona al árbol genealógico a partir de un objeto JSON.
     * 
     * @param personaObj Objeto JSON que representa a la persona.
     */
    private void incorporarArbol(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray personDetails = personaObj.getAsJsonArray(nombreCompleto);
        Persona nuevaPersona = establecerPersona(nombreCompleto, personDetails);
        
        // Crea la raíz del árbol o agrega la persona como hijo de su padre.
        if (nuevaPersona.getFather().equalsIgnoreCase("[Unknown]")) {
            this.arbolGenealogico.getArbol().crearRaiz(nuevaPersona);
        } else {
            nuevaPersona.setFather(nuevaPersona.getFather().replaceAll("of his name", "").replaceAll(",", "").trim());
            NodoArbol padre = this.arbolGenealogico.getArbol().buscarConNombreDistintivo(nuevaPersona.getFather());
            if (padre != null) {
                this.arbolGenealogico.getArbol().agregarHijo(padre, nuevaPersona);
            }
        }
    }

    /**
     * Establece una nueva persona a partir de su nombre completo y sus datos personales.
     * 
     * @param nombreCompleto Nombre completo de la persona.
     * @param personDetails Detalles de la persona en formato JSON.
     * @return Una instancia de Persona con los datos establecidos.
     */
    private Persona establecerPersona(String nombreCompleto, JsonArray personDetails) {
        String ordinal = null;
        String padre = null;
        String madre = null;
        String nickname = null;
        String titulo = null;
        String pareja = null;
        String colorOjos = null;
        String colorCabello = null;
        String NotasDeVida = null;
        String destino = null;
        
        // Procesa los detalles de la persona para establecer sus atributos.
        for (JsonElement detail : personDetails) {
            JsonObject atributo = detail.getAsJsonObject();
            if (atributo.has("Of his name")) {
                ordinal = atributo.get("Of his name").getAsString();
            } else if (atributo.has("Born to")) {
                String parent = atributo.get("Born to").getAsString();
                if (padre == null) {
                    padre = parent;
                } else {
                    madre = parent;
                }
            } else if (atributo.has("Known throughout as")) {
                nickname = atributo.get("Known throughout as").getAsString();
            } else if (atributo.has("Held title")) {
                titulo = atributo.get("Held title").getAsString();
            } else if (atributo.has("Wed to")) {
                pareja = atributo.get("Wed to").getAsString();
            } else if (atributo.has("Of eyes")) {
                colorOjos = atributo.get("Of eyes").getAsString();
            } else if (atributo.has("of hair")) {
                colorCabello = atributo.get("of hair").getAsString();
            } else if (atributo.has("Notes")) {
                NotasDeVida = atributo.get("Notes").getAsString();
            } else if (atributo.has("Fate")) {
                destino = atributo.get("Fate").getAsString();
            }
        }
        return new Persona(nombreCompleto, ordinal, padre, madre, nickname, titulo, pareja, colorOjos, colorCabello, NotasDeVida, destino);
    }    
}