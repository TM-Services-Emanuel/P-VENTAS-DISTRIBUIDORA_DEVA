package Datos;

import Componentes.Operacion;
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

public class GestionarSalida {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoSalida("SELECT IFNULL ((select MAX(sal_codigo) from salida),0) AS sal_codigo");
        return cod;
    }
    
    public static String getCodigoSolicitud() {
        String cod = generarCodigos.getCodigoSolicitudNC("SELECT IFNULL ((select MAX(idsolicitud) from solicitud_nc_provedor),0) AS idsolicitud");
        return cod;
    }
    
    public static String getCodigoSolicitudD() {
        String cod = generarCodigos.getCodigoSolicitudD("SELECT IFNULL ((select MAX(idsolicitud) from solicitud_destruccion),0) AS idsolicitud");
        return cod;
    }

    /*public static String addSalida(Salidas s) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO salida VALUES (");
        sql.append(s.getCodSal()).append(",");
        sql.append(s.getCodProv()).append(",'");
        sql.append(s.getFecha()).append("','");
        sql.append(Fecha.darHora()).append("',");
        sql.append(s.getMonto()).append(",'");
        sql.append(s.getObs()).append("','S','");
        sql.append(s.getUsu()).append("')");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }*/

    public static String DelSalida(String cod, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArraySalida = new JSONArray();
            JSONObject jsonObjectSalida = new JSONObject();
            try {
                jsonObjectSalida.put("sal_codigo", cod);
                jsonObjectSalida.put("usu", usuario);
                jsonObjectSalida.put("sal_indicador", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArraySalida.put(jsonObjectSalida);
            JSONObject json = new JSONObject();
            try {
                json.put("salida", jsonArraySalida);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delSalida.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonSalida", json);

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
    
    public static String DelSolicitud(int cod, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArraySolicitud = new JSONArray();
            JSONObject jsonObjectSolicitud = new JSONObject();
            try {
                jsonObjectSolicitud.put("idsolicitud", cod);
                jsonObjectSolicitud.put("usu", usuario);
                jsonObjectSolicitud.put("estado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArraySolicitud.put(jsonObjectSolicitud);
            JSONObject json = new JSONObject();
            try {
                json.put("solicitud", jsonArraySolicitud);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delSolicitud.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonSolicitud", json);

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
    
    public static String DelDestruccion(int cod, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArraySolicitud = new JSONArray();
            JSONObject jsonObjectSolicitud = new JSONObject();
            try {
                jsonObjectSolicitud.put("idsolicitud", cod);
                jsonObjectSolicitud.put("usu", usuario);
                jsonObjectSolicitud.put("estado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArraySolicitud.put(jsonObjectSolicitud);
            JSONObject json = new JSONObject();
            try {
                json.put("solicitud", jsonArraySolicitud);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delDestruccion.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonSolicitud", json);

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
    
    public static String ProcSolicitud(int cod, String proc, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArraySolicitud = new JSONArray();
            JSONObject jsonObjectSolicitud = new JSONObject();
            try {
                jsonObjectSolicitud.put("idsolicitud", cod);
                jsonObjectSolicitud.put("usu", usuario);
                jsonObjectSolicitud.put("cerrado", proc);
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArraySolicitud.put(jsonObjectSolicitud);
            JSONObject json = new JSONObject();
            try {
                json.put("solicitud", jsonArraySolicitud);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delSolicitud2.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonSolicitud", json);

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
    
    public static String ProcDestruccion(int cod, String proc, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArrayDestruccion = new JSONArray();
            JSONObject jsonObjectDestruccion = new JSONObject();
            try {
                jsonObjectDestruccion.put("idsolicitud", cod);
                jsonObjectDestruccion.put("usu", usuario);
                jsonObjectDestruccion.put("cerrado", proc);
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayDestruccion.put(jsonObjectDestruccion);
            JSONObject json = new JSONObject();
            try {
                json.put("solicitud", jsonArrayDestruccion);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delDestruccion2.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonSolicitud", json);

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
    
    public static String ActivarSalida(int cod, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArraySolicitud = new JSONArray();
            JSONObject jsonObjectSolicitud = new JSONObject();
            try {
                jsonObjectSolicitud.put("sal_codigo", cod);
                jsonObjectSolicitud.put("usu", usuario);
                jsonObjectSolicitud.put("procesado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArraySolicitud.put(jsonObjectSolicitud);
            JSONObject json = new JSONObject();
            try {
                json.put("salida", jsonArraySolicitud);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delActivarSalida.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonSalida", json);

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

    /*public static String addDetalleSalida(DetalleSalida ds) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO detalle_salida (articulo_art_codigo, salida_sal_codigo, motivo_mot_codigo,ds_cantidad,"
                + "ds_precio, ds_monto) VALUES (");
        sql.append(ds.getCodArt()).append(",");
        sql.append(ds.getCodSalida()).append(",");
        sql.append(ds.getCodM()).append(",'");
        sql.append(ds.getCant()).append("',");
        sql.append(ds.getPrec()).append(",");
        sql.append(ds.getMonto()).append(")");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }*/

    /*public static List listSalidas() {
        String sql = "SELECT * FROM v_salida where sal_indicador = 'S'";
        return Operacion.getTabla(sql);
    }*/

    /*public static List listDetalle(String cod) {
        StringBuilder sql = new StringBuilder("SELECT * FROM v_salidadetalle");
        sql.append(" WHERE v_salidadetalle.salida_sal_codigo= ");
        sql.append(cod);
        return Operacion.getTabla(sql.toString());
    }*/
}
