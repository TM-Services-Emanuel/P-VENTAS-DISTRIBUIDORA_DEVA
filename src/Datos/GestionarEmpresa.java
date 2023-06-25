package Datos;

import Componentes.OperacionMovil;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
//import Modelo.Familia;
import Modelo.Empresa;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestionarEmpresa {

    public static String getCodigo() {
        int cod = Integer.parseInt(generarCodigos.getCodigoEmpresa("SELECT MAX(idempresa) FROM empresa"))+1;
        return String.valueOf(cod);
    }

    public static String addEmpresa(Empresa e) {
        String msg = null;
        
        try {
            JSONArray jsonArrayNW_Empresa = new JSONArray();
            JSONObject jsonObjectNW_Empresa = new JSONObject();
            try {
                jsonObjectNW_Empresa.put("id_empresa", e.getCodEmpresa());
                jsonObjectNW_Empresa.put("razon_social", e.getEmpresa());
                jsonObjectNW_Empresa.put("ruc", e.getRuc());
                jsonObjectNW_Empresa.put("direccion", e.getDireccion());
                jsonObjectNW_Empresa.put("telefono", e.getTelefono());
                jsonObjectNW_Empresa.put("ciudad_idciudad", e.getIdciudad());
                jsonObjectNW_Empresa.put("estado", "S");
                

            } catch (JSONException new_empresa) {
                System.out.println(new_empresa.getMessage());
            }
            jsonArrayNW_Empresa.put(jsonObjectNW_Empresa);
            JSONObject json = new JSONObject();
            try {
                json.put("empresa", jsonArrayNW_Empresa);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer()+"saveEmpresa.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonEmpresa", json);

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
                StringBuilder resp = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    resp.append(scan.nextLine());
                }
                scan.close();
                msg = resp.toString();
                System.out.println(resp);
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }
//        msg = Operacion.exeOperacion("INSERT INTO unidad VALUES ("+u.getCodUnidad()+",'"+u.getUnidad()+"','S')");
        return msg;
    }

    public static Empresa busEmpresa(String cod) {
        Empresa e = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM v_empresa WHERE idempresa = '");
        sql.append(cod);
        sql.append("'");
//        String sql = "SELECT * FROM unidad WHERE uni_codigo = '"+cod+"'";
        Object[] filaObt = OperacionMovil.getFila(sql.toString());
        if (filaObt != null) {
            e = new Empresa();
            e.setCodEmpresa(Integer.parseInt(filaObt[0].toString()));
            e.setEmpresa(filaObt[1].toString());
        } else {
        }
        return e;
    }

    public static List listEmpresa() {
        String sql = "select * from v_empresa1 WHERE estado='S'";
        return OperacionMovil.getTabla(sql);
    }

    /* public static String actEmpresa(Empresa e) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE empresa SET em_razonsocial = '").append(e.getEmpresa());
        sql.append("',em_ruc='").append(e.getRuc());
        sql.append("',em_direccion='").append(e.getDireccion());
        sql.append("',em_telefono='").append(e.getTelefono());
        sql.append("',em_celular='").append(e.getCelular());
        sql.append("',em_visualizar='").append(e.getVisual());
        sql.append("',usu='").append(e.getUsuario());
        sql.append("' WHERE em_codigo=").append(e.getCodEmpresa()).append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }
     */
    public static String actEmpresa(Empresa e) {
        String msg = null;
        try {
            JSONArray jsonArrayACT_Empresa = new JSONArray();
            JSONObject jsonObjectACT_Empresa = new JSONObject();
            try {
                jsonObjectACT_Empresa.put("razon_social", e.getEmpresa());
                jsonObjectACT_Empresa.put("ruc", e.getRuc());
                jsonObjectACT_Empresa.put("direccion", e.getDireccion());
                jsonObjectACT_Empresa.put("telefono", e.getTelefono());
                jsonObjectACT_Empresa.put("ciudad_idciudad", e.getIdciudad());
                jsonObjectACT_Empresa.put("id_empresa", e.getCodEmpresa());

            } catch (JSONException act_empresa) {
                System.out.println(act_empresa.getMessage());
            }
            jsonArrayACT_Empresa.put(jsonObjectACT_Empresa);
            JSONObject json = new JSONObject();
            try {
                json.put("empresa", jsonArrayACT_Empresa);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer()+"actEmpresa.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonEmpresa", json);

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
                StringBuilder Respuesta = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Respuesta.append(scan.nextLine());
                }
                scan.close();
                msg = Respuesta.toString();
                System.out.println(Respuesta);
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }

        return msg;
    }

    public static String delEmpresa(String cod) {
        String msg = null;
        try {
            JSONArray jsonArrayDEL_Empresa = new JSONArray();
            JSONObject jsonObjectDEL_Empresa = new JSONObject();
            try {
                jsonObjectDEL_Empresa.put("id_empresa", cod);
                jsonObjectDEL_Empresa.put("estado", "N");

            } catch (JSONException act_empresa) {
                System.out.println(act_empresa.getMessage());
            }
            jsonArrayDEL_Empresa.put(jsonObjectDEL_Empresa);
            JSONObject json = new JSONObject();
            try {
                json.put("empresa", jsonArrayDEL_Empresa);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer()+"delEmpresa.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonEmpresa", json);

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
                StringBuilder Respuesta = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Respuesta.append(scan.nextLine());
                }
                scan.close();
                msg = Respuesta.toString();
                System.out.println(Respuesta);
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }

        return msg;
    }

}
