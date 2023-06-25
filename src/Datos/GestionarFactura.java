package Datos;

import Componentes.Fecha;
import Componentes.Operacion;
import Componentes.OperacionMovil;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Modelo.DetalleFactura;
import Modelo.Factura;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestionarFactura {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigoFactura("SELECT IFNULL ((select MAX(fac_codigo) from factura),0) AS fac_codigo");
        return cod;
    }
    public static String getFactura() {
        String cod = generarCodigos.getCodigo("SELECT MAX(fac_factura) from factura");
        return cod;
    }

    public static String addFactura(Factura f) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO factura VALUES (");
        sql.append(f.getCodFactura()).append(",");
        sql.append(f.getCodCliente()).append(",");
        sql.append(f.getCodVendedor()).append(",");
        sql.append(f.getDescuento()).append(",'");
        sql.append(f.getTipoPago()).append("','");
        sql.append(f.getFecha()).append("','");
        sql.append(Fecha.darHora()).append("','");
        sql.append(f.getNeto()).append("' ,");
        sql.append(f.getTotal()).append(",'S')");
        msg = Operacion.exeOperacion(sql.toString());
//        msg = Operacion.exeOperacion("INSERT INTO factura VALUES ("
//                + f.getCodFactura() + ","
//                + f.getCodCliente() + ","
//                + f.getCodVendedor() + ","
//                + f.getDescuento() + ",'"
//                + f.getTipoPago() + "','"
//                + f.getFecha() + "','"
//                + Fecha.darHora() + "','"
//                + f.getNeto() + "' ,"
//                + f.getTotal() + ",'S')");
        return msg;
    }

    public static String actFactura(String cod, String usuario) {
        String msg = null;
        try {
            JSONArray jsonArrayFactura = new JSONArray();
            JSONObject jsonObjectFactura = new JSONObject();
            try {
                jsonObjectFactura.put("fac_codigo", cod);
                jsonObjectFactura.put("usu", usuario);
                jsonObjectFactura.put("fac_indicador", "N");                                
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayFactura.put(jsonObjectFactura);
            JSONObject json = new JSONObject();
            try {
                json.put("factura", jsonArrayFactura);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delFactura.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonFactura", json);

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
    
    public static String actFacturaMovil(String cod, String idemision) {
        String msg = null;
        try {
            JSONArray jsonArrayFactura = new JSONArray();
            JSONObject jsonObjectFactura = new JSONObject();
            try {
                jsonObjectFactura.put("idventas", cod);
                jsonObjectFactura.put("idemision", idemision);
                jsonObjectFactura.put("estado", "N");
            } catch (JSONException pr) {
                System.out.println(pr.getMessage());
            }
            jsonArrayFactura.put(jsonObjectFactura);
            JSONObject json = new JSONObject();
            try {
                json.put("factura", jsonArrayFactura);
            } catch (JSONException ex) {
                System.out.println("ex: " + ex.getMessage());
            }
            //String jsonStrAcceso = json.toString();       
            URL url = new URL(urlServer() + "delFacturaMovil.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("jsonFactura", json);

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

    public static String addDetalleFactura(DetalleFactura df) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO detalle_factura VALUES (0,");
        sql.append(df.getCodFactura()).append(",");
        sql.append(df.getCodArticulo()).append(",");
        sql.append(df.getCantidad()).append(",");
        sql.append(df.getPrecio()).append(",");
        sql.append(df.getTotal()).append(")");
        msg = Operacion.exeOperacion(sql.toString());
//        msg = Operacion.exeOperacion("INSERT INTO detalle_factura VALUES ("
//                + df.getCodFactura() + ","
//                + df.getCodArticulo() + ","
//                + df.getCantidad() + ","
//                + df.getPrecio() + ","
//                + df.getTotal() + ")");
        return msg;
    }

    public static Factura busFactura(String cod) {
        Factura fac = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM factura WHERE fac_codigo=");
        sql.append(cod).append("");
//        String sql = "SELECT * FROM factura WHERE fac_codigo=" + cod + "";
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            fac = new Factura();
            fac.setCodFactura(Integer.parseInt(filaObt[0].toString()));
            fac.setCodCliente(Integer.parseInt(filaObt[1].toString()));
            fac.setCodVendedor(Integer.parseInt(filaObt[2].toString()));
            fac.setDescuento(Double.parseDouble(filaObt[3].toString()));
            fac.setTipoPago(filaObt[4].toString());
            fac.setFecha(filaObt[5].toString());
            fac.setHora(filaObt[6].toString());
            fac.setTotal(Double.parseDouble(filaObt[7].toString()));
        } else {
            System.out.println("No encontrado");
        }
        return fac;
    }

    /*public static List listFacturas() {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.razon_social,");
        sql.append("factura.fac_fecha,");
        sql.append("factura.fac_hora,");
        sql.append("clientes.idcliente,");
        sql.append("factura.caja_ca_id,");
        sql.append("factura.fac_factura,");
        sql.append("factura.fac_tipoventa,");
        sql.append("factura.estado,");
        sql.append("factura.fac_totalfinal,");
        sql.append("vendedor.ven_codigo,");
        sql.append("factura.fac_indicador");
        sql.append(" FROM factura ");
        sql.append(" JOIN vendedor ON factura.vendedor_ven_codigo = vendedor.ven_codigo");
        sql.append(" JOIN clientes ON factura.clientes_cli_codigo = clientes.idcliente");
        sql.append(" ORDER BY factura.fac_codigo ASC");
        return Operacion.getTabla(sql.toString());
    }*/
    
   /* public static List listFacturasMovil1(String fecha) {
        StringBuilder sql = new StringBuilder("SELECT id,idemision,timbra,fechadesde,fechahasta,estable,pexp,factura,condicion,");
        sql.append("fecha,hora,ruc,razon_social,totalfinal,nombre,estado,exenta,iva5,iva10");
        sql.append(" FROM v_venta_1");
        sql.append(" WHERE fecha='").append(fecha).append("'");
        sql.append(" ORDER BY idemision, id ASC");
        return OperacionMovil.getTabla(sql.toString());
    }*/
    
    public static List listVentasCabeceras(String fechaD, String fechaH) {
        StringBuilder sql = new StringBuilder("SELECT * FROM v_ventacabecera");
        sql.append(" WHERE fecha>='").append(fechaD).append("'");
        sql.append(" AND fecha<='").append(fechaH).append("'");
        sql.append(" ORDER by idemision ASC ");
        return OperacionMovil.getTabla(sql.toString());
    }

    public static List listFacturasMovilesT(String idT, String fecha) {
        StringBuilder sql = new StringBuilder("SELECT id,idemision,timbra,fechadesde,fechahasta,estable,pexp,factura,condicion,");
        sql.append("fecha,hora,ruc,razon_social,totalfinal,nombre,estado,exenta,iva5,iva10");
        sql.append(" FROM v_venta_1");
        sql.append(" WHERE idtimbrado=").append(idT);
        sql.append(" AND fecha='").append(fecha).append("'");
        sql.append(" ORDER BY idemision, id ASC");
        return OperacionMovil.getTabla(sql.toString());
    }
    public static List listFacturasMovilesTPE(String idPE,String idT, String fecha) {
        StringBuilder sql = new StringBuilder("SELECT id,idemision,timbra,fechadesde,fechahasta,estable,pexp,factura,condicion,");
        sql.append("fecha,hora,ruc,razon_social,totalfinal,nombre,estado,exenta,iva5,iva10");
        sql.append(" FROM v_venta_1");
        sql.append(" WHERE idemision=").append(idPE);
        sql.append(" AND idtimbrado=").append(idT);
        sql.append(" AND fecha='").append(fecha).append("'");
        sql.append(" ORDER BY id ASC");
        return OperacionMovil.getTabla(sql.toString());
    }
    
    public static List listFacturasCredito(String cliente) {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("factura.fac_fecha,");
        sql.append("factura.fac_hora,");
        sql.append("clientes.cli_codigo,");
        sql.append("factura.caja_ca_id,");
        sql.append("factura.fac_factura,");
        sql.append("factura.fac_tipoventa,");
        sql.append("factura.estado,");
        sql.append("factura.fac_totalfinal,");
        sql.append("vendedor.ven_codigo,");
        sql.append("factura.fac_indicador");
        sql.append(" FROM factura ");
        sql.append(" JOIN vendedor ON factura.vendedor_ven_codigo = vendedor.ven_codigo");
        sql.append(" JOIN clientes ON factura.clientes_cli_codigo = clientes.cli_codigo");
        sql.append(" WHERE clientes.cli_codigo=");
        sql.append(cliente);
        sql.append(" AND factura.fac_tipoventa='CREDITO'");
        sql.append(" ORDER BY factura.fac_codigo ASC");
        return Operacion.getTabla(sql.toString());
    }
    public static List listFacturasCreditoPendiente(String cliente) {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("factura.fac_fecha,");
        sql.append("factura.fac_hora,");
        sql.append("clientes.cli_codigo,");
        sql.append("factura.caja_ca_id,");
        sql.append("factura.fac_factura,");
        sql.append("factura.fac_tipoventa,");
        sql.append("factura.estado,");
        sql.append("factura.fac_totalfinal,");
        sql.append("vendedor.ven_codigo,");
        sql.append("factura.fac_indicador");
        sql.append(" FROM factura ");
        sql.append(" JOIN vendedor ON factura.vendedor_ven_codigo = vendedor.ven_codigo");
        sql.append(" JOIN clientes ON factura.clientes_cli_codigo = clientes.cli_codigo");
        sql.append(" WHERE clientes.cli_codigo=");
        sql.append(cliente);
        sql.append(" AND factura.estado='PENDIENTE'");
        sql.append(" AND factura.fac_tipoventa='CREDITO'");
        sql.append(" ORDER BY factura.fac_codigo ASC");
        return Operacion.getTabla(sql.toString());
    }
    public static List listFacturasCreditoActivo(String cliente) {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("factura.fac_fecha,");
        sql.append("factura.fac_hora,");
        sql.append("clientes.cli_codigo,");
        sql.append("factura.caja_ca_id,");
        sql.append("factura.fac_factura,");
        sql.append("factura.fac_tipoventa,");
        sql.append("factura.estado,");
        sql.append("factura.fac_totalfinal,");
        sql.append("vendedor.ven_codigo,");
        sql.append("factura.fac_indicador");
        sql.append(" FROM factura ");
        sql.append(" JOIN vendedor ON factura.vendedor_ven_codigo = vendedor.ven_codigo");
        sql.append(" JOIN clientes ON factura.clientes_cli_codigo = clientes.cli_codigo");
        sql.append(" WHERE clientes.cli_codigo=");
        sql.append(cliente);
        sql.append(" AND factura.fac_indicador='S'");
        sql.append(" AND factura.fac_tipoventa='CREDITO'");
        sql.append(" ORDER BY factura.fac_codigo ASC");
        return Operacion.getTabla(sql.toString());
    }
    public static List listFacturasCreditoPendienteActivo(String cliente) {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("factura.fac_fecha,");
        sql.append("factura.fac_hora,");
        sql.append("clientes.cli_codigo,");
        sql.append("factura.caja_ca_id,");
        sql.append("factura.fac_factura,");
        sql.append("factura.fac_tipoventa,");
        sql.append("factura.estado,");
        sql.append("factura.fac_totalfinal,");
        sql.append("vendedor.ven_codigo,");
        sql.append("factura.fac_indicador");
        sql.append(" FROM factura ");
        sql.append(" JOIN vendedor ON factura.vendedor_ven_codigo = vendedor.ven_codigo");
        sql.append(" JOIN clientes ON factura.clientes_cli_codigo = clientes.cli_codigo");
        sql.append(" WHERE clientes.cli_codigo=");
        sql.append(cliente);
        sql.append(" AND factura.fac_indicador='S'");
        sql.append(" AND factura.estado='PENDIENTE'");
        sql.append(" AND factura.fac_tipoventa='CREDITO'");
        sql.append(" ORDER BY factura.fac_codigo ASC");
        return Operacion.getTabla(sql.toString());
    }

    public static List lisFacturas2() {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("factura.fac_fecha,");
        sql.append("clientes.cli_codigo,");
        sql.append("factura.fac_tipoventa,");
        sql.append("factura.fac_total,");
        sql.append("vendedor.ven_codigo ");
        sql.append(" FROM ((factura ");
        sql.append(" JOIN vendedor ON ((factura.vendedor_ven_codigo = vendedor.ven_codigo))) ");
        sql.append(" JOIN clientes ON ((factura.clientes_cli_codigo = clientes.cli_codigo))) ");
        sql.append(" WHERE (((factura.fac_indicador) = 'S') AND (NOT (EXISTS ( SELECT factura.fac_codigo ");
        sql.append(" FROM notacredito ");
        sql.append(" WHERE (factura.fac_codigo = notacredito.nc_factura)))))");
        return Operacion.getTabla(sql.toString());
    }

//    public static List listFacturasAnuladas() {
//        String sql = "SELECT factura.fac_codigo, clientes.cli_razonSocial, factura.fac_fecha, clientes.cli_codigo, factura.fac_descuento,factura.fac_total, vendedor.ven_codigo FROM factura, clientes, vendedor where factura.fac_cliente = clientes.cli_codigo AND factura.fac_vendedor = vendedor.ven_codigo AND factura.fac_indicador='N'";
//        return Operacion.getTabla(sql);
//    }
    public static List fillCliente(String nom) {
        StringBuilder sql = new StringBuilder("SELECT factura.fac_codigo,");
        sql.append("clientes.cli_razonsocial,");
        sql.append("factura.fac_fecha,");
        sql.append("clientes.cli_codigo,");
        sql.append("factura.fac_descuento,");
        sql.append("factura.fac_total,");
        sql.append("vendedor.ven_codigo ");
        sql.append(" FROM ((factura ");
        sql.append(" JOIN vendedor ON ((factura.fac_vendedor = vendedor.ven_codigo))) ");
        sql.append(" JOIN clientes ON ((factura.fac_cliente = clientes.cli_codigo))) ");
        sql.append(" WHERE ");
        sql.append("(((factura.fac_indicador) = 'S') AND ");
        sql.append(" (NOT (EXISTS ( SELECT factura.fac_codigo ");
        sql.append(" FROM notacredito ");
        sql.append("  WHERE (factura.fac_codigo = notacredito.nc_factura)))) AND clientes.cli_razonsocial ILIKE '");
        sql.append(nom).append("%')");
//        String sql = "SELECT factura.fac_codigo,"
//                + "    clientes.cli_razonsocial,"
//                + "    factura.fac_fecha,"
//                + "    clientes.cli_codigo,"
//                + "    factura.fac_descuento,"
//                + "    factura.fac_total,"
//                + "    vendedor.ven_codigo"
//                + "   FROM ((factura"
//                + "   JOIN vendedor ON ((factura.fac_vendedor = vendedor.ven_codigo)))"
//                + "   JOIN clientes ON ((factura.fac_cliente = clientes.cli_codigo)))"
//                + "   WHERE "
//                + "(((factura.fac_indicador) = 'S') AND "
//                + "(NOT (EXISTS ( SELECT factura.fac_codigo"
//                + "   FROM notacredito"
//                + "  WHERE (factura.fac_codigo = notacredito.nc_factura)))) AND clientes.cli_razonsocial ILIKE '" + nom + "%')";
        return Operacion.getTabla(sql.toString());
    }

   /* public static List listDetalles(String cod) {
        StringBuilder sql = new StringBuilder("SELECT detalle_factura.ven_cantidad,");
        sql.append("detalle_factura.articulo_art_codigo,");
        sql.append("productos.cod_interno,");
        sql.append("productos.descripcion,");
        sql.append("detalle_factura.ven_precio,");
        sql.append("detalle_factura.ven_total");
        sql.append(" FROM detalle_factura");
        sql.append(" JOIN productos ON detalle_factura.articulo_art_codigo = productos.idproducto");
        sql.append(" JOIN factura ON detalle_factura.factura_fac_codigo = factura.fac_codigo");
        sql.append(" WHERE factura.fac_codigo=").append(cod);
        return Operacion.getTabla(sql.toString());
    }*/
    
    /*public static List listDetallesVentasMovil(String cod, String idemision) {
        StringBuilder sql = new StringBuilder("SELECT cod_interno,cod_barra,producto,cant,precio,total,impuesto_aplicado,um");
        sql.append(" FROM v_detalleventa1");
        sql.append(" WHERE id=").append(cod);
        sql.append(" AND idemision=").append(idemision);
        return OperacionMovil.getTabla(sql.toString());
    }*/

    /*public static List listDetallesF(String cod) {
        StringBuilder sql = new StringBuilder("SELECT detalle_factura.df_cantidad,");
        sql.append("detalle_factura.df_articulo,");
        sql.append("articulo.art_descripcion,");
        sql.append("detalle_factura.df_precarticulo,");
        sql.append("detalle_factura.df_total ");
        sql.append(" FROM ((detalle_factura ");
        sql.append(" JOIN factura ON ((detalle_factura.fac_codigo = factura.fac_codigo))) ");
        sql.append(" JOIN articulo ON ((detalle_factura.df_articulo = articulo.art_codigo))) ");
        sql.append(" WHERE (factura.fac_codigo = ").append(cod).append(")");
        return Operacion.getTabla(sql.toString());
    }*/

}
