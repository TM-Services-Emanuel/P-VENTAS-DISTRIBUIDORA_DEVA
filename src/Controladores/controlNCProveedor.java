package Controladores;

import Componentes.Mensajes;
import Componentes.Redondeo;
import IU.dlgBuscarFacturaProveedor;
import IU.dlgNCProveedor;
import Modelo.ArticuloMovil;
import Modelo.DetalleNCProveedor;
import Datos.ArregloNCProveedor;
import com.devazt.networking.HttpClient;
import com.devazt.networking.Response;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;
import Componentes.Fecha;
import Datos.GestionarArticulosMovil;
import IU.dlgBuscarArticuloNCProveedor;
import IU.dlgConsultarNCProveedor;
import com.devazt.networking.OnHttpRequestComplete;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import Componentes.Login;
import static Componentes.URL.urlServer;
import Datos.GestionarNCProveedor;
import IU.dlgBuscarArticuloNCCliente;
import IU.dlgBuscarFacturaCliente;
import IU.dlgConsultarNCCliente;
import IU.dlgConsultarPagosVentas;
import IU.dlgNCCliente;
import static IU.dlgNCCliente.tbTablaControl;
import IU.dlgRegistrarPagosCompras;
import IU.dlgRegistrarPagosFacturas;

public class controlNCProveedor {

    static ArticuloMovil art;
    static DetalleNCProveedor dc;
    public static ArregloNCProveedor array = new ArregloNCProveedor();
    static String UsuarioL = "";

    public static void selectFactura() {
        int x = dlgBuscarFacturaProveedor.tbDetalle.getSelectedRow();
        String cod = dlgBuscarFacturaProveedor.tbDetalle.getValueAt(x, 0).toString();
        String fact = dlgBuscarFacturaProveedor.tbDetalle.getValueAt(x, 5).toString();
        String proveedor = dlgBuscarFacturaProveedor.tbDetalle.getValueAt(x, 2).toString();
        String TF = dlgBuscarFacturaProveedor.tbDetalle.getValueAt(x, 6).toString();
        DecimalFormat df = new DecimalFormat("#,###");
        dlgNCProveedor.txtcodCompra.setText(cod);
        dlgNCProveedor.txtRazonS.setText(proveedor);
        dlgNCProveedor.txtFactura.setText(fact);
        dlgNCProveedor.txtTF.setText(df.format(Integer.parseInt(TF.trim().replace(".", "").replace(",", ""))));
        int coinc = getCoincidenciaFactura("SELECT IFNULL ((select count(nc_proveedor.idcompra) FROM nc_proveedor WHERE nc_proveedor.idcompra=" + cod + " AND nc_proveedor.estado='S'),0) AS idcompra");
        if (coinc == 0) {
            dlgNCProveedor.lbCoincidencia.setText(" No existe Nota de Crédito anexada a esta factura.");
            dlgNCProveedor.lbCoincidencia.setForeground(new java.awt.Color(0, 102, 0));
        } else {
            dlgNCProveedor.lbCoincidencia.setText("Existe " + coinc + " Nota/s de Crédito anexada/s a esta factura.");
            dlgNCProveedor.lbCoincidencia.setForeground(new java.awt.Color(255, 0, 0));
        }
        dlgNCProveedor.txtNC.requestFocus();
    }

    public static void selectFacturaCliente() {
        int x = dlgBuscarFacturaCliente.tbDetalle.getSelectedRow();
        String cod = dlgBuscarFacturaCliente.tbDetalle.getValueAt(x, 0).toString();
        String fact = dlgBuscarFacturaCliente.tbDetalle.getValueAt(x, 5).toString();
        String proveedor = dlgBuscarFacturaCliente.tbDetalle.getValueAt(x, 2).toString();
        String TF = dlgBuscarFacturaCliente.tbDetalle.getValueAt(x, 6).toString();
        String SuPr = dlgBuscarFacturaCliente.tbDetalle.getValueAt(x, 7).toString();
        DecimalFormat df = new DecimalFormat("#,###");
        dlgNCCliente.txtcodFactura.setText(cod);
        dlgNCCliente.txtRazonS.setText(proveedor);
        dlgNCCliente.txtFactura.setText(fact);
        dlgNCCliente.txtTF.setText(df.format(Integer.parseInt(TF.trim().replace(".", "").replace(",", ""))));
        int coinc = getCoincidenciaFactura2("SELECT IFNULL ((select count(nc_cliente.idfactura) FROM nc_cliente WHERE nc_cliente.idfactura=" + cod + " AND nc_cliente.estado='S'),0) AS idfactura");
        if (coinc == 0) {
            dlgNCCliente.lbCoincidencia.setText(" No existe Nota de Crédito anexada a esta factura.");
            dlgNCCliente.lbCoincidencia.setForeground(new java.awt.Color(0, 102, 0));
        } else {
            dlgNCCliente.lbCoincidencia.setText("Existe " + coinc + " Nota/s de Crédito anexada/s a esta factura.");
            dlgNCCliente.lbCoincidencia.setForeground(new java.awt.Color(255, 0, 0));
        }
        dlgNCCliente.txtSupermercado.setText(SuPr);
        CabecerasTablas.limpiarTablaControlNCCliente(dlgNCCliente.tbTablaControl);
        listTablaControl(Integer.parseInt(cod), dlgNCCliente.tbTablaControl);
    }

    public static void listTablaControl(int id, JTable tabla) {
        try {
            HttpClient facturas = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                        /*try {
                            int c = tb.getRowCount();
                            for (int x = 0; x < c; x++) {
                                tb.removeRow(x);
                            }
                        } catch (Exception e) {
                        }*/
                        JSONObject jsonFacturas = new JSONObject(status.getResult());
                        for (int f = 0; f < jsonFacturas.length(); f++) {
                            Object[] fila = new Object[3];
                            fila[0] = jsonFacturas.getJSONObject("" + f + "").get("articulo_art_codigo").toString();
                            fila[1] = jsonFacturas.getJSONObject("" + f + "").get("ven_cantidad").toString();
                            fila[2] = jsonFacturas.getJSONObject("" + f + "").get("ven_precio").toString();
                            tb.addRow(fila);
                        }

                    } catch (JSONException e) {
                    }
                }
            });

            facturas.excecute(urlServer() + "getlistDetalleFactura.php?cod=" + id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int getCoincidenciaFactura(String consulta)//Traemos el id mayor de las tablas
    {
        int cod = 0;
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
                StringBuilder Coincidencia = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Coincidencia.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodCoincidencia = new JSONArray(Coincidencia.toString());
                if (jsonCodCoincidencia.length() != 0) {
                    JSONObject objectCodCoincidencia = jsonCodCoincidencia.getJSONObject(0);
                    cod = Integer.parseInt(objectCodCoincidencia.getString("idcompra"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cod;//Retornamos el valor
    }

    public static int getCoincidenciaFactura2(String consulta)//Traemos el id mayor de las tablas
    {
        int cod = 0;
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
                StringBuilder Coincidencia = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    Coincidencia.append(scan.nextLine());
                }
                scan.close();
                JSONArray jsonCodCoincidencia = new JSONArray(Coincidencia.toString());
                if (jsonCodCoincidencia.length() != 0) {
                    JSONObject objectCodCoincidencia = jsonCodCoincidencia.getJSONObject(0);
                    cod = Integer.parseInt(objectCodCoincidencia.getString("idfactura"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cod;//Retornamos el valor
    }

    public static void selectArticulo() {
        int x = dlgBuscarArticuloNCProveedor.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloNCProveedor.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulosMovil.busArticulo(cod);
        dlgNCProveedor.txtCodA.setText(String.valueOf(art.getIdproducto()));
        dlgNCProveedor.txtArt.setText(art.getDescripcion());
        //dlgCompras1.txtCant.setText("1");
        String PC = String.valueOf(art.getPrecio_costo());
        DecimalFormat df = new DecimalFormat("#,###");
        dlgNCProveedor.txtCosto.setText((df.format(Integer.parseInt(PC.trim().replace(".", "").replace(",", "")))));
        dlgNCProveedor.txtCostoL.setText(PC);

    }

    public static int selectArticulo2() {
        int cerrar = 1;
        int x = dlgBuscarArticuloNCCliente.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgBuscarArticuloNCCliente.tbDetalle.getValueAt(x, 0).toString());
        String descripcion = dlgBuscarArticuloNCCliente.tbDetalle.getValueAt(x, 3).toString();
        int precio = Integer.parseInt(dlgBuscarArticuloNCCliente.tbDetalle.getValueAt(x, 4).toString());
        art = GestionarArticulosMovil.busArticulo(String.valueOf(cod));
        if (dlgNCCliente.ckControl.isSelected()) {
            int band = 0;
            int filas = tbTablaControl.getRowCount();
            for (int f = 0; f < filas; f++) {
                int id = Integer.parseInt(tbTablaControl.getValueAt(f, 0).toString());
                if (id == cod) {
                    band = 1;
                    int precioTC = Integer.parseInt(tbTablaControl.getValueAt(f, 2).toString());
                    double cantTC = Double.parseDouble(tbTablaControl.getValueAt(f, 1).toString());

                    dlgNCCliente.txtCodA.setText(String.valueOf(cod));
                    dlgNCCliente.txtArt.setText(descripcion);
                    dlgNCCliente.txtCantComprada.setText(String.valueOf(cantTC));
                    String PC = String.valueOf(precioTC);
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgNCCliente.txtVenta.setText((df.format(Integer.parseInt(PC.trim().replace(".", "").replace(",", "")))));
                    dlgNCCliente.txtVentaL.setText(PC);

                    dlgNCCliente.habilitarCANTCOSTO();
                    dlgNCCliente.txtCant.requestFocus();
                    dlgNCCliente.txtCant.selectAll();
                    cerrar = 0;
                }
            }
            if (band == 0) {
                Mensajes.error("CARGA BLOQUEADA:\n Motivo: El producto que desea cargar a la Nota de Crédito no coincide con ningún ítem de la Factura anexada.");
                cerrar = 1;
            }
        } else {
            dlgNCCliente.txtCodA.setText(String.valueOf(cod));
            dlgNCCliente.txtArt.setText(descripcion);
            //dlgCompras1.txtCant.setText("1");
            String PC = String.valueOf(precio);
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCCliente.txtVenta.setText((df.format(Integer.parseInt(PC.trim().replace(".", "").replace(",", "")))));
            dlgNCCliente.txtVentaL.setText(PC);

            dlgNCCliente.habilitarCANTCOSTO();
            dlgNCCliente.txtCant.requestFocus();
            dlgNCCliente.txtCant.selectAll();
            cerrar = 0;
        }

        return cerrar;
    }

    public static void listFacturas(String text, JTable tabla) {
        String filtro;
        if (text.contains(" ")) {
            filtro = text.replace(" ", "%20");
        } else {
            filtro = text;
        }
        try {
            HttpClient facturas = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                        JSONObject jsonFacturas = new JSONObject(status.getResult());
                        for (int f = 0; f < jsonFacturas.length(); f++) {
                            Object[] fila = new Object[7];
                            fila[0] = jsonFacturas.getJSONObject("" + f + "").get("id").toString();
                            fila[1] = jsonFacturas.getJSONObject("" + f + "").get("idcaja").toString();
                            fila[2] = jsonFacturas.getJSONObject("" + f + "").get("ruc").toString() + " - " + jsonFacturas.getJSONObject("" + f + "").get("rs").toString();
                            fila[3] = jsonFacturas.getJSONObject("" + f + "").get("condicion").toString();
                            fila[4] = Fecha.formatoFechaDd(jsonFacturas.getJSONObject("" + f + "").get("fecha").toString());
                            fila[5] = jsonFacturas.getJSONObject("" + f + "").get("fact").toString();
                            fila[6] = jsonFacturas.getJSONObject("" + f + "").get("total").toString();
                            tb.addRow(fila);
                        }

                    } catch (JSONException e) {
                    }
                }
            });

            facturas.excecute(urlServer() + "getlistFactCompras.php?filtro=" + filtro);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listFacturasClientes(String text, JTable tabla) {
        String filtro;
        if (text.contains(" ")) {
            filtro = text.replace(" ", "%20");
        } else {
            filtro = text;
        }
        try {
            HttpClient facturas = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                        JSONObject jsonFacturas = new JSONObject(status.getResult());
                        for (int f = 0; f < jsonFacturas.length(); f++) {
                            Object[] fila = new Object[8];
                            fila[0] = jsonFacturas.getJSONObject("" + f + "").get("id").toString();
                            fila[1] = jsonFacturas.getJSONObject("" + f + "").get("idcaja").toString();
                            fila[2] = jsonFacturas.getJSONObject("" + f + "").get("ruc").toString() + " - " + jsonFacturas.getJSONObject("" + f + "").get("rs").toString();
                            fila[3] = jsonFacturas.getJSONObject("" + f + "").get("condicion").toString();
                            fila[4] = Fecha.formatoFechaDd(jsonFacturas.getJSONObject("" + f + "").get("fecha").toString());
                            fila[5] = jsonFacturas.getJSONObject("" + f + "").get("fact").toString();
                            fila[6] = jsonFacturas.getJSONObject("" + f + "").get("total").toString();
                            fila[7] = jsonFacturas.getJSONObject("" + f + "").get("superM").toString();
                            tb.addRow(fila);
                        }

                    } catch (JSONException e) {
                    }
                }
            });

            facturas.excecute(urlServer() + "getlistFactFacturas.php?filtro=" + filtro);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listDetalleNC(int cod, JTable tabla) {
        try {
            HttpClient nc = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                        JSONObject jsonNC = new JSONObject(status.getResult());
                        for (int f = 0; f < jsonNC.length(); f++) {
                            Object[] fila = new Object[1];
                            fila[0] = jsonNC.getJSONObject("" + f + "").get("idnota").toString();
                            tb.addRow(fila);
                        }

                    } catch (JSONException e) {
                    }
                }
            });

            nc.excecute(urlServer() + "getlistDetalleNCenPago.php?filtro=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int getExcetas() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCProveedor.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCProveedor.tbDetalle.getModel().getValueAt(i, 6)));
        }
        return (total);
    }

    public static int getExcetas_2() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCCliente.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCCliente.tbDetalle.getModel().getValueAt(i, 6)));
        }
        return (total);
    }

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCProveedor.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCProveedor.tbDetalle.getModel().getValueAt(i, 7)));
        }
        return Redondeo.redondearI(total / 21);
    }

    public static int get5_2() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCCliente.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCCliente.tbDetalle.getModel().getValueAt(i, 7)));
        }
        return Redondeo.redondearI(total / 21);
    }

    public static int get10() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCProveedor.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCProveedor.tbDetalle.getModel().getValueAt(i, 8)));
        }
        return Redondeo.redondearI(total / 11);
    }

    public static int get10_2() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCCliente.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCCliente.tbDetalle.getModel().getValueAt(i, 8)));
        }
        return Redondeo.redondearI(total / 11);
    }

    public static int getTotal() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCProveedor.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCProveedor.tbDetalle.getModel().getValueAt(i, 9)));
        }
        return (total);
    }

    public static int getTotal_2() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgNCCliente.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgNCCliente.tbDetalle.getModel().getValueAt(i, 9)));
        }
        return (total);
    }

    public static int getTotalTF() {
        int total = 0;
        if (dlgRegistrarPagosCompras.Seleccionados(11)) {
            for (int i = 0; i < dlgRegistrarPagosCompras.tbCompraCredito.getRowCount(); i++) {
                boolean sel = (boolean) dlgRegistrarPagosCompras.tbCompraCredito.getValueAt(i, 11);
                if (sel) {
                    total += Integer.valueOf(String.valueOf(dlgRegistrarPagosCompras.tbCompraCredito.getModel().getValueAt(i, 8)));
                }
            }
        }
        return (total);
    }

    public static int getTotalTFCr() {
        int total = 0;
        if (dlgRegistrarPagosFacturas.Seleccionados(11)) {
            for (int i = 0; i < dlgRegistrarPagosFacturas.tbFacturasCredito.getRowCount(); i++) {
                boolean sel = (boolean) dlgRegistrarPagosFacturas.tbFacturasCredito.getValueAt(i, 11);
                if (sel) {
                    total += Integer.valueOf(String.valueOf(dlgRegistrarPagosFacturas.tbFacturasCredito.getModel().getValueAt(i, 8)));
                }
            }
        }
        return (total);
    }

    public static int getTotalTNC() {
        int total = 0;
        if (dlgRegistrarPagosCompras.Seleccionados(11)) {
            for (int i = 0; i < dlgRegistrarPagosCompras.tbCompraCredito.getRowCount(); i++) {
                boolean sel = (boolean) dlgRegistrarPagosCompras.tbCompraCredito.getValueAt(i, 11);
                if (sel) {
                    total += Integer.valueOf(String.valueOf(dlgRegistrarPagosCompras.tbCompraCredito.getModel().getValueAt(i, 9)));
                }
            }
        }
        return (total);
    }

    public static int getTotalTNCr() {
        int total = 0;
        if (dlgRegistrarPagosFacturas.Seleccionados(11)) {
            for (int i = 0; i < dlgRegistrarPagosFacturas.tbFacturasCredito.getRowCount(); i++) {
                boolean sel = (boolean) dlgRegistrarPagosFacturas.tbFacturasCredito.getValueAt(i, 11);
                if (sel) {
                    total += Integer.valueOf(String.valueOf(dlgRegistrarPagosFacturas.tbFacturasCredito.getModel().getValueAt(i, 9)));
                }
            }
        }
        return (total);
    }

    public static void cargarDetalleNC() {
        if (dlgRegistrarPagosFacturas.Seleccionados(11)) {
            for (int i = 0; i < dlgRegistrarPagosFacturas.tbFacturasCredito.getRowCount(); i++) {
                boolean sel = (boolean) dlgRegistrarPagosFacturas.tbFacturasCredito.getValueAt(i, 11);
                if (sel) {
                    int cod = Integer.parseInt(String.valueOf(dlgRegistrarPagosFacturas.tbFacturasCredito.getModel().getValueAt(i, 0)));
                    listDetalleNC(cod, dlgRegistrarPagosFacturas.tbDetalleNC);
                }
            }
        }
    }

    public static void insertar(String cod, String codI, String desc, String cant, String prec, String total, int iva, JTable tabla) {

        String fila[] = new String[10];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codI;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = prec;
        fila[5] = String.valueOf(iva);
        switch (iva) {
            case 10 -> {
                fila[6] = "0";
                fila[7] = "0";
                fila[8] = total;
            }
            case 5 -> {
                fila[6] = "0";
                fila[7] = total;
                fila[8] = "0";
            }
            default -> {
                fila[6] = total;
                fila[7] = "0";
                fila[8] = "0";
            }
        }
        fila[9] = total;
        tb.addRow(fila);
    }

    public static void insertar2(String cod, String codI, String desc, String cant, String prec, String total, int iva, JTable tabla) {

        String fila[] = new String[11];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codI;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = prec;
        fila[5] = String.valueOf(iva);
        switch (iva) {
            case 10 -> {
                fila[6] = "0";
                fila[7] = "0";
                fila[8] = total;
            }
            case 5 -> {
                fila[6] = "0";
                fila[7] = total;
                fila[8] = "0";
            }
            default -> {
                fila[6] = total;
                fila[7] = "0";
                fila[8] = "0";
            }
        }
        fila[9] = total;
        fila[10] = String.valueOf(dlgNCCliente.tbDetalle.getRowCount() + 1);
        tb.addRow(fila);
    }

    public static void addTabla(JTable tabla) {
        try {
            int codA = art.getIdproducto();
            String codI = art.getCodBarra();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgNCProveedor.txtCant.getText());
            int costo = Integer.valueOf(dlgNCProveedor.txtCostoL.getText());
            int mont = (int) (cant * costo);
            int iva = 0;
            switch (art.getIva()) {
                case 1 ->
                    iva = 0;
                case 2 ->
                    iva = 5;
                case 3 ->
                    iva = 10;
                default -> {
                }
            }
            DetalleNCProveedor dco = new DetalleNCProveedor(codA);
            if (array.busca(dco.getIdproducto()) != -1) {
                int Nfila = array.busca(dco.getIdproducto());
                double cantTabla = Double.parseDouble(dlgNCProveedor.tbDetalle.getValueAt(Nfila, 3).toString());
                System.out.println("fila: " + Nfila + " ** cantidad en tabla: " + cantTabla + " ** cantidad a agregar: " + cant + " ** iva: " + iva);
                addmismoItem(Nfila, cantTabla, cant, costo, iva);

            } else {
                array.agregar(dco);
                insertar(String.valueOf(codA), codI, desc, String.valueOf(cant), String.valueOf(costo), String.valueOf(mont), iva, tabla);
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgNCProveedor.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgNCProveedor.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgNCProveedor.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgNCProveedor.txtTotalL.setText(total);
                dlgNCProveedor.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void addTabla2(JTable tabla, double cantV) {
        try {
            int codA = art.getIdproducto();
            String codI = art.getCodBarra();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgNCCliente.txtCant.getText());
            int costo = Integer.valueOf(dlgNCCliente.txtVentaL.getText());
            int mont = (int) (cant * costo);
            int iva = 0;
            switch (art.getIva()) {
                case 1 ->
                    iva = 0;
                case 2 ->
                    iva = 5;
                case 3 ->
                    iva = 10;
                default -> {
                }
            }
            DetalleNCProveedor dco = new DetalleNCProveedor(codA);
            if (array.busca(dco.getIdproducto()) != -1) {
                int Nfila = array.busca(dco.getIdproducto());
                double cantTabla = Double.parseDouble(dlgNCCliente.tbDetalle.getValueAt(Nfila, 3).toString());
                System.out.println("fila: " + Nfila + " ** cantidad en tabla: " + cantTabla + " ** cantidad a agregar: " + cant + " ** iva: " + iva);
                if ((cantTabla + cant) <= cantV) {
                    addmismoItem_2(Nfila, cantTabla, cant, costo, iva);
                } else {
                    DecimalFormat df = new DecimalFormat("#,###.##");
                    Mensajes.error("CARGA BLOQUEADA:\nMotivo: El producto que desea cargar a la Nota de Crédito supera la cantidad comprada en la Factura anexada.\n\nCantidad Facturado: " + df.format(cantV));
                    dlgNCCliente.txtCant.requestFocus();
                    dlgNCCliente.txtCant.selectAll();
                }

            } else {
                array.agregar(dco);
                insertar2(String.valueOf(codA), codI, desc, String.valueOf(cant), String.valueOf(costo), String.valueOf(mont), iva, tabla);
                String total = String.valueOf(getTotal_2());
                String exentas = String.valueOf(getExcetas_2());
                String iva5 = String.valueOf(get5_2());
                String iva10 = String.valueOf(get10_2());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgNCCliente.txtTotalL.setText(total);
                dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void addTabla3(JTable tabla) {
        try {
            int codA = art.getIdproducto();
            String codI = art.getCodBarra();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgNCCliente.txtCant.getText());
            int costo = Integer.valueOf(dlgNCCliente.txtVentaL.getText());
            int mont = (int) (cant * costo);
            int iva = 0;
            switch (art.getIva()) {
                case 1 ->
                    iva = 0;
                case 2 ->
                    iva = 5;
                case 3 ->
                    iva = 10;
                default -> {
                }
            }
            DetalleNCProveedor dco = new DetalleNCProveedor(codA);
            if (array.busca(dco.getIdproducto()) != -1) {
                int Nfila = array.busca(dco.getIdproducto());
                double cantTabla = Double.parseDouble(dlgNCCliente.tbDetalle.getValueAt(Nfila, 3).toString());
                System.out.println("fila: " + Nfila + " ** cantidad en tabla: " + cantTabla + " ** cantidad a agregar: " + cant + " ** iva: " + iva);
                addmismoItem_2(Nfila, cantTabla, cant, costo, iva);

            } else {
                array.agregar(dco);
                insertar2(String.valueOf(codA), codI, desc, String.valueOf(cant), String.valueOf(costo), String.valueOf(mont), iva, tabla);
                String total = String.valueOf(getTotal_2());
                String exentas = String.valueOf(getExcetas_2());
                String iva5 = String.valueOf(get5_2());
                String iva10 = String.valueOf(get10_2());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgNCCliente.txtTotalL.setText(total);
                dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void consLinea() {
        int fila = dlgNCProveedor.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgNCProveedor.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Artículo no existe");
        } else {
            dc = array.getFila(p);
            int codAr = dc.getIdproducto();
        }
    }

    public static void consLinea2() {
        int fila = dlgNCCliente.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgNCCliente.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Artículo no existe");
        } else {
            dc = array.getFila(p);
            int codAr = dc.getIdproducto();
        }
    }

    public static void delRenglon(JTable tabla) {
        consLinea();
        int fila = dlgNCProveedor.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgNCProveedor.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                DecimalFormat df = new DecimalFormat("#,###");
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                dlgNCProveedor.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgNCProveedor.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgNCProveedor.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgNCProveedor.txtTotalL.setText(total);
                dlgNCProveedor.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            }
        }
    }

    public static void delRenglon2(JTable tabla) {
        consLinea2();
        int fila = dlgNCCliente.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgNCCliente.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                DecimalFormat df = new DecimalFormat("#,###");
                String total = String.valueOf(getTotal_2());
                String exentas = String.valueOf(getExcetas_2());
                String iva5 = String.valueOf(get5_2());
                String iva10 = String.valueOf(get10_2());
                dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgNCCliente.txtTotalL.setText(total);
                dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            }
        }
    }

    public static void canCelar() {
        array.vaciar();
    }

    /*public static String anularCompra() {
        String msg;
        int x = dlgConsultarCompras.tbCompra.getSelectedRow();
        String cod = dlgConsultarCompras.tbCompra.getValueAt(x, 0).toString();
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarCompra.delCompra(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Compra Anulada");
            controlNCProveedor.actStockEliminarCompra();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/

 /* public static String actStockEliminarCompra() {
        String msg = null;
        int f = dlgConsultarCompras.tbDetalleCompra.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarCompras.tbDetalleCompra.getValueAt(i, 1).toString());
            int st = Integer.valueOf(dlgConsultarCompras.tbDetalleCompra.getValueAt(i, 4).toString());
            Articulo a = new Articulo(coda, st);
            msg = GestionarArticulos.actStockMENOS(a);
        }
        if (msg == null) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/
    public static void actCantidad(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            double ca = Double.parseDouble(tabla.getValueAt(fila, 3).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 4).toString());
            double cant = (Mensajes.ingresarNumerosC(ca));
            int monto = (int) (pre * cant);
            int iva = Integer.parseInt(tabla.getValueAt(fila, 5).toString());
            tabla.setValueAt(String.valueOf(cant), fila, 3);

            switch (iva) {
                case 10 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 8);
                }
                case 5 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 7);
                }
                default -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 6);
                }
            }
            tabla.setValueAt(String.valueOf(monto), fila, 9);

            //int Gan = CalcGanancia();
            //dlgCompras1.tbDetalle.setValueAt(String.valueOf(Gan), fila, 16);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCProveedor.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgNCProveedor.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgNCProveedor.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgNCProveedor.txtTotalL.setText(total);
            dlgNCProveedor.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void actCantidad2(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            int cod = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            double ca = Double.parseDouble(tabla.getValueAt(fila, 3).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 4).toString());
            double cant = (Mensajes.ingresarNumerosC(ca));
            int monto = (int) (pre * cant);
            int iva = Integer.parseInt(tabla.getValueAt(fila, 5).toString());
            double cantTC = 0;
            int filas = tbTablaControl.getRowCount();
            for (int f = 0; f < filas; f++) {
                int id = Integer.parseInt(tbTablaControl.getValueAt(f, 0).toString());
                if (id == cod) {
                    cantTC = Double.parseDouble(tbTablaControl.getValueAt(f, 1).toString());
                }
            }
            if (cant <= cantTC) {
                tabla.setValueAt(String.valueOf(cant), fila, 3);
                switch (iva) {
                    case 10 -> {
                        tabla.setValueAt(String.valueOf(monto), fila, 8);
                    }
                    case 5 -> {
                        tabla.setValueAt(String.valueOf(monto), fila, 7);
                    }
                    default -> {
                        tabla.setValueAt(String.valueOf(monto), fila, 6);
                    }
                }
                tabla.setValueAt(String.valueOf(monto), fila, 9);
                String total = String.valueOf(getTotal_2());
                String exentas = String.valueOf(getExcetas_2());
                String iva5 = String.valueOf(get5_2());
                String iva10 = String.valueOf(get10_2());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgNCCliente.txtTotalL.setText(total);
                dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            } else {
                DecimalFormat df = new DecimalFormat("#,###.##");
                Mensajes.error("CARGA BLOQUEADA:\nMotivo: El producto que desea cargar a la Nota de Crédito supera la cantidad comprada en la Factura anexada.\n\nCantidad Facturado: " + df.format(cantTC));
                dlgNCCliente.txtCant.requestFocus();
                dlgNCCliente.txtCant.selectAll();
            }
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void actCantidad3(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            int cod = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            double ca = Double.parseDouble(tabla.getValueAt(fila, 3).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 4).toString());
            double cant = (Mensajes.ingresarNumerosC(ca));
            int monto = (int) (pre * cant);
            int iva = Integer.parseInt(tabla.getValueAt(fila, 5).toString());
            tabla.setValueAt(String.valueOf(cant), fila, 3);
            switch (iva) {
                case 10 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 8);
                }
                case 5 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 7);
                }
                default -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 6);
                }
            }
            tabla.setValueAt(String.valueOf(monto), fila, 9);
            String total = String.valueOf(getTotal_2());
            String exentas = String.valueOf(getExcetas_2());
            String iva5 = String.valueOf(get5_2());
            String iva10 = String.valueOf(get10_2());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgNCCliente.txtTotalL.setText(total);
            dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void addmismoItem(int fila, double cantTabla, double cantAdd, int costo, int iva) {
        try {
            double cantFinal = (cantTabla + cantAdd);
            int montoAct = (int) (costo * cantFinal);
            dlgNCProveedor.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 3);
            dlgNCProveedor.tbDetalle.setValueAt(String.valueOf(costo), fila, 4);
            switch (iva) {
                case 10 -> {
                    dlgNCProveedor.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 8);
                }
                case 5 -> {
                    dlgNCProveedor.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 7);
                }
                default -> {
                    dlgNCProveedor.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 6);
                }
            }
            dlgNCProveedor.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 9);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCProveedor.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgNCProveedor.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgNCProveedor.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgNCProveedor.txtTotalL.setText(total);
            dlgNCProveedor.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void addmismoItem_2(int fila, double cantTabla, double cantAdd, int costo, int iva) {
        try {
            double cantFinal = (cantTabla + cantAdd);
            int montoAct = (int) (costo * cantFinal);
            dlgNCCliente.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 3);
            dlgNCCliente.tbDetalle.setValueAt(String.valueOf(costo), fila, 4);
            switch (iva) {
                case 10 -> {
                    dlgNCCliente.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 8);
                }
                case 5 -> {
                    dlgNCCliente.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 7);
                }
                default -> {
                    dlgNCCliente.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 6);
                }
            }
            dlgNCCliente.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 9);
            String total = String.valueOf(getTotal_2());
            String exentas = String.valueOf(getExcetas_2());
            String iva5 = String.valueOf(get5_2());
            String iva10 = String.valueOf(get10_2());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgNCCliente.txtTotalL.setText(total);
            dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void actPrecio(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            String cod = (tabla.getValueAt(fila, 0).toString());
            double cant = Double.valueOf(tabla.getValueAt(fila, 3).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 4).toString());
            int precio = (Mensajes.ingresarPrecioC(pre));
            int iva = Integer.parseInt(tabla.getValueAt(fila, 5).toString());
            int monto = (int) (cant * (precio));
            tabla.setValueAt(String.valueOf(precio), fila, 4);
            switch (iva) {
                case 10 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 8);
                }
                case 5 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 7);
                }
                default -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 6);
                }
            }
            tabla.setValueAt(String.valueOf(monto), fila, 9);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCProveedor.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgNCProveedor.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgNCProveedor.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgNCProveedor.txtTotalL.setText(total);
            dlgNCProveedor.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void actPrecio2(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            String cod = (tabla.getValueAt(fila, 0).toString());
            double cant = Double.valueOf(tabla.getValueAt(fila, 3).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 4).toString());
            int precio = (Mensajes.ingresarPrecioC(pre));
            int iva = Integer.parseInt(tabla.getValueAt(fila, 5).toString());
            int monto = (int) (cant * (precio));
            tabla.setValueAt(String.valueOf(precio), fila, 4);
            switch (iva) {
                case 10 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 8);
                }
                case 5 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 7);
                }
                default -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 6);
                }
            }
            tabla.setValueAt(String.valueOf(monto), fila, 9);
            String total = String.valueOf(getTotal_2());
            String exentas = String.valueOf(getExcetas_2());
            String iva5 = String.valueOf(get5_2());
            String iva10 = String.valueOf(get10_2());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgNCCliente.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgNCCliente.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgNCCliente.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgNCCliente.txtTotalL.setText(total);
            dlgNCCliente.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void listarNCProveedor(JTable tabla) {
        try {
            HttpClient nc = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNCProveedor = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNCProveedor.length(); f++) {
                                Object[] fila = new Object[12];
                                fila[0] = jsonNCProveedor.getJSONObject("" + f + "").get("id").toString();
                                fila[1] = jsonNCProveedor.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonNCProveedor.getJSONObject("" + f + "").get("idcompra").toString();
                                fila[3] = jsonNCProveedor.getJSONObject("" + f + "").get("nrofactura").toString();
                                fila[4] = jsonNCProveedor.getJSONObject("" + f + "").get("condicion").toString();
                                fila[5] = jsonNCProveedor.getJSONObject("" + f + "").get("ruc").toString() + " - " + jsonNCProveedor.getJSONObject("" + f + "").get("rs").toString();
                                if (jsonNCProveedor.getJSONObject("" + f + "").get("prom").toString().equals("S")) {
                                    fila[6] = "SI";
                                } else if (jsonNCProveedor.getJSONObject("" + f + "").get("prom").toString().equals("N")) {
                                    fila[6] = "NO";
                                }
                                fila[7] = jsonNCProveedor.getJSONObject("" + f + "").get("nc_nro").toString();
                                fila[8] = Fecha.formatoFechaDd(jsonNCProveedor.getJSONObject("" + f + "").get("fecha").toString());
                                fila[9] = jsonNCProveedor.getJSONObject("" + f + "").get("total").toString();
                                fila[10] = Fecha.formatoFechaDdHMS(jsonNCProveedor.getJSONObject("" + f + "").get("registro").toString());
                                if (jsonNCProveedor.getJSONObject("" + f + "").get("estado").toString().equals("S")) {
                                    fila[11] = "";
                                } else if (jsonNCProveedor.getJSONObject("" + f + "").get("estado").toString().equals("N")) {
                                    fila[11] = "ANULADO";
                                }
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            nc.excecute(urlServer() + "getlistNCProveedor.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarNCCliente(JTable tabla) {
        try {
            HttpClient nc = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNCProveedor = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNCProveedor.length(); f++) {
                                Object[] fila = new Object[12];
                                fila[0] = jsonNCProveedor.getJSONObject("" + f + "").get("id").toString();
                                fila[1] = jsonNCProveedor.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonNCProveedor.getJSONObject("" + f + "").get("idfactura").toString();
                                fila[3] = jsonNCProveedor.getJSONObject("" + f + "").get("nrofactura").toString();
                                fila[4] = jsonNCProveedor.getJSONObject("" + f + "").get("condicion").toString();
                                fila[5] = jsonNCProveedor.getJSONObject("" + f + "").get("ruc").toString() + " - " + jsonNCProveedor.getJSONObject("" + f + "").get("rs").toString();
                                if (jsonNCProveedor.getJSONObject("" + f + "").get("prom").toString().equals("S")) {
                                    fila[6] = "SI";
                                } else if (jsonNCProveedor.getJSONObject("" + f + "").get("prom").toString().equals("N")) {
                                    fila[6] = "NO";
                                }
                                fila[7] = jsonNCProveedor.getJSONObject("" + f + "").get("nc_nro").toString();
                                fila[8] = Fecha.formatoFechaDd(jsonNCProveedor.getJSONObject("" + f + "").get("fecha").toString());
                                fila[9] = jsonNCProveedor.getJSONObject("" + f + "").get("total").toString();
                                fila[10] = Fecha.formatoFechaDdHMS(jsonNCProveedor.getJSONObject("" + f + "").get("registro").toString());
                                if (jsonNCProveedor.getJSONObject("" + f + "").get("estado").toString().equals("S")) {
                                    fila[11] = "";
                                } else if (jsonNCProveedor.getJSONObject("" + f + "").get("estado").toString().equals("N")) {
                                    fila[11] = "ANULADO";
                                }
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            nc.excecute(urlServer() + "getlistNCClientes.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarPagosVenta(JTable tabla) {
        try {
            HttpClient pv = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNCProveedor = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNCProveedor.length(); f++) {
                                Object[] fila = new Object[5];
                                fila[0] = jsonNCProveedor.getJSONObject("" + f + "").get("idpagos").toString();
                                fila[1] = jsonNCProveedor.getJSONObject("" + f + "").get("recibo").toString();
                                fila[2] = jsonNCProveedor.getJSONObject("" + f + "").get("total").toString();
                                fila[3] = Fecha.formatoFechaDdHMS(jsonNCProveedor.getJSONObject("" + f + "").get("fecha_hora").toString());
                                if (jsonNCProveedor.getJSONObject("" + f + "").get("estado").toString().equals("S")) {
                                    fila[4] = "";
                                } else {
                                    fila[4] = "ANULADO";
                                }
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            pv.excecute(urlServer() + "getlistPagosVenta.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarDetalleNCProveedor(JTable tabla) {
        int x = dlgConsultarNCProveedor.tbNC.getSelectedRow();
        String cod = dlgConsultarNCProveedor.tbNC.getValueAt(x, 0).toString();
        String mov = dlgConsultarNCProveedor.tbNC.getValueAt(x, 1).toString();
        String factura = dlgConsultarNCProveedor.tbNC.getValueAt(x, 3).toString() + " - " + dlgConsultarNCProveedor.tbNC.getValueAt(x, 4).toString();
        String proveedor = dlgConsultarNCProveedor.tbNC.getValueAt(x, 5).toString();
        dlgConsultarNCProveedor.txtCodCompra.setText(cod);
        dlgConsultarNCProveedor.txtmov.setText(mov);
        dlgConsultarNCProveedor.txtFactura.setText(factura);
        dlgConsultarNCProveedor.txtProveedor.setText(proveedor);
        try {
            HttpClient detalleNCP = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonFacturas = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonFacturas.length(); f++) {
                                Object[] fila = new Object[7];
                                fila[0] = jsonFacturas.getJSONObject("" + f + "").get("idnota").toString();
                                fila[1] = jsonFacturas.getJSONObject("" + f + "").get("idprod").toString();
                                fila[2] = jsonFacturas.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonFacturas.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonFacturas.getJSONObject("" + f + "").get("cant").toString();
                                fila[5] = jsonFacturas.getJSONObject("" + f + "").get("costo").toString();
                                fila[6] = jsonFacturas.getJSONObject("" + f + "").get("total").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            detalleNCP.excecute(urlServer() + "getlistDetalleNCP.php?cod=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarDetalleNCCliente(JTable tabla) {
        int x = dlgConsultarNCCliente.tbNC.getSelectedRow();
        String cod = dlgConsultarNCCliente.tbNC.getValueAt(x, 0).toString();
        String mov = dlgConsultarNCCliente.tbNC.getValueAt(x, 1).toString();
        String factura = dlgConsultarNCCliente.tbNC.getValueAt(x, 3).toString() + " - " + dlgConsultarNCCliente.tbNC.getValueAt(x, 4).toString();
        String proveedor = dlgConsultarNCCliente.tbNC.getValueAt(x, 5).toString();
        dlgConsultarNCCliente.txtCodCompra.setText(cod);
        dlgConsultarNCCliente.txtmov.setText(mov);
        dlgConsultarNCCliente.txtFactura.setText(factura);
        dlgConsultarNCCliente.txtProveedor.setText(proveedor);
        try {
            HttpClient detalleNCC = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNC = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNC.length(); f++) {
                                Object[] fila = new Object[7];
                                fila[0] = jsonNC.getJSONObject("" + f + "").get("idnota").toString();
                                fila[1] = jsonNC.getJSONObject("" + f + "").get("idprod").toString();
                                fila[2] = jsonNC.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonNC.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonNC.getJSONObject("" + f + "").get("cant").toString();
                                fila[5] = jsonNC.getJSONObject("" + f + "").get("costo").toString();
                                fila[6] = jsonNC.getJSONObject("" + f + "").get("total").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            detalleNCC.excecute(urlServer() + "getlistDetalleNCC.php?cod=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void DetallePagosVentas1(JTable tabla) {
        int x = dlgConsultarPagosVentas.tbPagos.getSelectedRow();
        String cod = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 0).toString();
        try {
            HttpClient dpv1 = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNC = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNC.length(); f++) {
                                Object[] fila = new Object[2];
                                fila[0] = jsonNC.getJSONObject("" + f + "").get("forma_pago").toString();
                                fila[1] = jsonNC.getJSONObject("" + f + "").get("monto").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            dpv1.excecute(urlServer() + "getlistDetallePagosVentas1.php?cod=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void DetallePagosVentas2(JTable tabla) {
        int x = dlgConsultarPagosVentas.tbPagos.getSelectedRow();
        String cod = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 0).toString();
        try {
            HttpClient dpv2 = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNC = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNC.length(); f++) {
                                Object[] fila = new Object[5];
                                fila[0] = jsonNC.getJSONObject("" + f + "").get("fac_codigo").toString();
                                fila[1] = jsonNC.getJSONObject("" + f + "").get("ruc").toString() + " - " + jsonNC.getJSONObject("" + f + "").get("rs").toString();
                                fila[2] = Fecha.formatoFechaDd(jsonNC.getJSONObject("" + f + "").get("fac_fecha").toString());
                                fila[3] = jsonNC.getJSONObject("" + f + "").get("fac_factura").toString();
                                fila[4] = jsonNC.getJSONObject("" + f + "").get("fac_totalfinal").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            dpv2.excecute(urlServer() + "getlistDetallePagosVentas2.php?cod=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void DetallePagosVentas3(JTable tabla) {
        int x = dlgConsultarPagosVentas.tbPagos.getSelectedRow();
        String cod = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 0).toString();
        try {
            HttpClient dpv3 = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonNC = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonNC.length(); f++) {
                                Object[] fila = new Object[4];
                                fila[0] = jsonNC.getJSONObject("" + f + "").get("idnc").toString();
                                fila[1] = Fecha.formatoFechaDd(jsonNC.getJSONObject("" + f + "").get("fecha").toString());
                                fila[2] = jsonNC.getJSONObject("" + f + "").get("nc_nro").toString();
                                fila[3] = jsonNC.getJSONObject("" + f + "").get("total").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            dpv3.excecute(urlServer() + "getlistDetallePagosVentas3.php?cod=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String anularNCP() {
        String msg;
        int x = dlgConsultarNCProveedor.tbNC.getSelectedRow();
        String cod = dlgConsultarNCProveedor.tbNC.getValueAt(x, 0).toString();
        String idcompra = dlgConsultarNCProveedor.tbNC.getValueAt(x, 2).toString();
        int monto = Integer.parseInt(dlgConsultarNCProveedor.tbNC.getValueAt(x, 9).toString());
        String prom = dlgConsultarNCProveedor.tbNC.getValueAt(x, 6).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarNCProveedor.delNCProveedor(cod, usuario, idcompra, monto);
        if (msg.equals("OK")) {
            if (prom.equals("SI")) {
                actStockEliminarNCPromocion();
            }
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String anularNCC() {
        String msg;
        int x = dlgConsultarNCCliente.tbNC.getSelectedRow();
        String cod = dlgConsultarNCCliente.tbNC.getValueAt(x, 0).toString();
        String idfactura = dlgConsultarNCCliente.tbNC.getValueAt(x, 2).toString();
        int monto = Integer.parseInt(dlgConsultarNCCliente.tbNC.getValueAt(x, 9).toString());
        String prom = dlgConsultarNCCliente.tbNC.getValueAt(x, 6).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarNCProveedor.delNCCliente(cod, usuario, idfactura, monto);
        if (msg.equals("OK")) {
            if (prom.equals("NO")) {
                actStockEliminarNCC();
            }
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String anularPago() {
        String msg;
        int x = dlgConsultarPagosVentas.tbPagos.getSelectedRow();
        String cod = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 0).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarNCProveedor.delPagos(cod, usuario);
        if (msg.equals("OK")) {
            Mensajes.Sistema("El Pago fue anulado exitosamente.");
            String smg="";
            int cant = dlgConsultarPagosVentas.tbDPV2.getRowCount();
            for (int t1 = 0; t1 < cant; t1++) {
                String idf = dlgConsultarPagosVentas.tbDPV2.getValueAt(t1, 0).toString();
                smg = GestionarNCProveedor.delPagosF(idf, usuario);
            }
            if (smg.equals("OK")) {
                Mensajes.Sistema("Se restablecieron exitosamente las Facturas anexadas.");
                String ssg="";
                int cantt = dlgConsultarPagosVentas.tbDPV3.getRowCount();
                for (int t2 = 0; t2 < cantt; t2++) {
                    String idnc = dlgConsultarPagosVentas.tbDPV3.getValueAt(t2, 0).toString();
                    ssg = GestionarNCProveedor.delPagosFF(idnc, usuario);
                }
                if(ssg.equals("OK")){
                    Mensajes.Sistema("Se restablecieron exitosamente las Notas de Créditos afectadas.");
                }
            } else {
                Mensajes.error(smg);
            }

        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarNCPromocion() {
        String msg = null;
        int f = dlgConsultarNCProveedor.tbDetalleNCP.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarNCProveedor.tbDetalleNCP.getValueAt(i, 1).toString());
            double st = Double.parseDouble(dlgConsultarNCProveedor.tbDetalleNCP.getValueAt(i, 4).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMAS(a);
        }
        if (msg.equals("OK")) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarNCC() {
        String msg = null;
        int f = dlgConsultarNCCliente.tbDetalleNCP.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarNCCliente.tbDetalleNCP.getValueAt(i, 1).toString());
            double st = Double.parseDouble(dlgConsultarNCCliente.tbDetalleNCP.getValueAt(i, 4).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMENOSDañados(a);
        }
        if (msg.equals("OK")) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

}
