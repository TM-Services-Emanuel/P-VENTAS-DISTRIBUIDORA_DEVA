package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimalconPuntos;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlNCProveedor;
import javax.swing.JOptionPane;

public class dlgConsultarNCProveedor extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgConsultarNCProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        CabecerasTablas.consNCProveedor(tbNC);
        CabecerasTablas.consDetalleCompras(tbDetalleNCP);
        controlNCProveedor.listarNCProveedor(tbNC);
        Renders();
        ocultar(0);

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de compras realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de compras realizadas");
        }
    }

    public static void Renders() {
        dlgConsultarNCProveedor.tbNC.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimal2());
    }

    public static void RendersD() {
        dlgConsultarNCProveedor.tbDetalleNCP.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimalconPuntos());
        dlgConsultarNCProveedor.tbDetalleNCP.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1());
        dlgConsultarNCProveedor.tbDetalleNCP.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal2());

    }

    private void ocultar(int est) {
        if (est == 1) {
            lb1.setVisible(true);
            lb2.setVisible(true);
            lb3.setVisible(true);
            lb4.setVisible(true);
            txtCodCompra.setVisible(true);
            txtmov.setVisible(true);
            txtFactura.setVisible(true);
            txtProveedor.setVisible(true);
        } else if (est == 0) {
            lb1.setVisible(false);
            lb2.setVisible(false);
            lb3.setVisible(false);
            lb4.setVisible(false);
            txtCodCompra.setVisible(false);
            txtmov.setVisible(false);
            txtFactura.setVisible(false);
            txtProveedor.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        btnAnular = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNC = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnBuscarF = new newscomponents.RSButtonBigIcon_new();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleNCP = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lb2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();
        lb3 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        lb4 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        txtmov = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnActualizar.setBackground(new java.awt.Color(0, 102, 102));
        btnActualizar.setBorder(null);
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBgHover(new java.awt.Color(0, 153, 153));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnActualizar.setIconTextGap(0);
        btnActualizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        btnActualizar.setPixels(0);
        btnActualizar.setSizeIcon(40.0F);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        btnActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarKeyPressed(evt);
            }
        });
        jPanel2.add(btnActualizar);

        btnAnular.setBackground(new java.awt.Color(0, 102, 102));
        btnAnular.setBorder(null);
        btnAnular.setText("ANULAR");
        btnAnular.setBgHover(new java.awt.Color(0, 153, 153));
        btnAnular.setFocusPainted(false);
        btnAnular.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnAnular.setIconTextGap(0);
        btnAnular.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DO_NOT_DISTURB_ON);
        btnAnular.setPixels(0);
        btnAnular.setSizeIcon(40.0F);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        btnAnular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAnularKeyPressed(evt);
            }
        });
        jPanel2.add(btnAnular);

        Oscuro.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 140, 56));

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
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 0, 15, 15));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 690, 76));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tbNC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbNC.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNC.setGridColor(new java.awt.Color(204, 204, 204));
        tbNC.setOpaque(false);
        tbNC.setRowHeight(20);
        tbNC.setShowGrid(true);
        tbNC.setShowVerticalLines(false);
        tbNC.getTableHeader().setResizingAllowed(false);
        tbNC.getTableHeader().setReorderingAllowed(false);
        tbNC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNCMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbNCMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbNC);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 109, 688, 225));

        btnBuscarF.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarF.setBorder(null);
        btnBuscarF.setText("BUSCAR NOTA DE CRÉDITO");
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
        Blanco.add(btnBuscarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, 180, 23));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane2.setOpaque(false);

        tbDetalleNCP.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalleNCP.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleNCP.setEnabled(false);
        tbDetalleNCP.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalleNCP.setOpaque(false);
        tbDetalleNCP.setRowHeight(20);
        tbDetalleNCP.setShowGrid(true);
        tbDetalleNCP.setShowVerticalLines(false);
        tbDetalleNCP.getTableHeader().setResizingAllowed(false);
        tbDetalleNCP.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDetalleNCP);

        Blanco.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 398, 688, 258));

        lb2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lb2.setText("MOV. DIARIO NRO:");
        Blanco.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 115, 23));

        lb1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lb1.setText("OPERACIÓN NRO:");
        Blanco.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 23));

        txtCodCompra.setEditable(false);
        txtCodCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtCodCompra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodCompra.setOpaque(false);
        Blanco.add(txtCodCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 110, 23));

        lb3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lb3.setText("APLICADO A LA FACTURA NRO:");
        Blanco.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 180, 23));

        txtFactura.setEditable(false);
        txtFactura.setBackground(new java.awt.Color(255, 255, 255));
        txtFactura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFactura.setOpaque(false);
        Blanco.add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 250, 23));

        lb4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lb4.setText("PROVEEDOR:");
        Blanco.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 180, 23));

        txtProveedor.setEditable(false);
        txtProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtProveedor.setOpaque(false);
        Blanco.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 250, 23));

        txtmov.setEditable(false);
        txtmov.setBackground(new java.awt.Color(255, 255, 255));
        txtmov.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtmov.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtmov.setOpaque(false);
        Blanco.add(txtmov, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 110, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNCMouseClicked
        // TODO add your handling code here:
        /*try {
            CabecerasTablas.limpiarTablas(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }*/
    }//GEN-LAST:event_tbNCMouseClicked

    private void tbNCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNCMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablasconsDetalleCompras(tbDetalleNCP);
            controlNCProveedor.listarDetalleNCProveedor(tbDetalleNCP);
            RendersD();
            ocultar(1);
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }
    }//GEN-LAST:event_tbNCMousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablasconsNCProveedor(tbNC);
        CabecerasTablas.consDetalleCompras(tbDetalleNCP);
        controlNCProveedor.listarNCProveedor(tbNC);
        Renders();
        ocultar(0);
        txtCodCompra.setText("");
        txtmov.setText("");
        txtFactura.setText("");
        txtProveedor.setText("");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarNCProveedor.tbNC.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione la Nota de Crédito que desea ANULAR");
        } else {
            int x = dlgConsultarNCProveedor.tbNC.getSelectedRow();
            String estado = dlgConsultarNCProveedor.tbNC.getValueAt(x, 11).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.Sistema("Esta Nota de Crédito ya fue anulada");
            } else {
                try {
                    String msg;
                    int rpta = Mensajes.confirmar("Seguro que desea Anular esta Nota de Crédito?");
                    if (rpta == 0) {
                        msg = controlNCProveedor.anularNCP();
                        if (msg.equals("OK")) {
                            btnActualizarActionPerformed(null);
                        }
                    }
                } catch (Exception e) {
                    Mensajes.informacion("Seleccione la fila a eliminar:" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnAnularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAnularKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnularKeyPressed

    private void btnBuscarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFActionPerformed
        // TODO add your handling code here:
        try {
            String cod = (JOptionPane.showInputDialog("Ingrese el Nro de Nota de Crédito"));
            for (int i = 0; i < tbNC.getRowCount(); i++) {
                if (tbNC.getValueAt(i, 7).equals(cod)) {
                    tbNC.changeSelection(i, 1, false, false);
                    tbNCMousePressed(null);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Consulta cancelada" + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarFActionPerformed

    private void btnBuscarFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarNCProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarNCProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarNCProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarNCProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgConsultarNCProveedor dialog = new dlgConsultarNCProveedor(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private newscomponents.RSButtonBigIcon_new btnActualizar;
    public static newscomponents.RSButtonBigIcon_new btnAnular;
    public static newscomponents.RSButtonBigIcon_new btnBuscarF;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    public static javax.swing.JTable tbDetalleNCP;
    public static javax.swing.JTable tbNC;
    public static javax.swing.JTextField txtCodCompra;
    public static javax.swing.JTextField txtFactura;
    public static javax.swing.JTextField txtProveedor;
    public static javax.swing.JTextField txtmov;
    // End of variables declaration//GEN-END:variables
}
