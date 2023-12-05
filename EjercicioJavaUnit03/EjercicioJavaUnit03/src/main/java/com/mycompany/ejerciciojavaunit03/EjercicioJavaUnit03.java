/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejerciciojavaunit03;

import clases.CirculoGeometria;
import clases.Cuadrado;
import clases.CuadradoGeometria;
import clases.DiasDeUnMes;
import clases.Doble;
import clases.ImprimirValores;
import clases.LeerNotas;
import clases.MostrarMensaje;
import clases.NumeroMaximo;
import clases.Promedio3;
/**
 *
 * @author Ariel
 */
public class EjercicioJavaUnit03 {

    public static void main(String[] args) {
       MostrarMensaje.shwoMsg(8,"Hola Mundo...");
       
       NumeroMaximo.showMaximo(145, 1533);
       
       Promedio3.showPromedio(25,11, 33);
       
       LeerNotas.showPromedioNotas();
       
       System.out.println("El numero dobel es --> " + Doble.showDoble(148.00));
        
       System.out.println("El cuadrado es --> " + Cuadrado.showCuadrado(3.00));
       
       ImprimirValores.showValores(97.00);
       
        System.out.println("El perímetro del cuadrado es -> " + CuadradoGeometria.perimetro(25));
        System.out.println("La Superficie del cuadrado es -> " + CuadradoGeometria.superficie(25));
        
        System.out.println("El perímetro del circulo es --> " + CirculoGeometria.perimetro(35.66));
        System.out.println("La superficie del circulo es --> " + CirculoGeometria.superficie(0.5f));
        
        DiasDeUnMes.showDias(3);
    }
    
}
