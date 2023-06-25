package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.RenderDecimalconPuntos;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.cargarComboBoxMovil;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlSalida;
import Datos.GestionarArticulosMovil;
import Datos.GestionarSalida;
import Modelo.ArticuloMovil;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class dlgSalidaMercaderia extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    static ArticuloMovil arti;
    public static Connection con;
    public static Statement stTransaccion;
    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgSalidaMercaderia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        lblCodArt.setVisible(false);
        CabecerasTablas.salidas(tbDetalle);
        cargarComboBoxMovil.cargarCboProveedor(cbProveedor, "SELECT pro_codigo, pro_razonsocial, pro_indicador FROM proveedor WHERE pro_indicador='S'");
        cargarComboBoxMovil.cargarCboMotivo_Salida(cbPara, "SELECT * FROM motivo_salida WHERE estado='S'");
        cargarComboBoxMovil.cargarCboMotivo(cbMotivo, "SELECT * FROM motivo WHERE mot_indicador='S'");
        cargarComboBoxMovil.cargarCboDeposito(cbDeposito, "SELECT * FROM depositos WHERE tipo='B' AND estado='S'");

        btnCancelarActionPerformed(null);
        invisible();
    }

    private void teclaPresionada(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_F9 ->
                btnBuscar.doClick();
            case KeyEvent.VK_F6 ->
                btnGuardar.doClick();
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_ESCAPE ->
                btnCancelar.doClick();
            case KeyEvent.VK_DELETE ->
                btnQuitar.doClick();
            default -> {
            }
        }
    }

    private void invisible() {
        btnQuitar.setVisible(false);
        btnAdd.setVisible(false);
        lblMotivo.setVisible(false);
        txtTotalL.setVisible(false);
        txtProveedor.setVisible(false);
        txtFechaR.setVisible(false);
        txtMotivoSalida.setVisible(false);
        txtDeposito.setVisible(false);
        txtTAblaDeposito.setVisible(false);
        lblCodArt.setVisible(false);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Aplicar salida a artículos");
        } else {
            this.setTitle(Software.getSoftware() + " - Aplicar salida a artículos");
        }
    }

    void limpiarCampos() {
        txtCod.setText("");
        dFecha.setText("");
        cbMotivo.setSelectedIndex(0);
        cbProveedor.setSelectedIndex(0);
        cbPara.setSelectedIndex(0);
        cbDeposito.setSelectedIndex(0);
        txtArt.setText("");
        txtCant.setText("0");
        txtTotalL.setText("0");
        txtTotal.setText("0");
        txtObs.setText("");
        txtCaja.setText("");
        txtMotivoSalida.setText("");
        txtDeposito.setText("");
        txtFechaR.setText("");
        txtTAblaDeposito.setText("");
        txtTotalL.setText("");
        lblMotivo.setText("");
        txtProveedor.setText("");
        CabecerasTablas.salidas(tbDetalle);
        CabecerasTablas.limpiarTablasSalida(tbDetalle);
        controlSalida.canCelar();

    }

    public static void cant() {
        int total = tbDetalle.getRowCount();
        etiCant.setText("Registros acumulados: " + String.valueOf(total));
    }

    public static void Renders() {
        dlgSalidaMercaderia.tbDetalle.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimalconPuntos());
        dlgSalidaMercaderia.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal2());
        dlgSalidaMercaderia.tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal2());
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

    private static void bloqueo() {
        if (tbDetalle.getRowCount() == 0) {
            cbPara.setEnabled(true);
            cbDeposito.setEnabled(true);
            cbProveedor.setEnabled(true);
            txtObs.setEnabled(true);
        } else {
            cbPara.setEnabled(false);
            cbDeposito.setEnabled(false);
            cbProveedor.setEnabled(false);
            txtObs.setEnabled(false);
        }
    }
    
    private void ImprimirDocumento(int cod){
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\salidas\\salida.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("ID", cod);
            //agregamos los parametros y la conexion a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, con);
            //se crea el visor con el reporte
            JRViewer jRViewer = new JRViewer(jasperPrint);
            //se elimina elementos del contenedor JPanel
            VisorReportes.jpContainer.removeAll();
            //para el tamaño del reporte se agrega un BorderLayout
            VisorReportes.jpContainer.setLayout(new BorderLayout());
            VisorReportes.jpContainer.add(jRViewer, BorderLayout.CENTER);
            jRViewer.setZoomRatio((float) 0.8);
            jRViewer.setVisible(true);
            VisorReportes.jpContainer.repaint();
            VisorReportes.jpContainer.revalidate();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }
        vr.setLocationRelativeTo(this);
        vr.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnAdd = new javax.swing.JButton();
        txtTotalL = new javax.swing.JTextField();
        lblMotivo = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        txtProveedor = new javax.swing.JTextField();
        txtFechaR = new javax.swing.JTextField();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        lblCodArt = new javax.swing.JTextField();
        txtMotivoSalida = new javax.swing.JTextField();
        txtDeposito = new javax.swing.JTextField();
        txtTAblaDeposito = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblSalida1 = new javax.swing.JLabel();
        dFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbProveedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbPara = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbDeposito = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cbMotivo = new javax.swing.JComboBox();
        btnBuscar = new newscomponents.RSButtonBigIcon_new();
        txtArt = new RSMaterialComponent.RSTextFieldMaterial();
        txtCant = new RSMaterialComponent.RSTextFieldMaterial();
        btnMotivo = new newscomponents.RSButtonBigIcon_new();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        etiCant = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OscuroKeyPressed(evt);
            }
        });
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

        Oscuro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 14, 200, 56));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar a detalle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        Oscuro.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 11, 35, 26));
        Oscuro.add(txtTotalL, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 14, 68, -1));

        lblMotivo.setText("jLabel9");
        Oscuro.add(lblMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 17, -1, -1));

        btnQuitar.setText("Quitar");
        btnQuitar.setToolTipText("Quitar un Renglón");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        Oscuro.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 65, 25));
        Oscuro.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 65, -1));
        Oscuro.add(txtFechaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 14, 78, -1));

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setBorder(null);
        btnSalir.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir.setIconTextGap(0);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setPixels(0);
        btnSalir.setSizeIcon(15.0F);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 20, 20));

        lblCodArt.setEditable(false);
        lblCodArt.setBackground(new java.awt.Color(255, 255, 255));
        lblCodArt.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lblCodArt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(lblCodArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 43, 41, -1));
        Oscuro.add(txtMotivoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 14, 65, -1));
        Oscuro.add(txtDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 65, -1));
        Oscuro.add(txtTAblaDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 90, -1));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 881, 71));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSalida1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblSalida1.setText("OPERACIÓN NRO");
        jPanel1.add(lblSalida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 23));

        dFecha.setEditable(false);
        dFecha.setBackground(new java.awt.Color(255, 255, 255));
        dFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        dFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dFechaActionPerformed(evt);
            }
        });
        dFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dFechaKeyPressed(evt);
            }
        });
        jPanel1.add(dFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 110, 23));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel1.setText("FECHA SALIDA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 23));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SALIDA TOTAL");
        jLabel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel5KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 9, 339, 115));

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
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
        });
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 110, 23));

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtObs.setRows(2);
        txtObs.setAutoscrolls(false);
        txtObs.setBorder(null);
        txtObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtObsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObsKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtObs);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 740, 60));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("OBSERVACIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel3.setText("PROVEEDOR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 23));

        cbProveedor.setBackground(new java.awt.Color(255, 255, 204));
        cbProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProveedorItemStateChanged(evt);
            }
        });
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });
        cbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbProveedorKeyPressed(evt);
            }
        });
        jPanel1.add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 390, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("FINALIDAD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, 23));

        cbPara.setBackground(new java.awt.Color(255, 255, 204));
        cbPara.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbPara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbPara.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbParaItemStateChanged(evt);
            }
        });
        cbPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbParaActionPerformed(evt);
            }
        });
        cbPara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbParaKeyPressed(evt);
            }
        });
        jPanel1.add(cbPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 190, 23));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel6.setText("MOV. NRO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 23));

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
        });
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 110, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel7.setText("APLICAR A");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 23));

        cbDeposito.setBackground(new java.awt.Color(255, 255, 204));
        cbDeposito.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbDeposito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbDeposito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepositoItemStateChanged(evt);
            }
        });
        cbDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepositoActionPerformed(evt);
            }
        });
        cbDeposito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbDepositoKeyPressed(evt);
            }
        });
        jPanel1.add(cbDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 390, 23));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 78, 860, 200));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbMotivo.setBackground(new java.awt.Color(255, 255, 204));
        cbMotivo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbMotivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbMotivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMotivoItemStateChanged(evt);
            }
        });
        cbMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMotivoMouseClicked(evt);
            }
        });
        cbMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMotivoActionPerformed(evt);
            }
        });
        cbMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbMotivoKeyPressed(evt);
            }
        });
        jPanel3.add(cbMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 5, 230, 23));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setBorder(null);
        btnBuscar.setText("AGREGAR");
        btnBuscar.setBgHover(new java.awt.Color(255, 255, 255));
        btnBuscar.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnBuscar.setFgHover(new java.awt.Color(0, 102, 102));
        btnBuscar.setFgIcon(new java.awt.Color(0, 102, 102));
        btnBuscar.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnBuscar.setFgText(new java.awt.Color(0, 102, 102));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscar.setIconTextGap(10);
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnBuscar.setPixels(0);
        btnBuscar.setSizeIcon(25.0F);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });
        jPanel3.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 106, 23));

        txtArt.setEditable(false);
        txtArt.setForeground(new java.awt.Color(0, 0, 0));
        txtArt.setColorMaterial(new java.awt.Color(0, 102, 102));
        txtArt.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtArt.setPhColor(new java.awt.Color(0, 0, 0));
        txtArt.setPlaceholder("DESCRIPCIÓN DEL PRODUCTO");
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArtKeyPressed(evt);
            }
        });
        jPanel3.add(txtArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 5, 420, 23));

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
        jPanel3.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 5, 49, 23));

        btnMotivo.setBackground(new java.awt.Color(0, 102, 102));
        btnMotivo.setBorder(null);
        btnMotivo.setBgHover(new java.awt.Color(255, 0, 0));
        btnMotivo.setFocusPainted(false);
        btnMotivo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnMotivo.setIconTextGap(0);
        btnMotivo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        btnMotivo.setPixels(0);
        btnMotivo.setSizeIcon(15.0F);
        btnMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotivoActionPerformed(evt);
            }
        });
        btnMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnMotivoKeyPressed(evt);
            }
        });
        jPanel3.add(btnMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 5, 23, 23));

        Blanco.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 280, 880, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

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
        });
        tbDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 315, 879, 250));

        etiCant.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        etiCant.setText("Registros acumulados:");
        Blanco.add(etiCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 570, 449, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMotivoActionPerformed
        // TODO add your handling code here:
        if (cbMotivo.getSelectedIndex() == 0) {
            lblMotivo.setText("");
        } else {
            String id = cargarComboBox.getCodidgo(cbMotivo);
            lblMotivo.setText(id);
        }

    }//GEN-LAST:event_cbMotivoActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        arti = GestionarArticulosMovil.busArticulo(lblCodArt.getText());
        try {
            if (txtArt.getText().isEmpty()) {
                Mensajes.informacion("Seleccione un Articulo");
                btnBuscar.doClick();
                //btnBuscar.requestFocus();
            } else if (lblMotivo.getText().isEmpty()) {
                Mensajes.informacion("Seleccione un Motivo");
                cbMotivo.requestFocus();
            } else if (Double.parseDouble(txtCant.getText()) <= 0) {
                Mensajes.error("Ingrese un numero mayor a 0");
                txtCant.requestFocus();
                txtCant.selectAll();
            } else if (Double.parseDouble(txtCant.getText()) > arti.getStock()) {
                Mensajes.informacion("Stock Insuficiente");
                txtCant.setText(String.valueOf(arti.getStock()));
                txtCant.requestFocus();
                txtCant.selectAll();
            } else {
                controlSalida.addTabla(tbDetalle);

                lblCodArt.setText("");
                txtArt.setText("");
                txtCant.setText("");
                cbMotivo.setSelectedIndex(0);
                cant();
                btnMotivo.setEnabled(false);
                cbMotivo.setEnabled(false);
                txtCant.setEnabled(false);
                bloqueo();
                btnBuscar.doClick();
                //Renders();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        try {
            controlSalida.delRenglon(tbDetalle);
            cant();
            Renders();
            bloqueo();
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        /*int fila = tbDetalle.getSelectedRow();
        String des = tbDetalle.getValueAt(fila, 1).toString();
        String cant = tbDetalle.getValueAt(fila, 4).toString();
        txtCant.setText(cant);
        txtArt.setText(des);*/
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        // TODO add your handling code here:
        if (txtTotal.getText().trim().length() >= 1) {
            DecimalFormat df = new DecimalFormat("#,###");
            txtTotal.setText(df.format(Integer.valueOf(txtTotal.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtTotalKeyReleased

    private void cbMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbMotivoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCant.requestFocus();
            txtCant.selectAll();
        }
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_cbMotivoKeyPressed

    private void cbMotivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMotivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMotivoMouseClicked

    private void cbMotivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMotivoItemStateChanged
        // TODO add your handling code here
    }//GEN-LAST:event_cbMotivoItemStateChanged

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
        if (cbProveedor.getSelectedIndex() == 0) {
            txtProveedor.setText("");
        } else {
            cbProveedor.setPopupVisible(true);
            String id = cargarComboBox.getCodidgo(cbProveedor);
            txtProveedor.setText(String.valueOf(id));
        }
    }//GEN-LAST:event_cbProveedorActionPerformed

    private void txtObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObsKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtObsKeyTyped

    private void cbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbProveedorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbDeposito.requestFocus();
            cbDeposito.setPopupVisible(true);
        }
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_cbProveedorKeyPressed

    private void txtObsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObsKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtObsKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarSalida.getCodigo();
        txtCod.setText(cod);
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.getCodigoCajaActual("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        dFecha.setText(Fecha.fechaCorrectaFachada());
        txtFechaR.setText(Fecha.fechaCorrecta());
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnBuscar.setEnabled(true);
        cbProveedor.setEnabled(true);
        txtObs.setEnabled(true);
        tbDetalle.clearSelection();
        cbPara.setEnabled(true);
        cbDeposito.setEnabled(true);
        cbPara.requestFocus();
        cbPara.setPopupVisible(true);
        bloqueo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlSalida.canCelar();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (cbPara.getSelectedIndex() == 0) {
            Mensajes.error("Seleccione la Finalidad");
            cbPara.requestFocus();
            cbPara.setPopupVisible(true);
        } else if (cbProveedor.getSelectedIndex() == 0) {
            Mensajes.error("Seleccione un Proveedor");
            cbProveedor.requestFocus();
            cbProveedor.setPopupVisible(true);
        } else if (cbDeposito.getSelectedIndex() == 0) {
            Mensajes.error("Seleccione el deposito de salida");
            cbDeposito.requestFocus();
            cbDeposito.setPopupVisible(true);
        } else if (txtObs.getText().trim().isEmpty()) {
            Mensajes.error("Ingrese Observación para mayor información de la Salida");
            txtObs.requestFocus();
        } else if (tbDetalle.getRowCount() == 0) {
            Mensajes.error("Tabla de salida vacio, ingrese al menos un artículo");
            btnBuscar.doClick();
        } else {
            /*int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar el registro?", "Guardar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    String cod = GestionarSalida.getCodigo();
                    txtCod.setText(cod);
                    controlSalida.addSalida();
                    //controlSalida.addDetalleSalida();
                    //controlSalida.actStock();
                    btnCancelarActionPerformed(null);
                } catch (Exception e) {
                    Mensajes.error("Error al Guardar: " + e.getMessage());
                }
            }*/
            if (txtMotivoSalida.getText().equals("1")) {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas registrar esta Salida al sistema?", "CONFIRMACIÓN DE Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        try {
                            String usuario = Login.getUsuarioLogueado();
                            prepararBD();
                            con.setAutoCommit(false);
                            String sql = "insert into salida values(" + txtCod.getText() + "," + txtProveedor.getText() + "," + txtDeposito.getText() + ", " + txtCaja.getText() + "," + txtMotivoSalida.getText() + ",'"
                                    + txtFechaR.getText() + "','" + Fecha.darHora() + "'," + txtTotalL.getText() + ", '" + txtObs.getText() + "','S','N','" + usuario + "')";
                            stTransaccion.executeUpdate(sql);
                            int fila = tbDetalle.getRowCount();
                            for (int j = 0; j < fila; j++) {
                                String filas[] = {
                                    tbDetalle.getValueAt(j, 0).toString(), //idproducto // 0
                                    tbDetalle.getValueAt(j, 2).toString(), //idmotivo   // 1
                                    tbDetalle.getValueAt(j, 4).toString(), //cantidad   // 2
                                    tbDetalle.getValueAt(j, 5).toString(), //precio     // 3
                                    tbDetalle.getValueAt(j, 6).toString()};//total      // 4
                                sql = "insert into detalle_salida values(" + txtCod.getText() + "," + filas[0] + "," + filas[1] + "," + filas[2] + "," + filas[3] + "," + filas[4] + ")";
                                String sql2 = "UPDATE " + txtTAblaDeposito.getText().trim() + " SET stock=stock-" + filas[2] + " WHERE  idproducto=" + filas[0];
                                //String sql3 = "UPDATE dañados SET stock=stock+" + filas[2] + " WHERE  idproducto=" + filas[0];
                                stTransaccion.executeUpdate(sql);
                                stTransaccion.executeUpdate(sql2);
                                //stTransaccion.executeUpdate(sql3);
                            }
                            con.commit();
                            stTransaccion.close();
                            Mensajes.informacion("La Salida con Operación N°:" + txtCod.getText() + " ha sido regitrada exitosamente");
                        } catch (SQLException e) {
                            try {
                                con.rollback();
                                Mensajes.error("TRANSACCIÓN FALLIDA: La salida no fue registrada en el sistema.\nError:ADD_S: " + e.getMessage().toUpperCase());
                            } catch (SQLException se) {
                                Mensajes.error(se.getMessage());
                            }
                        }
                        ImprimirDocumento(Integer.parseInt(txtCod.getText()));
                        btnCancelarActionPerformed(null);
                        cant();
                    }
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }

            } else {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas registrar esta Salida al sistema?", "CONFIRMACIÓN DE Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        try {
                            String usuario = Login.getUsuarioLogueado();
                            prepararBD();
                            con.setAutoCommit(false);
                            String sql = "insert into salida values(" + txtCod.getText() + "," + txtProveedor.getText() + "," + txtDeposito.getText() + ", " + txtCaja.getText() + "," + txtMotivoSalida.getText() + ",'"
                                    + txtFechaR.getText() + "','" + Fecha.darHora() + "'," + txtTotalL.getText() + ", '" + txtObs.getText() + "','S','N','" + usuario + "')";
                            stTransaccion.executeUpdate(sql);
                            int fila = tbDetalle.getRowCount();
                            for (int j = 0; j < fila; j++) {
                                String filas[] = {
                                    tbDetalle.getValueAt(j, 0).toString(), //idproducto // 0
                                    tbDetalle.getValueAt(j, 2).toString(), //idmotivo   // 1
                                    tbDetalle.getValueAt(j, 4).toString(), //cantidad   // 2
                                    tbDetalle.getValueAt(j, 5).toString(), //precio     // 3
                                    tbDetalle.getValueAt(j, 6).toString()};//total      // 4
                                sql = "insert into detalle_salida values(" + txtCod.getText() + "," + filas[0] + "," + filas[1] + "," + filas[2] + "," + filas[3] + "," + filas[4] + ")";
                                String sql2 = "UPDATE " + txtTAblaDeposito.getText().trim() + " SET stock=stock-" + filas[2] + " WHERE  idproducto=" + filas[0];
                                String sql3 = "UPDATE dañados SET stock=stock+" + filas[2] + " WHERE  idproducto=" + filas[0];
                                stTransaccion.executeUpdate(sql);
                                stTransaccion.executeUpdate(sql2);
                                stTransaccion.executeUpdate(sql3);
                            }
                            con.commit();
                            stTransaccion.close();
                            Mensajes.informacion("La Salida con Operación N°:" + txtCod.getText() + " ha sido regitrada exitosamente");
                        } catch (SQLException e) {
                            try {
                                con.rollback();
                                Mensajes.error("TRANSACCIÓN FALLIDA: La salida no fue registrada en el sistema.\nError:ADD_C: " + e.getMessage().toUpperCase());
                            } catch (SQLException se) {
                                Mensajes.error(se.getMessage());
                            }
                        }
                        ImprimirDocumento(Integer.parseInt(txtCod.getText()));
                        btnCancelarActionPerformed(null);
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
        limpiarCampos();
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnMotivo.setEnabled(false);
        cbMotivo.setEnabled(false);
        dFecha.setEnabled(false);
        txtCod.setEnabled(false);
        txtCant.setEnabled(false);
        cbProveedor.setEnabled(false);

        txtObs.setEnabled(false);
        cbPara.setEnabled(false);
        cbDeposito.setEnabled(false);
        cant();
        btnNuevo.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void dFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dFechaActionPerformed

    private void cbParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbParaActionPerformed
        // TODO add your handling code here:
        if (cbPara.getSelectedIndex() == 0) {
            txtMotivoSalida.setText("");
        } else {
            cbPara.setPopupVisible(true);
            String id = cargarComboBox.getCodidgo(cbPara);
            txtMotivoSalida.setText(String.valueOf(id));
        }
    }//GEN-LAST:event_cbParaActionPerformed

    private void cbParaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbParaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbProveedor.requestFocus();
            cbProveedor.setPopupVisible(true);
        }
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_cbParaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticulo art = new dlgBuscarArticulo(null, true);
            art.setLocationRelativeTo(null);
            art.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void txtCantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantMouseClicked
        // TODO add your handling code here:
        txtCant.selectAll();
    }//GEN-LAST:event_txtCantMouseClicked

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
        if (txtCant.getText().isEmpty()) {
            txtCant.requestFocus();
        } else if (txtCant.getText().equals("0")) {
            txtCant.requestFocus();
        }
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtCant);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdd.doClick();
        }
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCantKeyPressed

    private void btnMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotivoActionPerformed
        // TODO add your handling code here:
        try {
            dlgMotivo la = new dlgMotivo(null, true);
            la.setLocationRelativeTo(null);
            la.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_btnMotivoActionPerformed

    private void btnMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMotivoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnMotivoKeyPressed

    private void txtCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaActionPerformed

    private void cbDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepositoActionPerformed
        // TODO add your handling code here:
        if (cbDeposito.getSelectedIndex() == 0) {
            txtDeposito.setText("");
            txtTAblaDeposito.setText("");
        } else {
            //cbDeposito.setPopupVisible(true);
            String id = cargarComboBox.getCodidgo(cbDeposito);
            String tabla = cargarComboBox.getTablaAAplicar(cbDeposito);
            txtDeposito.setText(String.valueOf(id));
            txtTAblaDeposito.setText(tabla);
        }
    }//GEN-LAST:event_cbDepositoActionPerformed

    private void cbDepositoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbDepositoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtObs.requestFocus();
        }
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_cbDepositoKeyPressed

    private void cbParaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbParaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbParaItemStateChanged

    private void cbProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProveedorItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProveedorItemStateChanged

    private void cbDepositoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepositoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDepositoItemStateChanged

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleKeyPressed

    private void txtArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtArtKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());

    }//GEN-LAST:event_jPanel1KeyPressed

    private void OscuroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OscuroKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_OscuroKeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtTotalKeyPressed

    private void jLabel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel5KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jLabel5KeyPressed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel5KeyPressed

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCodKeyPressed

    private void dFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dFechaKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_dFechaKeyPressed

    private void txtCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCajaKeyPressed

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
            java.util.logging.Logger.getLogger(dlgSalidaMercaderia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgSalidaMercaderia dialog = new dlgSalidaMercaderia(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    public static javax.swing.JButton btnAdd;
    public static newscomponents.RSButtonBigIcon_new btnBuscar;
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnMotivo;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    private javax.swing.JButton btnQuitar;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    public static javax.swing.JComboBox<String> cbDeposito;
    public static javax.swing.JComboBox cbMotivo;
    public static javax.swing.JComboBox<String> cbPara;
    public static javax.swing.JComboBox<String> cbProveedor;
    public static javax.swing.JTextField dFecha;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField lblCodArt;
    public static javax.swing.JLabel lblMotivo;
    public static javax.swing.JLabel lblSalida1;
    public static javax.swing.JTable tbDetalle;
    public static RSMaterialComponent.RSTextFieldMaterial txtArt;
    public static javax.swing.JTextField txtCaja;
    public static RSMaterialComponent.RSTextFieldMaterial txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtDeposito;
    public static javax.swing.JTextField txtFechaR;
    public static javax.swing.JTextField txtMotivoSalida;
    public static javax.swing.JTextArea txtObs;
    public static javax.swing.JTextField txtProveedor;
    public static javax.swing.JTextField txtTAblaDeposito;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalL;
    // End of variables declaration//GEN-END:variables
}
