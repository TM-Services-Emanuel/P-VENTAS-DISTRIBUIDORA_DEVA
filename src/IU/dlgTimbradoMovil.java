package IU;

import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Software;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlTimbradoMovil;
import Datos.GestionarTimbradoMovil;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class dlgTimbradoMovil extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    public dlgTimbradoMovil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.Timbrado(tbTimbrado);
        controlTimbradoMovil.listTimbrado(tbTimbrado);
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestionar Timbrado");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestionar Timbrado");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTimbrado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFDesde = new javax.swing.JTextField();
        dcFDesde = new datechooser.beans.DateChooserCombo();
        txtFHasta = new javax.swing.JTextField();
        cbEstado = new javax.swing.JCheckBox();
        dcFHasta = new datechooser.beans.DateChooserCombo();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAutorizacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFAutori = new javax.swing.JTextField();
        dcFautori = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTimbrado = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(1, 9));

        btnNuevo.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
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
        jPanel1.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
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
        jPanel1.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
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
        jPanel1.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
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
        jPanel1.add(btnCancelar);

        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/garbage30.png"))); // NOI18N
        btnEliminar.setText("Elim-Supr");
        btnEliminar.setToolTipText("Eliminar - Supr");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

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

        javax.swing.GroupLayout OscuroLayout = new javax.swing.GroupLayout(Oscuro);
        Oscuro.setLayout(OscuroLayout);
        OscuroLayout.setHorizontalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        OscuroLayout.setVerticalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        jLabel3.setText("ID");

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Timbrado");

        txtTimbrado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTimbrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimbrado.setEnabled(false);
        txtTimbrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimbradoActionPerformed(evt);
            }
        });
        txtTimbrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimbradoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimbradoKeyTyped(evt);
            }
        });

        jLabel4.setText("Desde");

        txtFDesde.setEditable(false);
        txtFDesde.setBackground(new java.awt.Color(255, 255, 255));
        txtFDesde.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtFDesde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFDesde.setEnabled(false);
        txtFDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDesdeActionPerformed(evt);
            }
        });

        dcFDesde.setEnabled(false);
        dcFDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFDesdeOnCommit(evt);
            }
        });

        txtFHasta.setEditable(false);
        txtFHasta.setBackground(new java.awt.Color(255, 255, 255));
        txtFHasta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtFHasta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFHasta.setEnabled(false);
        txtFHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFHastaActionPerformed(evt);
            }
        });

        cbEstado.setBackground(new java.awt.Color(0, 102, 102));
        cbEstado.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        cbEstado.setForeground(new java.awt.Color(255, 255, 255));
        cbEstado.setText("ACTIVO");
        cbEstado.setEnabled(false);
        cbEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbEstado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cbEstado.setIconTextGap(15);

        dcFHasta.setEnabled(false);
        dcFHasta.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFHastaOnCommit(evt);
            }
        });

        jLabel5.setText("Hasta");

        jLabel6.setText("NR. Autorización");

        txtAutorizacion.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtAutorizacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAutorizacion.setEnabled(false);

        jLabel7.setText("Fecha de Autorización");

        txtFAutori.setEditable(false);
        txtFAutori.setBackground(new java.awt.Color(255, 255, 255));
        txtFAutori.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtFAutori.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFAutori.setEnabled(false);
        txtFAutori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFAutoriActionPerformed(evt);
            }
        });

        dcFautori.setEnabled(false);
        dcFautori.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFautoriOnCommit(evt);
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
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFAutori, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(dcFautori, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimbrado))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAutorizacion)))))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(dcFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(dcFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(txtTimbrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAutorizacion)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbEstado)
                        .addComponent(jLabel7))
                    .addComponent(dcFautori, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFAutori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbTimbrado.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        tbTimbrado.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTimbrado.setGridColor(new java.awt.Color(204, 204, 204));
        tbTimbrado.setRowHeight(18);
        tbTimbrado.setShowVerticalLines(false);
        tbTimbrado.getTableHeader().setResizingAllowed(false);
        tbTimbrado.getTableHeader().setReorderingAllowed(false);
        tbTimbrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTimbradoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTimbrado);

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarTimbradoMovil.getCodigo();
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtTimbrado.setEnabled(true);
        txtTimbrado.setText("");
        dcFDesde.setEnabled(true);
        dcFHasta.setEnabled(true);
        cbEstado.setSelected(true);
        dcFautori.setEnabled(true);
        txtAutorizacion.setEnabled(true);
        txtAutorizacion.setText("");
        CabecerasTablas.limpiarTablas(tbTimbrado);
        controlTimbradoMovil.listTimbrado(tbTimbrado);
        txtTimbrado.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{
            int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea desactivar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION){
                controlTimbradoMovil.delTimbrado();
                CabecerasTablas.limpiarTablas(tbTimbrado);
                controlTimbradoMovil.listTimbrado(tbTimbrado);
                btnCancelarActionPerformed(null);
            }
        }catch(HeadlessException ee){}        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try{
            int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION){
                controlTimbradoMovil.actTimbrado();
                CabecerasTablas.limpiarTablas(tbTimbrado);
                controlTimbradoMovil.listTimbrado(tbTimbrado);
                btnCancelarActionPerformed(null);
            }
        }catch(HeadlessException ee){}        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtTimbrado) ) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    String cod = GestionarTimbradoMovil.getCodigo();
                    txtCod.setText(cod);
                    controlTimbradoMovil.addTimbrado();
                    CabecerasTablas.limpiarTablas(tbTimbrado);
                    controlTimbradoMovil.listTimbrado(tbTimbrado);
                    btnCancelarActionPerformed(null);
                }
            }catch(HeadlessException ee){}            
        }
        else {
            Mensajes.informacion("Debe llenar obligatoriamente los campos Timbrado, Fecha desde y hasta");
            txtTimbrado.requestFocus();
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbTimbradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTimbradoMouseClicked
        // TODO add your handling code here:
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtTimbrado.setEnabled(true);
        txtAutorizacion.setEnabled(true);
        dcFautori.setEnabled(true);
        dcFDesde.setEnabled(true);
        dcFHasta.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(true);

        int fila = tbTimbrado.getSelectedRow();
        String cod = tbTimbrado.getValueAt(fila, 0).toString();
        String nom = tbTimbrado.getValueAt(fila, 1).toString();
        String desde = tbTimbrado.getValueAt(fila, 2).toString();
        String hasta = tbTimbrado.getValueAt(fila, 3).toString();
        String autorizacion = tbTimbrado.getValueAt(fila, 4).toString();
        String faturizacion = tbTimbrado.getValueAt(fila, 5).toString();
        String estado = tbTimbrado.getValueAt(fila, 6).toString();

        txtCod.setText(cod);
        txtTimbrado.setText(nom);
        txtFDesde.setText(desde);
        txtFHasta.setText(hasta);
        txtAutorizacion.setText(autorizacion);
        txtFAutori.setText(faturizacion);
        if(estado.equals("Activo")){
            cbEstado.setSelected(true);
            cbEstado.setEnabled(false);
        }else{
            cbEstado.setSelected(false);
            cbEstado.setEnabled(true);
        }
        txtTimbrado.requestFocus();
    }//GEN-LAST:event_tbTimbradoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtTimbrado.setEnabled(false);
        txtTimbrado.setText("");
        dcFDesde.setEnabled(false);
        dcFHasta.setEnabled(false);
        cbEstado.setEnabled(false);
        cbEstado.setSelected(false);
        dcFautori.setEnabled(false);
        txtAutorizacion.setEnabled(false);
        txtAutorizacion.setText("");
        limpiarCampos();
        tbTimbrado.clearSelection();
        btnNuevo.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTimbradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimbradoKeyPressed
        // TODO add your handling code here:
        if (!txtTimbrado.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtTimbrado);
        }
    }//GEN-LAST:event_txtTimbradoKeyPressed

    private void txtTimbradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimbradoKeyTyped
        // TODO add your handling code here:
        int limite=10;
        if (txtTimbrado.getText().length() == limite) {
            evt.consume();
        }
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtTimbradoKeyTyped

    private void txtTimbradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimbradoActionPerformed
        // TODO add your handling code here:
        if(btnGuardar.isEnabled()){
            btnGuardar.doClick();
        }else{
            btnModificar.doClick();
        }
    }//GEN-LAST:event_txtTimbradoActionPerformed

    private void txtFDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFDesdeActionPerformed

    private void dcFDesdeOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFDesdeOnCommit
        // TODO add your handling code here:
        //txtFDesde.setText(Fecha.fechaCFormulario(dcFDesde.getText()));
        txtFDesde.setText(Fecha.formatoFechaN(dcFDesde.getText()));
    }//GEN-LAST:event_dcFDesdeOnCommit

    private void txtFHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFHastaActionPerformed

    private void dcFHastaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFHastaOnCommit
        // TODO add your handling code here:
        txtFHasta.setText(Fecha.formatoFechaN(dcFHasta.getText()));
    }//GEN-LAST:event_dcFHastaOnCommit

    private void txtFAutoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFAutoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFAutoriActionPerformed

    private void dcFautoriOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFautoriOnCommit
        // TODO add your handling code here:
        txtFAutori.setText(Fecha.formatoFechaN(dcFautori.getText()));
    }//GEN-LAST:event_dcFautoriOnCommit

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    void limpiarCampos()
    {
        txtCod.setText("");
        txtTimbrado.setText("");
        txtFDesde.setText("");
        txtFHasta.setText("");
        txtAutorizacion.setText("");
        txtFAutori.setText("");
        
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgTimbradoMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgTimbradoMovil dialog = new dlgTimbradoMovil(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static javax.swing.JCheckBox cbEstado;
    public static datechooser.beans.DateChooserCombo dcFDesde;
    public static datechooser.beans.DateChooserCombo dcFHasta;
    public static datechooser.beans.DateChooserCombo dcFautori;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTimbrado;
    public static javax.swing.JTextField txtAutorizacion;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtFAutori;
    public static javax.swing.JTextField txtFDesde;
    public static javax.swing.JTextField txtFHasta;
    public static javax.swing.JTextField txtTimbrado;
    // End of variables declaration//GEN-END:variables
}
