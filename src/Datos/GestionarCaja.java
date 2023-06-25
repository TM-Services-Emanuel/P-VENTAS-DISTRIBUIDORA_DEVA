package Datos;

import Componentes.Operacion;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.Caja;
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

public class GestionarCaja {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoCaja("SELECT MAX(ca_id) FROM caja");
        return cod;
    }

    public static String addCaja(Caja caja) {
        String msg = null;
        try {
            JSONArray jsonArrayNEW_CAJA = new JSONArray();
            JSONObject jsonObjectNEW_CAJA = new JSONObject();
            try {
                jsonObjectNEW_CAJA.put("ca_id", getCodigo());
                jsonObjectNEW_CAJA.put("ca_fechainicio", caja.getFechaI());
                jsonObjectNEW_CAJA.put("ca_horainicio", caja.getHoraI());
                jsonObjectNEW_CAJA.put("ca_inicial", caja.getCaInicial());
                jsonObjectNEW_CAJA.put("ca_final", caja.getCaFinal());
                jsonObjectNEW_CAJA.put("ca_entregado", caja.getCaEntregado());
                jsonObjectNEW_CAJA.put("ca_diferencia", caja.getCaDiferencia());
                jsonObjectNEW_CAJA.put("ca_usuarioinicio", caja.getUsuarioI());
                jsonObjectNEW_CAJA.put("ca_indicador", "S");

            } catch (JSONException new_empresa) {
                System.out.println(new_empresa.getMessage());
            }
            jsonArrayNEW_CAJA.put(jsonObjectNEW_CAJA);
            JSONObject json = new JSONObject();
            try {
                json.put("caja", jsonArrayNEW_CAJA);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "saveCaja.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCaja", json);

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
        return msg;
    }

    public static String actCaja(Caja caja) {
        String msg = null;
        try {
            JSONArray jsonArrayMOD_CAJA = new JSONArray();
            JSONObject jsonObjectMOD_CAJA = new JSONObject();
            try {
                jsonObjectMOD_CAJA.put("ca_final", caja.getCaFinal());
                jsonObjectMOD_CAJA.put("ca_entregado", caja.getCaEntregado());
                jsonObjectMOD_CAJA.put("ca_diferencia", caja.getCaDiferencia());
                jsonObjectMOD_CAJA.put("ca_id", caja.getCaId());

            } catch (JSONException new_empresa) {
                System.out.println(new_empresa.getMessage());
            }
            jsonArrayMOD_CAJA.put(jsonObjectMOD_CAJA);
            JSONObject json = new JSONObject();
            try {
                json.put("caja", jsonArrayMOD_CAJA);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actCaja.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCaja", json);

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
        return msg;
    }

    public static String CerrarCaja(Caja caja) {
        String msg = null;
        try {
            JSONArray jsonArrayCLOSE_CAJA = new JSONArray();
            JSONObject jsonObjectCLOSE_CAJA = new JSONObject();
            try {
                jsonObjectCLOSE_CAJA.put("ca_fechafin", caja.getFechaF());
                jsonObjectCLOSE_CAJA.put("ca_horafin", caja.getHoraF());
                jsonObjectCLOSE_CAJA.put("ca_final", caja.getCaFinal());
                jsonObjectCLOSE_CAJA.put("ca_entregado", caja.getCaEntregado());
                jsonObjectCLOSE_CAJA.put("ca_diferencia", caja.getCaDiferencia());
                jsonObjectCLOSE_CAJA.put("ca_usuariocierre", caja.getUsuarioF());
                jsonObjectCLOSE_CAJA.put("ca_indicador", "N");
                jsonObjectCLOSE_CAJA.put("ca_id", caja.getCaId());

            } catch (JSONException new_empresa) {
                System.out.println(new_empresa.getMessage());
            }
            jsonArrayCLOSE_CAJA.put(jsonObjectCLOSE_CAJA);
            JSONObject json = new JSONObject();
            try {
                json.put("caja", jsonArrayCLOSE_CAJA);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "closeCaja.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCaja", json);

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
        return msg;
    }

    public static Caja busCaja(String cod) {
        Caja caj = null;
        try {
            URL url = new URL(urlServer() + "getBusCaja.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("id", cod);

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
                StringBuilder caja = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    caja.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCaja = new JSONArray(caja.toString());
                for (int i = 0; i < jsonCaja.length(); i++) {
                    JSONObject objectCaja = jsonCaja.getJSONObject(i);
                    caj = new Caja();
                    caj.setCaId(Integer.valueOf(objectCaja.getString("ca_id")));
                    caj.setFechaI(String.valueOf(objectCaja.getString("ca_fechainicio")));
                    caj.setHoraI(String.valueOf(objectCaja.getString("ca_horainicio")));
                    caj.setCaInicial(Integer.parseInt(objectCaja.getString("ca_inicial")));
                    caj.setCaFinal(Integer.parseInt(objectCaja.getString("ca_final")));
                    caj.setCaEntregado(Integer.parseInt(objectCaja.getString("ca_entregado")));
                    caj.setCaDiferencia(Integer.parseInt(objectCaja.getString("ca_diferencia")));
                    caj.setUsuarioI(String.valueOf(objectCaja.getString("ca_usuarioinicio")));
                    caj.setIndicador(String.valueOf(objectCaja.getString("ca_indicador")));
                    System.out.println("Encontrado");
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return caj;
    }
}
