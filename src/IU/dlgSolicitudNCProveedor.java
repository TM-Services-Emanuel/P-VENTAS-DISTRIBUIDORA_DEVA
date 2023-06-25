/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlSalida;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author ADMIN
 */
public class dlgSolicitudNCProveedor extends javax.swing.JDialog {
    
    public static Connection con;
    public static Statement st;
    static ConexionBD conectar = ConexionBD.getInstancia();

    /**
     * Creates new form dlgRepartos
     *
     * @param parent
     * @param modal
     */
    public dlgSolicitudNCProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        txtFechaFinal.setText(Fecha.formatoFecha(dcFecha.getText()));
        txtFechaFinal.setVisible(false);
        CabecerasTablas.TodasLasSolicitudes(tbDetalle);
        //CabecerasTablas.limpiarTablasTLS(tbDetalle);
        CabecerasTablas.RefTSNC(tbREF);
        //CabecerasTablas.limpiarTablasRefTSNCP(tbREF);
        CabecerasTablas.detalle_Sol_NC(tbDetalleS);
        //CabecerasTablas.limpiarTablasDetalleRefTSNCP(tbDetalleS);
        txtFechaFinal.setText(Fecha.formatoFecha(dcFecha.getText()));
        controlSalida.listarTLS(tbDetalle, txtFechaFinal.getText().trim());
        Renders();

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
    
     private void ImprimirDocumento(int cod) {
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\salidas\\solicitudNCP.jasper");
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

    public static void Renders() {
        tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal2());
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar Transferencias");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar Transferencias");
        }
    }

    private void nuevo() {
        dlgGestSolicitudNCP GR = new dlgGestSolicitudNCP(null, true);
        GR.setLocationRelativeTo(this);
        GR.Nuevo();
        GR.setVisible(true);

    }

    private void delSolicitud() {
        int x = tbDetalle.getSelectedRow();
        if (x < 0) {
            Mensajes.Sistema("Seleccione la Solicitud de Nota de Crédito que desea anular");
        } else {
            int fila = dlgSolicitudNCProveedor.tbDetalle.getSelectedRow();
            String estado = dlgSolicitudNCProveedor.tbDetalle.getValueAt(fila, 8).toString();
            String estado2 = dlgSolicitudNCProveedor.tbDetalle.getValueAt(fila, 9).toString();
            if (!estado.equals("PENDIENTE")) {
                Mensajes.Sistema("ANULACIÓN DE SOLICITUD RESTRINGIDA.\nMOTIVO: La Solicitud de Nota de Crédito seleccionada ya se encuentra procesada.");
            } else {
                if (estado2.equals("ANULADO")) {
                    Mensajes.Sistema("NO ES POSIBLE ANULAR ESTA SOLICITUD.\nMOTIVO: La Solicitud de Nota de Crédito seleccionada ya se encuentra anulada.");
                } else {
                    String msg;
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Anular esta Solicitud de Nota de Crédito?", "Anulación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        int id = Integer.parseInt(dlgSolicitudNCProveedor.tbDetalle.getValueAt(fila, 0).toString());
                        msg = controlSalida.DelSolicitud(id);
                        if (msg.equals("OK")) {
                            CabecerasTablas.limpiarTablasTLS(tbDetalle);
                            CabecerasTablas.limpiarTablasRefTSNCP(tbREF);
                            CabecerasTablas.limpiarTablasDetalleRefTSNCP(tbDetalleS);
                            controlSalida.listarTLS(tbDetalle, txtFechaFinal.getText().trim());
                        } else {
                            Mensajes.error("DEL_SOL: " + msg);
                        }
                    }
                }
            }
        }
    }

    private void Modificar() {
        int x = tbDetalle.getSelectedRow();
        if (x < 0) {
            Mensajes.Sistema("Seleccione la Solicitud de Nota de Crédito que desea cambiar de estado");
        } else {
            String estado2 = dlgSolicitudNCProveedor.tbDetalle.getValueAt(x, 9).toString();
            if (estado2.equals("ANULADO")) {
                Mensajes.Sistema("NO ES POSIBLE PROCESAR ESTA SOLICITUD.\nMOTIVO: La Solicitud de Nota de Crédito seleccionada ya se encuentra anulada.");
            } else {
                try {
                    dlgGestSolicitudNCP GR = new dlgGestSolicitudNCP(null, true);
                    GR.setLocationRelativeTo(null);
                    dlgGestSolicitudNCP.txtCod.setText(tbDetalle.getValueAt(x, 0).toString());
                    dlgGestSolicitudNCP.txtCaja.setText(tbDetalle.getValueAt(x, 1).toString());
                    Object descripcion = tbDetalle.getValueAt(x, 3).toString();
                    dlgGestSolicitudNCP.cbProveedor.setSelectedItem(descripcion);
                    dlgGestSolicitudNCP.txtFecha.setText(Fecha.formatoFechaDd(tbDetalle.getValueAt(x, 4).toString()));
                    dlgGestSolicitudNCP.txtHora.setText(Fecha.FormatoHoraSinSSString(tbDetalle.getValueAt(x, 5).toString()));
                    if (tbDetalle.getValueAt(x, 8).toString().equals("PENDIENTE")) {
                        dlgGestSolicitudNCP.ckPendiente.setSelected(false);
                        dlgGestSolicitudNCP.ckPendiente.setEnabled(true);
                        dlgGestSolicitudNCP.ckTexto();
                    } else {
                        dlgGestSolicitudNCP.ckPendiente.setSelected(true);
                        dlgGestSolicitudNCP.ckPendiente.setEnabled(true);
                        dlgGestSolicitudNCP.ckTexto();
                    }
                    dlgGestSolicitudNCP.txtObs.setText(tbDetalle.getValueAt(x, 7).toString());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgGestSolicitudNCP.txtTotal.setText(df.format(Integer.parseInt(tbDetalle.getValueAt(x, 6).toString().replace(".", "").replace(",", ""))));
                    dlgGestSolicitudNCP.btnNuevo.setEnabled(false);
                    controlSalida.listDetalleTLSpModificacion(Integer.parseInt(dlgGestSolicitudNCP.txtCod.getText()), dlgGestSolicitudNCP.tbDetalle);
                    dlgGestSolicitudNCP.Renders();
                    dlgGestSolicitudNCP.opcion = "M";
                    GR.setVisible(true);
                } catch (Exception e) {
                    //Mensajes.error("No se pudo cagar informacion del Producto" + e.getMessage());
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        txtFechaFinal = new javax.swing.JTextField();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleS = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbREF = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 6));

        btnNuevo.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevo.setBorder(null);
        btnNuevo.setText("NUEVO");
        btnNuevo.setBgHover(new java.awt.Color(0, 153, 153));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevo.setPixels(0);
        btnNuevo.setSizeIcon(40.0F);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

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
        jPanel1.add(btnActualizar);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ANULAR");
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
        jPanel1.add(btnEliminar);

        btnModificar.setBackground(new java.awt.Color(0, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("IMPRIMIR");
        btnModificar.setBgHover(new java.awt.Color(0, 153, 153));
        btnModificar.setFocusPainted(false);
        btnModificar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnModificar.setIconTextGap(0);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnModificar.setPixels(0);
        btnModificar.setSizeIcon(40.0F);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);

        Oscuro.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 300, 56));
        Oscuro.add(txtFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 124, -1));

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
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(983, 0, 20, 20));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1005, 70));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setOpaque(false);
        tbDetalle.setRowHeight(18);
        tbDetalle.setShowGrid(true);
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        tbDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDetalleMousePressed(evt);
            }
        });
        tbDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 118, 1003, 470));

        dcFecha.setCalendarBackground(new java.awt.Color(255, 255, 255));
        dcFecha.setCalendarPreferredSize(new java.awt.Dimension(300, 180));
        dcFecha.setFieldFont(new java.awt.Font("Roboto", java.awt.Font.BOLD, 14));
        dcFecha.setNavigateFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 14));
        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });
        Blanco.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 118, 26));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("SOLICITUDES DE LA FECHA");
        Blanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, 26));

        tbDetalleS.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleS.getTableHeader().setResizingAllowed(false);
        tbDetalleS.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDetalleS);

        Blanco.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 800, 110));

        tbREF.setModel(new javax.swing.table.DefaultTableModel(
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
        tbREF.getTableHeader().setResizingAllowed(false);
        tbREF.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbREF);

        Blanco.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 180, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        txtFechaFinal.setText(Fecha.formatoFecha(dcFecha.getText()));
        CabecerasTablas.limpiarTablasTLS(tbDetalle);
        CabecerasTablas.limpiarTablasRefTSNCP(tbREF);
        CabecerasTablas.limpiarTablasDetalleRefTSNCP(tbDetalleS);
        controlSalida.listarTLS(tbDetalle, txtFechaFinal.getText().trim());
        //  Renders();  
    }//GEN-LAST:event_dcFechaOnCommit

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleKeyPressed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            Modificar();
        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablasDetalleRefTSNCP(tbDetalleS);
        controlSalida.listDetalleTLS(tbDetalleS);
        CabecerasTablas.limpiarTablasRefTSNCP(tbREF);
        controlSalida.listRefTLS(tbREF);
        System.out.println("mostrando detalle");
    }//GEN-LAST:event_tbDetalleMousePressed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevo();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        delSolicitud();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add, your handling code here:
        if (tbDetalle.getSelectedRowCount() <= 0) {
            Mensajes.Sistema("Seleccione una Solicitud de Nota de Crédito para Imprimir el Documento.");
        } else {
            prepararBD();
            int x = tbDetalle.getSelectedRow();
            int cod = Integer.parseInt(tbDetalle.getValueAt(x, 0).toString());
            ImprimirDocumento(cod);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        txtFechaFinal.setText(Fecha.formatoFecha(dcFecha.getText()));
        CabecerasTablas.limpiarTablasTLS(tbDetalle);
        CabecerasTablas.limpiarTablasRefTSNCP(tbREF);
        CabecerasTablas.limpiarTablasDetalleRefTSNCP(tbDetalleS);
        controlSalida.listarTLS(tbDetalle, txtFechaFinal.getText().trim());
    }//GEN-LAST:event_btnActualizarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgSolicitudNCProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            dlgSolicitudNCProveedor dialog = new dlgSolicitudNCProveedor(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnActualizar;
    public static newscomponents.RSButtonBigIcon_new btnEliminar;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static datechooser.beans.DateChooserCombo dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTable tbDetalleS;
    public static javax.swing.JTable tbREF;
    public static javax.swing.JTextField txtFechaFinal;
    // End of variables declaration//GEN-END:variables
}
