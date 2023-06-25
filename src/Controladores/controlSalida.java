package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Redondeo;
import static Componentes.URL.urlServer;
import Datos.ArregloDetalles;
import Datos.GestionarArticulosMovil;
import Datos.GestionarSalida;
import IU.dlgBuscarArticulo;
import IU.dlgConSalidas;
import IU.dlgGestSolicitudDestrucción;
import IU.dlgGestSolicitudNCP;
import IU.dlgSalidaMercaderia;
import static IU.dlgSalidaMercaderia.Renders;
import static IU.dlgSalidaMercaderia.txtCant;
import IU.dlgSolicitudDestrucción;
import IU.dlgSolicitudNCProveedor;
import Modelo.ArticuloMovil;
import Modelo.DetalleSalida;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlSalida {

    static DetalleSalida ds;
    static ArticuloMovil art;
    public static ArregloDetalles array = new ArregloDetalles();
    static String UsuarioL = "";

    private static int idsalida;
    private static int idmotivo;
    private static String motivo;
    private static int idprod;
    private static String codbarra;
    private static String descripcion;
    private static String cantidad;
    private static int precio;
    private static int total;

    public static void selecProducto() {
        try {
            int x = dlgBuscarArticulo.tbDetalle.getSelectedRow();
            String cod = dlgBuscarArticulo.tbDetalle.getValueAt(x, 0).toString();
            art = GestionarArticulosMovil.busArticulo(cod);
            if (art.getStock() == 0.00) {
                Mensajes.informacion("Artículo con stock actual 0");
            } else {
                dlgSalidaMercaderia.lblCodArt.setText(String.valueOf(art.getIdproducto()));
                dlgSalidaMercaderia.txtArt.setText(art.getDescripcion());
                dlgSalidaMercaderia.txtCant.requestFocus();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /*public static void addTabla(JTable tabla)
    {
        try {
            int codA = art.getCodArticulo();
            String desc = art.getDescripcion();
            int codM = Integer.parseInt(dlgSalidaMercaderia.lblMotivo.getText());
            String mot = dlgSalidaMercaderia.cbMotivo.getSelectedItem().toString();
            int can = Integer.parseInt(dlgSalidaMercaderia.txtCant.getText());
            int pre = art.getCosto();
            int mon = Redondeo.redondearI(can * pre);
            int sa = (int) stockActual();
            
            DetalleSalida dsa = new DetalleSalida(codA, codM, can, pre, mon);
            
                if(array.busca(dsa.getCodArt()) !=-1 )
                {
                    Mensajes.error("Articulo ya fue agregado");
                }
            else
            {
                if(dlgSalidaMercaderia.txtCant.getText().compareTo("0") != 0)
                {
                    if(can<art.getStock())
                    {
                        array.agregar(dsa);
                        insertar(String.valueOf(codA),desc ,String.valueOf(codM),mot ,String.valueOf(can), String.valueOf(pre), String.valueOf(mon), String.valueOf(sa), tabla);
                        double total = getTotal();
                        dlgSalidaMercaderia.txtTotal.setText(String.valueOf(total));
                    }
                    else
                    {
                        Mensajes.error("No tiene stock sufisiente");
                    }
                }
                else
                {
                    Mensajes.error("Ingrese una cantidad");
                }
            
            }
        } catch (Exception e) {
            Mensajes.error("Eliga al menos un Artículo");
        }
    }*/
    public static void addTabla(JTable tabla) {
        try {
            int codA = art.getIdproducto();
            String desc = art.getDescripcion();
            int codM = Integer.parseInt(dlgSalidaMercaderia.lblMotivo.getText());
            String mot = dlgSalidaMercaderia.cbMotivo.getSelectedItem().toString();
            float can = Float.parseFloat(dlgSalidaMercaderia.txtCant.getText());
            int pre = art.getPrecio_costo();
            int mon = ((int) (can * pre));

            DetalleSalida dso = new DetalleSalida(codA);
            if (array.busca(dso.getCodArt()) != -1) {
                int Nfila = array.busca(dso.getCodArt());
                double cantTabla = Double.parseDouble(dlgSalidaMercaderia.tbDetalle.getValueAt(Nfila, 4).toString());
                if ((cantTabla + can) > art.getStock()) {
                    Mensajes.informacion("Stock insuficiente");
                    double sobra = art.getStock() - cantTabla;
                    txtCant.setText(String.valueOf(sobra));
                    txtCant.requestFocus();
                } else {
                    addmismoItem(Nfila, cantTabla, can, pre);
                    Renders();
                }

            } else {

                array.agregar(dso);
                insertar(String.valueOf(codA), desc, String.valueOf(codM), mot, String.valueOf(can), String.valueOf(pre), String.valueOf(mon), tabla);
                int total = getTotal();
                dlgSalidaMercaderia.txtTotalL.setText(String.valueOf(total));
                DecimalFormat df = new DecimalFormat("#,###");
                dlgSalidaMercaderia.txtTotal.setText(df.format(Integer.valueOf(dlgSalidaMercaderia.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                Renders();

            }

        } catch (NumberFormatException e) {
            Mensajes.error("Eliga al menos un Artículo");
        }
    }

    public static void addmismoItem(int fila, double cantTabla, double cantAdd, int costo) {
        try {
            double cantFinal = (cantTabla + cantAdd);
            int montoAct = (int) (costo * cantFinal);
            dlgSalidaMercaderia.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 4);
            dlgSalidaMercaderia.tbDetalle.setValueAt(String.valueOf(costo), fila, 5);
            dlgSalidaMercaderia.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 6);
            int total = getTotal();
            dlgSalidaMercaderia.txtTotalL.setText(String.valueOf(total));
            if (dlgSalidaMercaderia.txtTotalL.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                dlgSalidaMercaderia.txtTotal.setText(df.format(Integer.valueOf(dlgSalidaMercaderia.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
            }
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void delRenglon(JTable tabla) {
        consLinea();
        int f = dlgSalidaMercaderia.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgSalidaMercaderia.tbDetalle.getValueAt(f, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(f);
                int total = getTotal();
                //dlgSalidaMercaderia.txtTotal.setText(String.valueOf(total));
                dlgSalidaMercaderia.txtTotalL.setText(String.valueOf(total));

                if (dlgSalidaMercaderia.txtTotalL.getText().trim().length() >= 1) {
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgSalidaMercaderia.txtTotal.setText(df.format(Integer.valueOf(dlgSalidaMercaderia.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));

                }
            }
        }
    }

    public static void actCantidad(JTable tabla) {
        try {
            int fila = dlgSalidaMercaderia.tbDetalle.getSelectedRow();
            String cod = dlgSalidaMercaderia.tbDetalle.getValueAt(fila, 0).toString();
            art = GestionarArticulosMovil.busArticulo(cod);
            int pre = Integer.valueOf(dlgSalidaMercaderia.tbDetalle.getValueAt(fila, 5).toString());
            float can = Mensajes.ingresarNumeros();
            int monto = Redondeo.redondearI((int) (pre * can));
            double st = (art.getStock() - can);
            dlgSalidaMercaderia.tbDetalle.setValueAt(can, fila, 4);
            dlgSalidaMercaderia.tbDetalle.setValueAt(monto, fila, 6);
            dlgSalidaMercaderia.tbDetalle.setValueAt(st, fila, 7);
            int total = getTotal();

            dlgSalidaMercaderia.txtTotalL.setText(String.valueOf(total));
            if (dlgSalidaMercaderia.txtTotalL.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                dlgSalidaMercaderia.txtTotal.setText(df.format(Integer.valueOf(dlgSalidaMercaderia.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
            }
            //dlgSalidaMercaderia.txtTotal.setText(String.valueOf(total));
            //dlgSalidaMercaderia.txtTotalL.setText(String.valueOf(total));
            dlgSalidaMercaderia.txtArt.setText("");
            dlgSalidaMercaderia.txtCant.setText("");
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void consLinea() {
        int f = dlgSalidaMercaderia.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgSalidaMercaderia.tbDetalle.getValueAt(f, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Artículo no existe");
        } else {
            ds = array.getFila(p);
            int codA = ds.getCodArt();
        }

    }

    static void insertar(String codA, String desc, String codM, String mont, String cand, String prec, String tot, JTable tabla) {
        Object[] fila = {codA, desc, codM, mont, cand, prec, tot};
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        tb.addRow(fila);
    }

    public static int getTotal() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgSalidaMercaderia.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgSalidaMercaderia.tbDetalle.getModel().getValueAt(i, 6)));
        }
        return (total);
    }

    public static int getTotalDetalleSalidaNCP() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgGestSolicitudNCP.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgGestSolicitudNCP.tbDetalle.getModel().getValueAt(i, 8)));
        }
        return (total);
    }
    
    public static int getTotalDetalleSalidaD() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgGestSolicitudDestrucción.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgGestSolicitudDestrucción.tbDetalle.getModel().getValueAt(i, 8)));
        }
        return (total);
    }

    public static double stockActual() {
        double cant = Double.parseDouble(dlgSalidaMercaderia.txtCant.getText());
        return (double) (art.getStock() - cant);
    }

    public static String actStock() {
        String msg = null;
        int f = dlgSalidaMercaderia.tbDetalle.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 0).toString());
            double st = Double.parseDouble(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 4).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMENOS(a);
        }
        if (msg == null) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarSalida() {
        String msg = null;
        int f = dlgConSalidas.tbDetalleSalida.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConSalidas.tbDetalleSalida.getValueAt(i, 0).toString());
            double st = Double.parseDouble(dlgConSalidas.tbDetalleSalida.getValueAt(i, 2).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMAS(a);
        }
        if ("OK".equals(msg)) {
            Mensajes.informacion("Stock Actualizado.\nDestino: DEPOSITO DE PRODUCTOS BUENO.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarSolicitud() {
        String msg = null;
        int f = dlgSolicitudNCProveedor.tbDetalleS.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgSolicitudNCProveedor.tbDetalleS.getValueAt(i, 1).toString());
            double st = Double.parseDouble(dlgSolicitudNCProveedor.tbDetalleS.getValueAt(i, 2).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMASDañados(a);
        }
        if ("OK".equals(msg)) {
            Mensajes.informacion("Stock Actualizado.\nDestino: DEPOSITO DE DAÑADOS.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actStockEliminarDestruccion() {
        String msg = null;
        int f = dlgSolicitudDestrucción.tbDetalleS.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgSolicitudDestrucción.tbDetalleS.getValueAt(i, 1).toString());
            double st = Double.parseDouble(dlgSolicitudDestrucción.tbDetalleS.getValueAt(i, 2).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMASDañados(a);
        }
        if ("OK".equals(msg)) {
            Mensajes.informacion("Stock Actualizado.\nDestino: DEPOSITO DE DAÑADOS.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarSalidayDañados() {
        String msg = null;
        String msg2 = null;
        int f = dlgConSalidas.tbDetalleSalida.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConSalidas.tbDetalleSalida.getValueAt(i, 0).toString());
            double st = Double.parseDouble(dlgConSalidas.tbDetalleSalida.getValueAt(i, 2).toString());
            ArticuloMovil a = new ArticuloMovil(coda, st);
            msg = GestionarArticulosMovil.actStockMAS(a);
            msg2 = GestionarArticulosMovil.actStockMENOSDañados(a);
        }
        if ("OK".equals(msg) && "OK".equals(msg2)) {
            Mensajes.informacion("Stock Actualizado.\nSALIDA: DEPOSITO DE DAÑADOS.\nDestino: DEPOSITO DE PRODUCTOS BUENO.");
        } else {
            Mensajes.error(msg);
            Mensajes.error(msg2);
        }
        return msg;
    }

    public static void canCelar() {
        array.vaciar();
    }

    /*public static String addSalida() {
        String msg;
        int codS = Integer.valueOf(dlgSalidaMercaderia.txtCod.getText());
        int codP = Integer.valueOf(dlgSalidaMercaderia.txtProveedor.getText());
        int iddeposito = Integer.valueOf(dlgSalidaMercaderia.txtDeposito.getText());
        int idcaja = Integer.parseInt(dlgSalidaMercaderia.txtCaja.getText());
        int idmotivo_salida = Integer.parseInt(dlgSalidaMercaderia.txtMotivoSalida.getText());
        String fecha = dlgSalidaMercaderia.txtFechaR.getText();
        String hora = Fecha.darHora();
        int total = Integer.valueOf(dlgSalidaMercaderia.txtTotalL.getText());
        String Obs = dlgSalidaMercaderia.txtObs.getText().toUpperCase();
        String estado ="S";
        String usuario = Login.getUsuarioLogueado();
        Salidas salida = new Salidas(codS, codP, iddeposito, idcaja, idmotivo_salida, fecha, hora, total, Obs, estado, usuario);
        array.vaciar();
        msg = GestionarSalida.addSalida(salida);

        if (msg == null) {
            Mensajes.informacion("Salida Registrada");
            controlSalida.addDetalleSalida();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/
    public static String DelSalida() {
        String msg;
        int x = dlgConSalidas.tbSalida.getSelectedRow();
        String cod = dlgConSalidas.tbSalida.getValueAt(x, 0).toString();
        int idpara = Integer.parseInt(dlgConSalidas.tbSalida.getValueAt(x, 8).toString());
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarSalida.DelSalida(cod, usuario);
        if (msg.equals("OK")) {
            Mensajes.informacion("Salida de Productos Eliminada satisfactoriamente.");
            if (idpara == 1) {
                controlSalida.actStockEliminarSalida();
            } else {
                controlSalida.actStockEliminarSalidayDañados();
            }

        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String DelSolicitud(int id) {
        String msg;
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarSalida.DelSolicitud(id, usuario);
        if (msg.equals("OK")) {
            Mensajes.informacion("Solicitud Eliminada satisfactoriamente.");
            controlSalida.actStockEliminarSolicitud();
            int f = dlgSolicitudNCProveedor.tbREF.getRowCount();
            String smg = null;
            for (int i = 0; i < f; i++) {
                int fila = Integer.parseInt(dlgSolicitudNCProveedor.tbREF.getValueAt(i, 0).toString());
                smg = controlSalida.ActivarSalidas(fila);
            }
            if (("OK").equals(smg)) {
                Mensajes.informacion("Las Salidas anexadas fueron reactivados satisfactoriamente.");
            } else {
                Mensajes.error(msg);
            }
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String DelDestruccion(int id) {
        String msg;
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarSalida.DelDestruccion(id, usuario);
        if (msg.equals("OK")) {
            Mensajes.informacion("Solicitud Eliminada satisfactoriamente.");
            controlSalida.actStockEliminarDestruccion();
            int f = dlgSolicitudDestrucción.tbREF.getRowCount();
            String smg = null;
            for (int i = 0; i < f; i++) {
                int fila = Integer.parseInt(dlgSolicitudDestrucción.tbREF.getValueAt(i, 0).toString());
                smg = controlSalida.ActivarSalidas(fila);
            }
            if (("OK").equals(smg)) {
                Mensajes.informacion("Las Salidas anexadas fueron reactivados satisfactoriamente.");
            } else {
                Mensajes.error(msg);
            }
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String ProcSolicitud(int id, String proc) {
        String msg;
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarSalida.ProcSolicitud(id, proc, usuario);
        if (msg.equals("OK")) {
            Mensajes.informacion("El estado de la Solicitud ha sido cambiado satisfactoriamente.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String ProcDestruccion(int id, String proc) {
        String msg;
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarSalida.ProcDestruccion(id, proc, usuario);
        if (msg.equals("OK")) {
            Mensajes.informacion("El estado de la Solicitud ha sido cambiado satisfactoriamente.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String ActivarSalidas(int fila) {
        String smg;
        String usuario = Login.getUsuarioLogueado();
        smg = GestionarSalida.ActivarSalida(fila, usuario);

        return smg;
    }

    /*public static String addDetalleSalida() {
        String msg = null;
        int f = dlgSalidaMercaderia.tbDetalle.getRowCount();
        for (int i = 0; i < f; i++) {
            int codA = Integer.valueOf(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 0).toString());
            int codS = Integer.valueOf(dlgSalidaMercaderia.txtCod.getText());
            int codM = Integer.valueOf(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 2).toString());
            double cant = Double.parseDouble(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 4).toString());
            int prec = Integer.valueOf(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 5).toString());
            int impo = Integer.valueOf(dlgSalidaMercaderia.tbDetalle.getValueAt(i, 6).toString());

            ds = new DetalleSalida(codA, codS, codM, cant, prec, impo);

            msg = GestionarSalida.addDetalleSalida(ds);
        }
        if (msg == null) {
            Mensajes.informacion("Detalle Registrado");
            controlSalida.actStock();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/
    public static void listSalidas(JTable tabla) {
        try {
            HttpClient salidas = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonSalida = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonSalida.length(); f++) {
                                Object[] fila = new Object[14];
                                fila[0] = jsonSalida.getJSONObject("" + f + "").get("cod").toString();
                                fila[1] = jsonSalida.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonSalida.getJSONObject("" + f + "").get("fecha").toString();
                                fila[3] = jsonSalida.getJSONObject("" + f + "").get("hora").toString();
                                fila[4] = jsonSalida.getJSONObject("" + f + "").get("ruc").toString() + " - " + jsonSalida.getJSONObject("" + f + "").get("razonsocial").toString();
                                fila[5] = jsonSalida.getJSONObject("" + f + "").get("iddeposito").toString();
                                fila[6] = jsonSalida.getJSONObject("" + f + "").get("depositosalida").toString();
                                fila[7] = jsonSalida.getJSONObject("" + f + "").get("tabla").toString();
                                fila[8] = jsonSalida.getJSONObject("" + f + "").get("idpara").toString();
                                fila[9] = jsonSalida.getJSONObject("" + f + "").get("para").toString();
                                fila[10] = jsonSalida.getJSONObject("" + f + "").get("total").toString();
                                fila[11] = jsonSalida.getJSONObject("" + f + "").get("obs").toString();
                                fila[12] = jsonSalida.getJSONObject("" + f + "").get("estado").toString();
                                fila[13] = jsonSalida.getJSONObject("" + f + "").get("proceso").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            salidas.excecute(urlServer() + "getlistSalidas.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listDetalle(JTable tabla) {
        int x = dlgConSalidas.tbSalida.getSelectedRow();
        int cod = Integer.parseInt(dlgConSalidas.tbSalida.getValueAt(x, 0).toString());
        try {
            HttpClient detalle_salidas = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonSalida = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonSalida.length(); f++) {
                                Object[] fila = new Object[7];
                                fila[0] = jsonSalida.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[1] = jsonSalida.getJSONObject("" + f + "").get("mot_nombre").toString();
                                fila[2] = jsonSalida.getJSONObject("" + f + "").get("ds_cantidad").toString();
                                fila[3] = jsonSalida.getJSONObject("" + f + "").get("salida_sal_codigo").toString();
                                fila[4] = jsonSalida.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[5] = jsonSalida.getJSONObject("" + f + "").get("ds_precio").toString();
                                fila[6] = jsonSalida.getJSONObject("" + f + "").get("ds_monto").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            detalle_salidas.excecute(urlServer() + "getlistDetalleSalidas.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void listarSalidasNCP(JTable tabla, int codprov) {
        try {
            HttpClient ncp = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonSalidas = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonSalidas.length(); f++) {
                                Object[] fila = new Object[7];
                                fila[0] = jsonSalidas.getJSONObject("" + f + "").get("cod").toString();
                                fila[1] = jsonSalidas.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonSalidas.getJSONObject("" + f + "").get("fecha").toString();
                                fila[3] = jsonSalidas.getJSONObject("" + f + "").get("hora").toString();
                                fila[4] = jsonSalidas.getJSONObject("" + f + "").get("depositosalida").toString();
                                fila[5] = jsonSalidas.getJSONObject("" + f + "").get("total").toString();
                                fila[6] = jsonSalidas.getJSONObject("" + f + "").get("obs").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            ncp.excecute(urlServer() + "getlistSalidasNCP.php?idprov=" + codprov);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void listarSalidasD(JTable tabla, int codprov) {
        try {
            HttpClient ncp = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonSalidas = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonSalidas.length(); f++) {
                                Object[] fila = new Object[7];
                                fila[0] = jsonSalidas.getJSONObject("" + f + "").get("cod").toString();
                                fila[1] = jsonSalidas.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonSalidas.getJSONObject("" + f + "").get("fecha").toString();
                                fila[3] = jsonSalidas.getJSONObject("" + f + "").get("hora").toString();
                                fila[4] = jsonSalidas.getJSONObject("" + f + "").get("depositosalida").toString();
                                fila[5] = jsonSalidas.getJSONObject("" + f + "").get("total").toString();
                                fila[6] = jsonSalidas.getJSONObject("" + f + "").get("obs").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            ncp.excecute(urlServer() + "getlistSalidasD.php?idprov=" + codprov);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarTLS(JTable tabla, String f) {
        try {
            String ff;
            if (f.contains(" ")) {
                ff = f.replace(" ", "%20");
            } else {
                ff = f;
            }
            HttpClient tls = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonTLS = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonTLS.length(); f++) {
                                Object[] fila = new Object[10];
                                fila[0] = jsonTLS.getJSONObject("" + f + "").get("idsolicitud").toString();
                                fila[1] = jsonTLS.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonTLS.getJSONObject("" + f + "").get("pro_ruc").toString() + " - " + jsonTLS.getJSONObject("" + f + "").get("pro_razonsocial").toString();
                                fila[3] = jsonTLS.getJSONObject("" + f + "").get("pro_razonsocial").toString();
                                fila[4] = jsonTLS.getJSONObject("" + f + "").get("fecha").toString();
                                fila[5] = jsonTLS.getJSONObject("" + f + "").get("hora").toString();
                                fila[6] = jsonTLS.getJSONObject("" + f + "").get("total").toString();
                                fila[7] = jsonTLS.getJSONObject("" + f + "").get("observacion").toString();
                                fila[8] = jsonTLS.getJSONObject("" + f + "").get("cerrado").toString();
                                fila[9] = jsonTLS.getJSONObject("" + f + "").get("estado").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            tls.excecute(urlServer() + "getlistTLS.php?f=" + ff);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void listarTLSDestruccion(JTable tabla, String f) {
        try {
            String ff;
            if (f.contains(" ")) {
                ff = f.replace(" ", "%20");
            } else {
                ff = f;
            }
            HttpClient tls = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonTLS = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonTLS.length(); f++) {
                                Object[] fila = new Object[10];
                                fila[0] = jsonTLS.getJSONObject("" + f + "").get("idsolicitud").toString();
                                fila[1] = jsonTLS.getJSONObject("" + f + "").get("idcaja").toString();
                                fila[2] = jsonTLS.getJSONObject("" + f + "").get("pro_ruc").toString() + " - " + jsonTLS.getJSONObject("" + f + "").get("pro_razonsocial").toString();
                                fila[3] = jsonTLS.getJSONObject("" + f + "").get("pro_razonsocial").toString();
                                fila[4] = jsonTLS.getJSONObject("" + f + "").get("fecha").toString();
                                fila[5] = jsonTLS.getJSONObject("" + f + "").get("hora").toString();
                                fila[6] = jsonTLS.getJSONObject("" + f + "").get("total").toString();
                                fila[7] = jsonTLS.getJSONObject("" + f + "").get("observacion").toString();
                                fila[8] = jsonTLS.getJSONObject("" + f + "").get("cerrado").toString();
                                fila[9] = jsonTLS.getJSONObject("" + f + "").get("estado").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            tls.excecute(urlServer() + "getlistTLSD.php?f=" + ff);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listDetalleTLS(JTable tabla) {
        int x = dlgSolicitudNCProveedor.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgSolicitudNCProveedor.tbDetalle.getValueAt(x, 0).toString());
        try {
            HttpClient detalle_solicitud = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonDetalleSolicitud = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonDetalleSolicitud.length(); f++) {
                                Object[] fila = new Object[3];
                                fila[0] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idsolicitud").toString();
                                fila[1] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[2] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("cantidad").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            detalle_solicitud.excecute(urlServer() + "getlistDetalleSolicitudNC.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    public static void listDetalleTLSD(JTable tabla) {
        int x = dlgSolicitudDestrucción.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgSolicitudDestrucción.tbDetalle.getValueAt(x, 0).toString());
        try {
            HttpClient detalle_solicitud = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonDetalleSolicitud = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonDetalleSolicitud.length(); f++) {
                                Object[] fila = new Object[3];
                                fila[0] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idsolicitud").toString();
                                fila[1] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[2] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("cantidad").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            detalle_solicitud.excecute(urlServer() + "getlistDetalleSolicitudD.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    public static void listDetalleTLSpModificacion(int cod, JTable tabla) {
        try {
            HttpClient detalle_solicitud = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonDetalleSolicitud = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonDetalleSolicitud.length(); f++) {
                                Object[] fila = new Object[9];
                                fila[0] = "0";
                                fila[1] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idmotivo").toString();
                                fila[2] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("mot_nombre").toString();
                                fila[3] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[4] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[5] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[6] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("cantidad").toString();
                                fila[7] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("precio").toString();
                                fila[8] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("total").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            detalle_solicitud.excecute(urlServer() + "getlistDetalleSolicitudNC.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    public static void listDetalleTLSDpModificacion(int cod, JTable tabla) {
        try {
            HttpClient detalle_solicitud = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonDetalleSolicitud = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonDetalleSolicitud.length(); f++) {
                                Object[] fila = new Object[9];
                                fila[0] = "0";
                                fila[1] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idmotivo").toString();
                                fila[2] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("mot_nombre").toString();
                                fila[3] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("idproducto").toString();
                                fila[4] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[5] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[6] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("cantidad").toString();
                                fila[7] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("precio").toString();
                                fila[8] = jsonDetalleSolicitud.getJSONObject("" + f + "").get("total").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            detalle_solicitud.excecute(urlServer() + "getlistDetalleSolicitudD.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void listRefTLSD(JTable tabla) {
        int x = dlgSolicitudDestrucción.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgSolicitudDestrucción.tbDetalle.getValueAt(x, 0).toString());
        try {
            HttpClient refTLSD = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonREF = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonREF.length(); f++) {
                                Object[] fila = new Object[8];
                                fila[0] = jsonREF.getJSONObject("" + f + "").get("idsalida").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            refTLSD.excecute(urlServer() + "getlistRefTLSD.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    public static void listRefTLS(JTable tabla) {
        int x = dlgSolicitudNCProveedor.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgSolicitudNCProveedor.tbDetalle.getValueAt(x, 0).toString());
        try {
            HttpClient refTLS = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonREF = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonREF.length(); f++) {
                                Object[] fila = new Object[8];
                                fila[0] = jsonREF.getJSONObject("" + f + "").get("idsalida").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });
            refTLS.excecute(urlServer() + "getlistRefTLS.php?param=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    public static void addTablaSolicitudNCP(JTable tabla, int cod) {
        try {
            try {
                HttpClient detalle_salidas = new HttpClient(new OnHttpRequestComplete() {
                    @Override
                    public void onComplete(Response status) {
                        if (status.isSuccess()) {
                            try {
                                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                                JSONObject jsonSalida = new JSONObject(status.getResult());
                                for (int f = 0; f < jsonSalida.length(); f++) {
                                    idsalida = Integer.parseInt(jsonSalida.getJSONObject("" + f + "").get("salida_sal_codigo").toString());
                                    idmotivo = Integer.parseInt(jsonSalida.getJSONObject("" + f + "").get("idmot").toString());
                                    motivo = jsonSalida.getJSONObject("" + f + "").get("mot_nombre").toString();
                                    idprod = Integer.parseInt(jsonSalida.getJSONObject("" + f + "").get("idproducto").toString());
                                    codbarra = jsonSalida.getJSONObject("" + f + "").get("codbarra").toString();
                                    descripcion = jsonSalida.getJSONObject("" + f + "").get("descripcion").toString();
                                    cantidad = jsonSalida.getJSONObject("" + f + "").get("ds_cantidad").toString();
                                    precio = Integer.parseInt(jsonSalida.getJSONObject("" + f + "").get("ds_precio").toString());
                                    total = Integer.parseInt(jsonSalida.getJSONObject("" + f + "").get("ds_monto").toString());
                                    insertarDetalleSolicitudNCP(idsalida, idmotivo, motivo, idprod, codbarra, descripcion, cantidad, precio, total, tabla);
                                    DecimalFormat df = new DecimalFormat("#,###");
                                    try{
                                        String montoFinalS = String.valueOf(getTotalDetalleSalidaNCP());    
                                        dlgGestSolicitudNCP.txtTotal.setText(df.format(Integer.parseInt(montoFinalS.replace(".", "").replace(",", ""))));
                                    }catch(Exception e){}
                                    try{
                                        String montoFinalD = String.valueOf(getTotalDetalleSalidaD());
                                        dlgGestSolicitudDestrucción.txtTotal.setText(df.format(Integer.parseInt(montoFinalD.replace(".", "").replace(",", ""))));
                                    }catch(Exception e){}  
                                }
                            } catch (JSONException e) {
                            }
                        }
                    }
                });
                detalle_salidas.excecute(urlServer() + "getlistDetalleSalidas.php?param=" + cod);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void insertarDetalleSolicitudNCP(int idsalida, int idmotivo, String motivo, int idprod, String codbarra, String descripcion, String cant, int precio, int total, JTable tabla) {

        String fila[] = new String[9];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();

        fila[0] = String.valueOf(idsalida);
        fila[1] = String.valueOf(idmotivo);
        fila[2] = motivo;
        fila[3] = String.valueOf(idprod);
        fila[4] = codbarra;
        fila[5] = descripcion;
        fila[6] = cant;
        fila[7] = String.valueOf(precio);
        fila[8] = String.valueOf(total);
        tb.addRow(fila);
    }

}
