package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.Software;
import Componentes.cargarComboBoxMovil;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlCiudadMovil;
import Datos.GestionarCiudadMovil;
import static IU.dlgGestClientes.cbCiudad;
import com.mysql.jdbc.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class dlgCiudadMovil extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    public static ResultSet rs;
    public static Statement sentencia;
    public static Connection con;
    
    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgCiudadMovil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.ciudadMovil(tbCiudad);
        controlCiudadMovil.listCiudad(tbCiudad);
        CargarCombos();
        //txtCodDepartamento.setVisible(false);
        prepararBD();
    }

    private void CargarCombos() {
        cargarComboBoxMovil.cargarCboDepartamento(cboDepartamento, "SELECT * FROM departamento WHERE estado='S'");
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar ciudades");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar ciudades");
        }
    }

    public static void prepararBD() {
        try {
            con = (Connection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                sentencia = (Statement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modcboDepartamento(int iddepartamento) {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        try {
            rs = sentencia.executeQuery("SELECT * FROM departamento WHERE estado='S'");
            ml.addElement("SELEC. UNA OPCIÓN");
            while (rs.next()) {
                ml.addElement(rs.getString("departamento"));

            }
            ResultSet rss = sentencia.executeQuery("SELECT * FROM departamento WHERE iddepartamento=" + iddepartamento);
            rss.first();
            Object descripcion = (Object) rss.getString("departamento");
            cboDepartamento.setModel(ml);
            cboDepartamento.setSelectedItem(descripcion);
        } catch (SQLException ew) {
            //Mensajes.error("TIENES UN ERROR AL CARGAR LOS LABORATORIOS: "+ew.getMessage().toUpperCase());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboDepartamento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCiudad = new javax.swing.JTable()
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

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setBorder(null);
        btnSalir.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir.setIconTextGap(0);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setPixels(0);
        btnSalir.setSizeIcon(20.0F);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 4));

        btnNuevo.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevo.setBorder(null);
        btnNuevo.setText("NUEVO");
        btnNuevo.setBgHover(new java.awt.Color(0, 153, 153));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevo.setPixels(0);
        btnNuevo.setSizeIcon(35.0F);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(0, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("MODIFICAR");
        btnModificar.setBgHover(new java.awt.Color(0, 153, 153));
        btnModificar.setEnabled(false);
        btnModificar.setFocusPainted(false);
        btnModificar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnModificar.setIconTextGap(0);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setPixels(0);
        btnModificar.setSizeIcon(35.0F);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBgHover(new java.awt.Color(0, 153, 153));
        btnGuardar.setEnabled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setPixels(0);
        btnGuardar.setSizeIcon(35.0F);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setBorder(null);
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBgHover(new java.awt.Color(0, 153, 153));
        btnCancelar.setEnabled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setPixels(0);
        btnCancelar.setSizeIcon(35.0F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBgHover(new java.awt.Color(0, 153, 153));
        btnEliminar.setEnabled(false);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnEliminar.setIconTextGap(0);
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminar.setPixels(0);
        btnEliminar.setSizeIcon(35.0F);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID CIUDAD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 55, 25));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 25));

        jLabel2.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 25));

        txtCiudad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCiudad.setEnabled(false);
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });
        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiudadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 220, 25));

        jLabel4.setText("DEPARTAMENTO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, 25));

        cboDepartamento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cboDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDepartamento.setEnabled(false);
        cboDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboDepartamentoKeyPressed(evt);
            }
        });
        jPanel1.add(cboDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 220, 25));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tbCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbCiudad.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbCiudad.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCiudad.setGridColor(new java.awt.Color(204, 204, 204));
        tbCiudad.setRowHeight(18);
        tbCiudad.setShowVerticalLines(false);
        tbCiudad.getTableHeader().setResizingAllowed(false);
        tbCiudad.getTableHeader().setReorderingAllowed(false);
        tbCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCiudadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCiudad);

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCiudadMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(true);
            txtCiudad.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            cboDepartamento.setEnabled(false);
        } else if (evt.getClickCount() == 2) {
            btnNuevo.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(false);
            txtCiudad.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);
            cboDepartamento.setEnabled(true);

            int fila = tbCiudad.getSelectedRow();
            String cod = tbCiudad.getValueAt(fila, 0).toString();
            String nom = tbCiudad.getValueAt(fila, 1).toString();
            txtCod.setText(cod);
            txtCiudad.setText(nom);
            modcboDepartamento(Integer.parseInt(tbCiudad.getValueAt(fila, 4).toString()));
            txtCiudad.requestFocus();
        }

    }//GEN-LAST:event_tbCiudadMouseClicked

    private void txtCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtCiudadKeyTyped

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
        cboDepartamento.requestFocus();
        cboDepartamento.setPopupVisible(true);
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void cboDepartamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboDepartamentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (btnGuardar.isEnabled()) {
                btnGuardar.doClick();
            } else {
                btnModificar.doClick();
            }
        }
    }//GEN-LAST:event_cboDepartamentoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarCiudadMovil.getCodigo();
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        txtCiudad.setEnabled(true);
        txtCiudad.setText("");
        cboDepartamento.setEnabled(true);
        CabecerasTablas.limpiarTablas(tbCiudad);
        controlCiudadMovil.listCiudad(tbCiudad);
        txtCiudad.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (cboDepartamento.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Departamento");
            cboDepartamento.requestFocus();
            cboDepartamento.setPopupVisible(true);
        } else if (validarCampos.estaVacio(txtCiudad)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarCiudadMovil.getCodigo();
                    txtCod.setText(cod);
                    controlCiudadMovil.addCiudad();
                    btnNuevo.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    txtCiudad.setEnabled(false);
                    cboDepartamento.setEnabled(false);
                    limpiarCampos();
                    CabecerasTablas.limpiarTablas(tbCiudad);
                    controlCiudadMovil.listCiudad(tbCiudad);
                }
            } catch (Exception ee) {
            }
        } else {
            Mensajes.informacion("Debe llenar obligatoriamente el campo Ciudad");
            txtCiudad.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                btnEliminar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
                txtCiudad.setEnabled(false);
                cboDepartamento.setEnabled(false);
                controlCiudadMovil.delCiudad();
                limpiarCampos();
                CabecerasTablas.limpiarTablas(tbCiudad);
                controlCiudadMovil.listCiudad(tbCiudad);
                btnCancelarActionPerformed(null);
            }
        } catch (Exception ee) {}

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (cboDepartamento.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Departamento");
            cboDepartamento.requestFocus();
            cboDepartamento.setPopupVisible(true);
        } else if (validarCampos.estaVacio(txtCiudad)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlCiudadMovil.actCiudad();
                    btnNuevo.setEnabled(true);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    txtCiudad.setEnabled(false);
                    cboDepartamento.setEnabled(false);
                    limpiarCampos();
                    CabecerasTablas.limpiarTablas(tbCiudad);
                    controlCiudadMovil.listCiudad(tbCiudad);
                }
            } catch (Exception ee) {
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtCiudad.setEnabled(false);
        cboDepartamento.setEnabled(false);

        limpiarCampos();
        tbCiudad.clearSelection();
        btnNuevo.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            try {
                cargarComboBoxMovil.cargar(cbCiudad, "SELECT * FROM ciudad WHERE estado='S'");
                cargarComboBoxMovil.cargar(dlgGestProveedor.cbCiudad, "SELECT * FROM ciudad WHERE estado='S'");
            } catch (Exception e) {
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    void limpiarCampos() {
        txtCod.setText("");
        txtCiudad.setText("");
        cboDepartamento.setSelectedIndex(0);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlgCiudadMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCiudadMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCiudadMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCiudadMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgCiudadMovil dialog = new dlgCiudadMovil(new javax.swing.JFrame(), true);
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
    private newscomponents.RSButtonBigIcon_new btnCancelar;
    private newscomponents.RSButtonBigIcon_new btnEliminar;
    private newscomponents.RSButtonBigIcon_new btnGuardar;
    private newscomponents.RSButtonBigIcon_new btnModificar;
    private newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    public static javax.swing.JComboBox<String> cboDepartamento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tbCiudad;
    public static javax.swing.JTextField txtCiudad;
    public static javax.swing.JTextField txtCod;
    // End of variables declaration//GEN-END:variables
}
