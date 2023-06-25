package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.ReporteMovil;
import Componentes.Mensajes;
import Componentes.Reloj;
import Componentes.Software;
import static Componentes.URL.urlServer;
import Componentes.generarCodigos;
import Componentes.traerIP;
import Controladores.ControlLogeo;
import Datos.GestionarImagen;
import Modelo.Imagen;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public final class frmPrincipal extends javax.swing.JFrame {

    public ReporteMovil jasper;

    public frmPrincipal() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);

        try {
            lbIp.setText("DIRECCIÓN IP : " + traerIP.getIP());
        } catch (Exception e) {
        }
        titulo();
        Iniciar();
        cargarIcono();
        cargarTapiz();
        informacionGral();
        lbversion.setText(Software.getVersion());

    }

    void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Ventana principal");
        } else {
            this.setTitle("Ventana principal del sistema " + Software.getSoftware() + " - " + Software.getDescripcion());
        }
        if (Software.getVersion().equals("null")) {
            lbversion.setText("©: No disponible");
        } else {
            lbversion.setText(Software.getVersion());
        }
    }

    private void Iniciar() {
        Reloj hilo = new Reloj(lblFecha);
        hilo.start();
    }

    void cargarTapiz() {
        try {
            Imagen imagen = GestionarImagen.fondoPrincipal();
            String nombre = "/Recursos/" + imagen.getImgFondo();
            ((JPanelConFondo) panelFondo).setImagen(nombre);
        } catch (Exception e) {
            Mensajes.informacion("Error al cargar Fondo del Sistema.");
        }
    }

    public void informacionGral() {
        try {
            URL url = new URL(urlServer() + "getInformacionGeneral.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int ResponseCod = conn.getResponseCode();

            if (ResponseCod != 200) {
                throw new RuntimeException("Ocurrio un error: " + ResponseCod);
            } else {
                StringBuilder informacionG = new StringBuilder();
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    informacionG.append(scan.nextLine());
                }
                scan.close();

                JSONArray jsonIG = new JSONArray(informacionG.toString());
                if (jsonIG.length() != 0) {
                    JSONObject objectIG = jsonIG.getJSONObject(0);

                    lbEmpresa.setText(objectIG.getString("razon_social"));
                    lbRuc.setText(objectIG.getString("ruc"));
                    lbSucursal.setText(objectIG.getString("suc_nombre"));
                } else {
                    lbEmpresa.setText("SIN ESPECIFICAR");
                    lbRuc.setText("SIN ESPECIFICAR");
                    lbSucursal.setText("SIN ESPECIFICAR");
                }
            }
        } catch (IOException | RuntimeException e) {
            Mensajes.error("err_informacion_general: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelFondo = new JPanelConFondo();
        btnClientes = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnGestionarVentasMovil = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnVentaLocal = new javax.swing.JButton();
        btnVender1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSucursal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbRuc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel13 = new javax.swing.JLabel();
        lbversion = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel15 = new javax.swing.JLabel();
        lbIp = new javax.swing.JLabel();
        btnSalir = new RSMaterialComponent.RSButtonMaterialIconUno();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        mbBarraMenu = new javax.swing.JMenuBar();
        mnSistema = new javax.swing.JMenu();
        itemFondo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem52 = new javax.swing.JMenuItem();
        mnCalc = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnCerrarSistema = new javax.swing.JMenuItem();
        mnConfiguracion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnMantenimiento = new javax.swing.JMenu();
        mnInformacion = new javax.swing.JMenu();
        itemEmpresa = new javax.swing.JMenuItem();
        itemSucursal = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        mnGTimbradoM = new javax.swing.JMenuItem();
        mnGPuntoEmisionM = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        mnGCiudadM = new javax.swing.JMenuItem();
        mnGClasificacionM = new javax.swing.JMenuItem();
        mnGUMM = new javax.swing.JMenuItem();
        mnGImpuestoM = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        S1 = new javax.swing.JPopupMenu.Separator();
        mnLogistica = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnEmpleados = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        S2 = new javax.swing.JPopupMenu.Separator();
        mnComision = new javax.swing.JMenuItem();
        mnProveedores = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnClientes = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        rpClientes = new javax.swing.JMenu();
        mnGProductosM2 = new javax.swing.JMenuItem();
        S3 = new javax.swing.JPopupMenu.Separator();
        mnSeguridad = new javax.swing.JMenu();
        smModUsuarios = new javax.swing.JMenuItem();
        smModUsuariosD = new javax.swing.JMenuItem();
        S4 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        itemImportar = new javax.swing.JMenuItem();
        divisor3 = new javax.swing.JMenu();
        mnCaja = new javax.swing.JMenu();
        mnIniciarCaja = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        mnCierredeCaja = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        rpVendedores1 = new javax.swing.JMenu();
        itemTVentasv1 = new javax.swing.JMenuItem();
        itemTVentasv = new javax.swing.JMenuItem();
        divisor4 = new javax.swing.JMenu();
        mnGsIn = new javax.swing.JMenu();
        mnIngresosVarios = new javax.swing.JMenuItem();
        mnIngresosVarios1 = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        mnGestGastos = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        rpVendedores2 = new javax.swing.JMenu();
        itemRGL = new javax.swing.JMenuItem();
        itemRGR = new javax.swing.JMenuItem();
        itemRGA = new javax.swing.JMenuItem();
        divisor5 = new javax.swing.JMenu();
        mnProductos = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        rpArticulos = new javax.swing.JMenu();
        mnGProductosM1 = new javax.swing.JMenuItem();
        mnGProductosM3 = new javax.swing.JMenuItem();
        mnGProductosM4 = new javax.swing.JMenuItem();
        jSeparator34 = new javax.swing.JPopupMenu.Separator();
        mnGProductosM6 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        mnGProductosM5 = new javax.swing.JMenuItem();
        mnCompras = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnGC = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        mnGC1 = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        rpCompras = new javax.swing.JMenu();
        jMenuItem65 = new javax.swing.JMenuItem();
        mnVentas1 = new javax.swing.JMenu();
        mnVentas = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnGV = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        mnGC2 = new javax.swing.JMenuItem();
        jSeparator36 = new javax.swing.JPopupMenu.Separator();
        mnGV1 = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        mnVentasMovil = new javax.swing.JMenu();
        mnGVM1 = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        rpVentas = new javax.swing.JMenu();
        jMenuItem64 = new javax.swing.JMenuItem();
        jSeparator31 = new javax.swing.JPopupMenu.Separator();
        mnGVE = new javax.swing.JMenuItem();
        mnAyuda2 = new javax.swing.JMenu();
        mnAyuda4 = new javax.swing.JMenu();
        mnGNCVenta3 = new javax.swing.JMenuItem();
        jSeparator35 = new javax.swing.JPopupMenu.Separator();
        mnGNCVenta4 = new javax.swing.JMenuItem();
        jSeparator33 = new javax.swing.JPopupMenu.Separator();
        mnPagoProveedor = new javax.swing.JMenuItem();
        jSeparator30 = new javax.swing.JPopupMenu.Separator();
        mnAyuda5 = new javax.swing.JMenu();
        mnGNCVenta = new javax.swing.JMenuItem();
        jSeparator29 = new javax.swing.JPopupMenu.Separator();
        mnGNCVenta1 = new javax.swing.JMenuItem();
        mnAyuda3 = new javax.swing.JMenu();
        mnNCProveedor = new javax.swing.JMenuItem();
        jSeparator32 = new javax.swing.JPopupMenu.Separator();
        mnGNCVenta2 = new javax.swing.JMenuItem();
        mnTransferencias = new javax.swing.JMenu();
        itemGestionarTR = new javax.swing.JMenuItem();
        S8 = new javax.swing.JPopupMenu.Separator();
        rpVendedores3 = new javax.swing.JMenu();
        mnReparto = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        MitemRDC = new javax.swing.JMenuItem();
        S7 = new javax.swing.JPopupMenu.Separator();
        rpVendedores = new javax.swing.JMenu();
        jMenuItem50 = new javax.swing.JMenuItem();
        divisor1 = new javax.swing.JMenu();
        mnAyuda1 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        divisor2 = new javax.swing.JMenu();
        mnAyuda = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setExtendedState(6);
        setUndecorated(true);
        setResizable(false);

        panelImage1.setBackground(new java.awt.Color(0, 102, 102));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));

        btnClientes.setBackground(new java.awt.Color(0, 102, 102));
        btnClientes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_contact_phone_white_36.png"))); // NOI18N
        btnClientes.setText("CLIENTES - F3");
        btnClientes.setBorderPainted(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFocusPainted(false);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(0, 102, 102));
        btnProductos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_barcode_reader_white_36.png"))); // NOI18N
        btnProductos.setText("PRODUCTOS - F1");
        btnProductos.setBorderPainted(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setFocusPainted(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setIconTextGap(2);
        btnProductos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnGestionarVentasMovil.setBackground(new java.awt.Color(0, 102, 102));
        btnGestionarVentasMovil.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnGestionarVentasMovil.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionarVentasMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_local_shipping_white_36.png"))); // NOI18N
        btnGestionarVentasMovil.setText("VENTAS MÓVIL");
        btnGestionarVentasMovil.setBorderPainted(false);
        btnGestionarVentasMovil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarVentasMovil.setFocusPainted(false);
        btnGestionarVentasMovil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGestionarVentasMovil.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnGestionarVentasMovil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGestionarVentasMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarVentasMovilActionPerformed(evt);
            }
        });

        btnVender.setBackground(new java.awt.Color(0, 102, 102));
        btnVender.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_shopping_cart_checkout_white_36.png"))); // NOI18N
        btnVender.setText("VENDER");
        btnVender.setBorderPainted(false);
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender.setFocusPainted(false);
        btnVender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVender.setIconTextGap(2);
        btnVender.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnVender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnVentaLocal.setBackground(new java.awt.Color(0, 102, 102));
        btnVentaLocal.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnVentaLocal.setForeground(new java.awt.Color(255, 255, 255));
        btnVentaLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_white_36.png"))); // NOI18N
        btnVentaLocal.setText("VENTA LOCAL");
        btnVentaLocal.setBorderPainted(false);
        btnVentaLocal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentaLocal.setFocusPainted(false);
        btnVentaLocal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentaLocal.setIconTextGap(2);
        btnVentaLocal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnVentaLocal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVentaLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaLocalActionPerformed(evt);
            }
        });

        btnVender1.setBackground(new java.awt.Color(0, 102, 102));
        btnVender1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnVender1.setForeground(new java.awt.Color(255, 255, 255));
        btnVender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_shopping_cart_white_36.png"))); // NOI18N
        btnVender1.setText("COMPRAS");
        btnVender1.setBorderPainted(false);
        btnVender1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender1.setFocusPainted(false);
        btnVender1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVender1.setIconTextGap(2);
        btnVender1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnVender1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVender1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 824, Short.MAX_VALUE)
                        .addComponent(btnVender1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentaLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionarVentasMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProductos)
                    .addComponent(btnVender)
                    .addComponent(btnVender1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentaLocal))
                .addGap(2, 2, 2)
                .addComponent(btnGestionarVentasMovil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LOGO-FACT-EXPRESS - 256.png"))); // NOI18N

        jSeparator10.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(210, 229, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMPRESA:");

        lbEmpresa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lbEmpresa.setText("SIN ESPECIFICAR");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SUCURSAL:");

        lbSucursal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbSucursal.setForeground(new java.awt.Color(255, 255, 255));
        lbSucursal.setText("SIN ESPECIFICAR");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("R.U.C.");

        lbRuc.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbRuc.setForeground(new java.awt.Color(255, 255, 255));
        lbRuc.setText("SIN ESPECIFICAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 14, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbRuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbSucursal))
                .addGap(5, 5, 5))
        );

        jPanel2.setBackground(new java.awt.Color(210, 229, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("SIN ESPECIFICAR");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUARIO:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PERFIL:");

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("SIN ESPECIFICAR");

        lbPerfil.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lbPerfil.setText("SIN ESPECIFICAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator17.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator17.setForeground(new java.awt.Color(0, 153, 153));

        jToolBar1.setBackground(new java.awt.Color(4, 76, 76));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel5.setText("    ");
        jToolBar1.add(jLabel5);

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha: ");
        jToolBar1.add(lblFecha);

        jLabel9.setText("   ");
        jToolBar1.add(jLabel9);
        jToolBar1.add(jSeparator18);

        jLabel10.setText("   ");
        jToolBar1.add(jLabel10);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_cloud_done_white_20.png"))); // NOI18N
        jLabel8.setText("DATA BASE: u200536584_bddeva  - ONLINE");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jToolBar1.add(jLabel8);

        jLabel12.setText("   ");
        jToolBar1.add(jLabel12);
        jToolBar1.add(jSeparator3);

        jLabel13.setText("   ");
        jToolBar1.add(jLabel13);

        lbversion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbversion.setForeground(new java.awt.Color(255, 255, 255));
        lbversion.setText("Copyright ");
        jToolBar1.add(lbversion);

        jLabel14.setText("   ");
        jToolBar1.add(jLabel14);
        jToolBar1.add(jSeparator7);

        jLabel15.setText("   ");
        jToolBar1.add(jLabel15);

        lbIp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbIp.setForeground(new java.awt.Color(255, 255, 255));
        lbIp.setText("ip");
        jToolBar1.add(lbIp);

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setText("CERRAR EL SISTEMA");
        btnSalir.setBackgroundHover(new java.awt.Color(0, 102, 102));
        btnSalir.setEffectButton(null);
        btnSalir.setForegroundIcon(new java.awt.Color(4, 76, 76));
        btnSalir.setForegroundText(new java.awt.Color(4, 76, 76));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnSalir.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("¡El mejor software de gestión empresarial");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("La App de ventas en móviles de repartos");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("a tu alcance!");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("+");

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator10)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel20)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel19)
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        mbBarraMenu.setBackground(new java.awt.Color(0, 102, 102));
        mbBarraMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mbBarraMenu.setForeground(new java.awt.Color(0, 102, 102));

        mnSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_widgets_black_24 - copia.png"))); // NOI18N
        mnSistema.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnSistema.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemFondo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_image_black_24.png"))); // NOI18N
        itemFondo.setText("Gestionar Fondo del Sistema");
        itemFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFondoActionPerformed(evt);
            }
        });
        mnSistema.add(itemFondo);
        mnSistema.add(jSeparator4);

        jMenuItem11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_password_black_24.png"))); // NOI18N
        jMenuItem11.setText("Cambiar Contraseña de acceso al sistema");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        mnSistema.add(jMenuItem11);
        mnSistema.add(jSeparator11);

        jMenuItem52.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_link_off_black_24.png"))); // NOI18N
        jMenuItem52.setText("Cerrar sesión");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        mnSistema.add(jMenuItem52);

        mnCalc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_calculate_black_24.png"))); // NOI18N
        mnCalc.setText("Calculadora de windows");
        mnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCalcActionPerformed(evt);
            }
        });
        mnSistema.add(mnCalc);
        mnSistema.add(jSeparator12);

        mnCerrarSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnCerrarSistema.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnCerrarSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_exit_to_app_black_24.png"))); // NOI18N
        mnCerrarSistema.setText("Cerrar el sistema              ");
        mnCerrarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCerrarSistemaActionPerformed(evt);
            }
        });
        mnSistema.add(mnCerrarSistema);

        mbBarraMenu.add(mnSistema);

        mnConfiguracion.setForeground(new java.awt.Color(17, 35, 46));
        mnConfiguracion.setText("Configuración");
        mnConfiguracion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_settings_applications_black_24.png"))); // NOI18N
        jMenuItem1.setText("Establecer impresora predeterminada");
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnConfiguracion.add(jMenuItem1);

        jMenuItem9.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_settings_applications_black_24.png"))); // NOI18N
        jMenuItem9.setText("Información del Software");
        jMenuItem9.setOpaque(true);
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnConfiguracion.add(jMenuItem9);

        mbBarraMenu.add(mnConfiguracion);

        mnMantenimiento.setForeground(new java.awt.Color(17, 35, 46));
        mnMantenimiento.setText("Mantenimiento");
        mnMantenimiento.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnInformacion.setBackground(new java.awt.Color(255, 255, 255));
        mnInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_settings_suggest_black_24.png"))); // NOI18N
        mnInformacion.setText("Informaciones generales y auxiliares");
        mnInformacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnInformacion.setOpaque(true);

        itemEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        itemEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_store_black_24.png"))); // NOI18N
        itemEmpresa.setText("Gestionar empresa");
        itemEmpresa.setOpaque(true);
        itemEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpresaActionPerformed(evt);
            }
        });
        mnInformacion.add(itemEmpresa);

        itemSucursal.setBackground(new java.awt.Color(255, 255, 255));
        itemSucursal.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_storefront_black_24.png"))); // NOI18N
        itemSucursal.setText("Gestionar sucursales");
        itemSucursal.setOpaque(true);
        itemSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSucursalActionPerformed(evt);
            }
        });
        mnInformacion.add(itemSucursal);

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator14.setOpaque(true);
        mnInformacion.add(jSeparator14);

        mnGTimbradoM.setBackground(new java.awt.Color(255, 255, 255));
        mnGTimbradoM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGTimbradoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_app_settings_alt_black_24.png"))); // NOI18N
        mnGTimbradoM.setText("Gestionar Timbrado");
        mnGTimbradoM.setOpaque(true);
        mnGTimbradoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGTimbradoMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGTimbradoM);

        mnGPuntoEmisionM.setBackground(new java.awt.Color(255, 255, 255));
        mnGPuntoEmisionM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGPuntoEmisionM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_app_settings_alt_black_24.png"))); // NOI18N
        mnGPuntoEmisionM.setText("Gestionar Punto de Emisión");
        mnGPuntoEmisionM.setOpaque(true);
        mnGPuntoEmisionM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGPuntoEmisionMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGPuntoEmisionM);

        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator22.setOpaque(true);
        mnInformacion.add(jSeparator22);

        mnGCiudadM.setBackground(new java.awt.Color(255, 255, 255));
        mnGCiudadM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGCiudadM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_app_settings_alt_black_24.png"))); // NOI18N
        mnGCiudadM.setText("Gestionar Ciudades");
        mnGCiudadM.setOpaque(true);
        mnGCiudadM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGCiudadMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGCiudadM);

        mnGClasificacionM.setBackground(new java.awt.Color(255, 255, 255));
        mnGClasificacionM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGClasificacionM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_app_settings_alt_black_24.png"))); // NOI18N
        mnGClasificacionM.setText("Gestionar Clasificación");
        mnGClasificacionM.setOpaque(true);
        mnGClasificacionM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGClasificacionMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGClasificacionM);

        mnGUMM.setBackground(new java.awt.Color(255, 255, 255));
        mnGUMM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGUMM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_app_settings_alt_black_24.png"))); // NOI18N
        mnGUMM.setText("Gestionar Unidad de medida");
        mnGUMM.setOpaque(true);
        mnGUMM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGUMMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGUMM);

        mnGImpuestoM.setBackground(new java.awt.Color(255, 255, 255));
        mnGImpuestoM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGImpuestoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_app_settings_alt_black_24.png"))); // NOI18N
        mnGImpuestoM.setText("Gestionar Impuesto");
        mnGImpuestoM.setOpaque(true);
        mnGImpuestoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGImpuestoMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGImpuestoM);

        jMenuItem35.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem35.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem35.setText("Gestionar motivos");
        jMenuItem35.setOpaque(true);
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem35);

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setOpaque(true);
        mnInformacion.add(jSeparator9);

        jMenuItem51.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem51.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem51.setText("Gestionar motivos de ingresos");
        jMenuItem51.setOpaque(true);
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem51);

        jMenuItem53.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem53.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem53.setText("Gestionar motivos de gastos");
        jMenuItem53.setOpaque(true);
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem53);

        mnMantenimiento.add(mnInformacion);

        S1.setForeground(new java.awt.Color(255, 255, 255));
        S1.setOpaque(true);
        mnMantenimiento.add(S1);

        mnLogistica.setBackground(new java.awt.Color(255, 255, 255));
        mnLogistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_local_shipping_black_24.png"))); // NOI18N
        mnLogistica.setText("Puntos de Control & Logística");
        mnLogistica.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnLogistica.setOpaque(true);

        jMenuItem10.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem10.setText("Gestionar  Puntos de Control & Logistica                           ");
        jMenuItem10.setOpaque(true);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        mnLogistica.add(jMenuItem10);

        mnMantenimiento.add(mnLogistica);

        mnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        mnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_badge_black_24.png"))); // NOI18N
        mnEmpleados.setText("Recurso Humano");
        mnEmpleados.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnEmpleados.setOpaque(true);

        jMenuItem8.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem8.setText("Gestionar de Funcionarios");
        jMenuItem8.setOpaque(true);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnEmpleados.add(jMenuItem8);

        S2.setForeground(new java.awt.Color(255, 255, 255));
        S2.setOpaque(true);
        mnEmpleados.add(S2);

        mnComision.setBackground(new java.awt.Color(255, 255, 255));
        mnComision.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnComision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_sell_black_24.png"))); // NOI18N
        mnComision.setText("Comisiones");
        mnComision.setOpaque(true);
        mnComision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnComisionActionPerformed(evt);
            }
        });
        mnEmpleados.add(mnComision);

        mnMantenimiento.add(mnEmpleados);

        mnProveedores.setBackground(new java.awt.Color(255, 255, 255));
        mnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_contact_mail_black_24.png"))); // NOI18N
        mnProveedores.setText("Proveedores");
        mnProveedores.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnProveedores.setOpaque(true);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem7.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem7.setText("Gestionar Proveedores                                    ");
        jMenuItem7.setOpaque(true);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnProveedores.add(jMenuItem7);

        mnMantenimiento.add(mnProveedores);

        mnClientes.setBackground(new java.awt.Color(255, 255, 255));
        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_contact_phone_black_24.png"))); // NOI18N
        mnClientes.setText("Clientes");
        mnClientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnClientes.setOpaque(true);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem6.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_display_settings_black_24.png"))); // NOI18N
        jMenuItem6.setText("Gestionar Clientes                                  ");
        jMenuItem6.setOpaque(true);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnClientes.add(jMenuItem6);

        rpClientes.setBackground(new java.awt.Color(255, 255, 255));
        rpClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpClientes.setText("Generar Reportes");
        rpClientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpClientes.setOpaque(true);

        mnGProductosM2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGProductosM2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGProductosM2.setText("Listado de Clientes");
        mnGProductosM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGProductosM2ActionPerformed(evt);
            }
        });
        rpClientes.add(mnGProductosM2);

        mnClientes.add(rpClientes);

        mnMantenimiento.add(mnClientes);

        S3.setForeground(new java.awt.Color(255, 255, 255));
        S3.setOpaque(true);
        mnMantenimiento.add(S3);

        mnSeguridad.setBackground(new java.awt.Color(255, 255, 255));
        mnSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_admin_panel_settings_black_24.png"))); // NOI18N
        mnSeguridad.setText("Seguridad");
        mnSeguridad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnSeguridad.setOpaque(true);

        smModUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        smModUsuarios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        smModUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_manage_accounts_black_24.png"))); // NOI18N
        smModUsuarios.setText("Gestionar usuarios");
        smModUsuarios.setOpaque(true);
        smModUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smModUsuariosActionPerformed(evt);
            }
        });
        mnSeguridad.add(smModUsuarios);

        smModUsuariosD.setBackground(new java.awt.Color(255, 255, 255));
        smModUsuariosD.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        smModUsuariosD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_manage_accounts_black_24.png"))); // NOI18N
        smModUsuariosD.setText("Gestionar usuarios - Desarrollador");
        smModUsuariosD.setOpaque(true);
        smModUsuariosD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smModUsuariosDActionPerformed(evt);
            }
        });
        mnSeguridad.add(smModUsuariosD);

        S4.setForeground(new java.awt.Color(255, 255, 255));
        S4.setOpaque(true);
        mnSeguridad.add(S4);

        itemExportar.setBackground(new java.awt.Color(255, 255, 255));
        itemExportar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_cloud_download_black_24.png"))); // NOI18N
        itemExportar.setText("Generar respaldo (Backup)");
        itemExportar.setOpaque(true);
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        mnSeguridad.add(itemExportar);

        itemImportar.setBackground(new java.awt.Color(255, 255, 255));
        itemImportar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_backup_black_24.png"))); // NOI18N
        itemImportar.setText("Restaurar backup (Importar BD)");
        itemImportar.setOpaque(true);
        itemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemImportarActionPerformed(evt);
            }
        });
        mnSeguridad.add(itemImportar);

        mnMantenimiento.add(mnSeguridad);

        mbBarraMenu.add(mnMantenimiento);

        divisor3.setText("|");
        divisor3.setEnabled(false);
        divisor3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor3);

        mnCaja.setForeground(new java.awt.Color(17, 35, 46));
        mnCaja.setText("Movimiento Diario");
        mnCaja.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnIniciarCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnIniciarCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnIniciarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_free_cancellation_black_24.png"))); // NOI18N
        mnIniciarCaja.setText("Inicializar Movimiento Diario (Caja)");
        mnIniciarCaja.setOpaque(true);
        mnIniciarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIniciarCajaActionPerformed(evt);
            }
        });
        mnCaja.add(mnIniciarCaja);

        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator15.setOpaque(true);
        mnCaja.add(jSeparator15);

        mnCierredeCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnCierredeCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnCierredeCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_event_busy_black_24.png"))); // NOI18N
        mnCierredeCaja.setText("Finalizar Movimiento Diario (Cierre de caja)");
        mnCierredeCaja.setOpaque(true);
        mnCierredeCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCierredeCajaActionPerformed(evt);
            }
        });
        mnCaja.add(mnCierredeCaja);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        mnCaja.add(jSeparator2);

        rpVendedores1.setBackground(new java.awt.Color(255, 255, 255));
        rpVendedores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpVendedores1.setText("Generar Reportes");
        rpVendedores1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpVendedores1.setOpaque(true);

        itemTVentasv1.setBackground(new java.awt.Color(255, 255, 255));
        itemTVentasv1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemTVentasv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        itemTVentasv1.setText("Mov. Diario (Cierre de caja)");
        itemTVentasv1.setOpaque(true);
        itemTVentasv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTVentasv1ActionPerformed(evt);
            }
        });
        rpVendedores1.add(itemTVentasv1);

        itemTVentasv.setBackground(new java.awt.Color(255, 255, 255));
        itemTVentasv.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemTVentasv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        itemTVentasv.setText("Reporte total de ventas ");
        itemTVentasv.setOpaque(true);
        itemTVentasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTVentasvActionPerformed(evt);
            }
        });
        rpVendedores1.add(itemTVentasv);

        mnCaja.add(rpVendedores1);

        mbBarraMenu.add(mnCaja);

        divisor4.setText("|");
        divisor4.setEnabled(false);
        divisor4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor4);

        mnGsIn.setForeground(new java.awt.Color(17, 35, 46));
        mnGsIn.setText("Gastos e Ingresos");
        mnGsIn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnIngresosVarios.setBackground(new java.awt.Color(255, 255, 255));
        mnIngresosVarios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnIngresosVarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AgregarIngresos - copia.png"))); // NOI18N
        mnIngresosVarios.setText("Registrar Ingresos y/o Cobranzas");
        mnIngresosVarios.setOpaque(true);
        mnIngresosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIngresosVariosActionPerformed(evt);
            }
        });
        mnGsIn.add(mnIngresosVarios);

        mnIngresosVarios1.setBackground(new java.awt.Color(255, 255, 255));
        mnIngresosVarios1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnIngresosVarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GestionarIngresos - copia.png"))); // NOI18N
        mnIngresosVarios1.setText("Gestionar todos los Ingresos Diarios");
        mnIngresosVarios1.setOpaque(true);
        mnIngresosVarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIngresosVarios1ActionPerformed(evt);
            }
        });
        mnGsIn.add(mnIngresosVarios1);

        jSeparator19.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator19.setOpaque(true);
        mnGsIn.add(jSeparator19);

        mnGestGastos.setBackground(new java.awt.Color(255, 255, 255));
        mnGestGastos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGestGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GestionarGastos - copia.png"))); // NOI18N
        mnGestGastos.setText("Gestionar todos los Gastos Diarios");
        mnGestGastos.setOpaque(true);
        mnGestGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGestGastosActionPerformed(evt);
            }
        });
        mnGsIn.add(mnGestGastos);

        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator21.setOpaque(true);
        mnGsIn.add(jSeparator21);

        rpVendedores2.setBackground(new java.awt.Color(255, 255, 255));
        rpVendedores2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpVendedores2.setText("Generar Reportes");
        rpVendedores2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpVendedores2.setOpaque(true);

        itemRGL.setBackground(new java.awt.Color(255, 255, 255));
        itemRGL.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemRGL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        itemRGL.setText("Reporte de Gastos LOCAL");
        itemRGL.setOpaque(true);
        itemRGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRGLActionPerformed(evt);
            }
        });
        rpVendedores2.add(itemRGL);

        itemRGR.setBackground(new java.awt.Color(255, 255, 255));
        itemRGR.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemRGR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        itemRGR.setText("Reporte de Gastos EN REPARTOS");
        itemRGR.setOpaque(true);
        itemRGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRGRActionPerformed(evt);
            }
        });
        rpVendedores2.add(itemRGR);

        itemRGA.setBackground(new java.awt.Color(255, 255, 255));
        itemRGA.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemRGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        itemRGA.setText("Reporte de Gastos ADMINISTRATIVOS");
        itemRGA.setOpaque(true);
        itemRGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRGAActionPerformed(evt);
            }
        });
        rpVendedores2.add(itemRGA);

        mnGsIn.add(rpVendedores2);

        mbBarraMenu.add(mnGsIn);

        divisor5.setText("|");
        divisor5.setEnabled(false);
        divisor5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor5);

        mnProductos.setForeground(new java.awt.Color(17, 35, 46));
        mnProductos.setText("Depósitos");
        mnProductos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_barcode_reader_black_24.png"))); // NOI18N
        jMenu2.setText("Depósito de Productos Bueno");
        jMenu2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenu2.setOpaque(true);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_barcode_reader_black_24.png"))); // NOI18N
        jMenuItem2.setText("Gestionar Productos");
        jMenuItem2.setOpaque(true);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setOpaque(true);
        jMenu2.add(jSeparator8);

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_exposure_black_24.png"))); // NOI18N
        jMenuItem3.setText("Ajustar stock de Productos Bueno");
        jMenuItem3.setOpaque(true);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        jMenu2.add(jSeparator1);

        jMenuItem4.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_move_down_black_24.png"))); // NOI18N
        jMenuItem4.setText("Registrar Salidas del Depósito de Productos Bueno");
        jMenuItem4.setOpaque(true);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator13.setOpaque(true);
        jMenu2.add(jSeparator13);

        jMenuItem5.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        jMenuItem5.setText("Gestionar todas las Salidas aplicadas al Depósito de Productos Bueno");
        jMenuItem5.setOpaque(true);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator16.setOpaque(true);
        jMenu2.add(jSeparator16);

        rpArticulos.setBackground(new java.awt.Color(255, 255, 255));
        rpArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpArticulos.setText("Generar Reportes");
        rpArticulos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpArticulos.setOpaque(true);

        mnGProductosM1.setBackground(new java.awt.Color(255, 255, 255));
        mnGProductosM1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGProductosM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGProductosM1.setText("Listado de Productos con precios");
        mnGProductosM1.setOpaque(true);
        mnGProductosM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGProductosM1ActionPerformed(evt);
            }
        });
        rpArticulos.add(mnGProductosM1);

        mnGProductosM3.setBackground(new java.awt.Color(255, 255, 255));
        mnGProductosM3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGProductosM3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGProductosM3.setText("Listado de Productos para Inventario");
        mnGProductosM3.setOpaque(true);
        mnGProductosM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGProductosM3ActionPerformed(evt);
            }
        });
        rpArticulos.add(mnGProductosM3);

        mnGProductosM4.setBackground(new java.awt.Color(255, 255, 255));
        mnGProductosM4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGProductosM4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGProductosM4.setText("Listado de Stock Valorizado - Depósito de productos bueno");
        mnGProductosM4.setOpaque(true);
        mnGProductosM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGProductosM4ActionPerformed(evt);
            }
        });
        rpArticulos.add(mnGProductosM4);

        jSeparator34.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator34.setOpaque(true);
        rpArticulos.add(jSeparator34);

        mnGProductosM6.setBackground(new java.awt.Color(255, 255, 255));
        mnGProductosM6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGProductosM6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGProductosM6.setText("Generar Documento de Ajuste de Inventario");
        mnGProductosM6.setOpaque(true);
        mnGProductosM6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGProductosM6ActionPerformed(evt);
            }
        });
        rpArticulos.add(mnGProductosM6);

        jMenu2.add(rpArticulos);

        mnProductos.add(jMenu2);

        jSeparator27.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator27.setOpaque(true);
        mnProductos.add(jSeparator27);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_barcode_reader_black_24.png"))); // NOI18N
        jMenu1.setText("Depósito de Dañados");
        jMenu1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenu1.setOpaque(true);

        mnGProductosM5.setBackground(new java.awt.Color(255, 255, 255));
        mnGProductosM5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGProductosM5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGProductosM5.setText("Listado de Stock Valorizado - Depósito de Dañados");
        mnGProductosM5.setOpaque(true);
        mnGProductosM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGProductosM5ActionPerformed(evt);
            }
        });
        jMenu1.add(mnGProductosM5);

        mnProductos.add(jMenu1);

        mbBarraMenu.add(mnProductos);

        mnCompras.setForeground(new java.awt.Color(17, 35, 46));
        mnCompras.setText("Compras");
        mnCompras.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem30.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem30.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_shopping_cart_black_24.png"))); // NOI18N
        jMenuItem30.setText("Registrar compras de proveedores");
        jMenuItem30.setOpaque(true);
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        mnCompras.add(jMenuItem30);

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setOpaque(true);
        mnCompras.add(jSeparator6);

        mnGC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        mnGC.setBackground(new java.awt.Color(255, 255, 255));
        mnGC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        mnGC.setText("Gestionar todas las compras realizadas                                  ");
        mnGC.setOpaque(true);
        mnGC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGCActionPerformed(evt);
            }
        });
        mnCompras.add(mnGC);

        jSeparator23.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator23.setOpaque(true);
        mnCompras.add(jSeparator23);

        mnGC1.setBackground(new java.awt.Color(255, 255, 255));
        mnGC1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_attach_money_black_24.png"))); // NOI18N
        mnGC1.setText("Registrar Pagos a Proveedores");
        mnGC1.setOpaque(true);
        mnGC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGC1ActionPerformed(evt);
            }
        });
        mnCompras.add(mnGC1);

        jSeparator24.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator24.setOpaque(true);
        mnCompras.add(jSeparator24);

        rpCompras.setBackground(new java.awt.Color(255, 255, 255));
        rpCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpCompras.setText("Generar Reportes");
        rpCompras.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpCompras.setOpaque(true);

        jMenuItem65.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem65.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        jMenuItem65.setText("Facturas Compras");
        jMenuItem65.setOpaque(true);
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        rpCompras.add(jMenuItem65);

        mnCompras.add(rpCompras);

        mbBarraMenu.add(mnCompras);

        mnVentas1.setForeground(new java.awt.Color(17, 35, 46));
        mnVentas1.setText("Ventas");
        mnVentas1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnVentas.setBackground(new java.awt.Color(255, 255, 255));
        mnVentas.setForeground(new java.awt.Color(17, 35, 46));
        mnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_shopping_cart_checkout_black_24.png"))); // NOI18N
        mnVentas.setText("Ventas Locales");
        mnVentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnVentas.setOpaque(true);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem23.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem23.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_shopping_cart_checkout_black_24.png"))); // NOI18N
        jMenuItem23.setText("Registrar venta local");
        jMenuItem23.setOpaque(true);
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        mnVentas.add(jMenuItem23);

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOpaque(true);
        mnVentas.add(jSeparator5);

        mnGV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        mnGV.setBackground(new java.awt.Color(255, 255, 255));
        mnGV.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        mnGV.setText("Gestionar todas las ventas locales                                                     ");
        mnGV.setOpaque(true);
        mnGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVActionPerformed(evt);
            }
        });
        mnVentas.add(mnGV);

        jSeparator28.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator28.setOpaque(true);
        mnVentas.add(jSeparator28);

        mnGC2.setBackground(new java.awt.Color(255, 255, 255));
        mnGC2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_attach_money_black_24.png"))); // NOI18N
        mnGC2.setText("Registrar Pagos de Clientes");
        mnGC2.setOpaque(true);
        mnGC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGC2ActionPerformed(evt);
            }
        });
        mnVentas.add(mnGC2);

        jSeparator36.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator36.setOpaque(true);
        mnVentas.add(jSeparator36);

        mnGV1.setBackground(new java.awt.Color(255, 255, 255));
        mnGV1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        mnGV1.setText("Gestionar todos los Pagos realizados                                ");
        mnGV1.setOpaque(true);
        mnGV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGV1ActionPerformed(evt);
            }
        });
        mnVentas.add(mnGV1);

        mnVentas1.add(mnVentas);

        jSeparator25.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator25.setOpaque(true);
        mnVentas1.add(jSeparator25);

        mnVentasMovil.setBackground(new java.awt.Color(255, 255, 255));
        mnVentasMovil.setForeground(new java.awt.Color(17, 35, 46));
        mnVentasMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_local_shipping_black_24.png"))); // NOI18N
        mnVentasMovil.setText("Ventas Móviles");
        mnVentasMovil.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnVentasMovil.setOpaque(true);

        mnGVM1.setBackground(new java.awt.Color(255, 255, 255));
        mnGVM1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGVM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        mnGVM1.setText("Gestionar ventas móviles");
        mnGVM1.setOpaque(true);
        mnGVM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVM1ActionPerformed(evt);
            }
        });
        mnVentasMovil.add(mnGVM1);

        mnVentas1.add(mnVentasMovil);

        jSeparator26.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator26.setOpaque(true);
        mnVentas1.add(jSeparator26);

        rpVentas.setBackground(new java.awt.Color(255, 255, 255));
        rpVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpVentas.setText("Generar Reportes");
        rpVentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpVentas.setOpaque(true);

        jMenuItem64.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem64.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        jMenuItem64.setText("Lista de facturas emitidas");
        jMenuItem64.setOpaque(true);
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem64);

        jSeparator31.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator31.setOpaque(true);
        rpVentas.add(jSeparator31);

        mnGVE.setBackground(new java.awt.Color(255, 255, 255));
        mnGVE.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        mnGVE.setText("Generar extracto de cuentas -Ventas Crédito");
        mnGVE.setOpaque(true);
        mnGVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVEActionPerformed(evt);
            }
        });
        rpVentas.add(mnGVE);

        mnVentas1.add(rpVentas);

        mbBarraMenu.add(mnVentas1);

        mnAyuda2.setForeground(new java.awt.Color(17, 35, 46));
        mnAyuda2.setText("Nota de Crédito");
        mnAyuda2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnAyuda4.setBackground(new java.awt.Color(255, 255, 255));
        mnAyuda4.setForeground(new java.awt.Color(17, 35, 46));
        mnAyuda4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_shopping_cart_black_24.png"))); // NOI18N
        mnAyuda4.setText("Compras");
        mnAyuda4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnAyuda4.setOpaque(true);

        mnGNCVenta3.setBackground(new java.awt.Color(255, 255, 255));
        mnGNCVenta3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGNCVenta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_paid_black_24.png"))); // NOI18N
        mnGNCVenta3.setText("Registrar Nota de Crédito de Proveedores");
        mnGNCVenta3.setOpaque(true);
        mnGNCVenta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVenta3ActionPerformed(evt);
            }
        });
        mnAyuda4.add(mnGNCVenta3);

        jSeparator35.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator35.setOpaque(true);
        mnAyuda4.add(jSeparator35);

        mnGNCVenta4.setBackground(new java.awt.Color(255, 255, 255));
        mnGNCVenta4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGNCVenta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        mnGNCVenta4.setText("Gestionar todas las Nota de Crédito de Proveedores");
        mnGNCVenta4.setOpaque(true);
        mnGNCVenta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVenta4ActionPerformed(evt);
            }
        });
        mnAyuda4.add(mnGNCVenta4);

        jSeparator33.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator33.setOpaque(true);
        mnAyuda4.add(jSeparator33);

        mnPagoProveedor.setBackground(new java.awt.Color(255, 255, 255));
        mnPagoProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnPagoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_currency_exchange_black_24.png"))); // NOI18N
        mnPagoProveedor.setText("Gestionar y Generar Solicitud de Nota de Crédito a Proveedor");
        mnPagoProveedor.setOpaque(true);
        mnPagoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPagoProveedorActionPerformed(evt);
            }
        });
        mnAyuda4.add(mnPagoProveedor);

        mnAyuda2.add(mnAyuda4);

        jSeparator30.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator30.setOpaque(true);
        mnAyuda2.add(jSeparator30);

        mnAyuda5.setBackground(new java.awt.Color(255, 255, 255));
        mnAyuda5.setForeground(new java.awt.Color(17, 35, 46));
        mnAyuda5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_shopping_cart_checkout_black_24.png"))); // NOI18N
        mnAyuda5.setText("Ventas Locales");
        mnAyuda5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnAyuda5.setOpaque(true);

        mnGNCVenta.setBackground(new java.awt.Color(255, 255, 255));
        mnGNCVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGNCVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_currency_exchange_black_24.png"))); // NOI18N
        mnGNCVenta.setText("Registrar Notas de Crédito a Clientes");
        mnGNCVenta.setOpaque(true);
        mnGNCVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVentaActionPerformed(evt);
            }
        });
        mnAyuda5.add(mnGNCVenta);

        jSeparator29.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator29.setOpaque(true);
        mnAyuda5.add(jSeparator29);

        mnGNCVenta1.setBackground(new java.awt.Color(255, 255, 255));
        mnGNCVenta1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGNCVenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_push_pin_black_24.png"))); // NOI18N
        mnGNCVenta1.setText("Gestionar todas las Notas de Créditos");
        mnGNCVenta1.setOpaque(true);
        mnGNCVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVenta1ActionPerformed(evt);
            }
        });
        mnAyuda5.add(mnGNCVenta1);

        mnAyuda2.add(mnAyuda5);

        mbBarraMenu.add(mnAyuda2);

        mnAyuda3.setForeground(new java.awt.Color(17, 35, 46));
        mnAyuda3.setText("Destrucción");
        mnAyuda3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        mnNCProveedor.setBackground(new java.awt.Color(255, 255, 255));
        mnNCProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnNCProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_disabled_by_default_black_24.png"))); // NOI18N
        mnNCProveedor.setText("Gestionar y Generar Documento de Destrucción");
        mnNCProveedor.setOpaque(true);
        mnNCProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNCProveedorActionPerformed(evt);
            }
        });
        mnAyuda3.add(mnNCProveedor);

        jSeparator32.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator32.setOpaque(true);
        mnAyuda3.add(jSeparator32);

        mnGNCVenta2.setBackground(new java.awt.Color(255, 255, 255));
        mnGNCVenta2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        mnGNCVenta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        mnGNCVenta2.setText("Generar Reporte");
        mnGNCVenta2.setOpaque(true);
        mnGNCVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVenta2ActionPerformed(evt);
            }
        });
        mnAyuda3.add(mnGNCVenta2);

        mbBarraMenu.add(mnAyuda3);

        mnTransferencias.setForeground(new java.awt.Color(17, 35, 46));
        mnTransferencias.setText("Transferencias");
        mnTransferencias.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemGestionarTR.setBackground(new java.awt.Color(255, 255, 255));
        itemGestionarTR.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        itemGestionarTR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_move_down_black_24.png"))); // NOI18N
        itemGestionarTR.setText("Gestionar todas las Transferencias realizadas");
        itemGestionarTR.setOpaque(true);
        itemGestionarTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionarTRActionPerformed(evt);
            }
        });
        mnTransferencias.add(itemGestionarTR);

        S8.setForeground(new java.awt.Color(255, 255, 255));
        S8.setOpaque(true);
        mnTransferencias.add(S8);

        rpVendedores3.setBackground(new java.awt.Color(255, 255, 255));
        rpVendedores3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpVendedores3.setText("Generar Reportes");
        rpVendedores3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpVendedores3.setOpaque(true);
        mnTransferencias.add(rpVendedores3);

        mbBarraMenu.add(mnTransferencias);

        mnReparto.setForeground(new java.awt.Color(17, 35, 46));
        mnReparto.setText("Repartos");
        mnReparto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jMenuItem18.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_local_shipping_black_24.png"))); // NOI18N
        jMenuItem18.setText("Gestionar Repartos");
        jMenuItem18.setOpaque(true);
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        mnReparto.add(jMenuItem18);

        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator20.setOpaque(true);
        mnReparto.add(jSeparator20);

        MitemRDC.setBackground(new java.awt.Color(255, 255, 255));
        MitemRDC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        MitemRDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_local_atm_black_24.png"))); // NOI18N
        MitemRDC.setText("Generar Recibo de Dinero - Pago de Comisiones");
        MitemRDC.setOpaque(true);
        MitemRDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitemRDCActionPerformed(evt);
            }
        });
        mnReparto.add(MitemRDC);

        S7.setForeground(new java.awt.Color(255, 255, 255));
        S7.setOpaque(true);
        mnReparto.add(S7);

        rpVendedores.setBackground(new java.awt.Color(255, 255, 255));
        rpVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_inventory_black_24.png"))); // NOI18N
        rpVendedores.setText("Generar Reportes");
        rpVendedores.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rpVendedores.setOpaque(true);

        jMenuItem50.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem50.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_black_24.png"))); // NOI18N
        jMenuItem50.setText("Reporte de Reparto por Móvil");
        jMenuItem50.setOpaque(true);
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });
        rpVendedores.add(jMenuItem50);

        mnReparto.add(rpVendedores);

        mbBarraMenu.add(mnReparto);

        divisor1.setText("|");
        divisor1.setEnabled(false);
        divisor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor1);

        mnAyuda1.setForeground(new java.awt.Color(17, 35, 46));
        mnAyuda1.setText("Datos para Contabilidad");
        mnAyuda1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jMenuItem19.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_file_download_black_24.png"))); // NOI18N
        jMenuItem19.setText("Formulario de visualización y exportación.");
        jMenuItem19.setOpaque(true);
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        mnAyuda1.add(jMenuItem19);

        mbBarraMenu.add(mnAyuda1);

        divisor2.setText("|");
        divisor2.setEnabled(false);
        divisor2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor2);

        mnAyuda.setForeground(new java.awt.Color(17, 35, 46));
        mnAyuda.setText("Sistema");
        mnAyuda.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jMenuItem17.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_help_black_24.png"))); // NOI18N
        jMenuItem17.setText("Información del Sistema");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        mnAyuda.add(jMenuItem17);

        mbBarraMenu.add(mnAyuda);

        setJMenuBar(mbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 1598, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar salidas sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgAjusteStock ajuste = new dlgAjusteStock(this, true);
                    ajuste.setLocationRelativeTo(null);
                    ajuste.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar salidas sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgSalidaMercaderia salida = new dlgSalidaMercaderia(this, true);
                    salida.setLocationRelativeTo(null);
                    salida.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }

        //Mensajes.Sistema("La función: Aplicar salidas a artículos se encuentra bloqueada \nen estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgConSalidas conSalidas = new dlgConSalidas(this, true);
            conSalidas.setLocationRelativeTo(null);
            conSalidas.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.Sistema("La función: Controlar salidas aplicadas a artículos se encuentra bloqueada \nen estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("Esta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        abrirClientes();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("Esta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        abrirProductosMoviles();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnCerrarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCerrarSistemaActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_mnCerrarSistemaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        abrirProveedor();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            dlgVendedor vend = new dlgVendedor(this, true);
            vend.setLocationRelativeTo(null);
            vend.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar las compras sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                abrirCompras();
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }

    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a vender sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                abrirFactura();
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void mnGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgConsultarFacturas cf = new dlgConsultarFacturas(this, true);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGVActionPerformed

    private void mnGNCVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVentaActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("EN PROCESO DE DESARROLLO::\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");

        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar salidas sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgNCCliente sd = new dlgNCCliente(this, true);
                    sd.setSize(893,596);
                    sd.setLocationRelativeTo(null);
                    sd.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_mnGNCVentaActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        // TODO add your handling code here:
        CerrarCesion();


    }//GEN-LAST:event_jMenuItem52ActionPerformed

    public void salir() {
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del sistema?");
        if (rpta == 0) {
            String msg = ControlLogeo.desLogeo();
            System.exit(0);
            //this.dispose();

        }
    }

    public void CerrarCesion() {
        int rpta = Mensajes.confirmar("¿Seguro que desea Cerrar Sesión?");
        if (rpta == 0) {
            String msg = ControlLogeo.desLogeo();
            //System.exit(0);
            this.dispose();
            frmAcceso ac = new frmAcceso();
            ac.setLocationRelativeTo(null);
            ac.setVisible(true);

        }
    }

    void abrirImpresoras() {
        try {
            dlgImpresoras impre = new dlgImpresoras(this, true);
            impre.setLocationRelativeTo(null);
            impre.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirFactura() {
        try {
            dlgVentas factura = new dlgVentas(this, false);
            factura.setLocationRelativeTo(this);
            factura.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirCompras() {
        try {
            dlgCompras1 compras = new dlgCompras1(this, true);
            compras.setLocationRelativeTo(null);
            compras.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirClientes() {
        try {
            dlgClientes clientes = new dlgClientes(this, true);
            //clientes.setSize(1000, 540);
            clientes.setLocationRelativeTo(null);
            clientes.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirCiudadMovil() {
        try {
            dlgCiudadMovil ciudadm = new dlgCiudadMovil(this, true);
            ciudadm.setLocationRelativeTo(null);
            ciudadm.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirClasificacionMovil() {
        try {
            dlgClasificacionMovil clasifM = new dlgClasificacionMovil(this, true);
            clasifM.setLocationRelativeTo(null);
            clasifM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirTimbradoMovil() {
        try {
            dlgTimbradoMovil TimbradoM = new dlgTimbradoMovil(this, true);
            TimbradoM.setLocationRelativeTo(null);
            TimbradoM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirPuntoEmisionMovil() {
        try {
            dlgPuntoEmisionMovil PPM = new dlgPuntoEmisionMovil(this, true);
            PPM.setLocationRelativeTo(null);
            PPM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirUMMovil() {
        try {
            dlgUMMovil umM = new dlgUMMovil(this, true);
            umM.setLocationRelativeTo(null);
            umM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirIVAMovil() {
        try {
            dlgIVAMovil ivaM = new dlgIVAMovil(this, true);
            ivaM.setLocationRelativeTo(null);
            ivaM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirArticulos() {
        try {
            dlgArticulos articulo = new dlgArticulos(this, true);
            articulo.setLocationRelativeTo(null);
            articulo.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirProductosMoviles() {
        try {
            dlgArticulosMovil articulo = new dlgArticulosMovil(this, true);
            articulo.setLocationRelativeTo(null);
            articulo.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirCambiodeContraseña() {
        try {
            dlgActualizarContra contra = new dlgActualizarContra(this, true);
            contra.setLocationRelativeTo(null);
            contra.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirBackup() {
        try {
            dlgBackup bk = new dlgBackup(this, true);
            bk.setLocationRelativeTo(null);
            bk.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirTransferencias() {
        try {
            //dlgGestTransferencias transf = new dlgGestTransferencias(this, true);
            dlgTransferencias transf = new dlgTransferencias(this, true);
            transf.setLocationRelativeTo(null);
            transf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    private void smModUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smModUsuariosActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestUsuario gu = new dlgGestUsuario(this, true);
            gu.setLocationRelativeTo(null);
            gu.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_smModUsuariosActionPerformed

    private void mnComisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnComisionActionPerformed
        // TODO add your handling code here:
        /*dlgComisionEmpleado ce = new dlgComisionEmpleado(this, true);
        ce.setLocationRelativeTo(null);
        ce.setVisible(true);*/
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_mnComisionActionPerformed

    private void mnGCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGCActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgConsultarCompras consCompras = new dlgConsultarCompras(this, true);
            consCompras.setLocationRelativeTo(null);
            consCompras.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnGCActionPerformed

    private void mnCierredeCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCierredeCajaActionPerformed
        // TODO add your handling code here:
        // Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja ya fue cerrada.\n\nPodra acceder a este formulario para visualizar los movimientos en la siguiente apertura de caja.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgCajaDia cajaDia = new dlgCajaDia(this, false);
                cajaDia.setLocationRelativeTo(null);
                cajaDia.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnCierredeCajaActionPerformed

    private void mnIngresosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIngresosVariosActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara registrar cobranzas u otros ingresos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgIngreso ingreso = new dlgIngreso(this, true);
                ingreso.setLocationRelativeTo(null);
                ingreso.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_mnIngresosVariosActionPerformed

    private void itemFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFondoActionPerformed
        // TODO add your handling code here:
        try {
            dlgFondo fondo = new dlgFondo(this, true);
            fondo.setLocationRelativeTo(null);
            fondo.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemFondoActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        // TODO add your handling code here:

        try {
            dlgReporteFacturasEmitidas fe = new dlgReporteFacturasEmitidas(this, true);
            fe.setLocationRelativeTo(null);
            fe.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        //abrirBackup();
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImportarActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_itemImportarActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        dlgAyuda a = new dlgAyuda(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void mnNCProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNCProveedorActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("EN PROCESO DE DESARROLLO::\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar salidas sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgSolicitudDestrucción sd = new dlgSolicitudDestrucción(this, true);
                    //clientes.setSize(1000, 540);
                    sd.setLocationRelativeTo(null);
                    sd.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_mnNCProveedorActionPerformed

    private void mnIniciarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIniciarCajaActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja WHERE ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                dlgCaja caja = new dlgCaja(this, true);
                caja.setLocationRelativeTo(null);
                caja.setVisible(true);
            } else {
                Mensajes.informacion("La caja ya fue inicializada.\n\nPuede comenzar a registrar compras o realizar ventas\nsin ningún inconveniente.");
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnIniciarCajaActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("Esta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        abrirClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void mnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCalcActionPerformed
        // TODO add your handling code here:
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("calc");
            p.waitFor();
        } catch (IOException | InterruptedException ioe) {
            ioe.getMessage();
        }
    }//GEN-LAST:event_mnCalcActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        abrirImpresoras();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnGVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVEActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("Esta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgReporteExtractoComprobantes fe = new dlgReporteExtractoComprobantes(this, true);
            fe.setLocationRelativeTo(null);
            fe.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnGVEActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        dlgSoftware a = new dlgSoftware(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void smModUsuariosDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smModUsuariosDActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestUsuarioD gud = new dlgGestUsuarioD(this, true);
            gud.setLocationRelativeTo(null);
            gud.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_smModUsuariosDActionPerformed

    private void mnGProductosM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGProductosM1ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        jasper = new ReporteMovil();
        jasper.ListaProductosMovilesV("\\Reports\\articulos\\ListProductos.jasper");
        jasper.cerrar();
    }//GEN-LAST:event_mnGProductosM1ActionPerformed

    private void mnGProductosM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGProductosM2ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        //jasper.ListaClientesMoviles("\\Reports\\clientes\\ListaClientes.jasper");
    }//GEN-LAST:event_mnGProductosM2ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /* try {
            dlgMovilesReparto mreparto = new dlgMovilesReparto(this, true);
            mreparto.setLocationRelativeTo(null);
            mreparto.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
        if (!fe.equals(Fecha.fechaCorrecta())) {
            Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar los repartos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
        } else {
            abrirRepartos();
        }*/

    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void MitemRDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitemRDCActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
            dlgReporteComisiones ReCom = new dlgReporteComisiones(this, false);
            ReCom.setLocationRelativeTo(this);
            ReCom.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_MitemRDCActionPerformed

    private void mnGProductosM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGProductosM3ActionPerformed
        // TODO add your handling code here:
        // Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        jasper = new ReporteMovil();
        jasper.ListaProductosMovilesV("\\Reports\\articulos\\ListProductosInventario.jasper");
        jasper.cerrar();
    }//GEN-LAST:event_mnGProductosM3ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /* try {
            dlgReporteGananciaReparto ReCom = new dlgReporteGananciaReparto(this, true);
            ReCom.setLocationRelativeTo(this);
            ReCom.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void itemTVentasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTVentasvActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
            dlgReporteTotalVentas rsc = new dlgReporteTotalVentas(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/
    }//GEN-LAST:event_itemTVentasvActionPerformed

    private void itemTVentasv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTVentasv1ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
            dlgReporteResumenCaja rsc = new dlgReporteResumenCaja(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/
    }//GEN-LAST:event_itemTVentasv1ActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        abrirProductosMoviles();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void mnGestGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGestGastosActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /* try {
                dlgGestGastos Ggastos = new dlgGestGastos(this, true);
                Ggastos.setLocationRelativeTo(null);
                Ggastos.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_mnGestGastosActionPerformed

    private void mnIngresosVarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIngresosVarios1ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_mnIngresosVarios1ActionPerformed

    private void itemRGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRGLActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /* try {
                dlgReporteGastoLocal RG = new dlgReporteGastoLocal(this, true);
                RG.setLocationRelativeTo(null);
                RG.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_itemRGLActionPerformed

    private void itemRGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRGRActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
                dlgReporteGastoReparto RG = new dlgReporteGastoReparto(this, true);
                RG.setLocationRelativeTo(null);
                RG.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_itemRGRActionPerformed

    private void itemRGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRGAActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
                dlgReporteGastoAdministrativo RG = new dlgReporteGastoAdministrativo(this, true);
                RG.setLocationRelativeTo(null);
                RG.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_itemRGAActionPerformed

    private void itemGestionarTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionarTRActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
        if (!fe.equals(Fecha.fechaCorrecta())) {
            Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar los repartos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
        } else {
            abrirTransferencias();
        }*/
        //Mensajes.Sistema("Esta función se encuentra bloqueada en estos momentos por motivos de desarrollo.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_itemGestionarTRActionPerformed

    private void btnGestionarVentasMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarVentasMovilActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarFacturasMovil cf = new dlgConsultarFacturasMovil(this, true);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnGestionarVentasMovilActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        dlgExportaciones a = new dlgExportaciones(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
            dlgDetalleGasto detalleG = new dlgDetalleGasto(this, true);
            detalleG.setLocationRelativeTo(null);
            detalleG.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /*try {
            dlgDetalleIngreso detalleI = new dlgDetalleIngreso(this, true);
            detalleI.setLocationRelativeTo(null);
            detalleI.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgMotivo motivo = new dlgMotivo(this, true);
            motivo.setLocationRelativeTo(null);
            motivo.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void mnGImpuestoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGImpuestoMActionPerformed
        // TODO add your handling code here:
        abrirIVAMovil();

    }//GEN-LAST:event_mnGImpuestoMActionPerformed

    private void mnGUMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGUMMActionPerformed
        // TODO add your handling code here:
        abrirUMMovil();
    }//GEN-LAST:event_mnGUMMActionPerformed

    private void mnGClasificacionMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGClasificacionMActionPerformed
        // TODO add your handling code here:
        abrirClasificacionMovil();
    }//GEN-LAST:event_mnGClasificacionMActionPerformed

    private void mnGCiudadMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGCiudadMActionPerformed
        // TODO add your handling code here:
        abrirCiudadMovil();
    }//GEN-LAST:event_mnGCiudadMActionPerformed

    private void mnGPuntoEmisionMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGPuntoEmisionMActionPerformed
        // TODO add your handling code here:
        abrirPuntoEmisionMovil();
    }//GEN-LAST:event_mnGPuntoEmisionMActionPerformed

    private void mnGTimbradoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGTimbradoMActionPerformed
        // TODO add your handling code here:
        abrirTimbradoMovil();
    }//GEN-LAST:event_mnGTimbradoMActionPerformed

    private void itemSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSucursalActionPerformed
        // TODO add your handling code here:
        try {
            dlgSucursal sucursal = new dlgSucursal(this, true);
            sucursal.setLocationRelativeTo(null);
            sucursal.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemSucursalActionPerformed

    private void itemEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpresaActionPerformed
        // TODO add your handling code here:
        try {
            dlgEmpresa empresa = new dlgEmpresa(this, true);
            empresa.setLocationRelativeTo(null);
            empresa.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemEmpresaActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        abrirCambiodeContraseña();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a vender sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                abrirFactura();
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnVentaLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaLocalActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarFacturas cf = new dlgConsultarFacturas(this, true);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnVentaLocalActionPerformed

    private void mnGProductosM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGProductosM4ActionPerformed
        // TODO add your handling code here:
        // Mensajes.Sistema("RESTRICCIÓN DEL SISTEMA:\nEsta función se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        jasper = new ReporteMovil();
        jasper.ListaProductosMovilesV("\\Reports\\articulos\\ListProductosStockValorizado.jasper");
        jasper.cerrar();
    }//GEN-LAST:event_mnGProductosM4ActionPerformed

    private void mnGC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGC1ActionPerformed
        // TODO add your handling code here:
        // Mensajes.Sistema("EN PROCESO DE DESARROLLO:\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar las compras sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgRegistrarPagosCompras consComprasC = new dlgRegistrarPagosCompras(this, true);
                    consComprasC.setLocationRelativeTo(null);
                    consComprasC.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_mnGC1ActionPerformed

    private void mnGVM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVM1ActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarFacturasMovil cf = new dlgConsultarFacturasMovil(this, true);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGVM1ActionPerformed

    private void btnVender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVender1ActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar las compras sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                abrirCompras();
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_btnVender1ActionPerformed

    private void mnGNCVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVenta1ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("EN PROCESO DE DESARROLLO::\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgConsultarNCCliente consNCP = new dlgConsultarNCCliente(this, true);
            consNCP.setLocationRelativeTo(null);
            consNCP.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnGNCVenta1ActionPerformed

    private void mnPagoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPagoProveedorActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("EN PROCESO DE DESARROLLO::\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar salidas sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgSolicitudNCProveedor sncp = new dlgSolicitudNCProveedor(this, true);
                    //clientes.setSize(1000, 540);
                    sncp.setLocationRelativeTo(null);
                    sncp.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_mnPagoProveedorActionPerformed

    private void mnGNCVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVenta2ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("EN PROCESO DE DESARROLLO::\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");

    }//GEN-LAST:event_mnGNCVenta2ActionPerformed

    private void mnGNCVenta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVenta3ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("EN PROCESO DE DESARROLLO::\nEsta función se encuentra en desarrollo en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar salidas sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgNCProveedor sd = new dlgNCProveedor(this, true);
                    sd.setLocationRelativeTo(null);
                    sd.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_mnGNCVenta3ActionPerformed

    private void mnGProductosM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGProductosM5ActionPerformed
        // TODO add your handling code here:

        jasper = new ReporteMovil();
        jasper.ListaProductosMovilesV("\\Reports\\articulos\\ListDepositoDañado.jasper");
        jasper.cerrar();
    }//GEN-LAST:event_mnGProductosM5ActionPerformed

    private void mnGProductosM6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGProductosM6ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteAjusteStock ajStock = new dlgReporteAjusteStock(this, true);
            ajStock.setLocationRelativeTo(null);
            ajStock.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnGProductosM6ActionPerformed

    private void mnGNCVenta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVenta4ActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarNCProveedor consNCP = new dlgConsultarNCProveedor(this, true);
            consNCP.setLocationRelativeTo(null);
            consNCP.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnGNCVenta4ActionPerformed

    private void mnGC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGC2ActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar las compras sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                try {
                    dlgRegistrarPagosFacturas consComprasC = new dlgRegistrarPagosFacturas(this, true);
                    consComprasC.setSize(964,455);
                    consComprasC.setLocationRelativeTo(null);
                    consComprasC.setVisible(true);
                } catch (Exception e) {
                    Mensajes.informacion("Servidor no esta activo");
                }
            }
        } catch (Exception e) {
            Mensajes.error("Error obteniendo fecha de caja: " + e.getMessage());
        }
    }//GEN-LAST:event_mnGC2ActionPerformed

    private void mnGV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGV1ActionPerformed
        // TODO add your handling code here:
        
        try {
            dlgConsultarPagosVentas consNCP = new dlgConsultarPagosVentas(this, true);
            consNCP.setLocationRelativeTo(null);
            consNCP.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnGV1ActionPerformed

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteComprasRealizadas fe = new dlgReporteComprasRealizadas(this, true);
            fe.setLocationRelativeTo(null);
            fe.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem65ActionPerformed
    void abrirProveedor() {
        try {
            dlgProveedores proveedor = new dlgProveedores(this, true);
            proveedor.setLocationRelativeTo(null);
            proveedor.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirRepartos() {
        try {
            dlgRepartos repartos = new dlgRepartos(null, true);
            repartos.setLocationRelativeTo(null);
            repartos.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/icon.png"));
            setIconImage(icon);
            setVisible(true);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo el icono del sistema.");
        }
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MitemRDC;
    public static javax.swing.JPopupMenu.Separator S1;
    public static javax.swing.JPopupMenu.Separator S2;
    public static javax.swing.JPopupMenu.Separator S3;
    public static javax.swing.JPopupMenu.Separator S4;
    public static javax.swing.JPopupMenu.Separator S7;
    public static javax.swing.JPopupMenu.Separator S8;
    public static javax.swing.JButton btnClientes;
    public static javax.swing.JButton btnGestionarVentasMovil;
    public static javax.swing.JButton btnProductos;
    public static RSMaterialComponent.RSButtonMaterialIconUno btnSalir;
    public static javax.swing.JButton btnVender;
    public static javax.swing.JButton btnVender1;
    public static javax.swing.JButton btnVentaLocal;
    private javax.swing.JMenu divisor1;
    private javax.swing.JMenu divisor2;
    public static javax.swing.JMenu divisor3;
    public static javax.swing.JMenu divisor4;
    public static javax.swing.JMenu divisor5;
    private javax.swing.JMenuItem itemEmpresa;
    private javax.swing.JMenuItem itemExportar;
    public static javax.swing.JMenuItem itemFondo;
    private javax.swing.JMenuItem itemGestionarTR;
    private javax.swing.JMenuItem itemImportar;
    private javax.swing.JMenuItem itemRGA;
    private javax.swing.JMenuItem itemRGL;
    private javax.swing.JMenuItem itemRGR;
    private javax.swing.JMenuItem itemSucursal;
    private javax.swing.JMenuItem itemTVentasv;
    private javax.swing.JMenuItem itemTVentasv1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem35;
    public static javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator29;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator30;
    private javax.swing.JPopupMenu.Separator jSeparator31;
    private javax.swing.JPopupMenu.Separator jSeparator32;
    private javax.swing.JPopupMenu.Separator jSeparator33;
    private javax.swing.JPopupMenu.Separator jSeparator34;
    private javax.swing.JPopupMenu.Separator jSeparator35;
    private javax.swing.JPopupMenu.Separator jSeparator36;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lbEmpresa;
    private javax.swing.JLabel lbIp;
    public static javax.swing.JLabel lbPerfil;
    public static javax.swing.JLabel lbRuc;
    public static javax.swing.JLabel lbSucursal;
    public static javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbversion;
    private javax.swing.JMenuBar mbBarraMenu;
    public static javax.swing.JMenu mnAyuda;
    public static javax.swing.JMenu mnAyuda1;
    public static javax.swing.JMenu mnAyuda2;
    public static javax.swing.JMenu mnAyuda3;
    public static javax.swing.JMenu mnAyuda4;
    public static javax.swing.JMenu mnAyuda5;
    public static javax.swing.JMenu mnCaja;
    private javax.swing.JMenuItem mnCalc;
    private javax.swing.JMenuItem mnCerrarSistema;
    private javax.swing.JMenuItem mnCierredeCaja;
    public static javax.swing.JMenu mnClientes;
    public static javax.swing.JMenuItem mnComision;
    public static javax.swing.JMenu mnCompras;
    public static javax.swing.JMenu mnConfiguracion;
    public static javax.swing.JMenu mnEmpleados;
    private javax.swing.JMenuItem mnGC;
    private javax.swing.JMenuItem mnGC1;
    private javax.swing.JMenuItem mnGC2;
    private javax.swing.JMenuItem mnGCiudadM;
    private javax.swing.JMenuItem mnGClasificacionM;
    private javax.swing.JMenuItem mnGImpuestoM;
    public static javax.swing.JMenuItem mnGNCVenta;
    public static javax.swing.JMenuItem mnGNCVenta1;
    public static javax.swing.JMenuItem mnGNCVenta2;
    public static javax.swing.JMenuItem mnGNCVenta3;
    public static javax.swing.JMenuItem mnGNCVenta4;
    private javax.swing.JMenuItem mnGProductosM1;
    private javax.swing.JMenuItem mnGProductosM2;
    private javax.swing.JMenuItem mnGProductosM3;
    private javax.swing.JMenuItem mnGProductosM4;
    private javax.swing.JMenuItem mnGProductosM5;
    private javax.swing.JMenuItem mnGProductosM6;
    private javax.swing.JMenuItem mnGPuntoEmisionM;
    private javax.swing.JMenuItem mnGTimbradoM;
    private javax.swing.JMenuItem mnGUMM;
    private javax.swing.JMenuItem mnGV;
    private javax.swing.JMenuItem mnGV1;
    public static javax.swing.JMenuItem mnGVE;
    private javax.swing.JMenuItem mnGVM1;
    private javax.swing.JMenuItem mnGestGastos;
    public static javax.swing.JMenu mnGsIn;
    public static javax.swing.JMenu mnInformacion;
    private javax.swing.JMenuItem mnIngresosVarios;
    private javax.swing.JMenuItem mnIngresosVarios1;
    private javax.swing.JMenuItem mnIniciarCaja;
    public static javax.swing.JMenu mnLogistica;
    public static javax.swing.JMenu mnMantenimiento;
    public static javax.swing.JMenuItem mnNCProveedor;
    public static javax.swing.JMenuItem mnPagoProveedor;
    public static javax.swing.JMenu mnProductos;
    public static javax.swing.JMenu mnProveedores;
    public static javax.swing.JMenu mnReparto;
    public static javax.swing.JMenu mnSeguridad;
    public static javax.swing.JMenu mnSistema;
    public static javax.swing.JMenu mnTransferencias;
    public static javax.swing.JMenu mnVentas;
    public static javax.swing.JMenu mnVentas1;
    public static javax.swing.JMenu mnVentasMovil;
    public static javax.swing.JPanel panelFondo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public static javax.swing.JMenu rpArticulos;
    public static javax.swing.JMenu rpClientes;
    public static javax.swing.JMenu rpCompras;
    public static javax.swing.JMenu rpVendedores;
    public static javax.swing.JMenu rpVendedores1;
    public static javax.swing.JMenu rpVendedores2;
    public static javax.swing.JMenu rpVendedores3;
    public static javax.swing.JMenu rpVentas;
    private javax.swing.JMenuItem smModUsuarios;
    public static javax.swing.JMenuItem smModUsuariosD;
    // End of variables declaration//GEN-END:variables
}
