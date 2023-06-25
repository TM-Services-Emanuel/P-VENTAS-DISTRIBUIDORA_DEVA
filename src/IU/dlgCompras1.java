package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.RenderDecimal1;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlArticuloMovil;
//import Controladores.controlCompra;
import Controladores.controlCompra1;
import Datos.GestionarCompra;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import Modelo.Articulo;
import java.awt.event.KeyEvent;
import java.sql.*;

public final class dlgCompras1 extends javax.swing.JDialog {

    public static Connection con;
    public static Statement stTransaccion;
    public static int PrecioVenta;
    public static double costoiva;
    public static int descuento;
    public static int ganancia;
    public static Articulo ar;
    public static int Pcosto;
    public Reporte jasper;
    static String UsuarioL = "";

    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgCompras1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        jasper = new Reporte();
        CabecerasTablas.compras(tbDetalle);
        Cancelar();
        pintarCondicion();
        Invisible();

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Registrar compras de proveedores");
        } else {
            this.setTitle(Software.getSoftware() + " - Registrar compras de proveedores");
        }
    }

    public static void Cancelar() {
        limpiarCampos();
        //dcFecha.setEnabled(false);
        txtFactura.setEnabled(false);
        btnProveedor.setEnabled(false);
        rContado.setEnabled(false);
        rCredito.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCosto.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        cant();
    }

    public static void prepararBD() {
        try {
            con = (Connection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                stTransaccion = (Statement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Renders() {
        dlgCompras1.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1());
        dlgCompras1.tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal1());
        dlgCompras1.tbDetalle.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimal1());
        dlgCompras1.tbDetalle.getColumnModel().getColumn(12).setCellRenderer(new RenderDecimal1());
        dlgCompras1.tbDetalle.getColumnModel().getColumn(14).setCellRenderer(new RenderDecimal1());
    }

    public void BuscarCoincidenciaFacturaCompra() {
        try {
            prepararBD();
            String sql = "SELECT * FROM compra WHERE com_factura='" + txtFactura.getText() + "' AND proveedor_pro_codigo=" + txtCodProv.getText() + " AND com_indicador='S'";
            ResultSet rss = stTransaccion.executeQuery(sql);
            if (rss.next()) {
                //Mensajes.informacion("Esta compra ya fue registrada");
                Mensajes.informacion("Una compra ya fue registrada con los siguientes parámetros:\n"
                        + "PROVEEDOR: " + txtRuc.getText() + "-" + txtRazonS.getText() + "\n"
                        + "FACTURA N°: " + txtFactura.getText() + "\n"
                        + "Verifica que la numeración ingresada coincida con el documentos físico.");
                txtFactura.requestFocus();
            } else {
                btnBuscarArticulo.doClick();
            }
        } catch (SQLException e) {
        }
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCond.setVisible(false);
        txtTotalL.setVisible(false);
        txtCostoL.setVisible(false);
        txtExentaL.setVisible(false);
        txt5L.setVisible(false);
        txt10L.setVisible(false);
        txtCodProv.setVisible(false);
        txtCodA.setVisible(false);
        btnCantidad.setVisible(false);
        btnPrecio.setVisible(false);
        txtFecha.setVisible(false);
        dcFecha.setVisible(false);
    }

    public static void cant() {
        int total = tbDetalle.getRowCount();
        etiCant.setText("CANT DE PRODUCTOS COMPRADOS: " + String.valueOf(total));
    }

    private void pintarCondicion() {
        if (rContado.isSelected()) {
            rContado.setFont(new java.awt.Font("Tahoma", 1, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 51));
            rCredito.setFont(new java.awt.Font("Tahoma", 0, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 0));
            lbCond.setText("CONTADO");
        } else {
            rContado.setFont(new java.awt.Font("Tahoma", 0, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 0));
            rCredito.setFont(new java.awt.Font("Tahoma", 1, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 51));
            lbCond.setText("CREDITO");
        }
    }

    public static void limpiarCampos() {
        txtCod.setText("");
        txtFecha.setText("");
        txtCaja.setText("");
        txtFactura.setText("");
        txtCodProv.setText("");
        txtFechaFachada.setText("");
        txtRuc.setText("");
        txtRazonS.setText("");
        rCredito.isSelected();
        txtTotalL.setText("0");
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtCosto.setText("");
        //cbAsignación.setSelectedIndex(0);
        txtExenta.setText("0");
        txtExentaL.setText("0");
        txt5L.setText("0");
        txt5.setText("0");
        txt10L.setText("0");
        txt10.setText("0");
        lbCond.setText("");
        rCredito.setSelected(true);
        controlCompra1.array.vaciar();
        CabecerasTablas.compras(tbDetalle);
        CabecerasTablas.limpiarTablasCompras(tbDetalle);

    }

    public static void habilitarCANTCOSTO() {
        if (txtArt.getText().isEmpty()) {
            txtCant.setEnabled(false);
            txtCosto.setEnabled(false);
        } else {
            txtCant.setEnabled(true);
            txtCosto.setEnabled(true);
        }
    }

    private void teclaPresionada(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_F9 ->
                btnBuscarArticulo.doClick();
            case KeyEvent.VK_F3 ->
                btnProveedor.doClick();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoCondicion = new javax.swing.ButtonGroup();
        menuEmergente = new javax.swing.JPopupMenu();
        itmCantidad = new javax.swing.JMenuItem();
        itmPrecio = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itmHistorial = new javax.swing.JMenuItem();
        GrupoTipo = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        txtFecha = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnPrecio = new javax.swing.JButton();
        lbCond = new javax.swing.JLabel();
        dcFecha = new datechooser.beans.DateChooserCombo();
        btnRestar = new javax.swing.JButton();
        btnCantidad = new javax.swing.JButton();
        txtCostoL = new javax.swing.JTextField();
        txtExentaL = new javax.swing.JTextField();
        txt5L = new javax.swing.JTextField();
        txt10L = new javax.swing.JTextField();
        txtTotalL = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCodProv = new javax.swing.JTextField();
        txtCodA = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtRazonS = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        btnProveedor = new newscomponents.RSButtonBigIcon_new();
        txtFechaFachada = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        rContado = new javax.swing.JRadioButton();
        rCredito = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnBuscarArticulo = new newscomponents.RSButtonBigIcon_new();
        etiCant = new javax.swing.JLabel();
        txtCant = new RSMaterialComponent.RSTextFieldMaterial();
        txtArt = new RSMaterialComponent.RSTextFieldMaterial();
        txtCosto = new RSMaterialComponent.RSTextFieldMaterial();
        btnAtras = new RSMaterialComponent.RSButtonIconUno();

        itmCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itmCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        itmCantidad.setText("Modificar Cantidad");
        itmCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCantidadActionPerformed(evt);
            }
        });
        menuEmergente.add(itmCantidad);

        itmPrecio.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itmPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        itmPrecio.setText("Modificar Costo");
        itmPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmPrecioActionPerformed(evt);
            }
        });
        menuEmergente.add(itmPrecio);
        menuEmergente.add(jSeparator2);

        itmHistorial.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itmHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itmHistorial.setText("Consultar Historial de Compra");
        itmHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmHistorialActionPerformed(evt);
            }
        });
        menuEmergente.add(itmHistorial);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setLayout(new java.awt.GridLayout(1, 4));

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        Oscuro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 25, 200, 56));

        btnSalir1.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir1.setBorder(null);
        btnSalir1.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir1.setFocusPainted(false);
        btnSalir1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir1.setIconTextGap(0);
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.setPixels(0);
        btnSalir1.setSizeIcon(20.0F);
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
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 0, 20, 20));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        Oscuro.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        Oscuro.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 20, 23));

        btnPrecio.setText("Act. Precio");
        btnPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecioActionPerformed(evt);
            }
        });
        Oscuro.add(btnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 20, -1));

        lbCond.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Oscuro.add(lbCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 23));

        dcFecha.setEnabled(false);
        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });
        Oscuro.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 27, 23));

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        Oscuro.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 27, -1));

        btnCantidad.setText("Act. Cant");
        btnCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadActionPerformed(evt);
            }
        });
        Oscuro.add(btnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 31, -1));

        txtCostoL.setEditable(false);
        txtCostoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(txtCostoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 46, -1));

        txtExentaL.setEditable(false);
        txtExentaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExentaL.setText("0");
        Oscuro.add(txtExentaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 45, -1));

        txt5L.setEditable(false);
        txt5L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5L.setText("0");
        Oscuro.add(txt5L, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 45, -1));

        txt10L.setEditable(false);
        txt10L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10L.setText("0");
        Oscuro.add(txt10L, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 41, -1));

        txtTotalL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalL.setText("0");
        Oscuro.add(txtTotalL, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 55, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXENTAS");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 86, -1));

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExenta.setText("0");
        txtExenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel8.add(txtExenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, 86, 23));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 6, 86, -1));

        txt5.setEditable(false);
        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setText("0");
        txt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel8.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 21, 86, 23));

        txt10.setEditable(false);
        txt10.setBackground(new java.awt.Color(255, 255, 255));
        txt10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10.setText("0");
        txt10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel8.add(txt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 21, 86, 23));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 6, 86, -1));

        Oscuro.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 35, -1, -1));

        txtCodProv.setEditable(false);
        txtCodProv.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtCodProv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(txtCodProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 60, -1));

        txtCodA.setEditable(false);
        Oscuro.add(txtCodA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 63, -1));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 892, 83));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Operación N°");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 6, 85, 22));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 6, 92, 22));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 64, 85, 22));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Comprobante  Nro: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 64, -1, 22));

        txtFactura.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });
        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFacturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaKeyTyped(evt);
            }
        });
        jPanel1.add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 64, 222, 22));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("Mov.N°");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 35, 85, 22));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCajaActionPerformed(evt);
            }
        });
        txtCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCajaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCajaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 35, 92, 22));

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRazonS.setEditable(false);
        txtRazonS.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        jPanel5.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 10, 280, 23));

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 110, 23));

        btnProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnProveedor.setBorder(null);
        btnProveedor.setText("CAMBIAR");
        btnProveedor.setBgHover(new java.awt.Color(255, 255, 255));
        btnProveedor.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnProveedor.setBorderPainted(false);
        btnProveedor.setEnabled(false);
        btnProveedor.setFgHover(new java.awt.Color(0, 102, 102));
        btnProveedor.setFgIcon(new java.awt.Color(0, 102, 102));
        btnProveedor.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnProveedor.setFgText(new java.awt.Color(0, 102, 102));
        btnProveedor.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnProveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProveedor.setIconTextGap(3);
        btnProveedor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RECENT_ACTORS);
        btnProveedor.setPixels(0);
        btnProveedor.setSizeIcon(25.0F);
        btnProveedor.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        btnProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProveedorKeyPressed(evt);
            }
        });
        jPanel5.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 85, 23));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 93, 520, 44));

        txtFechaFachada.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFechaFachada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaFachada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFechaFachada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFachadaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaFachada, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 64, 92, 22));

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GrupoCondicion.add(rContado);
        rContado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rContado.setText("COMPRA CONTADO");
        rContado.setOpaque(false);
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });
        jPanel6.add(rContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 14));

        GrupoCondicion.add(rCredito);
        rCredito.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rCredito.setSelected(true);
        rCredito.setText("COMPRA CREDITO");
        rCredito.setOpaque(false);
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });
        jPanel6.add(rCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 14));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 6, 333, 33));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("TOTAL FACTURA");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 18, 305, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 102, 102));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel7.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 68, 305, 39));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 6, 326, 130));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 90, 877, 144));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setOpaque(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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
        ));
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(20);
        tbDetalle.setShowGrid(true);
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

        etiCant.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        etiCant.setText("Artículos registrados:");

        txtCant.setForeground(new java.awt.Color(0, 0, 0));
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setColorMaterial(new java.awt.Color(0, 102, 102));
        txtCant.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtCant.setPhColor(new java.awt.Color(0, 0, 0));
        txtCant.setPlaceholder("CANT");
        txtCant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantMouseClicked(evt);
            }
        });
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

        txtArt.setEditable(false);
        txtArt.setForeground(new java.awt.Color(0, 0, 0));
        txtArt.setColorMaterial(new java.awt.Color(0, 102, 102));
        txtArt.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtArt.setPhColor(new java.awt.Color(0, 0, 0));
        txtArt.setPlaceholder("DESCRIPCIÓN DEL PRODUCTO");

        txtCosto.setForeground(new java.awt.Color(0, 0, 0));
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.setColorMaterial(new java.awt.Color(0, 102, 102));
        txtCosto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtCosto.setPhColor(new java.awt.Color(0, 0, 0));
        txtCosto.setPlaceholder("COSTO");
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArt, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiCant, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiCant, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 238, 890, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlCompra1.addTabla(tbDetalle);
        Renders();
        cant();
        txtArt.setText("");
        txtCant.setText("");
        txtCosto.setText("");
        txtCostoL.setText("");
        txtCodA.setText("");
        habilitarCANTCOSTO();
        btnBuscarArticuloActionPerformed(null);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlCompra1.delRenglon(tbDetalle);
            Renders();
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }

    }//GEN-LAST:event_btnRestarActionPerformed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        txtFecha.setText(Fecha.formatoFecha(dcFecha.getText()));
    }//GEN-LAST:event_dcFechaOnCommit

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rCreditoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFactura);
        validarCampos.cantCaracteres(txtFactura, 15);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtFacturaKeyPressed

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaKeyTyped

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
        if (txtFactura.getText().isEmpty()) {
            txtFactura.requestFocus();
        } else {
            BuscarCoincidenciaFacturaCompra();
        }
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void txtCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaActionPerformed

    private void txtCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaKeyPressed

    private void txtCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaKeyTyped

    private void btnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlCompra1.actCantidad(tbDetalle);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnCantidadActionPerformed

    private void btnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecioActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlCompra1.actPrecio(tbDetalle);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnPrecioActionPerformed

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleMousePressed

    private void itmCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCantidadActionPerformed
        // TODO add your handling code here:
        btnCantidadActionPerformed(null);
    }//GEN-LAST:event_itmCantidadActionPerformed

    private void itmPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmPrecioActionPerformed
        // TODO add your handling code here:
        btnPrecioActionPerformed(null);
    }//GEN-LAST:event_itmPrecioActionPerformed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            if (evt.getClickCount() == 2) {
                menuEmergente.show(tbDetalle, evt.getX(), evt.getY());
            }

        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void itmHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmHistorialActionPerformed
        // TODO add your handling code here:
        int fila = tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(tbDetalle.getValueAt(fila, 0).toString());
        //int cod = Integer.parseInt(txtCodA.getText());
        try {
            jasper.Historial_de_compras("\\Reports\\compras\\comprasxart.jasper", "art", cod);
        } catch (Exception e) {
            Mensajes.informacion("Artículo sin Historial de Compras");
            txtCosto.requestFocus();
        }
    }//GEN-LAST:event_itmHistorialActionPerformed

    private void txtFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            if (txtFactura.getText().length() == 3) {
                txtFactura.setText(txtFactura.getText().concat("-"));
            } else if (txtFactura.getText().length() == 7) {
                txtFactura.setText(txtFactura.getText().concat("-"));
            }
        }
    }//GEN-LAST:event_txtFacturaKeyReleased

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlCompra1.array.vaciar();
            try {
                CabecerasTablas.ArticulosMovil(dlgArticulosMovil.tbProductos);
                CabecerasTablas.limpiarTablasArticuloM(tbDetalle);
                controlArticuloMovil.listArticulo(dlgArticulosMovil.tbProductos);
            } catch (Exception e) {
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnSalir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir1KeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalir1KeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarCompra.getCodigo();
        txtCod.setText(cod);
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.getCodigoCajaActual("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pintarCondicion();
        txtFecha.setText(Fecha.fechaCorrecta());
        txtFechaFachada.setText(Fecha.fechaCorrectaFachada());
        //txtFecha.setEnabled(true);
        //dcFecha.setEnabled(true);
        txtFactura.setEnabled(true);
        btnProveedor.setEnabled(true);
        btnProveedor.doClick();
        rContado.setEnabled(true);
        rCredito.setEnabled(true);
        btnBuscarArticulo.setEnabled(true);
        txtCosto.setEnabled(true);
        txtCant.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        habilitarCANTCOSTO();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String cod = GestionarCompra.getCodigo();
        txtCod.setText(cod);
        if (txtFecha.getText().isEmpty()) {
            Mensajes.informacion("Seleccione una Fecha.");
            txtFecha.requestFocus();
        } else if (txtFactura.getText().isEmpty()) {
            Mensajes.informacion("Ingrese la Factura de Compra.");
            txtFactura.requestFocus();
        } else if (txtCodProv.getText().isEmpty()) {
            Mensajes.informacion("Es necesario asociar un proveedor a la compra.");
            btnProveedor.doClick();
        } else if (tbDetalle.getRowCount() <= 0) {
            Mensajes.informacion("Aún no haz añadido ningún producto al detalle.");
            btnBuscarArticulo.doClick();
        } else {
            if (rContado.isSelected()) {
                try {
                    dlgPagoCompra dbp = new dlgPagoCompra(null, true);
                    dbp.setLocationRelativeTo(null);
                    dbp.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("No hay conexión con el servidor");
                }

            } else if (rCredito.isSelected()) {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas registrar esta Compra al sistema?", "CONFIRMACIÓN DE COMPRA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        try {
                            String usuario = UsuarioL = Login.getUsuarioLogueado();
                            prepararBD();
                            con.setAutoCommit(false);
                            String sql = "insert into compra values(" + txtCod.getText() + "," + txtCaja.getText() + "," + txtCodProv.getText() + ", '" + lbCond.getText() + "','" + txtFactura.getText() + "','"
                                    + txtFecha.getText() + "','" + Fecha.darHora() + "'," + txtTotalL.getText() + ", 0,'PENDIENTE', " + txtExentaL.getText() + "," + txt5L.getText() + "," + txt10L.getText() + ",'S','" + usuario + "')";
                            stTransaccion.executeUpdate(sql);
                            int fila = tbDetalle.getRowCount();
                            for (int j = 0; j < fila; j++) {
                                String filas[] = {
                                    tbDetalle.getValueAt(j, 0).toString(), //0
                                    tbDetalle.getValueAt(j, 4).toString(), //1
                                    tbDetalle.getValueAt(j, 6).toString(), //2
                                    tbDetalle.getValueAt(j, 15).toString(), //3
                                    tbDetalle.getValueAt(j, 16).toString(), //4
                                    tbDetalle.getValueAt(j, 7).toString(), //5
                                    tbDetalle.getValueAt(j, 17).toString(),//6
                                    tbDetalle.getValueAt(j, 18).toString(),//7
                                    tbDetalle.getValueAt(j, 19).toString(),//8
                                    tbDetalle.getValueAt(j, 20).toString(),//9
                                    tbDetalle.getValueAt(j, 21).toString(),//10
                                };
                                sql = "insert into detalle_compra values(" + txtCod.getText() + "," + filas[0] + "," + filas[1] + "," + filas[2] + "," + filas[3] + "," + filas[5] + ")";
                                String sql2 = "UPDATE productos SET precio_costo=" + filas[2] + ", ganancia=" + filas[4] + ", por_ganancia=" + filas[6] + ", gananciaminorista=" + filas[7] + ", por_gan_minorista=" + filas[8] + ", ganancia_super=" + filas[9] + ", por_gan_super=" + filas[10] + ", stock=stock+" + filas[1] + " WHERE  idproducto=" + filas[0];
                                stTransaccion.executeUpdate(sql);
                                stTransaccion.executeUpdate(sql2);
                            }
                            con.commit();
                            stTransaccion.close();
                            Mensajes.informacion("La Compra con factura N°:" + txtFactura.getText() + " ha sido regitrada exitosamente");
                        } catch (SQLException e) {
                            try {
                                con.rollback();
                                Mensajes.error("TRANSACCIÓN FALLIDA: La compra no fue registrada en el sistema.\nError:ADD_C: " + e.getMessage().toUpperCase());
                            } catch (SQLException se) {
                                Mensajes.error(se.getMessage());
                            }
                        }
                        Cancelar();
                        cant();
                    }
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar la Compra?");
        if (rpta == 0) {
            limpiarCampos();
            //dcFecha.setEnabled(false);
            txtFactura.setEnabled(false);
            btnProveedor.setEnabled(false);
            rContado.setEnabled(false);
            rCredito.setEnabled(false);
            btnBuscarArticulo.setEnabled(false);
            txtCosto.setEnabled(false);
            txtCant.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            cant();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarProveedor dbp = new dlgBuscarProveedor(null, true);
            dbp.setLocationRelativeTo(null);
            dbp.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProveedorKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnProveedorKeyPressed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloCompra1 bac = new dlgBuscarArticuloCompra1(null, true);
            bac.setLocationRelativeTo(null);
            bac.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void btnBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticuloKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarArticuloKeyPressed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
        if (txtCant.getText().isEmpty()) {
            txtCant.requestFocus();
        } else if (txtCant.getText().equals("0")) {
            txtCant.requestFocus();
        } else {
            txtCosto.requestFocus();
        }
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
        if (txtCosto.getText().isEmpty()) {
            txtCosto.requestFocus();
        } else if (txtCosto.getText().equals("0")) {
            txtCosto.requestFocus();
        } else {
            /*DecimalFormat df = new DecimalFormat("#0");
                txtCostoL.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));*/
            float cant = Float.parseFloat(txtCant.getText());
            int costo = Integer.parseInt(txtCostoL.getText());
            String total = String.valueOf((int) (cant * costo));
            btnAddActionPerformed(null);
        }
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCosto);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            txtCosto.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
        } catch (Exception e) {/*Mensajes.error("Error al formatear costo: "+e.getMessage());*/
        }
        try {
            DecimalFormat df = new DecimalFormat("#0");
            txtCostoL.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
        // TODO add your handling code here:
        txtCosto.selectAll();
    }//GEN-LAST:event_txtCostoMouseClicked

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        txtArt.setText("");
        txtCant.setText("");
        txtCant.setEnabled(false);
        txtCosto.setText("");
        txtCosto.setEnabled(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtCant);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCantKeyPressed

    private void txtCantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantMouseClicked
        // TODO add your handling code here:
        txtCant.selectAll();
    }//GEN-LAST:event_txtCantMouseClicked

    private void txtFechaFachadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFachadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFachadaActionPerformed

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleKeyPressed

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
            java.util.logging.Logger.getLogger(dlgCompras1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgCompras1 dialog = new dlgCompras1(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup GrupoCondicion;
    private javax.swing.ButtonGroup GrupoTipo;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private javax.swing.JButton btnAdd;
    private RSMaterialComponent.RSButtonIconUno btnAtras;
    public static newscomponents.RSButtonBigIcon_new btnBuscarArticulo;
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    private javax.swing.JButton btnCantidad;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    private javax.swing.JButton btnPrecio;
    public static newscomponents.RSButtonBigIcon_new btnProveedor;
    private javax.swing.JButton btnRestar;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static datechooser.beans.DateChooserCombo dcFecha;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itmCantidad;
    private javax.swing.JMenuItem itmHistorial;
    private javax.swing.JMenuItem itmPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JLabel lbCond;
    private javax.swing.JPopupMenu menuEmergente;
    public static javax.swing.JRadioButton rContado;
    public static javax.swing.JRadioButton rCredito;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt10L;
    public static javax.swing.JTextField txt5;
    public static javax.swing.JTextField txt5L;
    public static RSMaterialComponent.RSTextFieldMaterial txtArt;
    public static javax.swing.JTextField txtCaja;
    public static RSMaterialComponent.RSTextFieldMaterial txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCodA;
    public static javax.swing.JTextField txtCodProv;
    public static RSMaterialComponent.RSTextFieldMaterial txtCosto;
    public static javax.swing.JTextField txtCostoL;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtExentaL;
    public static javax.swing.JTextField txtFactura;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtFechaFachada;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalL;
    // End of variables declaration//GEN-END:variables
}
