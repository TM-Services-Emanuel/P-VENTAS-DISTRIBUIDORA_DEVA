package IU;

import Componentes.Mensajes;
import Componentes.cargarComboBoxMovil;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlProveedor;
import Datos.GestionarProveedor;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public final class dlgGestProveedor extends javax.swing.JDialog {

    public dlgGestProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbCiudad.setVisible(false);
        btnNuevo.doClick();
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        cargarComboBoxMovil.cargarCiudad(cbCiudad, "SELECT * FROM ciudad WHERE estado='S'");
    }

    private void Cancelar() {
        limpiarCampos();
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCiudad.setEnabled(false);
        txtRazonS.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtContacto.setEnabled(false);
        cbCiudad.setEnabled(false);
        txtRuc.setEnabled(false);
        txaS.setEnabled(false);
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        btnNuevo.requestFocus();
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbCiudad = new javax.swing.JTextField();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox();
        btnCiudad = new javax.swing.JButton();
        c5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaS = new javax.swing.JTextArea();
        lbm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 9));

        btnNuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuevo.setText("Nuevo-F1");
        btnNuevo.setToolTipText("Nuevo - F3");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit30.png"))); // NOI18N
        btnModificar.setText("Modif-F5");
        btnModificar.setToolTipText("Modificar - F5");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar-F6");
        btnGuardar.setToolTipText("Guardar - F6");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancel-Esc");
        btnCancelar.setToolTipText("Cancelar - Esc");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar);

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

        javax.swing.GroupLayout OscuroLayout = new javax.swing.GroupLayout(Oscuro);
        Oscuro.setLayout(OscuroLayout);
        OscuroLayout.setHorizontalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OscuroLayout.createSequentialGroup()
                        .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OscuroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        OscuroLayout.setVerticalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("ID PROVEEDOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 100, 30));

        lblCodP.setBackground(new java.awt.Color(255, 255, 255));
        lblCodP.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblCodP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblCodP.setOpaque(true);
        jPanel1.add(lblCodP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 14, 140, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("RAZÓN SOCIAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        txtRazonS.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSKeyTyped(evt);
            }
        });
        jPanel1.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 420, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setText("CONTACTO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 197, 100, 30));

        txtContacto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        txtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactoKeyTyped(evt);
            }
        });
        jPanel1.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 197, 163, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("DIRECCIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 100, 30));

        txtDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 123, 420, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 100, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 30));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("R.U.C.   ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 100, 30));

        txtRuc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 87, 98, 30));

        txtTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, 30));

        txtCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 140, 30));

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jPanel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, 30));

        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jPanel1.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 87, -1, 30));

        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jPanel1.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, 30));

        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jPanel1.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 123, -1, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("CIUDAD");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, 100, 30));

        cbCiudad.setBackground(new java.awt.Color(255, 255, 204));
        cbCiudad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        cbCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiudadActionPerformed(evt);
            }
        });
        cbCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCiudadKeyPressed(evt);
            }
        });
        jPanel1.add(cbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 234, 280, 30));

        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnCiudad.setToolTipText("Gestionar Ciudad");
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(btnCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 234, 20, 31));
        btnCiudad.getAccessibleContext().setAccessibleDescription("");

        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jPanel1.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 234, -1, 30));

        jTabbedPane1.addTab("INFORMACIÓN GENERAL", new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_info_black_24.png")), jPanel1); // NOI18N

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txaS.setColumns(20);
        txaS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txaS.setRows(5);
        txaS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaSKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaS);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 590, 270));

        jTabbedPane1.addTab("OBSERVACIONES", new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_insert_comment_black_24.png")), jPanel2); // NOI18N

        lbm.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        // TODO add your handling code here:
        dlgCiudad pro = new dlgCiudad(null, true);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);
    }//GEN-LAST:event_btnCiudadActionPerformed

    private void txtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtContacto);
        validarCampos.cantCaracteres(txtContacto, 29);
    }//GEN-LAST:event_txtContactoKeyPressed

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtRazonS);
        validarCampos.cantCaracteres(txtRazonS, 49);
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void cbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiudadActionPerformed
        // TODO add your handling code here:
        if (cbCiudad.getSelectedIndex() == 0) {
            lbCiudad.setText("");
        } else {
            String id = cargarComboBoxMovil.getCodidgo(cbCiudad);
            lbCiudad.setText(id);
        }
    }//GEN-LAST:event_cbCiudadActionPerformed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 49);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        //cargarComboBoxMovil.cargarCiudad(cbCiudad, "SELECT * FROM ciudad WHERE estado='S'");
        String cod = GestionarProveedor.getCodigo();
        lblCodP.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnCiudad.setEnabled(true);
        txtRazonS.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtContacto.setEnabled(true);
        txtCelular.setEnabled(true);
        txaS.setEnabled(true);
        txtRazonS.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        if (validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(txtRuc) && validarCampos.estaVacio(txtDireccion) && validarCampos.estaVacio(txtCelular)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlProveedor.actProveedor();
                    actualizartablaProveedores();
                    this.dispose();
                }
            } catch (Exception ee) {
            }
        } else {
            lbm.setText("Campo Obligatorio");
            if (txtRazonS.getText().trim().equals("")) {
                txtRazonS.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtRuc.getText().trim().equals("")) {
                txtRuc.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtDireccion.getText().trim() == null) {
                txtDireccion.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtCelular.getText().trim() == null) {
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
                c5.setVisible(false);
            } else if (lbCiudad.getText().trim().equals("")) {
                cbCiudad.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        if (validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(lbCiudad) && validarCampos.estaVacio(txtRuc) && validarCampos.estaVacio(txtDireccion) && validarCampos.estaVacio(txtCelular)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarProveedor.getCodigo();
                    lblCodP.setText(cod);
                    controlProveedor.addProveedor();
                    actualizartablaProveedores();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        } else {
            lbm.setText("Campo Obligatorio");
            if (txtRazonS.getText().trim().equals("")) {
                txtRazonS.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtRuc.getText().trim().equals("")) {
                txtRuc.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtDireccion.getText().trim().equals("")) {
                txtDireccion.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtCelular.getText().trim().equals("")) {
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
                c5.setVisible(false);
            } else if (lbCiudad.getText().trim().equals("")) {
                cbCiudad.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que deseas cancelar?");
        if (rpta == 0) {
            limpiarCampos();
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnCiudad.setEnabled(false);
            txtRazonS.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtTelefono.setEnabled(false);
            txtCelular.setEnabled(false);
            txtContacto.setEnabled(false);
            cbCiudad.setEnabled(false);
            txtRuc.setEnabled(false);
            txaS.setEnabled(false);
            lbm.setText("");
            c1.setVisible(false);
            c2.setVisible(false);
            c3.setVisible(false);
            c4.setVisible(false);
            btnNuevo.requestFocus();
            this.dispose();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtRazonS.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtDireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 49;
        if (txtContacto.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContactoKeyTyped

    private void txaSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txaS.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txaSKeyTyped

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 11;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtRuc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtCelular.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 12;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtTelefono.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
        txtContacto.requestFocus();
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 12;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtCelular.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void cbCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCiudadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!btnGuardar.isEnabled()) {
                btnModificar.doClick();
            } else {
                btnGuardar.doClick();
            }
        }
    }//GEN-LAST:event_cbCiudadKeyPressed

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
        txtRuc.requestFocus();
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
        cbCiudad.requestFocus();
        cbCiudad.setPopupVisible(true);
    }//GEN-LAST:event_txtContactoActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            actualizartablaProveedores();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    void limpiarCampos() {
        lblCodP.setText("");
        lbCiudad.setText("");
        txtRazonS.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtContacto.setText("");
        txtCelular.setText("");
        txtTelefono.setText("");
        cbCiudad.list();
        txaS.setText("");
    }

    void actualizartablaProveedores() {
        CabecerasTablas cabe = new CabecerasTablas();
        cabe.proveedor(dlgProveedores.tablaProveedores);
        CabecerasTablas.limpiarTablas(dlgProveedores.tablaProveedores);
        controlProveedor.listProveedor(dlgProveedores.tablaProveedores);
    }

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }

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
            java.util.logging.Logger.getLogger(dlgGestProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestProveedor dialog = new dlgGestProveedor(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnCiudad;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    public static javax.swing.JComboBox cbCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField lbCiudad;
    public static javax.swing.JLabel lblCodP;
    private javax.swing.JLabel lbm;
    public static javax.swing.JTextArea txaS;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtContacto;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
