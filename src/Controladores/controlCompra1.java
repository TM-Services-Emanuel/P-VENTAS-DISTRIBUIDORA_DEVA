package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Datos.ArregloCompras;
import Datos.GestionarArticulos;
import Datos.GestionarArticulosMovil;
import Datos.GestionarCompra;
import Datos.GestionarProveedor;
import IU.dlgBuscarArticuloCompra1;
import IU.dlgBuscarProveedor;
import IU.dlgCompras1;
import IU.dlgConsultarCompras;
import IU.dlgConsultarCompras1;
import IU.dlgPagoCompra;
import IU.dlgPagoComprasCredito;
import IU.dlgPagoVentasCredito;
import IU.dlgRegistrarPagosCompras;
import IU.dlgRegistrarPagosFacturas;
import Modelo.Articulo;
import Modelo.ArticuloMovil;
import Modelo.DetalleCompra;
import Modelo.Proveedor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Componentes.Fecha;
import IU.dlgBuscarProveedor1;
import IU.dlgReporteComprasRealizadas;

public class controlCompra1 {

    static Proveedor prov;
    static ArticuloMovil art;
    static DetalleCompra dc;
    public static ArregloCompras array = new ArregloCompras();
    public static int costo;
    public static int costo2;
    public static double costoiva;
    //public static int ganancia;
    public static int descuento;
    static String UsuarioL = "";

    public static void selectProveedor() {
        int x = dlgBuscarProveedor.tbDetalle.getSelectedRow();
        String cod = dlgBuscarProveedor.tbDetalle.getValueAt(x, 0).toString();
        prov = GestionarProveedor.busProveedor(cod);
        dlgCompras1.txtCodProv.setText(String.valueOf(prov.getCodP()));
        dlgCompras1.txtRazonS.setText(prov.getRazoS());
        dlgCompras1.txtRuc.setText(prov.getRuc());
    }
    
    public static void selectProveedor1() {
        int x = dlgBuscarProveedor1.tbDetalle.getSelectedRow();
        String cod = dlgBuscarProveedor1.tbDetalle.getValueAt(x, 0).toString();
        prov = GestionarProveedor.busProveedor(cod);
        dlgReporteComprasRealizadas.lbCodCliente.setText(String.valueOf(prov.getCodP()));
        dlgReporteComprasRealizadas.lbRZ.setText("R.U.C. o C.I. NRO: "+(prov.getRuc())+"   RAZÓN SOCIAL: "+prov.getRazoS());
    }

    public static void selectArticulo() {
        int x = dlgBuscarArticuloCompra1.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloCompra1.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulosMovil.busArticulo(cod);
        dlgCompras1.txtCodA.setText(String.valueOf(art.getIdproducto()));
        dlgCompras1.txtArt.setText(art.getDescripcion());
        //dlgCompras1.txtCant.setText("1");
        String PC = String.valueOf(art.getPrecio_costo());
        DecimalFormat df = new DecimalFormat("#,###");
        dlgCompras1.txtCosto.setText((df.format(Integer.parseInt(PC.trim().replace(".", "").replace(",", "")))));
        dlgCompras1.txtCostoL.setText(PC);

    }

    public static int getExcetas() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras1.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras1.tbDetalle.getModel().getValueAt(i, 9)));
        }
        return (total);
    }

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras1.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras1.tbDetalle.getModel().getValueAt(i, 11)));
        }
        return Redondeo.redondearI(total / 21);
    }

    public static int get10() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras1.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras1.tbDetalle.getModel().getValueAt(i, 13)));
        }
        return Redondeo.redondearI(total / 11);
    }

    public static int getTotal() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras1.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras1.tbDetalle.getModel().getValueAt(i, 15)));
        }
        return (total);
    }

    public static int getTotalPagadoCompra() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgPagoCompra.tbDetallePago.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgPagoCompra.tbDetallePago.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return (total);
    }
    
    public static int getTotalPagadoComprasCredito() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgPagoComprasCredito.tbDetallePago.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgPagoComprasCredito.tbDetallePago.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return (total);
    }
    
    public static int getTotalPagadoVentasCredito() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgPagoVentasCredito.tbDetallePago.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgPagoVentasCredito.tbDetallePago.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int CalcGananciaMayorista() {
        int gananciaMayorista = 0;
        try {
            int precio;
            precio = art.getPrecio_venta();
            if (precio == 0) {
                gananciaMayorista = 0;
            } else {
                gananciaMayorista = precio - costo;
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Ganancia Mayorista: " + e.getMessage());
        }
        return gananciaMayorista;
    }

    private static double calcularPorMayorista() {
        double val2 = 0;
        try {
            double ganancia = CalcGananciaMayorista();
            double porc = ((ganancia * 100.0) / costo);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            val2 = bd.doubleValue();

        } catch (Exception e) {
            Mensajes.error("Error al calcular Porcentaje de Ganancia Mayorista: " + e.getMessage());
        }
        return val2;
    }
    
    public static int CalcGananciaMinorista() {
        int gananciaMinorista = 0;
        try {
            int precio;
            precio = art.getPreciominorista();
            if (precio == 0) {
                gananciaMinorista = 0;
            } else {
                gananciaMinorista = precio - costo;
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Ganancia Minorista: " + e.getMessage());
        }
        return gananciaMinorista;
    }

    private static double calcularPorMinorista() {
        double val2 = 0;
        try {
            double ganancia = CalcGananciaMinorista();
            double porc = ((ganancia * 100.0) / costo);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            val2 = bd.doubleValue();

        } catch (Exception e) {
            Mensajes.error("Error al calcular Porcentaje de Ganancia Minorista: " + e.getMessage());
        }
        return val2;
    }
    
    public static int CalcGananciaSupermercado() {
        int gananciaSupermercado = 0;
        try {
            int precio;
            precio = art.getPreciosupermercado();
            if (precio == 0) {
                gananciaSupermercado = 0;
            } else {
                gananciaSupermercado = precio - costo;
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Ganancia Supermercado: " + e.getMessage());
        }
        return gananciaSupermercado;
    }

    private static double calcularPorSupermercado() {
        double val2 = 0;
        try {
            double ganancia = CalcGananciaSupermercado();
            double porc = ((ganancia * 100.0) / costo);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            val2 = bd.doubleValue();

        } catch (Exception e) {
            Mensajes.error("Error al calcular Porcentaje de Ganancia Supermercado: " + e.getMessage());
        }
        return val2;
    }
    
    public static int CalcGananciaMayorista2() {
        int gananciaMayorista = 0;
        try {
            int precio;
            precio = art.getPrecio_venta();
            if (precio == 0) {
                gananciaMayorista = 0;
            } else {
                gananciaMayorista = precio - costo2;
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Ganancia Mayorista: " + e.getMessage());
        }
        return gananciaMayorista;
    }

    private static double calcularPorMayorista2() {
        double val2 = 0;
        try {
            double ganancia = CalcGananciaMayorista2();
            double porc = ((ganancia * 100.0) / costo2);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            val2 = bd.doubleValue();

        } catch (Exception e) {
            Mensajes.error("Error al calcular Porcentaje de Ganancia Mayorista: " + e.getMessage());
        }
        return val2;
    }
    
    public static int CalcGananciaMinorista2() {
        int gananciaMinorista = 0;
        try {
            int precio;
            precio = art.getPreciominorista();
            if (precio == 0) {
                gananciaMinorista = 0;
            } else {
                gananciaMinorista = precio - costo2;
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Ganancia Minorista: " + e.getMessage());
        }
        return gananciaMinorista;
    }

    private static double calcularPorMinorista2() {
        double val2 = 0;
        try {
            double ganancia = CalcGananciaMinorista2();
            double porc = ((ganancia * 100.0) / costo2);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            val2 = bd.doubleValue();

        } catch (Exception e) {
            Mensajes.error("Error al calcular Porcentaje de Ganancia Minorista: " + e.getMessage());
        }
        return val2;
    }
    
    public static int CalcGananciaSupermercado2() {
        int gananciaSupermercado = 0;
        try {
            int precio;
            precio = art.getPreciosupermercado();
            if (precio == 0) {
                gananciaSupermercado = 0;
            } else {
                gananciaSupermercado = precio - costo2;
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Ganancia Supermercado: " + e.getMessage());
        }
        return gananciaSupermercado;
    }

    private static double calcularPorSupermercado2() {
        double val2 = 0;
        try {
            double ganancia = CalcGananciaSupermercado2();
            double porc = ((ganancia * 100.0) / costo2);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            val2 = bd.doubleValue();

        } catch (Exception e) {
            Mensajes.error("Error al calcular Porcentaje de Ganancia Supermercado: " + e.getMessage());
        }
        return val2;
    }

    public static void insertar(String cod, String codI, String desc, String cant, String prec, String total, int iva, String GAMA, String PORMA, String GAMI, String PORMI, String GASU, String PORSU, JTable tabla) {

        String fila[] = new String[22];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codI;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = cant;
        fila[5] = prec;
        fila[6] = prec;
        fila[7] = String.valueOf(iva);
        switch (iva) {
            case 10 -> {
                fila[8] = "0";
                fila[9] = "0";
                fila[10] = "0";
                fila[11] = "0";
                fila[12] = total;
                fila[13] = total;
            }
            case 5 -> {
                fila[8] = "0";
                fila[9] = "0";
                fila[10] = total;
                fila[11] = total;
                fila[12] = "0";
                fila[13] = "0";
            }
            default -> {
                fila[8] = total;
                fila[9] = total;
                fila[10] = "0";
                fila[11] = "0";
                fila[12] = "0";
                fila[13] = "0";
            }
        }
        fila[14] = total;
        fila[15] = total;
        fila[16] = GAMA;
        fila[17] = PORMA;
        fila[18] = GAMI;
        fila[19] = PORMI;
        fila[20] = GASU;
        fila[21] = PORSU;
        tb.addRow(fila);
    }

    public static void addTabla(JTable tabla) {
        try {
            int codA = art.getIdproducto();
            String codI = art.getCodinterno();
            String desc = art.getDescripcion();
            double cant = Double.parseDouble(dlgCompras1.txtCant.getText());
            costo = Integer.valueOf(dlgCompras1.txtCostoL.getText());
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
            int GAMA = CalcGananciaMayorista();
            double PORMA = calcularPorMayorista();
            int GAMI = CalcGananciaMinorista();
            double PORMI = calcularPorMinorista();
            int GASU = CalcGananciaSupermercado();
            double PORSU = calcularPorSupermercado();
            DetalleCompra dco = new DetalleCompra(codA);
            if (array.busca(dco.getCodArticulo()) != -1) {
                int Nfila = array.busca(dco.getCodArticulo());
                double cantTabla = Double.parseDouble(dlgCompras1.tbDetalle.getValueAt(Nfila, 4).toString());
                System.out.println("fila: " + Nfila + " ** cantidad en tabla: " + cantTabla + " ** cantidad a agregar: " + cant + " ** iva: " + iva);
                addmismoItem(Nfila, cantTabla, cant, costo, iva);

            } else {
                array.agregar(dco);
                insertar(String.valueOf(codA), codI, desc, String.valueOf(cant), String.valueOf(costo), String.valueOf(mont), iva, String.valueOf(GAMA),String.valueOf(PORMA),String.valueOf(GAMI),String.valueOf(PORMI),String.valueOf(GASU),String.valueOf(PORSU), tabla);
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgCompras1.txtExentaL.setText(exentas);
                dlgCompras1.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                dlgCompras1.txt5L.setText(iva5);
                dlgCompras1.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                dlgCompras1.txt10L.setText(iva10);
                dlgCompras1.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                dlgCompras1.txtTotalL.setText(total);
                dlgCompras1.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void addTablaPagoCompra(JTable tabla) {
        try {
            int idCompra = Integer.parseInt(dlgCompras1.txtCod.getText().trim());
            int idCaja = Integer.parseInt(dlgCompras1.txtCaja.getText().trim());
            String Pago = null;
            String Banco = null;
            String idBanco = null;
            String NroCuenta = null;
            String NroCheque = null;
            String fechaPago = null;
            if (dlgPagoCompra.rbEfectivo.isSelected()) {
                Pago = "EFECTIVO";
                Banco = "";
                idBanco = "";
                NroCheque = "";
                NroCuenta = "";
                fechaPago = "";
            } else if (dlgPagoCompra.rbCheque.isSelected()) {
                Pago = "CHEQUE";
                Banco = dlgPagoCompra.cboBanco.getSelectedItem().toString();
                idBanco = dlgPagoCompra.lbIDBanco.getText().trim();
                NroCheque = dlgPagoCompra.txtNroCheque.getText().trim();
                NroCuenta = dlgPagoCompra.txtNroCuenta.getText().trim();
                fechaPago = dlgPagoCompra.txtFechaPago.getText().trim();
            }
            String RS = null;
            String RUC = null;
            if (dlgPagoCompra.cbTitular.isSelected()) {
                RS = dlgPagoCompra.txtRS.getText().trim();
                RUC = dlgPagoCompra.txtRUC.getText().trim();
            } else {
                RS = "";
                RUC = "";
            }
            int Monto = Integer.parseInt(dlgPagoCompra.txtMonto.getText().trim().replace(".", "").replace(",", ""));
            insertarPagoCompra(idCompra, idCaja, Pago, Banco, idBanco, NroCuenta, NroCheque, fechaPago, Monto, RS, RUC, tabla);
            String total = String.valueOf(getTotalPagadoCompra());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgPagoCompra.lbPagado.setText(df.format(Integer.parseInt(total)));
            dlgPagoCompra.Renders();
            dlgPagoCompra.CalcularDif();
            dlgPagoCompra.LimpiarCampos();
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }
    
    public static void addTablaPagoComprasCredito(JTable tabla) {
        try {
            //int idCompra = Integer.parseInt(dlgCompras1.txtCod.getText().trim());
            int idCaja = Integer.parseInt(dlgRegistrarPagosCompras.txtCaja.getText().trim());
            String Pago = null;
            String Banco = null;
            String idBanco = null;
            String NroCuenta = null;
            String NroCheque = null;
            String fechaPago = null;
            if (dlgPagoComprasCredito.rbEfectivo.isSelected()) {
                Pago = "EFECTIVO";
                Banco = "";
                idBanco = "";
                NroCheque = "";
                NroCuenta = "";
                fechaPago = "";
            } else if (dlgPagoComprasCredito.rbCheque.isSelected()) {
                Pago = "CHEQUE";
                Banco = dlgPagoComprasCredito.cboBanco.getSelectedItem().toString();
                idBanco = dlgPagoComprasCredito.lbIDBanco.getText().trim();
                NroCheque = dlgPagoComprasCredito.txtNroCheque.getText().trim();
                NroCuenta = dlgPagoComprasCredito.txtNroCuenta.getText().trim();
                fechaPago = Fecha.formatoFechaDd_inver(dlgPagoVentasCredito.txtFechaPago.getText().trim());
            }
            String RS = null;
            String RUC = null;
            if (dlgPagoComprasCredito.cbTitular.isSelected()) {
                RS = dlgPagoComprasCredito.txtRS.getText().trim();
                RUC = dlgPagoComprasCredito.txtRUC.getText().trim();
            } else {
                RS = "";
                RUC = "";
            }
            int Monto = Integer.parseInt(dlgPagoComprasCredito.txtMonto.getText().trim().replace(".", "").replace(",", ""));
            insertarPagoComprasCredito(idCaja, Pago, Banco, idBanco, NroCuenta, NroCheque, fechaPago, Monto, RS, RUC, tabla);
            String total = String.valueOf(getTotalPagadoComprasCredito());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgPagoComprasCredito.lbPagado.setText(df.format(Integer.parseInt(total)));
            dlgPagoComprasCredito.Renders();
            dlgPagoComprasCredito.CalcularDif();
            dlgPagoComprasCredito.LimpiarCampos();
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }
    
    public static void addTablaPagoVentasCredito(JTable tabla) {
        try {
            //int idCompra = Integer.parseInt(dlgCompras1.txtCod.getText().trim());
            int idCaja = Integer.parseInt(dlgRegistrarPagosFacturas.txtCaja.getText().trim());
            String Pago = null;
            String Banco = null;
            String idBanco = null;
            String NroCuenta = null;
            String NroCheque = null;
            String fechaPago = null;
            if (dlgPagoVentasCredito.rbEfectivo.isSelected()) {
                Pago = "EFECTIVO";
                Banco = "";
                idBanco = "";
                NroCheque = "";
                NroCuenta = "";
                fechaPago = "";
            } else if (dlgPagoVentasCredito.rbCheque.isSelected()) {
                Pago = "CHEQUE";
                Banco = dlgPagoVentasCredito.cboBanco.getSelectedItem().toString();
                idBanco = dlgPagoVentasCredito.lbIDBanco.getText().trim();
                NroCheque = dlgPagoVentasCredito.txtNroCheque.getText().trim();
                NroCuenta = dlgPagoVentasCredito.txtNroCuenta.getText().trim();
                fechaPago = Fecha.formatoFechaDd_inver(dlgPagoVentasCredito.txtFechaPago.getText().trim());
            }
            String RS = null;
            String RUC = null;
            if (dlgPagoVentasCredito.cbTitular.isSelected()) {
                RS = dlgPagoVentasCredito.txtRS.getText().trim();
                RUC = dlgPagoVentasCredito.txtRUC.getText().trim();
            } else {
                RS = "";
                RUC = "";
            }
            int Monto = Integer.parseInt(dlgPagoVentasCredito.txtMonto.getText().trim().replace(".", "").replace(",", ""));
            insertarPagoVentasCredito(idCaja, Pago, Banco, idBanco, NroCuenta, NroCheque, fechaPago, Monto, RS, RUC, tabla);
            String total = String.valueOf(getTotalPagadoVentasCredito());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgPagoVentasCredito.lbPagado.setText(df.format(Integer.parseInt(total)));
            dlgPagoVentasCredito.Renders();
            dlgPagoVentasCredito.CalcularDif();
            dlgPagoVentasCredito.LimpiarCampos();
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void insertarPagoCompra(int idCompra, int idCaja, String Pago, String Banco, String idBanco, String NroCuenta, String NroCheque, String fechaPago, int Monto, String RS, String RUC, JTable tabla) {
        String fila[] = new String[11];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = String.valueOf(idCompra);
        fila[1] = String.valueOf(idCaja);
        fila[2] = Pago;
        fila[3] = Banco;
        fila[4] = idBanco;
        fila[5] = NroCuenta;
        fila[6] = NroCheque;
        fila[7] = fechaPago;
        fila[8] = String.valueOf(Monto);
        fila[9] = RS;
        fila[10] = RUC;
        tb.addRow(fila);
    }
    
    public static void insertarPagoComprasCredito(int idCaja, String Pago, String Banco, String idBanco, String NroCuenta, String NroCheque, String fechaPago, int Monto, String RS, String RUC, JTable tabla) {
        String fila[] = new String[11];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = "0";
        fila[1] = String.valueOf(idCaja);
        fila[2] = Pago;
        fila[3] = Banco;
        fila[4] = idBanco;
        fila[5] = NroCuenta;
        fila[6] = NroCheque;
        fila[7] = fechaPago;
        fila[8] = String.valueOf(Monto);
        fila[9] = RS;
        fila[10] = RUC;
        tb.addRow(fila);
    }
    
    public static void insertarPagoVentasCredito(int idCaja, String Pago, String Banco, String idBanco, String NroCuenta, String NroCheque, String fechaPago, int Monto, String RS, String RUC, JTable tabla) {
        String fila[] = new String[11];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = "0";
        fila[1] = String.valueOf(idCaja);
        fila[2] = Pago;
        fila[3] = Banco;
        fila[4] = idBanco;
        fila[5] = NroCuenta;
        fila[6] = NroCheque;
        fila[7] = fechaPago;
        fila[8] = String.valueOf(Monto);
        fila[9] = RS;
        fila[10] = RUC;
        tb.addRow(fila);
    }

    public static void consLinea() {
        int fila = dlgCompras1.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgCompras1.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Artículo no existe");
        } else {
            dc = array.getFila(p);
            int codAr = dc.getCodArticulo();
        }
    }

    public static void delRenglon(JTable tabla) {
        consLinea();
        int fila = dlgCompras1.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgCompras1.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf((getTotal()));
                DecimalFormat df = new DecimalFormat("#,###");
                dlgCompras1.txtTotalL.setText(total);
                dlgCompras1.txtTotal.setText(df.format(Integer.valueOf(total.trim().replace(".", "").replace(",", ""))));
            }
        }
    }

    public static void delRenglonPagoCompra(JTable tabla) {
        int fila = dlgPagoCompra.tbDetallePago.getSelectedRow();
        if (fila >= 0) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(getTotalPagadoCompra());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgPagoCompra.lbPagado.setText(df.format(Integer.parseInt(total)));
                dlgPagoCompra.Renders();
                dlgPagoCompra.CalcularDif();
            }
        }
    }
    
    public static void delRenglonPagoCompraCreditos(JTable tabla) {
        int fila = dlgPagoComprasCredito.tbDetallePago.getSelectedRow();
        if (fila >= 0) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(getTotalPagadoComprasCredito());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgPagoComprasCredito.lbPagado.setText(df.format(Integer.parseInt(total)));
                dlgPagoComprasCredito.Renders();
                dlgPagoComprasCredito.CalcularDif();
            }
        }
    }
    
    public static void delRenglonPagoVentaCreditos(JTable tabla) {
        int fila = dlgPagoVentasCredito.tbDetallePago.getSelectedRow();
        if (fila >= 0) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(getTotalPagadoVentasCredito());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgPagoVentasCredito.lbPagado.setText(df.format(Integer.parseInt(total)));
                dlgPagoVentasCredito.Renders();
                dlgPagoVentasCredito.CalcularDif();
            }
        }
    }

    public static void canCelar() {
        array.vaciar();
    }

    /*    public static String addCompra() {
        String msg;
        int codc = Integer.parseInt(dlgCompras1.txtCod.getText());
        int codProv = Integer.parseInt(dlgCompras1.txtCodProv.getText());
        String condPago = (dlgCompras1.lbCond.getText());
        String Fact= dlgCompras1.txtFactura.getText();
        String fecha = dlgCompras1.txtFecha.getText();
        int total = Integer.parseInt(dlgCompras1.txtTotalL.getText());
        int exenta= Integer.parseInt(dlgCompras1.txtExentaL.getText());
        int iva5= Integer.parseInt(dlgCompras1.txt5L.getText());
        int iva10=Integer.parseInt(dlgCompras1.txt10L.getText());

        Compra c = new Compra(codc, codProv,condPago,Fact, fecha, total, exenta, iva5, iva10);

        array.vaciar();
        msg = GestionarCompra.addCompra(c);

        if (msg == null) {
            Mensajes.informacion("Compra Realizada");
            controlCompra.addDetalleCompra();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/

 /*   public static String addDetalleCompra() {
        String msg = null;
        int fila = dlgCompras1.tbDetalle.getRowCount();
        for (int i = 0; i < fila; i++) {
            int codCompra = Integer.valueOf(dlgCompras1.txtCod.getText());
            int codArt = Integer.valueOf(dlgCompras1.tbDetalle.getValueAt(i, 0).toString());
            int cantidad = Integer.valueOf(dlgCompras1.tbDetalle.getValueAt(i, 4).toString());
            int precio = Integer.valueOf(dlgCompras1.tbDetalle.getValueAt(i, 6).toString());
            int mont = Integer.valueOf(dlgCompras1.tbDetalle.getValueAt(i, 14).toString());

            dc = new DetalleCompra(codCompra, codArt, cantidad, precio, mont);

            msg = GestionarCompra.addDetalleCompra(dc);
        }
        if (msg == null) {
            Mensajes.informacion("Detalle Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/

 /*  public static void finalizar(JTable tabla) {
        int fila = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras1.tbDetalle.getModel();
        int renglones = tb.getRowCount();
        for (int i = 0; i < renglones; i++) {
            fila++;
        }
        if (fila <= 0) {
            Mensajes.error("No ha ingresado artículos");
        } else {
            dlgFinCompra fc = new dlgFinCompra(null, true);
            fc.setLocationRelativeTo(null);
            int total = Redondeo.redondearI(getTotal());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgFinCompra.lblTotal.setText("₲ "+df.format(Integer.valueOf(String.valueOf(total).trim().replace(".", "").replace(",", ""))));
            //dlgFinCompra.lblTotal.setText(String.valueOf(total));
            fc.setVisible(true);
        }
    }*/

 /*------CONSULTADO LAS COMPRAS REALIZADAS*/
 /*public static void listarCompras(JTable tabla) {
        List lista;
        lista = GestionarCompra.listarCompras();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            //fila[10].toString();
            if (fila[10].toString().equals("S")) {
                fila[10] = "ACTIVO";
            } else {
                fila[10] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }*/
    public static void listarComprasReparto(JTable tabla, String caja) {
        List lista;
        lista = GestionarCompra.listarComprasReparto(caja);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5].toString();
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
            fila[12].toString();
            tb.addRow(fila);
        }
    }

    public static void listarDetalleCompras(JTable tabla) {
        int x = dlgConsultarCompras.tbCompra.getSelectedRow();
        String cod = dlgConsultarCompras.tbCompra.getValueAt(x, 0).toString();
        String fac = dlgConsultarCompras.tbCompra.getValueAt(x, 7).toString();
        String fecha = dlgConsultarCompras.tbCompra.getValueAt(x, 2).toString() + " " + dlgConsultarCompras.tbCompra.getValueAt(x, 3).toString();
        String pro = dlgConsultarCompras.tbCompra.getValueAt(x, 4).toString() + " - " + dlgConsultarCompras.tbCompra.getValueAt(x, 5).toString();
        String codPro = dlgConsultarCompras.tbCompra.getValueAt(x, 8).toString();
        DecimalFormat df = new DecimalFormat("#,###");
        String total = dlgConsultarCompras.tbCompra.getValueAt(x, 9).toString();
        dlgConsultarCompras.txtCodCompra.setText(fac);
        List lista;
        //lista = GestionarCompra.listarDetalleCompras(cod);
        /*for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5].toString();
            fila[6].toString();
            tb.addRow(fila);
        }*/
    }

    public static void listarDetalleComprasReparto(JTable tabla) {
        int x = dlgConsultarCompras1.tbCompra.getSelectedRow();
        String cod = dlgConsultarCompras1.tbCompra.getValueAt(x, 0).toString();
        List lista;
        /*lista = GestionarCompra.listarDetalleCompras(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            tb.addRow(fila);
        }*/
    }

    public static String anularCompra() {
        String msg;
        int x = dlgConsultarCompras.tbCompra.getSelectedRow();
        String cod = dlgConsultarCompras.tbCompra.getValueAt(x, 0).toString();
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarCompra.delCompra(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Compra Anulada");
            controlCompra1.actStockEliminarCompra();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarCompra() {
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
    }

    public static void actCantidad(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            double ca = Double.parseDouble(tabla.getValueAt(fila, 4).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 6).toString());
            double cant = (Mensajes.ingresarNumerosC(ca));
            int monto = (int) (pre * cant);
            int iva = Integer.parseInt(tabla.getValueAt(fila, 7).toString());
            tabla.setValueAt(String.valueOf(cant), fila, 3);
            tabla.setValueAt(String.valueOf(cant), fila, 4);

            switch (iva) {
                case 10 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 12);
                    tabla.setValueAt(String.valueOf(monto), fila, 13);
                }
                case 5 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 10);
                    tabla.setValueAt(String.valueOf(monto), fila, 11);
                }
                default -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 8);
                    tabla.setValueAt(String.valueOf(monto), fila, 9);
                }
            }
            tabla.setValueAt(String.valueOf(monto), fila, 14);
            tabla.setValueAt(String.valueOf(monto), fila, 15);

            //int Gan = CalcGanancia();
            //dlgCompras1.tbDetalle.setValueAt(String.valueOf(Gan), fila, 16);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgCompras1.txtExentaL.setText(exentas);
            dlgCompras1.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgCompras1.txt5L.setText(iva5);
            dlgCompras1.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgCompras1.txt10L.setText(iva10);
            dlgCompras1.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgCompras1.txtTotalL.setText(total);
            dlgCompras1.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void addmismoItem(int fila, double cantTabla, double cantAdd, int costo, int iva) {
        try {
            double cantFinal = (cantTabla + cantAdd);
            int montoAct = (int) (costo * cantFinal);
            dlgCompras1.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 3);
            dlgCompras1.tbDetalle.setValueAt(String.valueOf(cantFinal), fila, 4);
            dlgCompras1.tbDetalle.setValueAt(String.valueOf(costo), fila, 5);
            dlgCompras1.tbDetalle.setValueAt(String.valueOf(costo), fila, 6);
            switch (iva) {
                case 10 -> {
                    dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 12);
                    dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 13);
                }
                case 5 -> {
                    dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 10);
                    dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 11);
                }
                default -> {
                    dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 8);
                    dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 9);
                }
            }
            dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 14);
            dlgCompras1.tbDetalle.setValueAt(String.valueOf(montoAct), fila, 15);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgCompras1.txtExentaL.setText(exentas);
            dlgCompras1.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgCompras1.txt5L.setText(iva5);
            dlgCompras1.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgCompras1.txt10L.setText(iva10);
            dlgCompras1.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgCompras1.txtTotalL.setText(total);
            dlgCompras1.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void actPrecio(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();
            String cod = (tabla.getValueAt(fila, 0).toString());
            art = GestionarArticulosMovil.busArticulo(cod);
            double cant = Double.valueOf(tabla.getValueAt(fila, 4).toString());
            int pre = Integer.parseInt(tabla.getValueAt(fila, 6).toString());
            int precio = (Mensajes.ingresarPrecioC(pre));
            costo2 = (precio);
            int iva = Integer.parseInt(tabla.getValueAt(fila, 7).toString());
            int pv = art.getPrecio_venta();
            String GAMA = String.valueOf(CalcGananciaMayorista2());
            String PORMA = String.valueOf(calcularPorMayorista2());
            String GAMI = String.valueOf(CalcGananciaMinorista2());
            String PORMI = String.valueOf(calcularPorMinorista2());
            String GASU = String.valueOf(CalcGananciaSupermercado2());
            String PORSU = String.valueOf(calcularPorSupermercado2());
            int monto = (int) (cant * (precio));

            tabla.setValueAt(String.valueOf(precio), fila, 5);
            tabla.setValueAt(String.valueOf(precio), fila, 6);

            switch (iva) {
                case 10 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 12);
                    tabla.setValueAt(String.valueOf(monto), fila, 13);
                }
                case 5 -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 10);
                    tabla.setValueAt(String.valueOf(monto), fila, 11);
                }
                default -> {
                    tabla.setValueAt(String.valueOf(monto), fila, 8);
                    tabla.setValueAt(String.valueOf(monto), fila, 9);
                }
            }
            tabla.setValueAt(String.valueOf(monto), fila, 14);
            tabla.setValueAt(String.valueOf(monto), fila, 15);
            tabla.setValueAt(GAMA, fila, 16);
            tabla.setValueAt(PORMA, fila, 17);
            tabla.setValueAt(GAMI, fila, 18);
            tabla.setValueAt(PORMI, fila, 19);
            tabla.setValueAt(GASU, fila, 20);
            tabla.setValueAt(PORSU, fila, 21);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgCompras1.txtExentaL.setText(exentas);
            dlgCompras1.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgCompras1.txt5L.setText(iva5);
            dlgCompras1.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgCompras1.txt10L.setText(iva10);
            dlgCompras1.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgCompras1.txtTotalL.setText(total);
            dlgCompras1.txtTotal.setText(df.format(Integer.parseInt(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

}
