package Datos;

import Componentes.Fecha;
import Componentes.Operacion;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.Compra;
import Modelo.DetalleCompra;
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

public class GestionarCompra {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoCompra("SELECT IFNULL ((select MAX(com_codigo) from compra),0) AS com_codigo");
        return cod;
    }
    
    public static String getCodigoPago() {
        String cod = generarCodigos.getCodigoPago("SELECT IFNULL ((select MAX(idpagos) from pagos_compras),0) AS idpagos");
        return cod;
    }
    
    public static String getCodigoPagoCredito() {
        String cod = generarCodigos.getCodigoPago("SELECT IFNULL ((select MAX(idpagos) from pagos_ventas),0) AS idpagos");
        return cod;
    }
    
    public static String addCompra(Compra c) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO compra VALUES (");
        sql.append(c.getCodCompra()).append(",");
        sql.append(c.getCodProveedor()).append(",'");
        sql.append(c.getCondPago()).append("','");
        sql.append(c.getFact()).append("','");
        sql.append(c.getFecha()).append("','");
        sql.append(Fecha.darHora()).append("',");
        sql.append(c.getTotal()).append(",");
        sql.append(c.getExenta()).append(",");
        sql.append(c.getIVA5()).append(",");
        sql.append(c.getIVA10()).append(",'S')");
        msg = Operacion.exeOperacion(sql.toString());

        return msg;
    }


    public static String actCompra(Compra c) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE compras SET com_codigo=");
        sql.append(c.getCodCompra()).append(",com_proveedor=");
        sql.append(c.getCodProveedor()).append(",com_condPago='");
        sql.append(c.getCondPago()).append("',com_fecha='");
        sql.append(c.getFecha()).append("',com_total=");
        sql.append(c.getTotal()).append(",com_indicador='N' WHERE com_codigo=");
        sql.append(c.getCodCompra()).append("");
        msg = Operacion.exeOperacion(sql.toString());
//        msg = Operacion.exeOperacion("UPDATE compras SET com_codigo=" 
//                + c.getCodCompra() + ",com_proveedor=" 
//                + c.getCodProveedor() + ",com_condPago='" 
//                + c.getCondPago() + "',com_fecha='" 
//                + c.getFecha() + "',com_total=" 
//                + c.getTotal() + ",com_indicador='N' WHERE com_codigo=" 
//                + c.getCodCompra() + "");
        return msg;
    }

    public static String addDetalleCompra(DetalleCompra dc) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO detalle_compra VALUES (");
        sql.append(dc.getCodCompra()).append(",");
        sql.append(dc.getCodArticulo()).append(",");
        sql.append(dc.getCant()).append(",");
        sql.append(dc.getPrecio()).append(",");
        sql.append(dc.getMonto()).append(")");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static String delCompra(String cod, String usuario) {        
        String msg = null;
        try {
            JSONArray jsonArrayCompra = new JSONArray();
            JSONObject jsonObjectCompra = new JSONObject();
            try {
                jsonObjectCompra.put("com_codigo", cod);
                jsonObjectCompra.put("usu", usuario);
                jsonObjectCompra.put("com_indicador", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayCompra.put(jsonObjectCompra);
            JSONObject json = new JSONObject();
            try {
                json.put("compra", jsonArrayCompra);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delCompra.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonCompra", json);

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

    /*public static List listarCompras() {
        StringBuilder sql = new StringBuilder("SELECT compra.com_codigo,");
        sql.append("compra.caja_ca_id,");
        sql.append("compra.tipo,");
        sql.append(" compra.com_fecha,");
        sql.append(" compra.com_hora,");
        sql.append(" proveedor.pro_ruc,");
        sql.append(" proveedor.pro_razonsocial,");
        sql.append(" compra.com_condpago,");
        sql.append(" compra.com_factura,");
        sql.append(" proveedor.pro_codigo,");
        sql.append(" compra.com_total,");
        sql.append(" compra.com_indicador,");
        sql.append(" compra.obs");
        sql.append(" FROM compra ");
        sql.append(" JOIN proveedor ON compra.proveedor_pro_codigo = proveedor.pro_codigo");
        //sql.append(" WHERE compra.com_indicador='S'");
        return Operacion.getTabla(sql.toString());
    }*/
    
    public static List listarComprasReparto(String caja) {
        StringBuilder sql = new StringBuilder("SELECT compra.com_codigo,");
        sql.append("compra.caja_ca_id,");
        sql.append("compra.tipo,");
        sql.append(" compra.com_fecha,");
        sql.append(" compra.com_hora,");
        sql.append(" proveedor.pro_ruc,");
        sql.append(" proveedor.pro_razonsocial,");
        sql.append(" compra.com_condpago,");
        sql.append(" compra.com_factura,");
        sql.append(" proveedor.pro_codigo,");
        sql.append(" compra.com_total,");
        sql.append(" compra.com_indicador,");
        sql.append(" compra.obs");
        sql.append(" FROM compra ");
        sql.append(" JOIN proveedor ON compra.proveedor_pro_codigo = proveedor.pro_codigo");
        sql.append(" WHERE compra.caja_ca_id=").append(caja);
        sql.append(" AND compra.tipo='R'");
        sql.append(" AND compra.com_indicador='S'");
        return Operacion.getTabla(sql.toString());
    }

    /*public static List listarDetalleCompras(String cod) {
        StringBuilder sql = new StringBuilder("SELECT `p-ventasbd_jca`.detalle_compra.compra_com_codigo,");
        sql.append("jca_representaciones.productos.idproducto,");
        sql.append("jca_representaciones.productos.cod_interno,");
        sql.append("jca_representaciones.productos.descripcion,");
        sql.append("`p-ventasbd_jca`.detalle_compra.com_cantidad,");
        sql.append("`p-ventasbd_jca`.detalle_compra.com_costo,");
        sql.append("`p-ventasbd_jca`.detalle_compra.com_total,");
        sql.append("jca_representaciones.productos.precio_venta, (`p-ventasbd_jca`.detalle_compra.com_cantidad * jca_representaciones.productos.precio_venta) AS venta_total");
        sql.append(" FROM `p-ventasbd_jca`.compra");
        sql.append(" JOIN `p-ventasbd_jca`.detalle_compra ON `p-ventasbd_jca`.detalle_compra.compra_com_codigo = `p-ventasbd_jca`.compra.com_codigo");
        sql.append(" JOIN jca_representaciones.productos ON `p-ventasbd_jca`.detalle_compra.articulo_art_codigo = jca_representaciones.productos.idproducto");
        sql.append(" WHERE `p-ventasbd_jca`.compra.com_codigo =").append(cod);
        return Operacion.getTabla(sql.toString());
    }*/

}
