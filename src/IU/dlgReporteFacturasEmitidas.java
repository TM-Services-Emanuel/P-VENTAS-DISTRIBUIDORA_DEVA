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

public class dlgReporteFacturasEmitidas extends javax.swing.JDialog {

    public Reporte jasper;
    public static ResultSet rs;
    public static Statement sentencia;
    public static Connection con;
    static String Fdesde;
    static String Fhasta;

    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgReporteFacturasEmitidas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        CargarFecha();
        invisible();
        cbClienteEspecificoActionPerformed(null);
        prepararBD();
    }

    private void CargarFecha() {
        lbFechaActual.setText(Fecha.fechaFormulario());
        lbFechaActualR.setText(Fecha.fechaCorrecta());
    }

    private void invisible() {
        txtFDesdeR.setVisible(false);
        txtFHastaR.setVisible(false);
        lbFechaActualR.setVisible(false);
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
        lbFechaActualR = new javax.swing.JLabel();
        lbCodCliente = new javax.swing.JLabel();
        lbSi = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbRankingA = new javax.swing.JRadioButton();
        rbRankingF = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lbFechaActual = new javax.swing.JLabel();
        dcFDesde = new datechooser.beans.DateChooserCombo();
        dcFHasta = new datechooser.beans.DateChooserCombo();
        txtFDesde = new javax.swing.JTextField();
        txtFHasta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        cbCompleto = new rojerusan.RSCheckBox();
        cbAbonado = new rojerusan.RSCheckBox();
        cbpendiente = new rojerusan.RSCheckBox();
        jPanel4 = new javax.swing.JPanel();
        cbClienteEspecifico = new rojerusan.RSCheckBox();
        btnBuscar = new RSMaterialComponent.RSButtonIconUno();
        lbRZ = new javax.swing.JLabel();

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
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 15, 15));

        txtFHastaR.setEditable(false);
        txtFHastaR.setBackground(new java.awt.Color(255, 255, 204));
        txtFHastaR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFHastaR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(txtFHastaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 11, 90, -1));

        txtFDesdeR.setEditable(false);
        txtFDesdeR.setBackground(new java.awt.Color(255, 255, 204));
        txtFDesdeR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFDesdeR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Oscuro.add(txtFDesdeR, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 37, 90, -1));

        lbFechaActualR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaActualR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Oscuro.add(lbFechaActualR, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 63, 90, 21));

        lbCodCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Oscuro.add(lbCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 63, 66, 21));

        lbSi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Oscuro.add(lbSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 60, 20));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);

        GrupoReporte.add(rbRankingA);
        rbRankingA.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbRankingA.setSelected(true);
        rbRankingA.setText("Venta total del día (fecha actual):");
        rbRankingA.setOpaque(false);
        rbRankingA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRankingAActionPerformed(evt);
            }
        });

        GrupoReporte.add(rbRankingF);
        rbRankingF.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbRankingF.setText("Venta total entre fechas:");
        rbRankingF.setOpaque(false);
        rbRankingF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRankingFActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Desde");

        lbFechaActual.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbFechaActual.setText("jLabel2");

        dcFDesde.setEnabled(false);
        dcFDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFDesdeOnCommit(evt);
            }
        });

        dcFHasta.setEnabled(false);
        dcFHasta.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFHastaOnCommit(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Hasta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbRankingA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbRankingF, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(dcFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(dcFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRankingA)
                    .addComponent(lbFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbRankingF)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dcFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(cbCompleto);
        cbCompleto.setForeground(new java.awt.Color(0, 0, 0));
        cbCompleto.setSelected(true);
        cbCompleto.setText("Completo");
        cbCompleto.setColorCheck(new java.awt.Color(0, 102, 102));
        cbCompleto.setColorUnCheck(new java.awt.Color(0, 0, 0));
        cbCompleto.setFocusable(false);
        cbCompleto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        buttonGroup1.add(cbAbonado);
        cbAbonado.setForeground(new java.awt.Color(0, 0, 0));
        cbAbonado.setText("Abonados");
        cbAbonado.setColorCheck(new java.awt.Color(0, 102, 102));
        cbAbonado.setColorUnCheck(new java.awt.Color(0, 0, 0));
        cbAbonado.setFocusable(false);
        cbAbonado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        buttonGroup1.add(cbpendiente);
        cbpendiente.setForeground(new java.awt.Color(0, 0, 0));
        cbpendiente.setText("Pendientes");
        cbpendiente.setColorCheck(new java.awt.Color(0, 102, 102));
        cbpendiente.setColorUnCheck(new java.awt.Color(0, 0, 0));
        cbpendiente.setFocusable(false);
        cbpendiente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbpendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbpendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        btnBuscar.setBackground(new java.awt.Color(0, 102, 102));
        btnBuscar.setBackgroundHover(new java.awt.Color(0, 153, 153));
        btnBuscar.setEnabled(false);
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lbRZ.setBackground(new java.awt.Color(0, 102, 102));
        lbRZ.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbRZ.setForeground(new java.awt.Color(255, 255, 255));
        lbRZ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRZ.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbClienteEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
            .addComponent(lbRZ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbClienteEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRZ, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BlancoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BlancoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbRankingAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRankingAActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(false);
        txtFDesde.setText("");
        txtFDesdeR.setText("");
        dcFDesde.setEnabled(false);
        txtFHasta.setEnabled(false);
        txtFHasta.setText("");
        txtFHastaR.setText("");
        dcFHasta.setEnabled(false);
    }//GEN-LAST:event_rbRankingAActionPerformed

    private void rbRankingFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRankingFActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(true);
        dcFDesde.setEnabled(true);
        txtFHasta.setEnabled(true);
        dcFHasta.setEnabled(true);
    }//GEN-LAST:event_rbRankingFActionPerformed

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
            dlgBuscarCliente1 bc = new dlgBuscarCliente1(null, true);
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
        int rpta = Mensajes.confirmar("¿Seguro que desea generar el Reporte?");
        if (rpta == 0) {
            if (lbSi.getText().equals("NO")) {
                if (cbCompleto.isSelected()) {
                    if (rbRankingA.isSelected()) {
                        VisorReportes vr = new VisorReportes(null, true);
                        try {
                            //archivo jasper
                            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                            String jasperUrl3 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral.jasper");
                            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl3);
                            //para los parametro
                            Map parametros = new HashMap();
                            parametros.clear();
                            //Nuestro parametro se llama "pLastName"
                            parametros.put("desde", Date.valueOf(lbFechaActualR.getText().trim()));
                            parametros.put("hasta", Date.valueOf(lbFechaActualR.getText().trim()));
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
                    } else {
                        VisorReportes vr = new VisorReportes(null, true);
                        try {
                            //archivo jasper
                            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                            String jasperUrl4 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral.jasper");
                            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl4);
                            //para los parametro
                            Map parametros = new HashMap();
                            parametros.clear();
                            //Nuestro parametro se llama "pLastName"
                            parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                            parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));
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
                        //this.dispose();
                    }
                } else if (cbAbonado.isSelected()) {
                    if (rbRankingA.isSelected()) {
                        VisorReportes vr = new VisorReportes(null, true);
                        try {
                            //archivo jasper
                            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                            String jasperUrl7 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral4.jasper");
                            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl7);
                            //para los parametro
                            Map parametros = new HashMap();
                            parametros.clear();
                            //Nuestro parametro se llama "pLastName"
                            parametros.put("desde", Date.valueOf(lbFechaActualR.getText().trim()));
                            parametros.put("hasta", Date.valueOf(lbFechaActualR.getText().trim()));
                            parametros.put("pago", "ABONADO");
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
                        //this.dispose();
                    } else {
                        VisorReportes vr = new VisorReportes(null, true);
                        try {
                            //archivo jasper
                            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                            String jasperUrl8 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral4.jasper");
                            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl8);
                            //para los parametro
                            Map parametros = new HashMap();
                            parametros.clear();
                            //Nuestro parametro se llama "pLastName"
                            parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                            parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));
                            parametros.put("pago", "ABONADO");
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
                        //this.dispose();
                    }
                } else if (cbpendiente.isSelected()) {
                    if (rbRankingA.isSelected()) {
                        VisorReportes vr = new VisorReportes(null, true);
                        try {
                            //archivo jasper
                            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                            String jasperUrl11 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral4.jasper");
                            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl11);
                            //para los parametro
                            Map parametros = new HashMap();
                            parametros.clear();
                            //Nuestro parametro se llama "pLastName"
                            parametros.put("desde", Date.valueOf(lbFechaActualR.getText().trim()));
                            parametros.put("hasta", Date.valueOf(lbFechaActualR.getText().trim()));
                            parametros.put("pago", "PENDIENTE");
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
                        //this.dispose();
                    } else {
                        VisorReportes vr = new VisorReportes(null, true);
                        try {
                            //archivo jasper
                            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                            String jasperUrl12 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral4.jasper");
                            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl12);
                            //para los parametro
                            Map parametros = new HashMap();
                            parametros.clear();
                            //Nuestro parametro se llama "pLastName"
                            parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                            parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));
                            parametros.put("pago", "PENDIENTE");
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
                        //this.dispose();
                    }
                }
            } else if (lbSi.getText().equals("SI")) {
                if (cbCompleto.isSelected()) {
                    if (rbRankingA.isSelected()) {
                        if (lbCodCliente.getText().isEmpty()) {
                            Mensajes.Sistema("Busque y seleccione un Cliente");
                        } else {
                            VisorReportes vr = new VisorReportes(null, true);
                            try {
                                //archivo jasper
                                //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                                String jasperUrl1 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral2.jasper");
                                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl1);
                                //para los parametro
                                Map parametros = new HashMap();
                                parametros.clear();
                                //Nuestro parametro se llama "pLastName"
                                parametros.put("idCliente", Integer.parseInt(lbCodCliente.getText().trim()));
                                parametros.put("desde", Date.valueOf(lbFechaActualR.getText().trim()));
                                parametros.put("hasta", Date.valueOf(lbFechaActualR.getText().trim()));

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
                            //this.dispose();
                        }
                    } else {
                        if (lbCodCliente.getText().isEmpty()) {
                            Mensajes.Sistema("Busque y seleccione un Cliente");
                        } else {
                            VisorReportes vr = new VisorReportes(null, true);
                            try {
                                //archivo jasper
                                //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                                String jasperUrl2 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral2.jasper");
                                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl2);
                                //para los parametro
                                Map parametros = new HashMap();
                                parametros.clear();
                                //Nuestro parametro se llama "pLastName"
                                parametros.put("idCliente", Integer.parseInt(lbCodCliente.getText().trim()));
                                parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                                parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));

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
                            //this.dispose();
                        }
                    }
                } else if (cbAbonado.isSelected()) {
                    if (rbRankingA.isSelected()) {
                        if (lbCodCliente.getText().isEmpty()) {
                            Mensajes.Sistema("Busque y seleccione un Cliente");
                        } else {
                            VisorReportes vr = new VisorReportes(null, true);
                            try {
                                //archivo jasper
                                //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                                String jasperUrl5 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral3.jasper");
                                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl5);
                                //para los parametro
                                Map parametros = new HashMap();
                                parametros.clear();
                                //Nuestro parametro se llama "pLastName"
                                parametros.put("idCliente", Integer.parseInt(lbCodCliente.getText().trim()));
                                parametros.put("desde", Date.valueOf(lbFechaActualR.getText().trim()));
                                parametros.put("hasta", Date.valueOf(lbFechaActualR.getText().trim()));
                                parametros.put("pago", "ABONADO");

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
                            //this.dispose();
                        }
                    } else {
                        if (lbCodCliente.getText().isEmpty()) {
                            Mensajes.Sistema("Busque y seleccione un Cliente");
                        } else {
                            VisorReportes vr = new VisorReportes(null, true);
                            try {
                                //archivo jasper
                                //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                                String jasperUrl6 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral3.jasper");
                                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl6);
                                //para los parametro
                                Map parametros = new HashMap();
                                parametros.clear();
                                //Nuestro parametro se llama "pLastName"
                                parametros.put("idCliente", Integer.parseInt(lbCodCliente.getText().trim()));
                                parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                                parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));
                                parametros.put("pago", "ABONADO");

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
                            //this.dispose();
                        }
                    }
                } else if (cbpendiente.isSelected()) {
                    if (rbRankingA.isSelected()) {
                        if (lbCodCliente.getText().isEmpty()) {
                            Mensajes.Sistema("Busque y seleccione un Cliente");
                        } else {
                            VisorReportes vr = new VisorReportes(null, true);
                            try {
                                //archivo jasper
                                //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                                String jasperUrl9 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral3.jasper");
                                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl9);
                                //para los parametro
                                Map parametros = new HashMap();
                                parametros.clear();
                                //Nuestro parametro se llama "pLastName"
                                parametros.put("idCliente", Integer.parseInt(lbCodCliente.getText().trim()));
                                parametros.put("desde", Date.valueOf(lbFechaActualR.getText().trim()));
                                parametros.put("hasta", Date.valueOf(lbFechaActualR.getText().trim()));
                                parametros.put("pago", "PENDIENTE");
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
                            //this.dispose();
                        }
                    } else {
                        if (lbCodCliente.getText().isEmpty()) {
                            Mensajes.Sistema("Busque y seleccione un Cliente");
                        } else {
                            VisorReportes vr = new VisorReportes(null, true);
                            try {
                                //archivo jasper
                                //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
                                String jasperUrl10 = System.getProperty("user.dir").concat("\\Reports\\ventas\\ventas_gral3.jasper");
                                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl10);
                                //para los parametro
                                Map parametros = new HashMap();
                                parametros.clear();
                                //Nuestro parametro se llama "pLastName"
                                parametros.put("idCliente", Integer.parseInt(lbCodCliente.getText().trim()));
                                parametros.put("desde", Date.valueOf(txtFDesdeR.getText().trim()));
                                parametros.put("hasta", Date.valueOf(txtFHastaR.getText().trim()));
                                parametros.put("pago", "PENDIENTE");
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
                            //this.dispose();
                        }
                    }
                }
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
            java.util.logging.Logger.getLogger(dlgReporteFacturasEmitidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteFacturasEmitidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteFacturasEmitidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteFacturasEmitidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgReporteFacturasEmitidas dialog = new dlgReporteFacturasEmitidas(new javax.swing.JFrame(), true);
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
    private rojerusan.RSCheckBox cbAbonado;
    private rojerusan.RSCheckBox cbClienteEspecifico;
    private rojerusan.RSCheckBox cbCompleto;
    private rojerusan.RSCheckBox cbpendiente;
    public static datechooser.beans.DateChooserCombo dcFDesde;
    public static datechooser.beans.DateChooserCombo dcFHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbCodCliente;
    private javax.swing.JLabel lbFechaActual;
    private javax.swing.JLabel lbFechaActualR;
    public static javax.swing.JLabel lbRZ;
    private javax.swing.JLabel lbSi;
    private javax.swing.JRadioButton rbRankingA;
    private javax.swing.JRadioButton rbRankingF;
    public static javax.swing.JTextField txtFDesde;
    public static javax.swing.JTextField txtFDesdeR;
    public static javax.swing.JTextField txtFHasta;
    public static javax.swing.JTextField txtFHastaR;
    // End of variables declaration//GEN-END:variables
}
