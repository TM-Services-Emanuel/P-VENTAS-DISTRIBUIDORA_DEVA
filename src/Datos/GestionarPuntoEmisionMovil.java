package Datos;

import Componentes.OperacionMovil;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.PuntoEmisionMovil;
import Modelo.refMovil;
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

public class GestionarPuntoEmisionMovil {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoPuntoEmision("SELECT MAX(idemision) from puntoemision ");
        return cod;
    }

    public static String addPuntoEmision(PuntoEmisionMovil pe) {
        String msg = null;
        try {
            JSONArray jsonArrayPE = new JSONArray();
            JSONObject jsonObjectPE = new JSONObject();
            try {
                jsonObjectPE.put("idemision", pe.getIdEmision());
                jsonObjectPE.put("idtimbrado", pe.getIdTimbrado());
                jsonObjectPE.put("establecimiento", pe.getEstablecimiento());
                jsonObjectPE.put("puntoemision", pe.getPuntoEmision());
                jsonObjectPE.put("direccion", pe.getDireccion());
                jsonObjectPE.put("facturainicio", pe.getFacturaInicio());
                jsonObjectPE.put("facturafin", pe.getFacturaFin());
                jsonObjectPE.put("facturaactual", pe.getFacturaActual());
                jsonObjectPE.put("tipo", pe.getTipo());
                jsonObjectPE.put("finalidad", pe.getFinalidad());
                jsonObjectPE.put("ip", pe.getIp());
                jsonObjectPE.put("estado", pe.getEstado());
                jsonObjectPE.put("estado2", "S");

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayPE.put(jsonObjectPE);
            JSONObject json = new JSONObject();
            try {
                json.put("puntoemision", jsonArrayPE);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "savePuntoEmision.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonPE", json);

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

    public static String addRef(refMovil rm) {
        String msg = null;
        try {
            JSONArray jsonArrayREF = new JSONArray();
            JSONObject jsonObjectREF = new JSONObject();
            try {
                jsonObjectREF.put("idemision", rm.getIdemision());
                jsonObjectREF.put("nventa", rm.getNventa());

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayREF.put(jsonObjectREF);
            JSONObject json = new JSONObject();
            try {
                json.put("ref", jsonArrayREF);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "saveRef.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonREF", json);

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

    public static String actPuntoEmision(PuntoEmisionMovil m) {
        String msg = null;
        try {
            JSONArray jsonArrayPE = new JSONArray();
            JSONObject jsonObjectPE = new JSONObject();
            try {
                jsonObjectPE.put("idemision", m.getIdEmision());
                jsonObjectPE.put("establecimiento", m.getEstablecimiento());
                jsonObjectPE.put("puntoemision", m.getPuntoEmision());
                jsonObjectPE.put("direccion", m.getDireccion());
                jsonObjectPE.put("facturainicio", m.getFacturaInicio());
                jsonObjectPE.put("facturafin", m.getFacturaFin());
                jsonObjectPE.put("facturaactual", m.getFacturaActual());
                jsonObjectPE.put("tipo", m.getTipo());
                jsonObjectPE.put("finalid", m.getFinalidad());
                jsonObjectPE.put("ip", m.getIp());
                jsonObjectPE.put("estado", m.getEstado());

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayPE.put(jsonObjectPE);
            JSONObject json = new JSONObject();
            try {
                json.put("puntoemision", jsonArrayPE);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actPuntoEmision.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonPE", json);

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

    public static String actRef(refMovil rm) {
        String msg = null;

        try {
            JSONArray jsonArrayREF = new JSONArray();
            JSONObject jsonObjectREF = new JSONObject();
            try {
                jsonObjectREF.put("idemision", rm.getIdemision());
                jsonObjectREF.put("nventa", rm.getNventa());

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayREF.put(jsonObjectREF);
            JSONObject json = new JSONObject();
            try {
                json.put("ref", jsonArrayREF);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actRef.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonREF", json);

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

    public static String delPuntoEmision(int cod) {
        String msg = null;
        try {
            JSONArray jsonArrayPE = new JSONArray();
            JSONObject jsonObjectPE = new JSONObject();
            try {
                jsonObjectPE.put("idemision", cod);
                jsonObjectPE.put("estado2", "N");

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayPE.put(jsonObjectPE);
            JSONObject json = new JSONObject();
            try {
                json.put("puntoemision", jsonArrayPE);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delPuntoEmision.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonPE", json);

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

    /*public static List listPuntoEmision() {
        //String sql = "SELECT * FROM timbrado WHERE estado='S'";
        String sql = "SELECT * FROM v_puntoemision2 ORDER BY idemision";
        return OperacionMovil.getTabla(sql);
    }*/
}
