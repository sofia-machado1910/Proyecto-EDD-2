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

    String fullName; // Nombre y apellido de la persona
    String ofHisName; // Si es un nombre repetido en la familia, cuál es su posición
    String father; // Nombre del father
    String mother; // Nombre de la mother
    String knownAs; // Nombre por el que es conocido (Mote)
    String title; // Título nobiliario
    String wedTo; // Nombre de la pareja
    String ofEyes; // Color de ojos
    String ofHair; // Color de cabello
    String notes; // Notas adicionales de la persona
    String fate; // Destino de la persona

    /**
     * Constructor que inicializa todos los atributos de la persona.
     *
     * @param fullName Nombre completo de la persona.
     * @param ofHisName Numeral de la persona, es decir, su ordinal en la familia.
     * @param father Su padre.
     * @param mother Su madre.
     * @param knownAs Mote o nickname por la que se conoce a la persona.
     * @param title Título nobiliario de la persona.
     * @param wedTo Nombre de la pareja.
     * @param ofEyes Color de ojos de la persona.
     * @param ofHair Color de cabello de la persona.
     * @param notes Notas adicionales de la vida de la persona.
     * @param fate Destino o muerte de la persona.
     */
    public Persona(String fullName, String ofHisName, String father, String mother, String knownAs, String title, String wedTo, String ofEyes, String ofHair, String notes, String fate) {
        this.fullName = fullName;
        this.ofHisName = ofHisName;
        this.father = father;
        this.mother = mother;
        this.knownAs = knownAs;
        this.title = title;
        this.wedTo = wedTo;
        this.ofEyes = ofEyes;
        this.ofHair = ofHair;
        this.notes = notes;
        this.fate = fate;
    }
    
    /**
     * Constructor que inicializa algunos atributos básicos de la persona.
     *
     * @param fullName Nombre completo de la persona.
     * @param ofHisName Numeral de la persona, es decir, su ordinal en la familia.
     * @param father Su padre.
     * @param title Título nobiliario de la persona.
     */
    
    public Persona(String fullName, String ofHisName, String father, String title) {
        this.fullName = fullName;
        this.ofHisName = ofHisName;
        this.father = father;
        this.title = title;
    }
    
    //Getters para acceder a los atributos
    public String getFullName() {
        return fullName;
    }

    public String getOfHisName() {
        return ofHisName;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public String getTitle() {
        return title;
    }

    public String getWedTo() {
        return wedTo;
    }

    public String getOfEyes() {
        return ofEyes;
    }

    public String getOfHair() {
        return ofHair;
    }

    public String getNotes() {
        return notes;
    }

    public String getFate() {
        return fate;
    }
    
    // Setters para rellenar los datos de la persona según el JSON
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setOfHisName(String ofHisName) {
        this.ofHisName = ofHisName;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setFate(String fate) {
        this.fate = fate;
    }
    
    /**
     * Si tiene mote, devuelve el nombre con su mote o, si no, devuelve el nombre completo con el ordinal de su noombre en la familia.
     *
     * @return Nombre ordinal de la persona.
     */
    public String distinctiveName(){
        if(this.getKnownAs() != null){
           return this.getKnownAs();
        }
        return this.fullName + " " + this.ofHisName;
    }

    /**
     * Devuelve la información de la persona con ciertos atributos.
     * 
     * @return Información de la persona
     */
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Nombre: " + fullName + "\n").append(this.distinctiveName());;
        info.append("Padre: " + (father != null ? father : "null") + "\n");
        info.append("Madre: " + (mother != null ? mother : "null") + "\n");
        info.append("Mote: " + (knownAs != null ? knownAs : "null") + "\n");
        info.append("Título nobiliario: " + (title != null ? title : "null") + "\n");
        info.append("Casado con: " + (wedTo != null ? wedTo : "null") + "\n");
        info.append("Color de ojos: " + (ofEyes != null ? ofEyes : "null") + "\n");
        info.append("Color de cabello: " + (ofHair != null ? ofHair : "null") + "\n");
        info.append("\nNotas: " + (notes != null ? notes : "null") + "\n");
        info.append("Destino: " + (fate != null ? fate : "null") + "\n");
        return info.toString();
    }    
}
