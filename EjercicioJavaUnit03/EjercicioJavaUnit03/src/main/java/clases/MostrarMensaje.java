/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Ariel
 */
public class MostrarMensaje {
    
    MostrarMensaje(){}
    
    public static void shwoMsg (int cantidad,String mensaje){
        
        for (int i=1;i<=cantidad;i++){
            System.out.println("Mensaje numero -->  " + i + "\n" + mensaje);
        }
    }
    
}
