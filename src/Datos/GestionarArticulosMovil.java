package Datos;

import Componentes.OperacionMovil;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.ArticuloMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestionarArticulosMovil {

    static FileInputStream fis;

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoProducto("select MAX(idproducto) from productos");
        return cod;
    }

    public static String addArticulo(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("cod_interno", art.getCodinterno());
                jsonObjectProductos.put("cod_barra", art.getCodBarra());
                jsonObjectProductos.put("descripcion", art.getDescripcion());
                jsonObjectProductos.put("precio_costo", art.getPrecio_costo());
                jsonObjectProductos.put("ganancia", art.getGanancia());
                jsonObjectProductos.put("por_ganancia", art.getPorG());
                jsonObjectProductos.put("precio_venta", art.getPrecio_venta());
                jsonObjectProductos.put("stock", art.getStock());
                jsonObjectProductos.put("estado", "S");
                jsonObjectProductos.put("um_idunidad", art.getUm());
                jsonObjectProductos.put("division_iddivision", art.getDivision());
                jsonObjectProductos.put("iva_idiva", art.getIva());
                jsonObjectProductos.put("ventam", art.getVentam());
                jsonObjectProductos.put("cantm", art.getCantm());
                jsonObjectProductos.put("preciominorista", art.getPreciominorista());
                jsonObjectProductos.put("gananciaminorista", art.getGananciaminorista());
                jsonObjectProductos.put("por_gan_minorista", art.getPorGMinorista());
                jsonObjectProductos.put("precio_supermercado", art.getPreciosupermercado());
                jsonObjectProductos.put("ganancia_super", art.getGananciasupermercado());
                jsonObjectProductos.put("por_gan_super", art.getPorGSupermercado());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "saveProducto.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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

    public static String actArticulo(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("cod_interno", art.getCodinterno());
                jsonObjectProductos.put("cod_barra", art.getCodBarra());
                jsonObjectProductos.put("descripcion", art.getDescripcion());
                jsonObjectProductos.put("precio_costo", art.getPrecio_costo());
                jsonObjectProductos.put("ganancia", art.getGanancia());
                jsonObjectProductos.put("por_ganancia", art.getPorG());
                jsonObjectProductos.put("precio_venta", art.getPrecio_venta());
                jsonObjectProductos.put("stock", art.getStock());
                jsonObjectProductos.put("um_idunidad", art.getUm());
                jsonObjectProductos.put("division_iddivision", art.getDivision());
                jsonObjectProductos.put("iva_idiva", art.getIva());
                jsonObjectProductos.put("ventam", art.getVentam());
                jsonObjectProductos.put("cantm", art.getCantm());
                jsonObjectProductos.put("preciominorista", art.getPreciominorista());
                jsonObjectProductos.put("gananciaminorista", art.getGananciaminorista());
                jsonObjectProductos.put("por_gan_minorista", art.getPorGMinorista());
                jsonObjectProductos.put("precio_supermercado", art.getPreciosupermercado());
                jsonObjectProductos.put("ganancia_super", art.getGananciasupermercado());
                jsonObjectProductos.put("por_gan_super", art.getPorGSupermercado());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actProducto.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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

    public static String actStock(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("stock", art.getStock());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actStock.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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

    public static String actStockMENOS(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("stock", art.getStock());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actStockMENOS.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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
    
    public static String actStockMENOSDañados(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("stock", art.getStock());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actStockMENOSDañados.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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

    public static String actStockMAS(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("stock", art.getStock());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actStockMAS.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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
    
    public static String actStockMASDañados(ArticuloMovil art) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", art.getIdproducto());
                jsonObjectProductos.put("stock", art.getStock());
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "actStockMASDañados.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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

    /* public static String InactivarArticulo(String cod) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_activo = 'N' WHERE art_codigo = ");
        sql.append(cod);
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }*/
 /* public static String ActivarArticulo(String cod) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_activo = 'S' WHERE art_codigo = ");
        sql.append(cod);
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }*/
    public static String delArticulo(String cod) {
        String msg = null;
        try {
            JSONArray jsonArrayProductos = new JSONArray();
            JSONObject jsonObjectProductos = new JSONObject();
            try {
                jsonObjectProductos.put("idproducto", cod);
                jsonObjectProductos.put("estado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayProductos.put(jsonObjectProductos);
            JSONObject json = new JSONObject();
            try {
                json.put("producto", jsonArrayProductos);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delProducto.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonProducto", json);

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

    public static ArticuloMovil busArticulo(String cod) {
        ArticuloMovil ar = new ArticuloMovil();
        try {
            HttpClient producto = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject jsonProducto = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonProducto.length(); f++) {
                                ar.setIdproducto(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("idproducto").toString()));
                                ar.setCodinterno(jsonProducto.getJSONObject("" + f + "").get("cod_interno").toString());
                                ar.setCodBarra(jsonProducto.getJSONObject("" + f + "").get("cod_barra").toString());
                                ar.setDescripcion(jsonProducto.getJSONObject("" + f + "").get("descripcion").toString());
                                ar.setPrecio_costo(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("precio_costo").toString()));
                                ar.setGanancia(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("ganancia").toString()));
                                ar.setPorG(Double.parseDouble(jsonProducto.getJSONObject("" + f + "").get("por_ganancia").toString()));
                                ar.setPrecio_venta(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("precio_venta").toString()));
                                ar.setStock(Double.parseDouble(jsonProducto.getJSONObject("" + f + "").get("stock").toString()));
                                ar.setUm(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("um_idunidad").toString()));
                                ar.setDivision(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("division_iddivision").toString()));
                                ar.setIva(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("iva_idiva").toString()));
                                ar.setVentam((jsonProducto.getJSONObject("" + f + "").get("ventam").toString()));
                                ar.setCantm(Double.parseDouble(jsonProducto.getJSONObject("" + f + "").get("cantm").toString()));
                                ar.setPreciominorista(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("preciominorista").toString()));
                                ar.setGananciaminorista(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("gananciaminorista").toString()));
                                ar.setPorGMinorista(Double.parseDouble(jsonProducto.getJSONObject("" + f + "").get("por_gan_minorista").toString()));
                                ar.setPreciosupermercado(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("precio_supermercado").toString()));
                                ar.setGananciasupermercado(Integer.parseInt(jsonProducto.getJSONObject("" + f + "").get("ganancia_super").toString()));
                                ar.setPorGSupermercado(Double.parseDouble(jsonProducto.getJSONObject("" + f + "").get("por_gan_super").toString()));
                                System.out.println("Encontrado");
                            }
                        } catch (JSONException e) {
                            System.out.println("No encontrado");
                        }
                    }
                }
            });
            producto.excecute(urlServer() + "getProducto.php?idproducto="+cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return ar;
    }

    /*public static List listArticulo(String cod) {
        String sql = new StringBuffer("SELECT idproducto, cod_barra, descripcion, stock"
                + " FROM v_productos2")
                .append(" ORDER BY ").append(cod)
                .toString();
        return OperacionMovil.getTabla(sql);
    }*/

    public static List listArticuloMovil(String cod) {
        /*String sql = new StringBuffer("SELECT idproducto, cod_interno, cod_barra, despcripcion, precio_venta,"
                        + "impu, medida, clasif FROM v_productos")*/
        String sql = new StringBuffer("SELECT * FROM v_productos2")
                .append(" ORDER BY ").append(cod)
                .toString();
        return OperacionMovil.getTabla(sql);
    }

    /*public static List filtrarCodBarraActivo(String cad) {
        String sql = new StringBuffer("SELECT idproducto, cod_interno, cod_barra, descripcion, precio_costo FROM v_productos")
                .append(" WHERE cod_interno LIKE '")
                .append(cad)
                .append("' OR cod_barra LIKE '")
                .append(cad)
                .append("' OR descripcion LIKE '%")
                .append(cad)
                .append("%' ORDER BY idproducto DESC")
                .toString();
        return OperacionMovil.getTabla(sql);
    }*/

    public static List filtrarArticulosActivoAuxiliarReparto(String cad) {
        String sql = new StringBuffer("SELECT idproducto, cod_interno, cod_barra, descripcion, precio_venta FROM v_productos")
                .append(" WHERE cod_interno LIKE '")
                .append(cad)
                .append("' OR cod_barra LIKE '")
                .append(cad)
                .append("' OR descripcion LIKE '%")
                .append(cad)
                .append("%' ORDER BY idproducto DESC")
                .toString();
        return OperacionMovil.getTabla(sql);
    }

    /*public static List filtrarGralenBusqueda(String cad) {
        String sql = new StringBuffer("SELECT idproducto, cod_barra, descripcion, stock FROM v_productos2")
                .append(" WHERE cod_barra LIKE '")
                .append(cad)
                .append("' OR descripcion LIKE '%")
                .append(cad)
                .append("%' order by idproducto ASC")
                .toString();
        return OperacionMovil.getTabla(sql);
    }*/

    /*public static List filtrarGral(String cad) {
        String sql = new StringBuffer("SELECT * FROM v_productos2")
                .append(" WHERE cod_barra LIKE '")
                .append(cad)
                .append("' OR descripcion LIKE '%")
                .append(cad)
                .append("%' order by idproducto ASC")
                .toString();
        return OperacionMovil.getTabla(sql);
    }*/
    /*public static List filtrarCodBarraActivo(String cad) {
        String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva, ")
                .append("ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo ")
                .append("WHERE barra LIKE '%")
                .append(cad)
                .append("%' OR descripcion LIKE '%")
                .append(cad)
                .append("%' OR principio LIKE '%")
                .append(cad)
                .append("%' AND activo='SI' AND ind= 'S' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }*/

}
