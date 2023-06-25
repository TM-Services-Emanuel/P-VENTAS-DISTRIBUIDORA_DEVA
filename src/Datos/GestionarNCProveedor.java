package Datos;

import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
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

public class GestionarNCProveedor {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoNCProveedor("SELECT IFNULL ((select MAX(idnota) from nc_proveedor),0) AS idnota");
        return cod;
    }
    
    public static String getCodigo1() {
        String cod = generarCodigos.getCodigoNCProveedor("SELECT IFNULL ((select MAX(idnota) from nc_cliente),0) AS idnota");
        return cod;
    }

    public static String delNCProveedor(String cod, String usuario, String com_codigo, int com_nc) {        
        String msg = null;
        try {
            JSONArray jsonArrayNCP = new JSONArray();
            JSONObject jsonObjectNCP = new JSONObject();
            try {
                jsonObjectNCP.put("idnota", cod);
                jsonObjectNCP.put("usu", usuario);
                jsonObjectNCP.put("estado", "N");
                jsonObjectNCP.put("com_codigo", com_codigo);
                jsonObjectNCP.put("com_nc", com_nc);
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayNCP.put(jsonObjectNCP);
            JSONObject json = new JSONObject();
            try {
                json.put("ncp", jsonArrayNCP);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delNCProveedor.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonNCP", json);

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
    
    public static String delNCCliente(String cod, String usuario, String fac_codigo, int fac_nc) {        
        String msg = null;
        try {
            JSONArray jsonArrayNCP = new JSONArray();
            JSONObject jsonObjectNCP = new JSONObject();
            try {
                jsonObjectNCP.put("idnota", cod);
                jsonObjectNCP.put("usu", usuario);
                jsonObjectNCP.put("estado", "N");
                jsonObjectNCP.put("fac_codigo", fac_codigo);
                jsonObjectNCP.put("fac_nc", fac_nc);
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayNCP.put(jsonObjectNCP);
            JSONObject json = new JSONObject();
            try {
                json.put("ncc", jsonArrayNCP);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delNCCliente.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonNCC", json);

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
    
    public static String delPagos(String cod, String usuario) {        
        String msg = null;
        try {
            JSONArray jsonArrayP = new JSONArray();
            JSONObject jsonObjectP = new JSONObject();
            try {
                jsonObjectP.put("idpagos", cod);
                jsonObjectP.put("usuario", usuario);
                jsonObjectP.put("estado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayP.put(jsonObjectP);
            JSONObject json = new JSONObject();
            try {
                json.put("pagos", jsonArrayP);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delPagos.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonPagos", json);

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
    
    public static String delPagosF(String cod, String usuario) {        
        String msg = null;
        try {
            JSONArray jsonArrayP = new JSONArray();
            JSONObject jsonObjectP = new JSONObject();
            try {
                jsonObjectP.put("fac_codigo", cod);
                jsonObjectP.put("usu", usuario);
                jsonObjectP.put("estado", "PENDIENTE");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayP.put(jsonObjectP);
            JSONObject json = new JSONObject();
            try {
                json.put("pagos", jsonArrayP);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delPagosF.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonPagos", json);

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
    
    public static String delPagosFF(String cod, String usuario) {        
        String msg = null;
        try {
            JSONArray jsonArrayP = new JSONArray();
            JSONObject jsonObjectP = new JSONObject();
            try {
                jsonObjectP.put("idnota", cod);
                jsonObjectP.put("usu", usuario);
                jsonObjectP.put("liquidado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayP.put(jsonObjectP);
            JSONObject json = new JSONObject();
            try {
                json.put("pagos", jsonArrayP);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delPagosFF.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonPagos", json);

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
