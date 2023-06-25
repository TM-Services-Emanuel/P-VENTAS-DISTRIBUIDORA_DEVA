package IU;

import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlNotaCredito;
import Datos.GestionarNotaCretito;
import java.awt.event.KeyEvent;

public class dlgNotasCreditoCompra extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    public dlgNotasCreditoCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cabe.detallePresupuesto(jTable1);
        String cod = GestionarNotaCretito.getCodigo();
        txtCodNota.setText(cod);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        txtCodArticulo = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodNota = new javax.swing.JTextField();
        txtCodFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dcFecha = new datechooser.beans.DateChooserCombo();
        txtFEcha = new javax.swing.JTextField();
        btnBuscarF = new newscomponents.RSButtonBigIcon_new();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        txtTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnBuscarArticulo = new newscomponents.RSButtonBigIcon_new();
        lblDescripcion = new RSMaterialComponent.RSTextFieldMaterial();
        txtCant = new RSMaterialComponent.RSTextFieldMaterial();
        btnAtras = new RSMaterialComponent.RSButtonIconUno();
        jPanel7 = new javax.swing.JPanel();
        txtRUC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtObs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        btnBuscarF1 = new newscomponents.RSButtonBigIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Notas de Credito");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel6.add(btnNuevo);

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
        jPanel6.add(btnGuardar);

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
        jPanel6.add(btnCancelar);

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 190, 60));

        jPanel3.setLayout(new java.awt.GridLayout(1, 6));

        jButton4.setText("*");
        jButton4.setToolTipText("Cambiar cantidad");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Find.png"))); // NOI18N
        jButton8.setText("F5");
        jButton8.setToolTipText("Buscar Artículo");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);

        jButton9.setText("R");
        jButton9.setToolTipText("Quitar un renglón");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 334, 32));

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
        jPanel5.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 0, 20, 20));
        jPanel5.add(txtCodArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 54, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 754, 70));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel1.setText("NC NRO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 7, -1, 23));

        txtCodNota.setEditable(false);
        txtCodNota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodNota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtCodNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 7, 146, 23));

        txtCodFactura.setEditable(false);
        txtCodFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtCodFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 7, 193, 23));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("FECHA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 7, -1, 23));

        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });
        jPanel1.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 7, 25, 23));

        txtFEcha.setEditable(false);
        txtFEcha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFEcha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtFEcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 7, 130, 23));

        btnBuscarF.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarF.setBorder(null);
        btnBuscarF.setText("FACTURA NRO");
        btnBuscarF.setBgHover(new java.awt.Color(255, 255, 255));
        btnBuscarF.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnBuscarF.setFgHover(new java.awt.Color(0, 102, 102));
        btnBuscarF.setFgIcon(new java.awt.Color(0, 102, 102));
        btnBuscarF.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnBuscarF.setFgText(new java.awt.Color(0, 102, 102));
        btnBuscarF.setFocusPainted(false);
        btnBuscarF.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscarF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarF.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscarF.setIconTextGap(0);
        btnBuscarF.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarF.setPixels(0);
        btnBuscarF.setSizeIcon(20.0F);
        btnBuscarF.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFActionPerformed(evt);
            }
        });
        btnBuscarF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarFKeyPressed(evt);
            }
        });
        jPanel1.add(btnBuscarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 7, 100, 23));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 735, 37));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setRowHeight(18);
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 35, 752, 230));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 270, 200, 30));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TOTAL");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 270, 70, 30));

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
        jPanel2.add(btnBuscarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, 106, 23));

        lblDescripcion.setEditable(false);
        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setColorMaterial(new java.awt.Color(0, 102, 102));
        lblDescripcion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblDescripcion.setPhColor(new java.awt.Color(0, 0, 0));
        lblDescripcion.setPlaceholder("DESCRIPCIÓN DEL PRODUCTO");
        jPanel2.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 5, 534, 23));

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
        jPanel2.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 5, 49, 23));

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
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 5, -1, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 224, 754, 310));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRUC.setEditable(false);
        txtRUC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRUC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRUC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 115, 23));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel6.setText("R.U.C.");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 10, -1, 23));

        txtRazonS.setEditable(false);
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 10, 300, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel5.setText("RAZÓN SOCIAL");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 23));

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 61, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel7.setText("DIRECCIÓN");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 80, 23));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel10.setText("OBSERVACIÓN");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, 23));

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 40, 300, 23));

        txtObs.setEditable(false);
        txtObs.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtObs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(txtObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 70, 460, 23));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel8.setText("TEL.");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 40, -1, 23));

        txtVendedor.setEditable(false);
        txtVendedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 115, 23));

        btnBuscarF1.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarF1.setBorder(null);
        btnBuscarF1.setText("ID PROVEEDOR");
        btnBuscarF1.setBgHover(new java.awt.Color(255, 255, 255));
        btnBuscarF1.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnBuscarF1.setFgHover(new java.awt.Color(0, 102, 102));
        btnBuscarF1.setFgIcon(new java.awt.Color(0, 102, 102));
        btnBuscarF1.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnBuscarF1.setFgText(new java.awt.Color(0, 102, 102));
        btnBuscarF1.setFocusPainted(false);
        btnBuscarF1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscarF1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarF1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscarF1.setIconTextGap(0);
        btnBuscarF1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarF1.setPixels(0);
        btnBuscarF1.setSizeIcon(20.0F);
        btnBuscarF1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarF1ActionPerformed(evt);
            }
        });
        btnBuscarF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarF1KeyPressed(evt);
            }
        });
        jPanel7.add(btnBuscarF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 23));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 735, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlNotaCredito.addTabla(jTable1);
        txtCant.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloNCredito bnc = new dlgBuscarArticuloNCredito(null, true);
            bnc.setLocationRelativeTo(null);
            bnc.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            controlNotaCredito.delRenglon(jTable1);
        } catch (Exception e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        controlNotaCredito.actCantidad();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        txtFEcha.setText(Fecha.formatoFecha(dcFecha.getText()));
    }//GEN-LAST:event_dcFechaOnCommit

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            controlNotaCredito.finalizar(jTable1);
        } catch (Exception e) {
            Mensajes.informacion("Lista vacía! Eliga al menos un articulo");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar esta VENTA?");
        if (rpta == 0) {
            //limpiarCampos();
            controlNotaCredito.cancelar();
            txtCant.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnNuevo.requestFocus();
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnSalir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir1KeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalir1KeyPressed

    private void btnBuscarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarFactura bf = new dlgBuscarFactura(null, true);
            bf.setLocationRelativeTo(null);
            bf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No esta conectado con el servidor");
        }
    }//GEN-LAST:event_btnBuscarFActionPerformed

    private void btnBuscarFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFKeyPressed

    private void btnBuscarF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarF1ActionPerformed

    private void btnBuscarF1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarF1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarF1KeyPressed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloNCredito bnc = new dlgBuscarArticuloNCredito(null, true);
            bnc.setLocationRelativeTo(null);
            bnc.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void btnBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticuloKeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarArticuloKeyPressed

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
        validarCampos.soloNumeros(txtCant);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAdd.doClick();
        }
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtCantKeyPressed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        lblDescripcion.setText("");
        txtCant.setText("");
        txtCant.setEnabled(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlgNotasCreditoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgNotasCreditoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgNotasCreditoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgNotasCreditoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                dlgNotasCreditoCompra dialog = new dlgNotasCreditoCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private RSMaterialComponent.RSButtonIconUno btnAtras;
    public static newscomponents.RSButtonBigIcon_new btnBuscarArticulo;
    public static newscomponents.RSButtonBigIcon_new btnBuscarF;
    public static newscomponents.RSButtonBigIcon_new btnBuscarF1;
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static datechooser.beans.DateChooserCombo dcFecha;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static RSMaterialComponent.RSTextFieldMaterial lblDescripcion;
    public static RSMaterialComponent.RSTextFieldMaterial txtCant;
    public static javax.swing.JTextField txtCodArticulo;
    public static javax.swing.JTextField txtCodCliente;
    public static javax.swing.JTextField txtCodFactura;
    public static javax.swing.JTextField txtCodNota;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtFEcha;
    public static javax.swing.JTextField txtObs;
    public static javax.swing.JTextField txtRUC;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
