package Componentes;

import java.sql.*;

public class ConexionBD {
    
    private ConexionBD(){
        
    }
    
    
    private static Connection conexion;
    
    private static ConexionBD instancia;
    
    /*private static final String URL = "jdbc:mysql://127.0.0.1:3306/u200536584_bddeva";
    private static final String USER = "root";
    private static final String PASSWORD = "";*/
    private static final String URL = "jdbc:mysql://191.96.56.103:3306/u200536584_bddeva";
    private static final String USER = "u200536584_deva";
    private static final String PASSWORD = "Emanuel.4744832$";

    public Connection getConexion() {
        try {
            //MySQL
            Class.forName("org.mariadb.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            conexion = null;
            Mensajes.error("Error conexión: "+e.getMessage());
        }
        return conexion;
    }
    
    public void CerrarConexion() throws SQLException{
        try{
            conexion.close();
        }catch(SQLException e){
            Mensajes.error("Error cerrando conexión");
            conexion.close();
        }
    }
    
    //patron singleton
    public static ConexionBD getInstancia(){
        if(instancia == null){
            instancia = new ConexionBD();
        }
        return instancia;
    }

}
