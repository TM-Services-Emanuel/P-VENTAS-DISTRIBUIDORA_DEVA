package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Reporte;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class dlgReporteExtractoComprobantes extends javax.swing.JDialog {

    public Reporte jasper;
    public static ResultSet rs;
    public static Statement sentencia;
    public static Connection con;
    static String Fdesde;
    static String Fhasta;

    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgReporteExtractoComprobantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        invisible();
        cbClienteEspecificoActionPerformed(null);
        prepararBD();
    }

    private void invisible() {
        txtFDesdeR.setVisible(false);
        txtFHastaR.setVisible(false);
        lbCodCliente.setVisible(false);
        lbSi.setVisible(false);
    }

    public static void prepararBD() {
        {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoReporte = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        btnGenerar1 = new newscomponents.RSButtonBigIcon_new();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        txtFHastaR = new javax.swing.JTextField();
        txtFDesdeR = new javax.swing.JTextField();
        lbCodCliente = new javax.swing.JLabel();
        lbSi = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbClienteEspecifico = new rojerusan.RSCheckBox();
        btnBuscar = new RSMaterialComponent.RSButtonIconUno();
        lbRZ = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFDesde = new javax.swing.JTextField();
        dcFDesde = new datechooser.beans.DateChooserCombo();
        jLabel2 = new javax.swing.JLabel();
        txtFHasta = new javax.swing.JTextField();
        dcFHasta = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de Reportes");
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 6));

        btnGenerar1.setBackground(new java.awt.Color(0, 102, 102));
        btnGenerar1.setBorder(null);
        btnGenerar1.setText("GENERAR");
        btnGenerar1.setBgHover(new java.awt.Color(0, 153, 153));
        btnGenerar1.setFocusPainted(false);
        btnGenerar1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnGenerar1.setIconTextGap(0);
        btnGenerar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTENT_PASTE);
        btnGenerar1.setPixels(0);
        btnGenerar1.setSizeIcon(50.0F);
        btnGenerar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerar1);

        Oscuro.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 65, 64));

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
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 0, 15, 15));

        txtFHastaR.setEditable(false);
        txtFHastaR.setBackground(new java.awt.Color(255, 255, 204));
        txtFHastaR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFHastaR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(txtFHastaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 90, -1));

        txtFDesdeR.setEditable(false);
        txtFDesdeR.setBackground(new java.awt.Color(255, 255, 204));
        txtFDesdeR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFDesdeR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(txtFDesdeR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 90, -1));

        lbCodCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Oscuro.add(lbCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 63, 66, 21));

        lbSi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Oscuro.add(lbSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 60, 20));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbClienteEspecifico.setForeground(new java.awt.Color(0, 0, 0));
        cbClienteEspecifico.setText("Seleccionar Cliente especifico");
        cbClienteEspecifico.setColorCheck(new java.awt.Color(0, 102, 102));
        cbClienteEspecifico.setColorUnCheck(new java.awt.Color(0, 0, 0));
        cbClienteEspecifico.setFocusable(false);
        cbClienteEspecifico.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cbClienteEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteEspecificoActionPerformed(evt);
            }
        });
        jPanel4.add(cbClienteEspecifico, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, 192, 27));

        btnBuscar.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscar.setBackgroundHover(new java.awt.Color(0, 153, 153));
        btnBuscar.setEnabled(false);
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 26, 27));

        lbRZ.setBackground(new java.awt.Color(0, 102, 102));
        lbRZ.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbRZ.setForeground(new java.awt.Color(255, 255, 255));
        lbRZ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRZ.setOpaque(true);
        jPanel4.add(lbRZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 620, 27));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Desde");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 26));

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
        jPanel4.add(txtFDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 10, 100, 26));

        dcFDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFDesdeOnCommit(evt);
            }
        });
        jPanel4.add(dcFDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 10, 27, 26));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Hasta");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 40, 26));

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
        jPanel4.add(txtFHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 10, 100, 26));

        dcFHasta.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFHastaOnCommit(evt);
            }
        });
        jPanel4.add(dcFHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 27, 26));

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dcFDesdeOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFDesdeOnCommit
        // TODO add your handling code here:
        txtFDesde.setText(Fecha.fechaCFormulario(dcFDesde.getText()));
        txtFDesdeR.setText(Fecha.formatoFecha(dcFDesde.getText()));
    }//GEN-LAST:event_dcFDesdeOnCommit

    private void dcFHastaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFHastaOnCommit
        // TODO add your handling code here:
        txtFHasta.setText(Fecha.fechaCFormulario(dcFHasta.getText()));
        txtFHastaR.setText(Fecha.formatoFecha(dcFHasta.getText()));
    }//GEN-LAST:event_dcFHastaOnCommit

    private void txtFHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFHastaActionPerformed

    private void txtFDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFDesdeActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void cbClienteEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteEspecificoActionPerformed
        // TODO add your handling code here:
        if (cbClienteEspecifico.isSelected()) {
            btnBuscar.setEnabled(true);
            lbSi.setText("SI");
        } else {
            btnBuscar.setEnabled(false);
            lbCodCliente.setText("");
            lbRZ.setText("");
            lbSi.setText("NO");
        }
    }//GEN-LAST:event_cbClienteEspecificoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarCliente2 bc = new dlgBuscarCliente2(null, true);
            bc.setLocationRelativeTo(null);
            bc.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGenerar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar1ActionPerformed
        // TODO add your handling code here:
        prepararBD();

        if (lbSi.getText().equals("NO")) {
            Mensajes.Sistema("Para poder generar el extracto de cuenta es necesario seleccionar el Cliente.");
        } else if (txtFDesdeR.getText().isEmpty()) {
            Mensajes.Sistema("Falta seleccionar la fecha Desde.");
        } else if (txtFHastaR.getText().isEmpty()) {
            Mensajes.Sistema("Falta seleccionar la fecha Hasta.");
        } else {
            int rpta = Mensajes.confirmar("¿Seguro que desea generar el Reporte?");
            if (rpta == 0) {
                VisorReportes vr = new VisorReportes(null, true);
                try {
                    String jasperUrl3 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_extracto.jasper");
                    JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl3);
                    //para los parametro
                    Map parametros = new HashMap();
                    parametros.clear();
                    //Nuestro parametro se llama "pLastName"
                    parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                    parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));
                    parametros.put("id", Integer.parseInt(lbCodCliente.getText().trim()));
                    //agregamos los parametros y la conexion a la base de datos
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, con);
                    //se crea el visor con el reporte
                    JRViewer jRViewer = new JRViewer(jasperPrint);
                    //se elimina elementos del contenedor JPanel
                    VisorReportes.jpContainer.removeAll();
                    //para el tamaño del reporte se agrega un BorderLayout
                    VisorReportes.jpContainer.setLayout(new BorderLayout());
                    VisorReportes.jpContainer.add(jRViewer, BorderLayout.CENTER);
                    jRViewer.setZoomRatio((float) 0.85);
                    jRViewer.setVisible(true);
                    VisorReportes.jpContainer.repaint();
                    VisorReportes.jpContainer.revalidate();
                } catch (JRException ex) {
                    System.err.println(ex.getMessage());
                }
                vr.setLocationRelativeTo(this);
                vr.setVisible(true);
            }

        }
    }//GEN-LAST:event_btnGenerar1ActionPerformed

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
            java.util.logging.Logger.getLogger(dlgReporteExtractoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteExtractoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteExtractoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteExtractoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                dlgReporteExtractoComprobantes dialog = new dlgReporteExtractoComprobantes(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup GrupoReporte;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private RSMaterialComponent.RSButtonIconUno btnBuscar;
    public static newscomponents.RSButtonBigIcon_new btnGenerar1;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    private javax.swing.ButtonGroup buttonGroup1;
    private rojerusan.RSCheckBox cbClienteEspecifico;
    public static datechooser.beans.DateChooserCombo dcFDesde;
    public static datechooser.beans.DateChooserCombo dcFHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel lbCodCliente;
    public static javax.swing.JLabel lbRZ;
    private javax.swing.JLabel lbSi;
    public static javax.swing.JTextField txtFDesde;
    public static javax.swing.JTextField txtFDesdeR;
    public static javax.swing.JTextField txtFHasta;
    public static javax.swing.JTextField txtFHastaR;
    // End of variables declaration//GEN-END:variables
}
