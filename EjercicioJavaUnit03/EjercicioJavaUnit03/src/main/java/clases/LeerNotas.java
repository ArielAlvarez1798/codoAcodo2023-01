/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author Ariel
 */
public class LeerNotas {
    
    public static void showPromedioNotas(){
        
        Scanner scn = new Scanner(System.in);
        double nota = 0;
        int cantidadIngreso = 0;
        double sumaNotas = 0;
        while (nota >= 0){
           
            nota = scn.nextInt();
            
            if (nota >=0){
                cantidadIngreso++;
                sumaNotas=sumaNotas+nota;
            }
        }
        System.out.println("El promedio de las notas ingresadas es  --> " + (sumaNotas/cantidadIngreso));
    }
}
