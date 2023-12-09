/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.AutosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Autos;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author Ariel
 */
@WebServlet("/autos")
@MultipartConfig(
        location = "/media/temp",
        fileSizeThreshold = 1024 * 1024, //1 mb tamaño umbral
        maxFileSize = 1024 * 1024 * 5 , //tamaño maximo en bytes 5mb
        maxRequestSize = 1024 * 1024 * 10
)

public class AutosServletControler extends HttpServlet {

    List<Autos> autosList = new ArrayList();
    ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String route = req.getParameter("action");
        
       
       if (route.equals("getAll")){             
            res.setContentType("application/json; charset=UTF-8");
            autosList = AutosDAO.seleccionar(0);
            
            for (Autos auto : autosList){
                byte[] imagenBytes = auto.getImagen();
                String imagenBase64 = Base64.getEncoder().encodeToString(imagenBytes);
                auto.setImagenBase64(imagenBase64);                
            }
                mapper.writeValue(res.getWriter(), autosList);
            }
       
        if (route.equals("getDetails")){
            String idauto = req.getParameter("idAuto");
            res.setContentType("application/json; charset=UTF-8");
            
            Autos autoDetail = AutosDAO.seleccionarPorId(Integer.parseInt(idauto));          
            
            mapper.writeValue(res.getWriter(), autoDetail);           
        }
        
        if (route.equals("getById")){
            String idauto = req.getParameter("idAuto");
            res.setContentType("application/json; charset=UTF-8");
            
            Autos autoDetail = AutosDAO.seleccionarPorId(Integer.parseInt(idauto));          
            
            byte[] imagenByte = autoDetail.getImagen();
            String imagenBase64 = Base64.getEncoder().encodeToString(imagenByte);
            autoDetail.setImagenBase64(imagenBase64);
          
            mapper.writeValue(res.getWriter(), autoDetail);           
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        String route = req.getParameter("action");
        
        if (route.equals("add")){        
                String marca = req.getParameter("marca");
                String modelo = req.getParameter("modelo");
                String nacionalidad = req.getParameter("nacionalidad");
                String periodo = req.getParameter("periodo");
                String potencia = req.getParameter("potencia");
                String aceleracion = req.getParameter("aceleracion");
                String velocidad = req.getParameter("velocidad");
                Double precio = Double.parseDouble(req.getParameter("precio"));
                
                Part filePart = req.getPart("imagen");
                byte[] imagenBytes = IOUtils.toByteArray(filePart.getInputStream());
                
                Autos newAuto = new Autos(marca,modelo,nacionalidad,periodo,potencia,aceleracion,velocidad,precio,imagenBytes);
                AutosDAO.insertar(newAuto);
                res.setContentType("application/json");
                Map <String,String> response = new HashMap();
                response.put("message","Libro Agregado Exitosamente ...");
                mapper.writeValue(res.getWriter(), response);
                
            }
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest req,HttpServletResponse res){
        
    }    
}
