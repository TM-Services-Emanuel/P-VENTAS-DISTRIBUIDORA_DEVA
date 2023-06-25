package IU;

import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.Software;
import Componentes.generarCodigos;
import Controladores.CabecerasTablas;
import Controladores.controlCompra;
import Controladores.controlNCProveedor;
import java.text.DecimalFormat;

public class dlgRegistrarPagosCompras extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgRegistrarPagosCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.consComprasCreditos(tbCompraCredito);
        CabecerasTablas.limpiarTablas(tbCompraCredito);
        controlCompra.listarComprasCreditos(tbCompraCredito);
        Renders();
        cbSeleccionarActionPerformed(null);
        txtCaja.setVisible(false);

        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.getCodigoCajaActual("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de compras realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de compras realizadas");
        }
    }

    public static void Renders() {
        dlgRegistrarPagosCompras.tbCompraCredito.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal2());
        dlgRegistrarPagosCompras.tbCompraCredito.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimal2());
    }

    public static boolean Seleccionados(int pos) {
        int contador = 0;
        boolean bandera = true;
        for (int i = 0; i < tbCompraCredito.getRowCount(); i++) {
            boolean seleccion = (boolean) tbCompraCredito.getValueAt(i, pos);
            if (seleccion) {
                contador++;

            }
        }
        if (contador == 0) {
            bandera = false;
        }
        txtCant.setText(String.valueOf(contador));
        return bandera;
    }

    public static void ActualizarTabla() {
        CabecerasTablas.limpiarTablas(tbCompraCredito);
        controlCompra.listarComprasCreditos(tbCompraCredito);
        Renders();
        if (cbSeleccionar.isSelected()) {
            cbSeleccionar.setText("Deseleccionar Todo");
            for (int i = 0; i < tbCompraCredito.getRowCount(); i++) {
                tbCompraCredito.setValueAt(true, i, 11);
            }
        } else {
            cbSeleccionar.setText("Seleccionar Todo");
            for (int i = 0; i < tbCompraCredito.getRowCount(); i++) {
                tbCompraCredito.setValueAt(false, i, 11);
            }
        }
        DecimalFormat df = new DecimalFormat("#,###");
        int TotalF = controlNCProveedor.getTotalTF();
        txtTMonto.setText(df.format(TotalF));
        int TotalNC = controlNCProveedor.getTotalTNC();
        txtTnc.setText(df.format(TotalNC));
        txtDif.setText(df.format(TotalF - TotalNC));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        btnProcesar = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        cbSeleccionar = new rojerusan.RSCheckBox();
        txtCaja = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCompraCredito = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTnc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDif = new javax.swing.JTextField();

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

        btnProcesar.setBackground(new java.awt.Color(0, 102, 102));
        btnProcesar.setBorder(null);
        btnProcesar.setText("PROCESAR");
        btnProcesar.setBgHover(new java.awt.Color(0, 153, 153));
        btnProcesar.setFocusPainted(false);
        btnProcesar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnProcesar.setIconTextGap(0);
        btnProcesar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        btnProcesar.setPixels(0);
        btnProcesar.setSizeIcon(50.0F);
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        btnProcesar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProcesarKeyPressed(evt);
            }
        });
        jPanel2.add(btnProcesar);

        Oscuro.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 11, 70, 65));

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
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(947, 0, 15, 15));

        cbSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        cbSeleccionar.setText("Seleccionar Todo");
        cbSeleccionar.setColorCheck(new java.awt.Color(255, 255, 255));
        cbSeleccionar.setColorUnCheck(new java.awt.Color(255, 255, 255));
        cbSeleccionar.setFocusPainted(false);
        cbSeleccionar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeleccionarActionPerformed(evt);
            }
        });
        Oscuro.add(cbSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 160, 23));
        Oscuro.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 80, -1));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 962, 76));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbCompraCredito.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbCompraCredito.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCompraCredito.setFocusable(false);
        tbCompraCredito.setGridColor(new java.awt.Color(204, 204, 204));
        tbCompraCredito.setRowHeight(20);
        tbCompraCredito.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbCompraCredito.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbCompraCredito.setShowGrid(true);
        tbCompraCredito.setShowVerticalLines(false);
        tbCompraCredito.getTableHeader().setResizingAllowed(false);
        tbCompraCredito.getTableHeader().setReorderingAllowed(false);
        tbCompraCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCompraCreditoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCompraCredito);

        Blanco.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 80, 961, 280));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad de Facturas Seleccionadas:");
        Blanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 190, 23));

        txtCant.setEditable(false);
        txtCant.setBackground(new java.awt.Color(255, 255, 255));
        txtCant.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtCant.setText("0");
        txtCant.setBorder(null);
        txtCant.setOpaque(false);
        Blanco.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 370, 50, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel2.setText("Monto Total de las Facturas Seleccionadas:");
        Blanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 220, 23));

        txtTMonto.setEditable(false);
        txtTMonto.setBackground(new java.awt.Color(255, 255, 255));
        txtTMonto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtTMonto.setText("0");
        txtTMonto.setBorder(null);
        txtTMonto.setOpaque(false);
        Blanco.add(txtTMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 130, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel3.setText("Monto Total de las Notas de Créditos anexadas a las Facturas Seleccionadas:");
        Blanco.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 395, 23));

        txtTnc.setEditable(false);
        txtTnc.setBackground(new java.awt.Color(255, 255, 255));
        txtTnc.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtTnc.setText("0");
        txtTnc.setBorder(null);
        txtTnc.setOpaque(false);
        Blanco.add(txtTnc, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 430, 130, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("TOTAL A ABONAR:");
        Blanco.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 430, 130, 23));

        txtDif.setEditable(false);
        txtDif.setBackground(new java.awt.Color(255, 255, 255));
        txtDif.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtDif.setText("0");
        txtDif.setBorder(null);
        txtDif.setOpaque(false);
        Blanco.add(txtDif, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 135, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        // TODO add your handling code here:
        try {
            if (Seleccionados(11)) {
                try {
                    dlgPagoComprasCredito dbp = new dlgPagoComprasCredito(null, true);
                    dbp.setLocationRelativeTo(null);
                    dbp.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("No hay conexión con el servidor");
                }
            } else {
                Mensajes.Sistema("Para procesar un Pago es necesario tildar una o varias Compras Créditos.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnProcesarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProcesarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProcesarKeyPressed

    private void cbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeleccionarActionPerformed
        // TODO add your handling code here:
        if (cbSeleccionar.isSelected()) {
            cbSeleccionar.setText("Deseleccionar Todo");
            for (int i = 0; i < tbCompraCredito.getRowCount(); i++) {
                tbCompraCredito.setValueAt(true, i, 11);
            }
        } else {
            cbSeleccionar.setText("Seleccionar Todo");
            for (int i = 0; i < tbCompraCredito.getRowCount(); i++) {
                tbCompraCredito.setValueAt(false, i, 11);
            }
        }
        tbCompraCreditoMouseClicked(null);
    }//GEN-LAST:event_cbSeleccionarActionPerformed

    private void tbCompraCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCompraCreditoMouseClicked
        DecimalFormat df = new DecimalFormat("#,###");
        int TotalF = controlNCProveedor.getTotalTF();
        txtTMonto.setText(df.format(TotalF));
        int TotalNC = controlNCProveedor.getTotalTNC();
        txtTnc.setText(df.format(TotalNC));
        txtDif.setText(df.format(TotalF - TotalNC));
    }//GEN-LAST:event_tbCompraCreditoMouseClicked

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
            java.util.logging.Logger.getLogger(dlgRegistrarPagosCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgRegistrarPagosCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgRegistrarPagosCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgRegistrarPagosCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgRegistrarPagosCompras dialog = new dlgRegistrarPagosCompras(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnProcesar;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    public static rojerusan.RSCheckBox cbSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tbCompraCredito;
    public static javax.swing.JTextField txtCaja;
    private static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtDif;
    public static javax.swing.JTextField txtTMonto;
    public static javax.swing.JTextField txtTnc;
    // End of variables declaration//GEN-END:variables
}
