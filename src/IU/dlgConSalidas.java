package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimal2;
import Componentes.RenderDecimalconPuntos;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlSalida;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class dlgConSalidas extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    public static Connection con;
    public static Statement st;
    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgConSalidas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.consultaSalidas(tbSalida);
        Renders();
        cabe.detalleSalidas(tbDetalleSalida);
        controlSalida.listSalidas(tbSalida);
        HabilitarEliminar();
    }

    public static void prepararBD() {
        try {
            con = (Connection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                st = (Statement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Controlar salidas aplicadas a artículos");
        } else {
            this.setTitle(Software.getSoftware() + " - Controlar salidas aplicadas a artículos");
        }
    }

    public static void Renders() {
        dlgConSalidas.tbSalida.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimal1());
    }

    public final void HabilitarEliminar() {
        if (tbSalida.getSelectedRow() < 0) {
            btnEliminar.setEnabled(false);
        } else {
            btnEliminar.setEnabled(true);
        }
    }

    public static void Renders2() {
        dlgConSalidas.tbDetalleSalida.getColumnModel().getColumn(2).setCellRenderer(new RenderDecimalconPuntos());
        dlgConSalidas.tbDetalleSalida.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal2());
        dlgConSalidas.tbDetalleSalida.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal2());
    }

    private void ImprimirDocumento(int cod) {
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

        jLabel2 = new javax.swing.JLabel();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel3 = new javax.swing.JPanel();
        btnEliminar2 = new newscomponents.RSButtonBigIcon_new();
        btnEliminar1 = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSalida = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleSalida = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnEliminar2.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar2.setBorder(null);
        btnEliminar2.setText("IMPRIMIR");
        btnEliminar2.setBgHover(new java.awt.Color(0, 153, 153));
        btnEliminar2.setFocusPainted(false);
        btnEliminar2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnEliminar2.setIconTextGap(0);
        btnEliminar2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnEliminar2.setPixels(0);
        btnEliminar2.setSizeIcon(40.0F);
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        btnEliminar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminar2KeyPressed(evt);
            }
        });
        jPanel3.add(btnEliminar2);

        btnEliminar1.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar1.setBorder(null);
        btnEliminar1.setText("ACTUALIZAR");
        btnEliminar1.setBgHover(new java.awt.Color(0, 153, 153));
        btnEliminar1.setFocusPainted(false);
        btnEliminar1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnEliminar1.setIconTextGap(0);
        btnEliminar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        btnEliminar1.setPixels(0);
        btnEliminar1.setSizeIcon(40.0F);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        btnEliminar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminar1KeyPressed(evt);
            }
        });
        jPanel3.add(btnEliminar1);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBgHover(new java.awt.Color(0, 153, 153));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnEliminar.setIconTextGap(0);
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_FOREVER);
        btnEliminar.setPixels(0);
        btnEliminar.setSizeIcon(40.0F);
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
        jPanel3.add(btnEliminar);

        Oscuro.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 21, 220, 56));

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
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1156, 0, 20, 20));

        jPanel1.setOpaque(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tbSalida.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbSalida.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSalida.setGridColor(new java.awt.Color(204, 204, 204));
        tbSalida.setRowHeight(20);
        tbSalida.setShowGrid(true);
        tbSalida.setShowVerticalLines(false);
        tbSalida.getTableHeader().setResizingAllowed(false);
        tbSalida.getTableHeader().setReorderingAllowed(false);
        tbSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSalidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbSalidaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbSalida);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane2.setOpaque(false);

        tbDetalleSalida.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalleSalida.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleSalida.setEnabled(false);
        tbDetalleSalida.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalleSalida.setRowHeight(20);
        tbDetalleSalida.setShowGrid(true);
        tbDetalleSalida.setShowVerticalLines(false);
        tbDetalleSalida.getTableHeader().setResizingAllowed(false);
        tbDetalleSalida.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDetalleSalida);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addContainerGap(556, Short.MAX_VALUE))
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalidaMouseClicked
        // TODO add your handling code here:
        try {
            HabilitarEliminar();
            CabecerasTablas.limpiarTablas(tbDetalleSalida);
            controlSalida.listDetalle(tbDetalleSalida);
            Renders2();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_tbSalidaMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tbSalida.getSelectedRow() < 0) {
            Mensajes.error("Seleccione una fila de la tabla");
        } else {
            int fila = tbSalida.getSelectedRow();
            String estado = tbSalida.getValueAt(fila, 12).toString();
            String procesado = tbSalida.getValueAt(fila, 13).toString();
            if (procesado.equals("PROCESADO")) {
                Mensajes.Sistema("ANULACIÓN DE SALIDA RESTRINGIDA.\nMOTIVO: La Salida de Productos seleccionada ya se encuentra procesada.");
            } else {
                if (estado.equals("ANULADO")) {
                    Mensajes.Sistema("NO ES POSIBLE ANULAR ESTA SALIDA.\nMOTIVO: La Salida de Productos seleccionada ya se encuentra anulada.");
                } else {
                    String msg;
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        msg = controlSalida.DelSalida();
                        if (msg.equals("OK")) {
                            cabe.consultaSalidas(tbSalida);
                            tbSalida.clearSelection();
                            cabe.detalleSalidas(tbDetalleSalida);
                            tbDetalleSalida.clearSelection();
                            controlSalida.listSalidas(tbSalida);
                            Renders();
                            HabilitarEliminar();
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        cabe.consultaSalidas(tbSalida);
        CabecerasTablas.limpiarTablas(tbSalida);
        cabe.detalleSalidas(tbDetalleSalida);
        CabecerasTablas.limpiarTablas(tbDetalleSalida);
        controlSalida.listSalidas(tbSalida);
        Renders();
        HabilitarEliminar();
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnEliminar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1KeyPressed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        // TODO add your handling code here:
        if (tbSalida.getSelectedRowCount() <= 0) {
            Mensajes.error("Seleccione una salida para Imprimir el Documento.");
        } else {
            prepararBD();
            int x = tbSalida.getSelectedRow();
            int cod = Integer.parseInt(tbSalida.getValueAt(x, 0).toString());
            ImprimirDocumento(cod);
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnEliminar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminar2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar2KeyPressed

    private void tbSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalidaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSalidaMouseEntered

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
            java.util.logging.Logger.getLogger(dlgConSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgConSalidas dialog = new dlgConSalidas(new javax.swing.JFrame(), true);
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
    private newscomponents.RSButtonBigIcon_new btnEliminar;
    private newscomponents.RSButtonBigIcon_new btnEliminar1;
    private newscomponents.RSButtonBigIcon_new btnEliminar2;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tbDetalleSalida;
    public static javax.swing.JTable tbSalida;
    // End of variables declaration//GEN-END:variables
}
