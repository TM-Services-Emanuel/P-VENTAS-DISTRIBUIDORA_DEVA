package Datos;

import Componentes.Operacion;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.Usuario;
import IU.frmAcceso;
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

public class Logeo {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("SELECT MAX(acc_codigo) FROM accesos");
        return cod;
    }

    public static Usuario logear(String user, String pass) {
        Usuario u = null;
        try {
            URL url = new URL(urlServer()+"getLogueo.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("user", user);
            params.put("pass", pass);

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
                StringBuilder Logueo = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    Logueo.append(scan.nextLine());
                }
                scan.close();

                //System.out.println(informacionUM);
                JSONArray jsonLogueo = new JSONArray(Logueo.toString());
                if (jsonLogueo.length() != 0) {
                    JSONObject objectUM = jsonLogueo.getJSONObject(0);
                    u = new Usuario();
                    u.setCodUsuario(Integer.parseInt(objectUM.getString("usu_codigo")));
                    u.setPefil(objectUM.getString("DesPerfil"));
                    u.setNomUsuario(objectUM.getString("NombreVendedor"));
                    u.setUsuario(objectUM.getString("usu_usuario"));
                    u.setPassword(objectUM.getString("usu_password"));
                    u.setIp(objectUM.getString("usu_ip"));
                    System.out.println("Usuario Correcto");
                } else {
                    frmAcceso.lblMensaje.setText("Datos Incorrectos, verifique su Usuario y Contraseña.");
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public static String acceso(Usuario u) {
        String msg = null;
        try {
            JSONArray jsonArrayLogueo = new JSONArray();
            JSONObject jsonObjectLogin = new JSONObject();
            try {
                jsonObjectLogin.put("acc_usuario", u.getCodUsuario());
                jsonObjectLogin.put("acc_nombre", u.getNomUsuario());
                jsonObjectLogin.put("acc_user", u.getUsuario());
                jsonObjectLogin.put("acc_perfil", u.getPefil());
                jsonObjectLogin.put("acc_descripcion", u.getUsuario().concat(" ingresó al sistema"));
                jsonObjectLogin.put("acc_tipoacceso", "Entrada");
                jsonObjectLogin.put("acc_fecha", "NOW()");

            } catch (JSONException e) {
                System.out.println(e.getMessage());
            }
            jsonArrayLogueo.put(jsonObjectLogin);
            JSONObject json = new JSONObject();
            try {
                json.put("acceso", jsonArrayLogueo);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer()+"saveAcceso.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonAcceso", json);

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

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return msg;
    }

    public static String salida(Usuario u) {
        
        String msg = null;
        try {
            JSONArray jsonArrayLogueo = new JSONArray();
            JSONObject jsonObjectLogin = new JSONObject();
            try {
                jsonObjectLogin.put("acc_usuario", u.getCodUsuario());
                jsonObjectLogin.put("acc_nombre", u.getNomUsuario());
                jsonObjectLogin.put("acc_user", u.getUsuario());
                jsonObjectLogin.put("acc_perfil", u.getPefil());
                jsonObjectLogin.put("acc_descripcion", u.getUsuario().concat(" salió del sistema"));
                jsonObjectLogin.put("acc_tipoacceso", "Salida");
                jsonObjectLogin.put("acc_fecha", "NOW()");

            } catch (JSONException e) {
                System.out.println(e.getMessage());
            }
            jsonArrayLogueo.put(jsonObjectLogin);
            JSONObject json = new JSONObject();
            try {
                json.put("acceso", jsonArrayLogueo);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer()+"saveAcceso.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonAcceso", json);

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

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

}
