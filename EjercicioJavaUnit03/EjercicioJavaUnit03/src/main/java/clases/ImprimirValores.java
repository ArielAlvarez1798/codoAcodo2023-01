/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Ariel
 */
public class ImprimirValores {
    
    public static void showValores(Double num){
        
        System.out.println("El numero siguiente es --> " + (num + 1));
        System.out.println("El doble del numero es --> " + Doble.showDoble(num));
        System.out.println("El cuadrado del numero es --> " + Cuadrado.showCuadrado(num));
    }
}
