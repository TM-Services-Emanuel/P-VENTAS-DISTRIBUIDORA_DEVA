package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlSalida;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class dlgSeleccionarSalidasD extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgSeleccionarSalidasD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        CabecerasTablas.consNCpSolicitud(tbSalidas);
        CabecerasTablas.limpiarTablasSalidasNCP(tbSalidas);
        controlSalida.listarSalidasD(tbSalidas, Integer.parseInt(dlgGestSolicitudDestrucción.txtcodProv.getText().trim()));
        Renders();
        cbSeleccionarActionPerformed(null);

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de compras realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de compras realizadas");
        }
    }

    public static void Renders() {
        tbSalidas.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal2());
    }

    private boolean Seleccionados(int pos) {
        int contador = 0;
        boolean bandera = true;
        for (int i = 0; i < tbSalidas.getRowCount(); i++) {
            boolean seleccion = (boolean) tbSalidas.getValueAt(i, pos);
            if (seleccion) {
                contador++;
            }
        }
        if (contador == 0) {
            bandera = false;
        }
        return bandera;
    }

    public static void insertar(int fila, int idsalida, JTable tabla) {
        String filas[] = new String[2];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        filas[0] = String.valueOf(fila);
        filas[1] = String.valueOf(idsalida);
        tb.addRow(filas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSalidas = new javax.swing.JTable();
        cbSeleccionar = new rojerusan.RSCheckBox();

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
        btnActualizar.setText("CARGAR");
        btnActualizar.setBgHover(new java.awt.Color(0, 153, 153));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnActualizar.setIconTextGap(0);
        btnActualizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);
        btnActualizar.setPixels(0);
        btnActualizar.setSizeIcon(50.0F);
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

        Oscuro.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 70, 65));

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
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(939, 0, 23, 23));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 962, 76));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbSalidas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbSalidas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSalidas.setFocusable(false);
        tbSalidas.setGridColor(new java.awt.Color(204, 204, 204));
        tbSalidas.setRowHeight(20);
        tbSalidas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbSalidas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbSalidas.setShowGrid(true);
        tbSalidas.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tbSalidas);

        Blanco.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 107, 961, 360));

        cbSeleccionar.setForeground(new java.awt.Color(0, 0, 0));
        cbSeleccionar.setText("Seleccionar Todo");
        cbSeleccionar.setColorCheck(new java.awt.Color(0, 102, 102));
        cbSeleccionar.setColorUnCheck(new java.awt.Color(0, 0, 0));
        cbSeleccionar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeleccionarActionPerformed(evt);
            }
        });
        Blanco.add(cbSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 180, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestSolicitudDestrucción.txtObs.setText("");
            CabecerasTablas.limpiarTablasSalidasDNCP(dlgGestSolicitudDestrucción.tbDetalle);
            CabecerasTablas.limpiarTablasRefSolNCP(dlgGestSolicitudDestrucción.tbSalidas);
            if (Seleccionados(7)) {
                for (int i = 0; i < tbSalidas.getRowCount(); i++) {
                    boolean sel = (boolean) tbSalidas.getValueAt(i, 7);
                    if (sel) {
                        dlgGestSolicitudDestrucción.txtObs.append("OPERACIÓN SALIDA NRO:" + tbSalidas.getValueAt(i, 0) + "\n");
                        int x = Integer.parseInt(tbSalidas.getValueAt(i, 0).toString());
                        controlSalida.addTablaSolicitudNCP(dlgGestSolicitudDestrucción.tbDetalle, x);
                        insertar(i, x, dlgGestSolicitudDestrucción.tbSalidas);
                        dlgGestSolicitudDestrucción.Renders();
                    }
                }
                this.dispose();
            } else {
                Mensajes.Sistema("No fue seleccionado ninguna salida.");
                CabecerasTablas.limpiarTablasSalidasDNCP(dlgGestSolicitudDestrucción.tbDetalle);
                CabecerasTablas.limpiarTablasRefSolNCP(dlgGestSolicitudDestrucción.tbSalidas);
                String montoFinal = String.valueOf(controlSalida.getTotalDetalleSalidaD());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgGestSolicitudDestrucción.txtTotal.setText(df.format(Integer.parseInt(montoFinal.replace(".", "").replace(",", ""))));
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        dlgGestSolicitudDestrucción.HabilCB();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void cbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeleccionarActionPerformed
        // TODO add your handling code here:
        if (cbSeleccionar.isSelected()) {
            cbSeleccionar.setText("Deseleccionar Todo");
            for (int i = 0; i < tbSalidas.getRowCount(); i++) {
                tbSalidas.setValueAt(true, i, 7);
            }
        } else {
            cbSeleccionar.setText("Seleccionar Todo");
            for (int i = 0; i < tbSalidas.getRowCount(); i++) {
                tbSalidas.setValueAt(false, i, 7);
            }
        }
    }//GEN-LAST:event_cbSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(dlgSeleccionarSalidasD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgSeleccionarSalidasD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgSeleccionarSalidasD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgSeleccionarSalidasD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgSeleccionarSalidasD dialog = new dlgSeleccionarSalidasD(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private rojerusan.RSCheckBox cbSeleccionar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tbSalidas;
    // End of variables declaration//GEN-END:variables

}
