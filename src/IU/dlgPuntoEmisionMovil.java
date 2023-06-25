package IU;

import Componentes.Mensajes;
import Componentes.Software;
import static Componentes.URL.urlServer;
import Componentes.cargarComboBoxMovil;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlPuntoEmisionMovil;
import Datos.GestionarPuntoEmisionMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public class dlgPuntoEmisionMovil extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgPuntoEmisionMovil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboBoxMovil.cargarCboTimbrado(cboTimbrado, "SELECT * FROM timbrado WHERE estado='Activo'");
        titulo();
        cabe.PuntoEmision(tbPuntoEmision);
        controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar Punto de Emisión");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar Punto de Emisión");
        }
    }

    public void Cancelar() {
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        tbPuntoEmision.setVisible(true);
        //
        cboTimbrado.setEnabled(false);
        txtEstablecimiento.setEnabled(false);
        txtEmision.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtFInicio.setEnabled(false);
        txtFFin.setEnabled(false);
        txtFActual.setEnabled(false);
        txtNVenta.setEnabled(false);
        cbAMovil.setEnabled(false);
        rbActivo.setEnabled(false);
        rbInactivo.setEnabled(false);
        cbFinalidad.setEnabled(false);
        txtIP.setEnabled(false);
        limpiarCampos();
        btnNuevo.requestFocus();
    }

    public void modcboTimbrado(String idTimbrado) {
        try {
            HttpClient timbrado = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultComboBoxModel ml = new DefaultComboBoxModel();
                            ml.addElement("SELEC. UNA OPCIÓN");
                            JSONObject jsonTimbrado = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonTimbrado.length(); f++) {
                                ml.addElement(jsonTimbrado.getJSONObject("" + f + "").get("descripcion").toString());

                            }
                            cboTimbrado.setModel(ml);
                            try {
                                try {
                                    URL url = new URL(urlServer() + "getTimbradoEspecifico.php?id=" + idTimbrado);
                                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                    conn.setRequestMethod("GET");
                                    conn.connect();

                                    int ResponseCod = conn.getResponseCode();

                                    if (ResponseCod != 200) {
                                        throw new RuntimeException("Ocurrio un error: " + ResponseCod);
                                    } else {
                                        StringBuilder timbrado = new StringBuilder();
                                        Scanner scan = new Scanner(url.openStream());
                                        while (scan.hasNext()) {
                                            timbrado.append(scan.nextLine());
                                        }
                                        scan.close();
                                        JSONObject json = new JSONObject(timbrado.toString());
                                        for (int f = 0; f < json.length(); f++) {
                                            Object descripcion = json.getJSONObject("" + f + "").get("descripcion").toString();
                                            lbFechaTimbrado.setText("VALIDEZ: " + json.getJSONObject("" + f + "").get("fechadesde").toString() + " - " + json.getJSONObject("" + f + "").get("fechahasta").toString());
                                            //cboTimbrado.setModel(ml);
                                            cboTimbrado.setSelectedItem(descripcion);
                                            txtEstablecimiento.requestFocus();
                                        }
                                    }
                                } catch (IOException | RuntimeException e) {
                                    //System.out.println(e.getMessage());
                                }
                            } catch (Exception f) {
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            });
            timbrado.excecute(urlServer() + "getTimbradoActivo.php");
        } catch (Exception e) {
            System.out.println("err_modTimb: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupActivo = new javax.swing.ButtonGroup();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTimbrado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtEstablecimiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmision = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFInicio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFFin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFActual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNVenta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cbAMovil = new javax.swing.JCheckBox();
        txtIP = new javax.swing.JTextField();
        rbActivo = new javax.swing.JRadioButton();
        rbInactivo = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        lbFechaTimbrado = new javax.swing.JLabel();
        cbFinalidad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPuntoEmision = new javax.swing.JTable()
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

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 9));

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
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(0, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("MODIFICAR");
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
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });
        jPanel1.add(btnModificar);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("GUARDAR");
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
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel1.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setBorder(null);
        btnCancelar.setText("CANCELAR");
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
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBgHover(new java.awt.Color(0, 153, 153));
        btnEliminar.setEnabled(false);
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
        jPanel1.add(btnEliminar);

        Oscuro.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 15, 330, 56));

        btnSalir1.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir1.setBorder(null);
        btnSalir1.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir1.setFocusPainted(false);
        btnSalir1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir1.setIconTextGap(0);
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.setPixels(0);
        btnSalir1.setSizeIcon(20.0F);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 20, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 18, 21, -1));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 12, 39, 25));

        jLabel2.setText("Timbrado");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 18, -1, -1));

        cboTimbrado.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cboTimbrado.setEnabled(false);
        cboTimbrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimbradoActionPerformed(evt);
            }
        });
        cboTimbrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboTimbradoKeyPressed(evt);
            }
        });
        jPanel2.add(cboTimbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 12, 171, -1));

        jLabel6.setText("Establecimiento");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 69, -1, -1));

        txtEstablecimiento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEstablecimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstablecimiento.setEnabled(false);
        txtEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstablecimientoActionPerformed(evt);
            }
        });
        txtEstablecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstablecimientoKeyPressed(evt);
            }
        });
        jPanel2.add(txtEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 65, 70, -1));

        jLabel7.setText("P. Emisión");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 69, -1, -1));

        txtEmision.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEmision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmision.setEnabled(false);
        txtEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmisionActionPerformed(evt);
            }
        });
        txtEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmisionKeyPressed(evt);
            }
        });
        jPanel2.add(txtEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 65, 70, -1));

        jLabel8.setText("Dirección");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 96, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setEnabled(false);
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
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 92, 230, -1));

        jLabel9.setText("Inicio");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 123, -1, -1));

        txtFInicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFInicio.setEnabled(false);
        txtFInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFInicioActionPerformed(evt);
            }
        });
        txtFInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFInicioKeyPressed(evt);
            }
        });
        jPanel2.add(txtFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 119, 70, -1));

        jLabel10.setText("Fin");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 123, -1, -1));

        txtFFin.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFFin.setEnabled(false);
        txtFFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFFinActionPerformed(evt);
            }
        });
        txtFFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFFinKeyPressed(evt);
            }
        });
        jPanel2.add(txtFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 119, 70, -1));

        jLabel11.setText("Actual");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 150, -1, -1));

        txtFActual.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFActual.setEnabled(false);
        txtFActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFActualActionPerformed(evt);
            }
        });
        txtFActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFActualKeyPressed(evt);
            }
        });
        jPanel2.add(txtFActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 146, 70, -1));

        jLabel12.setText("N° Operación");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        txtNVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNVenta.setEnabled(false);
        txtNVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNVentaActionPerformed(evt);
            }
        });
        txtNVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNVentaKeyPressed(evt);
            }
        });
        jPanel2.add(txtNVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 146, 70, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setOpaque(false);

        cbAMovil.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        cbAMovil.setSelected(true);
        cbAMovil.setText("Aplicación Móvil");
        cbAMovil.setEnabled(false);
        cbAMovil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cbAMovil.setIconTextGap(6);
        cbAMovil.setOpaque(false);
        cbAMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAMovilActionPerformed(evt);
            }
        });

        txtIP.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIP.setEnabled(false);
        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIPKeyPressed(evt);
            }
        });

        grupActivo.add(rbActivo);
        rbActivo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rbActivo.setText("P. Emisión Activo");
        rbActivo.setEnabled(false);
        rbActivo.setIconTextGap(6);
        rbActivo.setOpaque(false);
        rbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActivoActionPerformed(evt);
            }
        });

        grupActivo.add(rbInactivo);
        rbInactivo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rbInactivo.setSelected(true);
        rbInactivo.setText("P. Emisión Inactivo");
        rbInactivo.setEnabled(false);
        rbInactivo.setIconTextGap(6);
        rbInactivo.setOpaque(false);
        rbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInactivoActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("IP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(rbActivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbInactivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbAMovil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIP)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbAMovil)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 12, 150, 128));

        lbFechaTimbrado.setBackground(new java.awt.Color(0, 102, 102));
        lbFechaTimbrado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbFechaTimbrado.setForeground(new java.awt.Color(255, 255, 255));
        lbFechaTimbrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaTimbrado.setOpaque(true);
        jPanel2.add(lbFechaTimbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 43, 318, 16));

        cbFinalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELEC. UNA FINALIDAD", "FACTURA", "NOTA DE CRÉDITO", "RECIBO DE DINERO" }));
        cbFinalidad.setEnabled(false);
        jPanel2.add(cbFinalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 147, 150, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbPuntoEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbPuntoEmision.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        tbPuntoEmision.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPuntoEmision.setGridColor(new java.awt.Color(204, 204, 204));
        tbPuntoEmision.setRowHeight(18);
        tbPuntoEmision.setShowVerticalLines(false);
        tbPuntoEmision.getTableHeader().setResizingAllowed(false);
        tbPuntoEmision.getTableHeader().setReorderingAllowed(false);
        tbPuntoEmision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPuntoEmisionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPuntoEmision);

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPuntoEmisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPuntoEmisionMouseClicked
        // TODO add your handling code here:
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        tbPuntoEmision.setVisible(true);
        //
        cboTimbrado.setEnabled(false);
        txtEstablecimiento.setEnabled(true);
        txtEmision.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtFInicio.setEnabled(true);
        txtFFin.setEnabled(true);
        txtFActual.setEnabled(true);
        txtNVenta.setEnabled(true);
        cbAMovil.setEnabled(true);
        rbActivo.setEnabled(true);
        rbInactivo.setEnabled(true);
        cbFinalidad.setEnabled(true);

        int fila = tbPuntoEmision.getSelectedRow();
        String cod = tbPuntoEmision.getValueAt(fila, 0).toString();
        String itTimbrado = tbPuntoEmision.getValueAt(fila, 1).toString();
        String establecimiento = tbPuntoEmision.getValueAt(fila, 3).toString();
        String puntoEmision = tbPuntoEmision.getValueAt(fila, 4).toString();
        String direccion = tbPuntoEmision.getValueAt(fila, 5).toString();
        String fi = tbPuntoEmision.getValueAt(fila, 6).toString();
        String ff = tbPuntoEmision.getValueAt(fila, 7).toString();
        String fa = tbPuntoEmision.getValueAt(fila, 8).toString();
        String nv = tbPuntoEmision.getValueAt(fila, 9).toString();
        String tipo = tbPuntoEmision.getValueAt(fila, 10).toString();
        String finalidad = tbPuntoEmision.getValueAt(fila, 11).toString();
        String ip = tbPuntoEmision.getValueAt(fila, 12).toString();
        String estado = tbPuntoEmision.getValueAt(fila, 13).toString();

        txtCod.setText(cod);
        modcboTimbrado(itTimbrado);
        txtEstablecimiento.setText(establecimiento);
        txtEmision.setText(puntoEmision);
        txtDireccion.setText(direccion);
        txtFInicio.setText(fi);
        txtFFin.setText(ff);
        txtFActual.setText(fa);
        txtNVenta.setText(nv);
        if (tipo.equals("M")) {
            cbAMovil.setSelected(true);
            cbAMovilActionPerformed(null);
        } else {
            cbAMovil.setSelected(false);
            txtIP.setEnabled(true);
        }
        if (finalidad.equals("F")) {
            cbFinalidad.setSelectedIndex(1);
        } else if (finalidad.equals("NC")) {
            cbFinalidad.setSelectedIndex(2);
        }else if(finalidad.equals("RD")){
            cbFinalidad.setSelectedIndex(3);
        }
        txtIP.setText(ip);
        if (estado.equals("Inactivo")) {
            rbInactivo.setSelected(true);
        } else {
            rbActivo.setSelected(true);
        }
        txtEstablecimiento.requestFocus();
    }//GEN-LAST:event_tbPuntoEmisionMouseClicked

    private void txtFInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFInicioActionPerformed
        // TODO add your handling code here:
        txtFFin.requestFocus();
    }//GEN-LAST:event_txtFInicioActionPerformed

    private void txtEmisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmisionKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtEmision);
        validarCampos.cantCaracteres(txtEmision, 3);
    }//GEN-LAST:event_txtEmisionKeyPressed

    private void txtEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmisionActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtEmisionActionPerformed

    private void txtEstablecimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstablecimientoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtEstablecimiento);
        validarCampos.cantCaracteres(txtEstablecimiento, 3);
    }//GEN-LAST:event_txtEstablecimientoKeyPressed

    private void txtEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstablecimientoActionPerformed
        // TODO add your handling code here:
        txtEmision.requestFocus();
    }//GEN-LAST:event_txtEstablecimientoActionPerformed

    private void cboTimbradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTimbradoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cboTimbrado.getSelectedIndex() == 0) {
                lbFechaTimbrado.setText("");
            } else {
                int idT;
                idT = Integer.parseInt(cargarComboBoxMovil.getCodidgo(cboTimbrado));
                try {
                    try {
                        URL url = new URL(urlServer() + "getTimbradoEspecifico.php?id=" + idT);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.connect();

                        int ResponseCod = conn.getResponseCode();

                        if (ResponseCod != 200) {
                            throw new RuntimeException("Ocurrio un error: " + ResponseCod);
                        } else {
                            StringBuilder timbrado = new StringBuilder();
                            Scanner scan = new Scanner(url.openStream());
                            while (scan.hasNext()) {
                                timbrado.append(scan.nextLine());
                            }
                            scan.close();
                            JSONObject json = new JSONObject(timbrado.toString());
                            for (int f = 0; f < json.length(); f++) {
                                lbFechaTimbrado.setText("VALIDEZ: " + json.getJSONObject("" + f + "").get("fechadesde").toString() + " - " + json.getJSONObject("" + f + "").get("fechahasta").toString());
                                txtEstablecimiento.requestFocus();
                            }
                        }
                    } catch (IOException | RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (Exception f) {
                }
                txtEstablecimiento.requestFocus();
            }

        }
    }//GEN-LAST:event_cboTimbradoKeyPressed

    private void cboTimbradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimbradoActionPerformed
        // TODO add your handling code here:
        if (cboTimbrado.getSelectedIndex() == 0) {
            lbFechaTimbrado.setText("");
        } else {
            int idT;
            idT = Integer.parseInt(cargarComboBoxMovil.getCodidgo(cboTimbrado));
            try {
                try {
                    URL url = new URL(urlServer() + "getTimbradoEspecifico.php?id=" + idT);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();

                    int ResponseCod = conn.getResponseCode();

                    if (ResponseCod != 200) {
                        throw new RuntimeException("Ocurrio un error: " + ResponseCod);
                    } else {
                        StringBuilder timbrado = new StringBuilder();
                        Scanner scan = new Scanner(url.openStream());
                        while (scan.hasNext()) {
                            timbrado.append(scan.nextLine());
                        }
                        scan.close();
                        JSONObject json = new JSONObject(timbrado.toString());
                        for (int f = 0; f < json.length(); f++) {
                            lbFechaTimbrado.setText("VALIDEZ: " + json.getJSONObject("" + f + "").get("fechadesde").toString() + " - " + json.getJSONObject("" + f + "").get("fechahasta").toString());
                            txtEstablecimiento.requestFocus();
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception f) {
            }
            txtEstablecimiento.requestFocus();
        }

    }//GEN-LAST:event_cboTimbradoActionPerformed

    private void rbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbInactivoActionPerformed

    private void rbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbActivoActionPerformed

    private void cbAMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAMovilActionPerformed
        // TODO add your handling code here:
        if (cbAMovil.isSelected()) {
            txtIP.setEnabled(false);
        } else {
            txtIP.setEnabled(true);
            txtIP.requestFocus();
            rbActivo.doClick();
        }
    }//GEN-LAST:event_cbAMovilActionPerformed

    private void txtIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtIP);
        validarCampos.cantCaracteres(txtIP, 16);
    }//GEN-LAST:event_txtIPKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 20);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtFInicio.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtFInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFInicioKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFInicio);
        validarCampos.cantCaracteres(txtFInicio, 3);
    }//GEN-LAST:event_txtFInicioKeyPressed

    private void txtFFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFFinActionPerformed
        // TODO add your handling code here:
        txtFActual.requestFocus();
    }//GEN-LAST:event_txtFFinActionPerformed

    private void txtFFinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFFinKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFFin);
        validarCampos.cantCaracteres(txtFFin, 6);
    }//GEN-LAST:event_txtFFinKeyPressed

    private void txtFActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFActualActionPerformed
        // TODO add your handling code here:
        txtNVenta.requestFocus();
    }//GEN-LAST:event_txtFActualActionPerformed

    private void txtFActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFActualKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFActual);
        validarCampos.cantCaracteres(txtFActual, 6);
    }//GEN-LAST:event_txtFActualKeyPressed

    private void txtNVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNVentaActionPerformed
        // TODO add your handling code here:
        cbAMovil.requestFocus();
    }//GEN-LAST:event_txtNVentaActionPerformed

    private void txtNVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNVentaKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtNVenta);
        validarCampos.cantCaracteres(txtNVenta, 6);
    }//GEN-LAST:event_txtNVentaKeyPressed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarPuntoEmisionMovil.getCodigo();
        cargarComboBoxMovil.cargarCboTimbrado(cboTimbrado, "SELECT * FROM timbrado WHERE estado='Activo'");
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        tbPuntoEmision.setVisible(false);
        //
        cboTimbrado.setEnabled(true);
        txtEstablecimiento.setEnabled(true);
        txtEmision.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtFInicio.setEnabled(true);
        txtFFin.setEnabled(true);
        txtFActual.setEnabled(true);
        txtNVenta.setEnabled(true);
        cbAMovil.setEnabled(true);
        rbActivo.setEnabled(true);
        rbInactivo.setEnabled(true);
        cbFinalidad.setEnabled(true);
        //
        CabecerasTablas.limpiarTablas(tbPuntoEmision);
        controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
        cboTimbrado.requestFocus();
        cboTimbrado.setPopupVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                String msg = controlPuntoEmisionMovil.actPuntoEmision();
                if (msg.equals("OK")) {
                    String msg1 = controlPuntoEmisionMovil.actRef();
                    if (msg1.equals("OK")) {
                        CabecerasTablas.limpiarTablas(tbPuntoEmision);
                        controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                        Cancelar();
                    }
                }                
            }
        } catch (HeadlessException ee) {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (cboTimbrado.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Timbrado");
            cboTimbrado.requestFocus();
            cboTimbrado.setPopupVisible(true);
        } else if (txtEstablecimiento.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese el Establecimiento");
            txtEstablecimiento.requestFocus();
        } else if (txtEmision.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese el Punto de Emisión");
            txtEmision.requestFocus();
        } else if (txtDireccion.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese la Dirección");
            txtDireccion.requestFocus();
        } else if (txtFInicio.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número para el inicio de las facturaciones");
            txtFInicio.requestFocus();
        } else if (txtFFin.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número para la finalización de las facturaciones");
            txtFFin.requestFocus();
        } else if (txtFActual.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número actual de la facturación");
            txtFActual.requestFocus();
        } else if (txtNVenta.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número de venta actual - Infomación requerido para la Aplicación Fact-Express");
            txtNVenta.requestFocus();
        } else if (cbFinalidad.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Finalidad");
            cbFinalidad.requestFocus();
            cbFinalidad.setPopupVisible(true);
        } else if (!cbAMovil.isSelected()) {
            if (txtIP.getText().trim().isEmpty()) {
                Mensajes.informacion("Ingrese la dirección IP de la terminar que utilizara este Punto de Emisión");
                txtIP.requestFocus();
            } else {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        String cod = GestionarPuntoEmisionMovil.getCodigo();
                        txtCod.setText(cod);
                        String msg;
                        msg = controlPuntoEmisionMovil.addPuntoEmision();
                        if (msg.equals("OK")) {
                            String msg1;
                            msg1 = controlPuntoEmisionMovil.addRef();
                            if (msg1.equals("OK")) {
                                CabecerasTablas.limpiarTablas(tbPuntoEmision);
                                controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                                Cancelar();
                            }
                        }
                    }
                } catch (HeadlessException ee) {
                }
            }
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarPuntoEmisionMovil.getCodigo();
                    txtCod.setText(cod);
                    controlPuntoEmisionMovil.addPuntoEmision();
                    controlPuntoEmisionMovil.addRef();
                    CabecerasTablas.limpiarTablas(tbPuntoEmision);
                    controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar?");
        if (rpta == 0) {
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tbPuntoEmision.setVisible(true);
            //
            cboTimbrado.setEnabled(false);
            txtEstablecimiento.setEnabled(false);
            txtEmision.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtFInicio.setEnabled(false);
            txtFFin.setEnabled(false);
            txtFActual.setEnabled(false);
            txtNVenta.setEnabled(false);
            cbAMovil.setEnabled(false);
            rbActivo.setEnabled(false);
            rbInactivo.setEnabled(false);
            cbFinalidad.setEnabled(false);
            txtIP.setEnabled(false);
            limpiarCampos();
            btnNuevo.requestFocus();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                controlPuntoEmisionMovil.delPuntoEmision();
                CabecerasTablas.limpiarTablas(tbPuntoEmision);
                controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                Cancelar();
            }
        } catch (HeadlessException ee) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    void limpiarCampos() {
        txtCod.setText("");
        cboTimbrado.setSelectedIndex(0);
        cbFinalidad.setSelectedIndex(0);
        lbFechaTimbrado.setText("");
        txtEstablecimiento.setText("");
        txtEmision.setText("");
        txtDireccion.setText("");
        txtFInicio.setText("");
        txtFFin.setText("");
        txtFActual.setText("");
        txtNVenta.setText("");
        txtIP.setText("");
        cbAMovil.setSelected(true);
        rbInactivo.setSelected(true);
        tbPuntoEmision.clearSelection();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(dlgPuntoEmisionMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            dlgPuntoEmisionMovil dialog = new dlgPuntoEmisionMovil(new javax.swing.JFrame(), true);
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
    private newscomponents.RSButtonBigIcon_new btnCancelar;
    private newscomponents.RSButtonBigIcon_new btnEliminar;
    private newscomponents.RSButtonBigIcon_new btnGuardar;
    private newscomponents.RSButtonBigIcon_new btnModificar;
    private newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    public static javax.swing.JCheckBox cbAMovil;
    public static javax.swing.JComboBox<String> cbFinalidad;
    public static javax.swing.JComboBox<String> cboTimbrado;
    private javax.swing.ButtonGroup grupActivo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbFechaTimbrado;
    public static javax.swing.JRadioButton rbActivo;
    public static javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTable tbPuntoEmision;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtEmision;
    public static javax.swing.JTextField txtEstablecimiento;
    public static javax.swing.JTextField txtFActual;
    public static javax.swing.JTextField txtFFin;
    public static javax.swing.JTextField txtFInicio;
    public static javax.swing.JTextField txtIP;
    public static javax.swing.JTextField txtNVenta;
    // End of variables declaration//GEN-END:variables
}
