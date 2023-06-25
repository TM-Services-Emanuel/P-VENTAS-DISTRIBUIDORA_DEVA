package IU;

import Componentes.Mensajes;
import Componentes.Software;
import static Componentes.URL.urlServer;
import Componentes.cargarComboBoxMovil;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlArticuloMovil;
import Datos.GestionarArticulosMovil;
import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public class dlgGestArticulosMovil extends javax.swing.JDialog {

    public dlgGestArticulosMovil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        Invisible();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Crear o modificar Productos");
        } else {
            this.setTitle(Software.getSoftware() + " - Crear o modificar Productos");
        }
    }

    private void CargarCombos() {
        cargarComboBoxMovil.cargarCboClasificacion(cboClasificacion, "SELECT * FROM division WHERE estado='S'");
        cargarComboBoxMovil.cargarCboUM(cboUM, "SELECT * FROM unidad_medida WHERE estado='S'");
        cargarComboBoxMovil.cargarCboImpuesto(cboImpuesto, "SELECT idiva, descripcion FROM iva WHERE estado='S'");
    }

    private void Invisible() {
        txtCodUM.setVisible(false);
        txtCodImpuesto.setVisible(false);
        txtCodClasificacion.setVisible(false);
        txtPrecioVentaL.setVisible(false);
        txtPrecioCostoL.setVisible(false);
    }

    private void Habilitacion() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnLaboratorio.setEnabled(true);
        btnProveedor.setEnabled(true);
        btnFamilia.setEnabled(true);
        txtCodInterno.setEnabled(true);
        txtDescripcion.setEnabled(true);
        cboClasificacion.setEnabled(true);
        cboImpuesto.setEnabled(true);
        cboUM.setEnabled(true);
        txtPrecioVentaMayorista.setEnabled(true);
        txtStock.setEnabled(true);
        txtPrecioVentaMinorista.setEnabled(true);
        ckHabilitar.setEnabled(true);
        ckHabilitar.setSelected(false);
    }

    private void Cancelar() {
        limpiarCampos();
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnLaboratorio.setEnabled(false);
        btnProveedor.setEnabled(false);
        btnFamilia.setEnabled(false);
        txtCodInterno.setEnabled(false);
        txtDescripcion.setEnabled(false);
        cboClasificacion.setEnabled(false);
        cboImpuesto.setEnabled(false);
        cboUM.setEnabled(false);
        txtPrecioVentaMayorista.setEnabled(false);
        txtStock.setEnabled(false);
        Volver();
        this.dispose();
    }

    private void calcularGanancia() {
        DecimalFormat df = new DecimalFormat("#,###");
        int costo, ganancia, venta;
        venta = Integer.parseInt(txtPrecioVentaMayorista.getText().trim().replace(",", "").replace(".", ""));
        costo = Integer.parseInt(txtCosto.getText().trim().replace(",", "").replace(".", ""));
        ganancia = venta - costo;
        txtGananciaMayorista.setText(String.valueOf(df.format(ganancia)));
    }

    private void calcularPor() {
        try {
            double costo = Double.parseDouble(txtCosto.getText().trim().replace(",", "").replace(".", ""));
            double ganancia = Double.parseDouble(txtGananciaMayorista.getText().trim().replace(",", "").replace(".", ""));

            double porc = ((ganancia * 100.0) / costo);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            double val2 = bd.doubleValue();

            txtPorcMay.setText(String.valueOf((val2)));
        } catch (NumberFormatException e) {
        }
    }

    private void calcularGananciaMinorista() {
        DecimalFormat df = new DecimalFormat("#,###");
        int costo, ganancia, venta;
        venta = Integer.parseInt(txtPrecioVentaMinorista.getText().trim().replace(",", "").replace(".", ""));
        costo = Integer.parseInt(txtCosto.getText().trim().replace(",", "").replace(".", ""));
        ganancia = venta - costo;
        txtGananciaMinorista.setText(String.valueOf(df.format(ganancia)));
    }

    private void calcularPorMinorista() {
        try {
            double costo = Double.parseDouble(txtCosto.getText().trim().replace(",", "").replace(".", ""));
            double ganancia = Double.parseDouble(txtGananciaMinorista.getText().trim().replace(",", "").replace(".", ""));

            double porc = ((ganancia * 100.0) / costo);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            double val2 = bd.doubleValue();

            txtPorcMin.setText(String.valueOf((val2)));
        } catch (NumberFormatException e) {
        }
    }

    private void calcularGananciaSuper() {
        DecimalFormat df = new DecimalFormat("#,###");
        int costo, ganancia, venta;
        venta = Integer.parseInt(txtPrecioVentaSuper.getText().trim().replace(",", "").replace(".", ""));
        costo = Integer.parseInt(txtCosto.getText().trim().replace(",", "").replace(".", ""));
        ganancia = venta - costo;
        txtGananciaSuper.setText(String.valueOf(df.format(ganancia)));
    }

    private void calcularPorSuper() {
        try {
            double costo = Double.parseDouble(txtCosto.getText().trim().replace(",", "").replace(".", ""));
            double ganancia = Double.parseDouble(txtGananciaSuper.getText().trim().replace(",", "").replace(".", ""));

            double porc = ((ganancia * 100.0) / costo);
            BigDecimal bd = new BigDecimal(porc).setScale(2, RoundingMode.HALF_UP);
            double val2 = bd.doubleValue();

            txtPorcSuper.setText(String.valueOf((val2)));
        } catch (NumberFormatException e) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel25 = new javax.swing.JLabel();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        txtCodClasificacion = new javax.swing.JTextField();
        txtCodUM = new javax.swing.JTextField();
        txtCodImpuesto = new javax.swing.JTextField();
        txtPrecioVentaL = new javax.swing.JTextField();
        txtPrecioCostoL = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtCodProducto = new javax.swing.JTextField();
        txtCodInterno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboClasificacion = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboUM = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cboImpuesto = new javax.swing.JComboBox();
        btnFamilia = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnLaboratorio = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCodBarra = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPrecioVentaMinorista = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtGananciaMinorista = new javax.swing.JTextField();
        txtPorcMin = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtGananciaMayorista = new javax.swing.JTextField();
        txtPorcMay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioVentaMayorista = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtGananciaSuper = new javax.swing.JTextField();
        txtPrecioVentaSuper = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPorcSuper = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        ckHabilitar = new rojerusan.RSCheckBox();
        txtCantM = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(17, 35, 46));
        jLabel25.setText("EN %:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 0, 20, 20));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel4.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(0, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("MODIFICAR");
        btnModificar.setBgHover(new java.awt.Color(0, 153, 153));
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
        jPanel4.add(btnModificar);

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
        jPanel4.add(btnGuardar);

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
        jPanel4.add(btnCancelar);

        Oscuro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 280, 56));
        Oscuro.add(txtCodClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 11, 44, -1));
        Oscuro.add(txtCodUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 11, 44, -1));
        Oscuro.add(txtCodImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 11, 44, -1));

        txtPrecioVentaL.setEditable(false);
        txtPrecioVentaL.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtPrecioVentaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaL.setText("0");
        Oscuro.add(txtPrecioVentaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 37, 43, -1));

        txtPrecioCostoL.setEditable(false);
        txtPrecioCostoL.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtPrecioCostoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioCostoL.setText("0");
        Oscuro.add(txtPrecioCostoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 37, 43, -1));

        jPanel1.setOpaque(false);

        txtCodProducto.setEditable(false);
        txtCodProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtCodProducto.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCodProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtCodInterno.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCodInterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodInterno.setNextFocusableComponent(txtDescripcion);
        txtCodInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodInternoActionPerformed(evt);
            }
        });
        txtCodInterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodInternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodInternoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("ID PRODUCTO");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("CÓDIGO INTERNO");

        txtDescripcion.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("DESCRIPCIÓN DEL PRODUCTO");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("CLASIFICACIÓN");

        cboClasificacion.setBackground(new java.awt.Color(255, 255, 204));
        cboClasificacion.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cboClasificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboClasificacion.setNextFocusableComponent(cboUM);
        cboClasificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboClasificacionItemStateChanged(evt);
            }
        });
        cboClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClasificacionActionPerformed(evt);
            }
        });
        cboClasificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboClasificacionKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("UNIDAD DE MEDIDA");

        cboUM.setBackground(new java.awt.Color(255, 255, 204));
        cboUM.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cboUM.setAutoscrolls(true);
        cboUM.setNextFocusableComponent(cboImpuesto);
        cboUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUMActionPerformed(evt);
            }
        });
        cboUM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboUMKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("IMPUESTO");

        cboImpuesto.setBackground(new java.awt.Color(255, 255, 204));
        cboImpuesto.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cboImpuesto.setNextFocusableComponent(txtCosto);
        cboImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboImpuestoActionPerformed(evt);
            }
        });
        cboImpuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboImpuestoKeyPressed(evt);
            }
        });

        btnFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnFamilia.setToolTipText("Gestionar Familia");
        btnFamilia.setBorderPainted(false);
        btnFamilia.setContentAreaFilled(false);
        btnFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFamiliaActionPerformed(evt);
            }
        });

        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnProveedor.setToolTipText("Gestionar Proveedor");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnLaboratorio.setToolTipText("Gestionar Laboratorio");
        btnLaboratorio.setBorderPainted(false);
        btnLaboratorio.setContentAreaFilled(false);
        btnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboClasificacion, 0, 237, Short.MAX_VALUE)
                            .addComponent(cboUM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("CÓDIGO DE BARRA");

        txtCodBarra.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCodBarra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodBarra.setNextFocusableComponent(txtDescripcion);
        txtCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarraActionPerformed(evt);
            }
        });
        txtCodBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("PRECIO DE COSTO");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtCosto.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(255, 0, 0));
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel22.setText("PRECIO DE VENTA");

        txtPrecioVentaMinorista.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtPrecioVentaMinorista.setForeground(new java.awt.Color(17, 35, 46));
        txtPrecioVentaMinorista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaMinorista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPrecioVentaMinorista.setMinimumSize(new java.awt.Dimension(7, 21));
        txtPrecioVentaMinorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMinoristaMouseClicked(evt);
            }
        });
        txtPrecioVentaMinorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaMinoristaActionPerformed(evt);
            }
        });
        txtPrecioVentaMinorista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMinoristaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMinoristaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMinoristaKeyTyped(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(0, 102, 102));
        jLabel18.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("MINORISTAS");
        jLabel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel18.setOpaque(true);

        txtGananciaMinorista.setEditable(false);
        txtGananciaMinorista.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtGananciaMinorista.setForeground(new java.awt.Color(0, 153, 0));
        txtGananciaMinorista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGananciaMinorista.setBorder(null);
        txtGananciaMinorista.setOpaque(false);
        txtGananciaMinorista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGananciaMinoristaFocusLost(evt);
            }
        });
        txtGananciaMinorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGananciaMinoristaMouseClicked(evt);
            }
        });
        txtGananciaMinorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGananciaMinoristaActionPerformed(evt);
            }
        });
        txtGananciaMinorista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGananciaMinoristaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaMinoristaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaMinoristaKeyTyped(evt);
            }
        });

        txtPorcMin.setEditable(false);
        txtPorcMin.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPorcMin.setForeground(new java.awt.Color(0, 153, 0));
        txtPorcMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPorcMin.setBorder(null);
        txtPorcMin.setOpaque(false);
        txtPorcMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcMinFocusLost(evt);
            }
        });
        txtPorcMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPorcMinMouseClicked(evt);
            }
        });
        txtPorcMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcMinActionPerformed(evt);
            }
        });
        txtPorcMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcMinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcMinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcMinKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(0, 102, 102));
        jLabel16.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("MAYORISTAS");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel16.setOpaque(true);

        txtGananciaMayorista.setEditable(false);
        txtGananciaMayorista.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtGananciaMayorista.setForeground(new java.awt.Color(0, 153, 0));
        txtGananciaMayorista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGananciaMayorista.setBorder(null);
        txtGananciaMayorista.setOpaque(false);
        txtGananciaMayorista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGananciaMayoristaFocusLost(evt);
            }
        });
        txtGananciaMayorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGananciaMayoristaMouseClicked(evt);
            }
        });
        txtGananciaMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGananciaMayoristaActionPerformed(evt);
            }
        });
        txtGananciaMayorista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGananciaMayoristaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaMayoristaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaMayoristaKeyTyped(evt);
            }
        });

        txtPorcMay.setEditable(false);
        txtPorcMay.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPorcMay.setForeground(new java.awt.Color(0, 153, 0));
        txtPorcMay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPorcMay.setBorder(null);
        txtPorcMay.setOpaque(false);
        txtPorcMay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcMayFocusLost(evt);
            }
        });
        txtPorcMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPorcMayMouseClicked(evt);
            }
        });
        txtPorcMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcMayActionPerformed(evt);
            }
        });
        txtPorcMay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcMayKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcMayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcMayKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel19.setText("PRECIO DE VENTA");
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtPrecioVentaMayorista.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtPrecioVentaMayorista.setForeground(new java.awt.Color(17, 35, 46));
        txtPrecioVentaMayorista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaMayorista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPrecioVentaMayorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMayoristaMouseClicked(evt);
            }
        });
        txtPrecioVentaMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaMayoristaActionPerformed(evt);
            }
        });
        txtPrecioVentaMayorista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMayoristaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMayoristaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMayoristaKeyTyped(evt);
            }
        });

        txtGananciaSuper.setEditable(false);
        txtGananciaSuper.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtGananciaSuper.setForeground(new java.awt.Color(0, 153, 0));
        txtGananciaSuper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGananciaSuper.setBorder(null);
        txtGananciaSuper.setOpaque(false);
        txtGananciaSuper.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGananciaSuperFocusLost(evt);
            }
        });
        txtGananciaSuper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGananciaSuperMouseClicked(evt);
            }
        });
        txtGananciaSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGananciaSuperActionPerformed(evt);
            }
        });
        txtGananciaSuper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGananciaSuperKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaSuperKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaSuperKeyTyped(evt);
            }
        });

        txtPrecioVentaSuper.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtPrecioVentaSuper.setForeground(new java.awt.Color(17, 35, 46));
        txtPrecioVentaSuper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaSuper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPrecioVentaSuper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaSuperMouseClicked(evt);
            }
        });
        txtPrecioVentaSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaSuperActionPerformed(evt);
            }
        });
        txtPrecioVentaSuper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaSuperKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaSuperKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaSuperKeyTyped(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(0, 102, 102));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("SUPERMERCADOS");
        jLabel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel17.setOpaque(true);

        txtPorcSuper.setEditable(false);
        txtPorcSuper.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtPorcSuper.setForeground(new java.awt.Color(0, 153, 0));
        txtPorcSuper.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPorcSuper.setBorder(null);
        txtPorcSuper.setOpaque(false);
        txtPorcSuper.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcSuperFocusLost(evt);
            }
        });
        txtPorcSuper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPorcSuperMouseClicked(evt);
            }
        });
        txtPorcSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcSuperActionPerformed(evt);
            }
        });
        txtPorcSuper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcSuperKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcSuperKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcSuperKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel23.setText("EN %:");

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel24.setText("EN %:");

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel26.setText("EN %:");

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel21.setText("LUCRO:");
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel27.setText("LUCRO:");
        jLabel27.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel28.setText("PRECIO DE VENTA");
        jLabel28.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel29.setText("LUCRO:");
        jLabel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecioVentaSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGananciaSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPorcSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecioVentaMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGananciaMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPorcMay, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecioVentaMinorista, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGananciaMinorista, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPorcMin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGananciaMinorista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtPrecioVentaMinorista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGananciaMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcMay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVentaMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGananciaSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVentaSuper, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel13.setText("STOCK ACTUAL EN DEPOSITO");

        txtStock.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStock.setText("0");
        txtStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        ckHabilitar.setForeground(new java.awt.Color(0, 0, 0));
        ckHabilitar.setText("APLICAR PRECIO MAYORISTA A PARTIR DE");
        ckHabilitar.setColorCheck(new java.awt.Color(0, 102, 102));
        ckHabilitar.setColorUnCheck(new java.awt.Color(0, 153, 153));
        ckHabilitar.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        ckHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckHabilitarActionPerformed(evt);
            }
        });
        ckHabilitar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckHabilitarKeyPressed(evt);
            }
        });

        txtCantM.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtCantM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCantM.setEnabled(false);
        txtCantM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantMMouseClicked(evt);
            }
        });
        txtCantM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantMActionPerformed(evt);
            }
        });
        txtCantM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantMKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ckHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(txtCantM, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addComponent(txtStock)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ckHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboImpuestoActionPerformed
        // TODO add your handling code here:
        /* if (cboImpuesto.getSelectedIndex() == 0) {
            txtGanancia.setText("0");
        } else {
            String item = String.valueOf(cboImpuesto.getSelectedItem());
            try {
                rs = sentencia.executeQuery("Select idiva from iva where descripcion='" + item + "' and estado='S'");
                rs.first();
                id = rs.getInt("idiva");
            } catch (SQLException ex) {
                Mensajes.error("ID Impuesto:" + ex.getMessage());
            }
        }*/
    }//GEN-LAST:event_cboImpuestoActionPerformed

    private void cboClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClasificacionActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboClasificacionActionPerformed

    private void btnFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFamiliaActionPerformed
        // TODO add your handling code here:
        dlgIVAMovil fa = new dlgIVAMovil(null, true);
        fa.setLocationRelativeTo(null);
        fa.setVisible(true);
    }//GEN-LAST:event_btnFamiliaActionPerformed

    private void btnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratorioActionPerformed
        // TODO add your handling code here:
        dlgClasificacionMovil la = new dlgClasificacionMovil(null, true);
        la.setLocationRelativeTo(null);
        la.setVisible(true);
    }//GEN-LAST:event_btnLaboratorioActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        dlgUMMovil umM = new dlgUMMovil(null, true);
        umM.setLocationRelativeTo(null);
        umM.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void txtPrecioVentaMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaMayoristaActionPerformed

    }//GEN-LAST:event_txtPrecioVentaMayoristaActionPerformed

    private void txtGananciaMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGananciaMayoristaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtGananciaMayoristaActionPerformed

    private void cboUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUMActionPerformed

    private void txtGananciaMayoristaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaMayoristaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMayoristaKeyReleased

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtCosto.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtCosto.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtCosto.setText("0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        if (txtCosto.getText().equals("")) {
            txtCosto.setText("0");
        } else {
            DecimalFormat dff = new DecimalFormat("#0");
            txtPrecioCostoL.setText(dff.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
        }

        calcularGananciaMinorista();
        calcularPorMinorista();
        calcularGanancia();
        calcularPor();
        calcularGananciaSuper();
        calcularPorSuper();

    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtPrecioVentaMayoristaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMayoristaKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVentaMayorista.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVentaMayorista.setText(df.format(Integer.valueOf(txtPrecioVentaMayorista.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVentaMayorista.setText("0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        if (txtPrecioVentaMayorista.getText().equals("")) {
            txtPrecioVentaMayorista.setText("0");
        } else {
            DecimalFormat dff = new DecimalFormat("#0");
            txtPrecioVentaL.setText(dff.format(Integer.valueOf(txtPrecioVentaMayorista.getText().trim().replace(".", "").replace(",", ""))));
        }
        calcularGanancia();
        calcularPor();
    }//GEN-LAST:event_txtPrecioVentaMayoristaKeyReleased

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtCosto.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:  
        txtPrecioVentaMinorista.requestFocus();
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtGananciaMayoristaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGananciaMayoristaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMayoristaFocusLost

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtCodInternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodInternoKeyPressed
        // TODO add your handling code here:
        /* if (!txtCodBarra.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtCodBarra);
        }*/

    }//GEN-LAST:event_txtCodInternoKeyPressed

    private void txtGananciaMayoristaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaMayoristaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 5;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtGananciaMayorista.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGananciaMayoristaKeyTyped

    private void txtPrecioVentaMayoristaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMayoristaKeyTyped
        // TODO add your handling code here:

        int limite = 10;
        if (txtPrecioVentaMayorista.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaMayoristaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
        //char c = evt.getKeyChar();
        int limite = 7;
        if (txtStock.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioVentaMayoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMayoristaMouseClicked
        // TODO add your handling code here:
        //txtPrecioVenta.selectAll();
    }//GEN-LAST:event_txtPrecioVentaMayoristaMouseClicked

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
        // TODO add your handling code here:
        //txtCosto.selectAll();
    }//GEN-LAST:event_txtCostoMouseClicked

    private void txtCodInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodInternoActionPerformed
        // TODO add your handling code here:
        txtCodBarra.requestFocus();
    }//GEN-LAST:event_txtCodInternoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
        cboClasificacion.requestFocus();
        cboClasificacion.setPopupVisible(true);
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void cboClasificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboClasificacionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cboUM.requestFocus();
            cboUM.setPopupVisible(true);
        }
    }//GEN-LAST:event_cboClasificacionKeyPressed

    private void cboUMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboUMKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cboImpuesto.requestFocus();
            cboImpuesto.setPopupVisible(true);
        }
    }//GEN-LAST:event_cboUMKeyPressed

    private void cboImpuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboImpuestoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtStock.isEnabled()) {
                ckHabilitar.requestFocus();
            } else {
                txtStock.requestFocus();
            }
        }
    }//GEN-LAST:event_cboImpuestoKeyPressed

    private void txtPrecioVentaMayoristaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMayoristaKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioVentaMayorista.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVentaMayorista);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPrecioVentaSuper.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioVentaMayoristaKeyPressed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
        if (!txtCosto.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtCosto);
        }
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
        // TODO add your handling code here:
        //validarCampos.soloNumeros(txtStock);
        validarCampos.soloDecimales(txtStock);
    }//GEN-LAST:event_txtStockKeyPressed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
        ckHabilitar.requestFocus();
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtGananciaMayoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGananciaMayoristaMouseClicked
        // TODO add your handling code here:
        txtGananciaMayorista.selectAll();
    }//GEN-LAST:event_txtGananciaMayoristaMouseClicked

    private void txtGananciaMayoristaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaMayoristaKeyPressed
        // TODO add your handling code here:
        if (!txtGananciaMayorista.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtGananciaMayorista);
        }
    }//GEN-LAST:event_txtGananciaMayoristaKeyPressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void cboClasificacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboClasificacionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClasificacionItemStateChanged

    private void txtCodInternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodInternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtCodInternoKeyTyped

    private void txtCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarraActionPerformed
        // TODO add your handling code here:
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtCodBarraActionPerformed

    private void txtCodBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodBarraKeyPressed

    private void txtCodBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodBarraKeyTyped

    private void txtPrecioVentaMinoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMinoristaMouseClicked
        // TODO add your handling code here:
        txtPrecioVentaMayorista.selectAll();
    }//GEN-LAST:event_txtPrecioVentaMinoristaMouseClicked

    private void txtPrecioVentaMinoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaMinoristaActionPerformed
        // TODO add your handling code here:
        txtPrecioVentaMayorista.requestFocus();
    }//GEN-LAST:event_txtPrecioVentaMinoristaActionPerformed

    private void txtPrecioVentaMinoristaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMinoristaKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioVentaMinorista.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVentaMinorista);
        }

    }//GEN-LAST:event_txtPrecioVentaMinoristaKeyPressed

    private void txtPrecioVentaMinoristaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMinoristaKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVentaMinorista.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVentaMinorista.setText(df.format(Integer.valueOf(txtPrecioVentaMinorista.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVentaMinorista.setText("0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        calcularGananciaMinorista();
        calcularPorMinorista();
    }//GEN-LAST:event_txtPrecioVentaMinoristaKeyReleased

    private void txtPrecioVentaMinoristaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMinoristaKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtPrecioVentaMinorista.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaMinoristaKeyTyped

    private void txtCantMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMMouseClicked

    private void txtCantMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantMActionPerformed
        // TODO add your handling code here:
        if (txtCantM.getText().isEmpty()) {
            txtCantM.setText("2");
            txtPrecioVentaMinorista.requestFocus();
        } else if (Integer.parseInt(txtCantM.getText()) < 2) {
            Mensajes.informacion("Para aplicar Precio Mayorista se requiere una Cantidad mayor que 1");
            txtCantM.setText("2");
            txtPrecioVentaMinorista.requestFocus();
        } else {
            txtPrecioVentaMinorista.requestFocus();
        }
    }//GEN-LAST:event_txtCantMActionPerformed

    private void txtCantMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyPressed
        // TODO add your handling code here:
        if (!txtCantM.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVentaMayorista);
        }
    }//GEN-LAST:event_txtCantMKeyPressed

    private void txtCantMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMKeyReleased

    private void txtCantMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMKeyTyped

    private void txtGananciaMinoristaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGananciaMinoristaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMinoristaFocusLost

    private void txtGananciaMinoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGananciaMinoristaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMinoristaMouseClicked

    private void txtGananciaMinoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGananciaMinoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMinoristaActionPerformed

    private void txtGananciaMinoristaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaMinoristaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMinoristaKeyPressed

    private void txtGananciaMinoristaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaMinoristaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMinoristaKeyReleased

    private void txtGananciaMinoristaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaMinoristaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaMinoristaKeyTyped

    private void txtPorcMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcMinFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMinFocusLost

    private void txtPorcMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPorcMinMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMinMouseClicked

    private void txtPorcMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMinActionPerformed

    private void txtPorcMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcMinKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMinKeyPressed

    private void txtPorcMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcMinKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMinKeyReleased

    private void txtPorcMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcMinKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMinKeyTyped

    private void txtPorcMayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcMayFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMayFocusLost

    private void txtPorcMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPorcMayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMayMouseClicked

    private void txtPorcMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcMayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMayActionPerformed

    private void txtPorcMayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcMayKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMayKeyPressed

    private void txtPorcMayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcMayKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMayKeyReleased

    private void txtPorcMayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcMayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcMayKeyTyped

    private void txtGananciaSuperFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGananciaSuperFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaSuperFocusLost

    private void txtGananciaSuperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGananciaSuperMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaSuperMouseClicked

    private void txtGananciaSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGananciaSuperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaSuperActionPerformed

    private void txtGananciaSuperKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaSuperKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaSuperKeyPressed

    private void txtGananciaSuperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaSuperKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaSuperKeyReleased

    private void txtGananciaSuperKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaSuperKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaSuperKeyTyped

    private void txtPorcSuperFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcSuperFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcSuperFocusLost

    private void txtPorcSuperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPorcSuperMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcSuperMouseClicked

    private void txtPorcSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcSuperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcSuperActionPerformed

    private void txtPorcSuperKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcSuperKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcSuperKeyPressed

    private void txtPorcSuperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcSuperKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcSuperKeyReleased

    private void txtPorcSuperKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcSuperKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcSuperKeyTyped

    private void txtPrecioVentaSuperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaSuperMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaSuperMouseClicked

    private void txtPrecioVentaSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaSuperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaSuperActionPerformed

    private void txtPrecioVentaSuperKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaSuperKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioVentaSuper.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVentaSuper);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!btnGuardar.isEnabled()) {
                btnModificar.doClick();
            } else {
                btnGuardar.doClick();
            }
        }
    }//GEN-LAST:event_txtPrecioVentaSuperKeyPressed

    private void txtPrecioVentaSuperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaSuperKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVentaSuper.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVentaSuper.setText(df.format(Integer.valueOf(txtPrecioVentaSuper.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVentaSuper.setText("0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        if (txtPrecioVentaSuper.getText().equals("")) {
            txtPrecioVentaSuper.setText("0");
        }
        calcularGananciaSuper();
        calcularPorSuper();
    }//GEN-LAST:event_txtPrecioVentaSuperKeyReleased

    private void txtPrecioVentaSuperKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaSuperKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaSuperKeyTyped

    private void ckHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckHabilitarActionPerformed
        // TODO add your handling code here:
        if (ckHabilitar.isSelected()) {
            txtCantM.setEnabled(true);
            //txtPrecioVentaMinorista.setEnabled(true);
            txtCantM.requestFocus();
        } else {
            txtCantM.setEnabled(false);
            txtCosto.requestFocus();
            //txtPrecioVentaMinorista.setEnabled(false);
            //txtCantM.setText("2");
            //txtPrecioVentaM.setText("0");
            //txtPrecioVentaML.setText("0");
        }
    }//GEN-LAST:event_ckHabilitarActionPerformed

    private void ckHabilitarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckHabilitarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCantM.isEnabled()) {
                txtCosto.requestFocus();
            } else {
                txtCantM.requestFocus();
            }
        }
    }//GEN-LAST:event_ckHabilitarKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        CargarCombos();
        limpiarCampos();
        Habilitacion();
        String cod = GestionarArticulosMovil.getCodigo();
        txtCodProducto.setText(cod);
        txtCodInterno.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txtCodProducto.getText().isEmpty()) {
            Mensajes.informacion("No se ha generado ID producto.");
        } else if (txtCodInterno.getText().isEmpty()) {
            Mensajes.informacion("Debes de cargar un código interno al producto.");
            txtCodInterno.requestFocus();
        } else if (txtCodBarra.getText().isEmpty()) {
            Mensajes.informacion("Debes de cargar el código de barra del producto.");
            txtCodBarra.requestFocus();
        } else if (txtDescripcion.getText().isEmpty()) {
            Mensajes.informacion("Debes de ingresar la descripción del producto.");
            txtDescripcion.requestFocus();
        } else if (cboClasificacion.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Clasificación");
            cboClasificacion.requestFocus();
        } else if (cboUM.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Unidad de medida");
            cboUM.requestFocus();
        } else if (cboImpuesto.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Impuesto");
            cboImpuesto.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlArticuloMovil.actArticulo();
                    Cancelar();
                } else {
                    txtCodInterno.requestFocus();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtCodProducto.getText().isEmpty()) {
            Mensajes.informacion("No se ha generado ID producto.");
        } else if (txtCodInterno.getText().isEmpty()) {
            Mensajes.informacion("Debes de cargar un código interno al producto.");
            txtCodInterno.requestFocus();
        } else if (txtCodBarra.getText().isEmpty()) {
            Mensajes.informacion("Debes de cargar el código de barra del producto.");
            txtCodBarra.requestFocus();
        } else if (txtDescripcion.getText().isEmpty()) {
            Mensajes.informacion("Debes de ingresar la descripción del producto.");
            txtDescripcion.requestFocus();
        } else if (cboClasificacion.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Clasificación");
            cboClasificacion.requestFocus();
        } else if (cboUM.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Unidad de medida");
            cboUM.requestFocus();
        } else if (cboImpuesto.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Impuesto");
            cboImpuesto.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    txtCodProducto.setText(GestionarArticulosMovil.getCodigo());
                    controlArticuloMovil.addArticulo();
                    Cancelar();
                } else {
                    txtCodInterno.requestFocus();
                }
            } catch (HeadlessException ee) {
                System.out.println("FATAL ERROR: " + ee.getMessage());
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar?");
        if (rpta == 0) {
            limpiarCampos();
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnLaboratorio.setEnabled(false);
            btnProveedor.setEnabled(false);
            btnFamilia.setEnabled(false);
            txtCodInterno.setEnabled(false);
            txtDescripcion.setEnabled(false);
            cboClasificacion.setEnabled(false);
            cboImpuesto.setEnabled(false);
            cboUM.setEnabled(false);
            txtCosto.setEnabled(false);
            txtGananciaMayorista.setEnabled(false);
            txtPrecioVentaMayorista.setEnabled(false);
            txtStock.setEnabled(false);
            Volver();
            this.dispose();
        } else {
            txtCodInterno.requestFocus();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void Nuevo() {
        btnNuevoActionPerformed(null);
    }

    public static void limpiarCampos() {
        txtCodProducto.setText("");
        txtDescripcion.setText("");
        txtCodInterno.setText("");
        txtCodBarra.setText("");
        txtCosto.setText("0");
        txtGananciaMayorista.setText("0");
        txtPrecioVentaMayorista.setText("0");
        txtPrecioVentaL.setText("0");
        txtStock.setText("0");
        txtPrecioVentaMinorista.setText("0");
        txtCantM.setText("3");
        txtGananciaMinorista.setText("0");
        //txtStockMin.setText("0");
        txtPrecioVentaSuper.setText("0");
        txtGananciaSuper.setText("0");
        txtPorcSuper.setText("0");
        txtPorcMin.setText("0");
        txtPorcMay.setText("0");
        txtCodClasificacion.setText("");
        txtCodImpuesto.setText("");
        txtCodUM.setText("");
        cboClasificacion.setSelectedIndex(0);
        cboUM.setSelectedIndex(0);
        cboImpuesto.setSelectedIndex(0);
    }

    void Volver() {
        if (dlgArticulosMovil.ckStock.isSelected()) {
            CabecerasTablas.ArticulosMovil(dlgArticulosMovil.tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(dlgArticulosMovil.tbProductos);
            controlArticuloMovil.listArticuloconStock(dlgArticulosMovil.tbProductos);
            dlgArticulosMovil.Renders();
        } else {
            CabecerasTablas.ArticulosMovil(dlgArticulosMovil.tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(dlgArticulosMovil.tbProductos);
            controlArticuloMovil.listArticulo(dlgArticulosMovil.tbProductos);
            dlgArticulosMovil.Renders();
        }
        dlgArticulosMovil.txtBuscar.requestFocus();
        dlgArticulosMovil.txtBuscar.setText("");
        dlgArticulosMovil.tbProductos.clearSelection();
    }

    public void modcboClasificacion() {
        String codClasificacion = txtCodClasificacion.getText().trim();
        try {
            HttpClient clasificacion = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultComboBoxModel ml = new DefaultComboBoxModel();
                            ml.addElement("SELEC. UNA OPCIÓN");
                            JSONObject jsonClasificacion = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonClasificacion.length(); f++) {
                                ml.addElement(jsonClasificacion.getJSONObject("" + f + "").get("descripcion").toString());
                            }
                            try {
                                try {
                                    URL url = new URL(urlServer() + "getClasificacionEspecifico.php?id=" + codClasificacion);
                                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                    conn.setRequestMethod("GET");
                                    conn.connect();

                                    int ResponseCod = conn.getResponseCode();

                                    if (ResponseCod != 200) {
                                        throw new RuntimeException("Ocurrio un error: " + ResponseCod);
                                    } else {
                                        StringBuilder clasificacion = new StringBuilder();
                                        Scanner scan = new Scanner(url.openStream());
                                        while (scan.hasNext()) {
                                            clasificacion.append(scan.nextLine());
                                        }
                                        scan.close();
                                        JSONObject jsonC = new JSONObject(clasificacion.toString());
                                        for (int f = 0; f < jsonC.length(); f++) {
                                            Object descripcion = jsonC.getJSONObject("" + f + "").get("descripcion").toString();
                                            cboClasificacion.setModel(ml);
                                            cboClasificacion.setSelectedItem(descripcion);
                                        }
                                    }
                                } catch (IOException | RuntimeException e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (Exception f) {
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            });
            clasificacion.excecute(urlServer() + "getClasificacion.php");
        } catch (Exception e) {
            System.out.println("err_modcboClasificacion: " + e.getMessage());
        }
    }

    public void modcboUM() {
        String codUM = txtCodUM.getText().trim();
        try {
            HttpClient um = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultComboBoxModel ml = new DefaultComboBoxModel();
                            ml.addElement("SELEC. UNA OPCIÓN");
                            JSONObject jsonUM = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonUM.length(); f++) {
                                ml.addElement(jsonUM.getJSONObject("" + f + "").get("unidadmedida").toString());
                            }
                            try {
                                try {
                                    URL url = new URL(urlServer() + "getUMEspecifico.php?id=" + codUM);
                                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                    conn.setRequestMethod("GET");
                                    conn.connect();

                                    int ResponseCod = conn.getResponseCode();

                                    if (ResponseCod != 200) {
                                        throw new RuntimeException("Ocurrio un error: " + ResponseCod);
                                    } else {
                                        StringBuilder um = new StringBuilder();
                                        Scanner scan = new Scanner(url.openStream());
                                        while (scan.hasNext()) {
                                            um.append(scan.nextLine());
                                        }
                                        scan.close();
                                        JSONObject jsonUME = new JSONObject(um.toString());
                                        for (int f = 0; f < jsonUME.length(); f++) {
                                            Object descripcion = jsonUME.getJSONObject("" + f + "").get("unidadmedida").toString();
                                            cboUM.setModel(ml);
                                            cboUM.setSelectedItem(descripcion);
                                        }
                                    }
                                } catch (IOException | RuntimeException e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (Exception f) {
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            });
            um.excecute(urlServer() + "getUM.php");
        } catch (Exception e) {
            System.out.println("err_modcboUM: " + e.getMessage());
        }
    }

    public void modcboImpuesto() {
        String codImpuesto = txtCodImpuesto.getText().trim();
        try {
            HttpClient impuesto = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            DefaultComboBoxModel ml = new DefaultComboBoxModel();
                            ml.addElement("SELEC. UNA OPCIÓN");
                            JSONObject jsonImpuesto = new JSONObject(status.getResult());
                            for (int f = 0; f < jsonImpuesto.length(); f++) {
                                ml.addElement(jsonImpuesto.getJSONObject("" + f + "").get("descripcion").toString());
                            }
                            try {
                                try {
                                    URL url = new URL(urlServer() + "getImpuestoEspecifico.php?id=" + codImpuesto);
                                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                    conn.setRequestMethod("GET");
                                    conn.connect();

                                    int ResponseCod = conn.getResponseCode();

                                    if (ResponseCod != 200) {
                                        throw new RuntimeException("Ocurrio un error: " + ResponseCod);
                                    } else {
                                        StringBuilder impuesto = new StringBuilder();
                                        Scanner scan = new Scanner(url.openStream());
                                        while (scan.hasNext()) {
                                            impuesto.append(scan.nextLine());
                                        }
                                        scan.close();
                                        JSONObject jsonIMP = new JSONObject(impuesto.toString());
                                        for (int f = 0; f < jsonIMP.length(); f++) {
                                            Object descripcion = jsonIMP.getJSONObject("" + f + "").get("descripcion").toString();
                                            cboImpuesto.setModel(ml);
                                            cboImpuesto.setSelectedItem(descripcion);
                                        }
                                    }
                                } catch (IOException | RuntimeException e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (Exception f) {
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            });
            impuesto.excecute(urlServer() + "getImpuesto.php");
        } catch (Exception e) {
            System.out.println("err_modcboImpuesto: " + e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(dlgGestArticulosMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestArticulosMovil dialog = new dlgGestArticulosMovil(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    public static javax.swing.JButton btnFamilia;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static javax.swing.JButton btnLaboratorio;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static javax.swing.JButton btnProveedor;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    public static javax.swing.JComboBox<String> cboClasificacion;
    public static javax.swing.JComboBox<String> cboImpuesto;
    public static javax.swing.JComboBox<String> cboUM;
    public static rojerusan.RSCheckBox ckHabilitar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTextField txtCantM;
    public static javax.swing.JTextField txtCodBarra;
    public static javax.swing.JTextField txtCodClasificacion;
    public static javax.swing.JTextField txtCodImpuesto;
    public static javax.swing.JTextField txtCodInterno;
    public static javax.swing.JTextField txtCodProducto;
    public static javax.swing.JTextField txtCodUM;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtGananciaMayorista;
    public static javax.swing.JTextField txtGananciaMinorista;
    public static javax.swing.JTextField txtGananciaSuper;
    public static javax.swing.JTextField txtPorcMay;
    public static javax.swing.JTextField txtPorcMin;
    public static javax.swing.JTextField txtPorcSuper;
    public static javax.swing.JTextField txtPrecioCostoL;
    public static javax.swing.JTextField txtPrecioVentaL;
    public static javax.swing.JTextField txtPrecioVentaMayorista;
    public static javax.swing.JTextField txtPrecioVentaMinorista;
    public static javax.swing.JTextField txtPrecioVentaSuper;
    public static javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
