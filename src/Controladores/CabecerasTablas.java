package Controladores;

import Componentes.Render;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public final class CabecerasTablas {

    static String articulos[] = {"CODIGO", "CLASIFICACION", "CODBARRA", "DESCRIPCIÓN", "STOCK", "COSTO", "PRECIO SUPER.", "PRECIO MIN.", "", "", "PRECIO MAY."};
    static String articulosCompra[] = {"CODIGO", "CODINT", "CODBARRA", "DESCRIPCIÓN", "PRECIO"};
    static String RefSolNCP[] = {"f", "IDENTIFICADOR DE SALIDAS"};
    static String RefTSNC[] = {"IDENTIFICADOR DE SALIDAS"};
    static String TablaControlNCCliente[] = {"IDPROD","CANT","PRECIO"};
    static String fac_nc_compra[] = {"ID", "CAJA", "PROVEEDOR", "CONDICIÓN", "FECHA.", "COMPROBANTE NRO.", "TOTAL"};
    static String fac_nc_venta[] = {"ID", "CAJA", "PROVEEDOR", "CONDICIÓN", "FECHA.", "COMPROBANTE NRO.", "TOTAL", "SUPER"};
    static String TLS[] = {"ID", "IDCAJA", "PROVEEDOR", "RS", "FECHA", "HORA", "TOTAL", "OBSERVACIÓN", "ESTADO", " "};
    static String articulosSalida[] = {"CODIGO", "CODINT", "CODBARRA", "DESCRIPCIÓN", "STOCK", "P.COSTO"};
    static String columnNCP[] = {"CODIGO", "IDCAJA", "FECHA", "HORA", "DEPOSITO SALIDA", "TOTAL", "OBSERVACIÓN", ""};
    static String columnDNCO[] = {"IDSALIDA", "IDMOTIVO", "MOTIVO", "IDPROD", "CODBARRA", "DESCRIPCIÓN", "CANT", "PRECIO", "MONTO"};
    static String columnconsNCProveedor[] = {"ID NC", "IDCAJA", "IDCOMPRA", "NROFACTURA", "CONDICIÓN", "PROVEEDOR", "PROMOCIÓN", "N. DE CRÉDITO NRO", "FECHA", "TOTAL", "REGISTRADO EN FECHA", ""};
    String articulosAux_reparto[] = {"CODIGO", "CODINT", "CODBARRA", "DESCRIPCIÓN", "P.VENTAS"};
    static String articulosBuscaVenta[] = {"CODIGO", "CODBARRA", "DESCRIPCIÓN", "STOCK"};
    static String columnconsPagosVentas[] = {"CODIGO", "RECIBO NRO.", "MONTO", "FECHA Y HORA",""};
    static String columnPerfiles[] = {"CODIGO", "PERFIL DE USUSARIO"};
    static String columnconsDetallePagosVentas1[] = {"FORMA DE PAGO", "MONTO"};
    static String columnconsDetallePagosVentas2[] = {"ID","PROVEEDOR", "FECHA","FACTURA NRO","MONTO"};
    static String columnconsDetallePagosVentas3[] = {"ID","FECHA","NC NRO","MONTO"};
    static String articulosMovil[] = {"CODIGO", "CLASIFICACION", "CODINT", "CODBARRA", "DESCRIPCIÓN", "U.M.", "COSTO", "GAN.MAY.", "MAYORISTA", "STOCK", "IMPU"};
    static String articulosMovil2[] = {"CODIGO", "CLASIFICACION", "CODBARRA", "DESCRIPCIÓN", "STOCK", "COSTO", "PRECIO SUPER.", "PRECIO MIN.", "", "", "PRECIO MAY."};
    static String reparto[] = {"ID", "CODINT", "DESCRIPCION", "PRECIO", "RA", "C", "T", "CARGA T.", "MCARGA", "RECAMBIO", "MRECAMBIO", "VENDIDO", "MVENDIDO", "MCOSTO", "DEVUELTO", "MDEVUELTO"};
    static String todosReparts[] = {"ID", "MOV.", "REFERENCIA", "TOTAL", "RECAMBIO", "DEVUELTO", "ENTREGAR", "ENTREGADO", "DIF."};
    static String reporteComision[] = {"ID.REPAR", "MOV.N°", "FECHA", "COMISIÓN"};
    String familia[] = {"ID", "FAMILIA", "%", "I.V.A."};
    String laboratorio[] = {"ID", "MARCAS"};
    String empresa[] = {"ID", "RAZÓN SOCIAL", "R.U.C.", "DIRECCIÓN", "TELÉFONO", "ESTADO", "IDCIUDAD", "CIUDAD"};
    String moviles[] = {"ID", "DESCRIPCIÓN DEL PUNTO DE CONTROL", "CHAPA", "MARCA", "MODELO", "CHASIS", "AÑO FABR.", "COLOR", "CAP."};
    String vendedores[] = {"ID", "ID", "FUNCION", "ID", "PUNTO DE CONTROL", "NOMBRE Y APELLIDO", "C.I. NRO.", "FECHA INGRESO", "CELULAR", "SUELDO", "% COM", "OBSERVACIÓN"};
    private static final String clientes[] = {"ID", "NOMBRE y APELLIDO O RAZÓN SOCIAL", "C.I. O R.U.C.", "DIRECCION", "TELEFONO", "CIUDAD"};
    private static final String clientesContaduria[] = {"ID_CLIENTE", "NOMBRE", "RUC", "DV"};
    private static final String actosGravados[] = {"ID_ACTOS", "DESCRIPCION", "IMPUESTO"};
    private static final String ventacabecera[] = {"TIMBRADO", "REGIMEN", "FECHA", "NRO_FAC", "ID_TIPDOCU", "ID_CLIENTE", "ID_MONEDA"};
    private static final String ventadetalle[] = {"TIMBRADO", "REGIMEN", "FECHA", "NRO_FAC", "ID_TIPDOCU", "ID_CLIENTE", "ID_ACTOS", "FORMA_IMP", "IMPORTE", "PDESCUENTO", "PDESCUENTODE"};
    private static final String Detalle_sol_nc[] = {"ID", "IDPROD", "CANT"};
    String provedores[] = {"ID", "RAZÓN SOCIAL", "R.U.C.", "TELÉFONO", "CONTACTO", "CELULAR", "CIUDAD", "DIRECCIÓN", "OBSERVACIÓN"};
    String tablaStock[] = {"Código", "Marca", "Descripción", "Stock"};
    String tablaAuxiliarArticulo[] = {"Codigo", "Rubro", "Descripcion", "Marca", "Precio"};
    String ciudad[] = {"ID", "CIUDAD"};
    String ciudadMovil[] = {"ID", "CIUDAD", "DEPARTAMENTO", "EST", "IDDEP"};
    String sucursal[] = {"ID", "SUCURSAL", "EMPRESA"};
    String zona[] = {"CODIGO", "ZONA"};
    String detalleGasto[] = {"ID", "DESCRIPCIÓN"};
    String motivo[] = {"ID", "MOTIVOS"};
    String clasificacion[] = {"ID", "CLASIFICACION", "ESPECIFICACIÓN"};
    String um[] = {"ID", "UNIDAD DE MEDIDA", "EQUIVALENCIA"};
    String timbrado[] = {"ID", "TIMBRADO", "DESDE", "HASTA", "AUTORIZACION", "FECHA AUT.", "ESTADO"};
    String puntoEmision[] = {"ID", "IDT", "TIMBRADO", "EST.", "P.E.", "DIRECCION", "INICIO", "FIN", "ACTUAL", "N°.VTA.", "TIPO", "FINALIDAD", "DIR. IP", "ESTADO"};
    String iva[] = {"ID", "IMPUESTO", "DESCRIPCIÓN DE IMPUESTO"};
    static String salidas[] = {"CODART", "DESCRIPCIÓN", "CODMOTIVO", "MOTIVO SALIDA", "CANT", "COSTO", "MONTO"};
    String conSalidas[] = {"OP. N°", "MOV. N°", "FECHA", "HORA", "PROVEEDOR", "IDDEP", "APLICADO A", "TABLA", "IDPARA", "FINALIDAD", "TOTAL", "OBSERVACIÓN", "", "ESTADO"};
    String detalleSalida[] = {"CODART", "MOTIVO SALIDA", "CANT", "OP. N°", "DESCRIPCIÓN", "COSTO", "MONTO"};
    static String compras[] = {"COD", "CODBARRA", "DESCRIPCIÓN", "CANT", "CANTf", "PRECIO ", "PRECIOF", "IVA", "EXENTA", "EXENTAf", "IVA 5%", "IVA5f", "IVA 10%", "IVA10f", "MONTO", "MONTOf", "GAMA", "PORMA", "GAMI", "PORMI", "GASU", "PORSU"};
    static String nccompras[] = {"COD", "CODBARRA", "DESCRIPCIÓN", "CANT", "PRECIO ", "IVA", "EXENTA", "IVA 5%", "IVA 10%", "MONTO"};
    static String ncventa[] = {"COD", "CODBARRA", "DESCRIPCIÓN", "CANT", "PRECIO ", "IVA", "EXENTA", "IVA 5%", "IVA 10%", "MONTO","ORDEN"};
    static String facturas[] = {"COD", "CODBARRA", "DESCRIPCIÓN", "CANT", "PRECIO", "EXENTA", "IVA 5%", "IVA 10%", "SUB-TOTAL", "IDIVA", "O"};
    static String pagoCompra[] = {"IDCOMPRA", "IDCAJA", "PAGO CON", "BANCO", "IDBANCO", "NRO CUENTA", "NRO CHEQUE", "FECHA PAGO", "MONTO", "RS", "RUC"};
    String categoria[] = {"CODIGO", "CATEGORIA"};
    String presupuestos[] = {"Cant.", "Cod.", "Descripción", "Precio", "Total"};
    String conFactura[] = {"OPERACIÓN", "RAZÓN SOCIAL", "FECHA", "HORA", "COD CLI", "MOV.CAJA", "FACTURA N°", "CONDICION", "PAGO", "TOTAL", "CODVENDE", "ESTADO"};
    String detalleFactura[] = {"CANT", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "PRECIO", "TOTAL"};
    String consPresupuesto[] = {"N°", "Fecha", "Razon Social", "Cód. Clie", "Desc", "Total"};
    String detallePresupuestoF[] = {"Cant.", "Código", "Descripción", "Precio", "Total"};
    String busEmpleado[] = {"Cód", "Empleado", "Observación"};
    String consNotaCredito[] = {"N°", "Fecha", "Razon Social", "Cod. Clie", "Total", "Desc", "Fac"};
    String detalleNotaCredito[] = {"Cant.", "Cód", "Descripción", "Precio", "Total"};
    String usuario[] = {"ID", "PERFIL ASIG.", "EMPLEADO", "USUARIO", "PASSWORD", "INDICADOR", "IP", "CODPERFIL", "CODVENDE"};
    String comisiones[] = {"FECHA", "FACT.", "CLIENTE", "TOTAL", "%COM.", "COMISION"};
    String consCompras[] = {"ID COMPRA", "MOV.NRO", "FECHA", "HORA", "ID", "PROVEEDOR", "CONDICIÓN", "FACTURA NRO", "TOTAL", "N. DE CRÉDITO", "ESTADO", ""};
    String consComprasCreditos[] = {"ID VENTA", "MOV.NRO", "FECHA", "HORA", "ID", "PROVEEDOR", "CONDICIÓN", "FACTURA NRO", "TOTAL", "N. DE CRÉDITO", "ESTADO", ""};
    //static String consVentasMoviles[] = {"VENTA.N°","EMISION","TIMBRADO","FACTURA NRO", "CONDICIÓN","FECHA"," HORA", "RUC","RAZÓN SOCIAL","TOTAL","VENDEDOR","ESTADO"};
    static String consVentasMoviles[] = {"VENTA.N°", "EMISION", "TIMBRADO", "DESDE", "HASTA", "FACTURA NRO", "CONDICIÓN", "FECHA", " HORA", "RUC", "RAZÓN SOCIAL", "TOTAL", "VENDEDOR", "ESTADO", "E", "5", "10"};
    //static String consDetalleVentasMoviles[] = {"CODINT","DESCRIPCIÓN","CANT", "PRECIO","SUB-TOTAL"};
    static String consDetalleVentasMoviles[] = {"CODINT", "COD_BARRA", "DESCRIPCIÓN", "CANT", "PRECIO", "SUB-TOTAL", "IMP", "UM"};
    String consRepartoAnterior[] = {"REPARTO.N°", "MOVIM.N°", "REFERENCIA", "FECHA", "HORA", "KILOMETRAJE", "EFECT. ENTREGADO"};
    static String consDetalleCompras[] = {"OPER. N°", "ID", "CÓD.BARRA", "DESCRIPCION", "CANT", "COSTO", "MONTO"};
    static String consDetalleTransferenciasRealizadas[] = {"OPER. N°", "ID", "CÓD.INT", "DESCRIPCION", "CANT", "PRECIO", "MONTO"};
    String consDetalleRepartoAnterior[] = {"OPER. N°", "ID", "CÓD.INT", "DESCRIPCION", "CANT", "VALOR"};
    static String Gastos[] = {"ID", "MOV.N°", "FECHA", "MOTIVO", "ORIGEN", "REFERENCIA", "MONTO", "OBSERVACIÓN"};
    static String dnc[] = {"ID NC"};
    static String transferencia[] = {"ID", "CODINT", "DESCRIPCION", "PRECIO", "CANT", "MONTO"};
    static String datosTransferencias[] = {"ID TRANSF.", "MOV.N°", "FECHA", "HORA", "O", "TRANSFERENCIA ORIGEN", "D", "TRANSFERENCIA DESTINO", "TOTAL"};
    static String datosTransferencias2[] = {"ID TRANSF.", "MOV.N°", "FECHA", "HORA", "O", "TRANSFERENCIA ORIGEN", "D", "TRANSFERENCIA DESTINO", "TOTAL", "ID.O", "ID.E"};
    static String datos[][] = {};
    static String datosRefSolNCP[][] = {};
    static String datosRefTSNC[][] = {};
    static String datosTablaControlNCCliente[][] = {};
    static String datosAjSt[][] = {};
    static String datosSalida[][] = {};
    static String datosCC[][] = {};
    static String datosAG[][] = {};
    static String datosVC[][] = {};
    static String datosVD[][] = {};
    static String datos_fac_nc_compra[][] = {};
    static String datos_fac_nc_venta[][] = {};
    static String datosDetalle_sol_nc[][] = {};
    static String datosVentasMoviles[][] = {};
    static String datosDetalleVentasMoviles[][] = {};
    static String datosDetalleTransf[][] = {};
    static String datosTT[][] = {};
    static String datosTT2[][] = {};
    static String datosTrans[][] = {};
    static String datosGastos[][] = {};
    static String datosdnc[][] = {};
    static String datosCompras[][] = {};
    static String datosncCompras[][] = {};
    static String datosncVentas[][] = {};
    static String datosArtAuxCompra[][] = {};
    static String datosArtAuxSalida[][] = {};
    static String datosBuscarClientes[][] = {};
    static String datosVentas[][] = {};
    static String datosPagosCompra[][] = {};
    static String datosArtAux[][] = {};
    static String datosArtM[][] = {};
    static String datosTodosR[][] = {};
    static String datosconsDetalleCompras[][] = {};
    static String datosNCP[][] = {};
    static String datosDNCP[][] = {};
    static String datosconsNCProveedor[][] = {};
    static String datosconsPagosVentas[][] = {};
    static String datosPerfiles[][] = {};
    static String datosconsDetallePagosVentas1[][] = {};
    static String datosconsDetallePagosVentas2[][] = {};
    static String datosconsDetallePagosVentas3[][] = {};
    static String datosTLS[][] = {};
    private static DefaultTableModel modelo;
    private static DefaultTableModel modelo_fac_nc_compra;
    private static DefaultTableModel modelo_fac_nc_venta;
    private static DefaultTableModel modeloTLS;
    private static DefaultTableModel modeloRefTSNC;
    private static DefaultTableModel modeloTablaControlNCCliente;
    private static DefaultTableModel modeloRefSolNCP;
    private static DefaultTableModel modeloNCP;
    private static DefaultTableModel modeloDNCP;
    private static DefaultTableModel modeloconsNCProveedor;
    private static DefaultTableModel modeloconsPagosVentas;
    private static DefaultTableModel modeloPerfiles;
    private static DefaultTableModel modeloconsDetallePagosVentas1;
    private static DefaultTableModel modeloconsDetallePagosVentas2;
    private static DefaultTableModel modeloconsDetallePagosVentas3;
    private static DefaultTableModel modeloSalida;
    private static DefaultTableModel modeloClienteContaduria;
    private static DefaultTableModel modeloActosGravados;
    private static DefaultTableModel modeloVentaCabecera;
    private static DefaultTableModel modeloVentaDetalle;
    private static DefaultTableModel modeloDetalle_sol_nc;
    private static DefaultTableModel modeloVentasMoviles;
    private static DefaultTableModel modeloDetalleVentasMoviles;
    private static DefaultTableModel modeloDetalleTransfe;
    private static DefaultTableModel modelotodosTransferencias;
    private static DefaultTableModel modelotodosTransferencias2;
    private static DefaultTableModel modeloTrans;
    private static DefaultTableModel modeloconsDetalleCompras;
    private static DefaultTableModel modeloArtAuxCompra;
    private static DefaultTableModel modeloArtAuxSalida;
    private static DefaultTableModel modeloArtM;
    private static DefaultTableModel modeloArtAux;
    private static DefaultTableModel modeloBuscarCliente;
    private static DefaultTableModel modeloReparto;
    private static DefaultTableModel modelotodosReparto;
    private static DefaultTableModel modeloVentas;
    private static DefaultTableModel modeloPagosCompra;
    private static DefaultTableModel modeloCompras;
    private static DefaultTableModel modeloncCompras;
    private static DefaultTableModel modeloncVentas;
    private static DefaultTableModel modeloGastos;
    private static DefaultTableModel modelodnc;
    private static DefaultTableModel modeloAjSt;
    private static TableColumn colum = null;

    public static void limpiarTablasconsDetalleCompras(JTable tabla) {
        tabla.setModel(modeloconsDetalleCompras);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloconsDetalleCompras.removeRow(0);
        }
    }

    public static void limpiarTablas(JTable tabla) {
        tabla.setModel(modelo);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }
    
    public static void limpiarTablasPerfiles(JTable tabla) {
        tabla.setModel(modeloPerfiles);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloPerfiles.removeRow(0);
        }
    }
    
    public static void limpiarTablasconsPagosVentas(JTable tabla) {
        tabla.setModel(modeloconsPagosVentas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloconsPagosVentas.removeRow(0);
        }
    }
    
    public static void limpiarTablasconsDetallePagosVentas1(JTable tabla) {
        tabla.setModel(modeloconsDetallePagosVentas1);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloconsDetallePagosVentas1.removeRow(0);
        }
    }
    
    public static void limpiarTablasconsDetallePagosVentas2(JTable tabla) {
        tabla.setModel(modeloconsDetallePagosVentas2);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloconsDetallePagosVentas2.removeRow(0);
        }
    }
    
    public static void limpiarTablasconsDetallePagosVentas3(JTable tabla) {
        tabla.setModel(modeloconsDetallePagosVentas3);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloconsDetallePagosVentas3.removeRow(0);
        }
    }
    
    public static void limpiarTablaControlNCCliente(JTable tabla) {
        tabla.setModel(modeloTablaControlNCCliente);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTablaControlNCCliente.removeRow(0);
        }
    }

    public static void limpiarTablasconsNCProveedor(JTable tabla) {
        tabla.setModel(modeloconsNCProveedor);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloconsNCProveedor.removeRow(0);
        }
    }

    public static void limpiarTablasncCompras(JTable tabla) {
        tabla.setModel(modeloncCompras);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloncCompras.removeRow(0);
        }
    }
    
    public static void limpiardnc(JTable tabla) {
        tabla.setModel(modelodnc);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelodnc.removeRow(0);
        }
    }
    
    public static void limpiarTablasncVentas(JTable tabla) {
        tabla.setModel(modeloncVentas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloncVentas.removeRow(0);
        }
    }

    public static void limpiar_fac_nc_compra(JTable tabla) {
        tabla.setModel(modelo_fac_nc_compra);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo_fac_nc_compra.removeRow(0);
        }
    }

    public static void limpiar_fac_nc_ventas(JTable tabla) {
        tabla.setModel(modelo_fac_nc_venta);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo_fac_nc_venta.removeRow(0);
        }
    }

    public static void limpiarTablasTLS(JTable tabla) {
        tabla.setModel(modeloTLS);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTLS.removeRow(0);
        }
    }

    public static void limpiarTablasRefSolNCP(JTable tabla) {
        tabla.setModel(modeloRefSolNCP);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloRefSolNCP.removeRow(0);
        }
    }

    public static void limpiarTablasRefTSNCP(JTable tabla) {
        tabla.setModel(modeloRefTSNC);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloRefTSNC.removeRow(0);
        }
    }

    public static void limpiarTablasDetalleRefTSNCP(JTable tabla) {
        tabla.setModel(modeloDetalle_sol_nc);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalle_sol_nc.removeRow(0);
        }
    }

    public static void limpiarTablasSalidasNCP(JTable tabla) {
        tabla.setModel(modeloNCP);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloNCP.removeRow(0);
        }
    }

    public static void limpiarTablasSalidasDNCP(JTable tabla) {
        tabla.setModel(modeloDNCP);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDNCP.removeRow(0);
        }
    }

    public static void limpiarTablasAjSt(JTable tabla) {
        tabla.setModel(modeloAjSt);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloAjSt.removeRow(0);
        }
    }

    public static void limpiarTablasSalida(JTable tabla) {
        tabla.setModel(modeloSalida);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloSalida.removeRow(0);
        }
    }

    public static void limpiarTablasPagosCompras(JTable tabla) {
        tabla.setModel(modeloPagosCompra);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloPagosCompra.removeRow(0);
        }
    }

    public static void limpiarTablasVentaCabecera(JTable tabla) {
        tabla.setModel(modeloVentaCabecera);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVentaCabecera.removeRow(0);
        }
    }

    public static void limpiarTablasVentaDetalle(JTable tabla) {
        tabla.setModel(modeloVentaDetalle);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVentaDetalle.removeRow(0);
        }
    }

    public static void limpiarTablasActosGravados(JTable tabla) {
        tabla.setModel(modeloActosGravados);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloActosGravados.removeRow(0);
        }
    }

    public static void limpiarTablasClienteContaduria(JTable tabla) {
        tabla.setModel(modeloClienteContaduria);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloClienteContaduria.removeRow(0);
        }
    }

    public static void limpiarTablasVentasMoviles(JTable tabla) {
        tabla.setModel(modeloVentasMoviles);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVentasMoviles.removeRow(0);
        }
    }

    public static void limpiarTablasDetalleVentasMoviles(JTable tabla) {
        tabla.setModel(modeloDetalleVentasMoviles);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleVentasMoviles.removeRow(0);
        }
    }

    public static void limpiarTablasDetalleTransferenciasRealizadas(JTable tabla) {
        tabla.setModel(modeloDetalleTransfe);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleTransfe.removeRow(0);
        }
    }

    public static void limpiarTablasTransferenciasRealizadas(JTable tabla) {
        tabla.setModel(modelotodosTransferencias);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelotodosTransferencias.removeRow(0);
        }
    }

    public static void limpiarTablasTransferenciasRealizadas2(JTable tabla) {
        tabla.setModel(modelotodosTransferencias2);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelotodosTransferencias2.removeRow(0);
        }
    }

    public static void limpiarTablasTransferencias(JTable tabla) {
        tabla.setModel(modeloTrans);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTrans.removeRow(0);
        }
    }

    public static void limpiarTablasGastos(JTable tabla) {
        tabla.setModel(modeloGastos);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloGastos.removeRow(0);
        }
    }

    public static void limpiarTablasTodosRepartos(JTable tabla) {
        tabla.setModel(modelotodosReparto);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelotodosReparto.removeRow(0);
        }
    }

    public static void limpiarTablasCompras(JTable tabla) {
        tabla.setModel(modeloCompras);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloCompras.removeRow(0);
        }
    }

    public static void limpiarTablasArtAuxCompra(JTable tabla) {
        tabla.setModel(modeloArtAuxCompra);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloArtAuxCompra.removeRow(0);
        }
    }

    public static void limpiarTablasArtAuxSalida(JTable tabla) {
        tabla.setModel(modeloArtAuxSalida);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloArtAuxSalida.removeRow(0);
        }
    }

    public static void limpiarTablasArticuloM(JTable tabla) {
        tabla.setModel(modeloArtM);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloArtM.removeRow(0);
        }
    }

    public static void limpiarTablasArtAux(JTable tabla) {
        tabla.setModel(modeloArtAux);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloArtAux.removeRow(0);
        }
    }

    public static void limpiarTablasVentas(JTable tabla) {
        tabla.setModel(modeloVentas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVentas.removeRow(0);
        }
    }

    public static void limpiarTablasRepartos(JTable tabla) {
        tabla.setModel(modeloReparto);
        int filasR = tabla.getRowCount();
        for (int i = 0; i < filasR; i++) {
            modeloReparto.removeRow(0);
        }
    }

    public static void limpiarTablasBuscarClientes(JTable tabla) {
        tabla.setModel(modeloBuscarCliente);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloBuscarCliente.removeRow(0);
        }
    }

    public static void gestGastos(JTable tabla) {
        modeloGastos = new DefaultTableModel(datosGastos, Gastos);
        tabla.setModel(modeloGastos);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(100);
        /* colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);*/
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(130);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);

    }
    
    public static void detalleNC(JTable tabla) {
        modelodnc = new DefaultTableModel(datosdnc, dnc);
        tabla.setModel(modelodnc);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
    }

    public void consComprasCreditos(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel(datos, consComprasCreditos) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, true
            };
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(85);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(240);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(105);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(30);

    }

    public static void consNCpSolicitud(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new Render());
        modeloNCP = new DefaultTableModel(datosNCP, columnNCP) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, true
            };
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
        tabla.setModel(modeloNCP);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(85);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(20);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(350);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(15);

    }

    public void consCompras(JTable tabla) {
        modelo = new DefaultTableModel(datos, consCompras);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(85);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(210);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(105);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(85);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(80);

    }

    public static void consNCProveedor(JTable tabla) {
        modeloconsNCProveedor = new DefaultTableModel(datosconsNCProveedor, columnconsNCProveedor);
        tabla.setModel(modeloconsNCProveedor);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(85);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(210);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(85);

    }
    
    public static void consPagosVentas(JTable tabla) {
        modeloconsPagosVentas = new DefaultTableModel(datosconsPagosVentas, columnconsPagosVentas);
        tabla.setModel(modeloconsPagosVentas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
    }
    
    public static void Perfiles(JTable tabla) {
        modeloPerfiles = new DefaultTableModel(datosPerfiles, columnPerfiles);
        tabla.setModel(modeloPerfiles);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
    }
    
    public static void consDetallePagosVentas1(JTable tabla) {
        modeloconsDetallePagosVentas1 = new DefaultTableModel(datosconsDetallePagosVentas1, columnconsDetallePagosVentas1);
        tabla.setModel(modeloconsDetallePagosVentas1);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
    }
    
    public static void consDetallePagosVentas2(JTable tabla) {
        modeloconsDetallePagosVentas2 = new DefaultTableModel(datosconsDetallePagosVentas2, columnconsDetallePagosVentas2);
        tabla.setModel(modeloconsDetallePagosVentas2);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(95);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }
    
    public static void consDetallePagosVentas3(JTable tabla) {
        modeloconsDetallePagosVentas3 = new DefaultTableModel(datosconsDetallePagosVentas3, columnconsDetallePagosVentas3);
        tabla.setModel(modeloconsDetallePagosVentas3);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(95);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
    }

    public static void detalleSolicitudNCP(JTable tabla) {
        modeloDNCP = new DefaultTableModel(datosDNCP, columnDNCO);
        tabla.setModel(modeloDNCP);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(15);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(40);

    }

    public static void consVentasMoviles(JTable tabla) {
        modeloVentasMoviles = new DefaultTableModel(datosVentasMoviles, consVentasMoviles);
        tabla.setModel(modeloVentasMoviles);
        /*colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);*/

        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);

    }

    public static void consDetalleVentasMoviles(JTable tabla) {
        modeloDetalleVentasMoviles = new DefaultTableModel(datosDetalleVentasMoviles, consDetalleVentasMoviles);
        tabla.setModel(modeloDetalleVentasMoviles);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(360);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);

    }

    public void consComprasReparto(JTable tabla) {
        modelo = new DefaultTableModel(datos, consCompras);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(75);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(220);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(95);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(120);
    }

    public void consRepartoAnterior(JTable tabla) {
        modelo = new DefaultTableModel(datos, consRepartoAnterior);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(175);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(115);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(115);
    }

    public static void consDetalleCompras(JTable tabla) {
        modeloconsDetalleCompras = new DefaultTableModel(datosconsDetalleCompras, consDetalleCompras);
        tabla.setModel(modeloconsDetalleCompras);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(130);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(505);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(95);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(95);
    }

    public static void consDetalleTransferencias(JTable tabla) {
        modeloDetalleTransfe = new DefaultTableModel(datosDetalleTransf, consDetalleTransferenciasRealizadas);
        tabla.setModel(modeloDetalleTransfe);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(505);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(95);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(95);
    }

    public void consDetalleComprasReparto(JTable tabla) {
        modelo = new DefaultTableModel(datos, consDetalleCompras);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(450);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void consDetalleRepartoAnterior(JTable tabla) {
        modelo = new DefaultTableModel(datos, consDetalleRepartoAnterior);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(410);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
    }

    public void usuario(JTable tabla) {
        modelo = new DefaultTableModel(datos, usuario);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void comision(JTable tabla) {
        modelo = new DefaultTableModel(datos, comisiones);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
    }

    public void busEmpleado(JTable tabla) {
        modelo = new DefaultTableModel(datos, busEmpleado);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
    }

    public void consNotaCredito(JTable tabla) {
        modelo = new DefaultTableModel(datos, consNotaCredito);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void detalleNotasCredito(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleNotaCredito);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public void consFacturasNotas(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void detallePresupuesto(JTable tabla) {
        modelo = new DefaultTableModel(datos, detallePresupuestoF);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public void consPresupuesto(JTable tabla) {
        modelo = new DefaultTableModel(datos, consPresupuesto);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void consFacturas(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);

        /*colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);*/
    }

    public void consFacturasA(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void detalleFactura(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleFactura);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(420);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
    }

    public void detalleFacturaA(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleFactura);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(280);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
    }

    public void presupuesto(JTable tabla) {
        modelo = new DefaultTableModel(datos, presupuestos);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(220);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public void factura(JTable tabla) {
        modelo = new DefaultTableModel(datos, facturas);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(220);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
    }

    public static void buscarCliente(JTable tabla) {
        modeloBuscarCliente = new DefaultTableModel(datosBuscarClientes, clientes);
        tabla.setModel(modeloBuscarCliente);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(300);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void categoria(JTable tabla) {
        modelo = new DefaultTableModel(datos, categoria);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(150);
    }

    public static final void todosReparto(JTable tabla) {
        modelotodosReparto = new DefaultTableModel(datosTodosR, todosReparts) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelotodosReparto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(22);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(25);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(30);
    }

    public static final void TodasLasSolicitudes(JTable tabla) {
        modeloTLS = new DefaultTableModel(datosTLS, TLS) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloTLS);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(10);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(10);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(20);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(10);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(300);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(30);
    }

    public static final void todosTransferencias(JTable tabla) {
        modelotodosTransferencias = new DefaultTableModel(datosTT, datosTransferencias) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelotodosTransferencias);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(20);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(10);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(170);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(170);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(30);
    }

    public static final void todosTransferencias2(JTable tabla) {
        modelotodosTransferencias2 = new DefaultTableModel(datosTT2, datosTransferencias2) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelotodosTransferencias2);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(20);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(10);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(170);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(170);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void reparto(JTable tabla) {
        modeloReparto = new DefaultTableModel(datos, reparto) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloReparto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(370);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);

        /*tabla.setModel(modeloReparto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(370);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(80);*/
    }

    public static void ReporteComision(JTable tabla) {
        modelo = new DefaultTableModel(datos, reporteComision) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(25);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(25);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
    }

    public void busProveedor(JTable tabla) {
        modelo = new DefaultTableModel(datos, provedores);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static void fac_nc_compra(JTable tabla) {
        modelo_fac_nc_compra = new DefaultTableModel(datos_fac_nc_compra, fac_nc_compra);
        tabla.setModel(modelo_fac_nc_compra);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(320);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
    }

    public static void fac_nc_venta(JTable tabla) {
        modelo_fac_nc_venta = new DefaultTableModel(datos_fac_nc_venta, fac_nc_venta);
        tabla.setModel(modelo_fac_nc_venta);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(320);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static void ventas(JTable tabla) {
        modeloVentas = new DefaultTableModel(datosVentas, facturas);
        tabla.setModel(modeloVentas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(335);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static void compras(JTable tabla) {
        modeloCompras = new DefaultTableModel(datosCompras, compras);
        tabla.setModel(modeloCompras);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(365);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(20);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(21);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static void ncCompras(JTable tabla) {
        modeloncCompras = new DefaultTableModel(datosncCompras, nccompras);
        tabla.setModel(modeloncCompras);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(360);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
    }
    
    public static void ncVenta(JTable tabla) {
        modeloncVentas = new DefaultTableModel(datosncVentas, ncventa);
        tabla.setModel(modeloncVentas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(360);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
    }

    public static void DetallePagos(JTable tabla) {
        modeloPagosCompra = new DefaultTableModel(datosPagosCompra, pagoCompra) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloPagosCompra);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(210);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);

    }

    public void detalleSalidas(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleSalida);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);

    }

    public void consultaSalidas(JTable tabla) {
        modelo = new DefaultTableModel(datos, conSalidas);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(240);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(220);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(80);

    }

    public static void Transferencia(JTable tabla) {

        modeloTrans = new DefaultTableModel(datosTrans, transferencia) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloTrans);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(350);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
    }

    public static void tablaArticuloAuxiliar(JTable tabla) {
        modeloArtAux = new DefaultTableModel(datosArtAux, articulosBuscaVenta);
        tabla.setModel(modeloArtAux);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
    }

    public static void tablaArticuloAuxiliarSalida(JTable tabla) {
        modeloArtAuxSalida = new DefaultTableModel(datosArtAuxSalida, articulosSalida);
        tabla.setModel(modeloArtAuxSalida);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
    }

    public static void tablaArticuloAuxiliarCompra(JTable tabla) {
        modeloArtAuxCompra = new DefaultTableModel(datosArtAuxCompra, articulosCompra);
        tabla.setModel(modeloArtAuxCompra);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public void tablaArticuloAuxiliarReparto(JTable tabla) {
        modelo = new DefaultTableModel(datos, articulosAux_reparto);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(440);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public static void salidas(JTable tabla) {
        modeloSalida = new DefaultTableModel(datosSalida, salidas);
        tabla.setModel(modeloSalida);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(340);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
    }

    public void motivo(JTable tabla) {
        modelo = new DefaultTableModel(datos, motivo);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(390);
    }

    public void clasificacion(JTable tabla) {
        modelo = new DefaultTableModel(datos, clasificacion);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(270);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
    }

    public void UM(JTable tabla) {
        modelo = new DefaultTableModel(datos, um);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(300);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(110);
    }

    public void Timbrado(JTable tabla) {
        modelo = new DefaultTableModel(datos, timbrado);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(135);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(100);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);
    }

    public void PuntoEmision(JTable tabla) {
        modelo = new DefaultTableModel(datos, puntoEmision);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(35);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(35);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(55);
    }

    public void IVA(JTable tabla) {
        modelo = new DefaultTableModel(datos, iva);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(210);
    }

    public void ciudad(JTable tabla) {
        modelo = new DefaultTableModel(datos, ciudad);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(390);
    }

    public void ciudadMovil(JTable tabla) {
        modelo = new DefaultTableModel(datos, ciudadMovil);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void sucursal(JTable tabla) {
        modelo = new DefaultTableModel(datos, sucursal);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(185);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(220);
    }

    /*public void zona(JTable tabla) {
        modelo = new DefaultTableModel(datos, zona);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(150);
    }*/
    public void detalleGasto(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleGasto);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(380);
    }

    public static void ajusteStock(JTable tabla) {
        modeloAjSt = new DefaultTableModel(datosAjSt, articulos);
        tabla.setModel(modeloAjSt);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(190);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void Articulos(JTable tabla) {
        modelo = new DefaultTableModel(datos, articulos);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(270);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(190);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(20);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(30);
    }

    public static void ArticulosMovil(JTable tabla) {
        modeloArtM = new DefaultTableModel(datosArtM, articulosMovil2);
        tabla.setModel(modeloArtM);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(190);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(90);
    }

    public void familia(JTable tabla) {
        modelo = new DefaultTableModel(datos, familia);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
    }

    public static void RefenSolicitudNCP(JTable tabla) {
        modeloRefSolNCP = new DefaultTableModel(datosRefSolNCP, RefSolNCP);
        tabla.setModel(modeloRefSolNCP);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(5);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(120);
    }

    public static void RefTSNC(JTable tabla) {
        modeloRefTSNC = new DefaultTableModel(datosRefTSNC, RefTSNC);
        tabla.setModel(modeloRefTSNC);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
    }
    
    public static void TablaControlNCCliente(JTable tabla) {
        modeloTablaControlNCCliente = new DefaultTableModel(datosTablaControlNCCliente, TablaControlNCCliente);
        tabla.setModel(modeloTablaControlNCCliente);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(50);
    }

    public void laboratorio(JTable tabla) {
        modelo = new DefaultTableModel(datos, laboratorio);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(350);
    }

    public void empresa(JTable tabla) {
        modelo = new DefaultTableModel(datos, empresa);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(260);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(150);
    }

    public void moviles(JTable tabla) {
        modelo = new DefaultTableModel(datos, moviles);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void proveedor(JTable tabla) {
        modelo = new DefaultTableModel(datos, provedores);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(190);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(270);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public void vendedor(JTable tabla) {
        modelo = new DefaultTableModel(datos, vendedores);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(270);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(180);
    }

    public void cliente(JTable tabla) {
        modelo = new DefaultTableModel(datos, clientes) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        /*colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);*/
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(300);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(200);
    }

    public static void clienteContaduria(JTable tabla) {
        modeloClienteContaduria = new DefaultTableModel(datosCC, clientesContaduria) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloClienteContaduria);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(400);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
    }

    public static void actosGravados(JTable tabla) {
        modeloActosGravados = new DefaultTableModel(datosAG, actosGravados) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloActosGravados);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(100);
    }

    public static void ventaCabecera(JTable tabla) {
        modeloVentaCabecera = new DefaultTableModel(datosVC, ventacabecera) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloVentaCabecera);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
    }

    public static void ventaDetalle(JTable tabla) {
        modeloVentaDetalle = new DefaultTableModel(datosVD, ventadetalle) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloVentaDetalle);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(30);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
    }

    public static void detalle_Sol_NC(JTable tabla) {
        modeloDetalle_sol_nc = new DefaultTableModel(datosDetalle_sol_nc, Detalle_sol_nc) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloDetalle_sol_nc);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(2);
    }
}
