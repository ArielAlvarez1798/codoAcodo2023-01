/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Ariel
 */
public class DiasDeUnMes {
    
    public static void showDias(int mes){
        
        switch(mes){
            case 1:case 3:case 7:case 8:case 10:case 12:
                System.out.println("El mes --> " + mes +" 31 días");
                break;
            case 4:case 6:case 9:case 11:
                System.out.println("El mes --> " + mes +" 30 días"); 
                break;
            case 2:
                System.out.println("El mes --> " + mes +" tiene 28 días"); 
                break;
        }
    }
    
}
