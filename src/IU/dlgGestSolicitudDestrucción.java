package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.cargarComboBoxMovil;
import Componentes.generarCodigos;
import Componentes.RenderDecimal2;
import Componentes.RenderDecimalconPuntos;
import Controladores.CabecerasTablas;
import Controladores.controlSalida;
import Datos.GestionarSalida;
import java.text.DecimalFormat;
import Componentes.Fecha;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Componentes.Login;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
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
public class dlgGestSolicitudDestrucción extends javax.swing.JDialog {

    public static Connection con;
    public static Statement stTransaccion;
    static ConexionBD conectar = ConexionBD.getInstancia();

    static String opcion = "";

    /**
     * Creates new form dlgGestSolicitudNCP
     *
     * @param parent
     * @param modal
     */
    public dlgGestSolicitudDestrucción(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CabecerasTablas.detalleSolicitudNCP(tbDetalle);
        //CabecerasTablas.limpiarTablasSalidasDNCP(tbDetalle);
        CabecerasTablas.RefenSolicitudNCP(tbSalidas);
        //CabecerasTablas.limpiarTablasRefSolNCP(tbSalidas);
        String montoFinal = String.valueOf(controlSalida.getTotalDetalleSalidaD());
        DecimalFormat df = new DecimalFormat("#,###");
        dlgGestSolicitudDestrucción.txtTotal.setText(df.format(Integer.parseInt(montoFinal.replace(".", "").replace(",", ""))));
        cargarComboBoxMovil.cargarCboProveedor(cbProveedor, "SELECT pro_codigo, pro_razonsocial, pro_indicador FROM proveedor WHERE pro_indicador='S'");
        scrolltbsalidas.setVisible(false);
        txtcodProv.setVisible(false);
        txtFechaR.setVisible(false);
        ckTexto();
    }
    
    private void ImprimirDocumento(int cod) {
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\salidas\\solicitudDestruccion.jasper");
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
    
    public static void ckTexto(){
        if(ckPendiente.isSelected()){
            ckPendiente.setText("SOLICITUD PROCESADA");
        }else{
            ckPendiente.setText("PROCESO PENDIENTE");
        }
    }

    public static void Renders() {
        tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimalconPuntos());
        tbDetalle.getColumnModel().getColumn(7).setCellRenderer(new RenderDecimal2());
        tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal2());
    }

    public void Nuevo() {
        btnNuevoActionPerformed(null);
    }

    public static void HabilCB() {
        if (tbDetalle.getRowCount() == 0) {
            cbProveedor.setEnabled(true);
        } else {
            cbProveedor.setEnabled(false);
        }
    }

    private void Seleccionado() {
        if (dlgGestSolicitudDestrucción.tbSalidas.getRowCount() != 0) {
            for (int i = 0; i < dlgGestSolicitudDestrucción.tbSalidas.getRowCount(); i++) {
                int f = Integer.parseInt(dlgGestSolicitudDestrucción.tbSalidas.getValueAt(i, 0).toString());
                dlgSeleccionarSalidasNC.tbSalidas.setValueAt(true, f, 7);
            }
        }
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

    private void Cancelar() {
        CabecerasTablas.detalleSolicitudNCP(tbDetalle);
        CabecerasTablas.limpiarTablasSalidasDNCP(tbDetalle);
        CabecerasTablas.RefenSolicitudNCP(tbSalidas);
        CabecerasTablas.limpiarTablasRefSolNCP(tbSalidas);
        txtCod.setText("");
        txtCaja.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtObs.setText("");
        cbProveedor.setSelectedIndex(0);
        cbProveedor.setEnabled(false);
        btnCargar.setEnabled(false);
        dlgSolicitudDestrucción.btnActualizar.doClick();
        this.dispose();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        txtcodProv = new javax.swing.JTextField();
        txtFechaR = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbProveedor = new javax.swing.JComboBox<>();
        ckPendiente = new rojerusan.RSCheckBox();
        btnCargar = new newscomponents.RSButtonBigIcon_new();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        scrolltbsalidas = new javax.swing.JScrollPane();
        tbSalidas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 6));

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
        jPanel3.add(btnNuevo);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBgHover(new java.awt.Color(0, 153, 153));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setPixels(0);
        btnGuardar.setSizeIcon(40.0F);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setBorder(null);
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBgHover(new java.awt.Color(0, 153, 153));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setPixels(0);
        btnCancelar.setSizeIcon(40.0F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);

        txtcodProv.setEditable(false);
        txtcodProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(txtcodProv, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 538, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1040, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("ID SOLICITUD");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, -1, 23));

        txtCod.setEditable(false);
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 12, 135, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("ID CAJA");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 41, -1, 23));

        txtCaja.setEditable(false);
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 41, 135, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("FECHA");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 23));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 90, 23));

        txtHora.setEditable(false);
        txtHora.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 40, 40, 23));

        jLabel5.setText("PROVEEDOR");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 70, -1, 23));

        cbProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbProveedor.setEnabled(false);
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });
        jPanel4.add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 70, 332, 23));

        ckPendiente.setForeground(new java.awt.Color(0, 102, 102));
        ckPendiente.setText("PROCESO PENDIENTE");
        ckPendiente.setColorCheck(new java.awt.Color(0, 102, 102));
        ckPendiente.setColorUnCheck(new java.awt.Color(0, 0, 0));
        ckPendiente.setEnabled(false);
        ckPendiente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ckPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckPendienteActionPerformed(evt);
            }
        });
        jPanel4.add(ckPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 12, 190, 23));

        btnCargar.setBackground(new java.awt.Color(0, 102, 102));
        btnCargar.setBorder(null);
        btnCargar.setBgHover(new java.awt.Color(255, 0, 0));
        btnCargar.setEnabled(false);
        btnCargar.setFocusPainted(false);
        btnCargar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnCargar.setIconTextGap(0);
        btnCargar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);
        btnCargar.setPixels(0);
        btnCargar.setSizeIcon(15.0F);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        btnCargar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCargarKeyPressed(evt);
            }
        });
        jPanel4.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 70, 60, 23));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtObs.setEditable(false);
        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtObs.setRows(1);
        jScrollPane2.setViewportView(txtObs);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 7, 280, 87));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 80, 790, 104));

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
        tbDetalle.setEnabled(false);
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(18);
        tbDetalle.setShowGrid(true);
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbDetalle);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 190, 1039, 395));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 102, 102));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 590, 236, 26));

        scrolltbsalidas.setBackground(new java.awt.Color(255, 255, 255));
        scrolltbsalidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbSalidas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "SALIDAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSalidas.setEnabled(false);
        tbSalidas.setGridColor(new java.awt.Color(204, 204, 204));
        tbSalidas.setRowHeight(18);
        tbSalidas.setShowGrid(true);
        tbSalidas.setShowVerticalLines(false);
        tbSalidas.getTableHeader().setResizingAllowed(false);
        tbSalidas.getTableHeader().setReorderingAllowed(false);
        scrolltbsalidas.setViewportView(tbSalidas);

        jPanel1.add(scrolltbsalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 220, 104));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarSalida.getCodigoSolicitudD();
        txtCod.setText(cod);
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.getCodigoCajaActual("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        txtFecha.setText(Fecha.fechaCorrectaFachada());
        txtFechaR.setText(Fecha.fechaCorrecta());
        txtHora.setText(Fecha.darHoraSinSS());
        cbProveedor.setEnabled(true);
        btnCargar.setEnabled(true);
        btnNuevo.setEnabled(false);
        opcion = "N";
        CabecerasTablas.limpiarTablasSalidasDNCP(tbDetalle);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getRowCount() == 0) {
            Mensajes.Sistema("Detalle de Salida vacía.");
            btnCargar.doClick();
        } else {
            if (opcion.equals("N")) {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas registrar esta Solicitud de Destrucción al sistema?", "CONFIRMACIÓN DE SOLICITUD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        try {
                            String usuario = Login.getUsuarioLogueado();
                            prepararBD();
                            con.setAutoCommit(false);
                            String sql = "insert into solicitud_destruccion values(" + txtCod.getText() + "," + txtCaja.getText() + "," + txtcodProv.getText() + ",'"
                                    + txtFechaR.getText() + "','" + txtHora.getText() + "','" + txtObs.getText() + "', '" + txtTotal.getText().replace(".", "").replace(",", "") + "','N','S','" + usuario + "')";
                            stTransaccion.executeUpdate(sql);
                            int fila = tbDetalle.getRowCount();
                            for (int j = 0; j < fila; j++) {
                                String filas[] = {
                                    tbDetalle.getValueAt(j, 1).toString(), //idmotivo // 0
                                    tbDetalle.getValueAt(j, 3).toString(), //idproducto //1
                                    tbDetalle.getValueAt(j, 6).toString(), //cantidad //2
                                    tbDetalle.getValueAt(j, 7).toString(), //precio //3
                                    tbDetalle.getValueAt(j, 8).toString()};//total // 4
                                sql = "insert into detalle_destruccion values(" + txtCod.getText() + "," + filas[0] + "," + filas[1] + "," + filas[2] + "," + filas[3] + "," + filas[4] + ")";
                                String sql2 = "UPDATE dañados SET stock=stock-" + filas[2] + " WHERE  idproducto=" + filas[1];
                                stTransaccion.executeUpdate(sql);
                                stTransaccion.executeUpdate(sql2);
                            }

                            int fila2 = tbSalidas.getRowCount();
                            for (int j = 0; j < fila2; j++) {
                                String filas[] = {
                                    tbSalidas.getValueAt(j, 1).toString(),};//idsalida // 0
                                sql = "insert into ref_destruccion_salida values(" + txtCod.getText() + "," + filas[0] + ")";
                                String sql2 = "UPDATE salida SET procesado='S' WHERE  sal_codigo=" + filas[0];
                                stTransaccion.executeUpdate(sql);
                                stTransaccion.executeUpdate(sql2);
                            }
                            con.commit();
                            stTransaccion.close();
                            Mensajes.informacion("La Solicitud de Destrucción\nN°:" + txtCod.getText() + "\nHa sido regitrado exitosamente");
                        } catch (SQLException e) {
                            try {
                                con.rollback();
                                Mensajes.error("TRANSACCIÓN FALLIDA: La solicitud no fue registrada en el sistema.\nError:ADD_S: " + e.getMessage().toUpperCase());
                            } catch (SQLException se) {
                                Mensajes.error(se.getMessage());
                            }
                        }
                        ImprimirDocumento(Integer.parseInt(txtCod.getText()));
                        Cancelar();
                    }
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            } else if (opcion.equals("M")) {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas actualizar el estado de esta Solicitud de Destricción?", "CONFIRMACIÓN DE SOLICITUD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        int id = Integer.parseInt(txtCod.getText().trim());
                        String proc;
                        if(ckPendiente.isSelected()){
                            proc="S";
                        }else{
                            proc="N";
                        }
                            
                        String msg = controlSalida.ProcDestruccion(id, proc);
                        if (msg.equals("OK")) {
                            Cancelar();
                        } else {
                            Mensajes.error("DEL_SOL: " + msg);
                        }
                    }
                } catch (Exception e) {

                }
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar y Cerrar el formulario?");
        if (rpta == 0) {
            CabecerasTablas.detalleSolicitudNCP(tbDetalle);
            CabecerasTablas.limpiarTablasSalidasDNCP(tbDetalle);
            CabecerasTablas.RefenSolicitudNCP(tbSalidas);
            CabecerasTablas.limpiarTablasRefSolNCP(tbSalidas);
            txtCod.setText("");
            txtCaja.setText("");
            txtFecha.setText("");
            txtHora.setText("");
            txtObs.setText("");
            cbProveedor.setSelectedIndex(0);
            cbProveedor.setEnabled(false);
            btnCargar.setEnabled(false);
            dlgSolicitudDestrucción.btnActualizar.doClick();
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ckPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckPendienteActionPerformed
        // TODO add your handling code here:
        ckTexto();
    }//GEN-LAST:event_ckPendienteActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        if (cbProveedor.getSelectedIndex() == 0) {
            Mensajes.Sistema("Seleccione el Proveedor cargar la tabla de Salidas");
            cbProveedor.setPopupVisible(true);
            cbProveedor.requestFocus();
        } else {
            try {
                dlgSeleccionarSalidasD sncp = new dlgSeleccionarSalidasD(null, true);
                sncp.setLocationRelativeTo(null);
                Seleccionado();
                sncp.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("Servidor no esta activo");
            }

        }

    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnCargarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCargarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarKeyPressed

    private void txtcodProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodProvActionPerformed

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
        if (cbProveedor.getSelectedIndex() == 0) {
            txtcodProv.setText("");
        } else {
            cbProveedor.setPopupVisible(true);
            String id = cargarComboBoxMovil.getCodidgo(cbProveedor);
            txtcodProv.setText(String.valueOf(id));
        }
    }//GEN-LAST:event_cbProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(dlgGestSolicitudDestrucción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgGestSolicitudDestrucción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgGestSolicitudDestrucción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgGestSolicitudDestrucción.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgGestSolicitudDestrucción dialog = new dlgGestSolicitudDestrucción(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    public static newscomponents.RSButtonBigIcon_new btnCargar;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static javax.swing.JComboBox<String> cbProveedor;
    public static rojerusan.RSCheckBox ckPendiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane scrolltbsalidas;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTable tbSalidas;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaR;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextArea txtObs;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtcodProv;
    // End of variables declaration//GEN-END:variables

}
