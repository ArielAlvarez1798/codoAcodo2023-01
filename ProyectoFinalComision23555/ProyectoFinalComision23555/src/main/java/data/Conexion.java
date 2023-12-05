package data;

import jakarta.activation.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL="jdbc:mysql://localhost:3306/tpfinalcodocodo?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";    
    public static final String JDBC_USER="root";
    public static final String JDBC_PASS="root";      
    
    public static BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(100);
        return ds;
    }
    
    public static Connection getConexion() throws SQLException{  
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");            
        }catch(ClassNotFoundException ex){
            ex.printStackTrace(System.out);            
        }                       
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement st) throws SQLException{
        st.close();
    }   
    
    public static void close(Connection cn) throws SQLException{
        cn.close();
    }    
    
       
}
