/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.AutosDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import model.Autos;


/**
 *
 * @author Ariel
 */
@WebServlet("/autos")
public class AutosServletControler extends HttpServlet {

    List<Autos> autosList = new ArrayList();
    ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String route = req.getParameter("action");
        
       
       if (route.equals("getAll")){
              
            res.setContentType("application/json; charset=UTF-8");
            autosList = AutosDAO.seleccionar();
            
            for (Autos auto : autosList){
                byte[] imagenBytes = auto.getImagen();
                String imagenBase64 = Base64.getEncoder().encodeToString(imagenBytes);
                auto.setImagenBase64(imagenBase64);
            }
            mapper.writeValue(res.getWriter(), autosList);
            } else{        
                 System.out.println("parametro no valido");
           }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res){
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest req,HttpServletResponse res){
        
    }    
}
