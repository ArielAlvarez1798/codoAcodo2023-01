
import data.AutosDAO;
import java.util.List;
import model.Autos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ariel
 */
public class main {
    
    //public static void main(String[] args) {
     public void lista(){
         List<Autos> listaAutos;
         listaAutos = AutosDAO.seleccionar(0);
         System.out.println("Lista de autos" + listaAutos.size());
         for (Autos a : listaAutos){
             System.out.println("Autos: " + a);
         }
         
         Autos au = AutosDAO.seleccionarPorId(1);
         System.out.println("***>>" + au) ;
         
         /*
         Autos newAuto = new Autos("a","b","c","d","e","f","g",1500,null);
         int res = AutosDAO.insertar(newAuto);
         System.out.println("resultado " + res);*/
         
     }
    
}
