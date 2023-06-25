package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Numero_a_Letra;
import Componentes.RenderDecimal;
import Componentes.RenderDecimal2;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Componentes.RenderDecimal1;
import Componentes.ReporteF;
import static Componentes.URL.urlServer;
import Componentes.traerIP;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import Datos.GestionarArticulosMovil;
import Datos.GestionarFactura;
import Datos.GestionarVendedor;
import java.awt.event.KeyEvent;
import Modelo.ArticuloMovil;
import Modelo.Vendedor;
import com.devazt.networking.HttpClient;
import com.devazt.networking.Response;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Date;

public final class dlgVentas extends javax.swing.JDialog {

    public static Connection con;
    public static Statement stTransaccion;
    public static Statement st;
    public static int PrecioVenta;
    public static double costoiva;
    public static double descuento;
    public static String UsuarioL = "";
    public Reporte jasper;
    static String emp;
    static String dir;
    static String cel;

    private static int idEmision;
    private static String Timbrado;
    private static String Establecimiento;
    private static String Emision;
    private static String Desde;
    private static String Hasta;
    private static int facturaactual;
    private static int facturafin;

    static public Numero_a_Letra d;

    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jasper = new Reporte();
        CabecerasTablas.ventas(tbDetalle);
        Cancelar();
        pintarCondicion();
        Invisible();
        obtenerNFactura();
        titulo();
        d = new Numero_a_Letra();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Venta de Productos");
        } else {
            this.setTitle(Software.getSoftware() + " - Venta de Productos");
        }
        if (Timbrado == null) {
            lbTimbrado.setText("");
        } else {
            lbTimbrado.setText("TIMBRADO N°: " + Timbrado);
        }
        if (Desde == null && Hasta == null) {
            lbValidaz.setText("");
        } else {
            lbValidaz.setText("PERIODO DE VALIDEZ: " + Desde + " AL " + Hasta);
        }
    }

    public void Cancelar() {
        limpiarCampos();
        btnAtras.setEnabled(false);
        lbDescripcionSupermercado.setOpaque(false);
        btnBuscarClientes.setEnabled(false);
        rContado.setEnabled(false);
        rContado.setSelected(true);
        rCredito.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnNuevo.requestFocus();
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    public void Rendes() {
        dlgVentas.tbDetalle.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimal2());
        dlgVentas.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1());
        dlgVentas.tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal1());
        dlgVentas.tbDetalle.getColumnModel().getColumn(7).setCellRenderer(new RenderDecimal1());
        dlgVentas.tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal());
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCond.setVisible(false);
        txtTotalL.setVisible(false);
        lbCred.setVisible(false);
        txtExentaL.setVisible(false);
        txt5L.setVisible(false);
        txt10L.setVisible(false);
        txtNetoL.setVisible(false);
        txtDescuentoL.setVisible(false);
        txtCodArticulo.setVisible(false);
        txtCodCliente.setVisible(false);
        txtdisponibleL.setVisible(false);
        txtFecha.setVisible(false);
        txtidEmision.setVisible(false);
        txt5libre.setVisible(false);
        txt10Libre.setVisible(false);
        btnCant.setVisible(false);
        lbSuper.setVisible(false);
        btnConfirmar.setVisible(false);
    }

    public static void prepararBD() {
        try {
            con = (Connection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                st = (Statement) con.createStatement();
                stTransaccion = (Statement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cant() {
        int total = tbDetalle.getRowCount();
        if (total == 0) {
            etiCant.setText("");
            btnBuscarClientes.setEnabled(true);
        } else if (total == 1) {
            etiCant.setText("1 producto listado para la venta");
            btnBuscarClientes.setEnabled(false);
        } else if (total > 1) {
            etiCant.setText(String.valueOf(total) + " productos listados para la venta");
            btnBuscarClientes.setEnabled(false);
        }
    }

    private void pintarCondicion() {
        if (rContado.isSelected()) {
            rContado.setForeground(new java.awt.Color(0, 102, 102));
            rCredito.setForeground(new java.awt.Color(0, 0, 0));
            lbCond.setText("CONTADO");
        } else {
            rContado.setForeground(new java.awt.Color(0, 0, 0));
            rCredito.setForeground(new java.awt.Color(0, 102, 102));
            lbCond.setText("CREDITO");
        }
    }

    private void limpiarCampos() {
        txtCod.setText("");
        etiCant.setText("");
        lbDescripcionSupermercado.setText("");
        lbSuper.setText("");
        txtidEmision.setText("");
        txtFacturaN.setText("");
        txtFecha.setText("");
        txtfechaF.setText("");
        txtHora.setText("");
        txtFacturaN.setText("");
        txtCodCliente.setText("");
        txtRuc.setText("");
        txtRazonS.setText("");
        rContado.isSelected();
        txtTotalL.setText("0");
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtExenta.setText("0");
        txtExentaL.setText("0");
        txt5L.setText("0");
        txt5.setText("0");
        txt10L.setText("0");
        txt10.setText("0");
        txtNetoL.setText("0");
        txtDescuentoL.setText("0");
        lbCond.setText("");
        txtCaja.setText("");
        txtEstablecimiento.setText("");
        txtEmision.setText("");
        rContado.setSelected(true);
        CabecerasTablas.limpiarTablasVentas(tbDetalle);
        CabecerasTablas.ventas(tbDetalle);
        controlFactura.canCelar();
        txtCodVendedor.setText("");
        lbEmpleado.setText("");
    }

    public static void habilitarCANTCOSTO() {
        if (txtArt.getText().isEmpty()) {
            txtCant.setEnabled(false);
        } else {
            txtCant.setEnabled(true);
        }
    }

    public void llamarReporteHoja1(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja1.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public void llamarReporteHoja2(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja2.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public void llamarReporteHoja3(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja3.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public void llamarReporteHoja4(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja4.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public static void obtenerNFactura() {
        String ip = traerIP.getIP();
        System.out.println(ip.trim());
        try {
            HttpClient obtFact = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        if (status.getResult().equals("rows 0{}")) {
                            Mensajes.error("ERROR FATAL: NO SE ENCUENTRA O NO EXISTE PUNTO DE EMISIÓN PARA ESTA TERMINAL");
                            btnNuevo.setEnabled(false);
                        } else {
                            JSONObject jsonobtFact = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonobtFact.length(); f++) {
                                idEmision = Integer.parseInt(jsonobtFact.getJSONObject("" + f + "").get("idemision").toString());
                                Timbrado = jsonobtFact.getJSONObject("" + f + "").get("timbra").toString();
                                Establecimiento = jsonobtFact.getJSONObject("" + f + "").get("establecimiento").toString();
                                Emision = jsonobtFact.getJSONObject("" + f + "").get("puntoemision").toString();
                                Desde = jsonobtFact.getJSONObject("" + f + "").get("fechadesde").toString();
                                Hasta = jsonobtFact.getJSONObject("" + f + "").get("fechahasta").toString();
                                facturaactual = Integer.parseInt(jsonobtFact.getJSONObject("" + f + "").get("facturaactual").toString());
                                facturafin = Integer.parseInt(jsonobtFact.getJSONObject("" + f + "").get("facturafin").toString());
                            }
                        }
                    } catch (JSONException e) {
                    }
                }
            });
            obtFact.excecute(urlServer() + "getobtenerNFactura.php?param=" + ip.trim());
        } catch (Exception e) {
            System.out.println("err_obtFact: " + e.getMessage());
        }
    }

    public static int DesdeHAsta() {
        int sms = 0;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date hoy = formato.parse(Fecha.fechaCorrecta());
            String hast= Fecha.formatoFechaDd_inver(Hasta);
            Date hasta = formato.parse(hast);
            if (hoy.before(hasta)) {
                sms = 1;
                System.out.println("la fecha de hoy: " + hoy + " es menor a la fecha hasta: " + hasta);
            } else if (hoy.equals(hasta)) {
                sms = 1;
                System.out.println("la fecha de hoy: " + hoy + " es igual a la fecha hasta: " + hasta);
            } else if(hoy.after(hasta)){
                sms = 0;
                System.out.println("la fecha de hoy: " + hoy + " es mayor a la fecha hasta: " + hasta);   
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sms;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dlgFinFactura = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        txtCodVendedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbEmpleado = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnSalir2 = new newscomponents.RSButtonBigIcon_new();
        btnConfirmar = new javax.swing.JButton();
        menuEmergente = new javax.swing.JPopupMenu();
        itemCantidad = new javax.swing.JMenuItem();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFacturaN = new javax.swing.JTextField();
        txtEstablecimiento = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtRazonS = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        btnBuscarClientes = new newscomponents.RSButtonBigIcon_new();
        lbDescripcionSupermercado = new javax.swing.JLabel();
        lbSuper = new javax.swing.JLabel();
        txtfechaF = new javax.swing.JTextField();
        lbTimbrado = new javax.swing.JLabel();
        lbValidaz = new javax.swing.JLabel();
        txtEmision = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtArt = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        etiCant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnBuscarArticulo = new newscomponents.RSButtonBigIcon_new();
        btnAtras = new RSMaterialComponent.RSButtonIconUno();
        jPanel12 = new javax.swing.JPanel();
        rContado = new rojerusan.RSRadioButton();
        rCredito = new rojerusan.RSRadioButton();
        jPanel6 = new javax.swing.JPanel();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtdisponibleL = new javax.swing.JTextField();
        txtTotalL = new javax.swing.JTextField();
        btnCant = new javax.swing.JButton();
        txtidEmision = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        txtCodCliente = new javax.swing.JTextField();
        txtNetoL = new javax.swing.JTextField();
        txtDescuentoL = new javax.swing.JTextField();
        txtCodArticulo = new javax.swing.JTextField();
        txtExentaL = new javax.swing.JTextField();
        txt5L = new javax.swing.JTextField();
        txt10L = new javax.swing.JTextField();
        txt5libre = new javax.swing.JTextField();
        txt10Libre = new javax.swing.JTextField();
        lbCond = new javax.swing.JLabel();
        lbCred = new javax.swing.JLabel();

        dlgFinFactura.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgFinFactura.setUndecorated(true);
        dlgFinFactura.setResizable(false);
        dlgFinFactura.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgFinFacturaWindowOpened(evt);
            }
        });
        dlgFinFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dlgFinFacturaKeyPressed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel9KeyPressed(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodVendedor.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtCodVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVendedorActionPerformed(evt);
            }
        });
        txtCodVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodVendedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodVendedorKeyTyped(evt);
            }
        });
        jPanel9.add(txtCodVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 51, 41, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel9.setText("ID VENDEDOR");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 51, -1, 23));

        lbEmpleado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbEmpleado.setForeground(new java.awt.Color(0, 102, 102));
        lbEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel9.add(lbEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 51, 176, 23));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator3.setOpaque(true);
        jPanel9.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 80, 291, 1));

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jPanel10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel10KeyPressed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VUELTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel13.setText("EFECTIVO");

        txtAbono.setEditable(false);
        txtAbono.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtAbono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbono.setText("0");
        txtAbono.setOpaque(false);
        txtAbono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAbonoMouseClicked(evt);
            }
        });
        txtAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbonoActionPerformed(evt);
            }
        });
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbonoKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel14.setText("VUELTO");

        txtVuelto.setEditable(false);
        txtVuelto.setBackground(new java.awt.Color(255, 255, 255));
        txtVuelto.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtVuelto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVuelto.setText("0");
        txtVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtAbono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(42, 42, 42))
        );

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("TOTAL A COBRAR");

        lblTotal.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EFECTIVO", new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_attach_money_black_18.png")), jPanel10); // NOI18N

        jPanel9.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 87, -1, 273));
        jTabbedPane1.getAccessibleContext().setAccessibleName("EFECTIVO");

        btnSalir2.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir2.setBorder(null);
        btnSalir2.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir2.setFgIcon(new java.awt.Color(0, 102, 102));
        btnSalir2.setFocusPainted(false);
        btnSalir2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir2.setIconTextGap(0);
        btnSalir2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir2.setPixels(0);
        btnSalir2.setSizeIcon(20.0F);
        btnSalir2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnSalir2FocusLost(evt);
            }
        });
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        btnSalir2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalir2KeyPressed(evt);
            }
        });
        jPanel9.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1, 22, 21));

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/accept.png"))); // NOI18N
        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.setEnabled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        btnConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmarKeyPressed(evt);
            }
        });
        jPanel9.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 31, 19));

        javax.swing.GroupLayout dlgFinFacturaLayout = new javax.swing.GroupLayout(dlgFinFactura.getContentPane());
        dlgFinFactura.getContentPane().setLayout(dlgFinFacturaLayout);
        dlgFinFacturaLayout.setHorizontalGroup(
            dlgFinFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinFacturaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dlgFinFacturaLayout.setVerticalGroup(
            dlgFinFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        itemCantidad.setBackground(new java.awt.Color(255, 255, 255));
        itemCantidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_black_20.png"))); // NOI18N
        itemCantidad.setText("MODIFICAR CANTIDAD DE VENTA");
        itemCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        itemCantidad.setOpaque(true);
        itemCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCantidadActionPerformed(evt);
            }
        });
        menuEmergente.add(itemCantidad);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BlancoKeyPressed(evt);
            }
        });
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel1.setText("Operación N°");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 38, 78, -1));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
        });
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 35, 125, 22));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("Fecha y Hora");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 67, 78, -1));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel19.setText("Mov. Caja N°");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 10, -1, -1));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCajaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCajaKeyReleased(evt);
            }
        });
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 7, 125, 22));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("Comprobante  N°: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 67, 100, -1));

        txtFacturaN.setEditable(false);
        txtFacturaN.setBackground(new java.awt.Color(255, 255, 255));
        txtFacturaN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtFacturaN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFacturaN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFacturaN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaNActionPerformed(evt);
            }
        });
        txtFacturaN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaNKeyTyped(evt);
            }
        });
        jPanel1.add(txtFacturaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 63, 110, 22));

        txtEstablecimiento.setEditable(false);
        txtEstablecimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtEstablecimiento.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtEstablecimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstablecimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstablecimientoActionPerformed(evt);
            }
        });
        txtEstablecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstablecimientoKeyPressed(evt);
            }
        });
        jPanel1.add(txtEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 63, 45, 22));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRazonS.setEditable(false);
        txtRazonS.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSKeyPressed(evt);
            }
        });
        jPanel5.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 5, 318, 22));

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
        });
        jPanel5.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 5, 115, 22));

        btnBuscarClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarClientes.setBorder(null);
        btnBuscarClientes.setText("CAMBIAR");
        btnBuscarClientes.setBgHover(new java.awt.Color(255, 255, 255));
        btnBuscarClientes.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnBuscarClientes.setBorderPainted(false);
        btnBuscarClientes.setEnabled(false);
        btnBuscarClientes.setFgHover(new java.awt.Color(0, 102, 102));
        btnBuscarClientes.setFgIcon(new java.awt.Color(0, 102, 102));
        btnBuscarClientes.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnBuscarClientes.setFgText(new java.awt.Color(0, 102, 102));
        btnBuscarClientes.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscarClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBuscarClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscarClientes.setIconTextGap(3);
        btnBuscarClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RECENT_ACTORS);
        btnBuscarClientes.setPixels(0);
        btnBuscarClientes.setSizeIcon(25.0F);
        btnBuscarClientes.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClientesActionPerformed(evt);
            }
        });
        btnBuscarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarClientesKeyPressed(evt);
            }
        });
        jPanel5.add(btnBuscarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 5, 85, 23));

        lbDescripcionSupermercado.setBackground(new java.awt.Color(0, 102, 102));
        lbDescripcionSupermercado.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDescripcionSupermercado.setForeground(new java.awt.Color(255, 255, 255));
        lbDescripcionSupermercado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lbDescripcionSupermercado, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 32, 318, 15));
        jPanel5.add(lbSuper, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 30, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 92, 550, 53));

        txtfechaF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtfechaF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfechaF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtfechaF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfechaFKeyPressed(evt);
            }
        });
        jPanel1.add(txtfechaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 64, 78, 22));

        lbTimbrado.setBackground(new java.awt.Color(255, 255, 255));
        lbTimbrado.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbTimbrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTimbrado.setText("TIMBRADO N°: ");
        lbTimbrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        lbTimbrado.setOpaque(true);
        lbTimbrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbTimbradoKeyPressed(evt);
            }
        });
        jPanel1.add(lbTimbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 7, 320, 21));

        lbValidaz.setBackground(new java.awt.Color(255, 255, 255));
        lbValidaz.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbValidaz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValidaz.setText("VALIDEZ:");
        lbValidaz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        lbValidaz.setOpaque(true);
        lbValidaz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbValidazKeyPressed(evt);
            }
        });
        jPanel1.add(lbValidaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 35, 320, 21));

        txtEmision.setEditable(false);
        txtEmision.setBackground(new java.awt.Color(255, 255, 255));
        txtEmision.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtEmision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmisionActionPerformed(evt);
            }
        });
        txtEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmisionKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 63, 45, 22));

        txtHora.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraKeyPressed(evt);
            }
        });
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 64, 41, 22));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 7, -1, 79));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 89, 570, 150));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TOTAL A FACTURAR");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 305, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 35)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 0, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel7.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 60, 305, 44));

        Blanco.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 127, 327, 111));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        txtArt.setEditable(false);
        txtArt.setBackground(new java.awt.Color(255, 255, 255));
        txtArt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtArt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtActionPerformed(evt);
            }
        });
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArtKeyReleased(evt);
            }
        });

        txtCant.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantKeyPressed(evt);
            }
        });

        etiCant.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        etiCant.setText("Artículos registrados:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(20);
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        tbDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDetalleMousePressed(evt);
            }
        });
        tbDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        btnBuscarArticulo.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarArticulo.setBorder(null);
        btnBuscarArticulo.setText("AGREGAR");
        btnBuscarArticulo.setBgHover(new java.awt.Color(255, 255, 255));
        btnBuscarArticulo.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnBuscarArticulo.setFgHover(new java.awt.Color(0, 102, 102));
        btnBuscarArticulo.setFgIcon(new java.awt.Color(0, 102, 102));
        btnBuscarArticulo.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnBuscarArticulo.setFgText(new java.awt.Color(0, 102, 102));
        btnBuscarArticulo.setFocusPainted(false);
        btnBuscarArticulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscarArticulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarArticulo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscarArticulo.setIconTextGap(10);
        btnBuscarArticulo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnBuscarArticulo.setPixels(0);
        btnBuscarArticulo.setSizeIcon(25.0F);
        btnBuscarArticulo.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });
        btnBuscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarArticuloKeyPressed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnAtras.setEnabled(false);
        btnAtras.setForegroundHover(new java.awt.Color(0, 153, 153));
        btnAtras.setForegroundText(new java.awt.Color(0, 102, 102));
        btnAtras.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BACKSPACE);
        btnAtras.setPreferredSize(new java.awt.Dimension(25, 25));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etiCant, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(etiCant))
        );

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 251, 902, 350));

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel12KeyPressed(evt);
            }
        });

        rContado.setBorder(null);
        buttonGroup1.add(rContado);
        rContado.setForeground(new java.awt.Color(0, 0, 0));
        rContado.setSelected(true);
        rContado.setText("CONTADO");
        rContado.setColorCheck(new java.awt.Color(0, 102, 102));
        rContado.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rContado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });
        rContado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rContadoKeyPressed(evt);
            }
        });

        rCredito.setBorder(null);
        buttonGroup1.add(rCredito);
        rCredito.setForeground(new java.awt.Color(0, 0, 0));
        rCredito.setText("CRÉDITO");
        rCredito.setColorCheck(new java.awt.Color(0, 102, 102));
        rCredito.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rCredito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });
        rCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rCreditoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(rContado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rContado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Blanco.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 90, -1, 32));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir1.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir1.setBorder(null);
        btnSalir1.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir1.setFocusPainted(false);
        btnSalir1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir1.setIconTextGap(0);
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.setPixels(0);
        btnSalir1.setSizeIcon(15.0F);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        btnSalir1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalir1KeyPressed(evt);
            }
        });
        jPanel6.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 20, 20));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnNuevo.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevo.setBorder(null);
        btnNuevo.setText("NUEVO");
        btnNuevo.setBgHover(new java.awt.Color(0, 153, 153));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevo.setPixels(0);
        btnNuevo.setSizeIcon(40.0F);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBgHover(new java.awt.Color(0, 153, 153));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setPixels(0);
        btnGuardar.setSizeIcon(40.0F);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel4.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setBorder(null);
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBgHover(new java.awt.Color(0, 153, 153));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setPixels(0);
        btnCancelar.setSizeIcon(40.0F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel4.add(btnCancelar);

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 23, 200, 56));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXENTAS");

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExenta.setText("0");
        txtExenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtExenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExentaKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");

        txt5.setEditable(false);
        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setText("0");
        txt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt5KeyPressed(evt);
            }
        });

        txt10.setEditable(false);
        txt10.setBackground(new java.awt.Color(255, 255, 255));
        txt10.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10.setText("0");
        txt10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt10KeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt5)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 29, -1, -1));

        jPanel3.setOpaque(false);

        txtdisponibleL.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTotalL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalL.setText("0");

        btnCant.setText("Act. Precio");
        btnCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantActionPerformed(evt);
            }
        });

        txtidEmision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtidEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidEmisionActionPerformed(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodClienteActionPerformed(evt);
            }
        });

        txtNetoL.setEditable(false);
        txtNetoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetoL.setText("0");

        txtDescuentoL.setEditable(false);
        txtDescuentoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuentoL.setText("0");

        txtCodArticulo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtCodArticulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArticuloActionPerformed(evt);
            }
        });

        txtExentaL.setEditable(false);
        txtExentaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExentaL.setText("0");

        txt5L.setEditable(false);
        txt5L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5L.setText("0");

        txt10L.setEditable(false);
        txt10L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10L.setText("0");

        txt5libre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt10Libre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCant, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestar, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(txtdisponibleL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodCliente)
                    .addComponent(txtTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txtidEmision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNetoL, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txt5L))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt10L, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txtDescuentoL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txt5libre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtExentaL, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txt10Libre))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt10L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt5L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdisponibleL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNetoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRestar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCant))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtExentaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescuentoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt10Libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt5libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1))))
        );

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 15, 350, -1));

        lbCond.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 60, 20));

        lbCred.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        lbCred.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 80, 22));

        Blanco.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 911, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        System.out.println(tbDetalle.getRowCount());
        if (tbDetalle.getRowCount() <= 14) {
            controlFactura.addTabla(tbDetalle);
            Rendes();
            cant();
            txtCodArticulo.setText("");
            txtArt.setText("");
            txtCant.setText("");
            btnBuscarArticulo.requestFocus();
            habilitarCANTCOSTO();
            btnBuscarArticuloActionPerformed(null);
        } else {
            Mensajes.Sistema("Se ha alcanzado el número máximo de items habilitado por la factura actual.");
            btnAtras.doClick();
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlFactura.delRenglon(tbDetalle);
            Rendes();
            cant();
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
        validarCampos.soloDecimales(txtCant);
        ArticuloMovil Ar = GestionarArticulosMovil.busArticulo((txtCodArticulo.getText()));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtCant.getText().isEmpty()) {
                txtCant.selectAll();
            } else if (txtCant.getText().equals("0")) {
                txtCant.selectAll();
            } else if (Double.parseDouble(txtCant.getText()) == 0.0) {
                txtCant.selectAll();
            } else if (Double.parseDouble(txtCant.getText()) > Ar.getStock()) {
                Mensajes.error("La cantidad que estas intentando vender supera el stock actual del producto");
                txtCant.requestFocus();
                txtCant.setText(String.valueOf(Ar.getStock()).trim().replace(".0", "").replace(",", ""));
                txtCant.selectAll();
            } else {
                btnAdd.doClick();
            }
        }
    }//GEN-LAST:event_txtCantKeyPressed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCantActionPerformed

    private void txtArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtActionPerformed

    private void txtArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtFacturaNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaNKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtFacturaNKeyPressed

    private void txtFacturaNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaNKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        int limite = 15;
        if (txtFacturaN.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFacturaNKeyTyped

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtAbono.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtAbono.setText(df.format(Integer.valueOf(txtAbono.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbono.setText("0");
                txtAbono.selectAll();

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
        /* try {
            if (txtAbono.getText().trim().length() >= 1) {
                DecimalFormat dff = new DecimalFormat("#0");
                txtAbonoL.setText(dff.format(Integer.valueOf(txtAbono.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbonoL.setText("0");

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }*/
    }//GEN-LAST:event_txtAbonoKeyReleased

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        String cod = GestionarFactura.getCodigo();
        txtCod.setText(cod);
        try {
            HttpClient obtFact = new HttpClient((Response status) -> {
                if (status.isSuccess()) {
                    try {
                        JSONObject jsonobtFact = new JSONObject(status.getResult());
                        for (int f = 0; /*f < jsonProductos.length()*/; f++) {
                            int act = Integer.parseInt(jsonobtFact.getJSONObject("" + f + "").get("facturaactual").toString());
                            int fa = act + 1;
                            switch (String.valueOf(fa).length()) {
                                case 1 ->
                                    txtFacturaN.setText("000000" + (fa));
                                case 2 ->
                                    txtFacturaN.setText("00000" + (fa));
                                case 3 ->
                                    txtFacturaN.setText("0000" + (fa));
                                case 4 ->
                                    txtFacturaN.setText("000" + (fa));
                                case 5 ->
                                    txtFacturaN.setText("00" + (fa));
                                case 6 ->
                                    txtFacturaN.setText("0" + (fa));
                                case 7 ->
                                    txtFacturaN.setText(String.valueOf(fa));
                                default -> {
                                }
                            }
                        }
                    } catch (JSONException e) {
                    }
                }
            });
            obtFact.excecute(urlServer() + "getConfirmarNFactura.php?param=" + txtidEmision.getText().trim());
        } catch (Exception e) {
            System.out.println("err_comprobandoFact: " + e.getMessage());
        }

        String NFactura = txtEstablecimiento.getText().trim() + "-" + txtEmision.getText().trim() + "-" + txtFacturaN.getText().trim();
        String cond = lbCond.getText();
        String est;
        if (cond.equals("CONTADO")) {
            est = "ABONADO";
        } else {
            est = "PENDIENTE";
        }
        UsuarioL = Login.getUsuarioLogueado();
        try {
            int resp = JOptionPane.showConfirmDialog(dlgFinFactura, "¿Seguro que deseas registrar esta Venta al sistema?", "CONFIRMACIÓN DE VENTA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    prepararBD();
                    con.setAutoCommit(false);
                    String sql = "insert into factura values("
                            + txtCod.getText().trim() + ","
                            + txtCodVendedor.getText().trim() + ","
                            + txtCodCliente.getText().trim() + ","
                            + txtCaja.getText().trim() + ","
                            + txtidEmision.getText().trim() + ",'"
                            + NFactura + "','"
                            + lbCond.getText() + "','"
                            + txtFecha.getText() + "','"
                            + txtHora.getText() + "',"
                            + txtTotalL.getText() + ", 0,"
                            + txtExentaL.getText() + ","
                            + txt5L.getText() + ","
                            + txt10L.getText() + ","
                            + "'S','"
                            + UsuarioL + "','"
                            + est + "')";
                    String sql4 = "UPDATE puntoemision set facturaactual=" + Integer.parseInt(txtFacturaN.getText().trim()) + " WHERE idemision=" + txtidEmision.getText().trim();
                    String sql5 = "UPDATE ref set nventa=" + Integer.parseInt(txtFacturaN.getText().trim()) + " WHERE idemision=" + txtidEmision.getText().trim();
                    stTransaccion.executeUpdate(sql);
                    stTransaccion.executeUpdate(sql4);
                    stTransaccion.executeUpdate(sql5);
                    int fila = tbDetalle.getRowCount();
                    for (int j = 0; j < fila; j++) {
                        String filas[] = {
                            tbDetalle.getValueAt(j, 0).toString(),
                            tbDetalle.getValueAt(j, 9).toString(),
                            tbDetalle.getValueAt(j, 3).toString(),
                            tbDetalle.getValueAt(j, 4).toString(),
                            tbDetalle.getValueAt(j, 5).toString(),
                            tbDetalle.getValueAt(j, 6).toString(),
                            tbDetalle.getValueAt(j, 7).toString(),
                            tbDetalle.getValueAt(j, 8).toString(),
                            tbDetalle.getValueAt(j, 10).toString()};//orden
                        sql = "insert into detalle_factura values("
                                + txtCod.getText() + ","
                                + filas[0] + ","
                                + filas[1] + ","
                                + filas[2] + ","
                                + filas[3] + ","
                                + filas[4] + ","
                                + filas[5] + ","
                                + filas[6] + ","
                                + filas[7] + ","
                                + filas[8] + ")";
                        String sql2 = "UPDATE productos SET stock=(stock-" + filas[2] + ") WHERE  idproducto=" + filas[0];
                        stTransaccion.executeUpdate(sql);
                        stTransaccion.executeUpdate(sql2);
                    }
                    con.commit();
                    stTransaccion.close();
                    Mensajes.informacion("VENTA REGISTRADA EXITOSAMENTE!");
                    dlgFinFactura.dispose();
                    if (cond.equals("CONTADO")) {
                        String Letra = d.Convertir((txtTotalL.getText()), true);
                        llamarReporteHoja3(Integer.parseInt(txtCod.getText().trim()), Letra);
                        int segImpr = JOptionPane.showConfirmDialog(this, "¿Desea Imprimir TRIPLICADO Y CUADRUPLICADO?", "CONFIRMACIÓN IMPRESIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (segImpr == JOptionPane.YES_OPTION) {
                            llamarReporteHoja4(Integer.parseInt(txtCod.getText().trim()), Letra);
                        }
                    } else {
                        String Letra = d.Convertir((txtTotalL.getText()), true);
                        llamarReporteHoja3(Integer.parseInt(txtCod.getText().trim()), Letra);
                        int segImpr = JOptionPane.showConfirmDialog(this, "¿Desea Imprimir TRIPLICADO Y CUADRUPLICADO?", "CONFIRMACIÓN IMPRESIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (segImpr == JOptionPane.YES_OPTION) {
                            llamarReporteHoja4(Integer.parseInt(txtCod.getText().trim()), Letra);
                        }
                    }
                    CabecerasTablas.limpiarTablasVentas(tbDetalle);
                    CabecerasTablas.ventas(tbDetalle);
                    controlFactura.canCelar();
                    Cancelar();
                    txtAbono.setText("0");
                    txtVuelto.setText("0");
                    cant();
                } catch (SQLException e) {
                    try {
                        con.rollback();
                        Mensajes.error("TRANSACCIÓN FALLIDA: La venta no fue registrada en el sistema.\nError:ADD_V: " + e.getMessage().toUpperCase());
                        controlFactura.canCelar();
                        dlgFinFactura.dispose();
                    } catch (SQLException se) {
                        Mensajes.error(se.getMessage());
                    }
                }
            }
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtAbonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAbonoMouseClicked
        // TODO add your handling code here:
        //txtAbono.selectAll();
    }//GEN-LAST:event_txtAbonoMouseClicked

    private void dlgFinFacturaWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgFinFacturaWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_dlgFinFacturaWindowOpened

    private void dlgFinFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgFinFacturaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgFinFacturaKeyPressed

    private void txtCodVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVendedorActionPerformed
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtCodVendedor.getText()) <= 0) {
                Mensajes.error("CÓDIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
                btnConfirmar.setEnabled(false);
                txtAbono.setEditable(false);
                txtCodVendedor.requestFocus();
                txtCodVendedor.selectAll();
            } else {
                try {
                    Vendedor vn = GestionarVendedor.busVendedorFactura(txtCodVendedor.getText());
                    if (vn.getNombreV().isEmpty()) {
                        btnConfirmar.setEnabled(false);
                        txtAbono.setEditable(false);
                        txtCodVendedor.requestFocus();
                        txtCodVendedor.selectAll();
                    } else {
                        lbEmpleado.setText(vn.getNombreV());
                        btnConfirmar.setEnabled(true);
                        txtAbono.setEditable(true);
                        txtAbono.requestFocus();
                        txtAbono.selectAll();
                    }

                } catch (Exception e) {
                }

            }
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txtCodVendedorActionPerformed

    private void txtCodVendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCodVendedor);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCodVendedorKeyPressed

    private void txtAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbonoActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtAbono.getText().replace(".", "").replace(",", "")) == 0) {
            btnConfirmar.doClick();
        } else {
            try {
                int calculos = controlFactura.calCulos();
                //txtVuelto.setText(String.valueOf(calculos));
                DecimalFormat df = new DecimalFormat("#,###");
                txtVuelto.setText(df.format(Integer.parseInt(String.valueOf(calculos).trim().replace(".", "").replace(",", ""))));
                txtVuelto.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtAbonoActionPerformed

    private void txtVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoActionPerformed
        // TODO add your handling code here:
        btnConfirmar.doClick();
    }//GEN-LAST:event_txtVueltoActionPerformed

    private void txtEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstablecimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstablecimientoActionPerformed

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MousePressed

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleMousePressed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            if (evt.getClickCount() == 2) {
                menuEmergente.show(tbDetalle, evt.getX(), evt.getY());
            }

        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void itemCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCantidadActionPerformed
        // TODO add your handling code here:
        btnCantActionPerformed(null);
    }//GEN-LAST:event_itemCantidadActionPerformed

    private void txtidEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidEmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidEmisionActionPerformed

    private void txtEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmisionActionPerformed

    private void txtFacturaNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaNActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlFactura.actCantidad(tbDetalle);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnCantActionPerformed

    private void txtCodArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodArticuloActionPerformed

    private void txtCodClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodClienteActionPerformed

    private void btnBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClientesActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarCliente bcliente = new dlgBuscarCliente(null, true);
            bcliente.setLocationRelativeTo(null);
            bcliente.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarClientesActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloVenta baf = new dlgBuscarArticuloVenta(null, true);
            baf.setLocationRelativeTo(null);
            // baf.setLocation(310, 365);
            // baf.setLocation(125, 365);
            baf.setVisible(true);
            btnAtras.setEnabled(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rCreditoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        obtenerNFactura();
        int sms = DesdeHAsta();
        if (sms == 1) {
            if (facturaactual <= facturafin) {
                String cod = GestionarFactura.getCodigo();
                txtCod.setText(cod);
                txtidEmision.setText(String.valueOf(idEmision));
                txtEstablecimiento.setText(Establecimiento);
                txtEmision.setText(Emision);
                int fac = facturaactual + 1;
                switch (String.valueOf(fac).length()) {
                    case 1 ->
                        txtFacturaN.setText("000000" + (fac));
                    case 2 ->
                        txtFacturaN.setText("00000" + (fac));
                    case 3 ->
                        txtFacturaN.setText("0000" + (fac));
                    case 4 ->
                        txtFacturaN.setText("000" + (fac));
                    case 5 ->
                        txtFacturaN.setText("00" + (fac));
                    case 6 ->
                        txtFacturaN.setText("0" + (fac));
                    case 7 ->
                        txtFacturaN.setText(String.valueOf(fac));
                    default -> {
                    }
                }
                try {
                    String FechaI = String.valueOf(Fecha.fechaCorrecta());
                    txtCaja.setText(generarCodigos.getCodigoCajaActual("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                //ClienteMovil Cl = GestionarCliente.busCliente("1");
                controlFactura.selectClienteInicio("1");
                rContado.setSelected(true);
                pintarCondicion();
                txtFecha.setText(Fecha.fechaCorrecta());
                txtfechaF.setText(Fecha.fechaCorrectaFachada());
                txtHora.setText(Fecha.darHoraSinSS());
                btnBuscarClientes.setEnabled(true);
                rContado.setEnabled(true);
                rCredito.setEnabled(true);
                btnBuscarArticulo.setEnabled(true);
                txtCant.setEnabled(true);
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnBuscarClientes.doClick();
                habilitarCANTCOSTO();
                cant();
            } else {
                Mensajes.error("OBSERVACIÓN:\nNo es posible continuar vendiendo.\nSe ha alcanzado la cantidad máxima de facturación para el punto de expedición/emisión actual.\n");
            }
        } else {
            Mensajes.error("OBSERVACIÓN:\nNo es posible continuar vendiendo.\nSe ha alcanzado la fecha habilitada para el punto de expedición/emisión actual.\n");
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getRowCount() <= 0) {
            Mensajes.informacion("La lista de productos a facturar esta vacía.\nRECOMENDACIÓN: Inserte en la tabla los detalles de la venta e intente procesarlo nuevamente.");
            btnBuscarArticulo.doClick();
        } else {
            DecimalFormat df = new DecimalFormat("#,###");
            if (dlgVentas.txtTotalL.getText().trim().length() >= 1) {
                dlgVentas.lblTotal.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
            }
            //dlgFinFactura.setModal(false);
            dlgFinFactura.setSize(313, 370);
            dlgFinFactura.setLocationRelativeTo(this);
            dlgFinFactura.setVisible(true);
            txtCodVendedor.requestFocus();

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar esta VENTA?");
        if (rpta == 0) {
            limpiarCampos();
            //dcFecha.setEnabled(false);
            btnAtras.setEnabled(false);
            lbDescripcionSupermercado.setOpaque(false);
            btnBuscarClientes.setEnabled(false);
            rContado.setEnabled(false);
            rContado.setSelected(true);
            rCredito.setEnabled(false);
            btnBuscarArticulo.setEnabled(false);
            txtCant.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnNuevo.requestFocus();
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void BlancoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BlancoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_BlancoKeyPressed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void txtArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtArtKeyPressed

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleKeyPressed

    private void btnSalir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir1KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalir1KeyPressed

    private void btnBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticuloKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarArticuloKeyPressed

    private void btnBuscarClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarClientesKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarClientesKeyPressed

    private void txtCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCajaKeyPressed

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtfechaFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaFKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtfechaFKeyPressed

    private void txtHoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtHoraKeyPressed

    private void txtEstablecimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstablecimientoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtEstablecimientoKeyPressed

    private void txtEmisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmisionKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtEmisionKeyPressed

    private void lbTimbradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbTimbradoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_lbTimbradoKeyPressed

    private void lbValidazKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbValidazKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_lbValidazKeyPressed

    private void txtExentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExentaKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtExentaKeyPressed

    private void txt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txt5KeyPressed

    private void txt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt10KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txt10KeyPressed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel5KeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel1KeyPressed

    private void rContadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rContadoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_rContadoKeyPressed

    private void rCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rCreditoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_rCreditoKeyPressed

    private void jPanel12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel12KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel12KeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel2KeyPressed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        txtArt.setText("");
        txtCant.setText("");
        txtCant.setEnabled(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtCodVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorKeyTyped
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCodVendedorKeyTyped

    private void txtAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAbonoKeyTyped

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
        try {
            dlgFinFactura.dispose();
            txtCodVendedor.setText("");
            lbEmpleado.setText("");
            txtAbono.setText("0");
            txtVuelto.setText("0");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnSalir2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSalir2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2FocusLost

    private void txtAbonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtAbonoKeyPressed

    private void btnSalir2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir2KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalir2KeyPressed

    private void btnConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnConfirmarKeyPressed

    private void jPanel9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel9KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel9KeyPressed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void jPanel10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel10KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel10KeyPressed

    private void txtCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgVentas dialog = new dlgVentas(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private javax.swing.JButton btnAdd;
    private RSMaterialComponent.RSButtonIconUno btnAtras;
    public static newscomponents.RSButtonBigIcon_new btnBuscarArticulo;
    private newscomponents.RSButtonBigIcon_new btnBuscarClientes;
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    private javax.swing.JButton btnCant;
    public static javax.swing.JButton btnConfirmar;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    private javax.swing.JButton btnRestar;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static newscomponents.RSButtonBigIcon_new btnSalir2;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JDialog dlgFinFactura;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itemCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lbCond;
    public static javax.swing.JLabel lbCred;
    public static javax.swing.JLabel lbDescripcionSupermercado;
    public static javax.swing.JLabel lbEmpleado;
    public static javax.swing.JLabel lbSuper;
    private javax.swing.JLabel lbTimbrado;
    private javax.swing.JLabel lbValidaz;
    public static javax.swing.JLabel lblTotal;
    private javax.swing.JPopupMenu menuEmergente;
    private rojerusan.RSRadioButton rContado;
    private rojerusan.RSRadioButton rCredito;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt10L;
    public static javax.swing.JTextField txt10Libre;
    public static javax.swing.JTextField txt5;
    public static javax.swing.JTextField txt5L;
    public static javax.swing.JTextField txt5libre;
    public static javax.swing.JTextField txtAbono;
    public static javax.swing.JTextField txtArt;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCodArticulo;
    public static javax.swing.JTextField txtCodCliente;
    public static javax.swing.JTextField txtCodVendedor;
    public static javax.swing.JTextField txtDescuentoL;
    public static javax.swing.JTextField txtEmision;
    public static javax.swing.JTextField txtEstablecimiento;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtExentaL;
    public static javax.swing.JTextField txtFacturaN;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtNetoL;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalL;
    public static javax.swing.JTextField txtVuelto;
    public static javax.swing.JTextField txtdisponibleL;
    public static javax.swing.JTextField txtfechaF;
    private javax.swing.JTextField txtidEmision;
    // End of variables declaration//GEN-END:variables

    private void teclaPresionada(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_F9 ->
                btnBuscarArticulo.doClick();
            case KeyEvent.VK_F3 ->
                btnBuscarClientes.doClick();
            case KeyEvent.VK_F6 ->
                btnGuardar.doClick();
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_ESCAPE ->
                btnCancelar.doClick();
            case KeyEvent.VK_DELETE ->
                btnRestar.doClick();
            default -> {
            }
        }
    }

}
