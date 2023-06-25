package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlMotivo;
import Datos.GestionarMotivo;
import javax.swing.JOptionPane;

public class dlgMotivo extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgMotivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.motivo(tbMotivo);
        controlMotivo.listMotivo(tbMotivo);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar motivos");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar motivos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMotivo = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 20, 20));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 9));

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
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel1.add(btnNuevo);

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
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });
        jPanel1.add(btnModificar);

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
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel1.add(btnGuardar);

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
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBgHover(new java.awt.Color(0, 153, 153));
        btnEliminar.setEnabled(false);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnEliminar.setIconTextGap(0);
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_FOREVER);
        btnEliminar.setPixels(0);
        btnEliminar.setSizeIcon(35.0F);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 25, 300, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 470, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel3.setText("ID Motivo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 85, 47, 23));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 85, 50, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("Motivo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 85, -1, 23));

        txtMotivo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtMotivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtMotivo.setEnabled(false);
        txtMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotivoActionPerformed(evt);
            }
        });
        txtMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMotivoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMotivoKeyTyped(evt);
            }
        });
        jPanel2.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 85, 290, 23));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbMotivo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbMotivo.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMotivo.setGridColor(new java.awt.Color(204, 204, 204));
        tbMotivo.setRowHeight(18);
        tbMotivo.setShowGrid(true);
        tbMotivo.setShowVerticalLines(false);
        tbMotivo.getTableHeader().setResizingAllowed(false);
        tbMotivo.getTableHeader().setReorderingAllowed(false);
        tbMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMotivoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMotivo);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 120, 469, 233));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMotivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMotivoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            btnNuevo.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(false);
            txtMotivo.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);

            int fila = tbMotivo.getSelectedRow();
            String cod = tbMotivo.getValueAt(fila, 0).toString();
            String nom = tbMotivo.getValueAt(fila, 1).toString();

            txtCod.setText(cod);
            txtMotivo.setText(nom);
            txtMotivo.requestFocus();
        }else if(evt.getClickCount() == 1){
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_tbMotivoMouseClicked

    private void txtMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMotivoKeyPressed

    private void txtMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtMotivoKeyTyped

    private void txtMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotivoActionPerformed
        // TODO add your handling code here:
        if (btnGuardar.isEnabled()) {
            btnGuardar.doClick();
        } else {
            btnModificar.doClick();
        }
    }//GEN-LAST:event_txtMotivoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            try {
                cargarComboBox.cargar(dlgSalidaMercaderia.cbMotivo, "SELECT * FROM motivo WHERE mot_indicador='S'");
                cargarComboBox.cargar(dlgCantStock.cbMotivo, "SELECT * FROM motivo WHERE mot_indicador='S'");
            } catch (Exception e) {
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        //teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarMotivo.getCodigo();
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtMotivo.setEnabled(true);
        txtMotivo.setText("");
        CabecerasTablas.limpiarTablas(tbMotivo);
        controlMotivo.listMotivo(tbMotivo);
        txtMotivo.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                controlMotivo.actMotivo();
                CabecerasTablas.limpiarTablas(tbMotivo);
                controlMotivo.listMotivo(tbMotivo);
                btnCancelarActionPerformed(null);
            }
        } catch (Exception ee) {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtMotivo)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarMotivo.getCodigo();
                    txtCod.setText(cod);
                    controlMotivo.addMotivo();
                    CabecerasTablas.limpiarTablas(tbMotivo);
                    controlMotivo.listMotivo(tbMotivo);
                    btnCancelarActionPerformed(null);
                }
            } catch (Exception ee) {
            }
        } else {
            Mensajes.informacion("Debe llenar obligatoriamente el campo Motivo");
            txtMotivo.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtMotivo.setEnabled(false);
        limpiarCampos();
        tbMotivo.clearSelection();
        btnNuevo.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
        int x = tbMotivo.getSelectedRow();
        if (x < 0) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlMotivo.delMotivo();
                    CabecerasTablas.limpiarTablas(tbMotivo);
                    controlMotivo.listMotivo(tbMotivo);
                    btnCancelarActionPerformed(null);
                }
            } catch (Exception ee) {
        }
        
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    void limpiarCampos() {
        txtCod.setText("");
        txtMotivo.setText("");
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
            java.util.logging.Logger.getLogger(dlgMotivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgMotivo dialog = new dlgMotivo(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    public static newscomponents.RSButtonBigIcon_new btnEliminar;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbMotivo;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}
