/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 * Clase que representa cada persona contenida en el JSON con su respectiva información personal.
 * 
 * @author Sofia Machado
 */
public class Persona {
    String nombreCompleto; // Nombre y apellido de la persona
    String ofHisName; // Si es un nombre repetido en la familia, cuál es su posición
    String padre; // Nombre del padre
    String madre; // Nombre de la madre
    String conocidoComo; // Nombre por el que es conocido (Mote)
    String titulo; // Título nobiliario
    String wedTo; // Nombre de la pareja
    String ofEyes; // Color de ojos
    String ofHair; // Color de cabello
    String[] fatherTo; // Lista de hijos (se colocó que pudiera tener hasta 20)
    String notes; // Notas adicionales de la persona
    String fate; // Destino de la persona

    /**
     * Constructor que inicializa el nombre completo de la persona y la lista de hijos.
     * 
     * @param nombreCompleto Nombre completo de la persona
     */
    
    public Persona(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        this.fatherTo = new String[20]; // Suponiendo que puede tener hasta 20 hijos
    }

    // Setters para rellenar los datos de la persona según el JSON
    public void setOfHisName(String ofHisName) {
        this.ofHisName = ofHisName;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    public void setConocidoComo(String conocidoComo) {
        this.conocidoComo = conocidoComo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setWedTo(String wedTo) {
        this.wedTo = wedTo;
    }

    public void setOfEyes(String ofEyes) {
        this.ofEyes = ofEyes;
    }

    public void setOfHair(String ofHair) {
        this.ofHair = ofHair;
    }

    /**
     * Agrega un hijo a la lista de hijos.
     * 
     * @param hijo Nombre del hijo a agregar
     */
    public void addFatherTo(String hijo) {
        for (int i = 0; i < fatherTo.length; i++) {
            if (fatherTo[i] == null) {
                fatherTo[i] = hijo; // Asigna el hijo al primer lugar vacío
                break;
            }
        }
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setFate(String fate) {
        this.fate = fate;
    }

    /**
     * Devuelve la información de la persona con todos sus atributos.
     * 
     * @return Información de la persona
     */
    public String toString() {
        StringBuilder info = new StringBuilder("Nombre: " + nombreCompleto + "\n");
        info.append("Numeral en su familia: " + (ofHisName != null ? ofHisName : "null") + "\n");
        info.append("Padre: " + (padre != null ? padre : "null") + "\n");
        info.append("Madre: " + (madre != null ? madre : "null") + "\n");
        info.append("Mote: " + (conocidoComo != null ? conocidoComo : "null") + "\n");
        info.append("Título nobiliario: " + (titulo != null ? titulo : "null") + "\n");
        info.append("Casado con: " + (wedTo != null ? wedTo : "null") + "\n");
        info.append("Color de ojos: " + (ofEyes != null ? ofEyes : "null") + "\n");
        info.append("Color de cabello: " + (ofHair != null ? ofHair : "null") + "\n");
        info.append("Hijos: ");
        for (String hijo : fatherTo) {
            if (hijo != null) {
                info.append(hijo + ", ");
            }
        }
        info.append("\nNotas: " + (notes != null ? notes : "null") + "\n");
        info.append("Destino: " + (fate != null ? fate : "null") + "\n");
        return info.toString();
    }    
}
