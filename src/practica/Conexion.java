package practica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    String bd =  "";
    String url = "jdbc:mysql://localhost:3306/"; //conexión a la base de datos Mysql con el puerto de conexión
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection cx; //variable global

    public Conexion(String bd) {
        this.bd = bd;
   
    }
    
    public Connection conectar (){
        try {
            Class.forName(driver); //pasamos el driver
            cx =DriverManager.getConnection(url+bd, user, password); //Cadena de conexión
            System.out.println("Se conecto a base de datos " + bd);
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("No se conecto a base de datos: " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return cx;
    }   
    
    public void desconectar (){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Conexion conexion  =  new Conexion("login");   
        conexion.conectar();
        
        
        
    }
}
