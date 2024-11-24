/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd_2;

/**
 *
 * @author Andrea Villasmil
 */

public class Validar {
    
    // Método privado para verificar si la cadena solo contiene números
    private boolean validarSoloNumeros(String num) {
        // Usamos una expresión regular para comprobar si 'num' tiene solo dígitos
        return num.matches("[0-9]*");
    }
    
    // Método público para validar y convertir una cadena a un número entero
    public int validarNumeros(String numero) {
        // Verificamos si la cadena 'numero' contiene solo números
        if (validarSoloNumeros(numero)) {
            // Si es válido, convertimos la cadena a un número entero
            int num = Integer.parseInt(numero);
            return num; // Devolvemos el número entero
        } else {
            // Si no es válido, devolvemos -1 para indicar un error
            return -1; 
        }
    }
}