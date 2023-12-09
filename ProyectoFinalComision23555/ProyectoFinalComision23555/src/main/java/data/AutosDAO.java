package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Autos;


public class AutosDAO {        
    
    private static final String SQL_SELECT_BY_ID = "SELECT idauto,marca,modelo,nacionalidad,periodo,potencia,aceleracion,velocidad,precio,imagen FROM deportivos WHERE idauto = ?";
   
    private static final String SQL_SELECT = "SELECT idauto,marca,modelo,nacionalidad,periodo,potencia,aceleracion,velocidad,precio,imagen FROM deportivos";
    
    private static final String SQL_INSERT = "INSERT INTO deportivos(marca,modelo,nacionalidad,periodo,potencia,aceleracion,velocidad,imagen,precio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE deportivos SET marca = ?, modelo = ?,nacionalidad = ?,periodo = ?,potencia = ?,aceleracion = ?,velocidad = ?,imagen = ?,precio = ? WHERE idauto = ?";
    
    private static final String SQL_LOGIC_DELETE = "UPDATE deportivos SET baja = ? WHERE idauto = ?";
   
    private static final String SQL_DELETE = "DELETE FROM deportivos WHERE idauto = ?";
    
    
    
    
    public static List<Autos> seleccionar(int id) {
            
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Autos auto = null;
            List<Autos> autos = new ArrayList();

            try {
                
                conn = getConexion();
                if (id==0){
                    stmt = conn.prepareStatement(SQL_SELECT);
                }else   {
                    stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
                    stmt.setInt(1, id);
                } 
                rs = stmt.executeQuery();
                                 
                while (rs.next()) {
                    int idauto = rs.getInt("idAuto");
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    String nacionalidad = rs.getString("nacionalidad");
                    String periodo = rs.getString("periodo");
                    String potencia = rs.getString("potencia");
                    String aceleracion = rs.getString("aceleracion");
                    String velocidad = rs.getString("velocidad");                    
                    double precio = rs.getDouble("precio");
                    
                    Blob blob = rs.getBlob("imagen");
                    byte[] imagenBytes = blob.getBytes(1,(int)blob.length());
                    
                    auto = new Autos(idauto,marca,modelo,nacionalidad,periodo,potencia,aceleracion,
                        velocidad,precio,imagenBytes);

                    autos.add(auto);
                   
                   
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);                
            }/*finally {
                try {
                    close(rs);
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }*/

            return autos;
        }    
    
    public static Autos seleccionarPorId(int idauto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autos auto = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, idauto);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                //int idauto = rs.getInt("idauto");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String nacionalidad = rs.getString("nacionalidad");
                String periodo = rs.getString("periodo");
                String potencia = rs.getString("potencia");
                String aceleracion = rs.getString("aceleracion");
                String velocidad = rs.getString("velocidad");
                double precio = rs.getDouble("precio");
                
                Blob blob = rs.getBlob("imagen");
                byte[] imagenBytes = blob.getBytes(1,(int)blob.length());
                
                auto = new Autos(idauto,marca,modelo,nacionalidad,periodo,potencia,aceleracion,velocidad,precio,imagenBytes);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } /*finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }*/

        return auto;
    }

    public static int insertar(Autos auto){
      
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModelo());
            stmt.setString(3,auto.getNacionalidad());
            stmt.setString(4,auto.getPeriodo());
            stmt.setString(5,auto.getPotencia());
            stmt.setString(6,auto.getAceleracion());
            stmt.setString(7,auto.getVelocidad());
            
            Blob imagenBlob = conn.createBlob();
            imagenBlob.setBytes(1,auto.getImagen());
            stmt.setBlob(8, imagenBlob);
            
            stmt.setDouble(9,auto.getPrecio());
            
            registros = stmt.executeUpdate();
            
         } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public static int eliminar(Autos auto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, auto.getIdAuto());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }    
     
}
