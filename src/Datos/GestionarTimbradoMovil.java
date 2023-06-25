package Datos;

import Componentes.OperacionMovil;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.TimbradoMovil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestionarTimbradoMovil {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoTimbrado("SELECT MAX(idtimbrado) from timbrado ");
        return cod;
    }

    public static String addTimbrado(TimbradoMovil m) {
        String msg = null;
        try {
            JSONArray jsonArrayTimbrado = new JSONArray();
            JSONObject jsonObjectTimbrado = new JSONObject();
            try {
                jsonObjectTimbrado.put("idtimbrado", m.getCodT());
                jsonObjectTimbrado.put("descripcion", m.getDescripcion());
                jsonObjectTimbrado.put("fechadesde", m.getFechadesde());
                jsonObjectTimbrado.put("fechahasta", m.getFechahasta());
                jsonObjectTimbrado.put("nr_autorizacion", m.getAutorizacion());
                jsonObjectTimbrado.put("fecha_autorizacion", m.getFautorizacion());
                jsonObjectTimbrado.put("estado", m.getEstado());
                
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayTimbrado.put(jsonObjectTimbrado);
            JSONObject json = new JSONObject();
            try {
                json.put("timbrado", jsonArrayTimbrado);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "saveTimbrado.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonTimbrado", json);

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
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }
        return msg;
    }

    public static String actTimbrado(TimbradoMovil m) {
        String msg = null;
        try {
            JSONArray jsonArrayTimbrado = new JSONArray();
            JSONObject jsonObjectTimbrado = new JSONObject();
            try {
                jsonObjectTimbrado.put("idtimbrado", m.getCodT());
                jsonObjectTimbrado.put("descripcion", m.getDescripcion());
                jsonObjectTimbrado.put("fechadesde", m.getFechadesde());
                jsonObjectTimbrado.put("fechahasta", m.getFechahasta());
                jsonObjectTimbrado.put("nr_autorizacion", m.getAutorizacion());
                jsonObjectTimbrado.put("fecha_autorizacion", m.getFautorizacion());
                jsonObjectTimbrado.put("estado", m.getEstado());
                
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayTimbrado.put(jsonObjectTimbrado);
            JSONObject json = new JSONObject();
            try {
                json.put("timbrado", jsonArrayTimbrado);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actTimbrado.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonTimbrado", json);

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
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }
        return msg;
    }

    public static String delTimbrado(int cod) {
        String msg = null;
        try {
            JSONArray jsonArrayTimbrado = new JSONArray();
            JSONObject jsonObjectTimbrado = new JSONObject();
            try {
                jsonObjectTimbrado.put("idtimbrado", cod);
                jsonObjectTimbrado.put("estado", "Inactivo");
                
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayTimbrado.put(jsonObjectTimbrado);
            JSONObject json = new JSONObject();
            try {
                json.put("timbrado", jsonArrayTimbrado);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delTimbrado.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonTimbrado", json);

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
            }
        } catch (IOException ee) {
            System.out.println(ee.getMessage());
        }
        return msg;
    }

    /*public static List listTimbrado() {
        //String sql = "SELECT * FROM timbrado WHERE estado='S'";
        String sql = "SELECT * FROM timbrado";
        return OperacionMovil.getTabla(sql);
    }*/

}
