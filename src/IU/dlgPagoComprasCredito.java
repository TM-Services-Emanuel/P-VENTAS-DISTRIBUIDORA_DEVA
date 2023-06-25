/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.RenderDecimal1;
import Componentes.cargarComboBoxMovil;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlCompra1;
import Datos.GestionarCompra;
import static IU.dlgRegistrarPagosCompras.ActualizarTabla;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class dlgPagoComprasCredito extends javax.swing.JDialog {

    static String UsuarioL = "";
    public static Connection con;
    public static Statement stTransaccion;
    static ConexionBD conectar = ConexionBD.getInstancia();

    public dlgPagoComprasCredito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CabecerasTablas.DetallePagos(tbDetallePago);
        CargarCombos();
        HabilitarDatos();
        lbPagar.setText(dlgRegistrarPagosCompras.txtDif.getText());
        CalcularDif();
        Invisible();
        txtIdPago.setText(GestionarCompra.getCodigoPago());
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

    private void Invisible() {
        lbIDBanco.setVisible(false);
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        txtIdPago.setVisible(false);
    }

    private void HabilitarDatos() {
        if (rbEfectivo.isSelected()) {
            txtMonto.setEnabled(true);
            cboBanco.setEnabled(false);
            cboBanco.setSelectedIndex(0);
            txtNroCheque.setEnabled(false);
            txtNroCheque.setText("");
            txtNroCuenta.setEnabled(false);
            txtNroCuenta.setText("");
            dcFecha.setEnabled(false);
            txtFechaPago.setText("");
            cbTitular.setEnabled(false);
            cbTitular.setSelected(false);
            txtRS.setEnabled(false);
            txtRS.setText("");
            txtRUC.setEnabled(false);
            txtRUC.setText("");
            txtMonto.requestFocus();
        } else if (rbCheque.isSelected()) {
            txtMonto.setEnabled(true);
            cboBanco.setEnabled(true);
            cboBanco.setSelectedIndex(0);
            txtNroCheque.setEnabled(true);
            txtNroCheque.setText("");
            txtNroCuenta.setEnabled(true);
            txtNroCuenta.setText("");
            dcFecha.setEnabled(true);
            txtFechaPago.setText("");
            cbTitular.setEnabled(true);
            txtRS.setText("");
            txtRUC.setText("");
            cboBanco.requestFocus();
            cboBanco.setPopupVisible(true);
        }
    }

    private void habilitarTitular() {
        if (cbTitular.isSelected()) {
            txtRS.setEnabled(true);
            txtRS.setText("");
            txtRUC.setEnabled(true);
            txtRUC.setText("");
            txtRS.requestFocus();
        } else {
            txtRS.setEnabled(false);
            txtRS.setText("");
            txtRUC.setEnabled(false);
            txtRUC.setText("");
            txtMonto.requestFocus();
        }
    }

    private void CargarCombos() {
        cargarComboBoxMovil.cargarCboBancos(cboBanco, "SELECT * FROM bancos WHERE estado='S'");
    }

    private void teclaPresionada(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_F6 ->
                btnGuardar.doClick();
            case KeyEvent.VK_ESCAPE ->
                btnSalir.doClick();
            case KeyEvent.VK_DELETE ->
                btnRestar.doClick();
            default -> {
            }
        }
    }

    public static void Renders() {
        dlgPagoComprasCredito.tbDetallePago.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal1());
    }

    public static void CalcularDif() {
        int pagar, pagado, dif;
        pagar = Integer.parseInt(lbPagar.getText().trim().replace(".", "").replace(",", ""));
        pagado = Integer.parseInt(lbPagado.getText().trim().replace(".", "").replace(",", ""));
        DecimalFormat df = new DecimalFormat("#,###");
        dif = (pagado - pagar);
        dlgPagoComprasCredito.lbDif.setText(df.format(dif));
    }

    public static void LimpiarCampos() {
        cboBanco.setSelectedIndex(0);
        txtFechaPago.setText("");
        txtNroCuenta.setText("");
        txtNroCheque.setText("");
        txtMonto.setText("");
        txtRS.setText("");
        txtRUC.setText("");
        lbIDBanco.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        lbIDBanco = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        txtIdPago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetallePago = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbEfectivo = new RSMaterialComponent.RSRadioButtonMaterial();
        rbCheque = new RSMaterialComponent.RSRadioButtonMaterial();
        jLabel2 = new javax.swing.JLabel();
        cboBanco = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtFechaPago = new javax.swing.JTextField();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        lbPagar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtNroCheque = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNroCuenta = new javax.swing.JTextField();
        cbTitular = new rojerusan.RSCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtRS = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lbPagado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbDif = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 0, 15, 15));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("FINALIZAR");
        btnGuardar.setBgHover(new java.awt.Color(0, 153, 153));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STORAGE);
        btnGuardar.setPixels(0);
        btnGuardar.setSizeIcon(30.0F);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 60, 45));
        jPanel2.add(lbIDBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 25, 59, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 20, 20));

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        btnRestar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRestarKeyPressed(evt);
            }
        });
        jPanel2.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 27, -1));
        jPanel2.add(txtIdPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 70, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 709, 53));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("MONTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 143, 50, 23));

        txtMonto.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtMonto.setEnabled(false);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoKeyReleased(evt);
            }
        });
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 143, 100, 23));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbDetallePago.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetallePago.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetallePago.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetallePago.setRowHeight(18);
        tbDetallePago.setShowGrid(true);
        tbDetallePago.setShowVerticalLines(false);
        tbDetallePago.getTableHeader().setResizingAllowed(false);
        tbDetallePago.getTableHeader().setReorderingAllowed(false);
        tbDetallePago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetallePagoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetallePago);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 258, 709, 120));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(rbEfectivo);
        rbEfectivo.setForeground(new java.awt.Color(0, 0, 0));
        rbEfectivo.setSelected(true);
        rbEfectivo.setText("EFECTIVO");
        rbEfectivo.setColorCheck(new java.awt.Color(0, 102, 102));
        rbEfectivo.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rbEfectivo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEfectivoActionPerformed(evt);
            }
        });
        rbEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbEfectivoKeyPressed(evt);
            }
        });

        buttonGroup1.add(rbCheque);
        rbCheque.setForeground(new java.awt.Color(0, 0, 0));
        rbCheque.setText("CHEQUE");
        rbCheque.setColorCheck(new java.awt.Color(0, 102, 102));
        rbCheque.setColorUnCheck(new java.awt.Color(0, 0, 0));
        rbCheque.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbChequeActionPerformed(evt);
            }
        });
        rbCheque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbChequeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("ENTIDAD BANCARIA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, 120, 23));

        cboBanco.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        cboBanco.setEnabled(false);
        cboBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBancoActionPerformed(evt);
            }
        });
        cboBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboBancoKeyPressed(evt);
            }
        });
        jPanel1.add(cboBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 113, 250, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("FECHA DE PAGO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 113, -1, 23));

        txtFechaPago.setEditable(false);
        txtFechaPago.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaPago.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtFechaPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFechaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaPagoActionPerformed(evt);
            }
        });
        txtFechaPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaPagoKeyPressed(evt);
            }
        });
        jPanel1.add(txtFechaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 113, 100, 23));

        dcFecha.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dcFecha.setCalendarBackground(new java.awt.Color(255, 255, 255));
    dcFecha.setEnabled(false);
    dcFecha.setFieldFont(new java.awt.Font("Roboto Black", java.awt.Font.BOLD, 15));
    dcFecha.setNavigateFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 11));
    dcFecha.setShowOneMonth(true);
    dcFecha.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dcFechaOnCommit(evt);
        }
    });
    jPanel1.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 113, 25, 23));

    jLabel1.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
    jLabel1.setText("TOTAL A PAGAR");
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, 40));

    lbPagar.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
    lbPagar.setForeground(new java.awt.Color(0, 102, 102));
    lbPagar.setText("0");
    lbPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    lbPagar.setOpaque(false);
    jPanel1.add(lbPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 60, 120, 40));

    jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
    jSeparator1.setOpaque(true);
    jSeparator1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jSeparator1KeyPressed(evt);
        }
    });
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 186, 580, -1));

    jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel6.setText("NRO CHEQUE");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 143, 80, 23));

    txtNroCheque.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
    txtNroCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtNroCheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    txtNroCheque.setEnabled(false);
    txtNroCheque.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtNroChequeActionPerformed(evt);
        }
    });
    txtNroCheque.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtNroChequeKeyPressed(evt);
        }
    });
    jPanel1.add(txtNroCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 143, 150, 23));

    jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel8.setText("NRO CUENTA");
    jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 143, 80, 23));

    txtNroCuenta.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
    txtNroCuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtNroCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    txtNroCuenta.setEnabled(false);
    txtNroCuenta.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtNroCuentaActionPerformed(evt);
        }
    });
    txtNroCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtNroCuentaKeyPressed(evt);
        }
    });
    jPanel1.add(txtNroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 143, 150, 23));

    cbTitular.setForeground(new java.awt.Color(0, 0, 0));
    cbTitular.setText("Registrar Titular");
    cbTitular.setColorCheck(new java.awt.Color(0, 102, 102));
    cbTitular.setColorUnCheck(new java.awt.Color(0, 0, 0));
    cbTitular.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    cbTitular.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbTitularActionPerformed(evt);
        }
    });
    jPanel1.add(cbTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 173, 120, 23));

    jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel9.setText("NOMBRE Y APELLIDO / RAZÓN SOCIAL");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 195, 220, 23));

    txtRS.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
    txtRS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtRS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    txtRS.setEnabled(false);
    txtRS.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtRSActionPerformed(evt);
        }
    });
    txtRS.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtRSKeyPressed(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtRSKeyTyped(evt);
        }
    });
    jPanel1.add(txtRS, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 195, 350, 23));

    jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
    jSeparator2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jSeparator2KeyPressed(evt);
        }
    });
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 255, 709, -1));

    jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel10.setText("C.I. NRO / R.U.C");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 225, 100, 23));

    txtRUC.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
    txtRUC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtRUC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    txtRUC.setEnabled(false);
    txtRUC.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtRUCActionPerformed(evt);
        }
    });
    txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtRUCKeyPressed(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtRUCKeyTyped(evt);
        }
    });
    jPanel1.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 225, 350, 23));

    jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
    jSeparator3.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jSeparator3KeyPressed(evt);
        }
    });
    jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 104, 709, -1));

    lbPagado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    lbPagado.setForeground(new java.awt.Color(0, 102, 102));
    lbPagado.setText("0");
    lbPagado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    lbPagado.setOpaque(false);
    jPanel1.add(lbPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 110, 18));

    jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel3.setText("PAGADO");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, 18));

    jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel4.setText("DIFERENCIA");
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, 18));

    lbDif.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    lbDif.setForeground(new java.awt.Color(0, 102, 102));
    lbDif.setText("0");
    lbDif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    lbDif.setOpaque(false);
    jPanel1.add(lbDif, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 110, 18));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario de pago?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        //txtFecha.setText(InicializarFecha());
        String fe = dcFecha.getText();
        //Fecha.formatoFechaVM(fe);
        txtFechaPago.setText(Fecha.formatoFechaVM(fe));
        //txtFechaFiltro.setText(Fecha.formatoFechaVMR2(fe));
    }//GEN-LAST:event_dcFechaOnCommit

    private void txtFechaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPagoActionPerformed

    private void cboBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBancoActionPerformed
        // TODO add your handling code here:
        try {
            String id = cargarComboBoxMovil.getCodidgo(cboBanco);
            lbIDBanco.setText(id);
        } catch (Exception e) {
            lbIDBanco.setText("");
        }
    }//GEN-LAST:event_cboBancoActionPerformed

    private void rbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfectivoActionPerformed
        // TODO add your handling code here:
        HabilitarDatos();
    }//GEN-LAST:event_rbEfectivoActionPerformed

    private void rbChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbChequeActionPerformed
        // TODO add your handling code here:
        HabilitarDatos();
    }//GEN-LAST:event_rbChequeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (rbEfectivo.isSelected()) {
            if (txtMonto.getText().isEmpty()) {
                Mensajes.Sistema("Ingrese el monto pagado.");
                txtMonto.requestFocus();
            } else if (Integer.parseInt(txtMonto.getText().replace(".", "").replace(",", "")) <= 0) {
                Mensajes.informacion("El Monto no puede ser 0.");
                txtMonto.requestFocus();
            } else {
                controlCompra1.addTablaPagoComprasCredito(tbDetallePago);

            }
        } else if (rbCheque.isSelected()) {
            if (cboBanco.getSelectedIndex() == 0) {
                Mensajes.informacion("Seleccione la Entidad Bancaria.");
                cboBanco.requestFocus();
                cboBanco.setPopupVisible(true);
            } else if (txtFechaPago.getText().isEmpty()) {
                Mensajes.informacion("Fije la Fecha de Pago.");
            } else if (txtNroCuenta.getText().isEmpty()) {
                Mensajes.informacion("Ingrese el Número de Cuenta.");
                txtNroCuenta.requestFocus();
            } else if (txtNroCheque.getText().isEmpty()) {
                Mensajes.informacion("Ingrese el Número de Cheque.");
                txtNroCheque.requestFocus();
            } else if (txtMonto.getText().isEmpty()) {
                Mensajes.informacion("Ingrese el monto pagado.");
                txtMonto.requestFocus();
            } else if (Integer.parseInt(txtMonto.getText().replace(".", "").replace(",", "")) <= 0) {
                Mensajes.informacion("El Monto no puede ser 0.");
                txtMonto.requestFocus();
            } else {
                controlCompra1.addTablaPagoComprasCredito(tbDetallePago);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
        btnAdd.doClick();
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtNroChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroChequeActionPerformed
        // TODO add your handling code here:
        txtMonto.requestFocus();
    }//GEN-LAST:event_txtNroChequeActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlCompra1.delRenglonPagoCompraCreditos(tbDetallePago);
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtMontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtMonto);
        validarCampos.cantCaracteres(txtMonto, 15);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtMontoKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (tbDetallePago.getRowCount() == 0) {
            Mensajes.Sistema("Es necesario registrar el modo de pago");
            txtMonto.requestFocus();
        } else if (tbDetallePago.getRowCount() > 0) {
            if (Integer.parseInt(lbDif.getText().trim().replace(".", "").replace(",", "")) < 0) {
                Mensajes.error("El Pago detallado no es suficiente para liquidar el Total de las Facturas Crédito.\n\nVerifique:\n 1- El MONTO detallado.\n 2- Si existe más de una forma de pago.");
            } else {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas registrar el Pago al sistema?", "CONFIRMACIÓN DE PAGO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        try {
                            String usuario = Login.getUsuarioLogueado();
                            prepararBD();
                            con.setAutoCommit(false);
                            String sql = "INSERT INTO pagos_compras "
                                    + "VALUES(" + txtIdPago.getText() + ", " + dlgRegistrarPagosCompras.txtCaja.getText() + ", " + lbPagado.getText().replace(".", "").replace(",", "") + ", NOW(), '" + usuario + "', 'S')";
                            stTransaccion.executeUpdate(sql);

                            int pagos = dlgPagoComprasCredito.tbDetallePago.getRowCount();
                            for (int j = 0; j < pagos; j++) {
                                String filas[] = {
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 0).toString(), //idcompra     0
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 1).toString(), //idcaja       1
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 2).toString(), //pago con     2
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 4).toString(), //idbanco      3
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 5).toString(), //Nro cuenta   4
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 6).toString(), //Nro cheque   5
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 7).toString(), //fecha pago   6
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 8).toString(), //Monto        7
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 9).toString(), //RS           8
                                    dlgPagoComprasCredito.tbDetallePago.getValueAt(j, 10).toString() //RUC          9                            
                                };
                                if (filas[2].equals("EFECTIVO")) {
                                    sql = "INSERT INTO detalle_pagos_compra "
                                            + "VALUES(" + txtIdPago.getText() + ", '" + filas[2] + "', " + filas[7] + ")";
                                    stTransaccion.executeUpdate(sql);
                                } else if (filas[2].equals("CHEQUE")) {
                                    sql = "INSERT INTO detalle_pagos_compra "
                                            + "VALUES(" + txtIdPago.getText() + ", '" + filas[2] + "', " + filas[7] + ")";
                                    String sql2 = "INSERT INTO cheque_compra (idpago, idcaja, idbanco, titular, ruc, nro_cuenta, nro_cheque, fecha_pago, monto, usuario, estado)"
                                            + "VALUES(" + txtIdPago.getText() + "," + filas[1] + ",'" + filas[3] + "','" + filas[8] + "','" + filas[9] + "', '" + filas[4] + "', '" + filas[5] + "','" + filas[6] + "', " + filas[7] + ", '" + usuario + "', 'S')";
                                    stTransaccion.executeUpdate(sql);
                                    stTransaccion.executeUpdate(sql2);
                                }
                            }
                            if (dlgRegistrarPagosCompras.Seleccionados(11)) {
                                for (int i = 0; i < dlgRegistrarPagosCompras.tbCompraCredito.getRowCount(); i++) {
                                    boolean sel = (boolean) dlgRegistrarPagosCompras.tbCompraCredito.getValueAt(i, 11);
                                    if (sel) {
                                        String filas[] = {
                                            dlgRegistrarPagosCompras.tbCompraCredito.getModel().getValueAt(i, 0).toString()//0 //idcompra
                                        };
                                        sql = "INSERT INTO ref_pagos_compra "
                                                + "VALUES(" + txtIdPago.getText() + ", " + filas[0] + ")";
                                        String sql2 = "UPDATE compra SET pago='ABONADO' WHERE com_codigo=" + filas[0];
                                        stTransaccion.executeUpdate(sql);
                                        stTransaccion.executeUpdate(sql2);
                                    }
                                }
                            }
                            con.commit();
                            stTransaccion.close();
                            Mensajes.informacion("El Pago y sus detalles han sido regitrados exitosamente.");
                            this.dispose();
                        } catch (SQLException e) {
                            try {
                                con.rollback();
                                Mensajes.error("TRANSACCIÓN FALLIDA: El Pago no fue registrado en el sistema.\nError:ADD_PG: " + e.getMessage().toUpperCase());
                                System.out.println(e.getMessage());
                                this.dispose();
                            } catch (SQLException se) {
                                Mensajes.error(se.getMessage());
                            }
                        }
                        ActualizarTabla();
                    }
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroCuentaActionPerformed
        // TODO add your handling code here:
        txtNroCheque.requestFocus();
    }//GEN-LAST:event_txtNroCuentaActionPerformed

    private void txtNroChequeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroChequeKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtNroCheque);
        validarCampos.cantCaracteres(txtNroCheque, 10);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtNroChequeKeyPressed

    private void txtNroCuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroCuentaKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtNroCuenta);
        validarCampos.cantCaracteres(txtNroCuenta, 15);
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtNroCuentaKeyPressed

    private void cboBancoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboBancoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_cboBancoKeyPressed

    private void txtFechaPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaPagoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtFechaPagoKeyPressed

    private void rbEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbEfectivoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_rbEfectivoKeyPressed

    private void rbChequeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbChequeKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_rbChequeKeyPressed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnRestarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRestarKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnRestarKeyPressed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnAddKeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jSeparator1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSeparator1KeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_jSeparator1KeyPressed

    private void tbDetallePagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetallePagoKeyPressed
        // TODO add your handling code here:
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_tbDetallePagoKeyPressed

    private void txtRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRSActionPerformed
        // TODO add your handling code here:
        txtRUC.requestFocus();
    }//GEN-LAST:event_txtRSActionPerformed

    private void txtRSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRSKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRSKeyPressed

    private void jSeparator2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSeparator2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSeparator2KeyPressed

    private void txtRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCActionPerformed
        // TODO add your handling code here:
        btnAdd.doClick();
    }//GEN-LAST:event_txtRUCActionPerformed

    private void txtRUCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUCKeyPressed

    private void jSeparator3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSeparator3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSeparator3KeyPressed

    private void cbTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTitularActionPerformed
        // TODO add your handling code here:
        habilitarTitular();
    }//GEN-LAST:event_cbTitularActionPerformed

    private void txtRSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRSKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 50;
        if (txtRS.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRSKeyTyped

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 12;
        if (txtRUC.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtMontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            txtMonto.setText(df.format(Integer.valueOf(txtMonto.getText().trim().replace(".", "").replace(",", ""))));
        } catch (Exception e) {/*Mensajes.error("Error al formatear costo: "+e.getMessage());*/
        }

    }//GEN-LAST:event_txtMontoKeyReleased

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
            java.util.logging.Logger.getLogger(dlgPagoComprasCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgPagoComprasCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgPagoComprasCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgPagoComprasCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgPagoComprasCredito dialog = new dlgPagoComprasCredito(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    private javax.swing.JButton btnRestar;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    public static rojerusan.RSCheckBox cbTitular;
    public static javax.swing.JComboBox<String> cboBanco;
    public static datechooser.beans.DateChooserCombo dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTextField lbDif;
    public static javax.swing.JTextField lbIDBanco;
    public static javax.swing.JTextField lbPagado;
    private static javax.swing.JTextField lbPagar;
    public static RSMaterialComponent.RSRadioButtonMaterial rbCheque;
    public static RSMaterialComponent.RSRadioButtonMaterial rbEfectivo;
    public static javax.swing.JTable tbDetallePago;
    public static javax.swing.JTextField txtFechaPago;
    private javax.swing.JTextField txtIdPago;
    public static javax.swing.JTextField txtMonto;
    public static javax.swing.JTextField txtNroCheque;
    public static javax.swing.JTextField txtNroCuenta;
    public static javax.swing.JTextField txtRS;
    public static javax.swing.JTextField txtRUC;
    // End of variables declaration//GEN-END:variables
}
