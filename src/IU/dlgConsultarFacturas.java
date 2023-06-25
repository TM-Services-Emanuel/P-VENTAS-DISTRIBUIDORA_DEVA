package IU;

import Componentes.Login;
import Componentes.Reporte;
import Componentes.Mensajes;
import Componentes.Numero_a_Letra;
import Componentes.Operacion;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimal2;
import Componentes.ReporteF;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import javax.swing.JOptionPane;

public class dlgConsultarFacturas extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    //public static Connection con;
    //public static Statement st;
    //public static ResultSet rss;

    public static String UsuarioL = "";

    static public Numero_a_Letra d;

    //static ConexionBD conectar = ConexionBD.getInstancia();
    public dlgConsultarFacturas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        //prepararBD();
        cabe.consFacturas(tblFactura);
        cabe.detalleFactura(tblDetalle);
        controlFactura.listFacturas(tblFactura);
        Renders();
        d = new Numero_a_Letra();

    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de ventas realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de ventas realizadas");
        }
    }

    public static void Renders() {
        dlgConsultarFacturas.tblFactura.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimal2());
    }

    public static void RendersD() {
        dlgConsultarFacturas.tblDetalle.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimal1());
        dlgConsultarFacturas.tblDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal2());
    }

    /* public static void prepararBD() {
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
    }*/
    public static void limpiarCampos() {
        txtCodCliente.setText("");
        txtRuc.setText("");
        txtRazonSocial.setText("");
        txtVendedor.setText("");
    }

    public void llamarReporteHoja1(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja1.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public void llamarReporteHoja2(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja2.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public void llamarReporteHoja3(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja3.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    public void llamarReporteHoja4(int cod, String Letra) {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        gr.FacturaLegal("\\Reports\\ventas\\Hoja4.jasper", "ID", cod, "LETRA", Letra);
        gr.cerrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        btnImprimir = new newscomponents.RSButtonBigIcon_new();
        btnAnular = new newscomponents.RSButtonBigIcon_new();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        btnSalir2 = new newscomponents.RSButtonBigIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tblFactura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura.setFillsViewportHeight(true);
        tblFactura.setGridColor(new java.awt.Color(204, 204, 204));
        tblFactura.setRowHeight(20);
        tblFactura.setShowVerticalLines(false);
        tblFactura.getTableHeader().setResizingAllowed(false);
        tblFactura.getTableHeader().setReorderingAllowed(false);
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFacturaMousePressed(evt);
            }
        });
        tblFactura.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblFacturaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("Vendedor:");

        txtVendedor.setEditable(false);
        txtVendedor.setBackground(new java.awt.Color(255, 255, 255));
        txtVendedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("ID:");

        txtCodCliente.setEditable(false);
        txtCodCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCodCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("Razón Social:");

        txtRazonSocial.setEditable(false);
        txtRazonSocial.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonSocial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonSocial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("R.U.C.: ");

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tblDetalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tblDetalle.setOpaque(false);
        tblDetalle.setRowHeight(20);
        tblDetalle.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tblDetalle);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnActualizar.setBackground(new java.awt.Color(0, 102, 102));
        btnActualizar.setBorder(null);
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBgHover(new java.awt.Color(0, 153, 153));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnActualizar.setIconTextGap(0);
        btnActualizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
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
        jPanel1.add(btnActualizar);

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
        jPanel1.add(btnImprimir);

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
        jPanel1.add(btnAnular);

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
        );

        btnSalir2.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir2.setBorder(null);
        btnSalir2.setText("BUSCAR FACTURA");
        btnSalir2.setBgHover(new java.awt.Color(255, 255, 255));
        btnSalir2.setBgShadeHover(new java.awt.Color(255, 255, 255));
        btnSalir2.setFgHover(new java.awt.Color(0, 102, 102));
        btnSalir2.setFgIcon(new java.awt.Color(0, 102, 102));
        btnSalir2.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnSalir2.setFgText(new java.awt.Color(0, 102, 102));
        btnSalir2.setFocusPainted(false);
        btnSalir2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnSalir2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir2.setIconTextGap(0);
        btnSalir2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnSalir2.setPixels(0);
        btnSalir2.setSizeIcon(20.0F);
        btnSalir2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        btnSalir2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalir2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BlancoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BlancoLayout.createSequentialGroup()
                        .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
            .addComponent(jScrollPane1)
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llamarReporteFactura() {
        Reporte gr;
        gr = new Reporte();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        //gr.MostrarReporteConParametro(System.getProperty("user.dir")+"/Reportes/Facturas/Factura.jasper", "Factura de Venta", codF,"Facturas/Fact-"+codF+".pdf");
        //gr.cerrar();
    }
    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        // TODO add your handling code here:
        /*try {
            CabecerasTablas.limpiarTablas(tblDetalle);
            controlFactura.listDetalle(tblDetalle);
            controlFactura.ListClientes();
            controlFactura.selecVendedor();
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }*/
    }//GEN-LAST:event_tblFacturaMouseClicked

    private void tblFacturaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblFacturaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturaPropertyChange

    private void tblFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablas(tblDetalle);
            controlFactura.listDetalle(tblDetalle);
            controlFactura.ListClientes();
            controlFactura.selecVendedor();
            RendersD();
        } catch (Exception e) {
            //Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_tblFacturaMousePressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarFacturas.tblFactura.getSelectedRow() < 0) {
            Mensajes.error("Seleccione una fila de la tabla");
        } else {
            int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
            String estado = dlgConsultarFacturas.tblFactura.getValueAt(x, 11).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.informacion("VENTA ANULADA: Imposible realizar la re-impresión");
            } else {
                int rpta = Mensajes.confirmar("¿Seguro que desea re-imprimir la venta?");
                if (rpta == 0) {
                    try {
                        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
                        String condicion = dlgConsultarFacturas.tblFactura.getValueAt(x, 7).toString();
                        String total = dlgConsultarFacturas.tblFactura.getValueAt(x, 9).toString();
                        if (condicion.equals("CONTADO")) {
                            String Letra = d.Convertir((total), true);
                            llamarReporteHoja3(Integer.parseInt(cod), Letra);
                            int segImpr = JOptionPane.showConfirmDialog(this, "¿Desea Imprimir TRIPLICADO Y CUADRUPLICADO?", "CONFIRMACIÓN IMPRESIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (segImpr == JOptionPane.YES_OPTION) {
                                llamarReporteHoja4(Integer.parseInt(cod), Letra);
                            }
                            try {
                                UsuarioL = Login.getUsuarioLogueado();
                                StringBuilder sql = new StringBuilder("INSERT INTO reimpresiones (re_fac_codigo, re_descripcion, re_tipo, fecha, usu) VALUES (");
                                sql.append(cod).append(", ");
                                sql.append("'RE-IMPRESION DE TICKET','");
                                sql.append(condicion).append("',");
                                sql.append("now(),'");
                                sql.append(UsuarioL).append("')");
                                String msg = Operacion.exeOperacion(sql.toString());
                                if (msg == null) {
                                    System.out.println("la re-impresion ha sido registrada");
                                } else {
                                    System.out.println("Error en registrar la re-impresion: " + msg);
                                }
                            } catch (Exception e) {
                                Mensajes.error("Hubo un error en el registro de la re-impresión");
                            }

                        } else {
                            String Letra = d.Convertir((total), true);
                            llamarReporteHoja3(Integer.parseInt(cod), Letra);
                            int segImpr = JOptionPane.showConfirmDialog(this, "¿Desea Imprimir TRIPLICADO Y CUADRUPLICADO?", "CONFIRMACIÓN IMPRESIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (segImpr == JOptionPane.YES_OPTION) {
                                llamarReporteHoja4(Integer.parseInt(cod), Letra);
                            }
                            try {
                                UsuarioL = Login.getUsuarioLogueado();
                                StringBuilder sql = new StringBuilder("INSERT INTO reimpresiones (re_fac_codigo, re_descripcion, re_tipo, fecha, usu) VALUES (");
                                sql.append(cod).append(", ");
                                sql.append("'RE-IMPRESION DE BOLETA CRÉDITO','");
                                sql.append(condicion).append("',");
                                sql.append("now(),'");
                                sql.append(UsuarioL).append("')");
                                String msg = Operacion.exeOperacion(sql.toString());
                                if (msg == null) {
                                    System.out.println("la re-impresion ha sido registrada");
                                } else {
                                    System.out.println("Error en registrar la re-impresion: " + msg);
                                }
                            } catch (Exception e) {
                                Mensajes.error("Hubo un error en el registro de la re-impresión");
                            }
                        }
                    } catch (Exception e) {
                        Mensajes.informacion(e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnImprimirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirKeyPressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablas(tblFactura);
            CabecerasTablas.limpiarTablas(tblDetalle);
            cabe.consFacturas(tblFactura);
            cabe.detalleFactura(tblDetalle);
            controlFactura.listFacturas(tblFactura);
            Renders();
            limpiarCampos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarFacturas.tblFactura.getSelectedRow() < 0) {
            Mensajes.error("Seleccione la venta que desea Anular");
        } else {
            int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
            String estado = dlgConsultarFacturas.tblFactura.getValueAt(x, 11).toString();
            String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.informacion("Esta venta ya fue anulada");
            } else {
                if (tblFactura.getSelectedRow() < 0) {
                    Mensajes.error("Seleccione la venta que desea Anular");
                } else {
                    String msg;
                    int rpta = Mensajes.confirmar("¿Seguro que desea Anular esta Venta?");
                    if (rpta == 0) {
                        try {
                            msg = controlFactura.anularFactura(cod);
                            if (msg.equals("OK")) {
                                btnActualizar.doClick();
                            }

                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnAnularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAnularKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnularKeyPressed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnSalir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1KeyPressed

    private void btnSalir2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2KeyPressed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
        try {
            String cod = (JOptionPane.showInputDialog("Ingrese N° de factura"));
            for (int i = 0; i < tblFactura.getRowCount(); i++) {
                if (tblFactura.getValueAt(i, 6).equals(cod)) {
                    tblFactura.changeSelection(i, 1, false, false);
                    tblFacturaMousePressed(null);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Consulta cancelada" + e.getMessage());
        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(dlgConsultarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                dlgConsultarFacturas dialog = new dlgConsultarFacturas(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnActualizar;
    public static newscomponents.RSButtonBigIcon_new btnAnular;
    public static newscomponents.RSButtonBigIcon_new btnImprimir;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static newscomponents.RSButtonBigIcon_new btnSalir2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblDetalle;
    public static javax.swing.JTable tblFactura;
    public static javax.swing.JTextField txtCodCliente;
    public static javax.swing.JTextField txtRazonSocial;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
