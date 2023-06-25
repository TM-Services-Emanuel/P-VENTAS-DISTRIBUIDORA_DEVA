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
import Componentes.Numero_a_Letra;
import Componentes.RenderCargaTotal;
import Componentes.RenderDevuelto;
import Componentes.RenderRecambio;
import Componentes.RenderVendido;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlReparto;
import Datos.GestionarReparto;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

/**
 *
 * @author ADMIN
 */
public class dlgGestRepartos extends javax.swing.JDialog {

    private static final CabecerasTablas cabe = new CabecerasTablas();

    public static ResultSet rs;
    public static MariaDbConnection con;
    public static MariaDbStatement sentencia;
    public static MariaDbStatement stTransaccion;
    static String UsuarioL = "";
    static String opcion = "";
    public Reporte jasper;
    public Numero_a_Letra d;

    static ConexionBD conectar = ConexionBD.getInstancia();

    /**
     * Creates new form dlgGestRepartos
     *
     * @param parent
     * @param modal
     */
    public dlgGestRepartos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        noVisible();
        CabecerasTablas.reparto(tbDetalleReparto);
        Renders();
        UsuarioL = Login.getUsuarioLogueado();
        d = new Numero_a_Letra();
    }

    public static void Renders() {
        dlgGestRepartos.tbDetalleReparto.getColumnModel().getColumn(7).setCellRenderer(new RenderCargaTotal());
        dlgGestRepartos.tbDetalleReparto.getColumnModel().getColumn(9).setCellRenderer(new RenderRecambio());
        dlgGestRepartos.tbDetalleReparto.getColumnModel().getColumn(11).setCellRenderer(new RenderVendido());
        dlgGestRepartos.tbDetalleReparto.getColumnModel().getColumn(14).setCellRenderer(new RenderDevuelto());
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Crear o modificar Repartos");
        } else {
            this.setTitle(Software.getSoftware() + " - Crear o modificar Repartos");
        }
    }

    private void noVisible() {
        txtCaja.setVisible(false);
        btnAdd.setVisible(false);
        txtOpcion.setVisible(false);
        txtResponsable.setVisible(false);
        txtChofer.setVisible(false);
        txtMovil.setVisible(false);
        txtFechaIF.setVisible(false);
        txtIdMovil.setVisible(false);
        txtTotalL.setVisible(false);
        txtCodArticulo.setVisible(false);
        txtRecambioL.setVisible(false);
        txtDevueltosL.setVisible(false);
        txtTotalVentasL.setVisible(false);
        btnBuscarArticulo.setVisible(false);
        btnRestar.setVisible(false);
        txtPresentadoL.setVisible(false);
        txtDiferenciaL.setVisible(false);
        lbComR.setVisible(false);
        lbComC.setVisible(false);
        txtIdResponsable.setVisible(false);
        txtIdChofer.setVisible(false);
        txtValorRA.setVisible(false);
        txtValorCompra.setVisible(false);
        txtValorTransferencia.setVisible(false);
    }

    public static void habilitarCANT() {
        if (txtProducto.getText().isEmpty()) {
            txtCantidad.setEnabled(false);
        } else {
            txtCantidad.setEnabled(true);
        }
    }

    public static void prepararBD() {
        try {
            con = (MariaDbConnection) conectar.getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                sentencia = (MariaDbStatement) con.createStatement();
                stTransaccion = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void limpiarCampos() {
        txtIdReparto.setText("");
        lbInfoMovil.setText("");
        lbInfoChofer.setText("");
        txtIdResponsable.setText("");
        txtResponsable.setText("");
        lbComR.setText("");
        txtIdChofer.setText("");
        txtChofer.setText("");
        lbComC.setText("");
        txtIdMovil.setText("");
        txtMovil.setText("");
        txtFechaI.setText("");
        txtFechaIF.setText("");
        txtHoraI.setText("");
        txtEstado.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtOpcion.setText("");
        txtCodArticulo.setText("");
        txtTotalL.setText("0");
        txtRecambioL.setText("0");
        txtDevueltosL.setText("0");
        txtTotalVentasL.setText("0");
        txtPresentadoL.setText("0");
        txtDiferenciaL.setText("0");
        txtKmAnterior.setText("0");
        txtKmActual.setText("0");
        txtKmRecorrido.setText("0");

        txtValorRA.setText("0");
        txtValorCompra.setText("0");
        txtValorTransferencia.setText("0");

        txtTotal.setText("0");
        txtRecambio.setText("0");
        txtDevueltos.setText("0");
        txtTotalVentas.setText("0");
        txtPresentado.setText("0");
        txtDiferencia.setText("0");
        txtGastosTotal.setText("0");
        txtComisionR.setText("0");
        txtComisionC.setText("0");
        txtEstado.setText("");
        txtCaja.setText("");
        txtContenedorI.setText("0");
        txtContenedorF.setText("0");
        txtContenedorD.setText("");
        cbCerrar.setSelected(false);
        chAgregar.setSelected(false);
        lbInfoCantidad.setText("");
        CabecerasTablas.reparto(tbDetalleReparto);
        CabecerasTablas.limpiarTablasRepartos(tbDetalleReparto);
    }

    public static void cant() {
        int total = tbDetalleReparto.getRowCount();
        switch (total) {
            case 0 ->
                lbInfoCantidad.setText("lista vacia.");
            case 1 ->
                lbInfoCantidad.setText("Se lista " + total + " producto en el reparto.");
            default ->
                lbInfoCantidad.setText("Se listan " + total + " productos en el reparto.");
        }

    }

    public static void calcularDiferencia() {
        int venta, entrega, diferencia;
        venta = Integer.parseInt(txtTotalVentasL.getText());
        entrega = Integer.parseInt(txtPresentadoL.getText());
        diferencia = (entrega - venta);

        DecimalFormat df = new DecimalFormat("#,###");
        txtDiferenciaL.setText(String.valueOf(diferencia));
        txtDiferencia.setText(df.format(Integer.parseInt(String.valueOf(diferencia).replace(".", "").replace(",", ""))));
    }

    public static void calcularCajas() {
        try {
            int inicio, cierre, diferencia;
            inicio = Integer.parseInt(txtContenedorI.getText());
            cierre = Integer.parseInt(txtContenedorF.getText());
            diferencia = cierre - inicio;
            txtContenedorD.setText(String.valueOf(diferencia));
        } catch (Exception e) {
        }

    }

    public static void calcularKilometraje() {
        try {
            int inicio, cierre, diferencia;
            inicio = Integer.parseInt(txtKmAnterior.getText());
            cierre = Integer.parseInt(txtKmActual.getText());
            diferencia = cierre - inicio;
            txtKmRecorrido.setText(String.valueOf(diferencia));
        } catch (Exception e) {
        }

    }

    public static void calcularComisiones() {
        DecimalFormat df = new DecimalFormat("#,###");
        try {
            if (txtPresentadoL.getText().isEmpty()) {
                txtComisionR.setText("0");
            } else {
                int monto;
                double com;
                int Mcomision;
                monto = Integer.parseInt(txtPresentadoL.getText());
                com = Double.parseDouble(lbComR.getText());
                Mcomision = (int) (monto * (com / 100));
                //txtComisionR.setText(String.valueOf(Mcomision));
                txtComisionR.setText(df.format(Integer.parseInt(String.valueOf(Mcomision).replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
        }
        try {
            if (txtPresentadoL.getText().isEmpty()) {
                txtComisionC.setText("0");
            } else {
                int monto;
                double com;
                int Mcomision;
                monto = Integer.parseInt(txtPresentadoL.getText());
                com = Double.parseDouble(lbComC.getText());
                Mcomision = (int) (monto * (com / 100));
                //txtComisionC.setText(String.valueOf(Mcomision));
                txtComisionC.setText(df.format(Integer.parseInt(String.valueOf(Mcomision).replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
        }
    }

    public static void modificarcboResponsable() {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        String codResponsable = txtIdResponsable.getText().trim();
        try {
            prepararBD();
            ResultSet res = sentencia.executeQuery("SELECT * FROM v_vendedores WHERE idfuncion=2 AND ven_indicador='S'");
            ml.addElement("SELECCIONE UN RESPONSABLE");
            while (res.next()) {
                ml.addElement(res.getString("ven_nombre"));

            }
            ResultSet rss = sentencia.executeQuery("SELECT * FROM v_vendedores WHERE ven_codigo=" + codResponsable);
            rss.first();
            Object descripcion = (Object) rss.getString("ven_nombre");
            cboResponsable.setModel(ml);
            cboResponsable.setSelectedItem(descripcion);
        } catch (SQLException ew) {
        }
    }

    public static void ObtenerGastosA() {
        prepararBD();
        try {
            String idm;
            idm = txtIdMovil.getText();
            try {
                rs = sentencia.executeQuery("SELECT SUM(ga_importe) AS total FROM gastos WHERE ga_idmovil=" + idm + " AND caja_ca_id=" + txtCaja.getText().trim() + " AND ga_indicador='S' AND tipo='A'");
                rs.last();
                if (rs.getString("total") == null) {
                    txtGastosTotal.setText("0");
                } else {
                    DecimalFormat df = new DecimalFormat("#,###");
                    txtGastosTotal.setText(df.format(Integer.parseInt(String.valueOf(rs.getString("total")).replace(".", "").replace(",", ""))));
                }
                rs.close();
            } catch (SQLException ex) {
                Mensajes.error("Error al querer obtener valor del gasto: " + ex.getMessage());
            }
        } catch (Exception pr) {
        }

    }

    public void Nuevo() {
        btnNuevoActionPerformed(null);
    }

    public void Cancelar() {
        controlReparto.array.vaciar();
        limpiarCampos();
        btnNuevo.setEnabled(true);
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        itemQuitar.setEnabled(false);
        btnSalir.setEnabled(true);
        itemSalir.setEnabled(true);
        btnRC.setEnabled(false);
        btnRR.setEnabled(false);
        itemHojaR.setEnabled(false);
        itemHojaR1.setEnabled(false);
        btnCargarRA.setEnabled(false);
        btnCompraA.setEnabled(false);
        txtContenedorI.setEnabled(false);
        txtContenedorF.setEnabled(false);
        txtKmAnterior.setEnabled(false);
        txtKmActual.setEnabled(false);
        txtPresentado.setEnabled(false);
        btnCargarTransferencias.setEnabled(false);
        cboResponsable.setEnabled(false);
        chAgregar.setEnabled(false);
        //txtIdReparto.setEnabled(true);
        cbCerrar.setEnabled(false);
        rdCargaT.setEnabled(false);
        rdRecambios.setEnabled(false);
        rdDevueltos.setEnabled(false);
        tbDetalleReparto.setEnabled(false);
        this.dispose();
        Volver();

    }

    private void Volver() {
        //dlgRepartos ac = new dlgRepartos(null,true);
        //ac.setLocationRelativeTo(null);
        //ac.setVisible(true);
        CabecerasTablas.todosReparto(dlgRepartos.tbDetalle);
        CabecerasTablas.limpiarTablasTodosRepartos(dlgRepartos.tbDetalle);
        controlReparto.listRepartos(dlgRepartos.tbDetalle, "id_reparto", dlgRepartos.txtFechaFinal.getText().trim());
        dlgRepartos.Renders();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoCargado = new javax.swing.ButtonGroup();
        grupoOpciones = new javax.swing.ButtonGroup();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        lbInfoCantidad = new javax.swing.JLabel();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtOpcion = new javax.swing.JTextField();
        txtResponsable = new javax.swing.JTextField();
        txtChofer = new javax.swing.JTextField();
        txtMovil = new javax.swing.JTextField();
        txtFechaIF = new javax.swing.JTextField();
        txtIdMovil = new javax.swing.JTextField();
        txtTotalL = new javax.swing.JTextField();
        txtCodArticulo = new javax.swing.JTextField();
        txtRecambioL = new javax.swing.JTextField();
        txtDevueltosL = new javax.swing.JTextField();
        txtTotalVentasL = new javax.swing.JTextField();
        btnRestar = new javax.swing.JButton();
        btnBuscarArticulo = new javax.swing.JButton();
        txtPresentadoL = new javax.swing.JTextField();
        txtDiferenciaL = new javax.swing.JTextField();
        txtIdResponsable = new javax.swing.JTextField();
        txtIdChofer = new javax.swing.JTextField();
        txtValorRA = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdReparto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboResponsable = new javax.swing.JComboBox<>();
        lbInfoMovil = new javax.swing.JLabel();
        lbInfoChofer = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        lbComR = new javax.swing.JLabel();
        lbComC = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCargarRA = new javax.swing.JButton();
        btnCompraA = new javax.swing.JButton();
        btnCargarTransferencias = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        rdCargaT = new javax.swing.JRadioButton();
        rdRecambios = new javax.swing.JRadioButton();
        rdDevueltos = new javax.swing.JRadioButton();
        chAgregar = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRecambio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDevueltos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPresentado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDiferencia = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtFechaI = new javax.swing.JTextField();
        txtHoraI = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtComisionR = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtComisionC = new javax.swing.JTextField();
        btnRR = new javax.swing.JButton();
        btnRC = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtContenedorI = new javax.swing.JTextField();
        txtContenedorF = new javax.swing.JTextField();
        txtContenedorD = new javax.swing.JTextField();
        txtValorCompra = new javax.swing.JTextField();
        txtValorTransferencia = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtKmAnterior = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtKmActual = new javax.swing.JTextField();
        txtKmRecorrido = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        cbCerrar = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtGastosTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnOpcionesReparto = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemBuscarArticulo = new javax.swing.JMenuItem();
        itemQuitar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        MnImprimirReparto = new javax.swing.JMenu();
        itemHojaApunte = new javax.swing.JMenuItem();
        itemHojaR = new javax.swing.JMenuItem();
        itemHojaR1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(null);

        lbInfoCantidad.setBackground(new java.awt.Color(17, 35, 46));
        lbInfoCantidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbInfoCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lbInfoCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInfoCantidad.setOpaque(true);
        Blanco.add(lbInfoCantidad);
        lbInfoCantidad.setBounds(10, 614, 908, 15);

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 9));

        btnNuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuevo.setText("Nuevo-F1");
        btnNuevo.setToolTipText("Nuevo - F3");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit30.png"))); // NOI18N
        btnModificar.setText("Modif-F5");
        btnModificar.setToolTipText("Modificar - F5");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar-F6");
        btnGuardar.setToolTipText("Guardar - F6");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancel-Esc");
        btnCancelar.setToolTipText("Cancelar - Esc");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar);

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("Salir-Alt+F4");
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtFechaIF.setEditable(false);
        txtFechaIF.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaIF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIFActionPerformed(evt);
            }
        });

        txtTotalL.setText("0");

        txtRecambioL.setText("0");

        txtDevueltosL.setText("0");

        txtTotalVentasL.setText("0");

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });

        btnBuscarArticulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarArticulo.setForeground(new java.awt.Color(0, 0, 51));
        btnBuscarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnBuscarArticulo.setText("F9-Agregar");
        btnBuscarArticulo.setBorderPainted(false);
        btnBuscarArticulo.setContentAreaFilled(false);
        btnBuscarArticulo.setEnabled(false);
        btnBuscarArticulo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });

        txtPresentadoL.setText("0");

        txtDiferenciaL.setText("0");
        txtDiferenciaL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiferenciaLActionPerformed(evt);
            }
        });

        txtIdResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdResponsableActionPerformed(evt);
            }
        });

        txtValorRA.setText("0");
        txtValorRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OscuroLayout = new javax.swing.GroupLayout(Oscuro);
        Oscuro.setLayout(OscuroLayout);
        OscuroLayout.setHorizontalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaIF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRecambioL, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDevueltosL, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalVentasL, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestar))
                .addGap(10, 10, 10)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPresentadoL, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiferenciaL, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OscuroLayout.createSequentialGroup()
                        .addComponent(txtIdResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtIdChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtValorRA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        OscuroLayout.setVerticalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtFechaIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtIdMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtRecambioL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtDevueltosL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtTotalVentasL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnBuscarArticulo)
                .addGap(6, 6, 6)
                .addComponent(btnRestar))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtPresentadoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtDiferenciaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(OscuroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txtValorRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Blanco.add(Oscuro);
        Oscuro.setBounds(0, 0, 1246, 81);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        jLabel1.setText("ID Reparto");

        txtIdReparto.setEditable(false);
        txtIdReparto.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtIdReparto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdReparto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRepartoActionPerformed(evt);
            }
        });

        jLabel2.setText("Responsable");

        cboResponsable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboResponsable.setMaximumRowCount(15);
        cboResponsable.setEnabled(false);
        cboResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboResponsableActionPerformed(evt);
            }
        });
        cboResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboResponsableKeyPressed(evt);
            }
        });

        lbInfoMovil.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbInfoMovil.setForeground(new java.awt.Color(17, 35, 46));
        lbInfoMovil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        lbInfoChofer.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbInfoChofer.setForeground(new java.awt.Color(17, 35, 46));
        lbInfoChofer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        txtCaja.setEditable(false);
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbComR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbComR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbComC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbComC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbComR, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(lbComC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboResponsable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbInfoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(lbInfoChofer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbInfoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lbComR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbInfoChofer, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lbComC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        Blanco.add(jPanel1);
        jPanel1.setBounds(10, 86, 396, 124);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANEXAR AL REPARTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(17, 35, 46))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCargarRA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCargarRA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/anterior_30.png"))); // NOI18N
        btnCargarRA.setText("1- Reparto anterior");
        btnCargarRA.setEnabled(false);
        btnCargarRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarRAActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargarRA, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 23, 170, 39));

        btnCompraA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCompraA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_compra_30.png"))); // NOI18N
        btnCompraA.setText("2- Compra del día");
        btnCompraA.setEnabled(false);
        btnCompraA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCompraA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraAActionPerformed(evt);
            }
        });
        jPanel2.add(btnCompraA, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 67, 170, 39));

        btnCargarTransferencias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCargarTransferencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Transf 25.png"))); // NOI18N
        btnCargarTransferencias.setText("3- Transferencias");
        btnCargarTransferencias.setEnabled(false);
        btnCargarTransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTransferenciasActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargarTransferencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 110, 170, 39));

        Blanco.add(jPanel2);
        jPanel2.setBounds(570, 82, 190, 160);

        tbDetalleReparto.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tbDetalleReparto.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleReparto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbDetalleReparto.getTableHeader().setResizingAllowed(false);
        tbDetalleReparto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbDetalleReparto);

        Blanco.add(jScrollPane1);
        jScrollPane1.setBounds(10, 245, 908, 363);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(160, 160));

        grupoCargado.add(rdCargaT);
        rdCargaT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdCargaT.setText("CARGA TOTAL");
        rdCargaT.setEnabled(false);
        rdCargaT.setOpaque(false);
        rdCargaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCargaTActionPerformed(evt);
            }
        });

        grupoCargado.add(rdRecambios);
        rdRecambios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdRecambios.setText("RECAMBIOS");
        rdRecambios.setEnabled(false);
        rdRecambios.setOpaque(false);
        rdRecambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdRecambiosActionPerformed(evt);
            }
        });

        grupoCargado.add(rdDevueltos);
        rdDevueltos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdDevueltos.setSelected(true);
        rdDevueltos.setText("DEVUELTOS");
        rdDevueltos.setEnabled(false);
        rdDevueltos.setOpaque(false);
        rdDevueltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDevueltosActionPerformed(evt);
            }
        });

        chAgregar.setBackground(new java.awt.Color(17, 35, 46));
        chAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chAgregar.setForeground(new java.awt.Color(255, 255, 255));
        chAgregar.setText("INGRESAR");
        chAgregar.setEnabled(false);
        chAgregar.setIconTextGap(15);
        chAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(chAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdCargaT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdDevueltos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdRecambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(chAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdCargaT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdRecambios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdDevueltos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Blanco.add(jPanel7);
        jPanel7.setBounds(410, 140, 153, 100);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen de Valores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(27, 57, 84))); // NOI18N
        jPanel8.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Total de recambios");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel9.setText("Total del reparto (Carga)");

        txtRecambio.setEditable(false);
        txtRecambio.setBackground(new java.awt.Color(255, 255, 255));
        txtRecambio.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtRecambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtRecambio.setText("0");
        txtRecambio.setBorder(null);
        txtRecambio.setOpaque(false);
        txtRecambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecambioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel10.setText("Total devueltos");

        txtDevueltos.setEditable(false);
        txtDevueltos.setBackground(new java.awt.Color(255, 255, 255));
        txtDevueltos.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtDevueltos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDevueltos.setText("0");
        txtDevueltos.setBorder(null);
        txtDevueltos.setOpaque(false);
        txtDevueltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDevueltosActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel11.setText("Efectivo a entregar");

        txtTotalVentas.setEditable(false);
        txtTotalVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVentas.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtTotalVentas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalVentas.setText("0");
        txtTotalVentas.setBorder(null);
        txtTotalVentas.setOpaque(false);
        txtTotalVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalVentasActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel12.setText("Efectivo entregado");

        txtPresentado.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtPresentado.setForeground(new java.awt.Color(51, 153, 0));
        txtPresentado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPresentado.setText("0");
        txtPresentado.setEnabled(false);
        txtPresentado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresentadoActionPerformed(evt);
            }
        });
        txtPresentado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPresentadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPresentadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresentadoKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel13.setText("Diferencia");

        txtDiferencia.setEditable(false);
        txtDiferencia.setBackground(new java.awt.Color(255, 255, 255));
        txtDiferencia.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtDiferencia.setForeground(new java.awt.Color(255, 0, 0));
        txtDiferencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiferencia.setText("0");
        txtDiferencia.setBorder(null);
        txtDiferencia.setOpaque(false);
        txtDiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiferenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRecambio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDevueltos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiferencia, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPresentado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txtTotalVentas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTotal))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRecambio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDevueltos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalVentas)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtPresentado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiferencia)
                    .addComponent(jLabel13))
                .addGap(6, 6, 6))
        );

        Blanco.add(jPanel8);
        jPanel8.setBounds(924, 160, 313, 180);

        txtProducto.setEditable(false);
        txtProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtProducto.setPreferredSize(new java.awt.Dimension(7, 20));
        Blanco.add(txtProducto);
        txtProducto.setBounds(10, 218, 340, 20);

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setEnabled(false);
        txtCantidad.setPreferredSize(new java.awt.Dimension(7, 20));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });
        Blanco.add(txtCantidad);
        txtCantidad.setBounds(356, 218, 50, 20);

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(17, 35, 46));
        txtEstado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(255, 255, 255));
        txtEstado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstado.setBorder(null);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        Blanco.add(txtEstado);
        txtEstado.setBounds(924, 88, 311, 36);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setOpaque(false);

        txtFechaI.setEditable(false);
        txtFechaI.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaI.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        txtFechaI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtHoraI.setEditable(false);
        txtHoraI.setBackground(new java.awt.Color(255, 255, 255));
        txtHoraI.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        txtHoraI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Blanco.add(jPanel4);
        jPanel4.setBounds(410, 86, 152, 45);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comisiones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(27, 57, 84))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel14.setText("Responsable");

        txtComisionR.setEditable(false);
        txtComisionR.setBackground(new java.awt.Color(255, 255, 255));
        txtComisionR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtComisionR.setForeground(new java.awt.Color(255, 0, 0));
        txtComisionR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtComisionR.setText("0");
        txtComisionR.setBorder(null);
        txtComisionR.setOpaque(false);
        txtComisionR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComisionRActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel15.setText("Chofer");

        txtComisionC.setEditable(false);
        txtComisionC.setBackground(new java.awt.Color(255, 255, 255));
        txtComisionC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtComisionC.setForeground(new java.awt.Color(255, 0, 0));
        txtComisionC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtComisionC.setText("0");
        txtComisionC.setBorder(null);
        txtComisionC.setOpaque(false);
        txtComisionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComisionCActionPerformed(evt);
            }
        });

        btnRR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/billetera.png"))); // NOI18N
        btnRR.setText("RECIBO");
        btnRR.setEnabled(false);
        btnRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRRActionPerformed(evt);
            }
        });

        btnRC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/billetera.png"))); // NOI18N
        btnRC.setText("RECIBO");
        btnRC.setEnabled(false);
        btnRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtComisionR, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(txtComisionC))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRR))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRR)
                    .addComponent(txtComisionR, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRC)
                    .addComponent(txtComisionC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Blanco.add(jPanel3);
        jPanel3.setBounds(924, 524, 313, 110);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAJAS CONTENEDORAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(27, 57, 84))); // NOI18N
        jPanel9.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("Cant. Inicial");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel16.setText("Cant. Finalizar");

        txtContenedorI.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtContenedorI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContenedorI.setText("0");
        txtContenedorI.setEnabled(false);
        txtContenedorI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContenedorIActionPerformed(evt);
            }
        });
        txtContenedorI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContenedorIKeyReleased(evt);
            }
        });

        txtContenedorF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtContenedorF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContenedorF.setText("0");
        txtContenedorF.setEnabled(false);
        txtContenedorF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContenedorFKeyReleased(evt);
            }
        });

        txtContenedorD.setEditable(false);
        txtContenedorD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtContenedorD.setForeground(new java.awt.Color(205, 0, 0));
        txtContenedorD.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtValorCompra.setText("0");

        txtValorTransferencia.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtValorTransferencia)
                    .addComponent(txtValorCompra)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtContenedorD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContenedorI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContenedorF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContenedorI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContenedorF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContenedorD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtValorTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Blanco.add(jPanel9);
        jPanel9.setBounds(765, 82, 150, 160);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recorrido registrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(27, 57, 84))); // NOI18N
        jPanel10.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel17.setText("Kilometraje del reparto anterior");

        txtKmAnterior.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtKmAnterior.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtKmAnterior.setText("0");
        txtKmAnterior.setEnabled(false);
        txtKmAnterior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKmAnteriorKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel19.setText("Kilometraje del reparto actual");

        txtKmActual.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtKmActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtKmActual.setText("0");
        txtKmActual.setEnabled(false);
        txtKmActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKmActualKeyReleased(evt);
            }
        });

        txtKmRecorrido.setEditable(false);
        txtKmRecorrido.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtKmRecorrido.setForeground(new java.awt.Color(205, 0, 0));
        txtKmRecorrido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtKmRecorrido.setText("0");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel20.setText("Kilometros recorrido");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKmAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(txtKmActual)
                            .addComponent(txtKmRecorrido))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKmAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKmActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKmRecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        Blanco.add(jPanel10);
        jPanel10.setBounds(924, 400, 313, 120);

        cbCerrar.setBackground(new java.awt.Color(17, 35, 46));
        cbCerrar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbCerrar.setForeground(new java.awt.Color(255, 255, 0));
        cbCerrar.setText("CERRAR REPARTO");
        cbCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbCerrar.setEnabled(false);
        cbCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cbCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cbCerrar.setIconTextGap(10);
        cbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCerrarActionPerformed(evt);
            }
        });
        Blanco.add(cbCerrar);
        cbCerrar.setBounds(924, 124, 311, 31);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gastos Administrativos registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(27, 57, 84))); // NOI18N
        jPanel11.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel18.setText("Total del móvil");

        txtGastosTotal.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtGastosTotal.setForeground(new java.awt.Color(255, 0, 0));
        txtGastosTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtGastosTotal.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(txtGastosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGastosTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        Blanco.add(jPanel11);
        jPanel11.setBounds(924, 340, 313, 57);

        MnOpcionesReparto.setText("Opciones");
        MnOpcionesReparto.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        MnOpcionesReparto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        itemModificar.setText("Guardar Modificación");
        itemModificar.setEnabled(false);
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemModificar);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        itemGuardar.setText("Guardar Nuevo");
        itemGuardar.setEnabled(false);
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemGuardar);

        itemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        itemCancelar.setText("Cancelar");
        itemCancelar.setEnabled(false);
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemCancelar);
        MnOpcionesReparto.add(jSeparator1);

        itemBuscarArticulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        itemBuscarArticulo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemBuscarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search20.png"))); // NOI18N
        itemBuscarArticulo.setText("Agregar producto");
        itemBuscarArticulo.setEnabled(false);
        itemBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarArticuloActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemBuscarArticulo);

        itemQuitar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemQuitar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vcsremoved_93492 - copia.png"))); // NOI18N
        itemQuitar.setText("Quitar producto");
        itemQuitar.setEnabled(false);
        itemQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitarActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemQuitar);
        MnOpcionesReparto.add(jSeparator3);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        MnOpcionesReparto.add(itemSalir);

        jMenuBar1.add(MnOpcionesReparto);

        MnImprimirReparto.setText("Imprimir");
        MnImprimirReparto.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        MnImprimirReparto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemHojaApunte.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemHojaApunte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itemHojaApunte.setText("Hoja de apunte");
        itemHojaApunte.setEnabled(false);
        itemHojaApunte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHojaApunteActionPerformed(evt);
            }
        });
        MnImprimirReparto.add(itemHojaApunte);

        itemHojaR.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemHojaR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itemHojaR.setText("Hoja de reparto consolidado Completo");
        itemHojaR.setEnabled(false);
        itemHojaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHojaRActionPerformed(evt);
            }
        });
        MnImprimirReparto.add(itemHojaR);

        itemHojaR1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemHojaR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itemHojaR1.setText("Hoja de reparto consolidado Simple");
        itemHojaR1.setEnabled(false);
        itemHojaR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHojaR1ActionPerformed(evt);
            }
        });
        MnImprimirReparto.add(itemHojaR1);

        jMenuBar1.add(MnImprimirReparto);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
        if (txtCantidad.getText().isEmpty()) {
            txtCantidad.requestFocus();
        } else {
            btnAdd.doClick();
        }
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnCompraAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraAActionPerformed
        // TODO add your handling code here:
        if (cboResponsable.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un responsable para filtrar las compras del día");
        } else {
            try {
                dlgConsultarCompras1 consCompras = new dlgConsultarCompras1(null, true);
                consCompras.setLocationRelativeTo(null);
                consCompras.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("Servidor no esta activo");
            }
        }

    }//GEN-LAST:event_btnCompraAActionPerformed

    private void btnCargarRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarRAActionPerformed
        // TODO add your handling code here
        if (cboResponsable.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un responsable para filtrar el reparto anterior");
        } else {
            try {
                dlgConsultarRepartoAnterior consReparto = new dlgConsultarRepartoAnterior(null, true);
                consReparto.setLocationRelativeTo(null);
                consReparto.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("Servidor no esta activo");
            }
        }

    }//GEN-LAST:event_btnCargarRAActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlReparto.array.vaciar();

            this.dispose();
            Volver();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cancelar esta operación?");
        if (rpta == 0) {
            controlReparto.array.vaciar();
            limpiarCampos();
            btnNuevo.setEnabled(true);
            itemNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            itemModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            itemGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            itemCancelar.setEnabled(false);
            itemQuitar.setEnabled(false);
            btnSalir.setEnabled(true);
            itemSalir.setEnabled(true);
            itemHojaR.setEnabled(false);
            itemHojaR1.setEnabled(false);
            btnCargarRA.setEnabled(false);
            btnCompraA.setEnabled(false);
            btnRC.setEnabled(false);
            btnRR.setEnabled(false);
            txtContenedorI.setEnabled(false);
            txtContenedorF.setEnabled(false);
            txtPresentado.setEnabled(false);
            txtKmAnterior.setEnabled(false);
            txtKmActual.setEnabled(false);
            btnCargarTransferencias.setEnabled(false);
            cboResponsable.setEnabled(false);
            chAgregar.setEnabled(false);
            cbCerrar.setEnabled(false);
            rdCargaT.setEnabled(false);
            rdRecambios.setEnabled(false);
            rdDevueltos.setEnabled(false);
            tbDetalleReparto.setEnabled(false);
            this.dispose();
            Volver();

        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String cod = GestionarReparto.getCodigoReparto();
        txtIdReparto.setText(cod);
        if (cboResponsable.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione el responsable de este reparto");
            cboResponsable.requestFocus();
            cboResponsable.setPopupVisible(true);
        } else if (tbDetalleReparto.getRowCount() == 0) {
            Mensajes.informacion("El reparto no puede guardarse vacío.\nFavor cargue los productos que estaran disponibles para la venta");
            btnCargarRA.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        String usuario = UsuarioL = Login.getUsuarioLogueado();
                        prepararBD();
                        con.setAutoCommit(false);
                        int totalCo = Integer.parseInt(txtComisionR.getText().replace(".", "").replace(",", "")) + Integer.parseInt(txtComisionC.getText().replace(".", "").replace(",", ""));
                        String sql = "insert into reparto values(" + txtIdReparto.getText() + "," + txtCaja.getText() + "," + txtIdResponsable.getText() + "," + lbComR.getText().trim()
                                + "," + txtIdMovil.getText().trim() + ",'" + txtMovil.getText() + "'," + txtIdChofer.getText().trim() + ", '" + txtChofer.getText() + "'," + lbComC.getText().trim()
                                + ",'" + txtFechaIF.getText() + "','" + txtHoraI.getText() + "'," + txtValorRA.getText() + "," + txtValorCompra.getText() + "," + txtValorTransferencia.getText() + "," + txtTotalL.getText()
                                + "," + txtRecambioL.getText() + "," + txtDevueltosL.getText() + "," + txtTotalVentasL.getText() + "," + txtPresentadoL.getText()
                                + "," + txtDiferenciaL.getText() + "," + txtContenedorI.getText() + "," + txtContenedorF.getText() + "," + txtGastosTotal.getText().trim().replace(".", "").replace(",", "") + "," + totalCo + "," + txtKmAnterior.getText() + "," + txtKmActual.getText() + "," + txtKmRecorrido.getText()
                                + ",'S','N','" + usuario + "')";
                        String sql2 = "INSERT INTO comisiones (idreparto,idcaja,idvendedor,fecha,monto,comision,totalComision,usuario,estado)"
                                + "VALUES(" + txtIdReparto.getText() + "," + txtCaja.getText() + "," + txtIdResponsable.getText() + ",'" + txtFechaIF.getText() + "'," + txtPresentadoL.getText()
                                + "," + lbComR.getText() + "," + txtComisionR.getText().replace(".", "").replace(",", "") + ",'" + usuario + "','S'" + ")";
                        String sql3 = "INSERT INTO comisiones (idreparto,idcaja,idvendedor,fecha,monto,comision,totalComision,usuario,estado)"
                                + "VALUES(" + txtIdReparto.getText() + "," + txtCaja.getText() + "," + txtIdChofer.getText() + ",'" + txtFechaIF.getText() + "'," + txtPresentadoL.getText()
                                + "," + lbComC.getText() + "," + txtComisionC.getText().replace(".", "").replace(",", "") + ",'" + usuario + "','S'" + ")";
                        stTransaccion.executeUpdate(sql);
                        stTransaccion.executeUpdate(sql2);
                        stTransaccion.executeUpdate(sql3);
                        int fila = tbDetalleReparto.getRowCount();
                        for (int j = 0; j < fila; j++) {
                            String filas[] = {
                                tbDetalleReparto.getValueAt(j, 0).toString(),//0

                                tbDetalleReparto.getValueAt(j, 4).toString(),//1
                                tbDetalleReparto.getValueAt(j, 5).toString(),//2
                                tbDetalleReparto.getValueAt(j, 6).toString(),//3

                                tbDetalleReparto.getValueAt(j, 7).toString(),//4
                                tbDetalleReparto.getValueAt(j, 8).toString(),//5
                                tbDetalleReparto.getValueAt(j, 9).toString(),//6
                                tbDetalleReparto.getValueAt(j, 10).toString(),//7
                                tbDetalleReparto.getValueAt(j, 11).toString(),//8
                                tbDetalleReparto.getValueAt(j, 12).toString(),//9
                                tbDetalleReparto.getValueAt(j, 13).toString(),//10
                                tbDetalleReparto.getValueAt(j, 14).toString(),//11
                                tbDetalleReparto.getValueAt(j, 15).toString()};//12
                            sql = "insert into detalle_reparto values(" + txtIdReparto.getText() + "," + filas[0] + "," + filas[1]
                                    + "," + filas[2] + "," + filas[3] + "," + filas[4] + "," + filas[5] + "," + filas[6] + "," + filas[7]
                                    + "," + filas[8] + "," + filas[9] + "," + filas[10] + "," + filas[11] + "," + filas[12] + ")";
                            //String sql2 = "UPDATE productos SET precio_costo=" + filas[2] + ", ganancia=" + filas[4] + " WHERE  idproducto=" + filas[0];
                            stTransaccion.executeUpdate(sql);
                            //stTransaccionMovil.executeUpdate(sql2);
                        }
                        con.commit();
                        stTransaccion.close();
                        Mensajes.informacion("El reparto ha sido regitrada exitosamente");
                    } catch (SQLException e) {
                        try {
                            con.rollback();
                            Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage().toUpperCase());
                        } catch (SQLException se) {
                            Mensajes.error(se.getMessage());
                        }
                    }
                    Cancelar();
                    cant();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int cod = Integer.parseInt(txtIdReparto.getText().trim());
        String cerrado;
        if (cbCerrar.isSelected()) {
            cerrado = "S";
        } else {
            cerrado = "N";
        }
        try {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea aplicar cambios al contenido de este reparto?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    String usuario = UsuarioL = Login.getUsuarioLogueado();
                    prepararBD();
                    con.setAutoCommit(false);
                    int totalCo = Integer.parseInt(txtComisionR.getText().replace(".", "").replace(",", "")) + Integer.parseInt(txtComisionC.getText().replace(".", "").replace(",", ""));
                    String sql = "UPDATE reparto SET valor_recambio=" + txtRecambioL.getText() + ", valor_devuelto=" + txtDevueltosL.getText() + ", efectivo_entregar=" + txtTotalVentasL.getText() + ", efectivo_entregado=" + txtPresentadoL.getText()
                            + ", diferencia=" + txtDiferenciaL.getText() + ", recolector_inicio=" + txtContenedorI.getText() + ", recolector_fin=" + txtContenedorF.getText() + ", gasto_reparto=" + txtGastosTotal.getText().replace(".", "").replace(",", "") + ", comision_reparto=" + totalCo
                            + ", km_anterior=" + txtKmAnterior.getText() + ", km_actual=" + txtKmActual.getText() + ", km_recorrido=" + txtKmRecorrido.getText() + ", cerrado='" + cerrado + "', usuario='" + usuario + "' "
                            + "WHERE id_reparto=" + cod;

                    String sql2 = "UPDATE comisiones SET monto=" + txtPresentadoL.getText() + ",comision=" + lbComR.getText() + ",totalcomision=" + txtComisionR.getText().replace(".", "").replace(",", "") + ",usuario='" + usuario + "'"
                            + " WHERE idreparto=" + txtIdReparto.getText() + " AND idvendedor=" + txtIdResponsable.getText();

                    String sql3 = "UPDATE comisiones SET monto=" + txtPresentadoL.getText() + ",comision=" + lbComC.getText() + ",totalcomision=" + txtComisionC.getText().replace(".", "").replace(",", "") + ",usuario='" + usuario + "'"
                            + " WHERE idreparto=" + txtIdReparto.getText() + " AND idvendedor=" + txtIdChofer.getText();
                    stTransaccion.executeUpdate(sql);
                    stTransaccion.executeUpdate(sql2);
                    stTransaccion.executeUpdate(sql3);
                    int fila = tbDetalleReparto.getRowCount();
                    for (int j = 0; j < fila; j++) {
                        String filas[] = {
                            tbDetalleReparto.getValueAt(j, 0).toString(),//0
                            tbDetalleReparto.getValueAt(j, 9).toString(),//1
                            tbDetalleReparto.getValueAt(j, 10).toString(),//2
                            tbDetalleReparto.getValueAt(j, 11).toString(),//3
                            tbDetalleReparto.getValueAt(j, 12).toString(),//4
                            tbDetalleReparto.getValueAt(j, 13).toString(),//5
                            tbDetalleReparto.getValueAt(j, 14).toString(),//6
                            tbDetalleReparto.getValueAt(j, 15).toString()};//7
                        sql = "UPDATE detalle_reparto SET recambio=" + filas[1] + ", monto_recambio=" + filas[2] + ", venta=" + filas[3] + ", monto_venta=" + filas[4]
                                + ", monto_costo=" + filas[5] + ", devuelve=" + filas[6] + ", monto_devuelve=" + filas[7] + " WHERE idreparto=" + cod + " AND idproducto=" + filas[0];
                        stTransaccion.executeUpdate(sql);
                    }
                    con.commit();
                    stTransaccion.close();
                    Mensajes.informacion("Las modificaciones fueron aplicadas exitosamente");
                    if (cerrado.equals("S")) {
                        txtEstado.setText("REPARTO CERRADO");
                    }
                } catch (SQLException e) {
                    try {
                        con.rollback();
                        Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage().toUpperCase());
                    } catch (SQLException se) {
                        Mensajes.error(se.getMessage());
                    }
                }
                Cancelar();
                cant();
            }
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        //limpiarCampos();
        //Cancelar();
        String cod = GestionarReparto.getCodigoReparto();
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.ObtenerCodigo("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cargarComboBox.cargarResponsable(cboResponsable, "SELECT * FROM v_vendedores WHERE idfuncion=2 AND ven_indicador='S'");
        txtIdReparto.setText(cod);
        txtFechaI.setText(Fecha.fechaCorrectaFachada());
        txtFechaIF.setText(Fecha.fechaCorrecta());
        txtHoraI.setText(Fecha.darHoraSinSS());
        txtEstado.setText("INICIALIZANDO REPARTO");
        //
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        itemSalir.setEnabled(false);
        itemBuscarArticulo.setEnabled(false);
        itemQuitar.setEnabled(true);
        //
        cboResponsable.setEnabled(true);
        btnCargarRA.setEnabled(true);
        btnCompraA.setEnabled(true);
        btnCargarTransferencias.setEnabled(true);
        chAgregar.setEnabled(true);
        //txtIdReparto.setEnabled(false);
        txtContenedorI.setEnabled(true);
        txtKmAnterior.setEnabled(true);
        //
        tbDetalleReparto.setEnabled(true);
        cboResponsable.requestFocus();
        //cboResponsable.setPopupVisible(true);
        opcion = "N";
        System.out.println(UsuarioL = Login.getUsuarioLogueado());
        cant();
        calcularCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloReparto bac = new dlgBuscarArticuloReparto(null, true);
            bac.setLocationRelativeTo(null);
            switch (txtOpcion.getText().trim()) {
                case "C" ->
                    bac.tituloOperacion("GESTIÓN - CARGA TOTAL");
                case "R" ->
                    bac.tituloOperacion("GESTIÓN - RECAMBIOS");
                case "D" ->
                    bac.tituloOperacion("GESTIÓN - DEVUELTOS");
                default -> {
                }
            }
            bac.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void cboResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboResponsableActionPerformed
        // TODO add your handling code here:
        if (opcion.equals("N")) {
            if (cboResponsable.getSelectedIndex() == 0) {
                txtIdMovil.setText("");
                lbInfoChofer.setText("");
                lbInfoMovil.setText("");
                lbComC.setText("");
                lbComR.setText("");

                txtResponsable.setText("");
                txtChofer.setText("");
                txtMovil.setText("");
                txtIdChofer.setText("");
            } else {
                txtResponsable.setText(cboResponsable.getSelectedItem().toString());
                prepararBD();
                try {
                    String resp;
                    resp = cargarComboBox.getCodidgo(cboResponsable);
                    try {
                        rs = sentencia.executeQuery("SELECT ven_codigo,idmovil, movil, ven_comision FROM v_vendedores WHERE ven_codigo=" + resp);
                        rs.last();
                        txtIdResponsable.setText(String.valueOf(rs.getInt("ven_codigo")));
                        txtIdMovil.setText(String.valueOf(rs.getInt("idmovil")));
                        lbInfoMovil.setText(" Referencia: " + rs.getString("movil"));
                        txtMovil.setText(rs.getString("movil"));
                        lbComR.setText(String.valueOf(rs.getDouble("ven_comision")));
                        rs.close();
                    } catch (SQLException ex) {
                        Mensajes.error("Error al querer obtener ID del móvil: " + ex.getMessage());
                    }
                } catch (Exception pr) {
                }
                try {
                    String idm;
                    idm = txtIdMovil.getText();
                    try {
                        rs = sentencia.executeQuery("SELECT ven_codigo,ven_nombre, ven_comision FROM v_vendedores WHERE idmovil=" + idm + " AND idfuncion=1");
                        rs.last();
                        lbInfoChofer.setText(" Chofer: " + rs.getString("ven_nombre"));
                        txtIdChofer.setText(rs.getString("ven_codigo"));
                        txtChofer.setText(rs.getString("ven_nombre"));
                        lbComC.setText(String.valueOf(rs.getDouble("ven_comision")));
                        rs.close();
                    } catch (SQLException ex) {
                        Mensajes.error("Error al querer obtener valor del chofer: " + ex.getMessage());
                    }
                } catch (Exception pr) {
                }

                try {
                    String idm;
                    idm = txtIdMovil.getText();
                    try {
                        rs = sentencia.executeQuery("SELECT SUM(ga_importe) AS total FROM gastos WHERE ga_idmovil=" + idm + " AND caja_ca_id=" + txtCaja.getText().trim() + " AND ga_indicador='S' AND tipo='A'");
                        rs.last();
                        if (rs.getString("total") == null) {
                            txtGastosTotal.setText("0");
                        } else {
                            DecimalFormat df = new DecimalFormat("#,###");
                            txtGastosTotal.setText(df.format(Integer.parseInt(String.valueOf(rs.getString("total")).replace(".", "").replace(",", ""))));
                        }
                        rs.close();
                    } catch (SQLException ex) {
                        Mensajes.error("Error al querer obtener valor del gasto: " + ex.getMessage());
                    }
                } catch (Exception pr) {
                }
            }
        }
    }//GEN-LAST:event_cboResponsableActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        btnGuardarActionPerformed(null);
    }//GEN-LAST:event_itemGuardarActionPerformed

    private void itemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_itemCancelarActionPerformed

    private void itemBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarArticuloActionPerformed
        // TODO add your handling code here:
        btnBuscarArticulo.doClick();
    }//GEN-LAST:event_itemBuscarArticuloActionPerformed

    private void itemQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitarActionPerformed
        // TODO add your handling code here:S
        btnRestar.doClick();
    }//GEN-LAST:event_itemQuitarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        switch (txtOpcion.getText()) {
            case "C" -> {
                controlReparto.addTabla(tbDetalleReparto);
                txtProducto.setText("");
                txtCantidad.setText("");
                txtCodArticulo.setText("");
                habilitarCANT();
                cant();
                calcularDiferencia();
                Renders();
                btnBuscarArticuloActionPerformed(null);
            }
            case "R" -> {
                controlReparto.addTablaRecabios(tbDetalleReparto);
                txtProducto.setText("");
                txtCantidad.setText("");
                txtCodArticulo.setText("");
                habilitarCANT();
                cant();
                calcularDiferencia();
                Renders();
                btnBuscarArticuloActionPerformed(null);
            }
            case "D" -> {
                controlReparto.addTablaDevueltos(tbDetalleReparto);
                txtProducto.setText("");
                txtCantidad.setText("");
                txtCodArticulo.setText("");
                habilitarCANT();
                cant();
                calcularDiferencia();
                Renders();
                btnBuscarArticuloActionPerformed(null);
            }
            default -> {
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtCantidad);
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void cboResponsableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboResponsableKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCargarRA.doClick();
        }
    }//GEN-LAST:event_cboResponsableKeyPressed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnCargarTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTransferenciasActionPerformed
        // TODO add your handling code here:
        if (cboResponsable.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un responsable para filtrar las trasferencia realizada");
        } else {
            try {
                dlgConsultarTransferencia consT = new dlgConsultarTransferencia(null, true);
                consT.setLocationRelativeTo(null);
                consT.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("Servidor no esta activo");
            }
        }
    }//GEN-LAST:event_btnCargarTransferenciasActionPerformed

    private void chAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chAgregarActionPerformed
        // TODO add your handling code here:
        if (chAgregar.isSelected()) {
            if (opcion.equals("N")) {
                rdCargaT.setEnabled(true);
                rdCargaT.setSelected(true);
                txtOpcion.setText("C");
                rdDevueltos.setEnabled(false);
                rdRecambios.setEnabled(false);
                btnBuscarArticulo.setEnabled(true);
                btnBuscarArticulo.doClick();

            } else if (opcion.equals("M")) {
                rdCargaT.setEnabled(false);
                rdDevueltos.setEnabled(true);
                txtOpcion.setText("D");
                rdRecambios.setEnabled(true);
                btnBuscarArticulo.setEnabled(true);
                btnBuscarArticulo.doClick();
            }
            itemBuscarArticulo.setEnabled(true);

        } else {
            rdCargaT.setEnabled(false);
            rdDevueltos.setSelected(true);
            txtOpcion.setText("");
            rdDevueltos.setEnabled(false);
            rdRecambios.setEnabled(false);
            btnBuscarArticulo.setEnabled(false);
            itemBuscarArticulo.setEnabled(false);
        }

    }//GEN-LAST:event_chAgregarActionPerformed

    private void rdCargaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCargaTActionPerformed
        // TODO add your handling code here:
        txtOpcion.setText("C");
        btnBuscarArticuloActionPerformed(null);
    }//GEN-LAST:event_rdCargaTActionPerformed

    private void rdRecambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRecambiosActionPerformed
        // TODO add your handling code here:
        txtOpcion.setText("R");
        btnBuscarArticuloActionPerformed(null);
    }//GEN-LAST:event_rdRecambiosActionPerformed

    private void rdDevueltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDevueltosActionPerformed
        // TODO add your handling code here:
        txtOpcion.setText("D");
        btnBuscarArticuloActionPerformed(null);
    }//GEN-LAST:event_rdDevueltosActionPerformed

    private void txtRecambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecambioActionPerformed

    private void txtDevueltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDevueltosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDevueltosActionPerformed

    private void txtTotalVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalVentasActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlReparto.delRenglon(tbDetalleReparto);
            cant();
            calcularDiferencia();
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtComisionRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComisionRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComisionRActionPerformed

    private void txtComisionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComisionCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComisionCActionPerformed

    private void txtPresentadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentadoKeyPressed
        // TODO add your handling code here:
        if (!txtPresentado.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPresentado);
        }
    }//GEN-LAST:event_txtPresentadoKeyPressed

    private void txtPresentadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentadoKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtPresentado.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPresentadoKeyTyped

    private void txtPresentadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentadoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPresentado.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPresentado.setText(df.format(Integer.valueOf(txtPresentado.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPresentado.setText("0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        if (txtPresentado.getText().equals("")) {
            txtPresentado.setText("0");
        } else {
            DecimalFormat dff = new DecimalFormat("#0");
            txtPresentadoL.setText(dff.format(Integer.valueOf(txtPresentado.getText().trim().replace(".", "").replace(",", ""))));
        }
        calcularComisiones();
        calcularDiferencia();
    }//GEN-LAST:event_txtPresentadoKeyReleased

    private void txtDiferenciaLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiferenciaLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiferenciaLActionPerformed

    private void txtContenedorIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenedorIKeyReleased
        // TODO add your handling code here:
        calcularCajas();
    }//GEN-LAST:event_txtContenedorIKeyReleased

    private void txtContenedorFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenedorFKeyReleased
        // TODO add your handling code here:
        calcularCajas();
    }//GEN-LAST:event_txtContenedorFKeyReleased

    private void txtDiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiferenciaActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtIdRepartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRepartoActionPerformed
        // TODO add your handling code here:
        /*   if (!txtIdReparto.getText().isEmpty()) {
            opcion = "M";
            controlReparto.array.vaciar();
            CabecerasTablas.limpiarTablasRepartos(tbDetalleReparto);
            controlReparto.aModifcar();
            calcularComisiones();
            controlReparto.listarDetalleReparto_A_Modificar(tbDetalleReparto);
            Renders();
        } else {
            Cancelar();
        }*/

    }//GEN-LAST:event_txtIdRepartoActionPerformed

    private void txtIdResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdResponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdResponsableActionPerformed

    private void txtFechaIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIFActionPerformed

    private void txtContenedorIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContenedorIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContenedorIActionPerformed

    private void txtPresentadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresentadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentadoActionPerformed

    private void cbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCerrarActionPerformed
        // TODO add your handling code here:
        if (cbCerrar.isSelected()) {
            Mensajes.informacion("Con esta acción se dara por finalizada toda operación del reparto."
                    + "\nSe consolidaran los datos para los respectivos reportes.");
        }
    }//GEN-LAST:event_cbCerrarActionPerformed

    private void itemHojaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHojaRActionPerformed
        // TODO add your handling code here:

        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\repartos\\movimiento_reparto.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("id_reparto", Integer.parseInt(txtIdReparto.getText().trim()));
            parametros.put("estado", txtEstado.getText());
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
    }//GEN-LAST:event_itemHojaRActionPerformed

    private void itemHojaApunteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHojaApunteActionPerformed
        // TODO add your handling code here:
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\repartos\\Hoja_reparto.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("id_reparto", Integer.parseInt(txtIdReparto.getText().trim()));
            parametros.put("estado", txtEstado.getText());
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
    }//GEN-LAST:event_itemHojaApunteActionPerformed

    private void btnRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRRActionPerformed
        // TODO add your handling code here:
        String letras = d.Convertir(txtComisionR.getText().replace(".", "").replace(",", ""), true);
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\repartos\\reciboDinero.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("idreparto", Integer.parseInt(txtIdReparto.getText().trim()));
            parametros.put("idvendedor", Integer.parseInt(txtIdResponsable.getText().trim()));
            parametros.put("Letras", letras);
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
    }//GEN-LAST:event_btnRRActionPerformed

    private void btnRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRCActionPerformed

        String letras = d.Convertir(txtComisionC.getText().replace(".", "").replace(",", ""), true);
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\repartos\\reciboDinero.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("idreparto", Integer.parseInt(txtIdReparto.getText().trim()));
            parametros.put("idvendedor", Integer.parseInt(txtIdChofer.getText().trim()));
            parametros.put("Letras", letras);
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
    }//GEN-LAST:event_btnRCActionPerformed

    private void txtKmAnteriorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKmAnteriorKeyReleased
        // TODO add your handling code here:
        calcularKilometraje();
    }//GEN-LAST:event_txtKmAnteriorKeyReleased

    private void txtKmActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKmActualKeyReleased
        // TODO add your handling code here:
        calcularKilometraje();
    }//GEN-LAST:event_txtKmActualKeyReleased

    private void txtValorRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorRAActionPerformed

    private void itemHojaR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHojaR1ActionPerformed
        VisorReportes vr = new VisorReportes(null, true);
        try {
            //archivo jasper
            //URL  jasperUrl = this.getClass().getResource("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\repartos\\movimiento_reparto_E.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("id_reparto", Integer.parseInt(txtIdReparto.getText().trim()));
            parametros.put("estado", txtEstado.getText());
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
    }//GEN-LAST:event_itemHojaR1ActionPerformed

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
            java.util.logging.Logger.getLogger(dlgGestRepartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgGestRepartos dialog = new dlgGestRepartos(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenu MnImprimirReparto;
    private javax.swing.JMenu MnOpcionesReparto;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private javax.swing.JButton btnAdd;
    public static javax.swing.JButton btnBuscarArticulo;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnCargarRA;
    public static javax.swing.JButton btnCargarTransferencias;
    public static javax.swing.JButton btnCompraA;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnRC;
    public static javax.swing.JButton btnRR;
    private javax.swing.JButton btnRestar;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JCheckBox cbCerrar;
    public static javax.swing.JComboBox<String> cboResponsable;
    public static javax.swing.JCheckBox chAgregar;
    private javax.swing.ButtonGroup grupoCargado;
    private javax.swing.ButtonGroup grupoOpciones;
    public static javax.swing.JMenuItem itemBuscarArticulo;
    public static javax.swing.JMenuItem itemCancelar;
    public static javax.swing.JMenuItem itemGuardar;
    public static javax.swing.JMenuItem itemHojaApunte;
    public static javax.swing.JMenuItem itemHojaR;
    public static javax.swing.JMenuItem itemHojaR1;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    public static javax.swing.JMenuItem itemQuitar;
    public static javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JLabel lbComC;
    public static javax.swing.JLabel lbComR;
    public static javax.swing.JLabel lbInfoCantidad;
    public static javax.swing.JLabel lbInfoChofer;
    public static javax.swing.JLabel lbInfoMovil;
    public static javax.swing.JRadioButton rdCargaT;
    public static javax.swing.JRadioButton rdDevueltos;
    public static javax.swing.JRadioButton rdRecambios;
    public static final javax.swing.JTable tbDetalleReparto = new javax.swing.JTable();
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtChofer;
    public static javax.swing.JTextField txtCodArticulo;
    public static javax.swing.JTextField txtComisionC;
    public static javax.swing.JTextField txtComisionR;
    public static javax.swing.JTextField txtContenedorD;
    public static javax.swing.JTextField txtContenedorF;
    public static javax.swing.JTextField txtContenedorI;
    public static javax.swing.JTextField txtDevueltos;
    public static javax.swing.JTextField txtDevueltosL;
    public static javax.swing.JTextField txtDiferencia;
    public static javax.swing.JTextField txtDiferenciaL;
    public static javax.swing.JTextField txtEstado;
    public static javax.swing.JTextField txtFechaI;
    public static javax.swing.JTextField txtFechaIF;
    public static javax.swing.JLabel txtGastosTotal;
    public static javax.swing.JTextField txtHoraI;
    public static javax.swing.JTextField txtIdChofer;
    public static javax.swing.JTextField txtIdMovil;
    public static javax.swing.JTextField txtIdReparto;
    public static javax.swing.JTextField txtIdResponsable;
    public static javax.swing.JTextField txtKmActual;
    public static javax.swing.JTextField txtKmAnterior;
    public static javax.swing.JTextField txtKmRecorrido;
    public static javax.swing.JTextField txtMovil;
    public static javax.swing.JTextField txtOpcion;
    public static javax.swing.JTextField txtPresentado;
    public static javax.swing.JTextField txtPresentadoL;
    public static javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtRecambio;
    public static javax.swing.JTextField txtRecambioL;
    public static javax.swing.JTextField txtResponsable;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalL;
    public static javax.swing.JTextField txtTotalVentas;
    public static javax.swing.JTextField txtTotalVentasL;
    public static javax.swing.JTextField txtValorCompra;
    public static javax.swing.JTextField txtValorRA;
    public static javax.swing.JTextField txtValorTransferencia;
    // End of variables declaration//GEN-END:variables

}
