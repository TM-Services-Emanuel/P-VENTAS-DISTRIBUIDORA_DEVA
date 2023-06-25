package IU;

import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.cargarComboBoxMovil;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlCliente;
import Datos.GestionarCliente;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public final class dlgGestClientes extends javax.swing.JDialog {

    public dlgGestClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboBoxMovil.cargarCiudad(cbCiudad, "SELECT * FROM ciudad WHERE estado='S'");
        cargarIcono();
        lbCiudad.setVisible(false);
        txtFechaR.setVisible(false);
        btnNuevo.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        contenedor = new javax.swing.JTabbedPane();
        pnDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox();
        btnCiudad = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lbCiudad = new javax.swing.JLabel();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();
        jLabel9 = new javax.swing.JLabel();
        txtBarrio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboSexo = new javax.swing.JComboBox();
        btnNacionalidad = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbotipopersona = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cboNacionalidad = new javax.swing.JComboBox();
        btnNacionalidad1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        dcFecha = new datechooser.beans.DateChooserCombo();
        pnDistribucion = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        ckLunes = new rojerusan.RSCheckBox();
        ckMartes = new rojerusan.RSCheckBox();
        ckJueves = new rojerusan.RSCheckBox();
        ckMiercoles = new rojerusan.RSCheckBox();
        ckSabado = new rojerusan.RSCheckBox();
        ckViernes = new rojerusan.RSCheckBox();
        ckDomingo = new rojerusan.RSCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        rSCheckBox7 = new rojerusan.RSCheckBox();
        rSCheckBox9 = new rojerusan.RSCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ckSupermercado = new rojerusan.RSCheckBox();
        pnObservacion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        txtFechaR = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor.setBackground(new java.awt.Color(0, 102, 102));
        contenedor.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        contenedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        contenedor.setOpaque(true);

        pnDatos.setBackground(new java.awt.Color(255, 255, 255));
        pnDatos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        pnDatos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnDatosFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("ID CLIENTE");

        lblCodC.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblCodC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblCodC.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("RAZÓN SOCIAL");

        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("DIRECCIÓN (CALLE)");

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("CIUDAD");

        cbCiudad.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiudadActionPerformed(evt);
            }
        });
        cbCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCiudadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbCiudadKeyReleased(evt);
            }
        });

        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        btnCiudad.setToolTipText("Gestionar Ciudad");
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("CELULAR/TELEFONO");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("C.I / R.U.C.   ");

        txtRuc.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        rSButtonIconUno1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonIconUno1.setBackgroundHover(new java.awt.Color(255, 255, 255));
        rSButtonIconUno1.setEnabled(false);
        rSButtonIconUno1.setForegroundHover(new java.awt.Color(0, 102, 0));
        rSButtonIconUno1.setForegroundText(new java.awt.Color(17, 35, 46));
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setText("BARRIO");

        txtBarrio.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtBarrio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrioActionPerformed(evt);
            }
        });
        txtBarrio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarrioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarrioKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("SEXO");

        cboSexo.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN ESPECIFICAR", "MASCULINO", "FEMENINO", "OTROS" }));
        cboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSexoActionPerformed(evt);
            }
        });
        cboSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboSexoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboSexoKeyReleased(evt);
            }
        });

        btnNacionalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        btnNacionalidad.setToolTipText("Gestionar Ciudad");
        btnNacionalidad.setBorderPainted(false);
        btnNacionalidad.setContentAreaFilled(false);
        btnNacionalidad.setEnabled(false);
        btnNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNacionalidadActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("TIPO DE PERSONA");

        cbotipopersona.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbotipopersona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN ESPECIFICAR", "FÍSICA", "JURIDICA" }));
        cbotipopersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipopersonaActionPerformed(evt);
            }
        });
        cbotipopersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbotipopersonaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbotipopersonaKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setText("NACIONALIDAD");

        cboNacionalidad.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cboNacionalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIN ESPECIFICAR", "PARAGUAY", "ARGENTINA", "BRASIL", "CHILE", "BOLIVIA", "PERU", "ECUADOR", "VENEZUELA", "PORTUGAL", "ESPAÑA", "OTRA NACIONALIDAD" }));
        cboNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNacionalidadActionPerformed(evt);
            }
        });
        cboNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboNacionalidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboNacionalidadKeyReleased(evt);
            }
        });

        btnNacionalidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        btnNacionalidad1.setToolTipText("Gestionar Ciudad");
        btnNacionalidad1.setBorderPainted(false);
        btnNacionalidad1.setContentAreaFilled(false);
        btnNacionalidad1.setEnabled(false);
        btnNacionalidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNacionalidad1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setText("FECHA DE NACIM.");

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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
    dcFecha.setFieldFont(new java.awt.Font("Roboto Black", java.awt.Font.BOLD, 15));
    dcFecha.setNavigateFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 11));
    dcFecha.setShowOneMonth(true);
    dcFecha.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dcFechaOnCommit(evt);
        }
    });

    javax.swing.GroupLayout pnDatosLayout = new javax.swing.GroupLayout(pnDatos);
    pnDatos.setLayout(pnDatosLayout);
    pnDatosLayout.setHorizontalGroup(
        pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnDatosLayout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBarrio)
                            .addGroup(pnDatosLayout.createSequentialGroup()
                                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDatosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtRazonS)
                                    .addGroup(pnDatosLayout.createSequentialGroup()
                                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnDatosLayout.createSequentialGroup()
                                                .addComponent(lblCodC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbotipopersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(288, 288, 288))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(cboNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNacionalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnDatosLayout.createSequentialGroup()
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(187, 187, 187))
    );
    pnDatosLayout.setVerticalGroup(
        pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createSequentialGroup()
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatosLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(lblCodC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtRuc, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipopersona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnNacionalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(8, 8, 8)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(47, Short.MAX_VALUE))
    );

    btnCiudad.getAccessibleContext().setAccessibleDescription("");

    contenedor.addTab("INFORMACIÓN GENERAL", new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_info_black_24.png")), pnDatos); // NOI18N

    pnDistribucion.setBackground(new java.awt.Color(255, 255, 255));

    jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(17, 35, 46));
    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel15.setText("APLICAR DÍAS DE VISITAS");
    jLabel15.setToolTipText("");
    jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

    ckLunes.setForeground(new java.awt.Color(0, 0, 0));
    ckLunes.setText("Lunes");
    ckLunes.setColorCheck(new java.awt.Color(0, 102, 102));
    ckLunes.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckLunes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    ckMartes.setForeground(new java.awt.Color(0, 0, 0));
    ckMartes.setText("Martes");
    ckMartes.setColorCheck(new java.awt.Color(0, 102, 102));
    ckMartes.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckMartes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    ckJueves.setForeground(new java.awt.Color(0, 0, 0));
    ckJueves.setText("Jueves");
    ckJueves.setColorCheck(new java.awt.Color(0, 102, 102));
    ckJueves.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckJueves.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    ckMiercoles.setForeground(new java.awt.Color(0, 0, 0));
    ckMiercoles.setText("Miercoles");
    ckMiercoles.setColorCheck(new java.awt.Color(0, 102, 102));
    ckMiercoles.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckMiercoles.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    ckSabado.setForeground(new java.awt.Color(0, 0, 0));
    ckSabado.setText("Sábado");
    ckSabado.setColorCheck(new java.awt.Color(0, 102, 102));
    ckSabado.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckSabado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    ckViernes.setForeground(new java.awt.Color(0, 0, 0));
    ckViernes.setText("Viernes");
    ckViernes.setColorCheck(new java.awt.Color(0, 102, 102));
    ckViernes.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckViernes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    ckDomingo.setForeground(new java.awt.Color(0, 0, 0));
    ckDomingo.setText("Domingo");
    ckDomingo.setColorCheck(new java.awt.Color(0, 102, 102));
    ckDomingo.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckDomingo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jLabel16.setText("TIPO DE VENTA HABILITADO");

    rSCheckBox7.setForeground(new java.awt.Color(17, 35, 46));
    rSCheckBox7.setText("CONTADO");
    rSCheckBox7.setColorCheck(new java.awt.Color(0, 102, 0));
    rSCheckBox7.setColorUnCheck(new java.awt.Color(17, 35, 46));
    rSCheckBox7.setEnabled(false);
    rSCheckBox7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    rSCheckBox9.setForeground(new java.awt.Color(17, 35, 46));
    rSCheckBox9.setText("CRÉDITO");
    rSCheckBox9.setColorCheck(new java.awt.Color(0, 102, 0));
    rSCheckBox9.setColorUnCheck(new java.awt.Color(17, 35, 46));
    rSCheckBox9.setEnabled(false);
    rSCheckBox9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    jTextField2.setEditable(false);
    jTextField2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jTextField2.setText("0");

    jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jLabel17.setText("MONTO ACREDITADO:");

    ckSupermercado.setForeground(new java.awt.Color(0, 0, 0));
    ckSupermercado.setText("VENDER SOLO CON PRECIO DE SUPERMERCADO");
    ckSupermercado.setColorCheck(new java.awt.Color(0, 102, 102));
    ckSupermercado.setColorUnCheck(new java.awt.Color(0, 153, 153));
    ckSupermercado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

    javax.swing.GroupLayout pnDistribucionLayout = new javax.swing.GroupLayout(pnDistribucion);
    pnDistribucion.setLayout(pnDistribucionLayout);
    pnDistribucionLayout.setHorizontalGroup(
        pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnDistribucionLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jSeparator2)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDistribucionLayout.createSequentialGroup()
                    .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnDistribucionLayout.createSequentialGroup()
                            .addGap(0, 43, Short.MAX_VALUE)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rSCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rSCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnDistribucionLayout.createSequentialGroup()
                            .addComponent(ckSupermercado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDistribucionLayout.createSequentialGroup()
                                    .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ckMartes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ckLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ckJueves, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ckMiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ckSabado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(ckViernes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ckDomingo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(23, 23, 23))
                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))
            .addContainerGap())
    );
    pnDistribucionLayout.setVerticalGroup(
        pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnDistribucionLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ckSupermercado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDistribucionLayout.createSequentialGroup()
                        .addComponent(ckLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckMartes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDistribucionLayout.createSequentialGroup()
                        .addComponent(ckMiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckJueves, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ckDomingo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDistribucionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ckSabado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ckViernes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(2, 2, 2)
            .addGroup(pnDistribucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rSCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rSCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(252, Short.MAX_VALUE))
    );

    contenedor.addTab("INFORMACIÓN DE DISTRIBUCIÓN", new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_calendar_black_24.png")), pnDistribucion); // NOI18N

    pnObservacion.setBackground(new java.awt.Color(255, 255, 255));
    pnObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    jLabel3.setText("Grados decimales (DD):");

    jTextField1.setEditable(false);
    jTextField1.setText("-25.467164, -56.445958");
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField1ActionPerformed(evt);
        }
    });

    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gmap.png"))); // NOI18N

    javax.swing.GroupLayout pnObservacionLayout = new javax.swing.GroupLayout(pnObservacion);
    pnObservacion.setLayout(pnObservacionLayout);
    pnObservacionLayout.setHorizontalGroup(
        pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnObservacionLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addGroup(pnObservacionLayout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    pnObservacionLayout.setVerticalGroup(
        pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnObservacionLayout.createSequentialGroup()
            .addGroup(pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
    );

    contenedor.addTab("GEOLOCALIZACIÓN", new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_person_pin_black_24.png")), pnObservacion); // NOI18N

    Blanco.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 76, -1, -1));

    panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
    panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));
    panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
    panelImage1.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 0, 20, 20));

    jPanel5.setOpaque(false);
    jPanel5.setLayout(new java.awt.GridLayout(1, 9));

    btnNuevo.setBackground(new java.awt.Color(0, 102, 102));
    btnNuevo.setBorder(null);
    btnNuevo.setText("NUEVO");
    btnNuevo.setToolTipText("CREAR UN NUEVO CLIENTE");
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
    jPanel5.add(btnNuevo);

    btnModificar.setBackground(new java.awt.Color(0, 102, 102));
    btnModificar.setBorder(null);
    btnModificar.setText("MODIFICAR");
    btnModificar.setToolTipText("GUARDAR MODIFICACIÓN APLICADO");
    btnModificar.setBgHover(new java.awt.Color(0, 153, 153));
    btnModificar.setEnabled(false);
    btnModificar.setFocusPainted(false);
    btnModificar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
    btnModificar.setIconTextGap(0);
    btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
    btnModificar.setPixels(0);
    btnModificar.setSizeIcon(40.0F);
    btnModificar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnModificarActionPerformed(evt);
        }
    });
    jPanel5.add(btnModificar);

    btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
    btnGuardar.setBorder(null);
    btnGuardar.setText("GUARDAR");
    btnGuardar.setToolTipText("GUARDAR EL NUEVO CLIENTE");
    btnGuardar.setBgHover(new java.awt.Color(0, 153, 153));
    btnGuardar.setEnabled(false);
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
    jPanel5.add(btnGuardar);

    btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
    btnCancelar.setBorder(null);
    btnCancelar.setText("CANCELAR");
    btnCancelar.setToolTipText("DEJAR SIN EFECTO LOS CAMBIOS");
    btnCancelar.setBgHover(new java.awt.Color(0, 153, 153));
    btnCancelar.setEnabled(false);
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
    jPanel5.add(btnCancelar);

    panelImage1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 260, 56));
    panelImage1.add(txtFechaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 52, 86, -1));

    Blanco.add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 842, 75));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnDatosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnDatosFocusGained
        // TODO add your handling code here:
        txtRazonS.requestFocus();
    }//GEN-LAST:event_pnDatosFocusGained

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 15;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtTelefono.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        cbCiudad.requestFocus();
        cbCiudad.setPopupVisible(true);
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 11;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtRuc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        // TODO add your handling code here:
        dlgCiudadMovil ciumov = new dlgCiudadMovil(null, true);
        ciumov.setLocationRelativeTo(null);
        ciumov.setVisible(true);
    }//GEN-LAST:event_btnCiudadActionPerformed

    private void cbCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCiudadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!btnGuardar.isEnabled()) {
                btnModificar.doClick();
            } else {
                btnGuardar.doClick();
            }
        }
    }//GEN-LAST:event_cbCiudadKeyPressed

    private void cbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiudadActionPerformed
        // TODO add your handling code here:
        try {
            String id = cargarComboBoxMovil.getCodidgo(cbCiudad);
            lbCiudad.setText(id);
        } catch (Exception e) {
            lbCiudad.setText("");
        }

    }//GEN-LAST:event_cbCiudadActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 50;
        if (txtDireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 49);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
       /* int limite = 199;
        if (txtRazonS.getText().length() == limite) {
            evt.consume();
        }*/
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        //validarCampos.soloLetras(txtRazonS);
        validarCampos.cantCaracteres(txtRazonS, 100);
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
        txtRuc.requestFocus();
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void cbCiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCiudadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCiudadKeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarrioActionPerformed

    private void txtBarrioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrioKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtBarrio, 49);
    }//GEN-LAST:event_txtBarrioKeyPressed

    private void txtBarrioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 50;
        if (txtBarrio.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBarrioKeyTyped

    private void cboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSexoActionPerformed

    private void cboSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboSexoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSexoKeyPressed

    private void cboSexoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboSexoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSexoKeyReleased

    private void btnNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNacionalidadActionPerformed

    private void cbotipopersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipopersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipopersonaActionPerformed

    private void cbotipopersonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbotipopersonaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipopersonaKeyPressed

    private void cbotipopersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbotipopersonaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipopersonaKeyReleased

    private void cboNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNacionalidadActionPerformed

    private void cboNacionalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboNacionalidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNacionalidadKeyPressed

    private void cboNacionalidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboNacionalidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNacionalidadKeyReleased

    private void btnNacionalidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNacionalidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNacionalidad1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        cargarComboBoxMovil.cargarCiudad(cbCiudad, "SELECT * FROM ciudad WHERE estado='S'");
        String cod = GestionarCliente.getCodigo();
        lblCodC.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnCiudad.setEnabled(true);
        txtRazonS.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        cbCiudad.setEnabled(true);
        contenedor.setSelectedIndex(0);
        txtRazonS.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (lblCodC.getText().isEmpty()) {
            Mensajes.error("El cliente no posee ID identificatorio.");
        } else if (txtRuc.getText().isEmpty()) {
            Mensajes.error("Debe de registrar obligatoriamente el RUC del cliente.");
            txtRuc.requestFocus();
        } else if (txtRazonS.getText().isEmpty()) {
            Mensajes.error("Debe de registrar obligatoriamente el Nombre completo o la Razón Social del cliente.");
            txtRazonS.requestFocus();
        } else if (txtFecha.getText().isEmpty()) {
            Mensajes.error("Debe de registrar la fecha de nacimiento del cliente.");
            dcFecha.requestFocus();
        } else if (txtDireccion.getText().isEmpty()) {
            Mensajes.error("Debe de registrar la dirección del cliente.");
            txtDireccion.requestFocus();
        } else if (txtBarrio.getText().isEmpty()) {
            Mensajes.error("Debe de registrar el barrio del cliente.");
            txtBarrio.requestFocus();
        } else if (lbCiudad.getText().isEmpty()) {
            Mensajes.informacion("Seleccione una ciudad");
            cbCiudad.requestFocus();
            cbCiudad.setPopupVisible(true);
        }else if(txtTelefono.getText().isEmpty()){
            Mensajes.error("Debe de registrar el número telefonico o de celular del cliente.");
        }else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlCliente.actCliente();
                    actualizartablaClientes();
                    this.dispose();
                }
            } catch (Exception ee) {
            } 
        }
                
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (lblCodC.getText().isEmpty()) {
            Mensajes.error("El cliente no posee ID identificatorio.");
        } else if (txtRuc.getText().isEmpty()) {
            Mensajes.error("Debe de registrar obligatoriamente el RUC del cliente.");
            txtRuc.requestFocus();
        } else if (txtRazonS.getText().isEmpty()) {
            Mensajes.error("Debe de registrar obligatoriamente el Nombre completo o la Razón Social del cliente.");
            txtRazonS.requestFocus();
        } else if (txtFecha.getText().isEmpty()) {
            Mensajes.error("Debe de registrar la fecha de nacimiento del cliente.");
            dcFecha.requestFocus();
        } else if (txtDireccion.getText().isEmpty()) {
            Mensajes.error("Debe de registrar la dirección del cliente.");
            txtDireccion.requestFocus();
        } else if (txtBarrio.getText().isEmpty()) {
            Mensajes.error("Debe de registrar el barrio del cliente.");
            txtBarrio.requestFocus();
        } else if (lbCiudad.getText().isEmpty()) {
            Mensajes.informacion("Seleccione una ciudad");
            cbCiudad.requestFocus();
            cbCiudad.setPopupVisible(true);
        }else if(txtTelefono.getText().isEmpty()){
            Mensajes.error("Debe de registrar el número telefonico o de celular del cliente.");
        }else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    lblCodC.setText(GestionarCliente.getCodigo());
                    controlCliente.addCliente();
                    actualizartablaClientes();
                    btnCancelarActionPerformed(null);
                }

            } catch (HeadlessException ee) {
            }
        }
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCiudad.setEnabled(false);
        txtRazonS.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        cbCiudad.setEnabled(false);
        txtRuc.setEnabled(false);
        btnNuevo.requestFocus();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        String fe = dcFecha.getText();
        txtFecha.setText(Fecha.formatoFechaVM(fe));
        txtFechaR.setText(Fecha.formatoFechaVMR(fe));
    }//GEN-LAST:event_dcFechaOnCommit

    void limpiarCampos() {
        lblCodC.setText("");
        lbCiudad.setText("");
        txtRazonS.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        cbCiudad.list();
    }

    void actualizartablaClientes() {
        CabecerasTablas cabe = new CabecerasTablas();
        cabe.cliente(dlgClientes.tablaClientes);
        CabecerasTablas.limpiarTablas(dlgClientes.tablaClientes);
        controlCliente.listClientes(dlgClientes.tablaClientes);
    }

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgGestClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestClientes dialog = new dlgGestClientes(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    private javax.swing.JButton btnCiudad;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    private javax.swing.JButton btnNacionalidad;
    private javax.swing.JButton btnNacionalidad1;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static javax.swing.JComboBox cbCiudad;
    public static javax.swing.JComboBox cboNacionalidad;
    public static javax.swing.JComboBox cboSexo;
    public static javax.swing.JComboBox cbotipopersona;
    public static rojerusan.RSCheckBox ckDomingo;
    public static rojerusan.RSCheckBox ckJueves;
    public static rojerusan.RSCheckBox ckLunes;
    public static rojerusan.RSCheckBox ckMartes;
    public static rojerusan.RSCheckBox ckMiercoles;
    public static rojerusan.RSCheckBox ckSabado;
    public static rojerusan.RSCheckBox ckSupermercado;
    public static rojerusan.RSCheckBox ckViernes;
    private javax.swing.JTabbedPane contenedor;
    public static datechooser.beans.DateChooserCombo dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JLabel lbCiudad;
    public static javax.swing.JLabel lblCodC;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JPanel pnDatos;
    private javax.swing.JPanel pnDistribucion;
    private javax.swing.JPanel pnObservacion;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    private rojerusan.RSCheckBox rSCheckBox7;
    private rojerusan.RSCheckBox rSCheckBox9;
    public static javax.swing.JTextField txtBarrio;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtFechaR;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
