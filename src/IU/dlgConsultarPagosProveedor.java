package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimalconPuntos;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlCompra;
import javax.swing.JOptionPane;

public class dlgConsultarPagosProveedor extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgConsultarPagosProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.consCompras(tbCompra);
        CabecerasTablas.consDetalleCompras(tbDetalleCompra);
        Renders();
        controlCompra.listarCompras(tbCompra);
        

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de compras realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de compras realizadas");
        }
    }

    public static void Renders() {
        dlgConsultarPagosProveedor.tbCompra.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal2());
        dlgConsultarPagosProveedor.tbCompra.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimal2());
    }

    public static void RendersD() {
        dlgConsultarPagosProveedor.tbDetalleCompra.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimalconPuntos());
        dlgConsultarPagosProveedor.tbDetalleCompra.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1());
        dlgConsultarPagosProveedor.tbDetalleCompra.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal2());
        
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
        tbCompra = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnBuscarF = new newscomponents.RSButtonBigIcon_new();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleCompra = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jLabel5 = new javax.swing.JLabel();
        txtmov = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();

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
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 20, 20));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1060, 76));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tbCompra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCompra.setGridColor(new java.awt.Color(204, 204, 204));
        tbCompra.setOpaque(false);
        tbCompra.setRowHeight(20);
        tbCompra.setShowGrid(true);
        tbCompra.setShowVerticalLines(false);
        tbCompra.getTableHeader().setResizingAllowed(false);
        tbCompra.getTableHeader().setReorderingAllowed(false);
        tbCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCompraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCompraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCompra);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 109, 1059, 230));

        btnBuscarF.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarF.setBorder(null);
        btnBuscarF.setText("BUSCAR FACTURA");
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
        Blanco.add(btnBuscarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, 118, 23));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane2.setOpaque(false);

        tbDetalleCompra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleCompra.setEnabled(false);
        tbDetalleCompra.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalleCompra.setOpaque(false);
        tbDetalleCompra.setRowHeight(20);
        tbDetalleCompra.setShowGrid(true);
        tbDetalleCompra.setShowVerticalLines(false);
        tbDetalleCompra.getTableHeader().setResizingAllowed(false);
        tbDetalleCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDetalleCompra);

        Blanco.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 348, 1059, 258));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("MOV. DIARIO N°");
        Blanco.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 80, 90, 23));

        txtmov.setEditable(false);
        txtmov.setBackground(new java.awt.Color(255, 255, 255));
        txtmov.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtmov.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtmov.setOpaque(false);
        Blanco.add(txtmov, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 80, 110, 23));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("COMPRA N°");
        Blanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 70, 23));

        txtCodCompra.setEditable(false);
        txtCodCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtCodCompra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodCompra.setOpaque(false);
        Blanco.add(txtCodCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 110, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCompraMouseClicked
        // TODO add your handling code here:
        /*try {
            CabecerasTablas.limpiarTablas(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }*/
    }//GEN-LAST:event_tbCompraMouseClicked

    private void tbCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCompraMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablasconsDetalleCompras(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }
    }//GEN-LAST:event_tbCompraMousePressed

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
        cabe.consCompras(tbCompra);
        CabecerasTablas.consDetalleCompras(tbDetalleCompra);
        controlCompra.listarCompras(tbCompra);
        Renders();
        txtCodCompra.setText("");
        txtmov.setText("");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarPagosProveedor.tbCompra.getSelectedRow() < 0) {
            Mensajes.error("Seleccione una fila de la tabla");
        } else {
            int x = dlgConsultarPagosProveedor.tbCompra.getSelectedRow();
            String condicion = dlgConsultarPagosProveedor.tbCompra.getValueAt(x, 6).toString();
            String estado = dlgConsultarPagosProveedor.tbCompra.getValueAt(x, 11).toString();
            String pago = dlgConsultarPagosProveedor.tbCompra.getValueAt(x, 10).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.informacion("Esta compra ya fue anulada");
            } else {
                if(condicion.equals("CRÉDITO") && pago.equals("ABONADO")){
                    Mensajes.Sistema("ANULACIÓN DE COMPRA RESTRINGIDA.\nMOTIVO: La Compra Crédito seleccionada ya se encuentra procesada.");
                }else{
                    try {
                        String msg;
                        int rpta = Mensajes.confirmar("Seguro que desea Anular esta Compra?");
                        if (rpta == 0) {
                            msg = controlCompra.anularCompra();
                            if (msg.equals("OK")) {
                                CabecerasTablas.limpiarTablas(tbCompra);
                                CabecerasTablas.limpiarTablasconsDetalleCompras(tbDetalleCompra);
                                cabe.consCompras(tbCompra);
                                CabecerasTablas.consDetalleCompras(tbDetalleCompra);
                                controlCompra.listarCompras(tbCompra);
                            }
                        }
                    } catch (Exception e) {
                        Mensajes.informacion("Seleccione la fila a eliminar:" + e.getMessage());
                    } 
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
            String cod = (JOptionPane.showInputDialog("Ingrese N° de Factura Compra"));
            for (int i = 0; i < tbCompra.getRowCount(); i++) {
                if (tbCompra.getValueAt(i, 7).equals(cod)) {
                    tbCompra.changeSelection(i, 1, false, false);
                    tbCompraMousePressed(null);
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
            java.util.logging.Logger.getLogger(dlgConsultarPagosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarPagosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarPagosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarPagosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgConsultarPagosProveedor dialog = new dlgConsultarPagosProveedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tbCompra;
    public static javax.swing.JTable tbDetalleCompra;
    public static javax.swing.JTextField txtCodCompra;
    public static javax.swing.JTextField txtmov;
    // End of variables declaration//GEN-END:variables
}
