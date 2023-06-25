package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.Numero_a_Letra;
import Componentes.RenderDecimal2;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlNCProveedor;
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

public class dlgConsultarPagosVentas extends javax.swing.JDialog {

    static public Numero_a_Letra d;
    
    public static Connection con;
    public static Statement stTransaccion;
    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgConsultarPagosVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        d = new Numero_a_Letra();
        titulo();
        CabecerasTablas.consPagosVentas(tbPagos);
        controlNCProveedor.listarPagosVenta(tbPagos);
        CabecerasTablas.consDetallePagosVentas1(tbDPV1);
        CabecerasTablas.consDetallePagosVentas2(tbDPV2);
        CabecerasTablas.consDetallePagosVentas3(tbDPV3);
        Renders();

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de compras realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de compras realizadas");
        }
    }

    public static void Renders() {
        dlgConsultarPagosVentas.tbPagos.getColumnModel().getColumn(2).setCellRenderer(new RenderDecimal2());
    }

    public static void RendersD() {
        //dlgConsultarPagosVentas.tbDPV1.getColumnModel().getColumn(1).setCellRenderer(new RenderDecimal1());
        dlgConsultarPagosVentas.tbDPV1.getColumnModel().getColumn(1).setCellRenderer(new RenderDecimal2());
        dlgConsultarPagosVentas.tbDPV2.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimal2());
        dlgConsultarPagosVentas.tbDPV3.getColumnModel().getColumn(3).setCellRenderer(new RenderDecimal2());

    }

    public static void prepararBD() {
        try {
            con = (Connection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                stTransaccion = (Statement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ImprimirRecibo(int id, String Letra) {
        VisorReportes vr = new VisorReportes(null, true);
        try {
            String jasperUrl3 = System.getProperty("user.dir").concat("\\Reports\\ventas\\Hoja_recibos.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl3);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("ID", id);
            parametros.put("LETRA", Letra);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        btnImprimir = new newscomponents.RSButtonBigIcon_new();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        btnAnular = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPagos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnBuscarF = new newscomponents.RSButtonBigIcon_new();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDPV1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDPV2 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDPV3 = new javax.swing.JTable()
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
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnImprimir.setBackground(new java.awt.Color(0, 102, 102));
        btnImprimir.setBorder(null);
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setBgHover(new java.awt.Color(0, 153, 153));
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnImprimir.setIconTextGap(0);
        btnImprimir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimir.setPixels(0);
        btnImprimir.setSizeIcon(40.0F);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        btnImprimir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnImprimirKeyPressed(evt);
            }
        });
        jPanel2.add(btnImprimir);

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

        Oscuro.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 230, 56));

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
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1042, 0, 15, 15));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1057, 76));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tbPagos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbPagos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPagos.setGridColor(new java.awt.Color(255, 255, 255));
        tbPagos.setOpaque(false);
        tbPagos.setRowHeight(20);
        tbPagos.setShowGrid(false);
        tbPagos.getTableHeader().setResizingAllowed(false);
        tbPagos.getTableHeader().setReorderingAllowed(false);
        tbPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPagosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbPagosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbPagosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbPagos);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 109, 490, 225));

        btnBuscarF.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarF.setBorder(null);
        btnBuscarF.setText("BUSCAR NÚMERO DE RECIBO");
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

        tbDPV1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDPV1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDPV1.setEnabled(false);
        tbDPV1.setGridColor(new java.awt.Color(255, 255, 255));
        tbDPV1.setOpaque(false);
        tbDPV1.setRowHeight(20);
        tbDPV1.setShowGrid(false);
        tbDPV1.getTableHeader().setResizingAllowed(false);
        tbDPV1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDPV1);

        Blanco.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 109, 230, 225));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane3.setOpaque(false);

        tbDPV2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDPV2.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDPV2.setEnabled(false);
        tbDPV2.setGridColor(new java.awt.Color(255, 255, 255));
        tbDPV2.setOpaque(false);
        tbDPV2.setRowHeight(20);
        tbDPV2.setShowGrid(false);
        tbDPV2.getTableHeader().setResizingAllowed(false);
        tbDPV2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbDPV2);

        Blanco.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 336, 689, 220));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane4.setOpaque(false);

        tbDPV3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDPV3.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDPV3.setEnabled(false);
        tbDPV3.setGridColor(new java.awt.Color(255, 255, 255));
        tbDPV3.setOpaque(false);
        tbDPV3.setRowHeight(20);
        tbDPV3.setShowGrid(false);
        tbDPV3.getTableHeader().setResizingAllowed(false);
        tbDPV3.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbDPV3);

        Blanco.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 336, 369, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPagosMouseClicked
        // TODO add your handling code here:
        /*try {
            CabecerasTablas.limpiarTablas(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }*/
    }//GEN-LAST:event_tbPagosMouseClicked

    private void tbPagosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPagosMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablasconsDetallePagosVentas1(tbDPV1);
            CabecerasTablas.limpiarTablasconsDetallePagosVentas2(tbDPV2);
            CabecerasTablas.limpiarTablasconsDetallePagosVentas3(tbDPV3);
            controlNCProveedor.DetallePagosVentas1(tbDPV1);
            controlNCProveedor.DetallePagosVentas2(tbDPV2);
            controlNCProveedor.DetallePagosVentas3(tbDPV3);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }
    }//GEN-LAST:event_tbPagosMousePressed

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
        CabecerasTablas.limpiarTablasconsPagosVentas(tbPagos);
        CabecerasTablas.limpiarTablasconsDetallePagosVentas1(tbDPV1);
        CabecerasTablas.limpiarTablasconsDetallePagosVentas2(tbDPV2);
        CabecerasTablas.limpiarTablasconsDetallePagosVentas3(tbDPV3);
        controlNCProveedor.listarPagosVenta(tbPagos);
        Renders();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarPagosVentas.tbPagos.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione el pago que desea ANULAR");
        } else {
            int x = dlgConsultarPagosVentas.tbPagos.getSelectedRow();
            String estado = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 4).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.Sistema("El Pago ya fue anulado");
            } else {
                try {
                    String msg;
                    int rpta = Mensajes.confirmar("Seguro que desea Anular este registro de Pago?");
                    if (rpta == 0) {
                        msg = controlNCProveedor.anularPago();
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
            String cod = (JOptionPane.showInputDialog("Ingrese el Nro de Recibo de Dinero"));
            for (int i = 0; i < tbPagos.getRowCount(); i++) {
                if (tbPagos.getValueAt(i, 1).equals(cod)) {
                    tbPagos.changeSelection(i, 1, false, false);
                    tbPagosMousePressed(null);
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

    private void tbPagosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPagosMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPagosMouseReleased

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarPagosVentas.tbPagos.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione el pago que desea Imprimir el Recibo de Dinero");
        } else {
            int x = dlgConsultarPagosVentas.tbPagos.getSelectedRow();
            int cod = Integer.parseInt(dlgConsultarPagosVentas.tbPagos.getValueAt(x, 0).toString());
            String monto = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 2).toString().replace(".", "").replace(",", "");
            String estado = dlgConsultarPagosVentas.tbPagos.getValueAt(x, 4).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.Sistema("El Pago ya fue anulado");
            } else {
                prepararBD();
                String Letra = d.Convertir((monto), true);
                ImprimirRecibo(cod, Letra);
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnImprimirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirKeyPressed

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
            java.util.logging.Logger.getLogger(dlgConsultarPagosVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarPagosVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarPagosVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarPagosVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                dlgConsultarPagosVentas dialog = new dlgConsultarPagosVentas(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnImprimir;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tbDPV1;
    public static javax.swing.JTable tbDPV2;
    public static javax.swing.JTable tbDPV3;
    public static javax.swing.JTable tbPagos;
    // End of variables declaration//GEN-END:variables
}
