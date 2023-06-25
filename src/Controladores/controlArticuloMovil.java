package Controladores;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import static Componentes.URL.urlServer;
import Datos.GestionarArticulosMovil;
import IU.dlgArticulosMovil;
import IU.dlgGestArticulosMovil;
import IU.dlgGestArticulosMovil1;
import IU.dlgNCCliente;
import Modelo.ArticuloMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public class controlArticuloMovil {

    public static ResultSet rs;
    public static Statement sentencia;
    public static Connection con;
    static int codClasificacion;
    static int codUM;
    static int codImpuesto;

    static ConexionBD conectar = ConexionBD.getInstancia();

    public static void prepararBD() {
        {
            try {
                con = (Connection) conectar.getConexion();
                if (con == null) {
                    System.out.println("No hay Conexion con la Base de Datos");
                } else {
                    sentencia = (Statement) con.createStatement();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void aModifcar() {
        try {
            int x = dlgArticulosMovil.tbProductos.getSelectedRow();
            String cod = dlgArticulosMovil.tbProductos.getValueAt(x, 0).toString();
            System.out.println("articulo a mod: " + cod);
            ArticuloMovil ar = GestionarArticulosMovil.busArticulo(cod);
            dlgGestArticulosMovil.txtCodProducto.setText(String.valueOf(ar.getIdproducto()));
            dlgGestArticulosMovil.txtCodInterno.setText((ar.getCodinterno()));
            dlgGestArticulosMovil.txtCodBarra.setText((ar.getCodBarra()));
            dlgGestArticulosMovil.txtDescripcion.setText(ar.getDescripcion());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgGestArticulosMovil.txtPrecioCostoL.setText(String.valueOf(ar.getPrecio_costo()));
            dlgGestArticulosMovil.txtCosto.setText(df.format(Integer.valueOf(dlgGestArticulosMovil.txtPrecioCostoL.getText().trim().replace(".", "").replace(",", ""))));
            dlgGestArticulosMovil.txtGananciaMayorista.setText(String.valueOf(df.format(ar.getGanancia())));
            dlgGestArticulosMovil.txtPrecioVentaL.setText(String.valueOf(ar.getPrecio_venta()));
            dlgGestArticulosMovil.txtPorcMay.setText(String.valueOf(ar.getPorG()));
            dlgGestArticulosMovil.txtPrecioVentaMayorista.setText(df.format(Integer.valueOf(dlgGestArticulosMovil.txtPrecioVentaL.getText().trim().replace(".", "").replace(",", ""))));
            dlgGestArticulosMovil.txtStock.setText(String.valueOf(ar.getStock()).trim().replace(".0", "").replace(",", ""));
            dlgGestArticulosMovil.txtCodClasificacion.setText(String.valueOf(ar.getDivision()));
            dlgGestArticulosMovil.txtCodImpuesto.setText(String.valueOf(ar.getIva()));
            dlgGestArticulosMovil.txtCodUM.setText(String.valueOf(ar.getUm()));
            if (ar.getVentam().equals("SI")) {
                dlgGestArticulosMovil.ckHabilitar.setSelected(true);
                dlgGestArticulosMovil.txtCantM.setEnabled(true);
            } else {
                dlgGestArticulosMovil.ckHabilitar.setSelected(false);
                dlgGestArticulosMovil.txtCantM.setEnabled(false);
            }
            dlgGestArticulosMovil.txtCantM.setText(String.valueOf(ar.getCantm()).trim().replace(".0", "").replace(",", ""));
            dlgGestArticulosMovil.txtGananciaMinorista.setText(String.valueOf(df.format(ar.getGananciaminorista())));
            dlgGestArticulosMovil.txtPorcMin.setText(String.valueOf(ar.getPorGMinorista()));
            dlgGestArticulosMovil.txtPrecioVentaMinorista.setText(String.valueOf(df.format(ar.getPreciominorista())));
            dlgGestArticulosMovil.txtGananciaSuper.setText(String.valueOf(df.format(ar.getGananciasupermercado())));
            dlgGestArticulosMovil.txtPorcSuper.setText(String.valueOf(ar.getPorGSupermercado()));
            dlgGestArticulosMovil.txtPrecioVentaSuper.setText(String.valueOf(df.format(ar.getPreciosupermercado())));

        } catch (NumberFormatException ee) {
            System.out.println("Error: " + ee.getMessage());
        }

    }

    public static ArticuloMovil capturarCampos() {
        ArticuloMovil art;
        int codA = Integer.parseInt(dlgGestArticulosMovil.txtCodProducto.getText());
        String codInt = (dlgGestArticulosMovil.txtCodInterno.getText().trim().toUpperCase());
        String codBar = (dlgGestArticulosMovil.txtCodBarra.getText().trim().toUpperCase());
        String descripcion = dlgGestArticulosMovil.txtDescripcion.getText().toUpperCase();
        try {
            String clas;
            if (dlgGestArticulosMovil.cboClasificacion.getSelectedItem().toString().contains(" ")) {
                clas = dlgGestArticulosMovil.cboClasificacion.getSelectedItem().toString().replace(" ", "%20");
            } else {
                clas = dlgGestArticulosMovil.cboClasificacion.getSelectedItem().toString();
            }
            URL url = new URL(urlServer() + "getIdClasificacion.php?descripcion=" + clas);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder clasificacion = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    clasificacion.append(scan.nextLine());
                }
                scan.close();
                JSONObject jsonC = new JSONObject(clasificacion.toString());
                for (int f = 0; f < jsonC.length(); f++) {
                    codClasificacion = Integer.parseInt(jsonC.getJSONObject("" + f + "").get("iddivision").toString());
                }
            }
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            String um;
            if (dlgGestArticulosMovil.cboUM.getSelectedItem().toString().contains(" ")) {
                um = dlgGestArticulosMovil.cboUM.getSelectedItem().toString().replace(" ", "%20");
            } else {
                um = dlgGestArticulosMovil.cboUM.getSelectedItem().toString();
            }
            URL url = new URL(urlServer() + "getIdUM.php?unidadmedida=" + um);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder UM = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    UM.append(scan.nextLine());
                }
                scan.close();
                JSONObject jsonC = new JSONObject(UM.toString());
                for (int f = 0; f < jsonC.length(); f++) {
                    codUM = Integer.parseInt(jsonC.getJSONObject("" + f + "").get("idunidad").toString());
                }
            }
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            String imp;
            if (dlgGestArticulosMovil.cboImpuesto.getSelectedItem().toString().contains(" ")) {
                imp = dlgGestArticulosMovil.cboImpuesto.getSelectedItem().toString().replace(" ", "%20");
            } else {
                imp = dlgGestArticulosMovil.cboImpuesto.getSelectedItem().toString();
            }
            URL url = new URL(urlServer() + "getIdImpuesto.php?descripcion=" + imp);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder IMP = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    IMP.append(scan.nextLine());
                }
                scan.close();
                JSONObject jsonC = new JSONObject(IMP.toString());
                for (int f = 0; f < jsonC.length(); f++) {
                    codImpuesto = Integer.parseInt(jsonC.getJSONObject("" + f + "").get("idiva").toString());
                }
            }
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }

        int Pcosto = Integer.valueOf(dlgGestArticulosMovil.txtCosto.getText().trim().replace(".", "").replace(",", ""));
        //
        int Ganancia = Integer.valueOf(dlgGestArticulosMovil.txtGananciaMayorista.getText().trim().replace(".", "").replace(",", ""));
        double porG = Double.parseDouble(dlgGestArticulosMovil.txtPorcMay.getText());
        int Pventa = Integer.valueOf(dlgGestArticulosMovil.txtPrecioVentaMayorista.getText().trim().replace(".", "").replace(",", ""));
        //
        double stock = Double.parseDouble(dlgGestArticulosMovil.txtStock.getText().trim());
        String ventam;
        if (dlgGestArticulosMovil.ckHabilitar.isSelected()) {
            ventam = "SI";
        } else {
            ventam = "NO";
        }
        //
        double cantM = Double.parseDouble(dlgGestArticulosMovil.txtCantM.getText().trim().replace(".", "").replace(",", ""));
        int GananciaM = Integer.parseInt(dlgGestArticulosMovil.txtGananciaMinorista.getText().trim().replace(".", "").replace(",", ""));
        double porGMin = Double.parseDouble(dlgGestArticulosMovil.txtPorcMin.getText());
        int PventaM = Integer.parseInt(dlgGestArticulosMovil.txtPrecioVentaMinorista.getText().trim().replace(".", "").replace(",", ""));
        //
        int GananciaS = Integer.parseInt(dlgGestArticulosMovil.txtGananciaSuper.getText().trim().replace(".", "").replace(",", ""));
        double porGS = Double.parseDouble(dlgGestArticulosMovil.txtPorcSuper.getText());
        int PventaS = Integer.parseInt(dlgGestArticulosMovil.txtPrecioVentaSuper.getText().trim().replace(".", "").replace(",", ""));
        //

        art = new ArticuloMovil(codA, codInt, codBar, descripcion, Pcosto, Ganancia, porG, Pventa, stock, codUM, codClasificacion, codImpuesto, ventam, cantM, PventaM, GananciaM, porGMin, PventaS, GananciaS, porGS);
        return art;
    }

    public static ArticuloMovil capturarCampos1() {
        ArticuloMovil art = null;
        int codA = Integer.parseInt(dlgGestArticulosMovil1.txtCodProducto.getText());
        String codInt;
        if (dlgGestArticulosMovil1.txtCodInterno.getText().trim().isEmpty()) {
            codInt = (dlgGestArticulosMovil1.txtCodProducto.getText());
        } else {
            codInt = (dlgGestArticulosMovil1.txtCodInterno.getText().trim().toUpperCase());
        }
        String codBar;
        if (dlgGestArticulosMovil1.txtCodBarra.getText().trim().isEmpty()) {
            codBar = "SIN CODIGO";
        } else {
            codBar = (dlgGestArticulosMovil1.txtCodBarra.getText().trim().toUpperCase());
        }

        String descripcion = dlgGestArticulosMovil1.txtDescripcion.getText().toUpperCase();

        try {
            prepararBD();
            String clas;
            clas = dlgGestArticulosMovil1.cboClasificacion.getSelectedItem().toString();
            try {
                rs = sentencia.executeQuery("SELECT * FROM division WHERE descripcion='" + clas + "'");
                rs.last();
                codClasificacion = rs.getInt("iddivision");
                rs.close();
            } catch (SQLException ex) {
                Mensajes.error("Error al querer obtener valor de la clasificación: " + ex.getMessage());
            }
        } catch (Exception pr) {
        }
        try {
            prepararBD();
            String um;
            um = dlgGestArticulosMovil1.cboUM.getSelectedItem().toString();
            try {
                rs = sentencia.executeQuery("SELECT * FROM unidad_medida WHERE unidadmedida='" + um + "'");
                rs.last();
                codUM = rs.getInt("idunidad");
                rs.close();
            } catch (SQLException ex) {
                Mensajes.error("Error al querer obtener valor de la Unidad de medida: " + ex.getMessage());
            }
        } catch (Exception pr) {
        }
        try {
            prepararBD();
            String iva;
            iva = dlgGestArticulosMovil1.cboImpuesto.getSelectedItem().toString();
            try {
                rs = sentencia.executeQuery("SELECT * FROM iva WHERE descripcion='" + iva + "'");
                rs.last();
                codImpuesto = rs.getInt("idiva");
                rs.close();
            } catch (SQLException ex) {
                Mensajes.error("Error al querer obtener valor del impuesto: " + ex.getMessage());
            }
        } catch (Exception pr) {
        }

        int Pcosto = Integer.valueOf(dlgGestArticulosMovil1.txtPrecioCostoL.getText().trim());
        int Ganancia = Integer.valueOf(dlgGestArticulosMovil1.txtGanancia.getText().trim().replace(".", "").replace(",", ""));
        int Pventa = Integer.valueOf(dlgGestArticulosMovil1.txtPrecioVentaL.getText().trim());
        double stock = Double.parseDouble(dlgGestArticulosMovil1.txtStock.getText().trim());
        String ventam;
        if (dlgGestArticulosMovil1.ckHabilitar.isSelected()) {
            ventam = "SI";
        } else {
            ventam = "NO";
        }
        double cantM = Double.parseDouble(dlgGestArticulosMovil1.txtCantM.getText().trim().replace(".", "").replace(",", ""));
        int GananciaM = Integer.parseInt(dlgGestArticulosMovil1.txtGananciaMinorista.getText().trim().replace(".", "").replace(",", ""));
        int PventaM = Integer.parseInt(dlgGestArticulosMovil1.txtPrecioVentaMinorista.getText().trim().replace(".", "").replace(",", ""));

        //art = new ArticuloMovil(codA, codInt, codBar, descripcion, Pcosto, Ganancia, Pventa, stock, codUM, codClasificacion, codImpuesto, ventam, cantM, PventaM,GananciaM);
        return art;
    }

    public static String addArticulo() {
        String msg;
        ArticuloMovil art = capturarCampos();
        msg = GestionarArticulosMovil.addArticulo(art);
        if (msg.equals("OK")) {
            Mensajes.informacion("Artículo Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String addArticulo1() {
        String msg;
        ArticuloMovil art = capturarCampos1();
        msg = GestionarArticulosMovil.addArticulo(art);
        if (msg == null) {
            Mensajes.informacion("Artículo Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actArticulo() {
        String msg;
        ArticuloMovil art = capturarCampos();
        msg = GestionarArticulosMovil.actArticulo(art);
        if (msg.equals("OK")) {
            Mensajes.informacion("Artículo Modifcado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static ArticuloMovil busArticulo(String cod) {
        ArticuloMovil art;
        art = GestionarArticulosMovil.busArticulo(cod);
        return art;
    }

    public static String delArticulo() {
        int x = dlgArticulosMovil.tbProductos.getSelectedRow();
        String msg;
        String cod = dlgArticulosMovil.tbProductos.getValueAt(x, 0).toString();
        msg = GestionarArticulosMovil.delArticulo(cod);
        if (msg.equals("OK")) {
            Mensajes.informacion("Artículo Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listArticuloenBusqueda(JTable tabla) {
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[4];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("stock").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            productos.excecute(urlServer() + "getlistProductos.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listArticulo(JTable tabla) {
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[11];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("division").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonProductos.getJSONObject("" + f + "").get("stock").toString();
                                fila[5] = jsonProductos.getJSONObject("" + f + "").get("costo").toString();
                                fila[6] = jsonProductos.getJSONObject("" + f + "").get("supermercado").toString();
                                fila[7] = jsonProductos.getJSONObject("" + f + "").get("minorista").toString();
                                fila[8] = jsonProductos.getJSONObject("" + f + "").get("ventam").toString();
                                fila[9] = jsonProductos.getJSONObject("" + f + "").get("cantm").toString();
                                fila[10] = jsonProductos.getJSONObject("" + f + "").get("mayorista").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            productos.excecute(urlServer() + "getv_productos2_2.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listArticuloconStock(JTable tabla) {
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[11];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("division").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonProductos.getJSONObject("" + f + "").get("stock").toString();
                                fila[5] = jsonProductos.getJSONObject("" + f + "").get("costo").toString();
                                fila[6] = jsonProductos.getJSONObject("" + f + "").get("supermercado").toString();
                                fila[7] = jsonProductos.getJSONObject("" + f + "").get("minorista").toString();
                                fila[8] = jsonProductos.getJSONObject("" + f + "").get("ventam").toString();
                                fila[9] = jsonProductos.getJSONObject("" + f + "").get("cantm").toString();
                                fila[10] = jsonProductos.getJSONObject("" + f + "").get("mayorista").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    } else {
                        System.out.println(status.getIdResponse());
                    }
                }
            });

            productos.excecute(urlServer() + "getv_productos2.php");
        } catch (JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*   public static void listArticuloActivo(JTable tabla, String cod) {
        List lista;
        lista = GestionarArticulos.listArticuloActivo(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }*/
    public static void filtrarGral(JTable tabla, String cod) {
        String Param;
        if (cod.contains(" ")) {
            Param = cod.replace(" ", "%20");
        } else {
            Param = cod;
        }
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[11];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("division").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonProductos.getJSONObject("" + f + "").get("stock").toString();
                                fila[5] = jsonProductos.getJSONObject("" + f + "").get("costo").toString();
                                fila[6] = jsonProductos.getJSONObject("" + f + "").get("supermercado").toString();
                                fila[7] = jsonProductos.getJSONObject("" + f + "").get("minorista").toString();
                                fila[8] = jsonProductos.getJSONObject("" + f + "").get("ventam").toString();
                                fila[9] = jsonProductos.getJSONObject("" + f + "").get("cantm").toString();
                                fila[10] = jsonProductos.getJSONObject("" + f + "").get("mayorista").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    } else {
                        System.out.println(status.getIdResponse());
                    }
                }
            });
            productos.excecute(urlServer() + "getfiltrarGral.php?param=" + Param);
        } catch (JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void filtrarGralenBusqueda(JTable tabla, String cod) {
        String C;
        if (cod.contains(" ")) {
            C = cod.replace(" ", "%20");
        } else {
            C = cod;
        }
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[4];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("stock").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            productos.excecute(urlServer() + "getfiltrarGralenBusqueda.php?filtro=" + C);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*public static void filtrarDescripcion(JTable tabla, String cod) {
        List lista = null;
        lista = GestionarArticulos.filtrarDescripcion(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }*/
 /*public static void filtrarDescripcionActivo(JTable tabla, String cod) {
        List lista = null;
        lista = GestionarArticulos.filtrarDescripcionActivo(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            //fila[0].toString();
            //fila[1].toString();
            tb.addRow(fila);
        }
    }*/

 /*    public static void filrarPrincipio(JTable tabla, String pr) {
        List lista = null;
        lista = GestionarArticulos.filtrarPrincipio(pr);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            //fila[0].toString();
            //fila[1].toString();
            tb.addRow(fila);
        }
    }*/
 /* public static void filrarPrincipioActivo(JTable tabla, String pr) {
        List lista = null;
        lista = GestionarArticulos.filtrarPrincipioActivo(pr);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            //fila[0].toString();
            //fila[1].toString();
            tb.addRow(fila);
        }
    }*/

 /*public static void filtrarCodBarra(JTable tabla, String rb) {
        List lista = null;
        lista = GestionarArticulos.filtrarCodBarra(rb);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            //fila[0].toString();
            //fila[1].toString();
            tb.addRow(fila);
        }
    }*/
    public static void filtrarCodBarraActivo(JTable tabla, String rb) {
        String Param;
        if (rb.contains(" ")) {
            Param = rb.replace(" ", "%20");
        } else {
            Param = rb;
        }
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[5];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("cod_interno").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonProductos.getJSONObject("" + f + "").get("precio_costo").toString();
                                tb.addRow(fila);
                            }
                        } catch (JSONException e) {
                        }
                    } else {
                        System.out.println(status.getIdResponse());
                    }
                }
            });
            productos.excecute(urlServer() + "getfiltrarCodBarraActivo.php?filtro=" + Param);
        } catch (JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void filtrarCodBarraActivo2(JTable tabla, String rb) {
        String Param;
        if (rb.contains(" ")) {
            Param = rb.replace(" ", "%20");
        } else {
            Param = rb;
        }
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[5];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                if(dlgNCCliente.txtSupermercado.getText().equals("S")){
                                    fila[4] = jsonProductos.getJSONObject("" + f + "").get("supermercado").toString();
                                }else{
                                    fila[4] = jsonProductos.getJSONObject("" + f + "").get("minorista").toString();
                                }
                                tb.addRow(fila);
                            }
                        } catch (JSONException e) {
                        }
                    } else {
                        System.out.println(status.getIdResponse());
                    }
                }
            });
            productos.excecute(urlServer() + "getfiltrarCodBarraActivo2.php?filtro=" + Param);
        } catch (JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void filtrarCodBarraActivoCStock(JTable tabla, String rb) {
        String Param;
        if (rb.contains(" ")) {
            Param = rb.replace(" ", "%20");
        } else {
            Param = rb;
        }
        try {
            HttpClient productos = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonProductos = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                                Object[] fila = new Object[6];
                                fila[0] = jsonProductos.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonProductos.getJSONObject("" + f + "").get("cod_interno").toString();
                                fila[2] = jsonProductos.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonProductos.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonProductos.getJSONObject("" + f + "").get("stock").toString();
                                fila[5] = jsonProductos.getJSONObject("" + f + "").get("precio_costo").toString();
                                tb.addRow(fila);
                            }
                        } catch (JSONException e) {
                        }
                    } else {
                        System.out.println(status.getIdResponse());
                    }
                }
            });
            productos.excecute(urlServer() + "getfiltrarCodBarraActivoCStock.php?filtro=" + Param);
        } catch (JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void filtrarArticulosMovActivoAuxReparto(JTable tabla, String rb) {
        List lista = null;
        lista = GestionarArticulosMovil.filtrarArticulosActivoAuxiliarReparto(rb);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            //fila[0].toString();
            //fila[1].toString();
            tb.addRow(fila);
        }
    }
}
