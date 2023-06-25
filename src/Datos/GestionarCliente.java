package Datos;

import Componentes.Fecha;
import Componentes.OperacionMovil;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.ClienteMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestionarCliente {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoCliente("SELECT MAX(idcliente) FROM clientes");
        return cod;
    }

    public static String addCliente(ClienteMovil c) {
        String msg = null;
        try {
            JSONArray jsonArrayClientes = new JSONArray();
            JSONObject jsonObjectClientes = new JSONObject();
            try {
                jsonObjectClientes.put("idcliente", c.getIdCliente());
                jsonObjectClientes.put("razon_social", c.getRazonSocial());
                jsonObjectClientes.put("ruc", c.getRuc());
                jsonObjectClientes.put("tipo_persona", c.getTipoPersona());
                jsonObjectClientes.put("nacionalidad", c.getNacionalidad());
                jsonObjectClientes.put("fecha_nacimiento", c.getFechaN());
                jsonObjectClientes.put("sexo", c.getSexo());
                jsonObjectClientes.put("direccion", c.getDireccion());
                jsonObjectClientes.put("barrio", c.getBarrio());
                jsonObjectClientes.put("telefono", c.getTelefono());
                jsonObjectClientes.put("ciudad_idciudad", c.getCodCiudad());
                jsonObjectClientes.put("supermercado", c.getSuper());
                jsonObjectClientes.put("lunes", c.getLunes());
                jsonObjectClientes.put("martes", c.getMartes());
                jsonObjectClientes.put("miercoles", c.getMiercoles());
                jsonObjectClientes.put("jueves", c.getJueves());
                jsonObjectClientes.put("viernes", c.getViernes());
                jsonObjectClientes.put("sabado", c.getSabado());
                jsonObjectClientes.put("domingo", c.getDomingo());
                jsonObjectClientes.put("estado", "S");

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayClientes.put(jsonObjectClientes);
            JSONObject json = new JSONObject();
            try {
                json.put("cliente", jsonArrayClientes);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "saveCliente.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCliente", json);

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

    public static String actCliente(ClienteMovil c) {
        String msg = null;
        try {
            JSONArray jsonArrayClientes = new JSONArray();
            JSONObject jsonObjectClientes = new JSONObject();
            try {
                jsonObjectClientes.put("idcliente", c.getIdCliente());
                jsonObjectClientes.put("razon_social", c.getRazonSocial());
                jsonObjectClientes.put("ruc", c.getRuc());
                jsonObjectClientes.put("tipo_persona", c.getTipoPersona());
                jsonObjectClientes.put("nacionalidad", c.getNacionalidad());
                jsonObjectClientes.put("fecha_nacimiento", c.getFechaN());
                jsonObjectClientes.put("sexo", c.getSexo());
                jsonObjectClientes.put("direccion", c.getDireccion());
                jsonObjectClientes.put("barrio", c.getBarrio());
                jsonObjectClientes.put("telefono", c.getTelefono());
                jsonObjectClientes.put("ciudad_idciudad", c.getCodCiudad());
                jsonObjectClientes.put("supermercado", c.getSuper());
                jsonObjectClientes.put("lunes", c.getLunes());
                jsonObjectClientes.put("martes", c.getMartes());
                jsonObjectClientes.put("miercoles", c.getMiercoles());
                jsonObjectClientes.put("jueves", c.getJueves());
                jsonObjectClientes.put("viernes", c.getViernes());
                jsonObjectClientes.put("sabado", c.getSabado());
                jsonObjectClientes.put("domingo", c.getDomingo());

            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayClientes.put(jsonObjectClientes);
            JSONObject json = new JSONObject();
            try {
                json.put("cliente", jsonArrayClientes);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actCliente.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCliente", json);

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

    public static String delCliente(String cod) {
        String msg = null;
        try {
            JSONArray jsonArrayCliente = new JSONArray();
            JSONObject jsonObjectCliente = new JSONObject();
            try {
                jsonObjectCliente.put("idcliente", cod);
                jsonObjectCliente.put("estado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayCliente.put(jsonObjectCliente);
            JSONObject json = new JSONObject();
            try {
                json.put("cliente", jsonArrayCliente);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delCliente.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCliente", json);

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

    public static ClienteMovil busCliente(String cod) {
        ClienteMovil c = new ClienteMovil();
        try {
            HttpClient producto = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject jsonCliente = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonCliente.length(); f++) {
                                c.setIdCliente(Integer.parseInt(jsonCliente.getJSONObject("" + f + "").get("idcliente").toString()));
                                c.setRazonSocial(jsonCliente.getJSONObject("" + f + "").get("razon_social").toString());
                                c.setRuc(jsonCliente.getJSONObject("" + f + "").get("ruc").toString());
                                c.setTipoPersona(jsonCliente.getJSONObject("" + f + "").get("tipo_persona").toString());
                                c.setNacionalidad(jsonCliente.getJSONObject("" + f + "").get("nacionalidad").toString());
                                c.setFechaN((jsonCliente.getJSONObject("" + f + "").get("fecha_nacimiento").toString()));
                                c.setSexo(jsonCliente.getJSONObject("" + f + "").get("sexo").toString());
                                c.setDireccion(jsonCliente.getJSONObject("" + f + "").get("direccion").toString());
                                c.setBarrio(jsonCliente.getJSONObject("" + f + "").get("barrio").toString());
                                c.setTelefono(jsonCliente.getJSONObject("" + f + "").get("telefono").toString());
                                c.setCodCiudad(Integer.parseInt(jsonCliente.getJSONObject("" + f + "").get("ciudad_idciudad").toString()));
                                c.setSuper(jsonCliente.getJSONObject("" + f + "").get("supermercado").toString());
                                c.setLunes(jsonCliente.getJSONObject("" + f + "").get("lunes").toString());
                                c.setMartes(jsonCliente.getJSONObject("" + f + "").get("martes").toString());
                                c.setMiercoles(jsonCliente.getJSONObject("" + f + "").get("miercoles").toString());
                                c.setJueves(jsonCliente.getJSONObject("" + f + "").get("jueves").toString());
                                c.setViernes(jsonCliente.getJSONObject("" + f + "").get("viernes").toString());
                                c.setSabado(jsonCliente.getJSONObject("" + f + "").get("sabado").toString());
                                c.setDomingo(jsonCliente.getJSONObject("" + f + "").get("domingo").toString());

                                System.out.println("Encontrado");
                            }
                        } catch (JSONException e) {
                            System.out.println("cliente no encontrado: "+e.getMessage());
                        }
                    }
                }
            });
            producto.excecute(urlServer() + "getClientes.php?idcliente=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return c;
    }

    public static ClienteMovil busClienteRuc(String cod) {
        ClienteMovil c = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM clientes WHERE ruc LIKE '%");
        sql.append(cod).append("%'");
//        String sql = "SELECT * FROM clientes WHERE cli_ruc LIKE '" + cod + "%'";
        Object[] filaObt = OperacionMovil.getFila(sql.toString());
        if (filaObt != null) {
            c = new ClienteMovil();
            c.setIdCliente(Integer.parseInt(filaObt[0].toString()));
            c.setRazonSocial(filaObt[1].toString());
            c.setRuc(filaObt[2].toString());
            c.setDireccion(filaObt[3].toString());
            c.setTelefono(filaObt[4].toString());
            c.setCodCiudad(Integer.parseInt(filaObt[6].toString()));
        } else {
            System.out.println("No encotrado");
        }
        return c;
    }

    /*public static List listClientes(String cod) {
        StringBuilder sql = new StringBuilder("SELECT clientes.idcliente,");
        sql.append("clientes.razon_social,");
        sql.append("clientes.ruc,");
        sql.append("clientes.direccion,");
        sql.append("clientes.telefono,");
        sql.append("ciudad.ciudad");
        sql.append(" FROM clientes ");
        sql.append(" JOIN ciudad ON clientes.ciudad_idciudad = ciudad.idciudad");
        sql.append(" WHERE clientes.estado='S'");
        sql.append(" ORDER BY clientes.idcliente ASC");
        sql.append(" LIMIT 10000");
        return OperacionMovil.getTabla(sql.toString());
    }*/
    public static List listClientesContaduria() {
        StringBuilder sql = new StringBuilder("SELECT clientes.idcliente,");
        sql.append("clientes.razon_social,");
        sql.append("clientes.ruc, clientes.ciudad_idciudad ");
        sql.append(" FROM clientes ");
        sql.append(" WHERE clientes.estado='S'");
        sql.append(" ORDER BY clientes.idcliente ASC");
        return OperacionMovil.getTabla(sql.toString());
    }

    public static List listActosGravados() {
        StringBuilder sql = new StringBuilder("SELECT idiva, descripcion, impuesto FROM iva WHERE estado='S'");
        sql.append(" ORDER BY idiva ASC");
        return OperacionMovil.getTabla(sql.toString());
    }

    public static List listVCContaduria(String desde, String hasta) {
        StringBuilder sql = new StringBuilder("(SELECT * FROM v_ventacabecera WHERE fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("')");
        sql.append("UNION");
        sql.append("(SELECT * FROM v_ventacabecera_factura WHERE fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("') ");
        sql.append("ORDER BY idemision ASC, nrofactura ASC");
        return OperacionMovil.getTabla(sql.toString());
    }

    public static List listVDContaduria(String desde, String hasta) {
        /*StringBuilder sql = new StringBuilder("(SELECT * FROM v_contae WHERE v_contae.imp > 0");
        sql.append(" AND fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("')");
        sql.append(" UNION");
        sql.append(" (SELECT * FROM v_conta5 WHERE v_conta5.imp > 0");
        sql.append(" AND fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("')");
        sql.append(" UNION");
        sql.append("(SELECT * FROM v_conta10 WHERE v_conta10.imp > 0");
        sql.append(" AND fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("')");
        sql.append(" ORDER BY v_contae.idemision ASC, v_contae.idventas ASC, v_contae.fecha ASC, v_contae.idiva ASC"); */
        StringBuilder sql = new StringBuilder("(SELECT * FROM v_ventadetalle");
        sql.append(" WHERE fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("')");
        sql.append("UNION");
        sql.append("(SELECT * FROM v_ventadetalle_factura");
        sql.append(" WHERE fecha >='").append(desde).append("' AND fecha <='").append(hasta).append("')");
        return OperacionMovil.getTabla(sql.toString());
    }

    /*public static List filRazonS(String cad) {
        StringBuilder sql = new StringBuilder("SELECT clientes.idcliente,");
        sql.append("clientes.razon_social,");
        sql.append("clientes.ruc,");
        sql.append("clientes.direccion,");
        sql.append("clientes.telefono,");
        sql.append("ciudad.ciudad");
        sql.append(" FROM clientes ");
        sql.append(" JOIN ciudad ON clientes.ciudad_idciudad = ciudad.idciudad");
        sql.append(" WHERE clientes.razon_social LIKE '%").append(cad).append("%'");
        sql.append(" OR clientes.ruc LIKE '%").append(cad).append("%' AND clientes.estado='S'");
        return OperacionMovil.getTabla(sql.toString());
    }*/
    public static List filRuc(String cad) {
        StringBuilder sql = new StringBuilder("SELECT clientes.idcliente,");
        sql.append("clientes.razon_social,");
        sql.append("clientes.ruc,");
        sql.append("clientes.direccion,");
        sql.append("clientes.telefono,");
        sql.append("ciudad.ciudad");
        sql.append(" FROM clientes ");
        sql.append(" JOIN ciudad ON clientes.ciudad_idciudad = ciudad.idciudad");
        sql.append(" WHERE (((clientes.estado) = 'S') AND ((clientes.ruc) LIKE '%").append(cad).append("%'))");
        return OperacionMovil.getTabla(sql.toString());
    }

    /* public static List filRuc(String cad) {
        StringBuilder sql = new StringBuilder("SELECT clientes.cli_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("clientes.cli_contacto,");
        sql.append("vendedor.ven_nombre,");
        sql.append("clientes.cli_telefono,");
        sql.append("clientes.cli_celular,");
        sql.append("clientes.cli_fax,");
        sql.append("rubro.rub_nombre,");
        sql.append("clientes.cli_ruc,");
        sql.append("clientes.cli_limitecuenta,");
        sql.append("clientes.cli_direccion,");
        sql.append("clientes.cli_email,");
        sql.append("clientes.cli_web,");
        sql.append("transporte.tra_nombre,");
        sql.append("provincias.prv_nombre ");
        sql.append(" FROM clientes ");
        sql.append(" JOIN vendedor ON clientes.cli_vendedor = vendedor.ven_codigo ");
        sql.append(" JOIN rubro ON clientes.cli_rubro = rubro.rub_codigo ");
        sql.append(" JOIN transporte ON clientes.cli_transporte = transporte.tra_codigo ");
        sql.append(" JOIN provincias ON clientes.cli_provincia = provincias.prv_codigo AND clientes.cli_provincia = provincias.prv_codigo ");
        sql.append("  WHERE (((clientes.cli_indicador) = 'S') AND ((clientes.cli_ruc) LIKE '").append(cad).append("%'))");
//        String sq = "SELECT clientes.cli_codigo,"
//                + "    clientes.cli_razonsocial,"
//                + "    clientes.cli_contacto,"
//                + "    vendedor.ven_nombre,"
//                + "    clientes.cli_telefono,"
//                + "    clientes.cli_celular,"
//                + "    clientes.cli_fax,"
//                + "    rubro.rub_nombre,"
//                + "    clientes.cli_ruc,"
//                + "    clientes.cli_limitecuenta,"
//                + "    clientes.cli_direccion,"
//                + "    clientes.cli_email,"
//                + "    clientes.cli_web,"
//                + "    transporte.tra_nombre,"
//                + "    provincias.prv_nombre"
//                + "   FROM ((((clientes"
//                + "   JOIN vendedor ON ((clientes.cli_vendedor = vendedor.ven_codigo)))"
//                + "   JOIN rubro ON ((clientes.cli_rubro = rubro.rub_codigo)))"
//                + "   JOIN transporte ON ((clientes.cli_transporte = transporte.tra_codigo)))"
//                + "   JOIN provincias ON (((clientes.cli_provincia = provincias.prv_codigo) AND (clientes.cli_provincia = provincias.prv_codigo))))"
//                + "  WHERE (((clientes.cli_indicador) = 'S') AND ((clientes.cli_ruc) LIKE '" + cad + "%'))";
        return Operacion.getTabla(sql.toString());
    }

    public static List filContacto(String cad) {
        StringBuilder sql = new StringBuilder("SELECT clientes.cli_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("clientes.cli_contacto,");
        sql.append("vendedor.ven_nombre,");
        sql.append("clientes.cli_telefono,");
        sql.append("clientes.cli_celular,");
        sql.append("clientes.cli_fax,");
        sql.append("rubro.rub_nombre,");
        sql.append("clientes.cli_ruc,");
        sql.append("clientes.cli_limitecuenta,");
        sql.append("clientes.cli_direccion,");
        sql.append("clientes.cli_email,");
        sql.append("clientes.cli_web,");
        sql.append("transporte.tra_nombre,");
        sql.append("provincias.prv_nombre ");
        sql.append(" FROM clientes ");
        sql.append(" JOIN vendedor ON clientes.cli_vendedor = vendedor.ven_codigo ");
        sql.append(" JOIN rubro ON clientes.cli_rubro = rubro.rub_codigo ");
        sql.append(" JOIN transporte ON clientes.cli_transporte = transporte.tra_codigo ");
        sql.append(" JOIN provincias ON clientes.cli_provincia = provincias.prv_codigo AND clientes.cli_provincia = provincias.prv_codigo ");
        sql.append("  WHERE (((clientes.cli_indicador) = 'S') AND ((clientes.cli_contacto) LIKE '").append(cad).append("%'))");
//        String sq = "SELECT clientes.cli_codigo,"
//                + "    clientes.cli_razonsocial,"
//                + "    clientes.cli_contacto,"
//                + "    vendedor.ven_nombre,"
//                + "    clientes.cli_telefono,"
//                + "    clientes.cli_celular,"
//                + "    clientes.cli_fax,"
//                + "    rubro.rub_nombre,"
//                + "    clientes.cli_ruc,"
//                + "    clientes.cli_limitecuenta,"
//                + "    clientes.cli_direccion,"
//                + "    clientes.cli_email,"
//                + "    clientes.cli_web,"
//                + "    transporte.tra_nombre,"
//                + "    provincias.prv_nombre"
//                + "   FROM ((((clientes"
//                + "   JOIN vendedor ON ((clientes.cli_vendedor = vendedor.ven_codigo)))"
//                + "   JOIN rubro ON ((clientes.cli_rubro = rubro.rub_codigo)))"
//                + "   JOIN transporte ON ((clientes.cli_transporte = transporte.tra_codigo)))"
//                + "   JOIN provincias ON (((clientes.cli_provincia = provincias.prv_codigo) AND (clientes.cli_provincia = provincias.prv_codigo))))"
//                + "  WHERE (((clientes.cli_indicador) = 'S') AND ((clientes.cli_contacto) LIKE '" + cad + "%'))";
        return Operacion.getTabla(sql.toString());
    }

    public static List filDireccion(String cad) {
        StringBuilder sql = new StringBuilder("SELECT clientes.cli_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("clientes.cli_contacto,");
        sql.append("vendedor.ven_nombre,");
        sql.append("clientes.cli_telefono,");
        sql.append("clientes.cli_celular,");
        sql.append("clientes.cli_fax,");
        sql.append("rubro.rub_nombre,");
        sql.append("clientes.cli_ruc,");
        sql.append("clientes.cli_limitecuenta,");
        sql.append("clientes.cli_direccion,");
        sql.append("clientes.cli_email,");
        sql.append("clientes.cli_web,");
        sql.append("transporte.tra_nombre,");
        sql.append("provincias.prv_nombre ");
        sql.append(" FROM clientes ");
        sql.append(" JOIN vendedor ON clientes.cli_vendedor = vendedor.ven_codigo ");
        sql.append(" JOIN rubro ON clientes.cli_rubro = rubro.rub_codigo ");
        sql.append(" JOIN transporte ON clientes.cli_transporte = transporte.tra_codigo ");
        sql.append(" JOIN provincias ON clientes.cli_provincia = provincias.prv_codigo AND clientes.cli_provincia = provincias.prv_codigo ");
        sql.append("  WHERE (((clientes.cli_indicador) = 'S') AND ((clientes.cli_direccion) LIKE '").append(cad).append("%'))");
//        String sq = "SELECT clientes.cli_codigo,"
//                + "    clientes.cli_razonsocial,"
//                + "    clientes.cli_contacto,"
//                + "    vendedor.ven_nombre,"
//                + "    clientes.cli_telefono,"
//                + "    clientes.cli_celular,"
//                + "    clientes.cli_fax,"
//                + "    rubro.rub_nombre,"
//                + "    clientes.cli_ruc,"
//                + "    clientes.cli_limitecuenta,"
//                + "    clientes.cli_direccion,"
//                + "    clientes.cli_email,"
//                + "    clientes.cli_web,"
//                + "    transporte.tra_nombre,"
//                + "    provincias.prv_nombre"
//                + "   FROM ((((clientes"
//                + "   JOIN vendedor ON ((clientes.cli_vendedor = vendedor.ven_codigo)))"
//                + "   JOIN rubro ON ((clientes.cli_rubro = rubro.rub_codigo)))"
//                + "   JOIN transporte ON ((clientes.cli_transporte = transporte.tra_codigo)))"
//                + "   JOIN provincias ON (((clientes.cli_provincia = provincias.prv_codigo) AND (clientes.cli_provincia = provincias.prv_codigo))))"
//                + "  WHERE (((clientes.cli_indicador) = 'S') AND ((clientes.cli_direccion) LIKE '" + cad + "%'))";
        return Operacion.getTabla(sql.toString());
    }
     */
}
