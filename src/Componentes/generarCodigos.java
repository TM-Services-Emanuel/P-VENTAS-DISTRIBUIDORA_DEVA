package Componentes;

import static Componentes.URL.urlServer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/*CLASE PARA GENERAR LOS ID's DE TODAS LAS TABLAS Y PARA EXTRAER VALORES ENTEROS*/
 /*-------------------------------------------------------------------------------*/
public class generarCodigos {

    static ConexionBD conectar = ConexionBD.getInstancia();

    public static String getCodigo(String consulta)//Traemos el id mayor de las tablas
    {
        String codgen = "";
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + consulta);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder codLogueo = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    codLogueo.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodLogueo = new JSONArray(codLogueo.toString());
                if (jsonCodLogueo.length() != 0) {
                    JSONObject objectCodLogueo = jsonCodLogueo.getJSONObject(0);
                    codgen = objectCodLogueo.getString("acc_codigo");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codgen;//Retornamos el valor
    }

    public static String getCodigoFactura(String consulta)//Traemos el id mayor de las tablas
    {
        String codFactura = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Factura = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Factura.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodFactura = new JSONArray(Factura.toString());
                if (jsonCodFactura.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodFactura.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("fac_codigo"))+ 1;
                    codFactura = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codFactura;//Retornamos el valor
    }
    
    public static String getCodigoCompra(String consulta)//Traemos el id mayor de las tablas
    {
        String codCompra = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Factura = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Factura.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodFactura = new JSONArray(Factura.toString());
                if (jsonCodFactura.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodFactura.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("com_codigo"))+ 1;
                    codCompra = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codCompra;//Retornamos el valor
    }
    
    public static String getCodigoPago(String consulta)//Traemos el id mayor de las tablas
    {
        String codPago = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Pago = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Pago.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodPago = new JSONArray(Pago.toString());
                if (jsonCodPago.length() != 0) {
                    JSONObject objectCodPago = jsonCodPago.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodPago.getString("idpagos"))+ 1;
                    codPago = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codPago;//Retornamos el valor
    }
    
    public static String getCodigoNCProveedor(String consulta)//Traemos el id mayor de las tablas
    {
        String codCompra = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Factura = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Factura.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodFactura = new JSONArray(Factura.toString());
                if (jsonCodFactura.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodFactura.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("idnota"))+ 1;
                    codCompra = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codCompra;//Retornamos el valor
    }
    
    public static String getCodigoSalida(String consulta)//Traemos el id mayor de las tablas
    {
        String codCompra = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Salida = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Salida.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodSalida = new JSONArray(Salida.toString());
                if (jsonCodSalida.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodSalida.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("sal_codigo"))+ 1;
                    codCompra = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codCompra;//Retornamos el valor
    }
    
    public static String getCodigoSolicitudNC(String consulta)//Traemos el id mayor de las tablas
    {
        String codS = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Salida = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Salida.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodSalida = new JSONArray(Salida.toString());
                if (jsonCodSalida.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodSalida.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("idsolicitud"))+ 1;
                    codS = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codS;//Retornamos el valor
    }
    
    public static String getCodigoSolicitudD(String consulta)//Traemos el id mayor de las tablas
    {
        String codD = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Salida = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Salida.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodSalida = new JSONArray(Salida.toString());
                if (jsonCodSalida.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodSalida.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("idsolicitud"))+ 1;
                    codD = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codD;//Retornamos el valor
    }
    
    public static String getCodigoMotivo(String consulta)//Traemos el id mayor de las tablas
    {
        String codMotivo = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Salida = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Salida.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodSalida = new JSONArray(Salida.toString());
                if (jsonCodSalida.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodSalida.getJSONObject(0);
                    int cod = Integer.parseInt(objectCodEmpresa.getString("mot_codigo"))+ 1;
                    codMotivo = String.valueOf(cod);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codMotivo;//Retornamos el valor
    }


    public static String getCodigoEmpresa(String consulta)//Traemos el id mayor de las tablas
    {
        String codEmpresa = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder Empresa = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Empresa.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodEmpresa = new JSONArray(Empresa.toString());
                if (jsonCodEmpresa.length() != 0) {
                    JSONObject objectCodEmpresa = jsonCodEmpresa.getJSONObject(0);
                    codEmpresa = objectCodEmpresa.getString("MAX(idempresa)");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codEmpresa;//Retornamos el valor
    }

    public static String getCodigoCaja(String consulta)//Traemos el id mayor de las tablas
    {
        String codCaja = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder IDCaja = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    IDCaja.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodCaja = new JSONArray(IDCaja.toString());
                if (jsonCodCaja.length() != 0) {
                    JSONObject objectCodCaja = jsonCodCaja.getJSONObject(0);
                    int id = Integer.parseInt(objectCodCaja.getString("MAX(ca_id)")) + 1;
                    codCaja = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codCaja;//Retornamos el valor
    }

    public static String getCodigoProducto(String consulta)//Traemos el id mayor de las tablas
    {
        String codproducto = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder idProducto = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    idProducto.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonIdProducto = new JSONArray(idProducto.toString());
                if (jsonIdProducto.length() != 0) {
                    JSONObject objectCodCaja = jsonIdProducto.getJSONObject(0);
                    int id = Integer.parseInt(objectCodCaja.getString("MAX(idproducto)")) + 1;
                    codproducto = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codproducto;//Retornamos el valor
    }

    public static String getCodigoCliente(String consulta)//Traemos el id mayor de las tablas
    {
        String codCliente = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder idCliente = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    idCliente.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonIdCliente = new JSONArray(idCliente.toString());
                if (jsonIdCliente.length() != 0) {
                    JSONObject objectCodCaja = jsonIdCliente.getJSONObject(0);
                    int id = Integer.parseInt(objectCodCaja.getString("MAX(idcliente)")) + 1;
                    codCliente = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codCliente;//Retornamos el valor
    }
    
    public static String getCodigoProveedor(String consulta)//Traemos el id mayor de las tablas
    {
        String codProveedor = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder idCliente = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    idCliente.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonIdProveedor = new JSONArray(idCliente.toString());
                if (jsonIdProveedor.length() != 0) {
                    JSONObject objectCodProveedor = jsonIdProveedor.getJSONObject(0);
                    int id = Integer.parseInt(objectCodProveedor.getString("MAX(pro_codigo)")) + 1;
                    codProveedor = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codProveedor;//Retornamos el valor
    }

    public static String getCodigoTimbrado(String consulta)//Traemos el id mayor de las tablas
    {
        String codTimbrado = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder idTimbrado = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    idTimbrado.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonResp = new JSONArray(idTimbrado.toString());
                if (jsonResp.length() != 0) {
                    JSONObject objectCodCaja = jsonResp.getJSONObject(0);
                    int id = Integer.parseInt(objectCodCaja.getString("MAX(idtimbrado)")) + 1;
                    codTimbrado = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codTimbrado;//Retornamos el valor
    }

    public static String getCodigoPuntoEmision(String consulta)//Traemos el id mayor de las tablas
    {
        String codPE = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder idPE = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    idPE.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonResp = new JSONArray(idPE.toString());
                if (jsonResp.length() != 0) {
                    JSONObject objectCodCaja = jsonResp.getJSONObject(0);
                    int id = Integer.parseInt(objectCodCaja.getString("MAX(idemision)")) + 1;
                    codPE = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codPE;//Retornamos el valor
    }

    public static String getCodigoCajaActual(String consulta)//Traemos el id mayor de las tablas
    {
        String codCaja = "";
        String putConsult;
        if (consulta.contains(" ")) {
            putConsult = consulta.replace(" ", "%20");
        } else {
            putConsult = consulta;
        }
        try {
            URL url = new URL(urlServer() + "getCod.php?consulta=" + putConsult);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder IDCaja = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    IDCaja.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodCaja = new JSONArray(IDCaja.toString());
                if (jsonCodCaja.length() != 0) {
                    JSONObject objectCodCaja = jsonCodCaja.getJSONObject(0);
                    int id = Integer.parseInt(objectCodCaja.getString("ca_id"));
                    codCaja = String.valueOf(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codCaja;//Retornamos el valor
    }

    public static String getCodigoMovil(String sql)//Traemos el id mayor de las tablas
    {
        String codgen = "";
        //String CodMaximo = "";
        //int contador = 0;
        try {
            //System.out.println("1");
            try ( Connection conexion = (Connection) conectar.getConexion()//Nos conectamos
                    ) {
                //System.out.println("1");
                Statement sentencia = (Statement) conexion.createStatement();
                //System.out.println("2");
                ResultSet resultado = sentencia.executeQuery(sql);
                // System.out.println("3");
                resultado.first();
                codgen = String.valueOf(resultado.getInt(1) + 1);
            }
        } catch (SQLException e) {
            //Excepcion en caso la tabla este vacian()
            System.out.println(e.getMessage());
            System.out.println("Tabla vacía*");
        }

        return codgen;//Retornamos el valor
    }

    public static String ObtenerCodigo(String sql)//Traemos el id mayor de las tablas
    {
        String codgen = "";
        //String CodMaximo = "";
        //int contador = 0;
        try {
            //System.out.println("1");
            try ( Connection conexion = (Connection) conectar.getConexion() //Nos conectamos
                    ) {
                //System.out.println("1");
                Statement sentencia = (Statement) conexion.createStatement();
                //System.out.println("2");
                ResultSet resultado = sentencia.executeQuery(sql);
                // System.out.println("3");
                resultado.first();
                codgen = String.valueOf(resultado.getInt(1));
            }
        } catch (SQLException e) {
            //Excepcion en caso la tabla este vacian()
            System.out.println(e.getMessage());
            System.out.println("Tabla vacía*");
        }

        return codgen;//Retornamos el valor
    }

    /*static String unoMas(int num)//Aumentar el valor obtenido en getCodigo() +1
    {
        String nnum = String.valueOf(num);
        for (int i = String.valueOf(num).length(); i <= 1; i++) {
            nnum = "" + nnum;//Sumamos el valor
        }
        return nnum;//Retornamos el valor
    }*/
    public static String getCantidad(String sql)//Metodo para traer valores enteros de la base de datos
    {
        String codgen = "";
        String CodMaximo = "";
        int contador = 0;
        try {
            try ( Connection conexion = (Connection) conectar.getConexion() //Nos conectamos
                    ) {
                Statement sentencia = (Statement) conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql);
                ResultSetMetaData rmeta = (ResultSetMetaData) resultado.getMetaData();
                int numColumnas = rmeta.getColumnCount();

                while (resultado.next())//Recorremos la tabla
                {
                    for (int j = 1; j <= numColumnas; j++) {
                        CodMaximo = resultado.getString(j);//Obtenermos el codigo maximo
                    }
                    contador++;//Acumulamos
                }
            }
        } catch (SQLException e) {
            //Excepcion en caso la tabla este vacia
            System.out.println("Tabla vacía/");
        }
        if (contador == 0)//Si no hay registros
        {
            codgen = "1";
        } else//Si hay mas de un registro
        {
            int mayor = Integer.parseInt(CodMaximo.substring(0));
            codgen = String.valueOf(mayor);//No aumentamos nada
        }
        return codgen;//Retornamos el valor
    }

    public static String getDecimales(String sql)//Metodo para traer datos decimales
    {
        String codgen;
        String CodMaximo = "";
        int contador = 0;
        try {
            try ( Connection conexion = (Connection) conectar.getConexion() //Nos conectamos
                    ) {
                Statement sentencia = (Statement) conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql);
                ResultSetMetaData rmeta = (ResultSetMetaData) resultado.getMetaData();
                int numColumnas = rmeta.getColumnCount();

                while (resultado.next())//Recorremos la tabla
                {
                    for (int j = 1; j <= numColumnas; j++) {
                        CodMaximo = resultado.getString(j);//Obtenermos el codigo maximo
                    }
                    contador++;//Acumulamos
                }
            }
        } catch (SQLException e) {
            //Excepcion en caso la tabla este vacia
            System.out.println(0.0);
        }
        if (contador == 0)//Si no hay registros
        {
            codgen = "1";
        } else//Si hay mas de un registro
        {
            int mayor = Integer.parseInt(CodMaximo.substring(0));
            codgen = String.valueOf(mayor);//No aumentamos nada
        }
        return codgen;//Retornamos el valor
    }

    /*public static String getFecha(String sql)//Metodo para traer fechas
    {
        String codgen = "";
        String CodMaximo = "";
        int contador = 0;
        try {
            try ( Connection conexion = (Connection) conectar.getConexion() //Nos conectamos
                    ) {
                Statement sentencia = (Statement) conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql);
                ResultSetMetaData rmeta = (ResultSetMetaData) resultado.getMetaData();
                int numColumnas = rmeta.getColumnCount();

                while (resultado.next())//Recorremos la tabla
                {
                    for (int j = 1; j <= numColumnas; j++) {
                        CodMaximo = resultado.getString(j);//Obtenermos el codigo maximo
                    }
                    contador++;//Acumulamos
                }
            }
        } catch (SQLException e) {
            //Excepcion en caso la tabla este vacia
            System.out.println("Tabla vacía-");
        }
        if (contador == 0)//Si no hay registros
        {
            codgen = "1";
        } else//Si hay mas de un registro
        {
            String mayor = String.valueOf(CodMaximo.substring(0));
            codgen = String.valueOf(mayor);//No aumentamos nada
        }
        return codgen;//Retornamos el valor
    }*/
    public static String getFecha(String sql) {
        String codgen = null;
        try {
            URL url = new URL(urlServer() + "getFecha.php");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("consulta", sql);

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
                StringBuilder getFecha = new StringBuilder();
                Scanner scan = new Scanner(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while (scan.hasNext()) {
                    getFecha.append(scan.nextLine());
                }
                scan.close();

                System.out.println(getFecha);
                JSONArray jsonGetFecha = new JSONArray(getFecha.toString());
                for (int i = 0; i < jsonGetFecha.length(); i++) {
                    JSONObject objectGetFecha = jsonGetFecha.getJSONObject(i);
                    codgen = objectGetFecha.getString("ca_fechainicio");
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return codgen;
    }
}
