package Controladores;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Redondeo;
import static Componentes.URL.urlServer;
import Datos.ArregloFactura;
import Datos.ArregloTransferencia;
import Datos.GestionarArticulosMovil;
import Datos.GestionarCliente;
import Datos.GestionarFactura;
import Datos.GestionarVendedor;
import IU.dlgBuscarArticuloTransferencia;
import IU.dlgBuscarArticuloVenta;
import IU.dlgBuscarArticuloVenta1;
import IU.dlgBuscarCliente;
import IU.dlgBuscarCliente1;
import IU.dlgBuscarCliente2;
import IU.dlgConsultarFacturas;
import IU.dlgConsultarFacturasMovil;
import IU.dlgGestTransferencias;
import static IU.dlgGestTransferencias.BloquearOrigen;
import IU.dlgReporteExtractoComprobantes;
import IU.dlgReporteFacturasEmitidas;
import IU.dlgVentas;
import Modelo.ArticuloMovil;
import Modelo.ClienteMovil;
import Modelo.DetalleFactura;
import Modelo.DetalleTransferencia;
import Modelo.Vendedor;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class controlFactura {

    static ClienteMovil cl;
    static ArticuloMovil art;
    static DetalleFactura dfa;
    static DetalleTransferencia dtran;
    static ArregloFactura array = new ArregloFactura();
    static ArregloTransferencia arrayT = new ArregloTransferencia();
    static String UsuarioL = "";

    /*public static Connection con;
    public static Statement st;
    public static ResultSet rss;
    
    static ConexionBD conectar = ConexionBD.getInstancia();*/

 /* public static void prepararBD() {
        try {
            con = (Connection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                st = (Statement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
    public static void selecArticulo()//Seleccionar Artículo
    {
        int x = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloVenta.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulosMovil.busArticulo(cod);
        dlgVentas.txtCodArticulo.setText(String.valueOf(art.getIdproducto()));
        dlgVentas.txtArt.setText(art.getDescripcion());
        dlgVentas.txtCant.setText("1");
        //DecimalFormat df = new DecimalFormat("#,###");
        //String PV = String.valueOf(art.getPrecio_venta());
    }

    public static void selecArticuloT()//Seleccionar Artículo
    {
        int x = dlgBuscarArticuloVenta1.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloVenta1.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulosMovil.busArticulo(cod);
        dlgGestTransferencias.txtCodArticulo.setText(String.valueOf(art.getIdproducto()));
        dlgGestTransferencias.txtArt.setText(art.getDescripcion());
        dlgGestTransferencias.txtCant.setText("1");
    }

    public static void selecArticuloTR()//Seleccionar Artículo
    {
        int x = dlgBuscarArticuloTransferencia.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloTransferencia.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulosMovil.busArticulo(cod);
        dlgGestTransferencias.txtCodArticulo.setText(String.valueOf(art.getIdproducto()));
        dlgGestTransferencias.txtArt.setText(art.getDescripcion());
        dlgGestTransferencias.txtCant.setText("1");
    }

    public static void selectCliente()//Seleccionar Cliente
    {
        int x = dlgBuscarCliente.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgVentas.txtCodCliente.setText(String.valueOf(cl.getIdCliente()));
        dlgVentas.txtRuc.setText((cl.getRuc()));
        dlgVentas.txtRazonS.setText(cl.getRazonSocial());
        if (cl.getSuper().equals("S")) {
            dlgVentas.lbSuper.setText(cl.getSuper());
            dlgVentas.lbDescripcionSupermercado.setText("SUPERMERCADO");
            dlgVentas.lbDescripcionSupermercado.setOpaque(true);
        } else if (cl.getSuper().equals("N")) {
            dlgVentas.lbSuper.setText(cl.getSuper());
            dlgVentas.lbDescripcionSupermercado.setText("");
            dlgVentas.lbDescripcionSupermercado.setOpaque(false);
        }
    }
    
    public static void selectCliente1()//Seleccionar Cliente
    {
        int x = dlgBuscarCliente1.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente1.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgReporteFacturasEmitidas.lbCodCliente.setText(String.valueOf(cl.getIdCliente()));
        dlgReporteFacturasEmitidas.lbRZ.setText("R.U.C. o C.I. NRO: "+(cl.getRuc())+"   RAZÓN SOCIAL: "+cl.getRazonSocial());
    }
    
    public static void selectCliente2()//Seleccionar Cliente
    {
        int x = dlgBuscarCliente2.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente2.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgReporteExtractoComprobantes.lbCodCliente.setText(String.valueOf(cl.getIdCliente()));
        dlgReporteExtractoComprobantes.lbRZ.setText("R.U.C. o C.I. NRO: "+(cl.getRuc())+"   RAZÓN SOCIAL: "+cl.getRazonSocial());
    }

    public static void selectClienteInicio(String cod)//Seleccionar Cliente
    {
        cl = GestionarCliente.busCliente(cod);
        dlgVentas.txtCodCliente.setText(String.valueOf(cl.getIdCliente()));
        dlgVentas.txtRuc.setText((cl.getRuc()));
        dlgVentas.txtRazonS.setText(cl.getRazonSocial());
        if (cl.getSuper().equals("S")) {
            dlgVentas.lbSuper.setText(cl.getSuper());
            dlgVentas.lbDescripcionSupermercado.setText("SUPERMERCADO");
            dlgVentas.lbDescripcionSupermercado.setOpaque(true);
        } else if (cl.getSuper().equals("N")) {
            dlgVentas.lbSuper.setText(cl.getSuper());
            dlgVentas.lbDescripcionSupermercado.setText("");
            dlgVentas.lbDescripcionSupermercado.setOpaque(false);
        }
    }

    public static int getExcetas() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 5)).replace(".", "").replace(",", ""));
        }
        return Redondeo.redondearI(total);
    }

    public static int get5Libre() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 6)).replace(".", "").replace(",", ""));
        }
        return total;
    }

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 6)).replace(".", "").replace(",", ""));
        }
        return Redondeo.redondearI(total / 21);
    }

    public static int get10() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 7)).replace(".", "").replace(",", ""));
        }
        return Redondeo.redondearI(total / 11);
    }

    public static int get10Libre() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 7)).replace(".", "").replace(",", ""));
        }
        return total;
    }

    public static int getTotal()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return /*Redondeo.redondearD*/ (total);
    }

    public static int getTotalVentasMoviles() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturasMovil.tbVentasMoviles.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            String activo = dlgConsultarFacturasMovil.tbVentasMoviles.getModel().getValueAt(i, 13).toString();
            if (!activo.equals("ANULADO")) {
                total += Integer.valueOf(String.valueOf(dlgConsultarFacturasMovil.tbVentasMoviles.getModel().getValueAt(i, 11)).replace(".", "").replace(",", ""));
            }
        }
        return (total);
    }

    public static int getTotalVentasMovilesA() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturasMovil.tbVentasMoviles.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            String activo = dlgConsultarFacturasMovil.tbVentasMoviles.getModel().getValueAt(i, 13).toString();
            if (activo.equals("ANULADO")) {
                total += Integer.valueOf(String.valueOf(dlgConsultarFacturasMovil.tbVentasMoviles.getModel().getValueAt(i, 11)).replace(".", "").replace(",", ""));
            }
        }
        return (total);
    }

    public static int getTotaltransferencia()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgGestTransferencias.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgGestTransferencias.tbDetalle.getModel().getValueAt(i, 5)).replace(".", "").replace(",", ""));
        }
        return /*Redondeo.redondearD*/ (total);
    }

    public static void insertarTransferencia(String cod, String codB, String desc, String prec, String cant, String total, JTable tabla) {
        String fila[] = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codB;
        fila[2] = desc;
        fila[3] = prec;
        fila[4] = cant;
        fila[5] = total;
        tb.addRow(fila);
    }

    public static void insertar(String cod, String codB, String desc, String cant, String prec, String total, int iva, JTable tabla) {
        String fila[] = new String[11];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codB;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = prec;
        switch (iva) {
            case 3 -> {
                fila[5] = "0";
                fila[6] = "0";
                fila[7] = total;
            }
            case 2 -> {
                fila[5] = "0";
                fila[6] = total;
                fila[7] = "0";
            }
            case 1 -> {
                fila[5] = total;
                fila[6] = "0";
                fila[7] = "0";
            }
        }
        fila[8] = total;
        fila[9] = String.valueOf(iva);
        fila[10] = String.valueOf(dlgVentas.tbDetalle.getRowCount()+1);
        tb.addRow(fila);
    }

    /*  public static double actStock() {
        int cant = Integer.parseInt(dlgVentas.txtCant.getText());
        return art.getStock() - cant;
    }*/
    public static void addmismoItemFactura(int fila, double cantTabla, int iva, double cantAdd, int precio) {
        try {
            double cantFinal = (cantTabla + cantAdd);
            int montoVenta = (int) (cantFinal * precio);

            dlgVentas.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 3);
            dlgVentas.tbDetalle.setValueAt(String.valueOf(precio), fila, 4);
            switch (iva) {
                case 3 -> {
                    dlgVentas.tbDetalle.setValueAt(String.valueOf("0"), fila, 5);
                    dlgVentas.tbDetalle.setValueAt(String.valueOf("0"), fila, 6);
                    dlgVentas.tbDetalle.setValueAt(String.valueOf(montoVenta), fila, 7);
                }
                case 2 -> {
                    dlgVentas.tbDetalle.setValueAt(String.valueOf("0"), fila, 5);
                    dlgVentas.tbDetalle.setValueAt(String.valueOf(montoVenta), fila, 6);
                    dlgVentas.tbDetalle.setValueAt(String.valueOf("0"), fila, 7);
                }
                case 1 -> {
                    dlgVentas.tbDetalle.setValueAt(String.valueOf(montoVenta), fila, 5);
                    dlgVentas.tbDetalle.setValueAt(String.valueOf("0"), fila, 6);
                    dlgVentas.tbDetalle.setValueAt(String.valueOf("0"), fila, 7);
                }
            }
            dlgVentas.tbDetalle.setValueAt(String.valueOf(montoVenta), fila, 8);
            dlgVentas.tbDetalle.setValueAt(String.valueOf(iva), fila, 9);
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void addmismoItemTransferencia(int fila, double cantTabla, double cantAdd, int precio) {
        try {
            double cantFinal = (cantTabla + cantAdd);
            int montoVenta = (int) (cantFinal * precio);
            dlgGestTransferencias.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 4);
            dlgGestTransferencias.tbDetalle.setValueAt(String.valueOf(precio), fila, 3);
            dlgGestTransferencias.tbDetalle.setValueAt(String.valueOf(montoVenta), fila, 5);
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void addTabla(JTable tabla) {
        try {
            //int f = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
            int codA = art.getIdproducto();
            String codB = art.getCodBarra();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgVentas.txtCant.getText().trim());
            int precio = 0;
            int monto = 0;
            if (dlgVentas.lbSuper.getText().trim().equals("S")) {
                precio = art.getPreciosupermercado();
                monto = (int) (cant * precio);
            } else if (dlgVentas.lbSuper.getText().trim().equals("N")) {
                if (art.getVentam().equals("SI")) {
                    if (cant < art.getCantm()) {
                        precio = art.getPreciominorista();
                        monto = (int) (cant * precio);
                    } else {
                        precio = art.getPrecio_venta();
                        monto = (int) (cant * precio);
                    }
                } else {
                    precio = art.getPreciominorista();
                    monto = (int) (cant * precio);
                }
            }
            int iva = art.getIva();
            DetalleFactura dfac = new DetalleFactura(codA);
            if (array.busca(dfac.getCodArticulo()) != -1) {
                int Nfila = array.busca(dfac.getCodArticulo());
                double cantTabla = Double.parseDouble(dlgVentas.tbDetalle.getValueAt(Nfila, 3).toString());
                if ((cantTabla + cant) <= 0) {
                    Mensajes.error("ERROR:\nAcabas de ingresar un número que dara como resultado: " + (cantTabla + cant));
                }
                if ((cantTabla + cant) > art.getStock()) {
                    Mensajes.error("ERROR:\nLa cantidad que estas intentando vender supera el stock actual del producto.");
                } else {
                    if (dlgVentas.lbSuper.getText().trim().equals("S")) {
                        precio = art.getPreciosupermercado();
                    } else if (dlgVentas.lbSuper.getText().trim().equals("N")) {
                        if (art.getVentam().equals("SI")) {
                            if (cantTabla + cant < art.getCantm()) {
                                precio = art.getPreciominorista();
                            } else {
                                precio = art.getPrecio_venta();
                            }
                        } else {
                            precio = art.getPreciominorista();
                        }
                    }
                    addmismoItemFactura(Nfila, cantTabla, iva, cant, precio);
                    String total = String.valueOf(getTotal());
                    String exentas = String.valueOf(getExcetas());
                    String iva5 = String.valueOf(get5());
                    String iva10 = String.valueOf(get10());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgVentas.txtExentaL.setText(exentas);
                    dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                    dlgVentas.txt5L.setText(iva5);
                    dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                    dlgVentas.txt5libre.setText(df.format(Integer.valueOf(String.valueOf(get5Libre()).replace(".", "").replace(",", ""))));
                    dlgVentas.txt10L.setText(iva10);
                    dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                    dlgVentas.txt10Libre.setText(df.format(Integer.valueOf(String.valueOf(get10Libre()).replace(".", "").replace(",", ""))));
                    dlgVentas.txtTotalL.setText(total);
                    dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                }
            } else {
                if (cant < 0) {
                    Mensajes.error("ERROR:\nAcabas de ingresar un número que dara como resultado: " + cant);
                } else {
                    array.agregar(dfac);
                    insertar(String.valueOf(codA), codB, desc, String.valueOf(cant), String.valueOf(precio), String.valueOf(monto), iva, tabla);
                    String total = String.valueOf(getTotal());
                    String exentas = String.valueOf(getExcetas());
                    String iva5 = String.valueOf(get5());
                    String iva10 = String.valueOf(get10());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgVentas.txtExentaL.setText(exentas);
                    dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                    dlgVentas.txt5L.setText(iva5);
                    dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                    dlgVentas.txt5libre.setText(df.format(Integer.valueOf(String.valueOf(get5Libre()).replace(".", "").replace(",", ""))));
                    dlgVentas.txt10L.setText(iva10);
                    dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                    dlgVentas.txt10Libre.setText(df.format(Integer.valueOf(String.valueOf(get10Libre()).replace(".", "").replace(",", ""))));
                    dlgVentas.txtTotalL.setText(total);
                    dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                }
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL AGREGAR ARTICULO: " + e.getMessage().toUpperCase());
        }
    }

    public static void addTablaTR(JTable tabla) {
        try {
            //int f = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
            int codA = art.getIdproducto();
            String codB = art.getCodinterno();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgGestTransferencias.txtCant.getText().trim());
            int precio;
            int monto;
            precio = art.getPrecio_venta();
            monto = (int) (cant * precio);
            DetalleTransferencia dtrans = new DetalleTransferencia(codA);
            if (arrayT.busca(dtrans.getCodArticulo()) != -1) {
                int Nfila = arrayT.busca(dtrans.getCodArticulo());
                double cantTabla = Double.parseDouble(dlgGestTransferencias.tbDetalle.getValueAt(Nfila, 4).toString());
                if ((cantTabla + cant) <= 0) {
                    Mensajes.error("ERROR:\nAcabas de ingresar un número que dara como resultado: " + (cantTabla + cant));
                } else {
                    precio = art.getPrecio_venta();
                    addmismoItemTransferencia(Nfila, cantTabla, cant, precio);
                    String total = String.valueOf(getTotaltransferencia());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgGestTransferencias.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                }
            } else {
                if (cant < 0) {
                    Mensajes.error("ERROR:\nAcabas de ingresar un número que dara como resultado: " + cant);
                } else {
                    arrayT.agregar(dtrans);
                    insertarTransferencia(String.valueOf(codA), codB, desc, String.valueOf(precio), String.valueOf(cant), String.valueOf(monto), tabla);
                    String total = String.valueOf(getTotaltransferencia());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgGestTransferencias.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                }
            }
            BloquearOrigen();
        } catch (Exception e) {
            Mensajes.error("ERROR AL AGREGAR ARTICULO: " + e.getMessage().toUpperCase());
        }
    }

    public static void addTablaT(JTable tabla) {
        try {
            //int f = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
            int codA = art.getIdproducto();
            String codB = art.getCodinterno();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgGestTransferencias.txtCant.getText().trim());
            int precio;
            int monto;
            precio = art.getPrecio_venta();
            monto = (int) (cant * precio);
            DetalleTransferencia dtrans = new DetalleTransferencia(codA);
            if (arrayT.busca(dtrans.getCodArticulo()) != -1) {
                int Nfila = arrayT.busca(dtrans.getCodArticulo());
                double cantTabla = Double.parseDouble(dlgGestTransferencias.tbDetalle.getValueAt(Nfila, 4).toString());
                if ((cantTabla + cant) <= 0) {
                    Mensajes.error("ERROR:\nAcabas de ingresar un número que dara como resultado: " + (cantTabla + cant));
                } else if ((cantTabla + cant) > art.getStock()) {
                    Mensajes.error("ERROR:\nLa cantidad que estas intentando Transferir supera el stock actual del producto.");
                } else {
                    precio = art.getPrecio_venta();
                    addmismoItemTransferencia(Nfila, cantTabla, cant, precio);
                    String total = String.valueOf(getTotaltransferencia());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgGestTransferencias.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                }
            } else {
                if (cant < 0) {
                    Mensajes.error("ERROR:\nAcabas de ingresar un número que dara como resultado: " + cant);
                } else {
                    arrayT.agregar(dtrans);
                    insertarTransferencia(String.valueOf(codA), codB, desc, String.valueOf(precio), String.valueOf(cant), String.valueOf(monto), tabla);
                    String total = String.valueOf(getTotaltransferencia());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgGestTransferencias.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                }
            }
            BloquearOrigen();
        } catch (Exception e) {
            Mensajes.error("ERROR AL AGREGAR ARTICULO: " + e.getMessage().toUpperCase());
        }
    }

    public static void consLinea()//Buscar linea en ArrayList
    {
        int fila = dlgVentas.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Articulo no existe");
        } else {
            dfa = array.getFila(p);
            int codA = dfa.getCodArticulo();
        }
    }

    public static void consLineaT()//Buscar linea en ArrayList
    {
        int fila = dlgGestTransferencias.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgGestTransferencias.tbDetalle.getValueAt(fila, 0).toString());
        int p = arrayT.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Articulo no existe");
        } else {
            dtran = arrayT.getFila(p);
            int codA = dtran.getCodArticulo();
        }
    }

    public static void delRenglon(JTable tabla)//Quita un renglon del detalle
    {
        consLinea();
        int fila = dlgVentas.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtExentaL.setText(exentas);
                dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txt5L.setText(iva5);
                dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                dlgVentas.txt5libre.setText(df.format(Integer.valueOf(String.valueOf(get5Libre()).replace(".", "").replace(",", ""))));
                dlgVentas.txt10L.setText(iva10);
                dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                dlgVentas.txt10Libre.setText(df.format(Integer.valueOf(String.valueOf(get10Libre()).replace(".", "").replace(",", ""))));
                dlgVentas.txtTotalL.setText(total);
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
            }
        }
    }

    public static void delRenglonT(JTable tabla)//Quita un renglon del detalle
    {
        consLineaT();
        int fila = dlgGestTransferencias.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgGestTransferencias.tbDetalle.getValueAt(fila, 0).toString());
        int p = arrayT.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                arrayT.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(getTotaltransferencia());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgGestTransferencias.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                BloquearOrigen();
            }
        }
    }

    public static int calCulos()//Metodo que realiza los calculos finales de la venta
    {
        int total = Integer.parseInt(dlgVentas.txtTotal.getText().replace(".", "").replace(",", ""));
        int abono = Integer.parseInt(dlgVentas.txtAbono.getText().replace(".", "").replace(",", ""));
        int vuelto = abono - total;
        return /*Redondeo.redondearI*/ (vuelto);
    }

    public static void canCelar()//Cancelar la venta y vaciar ArrayList
    {
        array.vaciar();
    }

    public static void canCelarT()//Cancelar la venta y vaciar ArrayList
    {
        arrayT.vaciar();
    }

    public static void listFacturas(JTable tabla)//Lista las facturas realizadas
    {
        try {
            HttpClient facturas = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonFacturas = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonFacturas.length(); f++) {
                                Object[] fila = new Object[12];
                                fila[0] = jsonFacturas.getJSONObject("" + f + "").get("fac_codigo").toString();
                                fila[1] = jsonFacturas.getJSONObject("" + f + "").get("razon_social").toString();
                                fila[2] = jsonFacturas.getJSONObject("" + f + "").get("fac_fecha").toString();
                                fila[3] = jsonFacturas.getJSONObject("" + f + "").get("fac_hora").toString();
                                fila[4] = jsonFacturas.getJSONObject("" + f + "").get("idcliente").toString();
                                fila[5] = jsonFacturas.getJSONObject("" + f + "").get("caja_ca_id").toString();
                                fila[6] = jsonFacturas.getJSONObject("" + f + "").get("fac_factura").toString();
                                fila[7] = jsonFacturas.getJSONObject("" + f + "").get("fac_tipoventa").toString();
                                fila[8] = jsonFacturas.getJSONObject("" + f + "").get("estado").toString();
                                fila[9] = jsonFacturas.getJSONObject("" + f + "").get("fac_totalfinal").toString();
                                fila[10] = jsonFacturas.getJSONObject("" + f + "").get("ven_codigo").toString();
                                if (jsonFacturas.getJSONObject("" + f + "").get("fac_indicador").toString().equals("S")) {
                                    fila[11] = "";
                                } else if (jsonFacturas.getJSONObject("" + f + "").get("fac_indicador").toString().equals("N")) {
                                    fila[11] = "ANULADO";
                                }
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            facturas.excecute(urlServer() + "getlistFacturas.php");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listFacturasMoviles(JTable tabla, String fecha)//Lista las facturas realizadas
    {
        System.out.println(fecha);
        try {
            HttpClient facturasm = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonFacturasm = new JSONObject(status.getResult());
                            for (int f = 0; /*f < jsonFacturasm.length()*/; f++) {
                                Object[] fila = new Object[17];
                                fila[0] = jsonFacturasm.getJSONObject("" + f + "").get("id").toString();
                                fila[1] = jsonFacturasm.getJSONObject("" + f + "").get("idemision").toString();
                                fila[2] = jsonFacturasm.getJSONObject("" + f + "").get("timbra").toString();
                                fila[3] = jsonFacturasm.getJSONObject("" + f + "").get("fechadesde").toString();
                                fila[4] = jsonFacturasm.getJSONObject("" + f + "").get("fechahasta").toString();
                                fila[5] = jsonFacturasm.getJSONObject("" + f + "").get("estable").toString() + "-" + jsonFacturasm.getJSONObject("" + f + "").get("pexp").toString() + "-" + jsonFacturasm.getJSONObject("" + f + "").get("factura").toString();
                                fila[6] = jsonFacturasm.getJSONObject("" + f + "").get("condicion").toString();
                                fila[7] = /*Fecha.formatoFechaDd*/(jsonFacturasm.getJSONObject("" + f + "").get("fecha").toString());
                                fila[8] = jsonFacturasm.getJSONObject("" + f + "").get("hora").toString();
                                fila[9] = jsonFacturasm.getJSONObject("" + f + "").get("ruc").toString();
                                fila[10] = jsonFacturasm.getJSONObject("" + f + "").get("razon_social").toString();
                                fila[11] = jsonFacturasm.getJSONObject("" + f + "").get("totalfinal").toString();
                                fila[12] = jsonFacturasm.getJSONObject("" + f + "").get("nombre").toString();
                                if (jsonFacturasm.getJSONObject("" + f + "").get("estado").toString().equals("S")) {
                                    fila[13] = "";
                                } else {
                                    fila[13] = "ANULADO";
                                }
                                fila[14] = jsonFacturasm.getJSONObject("" + f + "").get("exenta").toString();
                                fila[15] = jsonFacturasm.getJSONObject("" + f + "").get("iva5").toString();
                                fila[16] = jsonFacturasm.getJSONObject("" + f + "").get("iva10").toString();
                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            facturasm.excecute(urlServer() + "getlistFacturasMovil.php?fecha=%20"+fecha+"%20");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void listVentasCabeceras(JTable tabla, String fechaD, String fechaH)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listVentasCabeceras(fechaD, fechaH);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1] = fila[1].toString() + "-" + fila[2].toString();
            fila[2] = Fecha.formatoFechaVMRInverter(fila[3].toString());
            fila[3] = fila[4].toString();
            if (fila[5].toString().equals("CONTADO")) {
                fila[4] = "1";
            } else {
                fila[4] = "2";
            }
            fila[5] = fila[6].toString();
            fila[6] = "1";
            tb.addRow(fila);
        }
    }

    public static void listFacturasMovilesT(JTable tabla, String idT, String fecha)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listFacturasMovilesT(idT, fecha);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5] = fila[5].toString() + "-" + fila[6].toString() + "-" + fila[7].toString();
            fila[6] = fila[8].toString();
            fila[7] = fila[9].toString();
            fila[8] = fila[10].toString();
            fila[9] = fila[11].toString();
            fila[10] = fila[12].toString();
            fila[11] = fila[13].toString();
            fila[12] = fila[14].toString();
            //fila[10].toString();
            if (fila[15].toString().equals("S")) {
                fila[13] = "";
            } else {
                fila[13] = "ANULADO";
            }
            fila[14] = fila[16].toString();
            fila[15] = fila[17].toString();
            fila[16] = fila[18].toString();
            tb.addRow(fila);
        }
    }

    public static void listFacturasMovilesTPE(JTable tabla, String idT, String idPE, String fecha)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listFacturasMovilesTPE(idPE, idT, fecha);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5] = fila[5].toString() + "-" + fila[6].toString() + "-" + fila[7].toString();
            fila[6] = fila[8].toString();
            fila[7] = fila[9].toString();
            fila[8] = fila[10].toString();
            fila[9] = fila[11].toString();
            fila[10] = fila[12].toString();
            fila[11] = fila[13].toString();
            fila[12] = fila[14].toString();
            //fila[10].toString();
            if (fila[15].toString().equals("S")) {
                fila[13] = "";
            } else {
                fila[13] = "ANULADO";
            }
            fila[14] = fila[16].toString();
            fila[15] = fila[17].toString();
            fila[16] = fila[18].toString();
            tb.addRow(fila);
        }
    }

    public static void listDetalleVentasMoviles(JTable tabla)//Lista el detalle de la factura seleccionada
    {
        int x = dlgConsultarFacturasMovil.tbVentasMoviles.getSelectedRow();
        String cod = dlgConsultarFacturasMovil.tbVentasMoviles.getValueAt(x, 0).toString();
        String idemision = dlgConsultarFacturasMovil.tbVentasMoviles.getValueAt(x, 1).toString();
        try {
            HttpClient facturas = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonFacturas = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonFacturas.length(); f++) {
                                Object[] fila = new Object[12];
                                fila[0] = jsonFacturas.getJSONObject("" + f + "").get("cod_interno").toString();
                                fila[1] = jsonFacturas.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[2] = jsonFacturas.getJSONObject("" + f + "").get("producto").toString();
                                fila[3] = jsonFacturas.getJSONObject("" + f + "").get("cant").toString();
                                fila[4] = jsonFacturas.getJSONObject("" + f + "").get("precio").toString();
                                fila[5] = jsonFacturas.getJSONObject("" + f + "").get("total").toString();
                                fila[6] = jsonFacturas.getJSONObject("" + f + "").get("impuesto_aplicado").toString();
                                fila[7] = jsonFacturas.getJSONObject("" + f + "").get("um").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            facturas.excecute(urlServer() + "getlistDetalleMovil.php?cod=%20"+cod+"%20&idemision=%20"+idemision+"%20");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listFacturasCredito(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listFacturasCredito(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendiente(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendiente(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoActivo(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listFacturasCreditoActivo(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendienteActivo(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendienteActivo(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturas2(JTable tabla)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.lisFacturas2();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            tb.addRow(fila);
        }
    }

    public static void listDetalle(JTable tabla)//Lista el detalle de la factura seleccionada
    {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        // String fecha = dlgConsultarFacturas.tblFactura.getValueAt(x, 2).toString();
        //String des = dlgConsultarFacturas.tblFactura.getValueAt(x, 4).toString();
        // String total = dlgConsultarFacturas.tblFactura.getValueAt(x, 5).toString();
        try {
            HttpClient facturas = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                            JSONObject jsonFacturas = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonFacturas.length(); f++) {
                                Object[] fila = new Object[12];
                                fila[0] = jsonFacturas.getJSONObject("" + f + "").get("ven_cantidad").toString();
                                fila[1] = jsonFacturas.getJSONObject("" + f + "").get("articulo_art_codigo").toString();
                                fila[2] = jsonFacturas.getJSONObject("" + f + "").get("cod_barra").toString();
                                fila[3] = jsonFacturas.getJSONObject("" + f + "").get("descripcion").toString();
                                fila[4] = jsonFacturas.getJSONObject("" + f + "").get("ven_precio").toString();
                                fila[5] = jsonFacturas.getJSONObject("" + f + "").get("ven_total").toString();

                                tb.addRow(fila);
                            }

                        } catch (JSONException e) {
                        }
                    }
                }
            });

            facturas.excecute(urlServer() + "getlistDetalle.php?cod=" + cod);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void ListClientes()//Mostrar informacion del cliente
    {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 4).toString();
        ClienteMovil c = GestionarCliente.busCliente(cod);
        dlgConsultarFacturas.txtCodCliente.setText(String.valueOf(c.getIdCliente()));
        dlgConsultarFacturas.txtRazonSocial.setText(c.getRazonSocial());
        dlgConsultarFacturas.txtRuc.setText(c.getRuc());
    }

    public static void selecVendedor()//Seleccionar Vendedor
    {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 10).toString();
        Vendedor ven = GestionarVendedor.busVendedor(cod);
        dlgConsultarFacturas.txtVendedor.setText(ven.getNombreV());
    }

    public static void fillCliente(JTable tabla, String nom) {
        List lista;
        lista = GestionarFactura.fillCliente(nom);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static String anularFactura(String cod)//Metodo para anular facturas
    {
        String msg;
        //int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        //String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarFactura.actFactura(cod, usuario);
        if (msg.equals("OK")) {
            Mensajes.informacion("Venta Anulada");
            controlFactura.actStockEliminarFactura();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String anularVentaMovil()//Metodo para anular facturas
    {
        String msg;
        int x = dlgConsultarFacturasMovil.tbVentasMoviles.getSelectedRow();
        String cod = dlgConsultarFacturasMovil.tbVentasMoviles.getValueAt(x, 0).toString();
        String idemision = dlgConsultarFacturasMovil.tbVentasMoviles.getValueAt(x, 1).toString();
        //String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarFactura.actFacturaMovil(cod, idemision);
        if (msg.equals("OK")) {
            Mensajes.informacion("Venta Móvil Anulada");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarFactura() {
        String msg = null;
        int f = dlgConsultarFacturas.tblDetalle.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarFacturas.tblDetalle.getValueAt(i, 1).toString());
            double stK = Double.parseDouble(dlgConsultarFacturas.tblDetalle.getValueAt(i, 0).toString());
            ArticuloMovil a = new ArticuloMovil(coda, stK);
            msg = GestionarArticulosMovil.actStockMAS(a);
        }
        if (msg.equals("OK")) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void actCantidad(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            String cod = (tabla.getValueAt(fila, 0).toString());
            double ca = Double.parseDouble(tabla.getValueAt(fila, 3).toString());
            int pre = 0;
            int monto = 0;
            double cant = (Mensajes.ingresarNumerosV(cod, ca));
            ArticuloMovil ar = GestionarArticulosMovil.busArticulo(cod);
            if (dlgVentas.lbSuper.getText().trim().equals("S")) {
                pre = ar.getPreciosupermercado();
                monto = (int) (cant * pre);
            } else if (dlgVentas.lbSuper.getText().trim().equals("N")) {
                if (ar.getVentam().equals("SI")) {
                    if (cant < ar.getCantm()) {
                        pre = ar.getPreciominorista();
                        monto = (int) (cant * pre);
                    } else {
                        pre = ar.getPrecio_venta();
                        monto = (int) (cant * pre);
                    }
                } else {
                    pre = ar.getPreciominorista();
                    monto = (int) (cant * pre);
                }
            }
            tabla.setValueAt(String.valueOf(cant), fila, 3);
            tabla.setValueAt(String.valueOf(pre), fila, 4);
            int iva = Integer.parseInt(tabla.getValueAt(fila, 9).toString());

            switch (iva) {
                case 3 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 7);
                }
                case 2 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 6);
                }
                case 1 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 5);
                }
            }

            tabla.setValueAt(String.valueOf(monto), fila, 8);

            //int Gan = CalcGanancia();
            //dlgCompras1.tbDetalle.setValueAt(String.valueOf(Gan), fila, 16);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgVentas.txtExentaL.setText(exentas);
            dlgVentas.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txt5L.setText(iva5);
            dlgVentas.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgVentas.txt10L.setText(iva10);
            dlgVentas.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgVentas.txtTotalL.setText(total);
            dlgVentas.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

}
