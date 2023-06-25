package Componentes;


import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class CargarJList {
    static DefaultComboBoxModel modeloCombo;
    static ConexionBD conectar = ConexionBD.getInstancia();
    
    public static void cargar(JList cb, String sql)
    {
        try {
            try (Connection con = (Connection) conectar.getConexion() //Nos conectamos
            ) {
                Statement st = (Statement) con.createStatement();
                try (ResultSet rs = (ResultSet) st.executeQuery(sql)) {
                    modeloCombo = new DefaultComboBoxModel();
                    cb.setModel(modeloCombo);
                    while (rs.next()) {
                        //recorremos la tabla
                        //Agregamos al combo los valores
                        modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2)));
                    }
                    rs.close();
                    st.close();
                    con.close();
                    //Cerramos el recorrido
                    //Cerramos la conexion
                }
            }
        } catch (NumberFormatException | SQLException e) {
            //Excepcion en caso haya conexion
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }
    
    public static String getCodidgo(JList cb)//Metodo para Obtener el id
    {
        Combo c = (Combo)cb.getSelectedValue();//Seleccionamos
        int id = c.getCodigo();//Obtenermos el id
        System.out.println("getCodigo: "+id);
        return String.valueOf(id);//Retornamos el codigo
    }
}
