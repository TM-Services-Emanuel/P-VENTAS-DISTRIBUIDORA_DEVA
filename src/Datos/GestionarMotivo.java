package Datos;

import Componentes.Operacion;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.Motivo;
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

public class GestionarMotivo {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoMotivo("SELECT IFNULL ((select MAX(mot_codigo) from motivo),0) AS mot_codigo");
        return cod;
    }
    
    public static String addMotivo(Motivo m) {
        String msg = null;
        try {
            JSONArray jsonArrayMotivo = new JSONArray();
            JSONObject jsonObjectMotivo = new JSONObject();
            try {
                jsonObjectMotivo.put("mot_codigo", m.getCodM());
                jsonObjectMotivo.put("mot_nombre", m.getMotivo());
                jsonObjectMotivo.put("mot_indicador", "S");
                jsonObjectMotivo.put("usu", m.getUsuario());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayMotivo.put(jsonObjectMotivo);
            JSONObject json = new JSONObject();
            try {
                json.put("motivo", jsonArrayMotivo);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "saveMotivo.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonMotivo", json);

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
    
    public static String actMotivo(Motivo m) {
        String msg = null;
        try {
            JSONArray jsonArrayMotivo = new JSONArray();
            JSONObject jsonObjectMotivo = new JSONObject();
            try {
                jsonObjectMotivo.put("mot_codigo", m.getCodM());
                jsonObjectMotivo.put("mot_nombre", m.getMotivo());
                jsonObjectMotivo.put("usu", m.getUsuario());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayMotivo.put(jsonObjectMotivo);
            JSONObject json = new JSONObject();
            try {
                json.put("motivo", jsonArrayMotivo);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actMotivo.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonMotivo", json);

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

    public static String delMotivo(Motivo m) {
        String msg = null;
        try {
            JSONArray jsonArrayMotivo = new JSONArray();
            JSONObject jsonObjectMotivo = new JSONObject();
            try {
                jsonObjectMotivo.put("mot_codigo", m.getCodM());
                jsonObjectMotivo.put("mot_indicador", "N");
                jsonObjectMotivo.put("usu", m.getUsuario());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayMotivo.put(jsonObjectMotivo);
            JSONObject json = new JSONObject();
            try {
                json.put("motivo", jsonArrayMotivo);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delMotivo.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonMotivo", json);

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

}
