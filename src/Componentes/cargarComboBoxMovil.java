package Componentes;

import static Componentes.URL.urlServer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import org.json.JSONArray;
import org.json.JSONObject;

public class cargarComboBoxMovil {

    static DefaultComboBoxModel modeloCombo;
    static DefaultComboBoxModel modelClasificacion;
    static DefaultComboBoxModel modelDepartamentos;
    static DefaultComboBoxModel modelUM;
    static DefaultComboBoxModel modelImpuesto;
    static DefaultComboBoxModel modelTimbrado;
    static DefaultComboBoxModel modelBancos;
    static DefaultComboBoxModel modelMotivo;
    static DefaultComboBoxModel modelMotivoSalida;
    static DefaultComboBoxModel modelProveedor;
    static DefaultComboBoxModel modelDeposito;
    
    static ConexionBD conectar = ConexionBD.getInstancia();

    public static void cargar(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modeloCombo.addElement(new Combo(Integer.parseInt(objectCargar.get("idciudad").toString()), objectCargar.get("ciudad").toString()));
                }
                cb.setModel(modeloCombo);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboDepartamento(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelDepartamentos = new DefaultComboBoxModel();
                modelDepartamentos.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelDepartamentos.addElement(new Combo(Integer.parseInt(objectCargar.get("iddepartamento").toString()), objectCargar.get("departamento").toString()));
                }
                cb.setModel(modelDepartamentos);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboMotivo(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelMotivo = new DefaultComboBoxModel();
                modelMotivo.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelMotivo.addElement(new Combo(Integer.parseInt(objectCargar.get("mot_codigo").toString()), objectCargar.get("mot_nombre").toString()));
                }
                cb.setModel(modelMotivo);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboDeposito(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelDeposito = new DefaultComboBoxModel();
                modelDeposito.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelDeposito.addElement(new Combo(Integer.parseInt(objectCargar.get("iddeposito").toString()), objectCargar.get("nombre").toString(), objectCargar.get("tabla").toString()));
                }
                cb.setModel(modelDeposito);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboMotivo_Salida(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelMotivoSalida = new DefaultComboBoxModel();
                modelMotivoSalida.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelMotivoSalida.addElement(new Combo(Integer.parseInt(objectCargar.get("idmotivo").toString()), objectCargar.get("descripcion").toString()));
                }
                cb.setModel(modelMotivoSalida);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboClasificacion(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelClasificacion = new DefaultComboBoxModel();
                modelClasificacion.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelClasificacion.addElement(new Combo(Integer.parseInt(objectCargar.get("iddivision").toString()), objectCargar.get("descripcion").toString()));
                }
                cb.setModel(modelClasificacion);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboBancos(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelBancos = new DefaultComboBoxModel();
                modelBancos.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelBancos.addElement(new Combo(Integer.parseInt(objectCargar.get("idbancos").toString()), objectCargar.get("descripcion").toString()));
                }
                cb.setModel(modelBancos);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargarCboUM(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelUM = new DefaultComboBoxModel();
                modelUM.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelUM.addElement(new Combo(Integer.parseInt(objectCargar.get("idunidad").toString()), objectCargar.get("unidadmedida").toString()));
                }
                cb.setModel(modelUM);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboImpuesto(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelImpuesto = new DefaultComboBoxModel();
                modelImpuesto.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelImpuesto.addElement(new Combo(Integer.parseInt(objectCargar.get("idiva").toString()), objectCargar.get("descripcion").toString()));
                }
                cb.setModel(modelImpuesto);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCiudad(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modeloCombo.addElement(new Combo(Integer.parseInt(objectCargar.get("idciudad").toString()), objectCargar.get("ciudad").toString()));
                }
                cb.setModel(modeloCombo);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboTimbrado(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelTimbrado = new DefaultComboBoxModel();
                modelTimbrado.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelTimbrado.addElement(new Combo(Integer.parseInt(objectCargar.get("idtimbrado").toString()), objectCargar.get("descripcion").toString()));
                }
                cb.setModel(modelTimbrado);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cargarCboProveedor(JComboBox cb, String sql) {
        try {
            URL url = new URL(urlServer()+"getCargarComboBox.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

            StringBuilder postID = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postID.length() != 0) {
                    postID.append('&');
                }
                postID.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postID.append('=');
                postID.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postBytesID = postID.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytesID.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytesID);

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Resultado = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Resultado.append(scan.nextLine());
                }
                scan.close();

                modelProveedor = new DefaultComboBoxModel();
                modelProveedor.addElement("SELEC. UNA OPCIÓN");
                JSONArray jsonCargar = new JSONArray(Resultado.toString());
                for (int i = 0; i < jsonCargar.length(); i++) {
                    JSONObject objectCargar = jsonCargar.getJSONObject(i);
                    modelProveedor.addElement(new Combo(Integer.parseInt(objectCargar.get("pro_codigo").toString()), objectCargar.get("pro_razonsocial").toString()));
                }
                cb.setModel(modelProveedor);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargarCliente(JComboBox cb, String sql) {
        try {
            try ( Connection con = (Connection) conectar.getConexion()//Nos conectamos
                    ) {
                Statement st = (Statement) con.createStatement();
                try ( ResultSet rs = (ResultSet) st.executeQuery(sql)) {
                    modeloCombo = new DefaultComboBoxModel();
                    modeloCombo.addElement("SELECCIONE UN CLIENTE");
                    while (rs.next()) {//recorremos la tabla
                        //Agregamos al combo los valores
                        modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(4) + " - " + rs.getString(3)));
                    }
                    cb.setModel(modeloCombo);
                    //Cerramos el recorrido
                    //Cerramos la conexion
                }
            }
        } catch (NumberFormatException | SQLException e) {
            //Excepcion en caso haya conexion
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarPE(JComboBox cb, String sql) {
        try {
            try ( Connection con = (Connection) conectar.getConexion()//Nos conectamos
                    ) {
                Statement st = (Statement) con.createStatement();
                try ( ResultSet rs = (ResultSet) st.executeQuery(sql)) {
                    modeloCombo = new DefaultComboBoxModel();
                    modeloCombo.addElement("SELEC. P. EMISIÓN");
                    while (rs.next()) {//recorremos la tabla
                        //Agregamos al combo los valores
                        modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2) + "-" + rs.getString(3) + " REF: " + rs.getString(4)));
                    }
                    cb.setModel(modeloCombo);
                    //Cerramos el recorrido
                    //Cerramos la conexion
                }
            }
        } catch (NumberFormatException | SQLException e) {
            //Excepcion en caso haya conexion
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarList(JList cb, String sql) {
        try {
            try ( Connection con = (Connection) conectar.getConexion()//Nos conectamos
                    ) {
                Statement st = (Statement) con.createStatement();
                try ( ResultSet rs = (ResultSet) st.executeQuery(sql)) {
                    modeloCombo = new DefaultComboBoxModel();
                    cb.setModel(modeloCombo);
                    while (rs.next()) {
                        //recorremos la tabla
                        //Agregamos al combo los valores
                        modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2)));
                    }
                    //Cerramos el recorrido
                    //Cerramos la conexion
                }
            }
        } catch (NumberFormatException | SQLException e) {
            //Excepcion en caso haya conexion
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarProv(JComboBox cb, String sql) {
        try {
            try ( Connection con = (Connection) conectar.getConexion()//Nos conectamos
                    ) {
                Statement st = (Statement) con.createStatement();
                try ( ResultSet rs = (ResultSet) st.executeQuery(sql)) {
                    modeloCombo = new DefaultComboBoxModel();
                    cb.setModel(modeloCombo);
                    while (rs.next()) {
                        //recorremos la tabla
                        //Agregamos al combo los valores
                        modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2) + " -- RUC: " + rs.getString(3)));
                    }
                    //Cerramos el recorrido
                    //Cerramos la conexion
                }
            }
        } catch (NumberFormatException | SQLException e) {
            //Excepcion en caso haya conexion
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarCli(JComboBox cb, String sql) {
        try {
            try ( Connection con = (Connection) conectar.getConexion()//Nos conectamos
                    ) {
                Statement st = (Statement) con.createStatement();
                try ( ResultSet rs = (ResultSet) st.executeQuery(sql)) {
                    modeloCombo = new DefaultComboBoxModel();
                    modeloCombo.addElement("SELEC. UNA OPCIÓN");
                    cb.setModel(modeloCombo);
                    while (rs.next()) {
                        //recorremos la tabla
                        //Agregamos al combo los valores
                        modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(3) + " -- RUC/C.I.: " + rs.getString(4)));
                    }
                    //Cerramos el recorrido
                    //Cerramos la conexion
                }
            }
        } catch (NumberFormatException | SQLException e) {
            //Excepcion en caso haya conexion
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static String getCodidgo(JComboBox cb)//Metodo para Obtener el id
    {
        Combo c = (Combo) cb.getSelectedItem();//Seleccionamos
        int id = c.getCodigo();//Obtenermos el id
        //System.out.println(id);
        return String.valueOf(id);//Retornamos el codigo
    }

    public static String getDesc(JComboBox cb)//Metodo para Obtener el id
    {
        Combo c = (Combo) cb.getSelectedItem();//Seleccionamos
        String id = c.getDesc();//Obtenermos el id
        //System.out.println(id);
        return (id);//Retornamos el codigo
    }

    public static String getCodidgoL(JList cb)//Metodo para Obtener el id
    {
        Combo c = (Combo) cb.getSelectedValue();//Seleccionamos
        int id = c.getCodigo();//Obtenermos el id
        //System.out.println(id);
        return String.valueOf(id);//Retornamos el codigo
    }

    public static String getDescList(JList cb)//Metodo para Obtener el id
    {
        Combo c = (Combo) cb.getSelectedValue();//Seleccionamos
        String des = c.getDesc();//Obtenermos el id
        //System.out.println(des);
        return String.valueOf(des);//Retornamos el codigo
    }

}
