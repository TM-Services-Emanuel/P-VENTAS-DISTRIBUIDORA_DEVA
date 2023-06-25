package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal2;
import Componentes.RenderDecimalconPuntos;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlArticuloMovil;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgArticulosMovil extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    clsExportarExcel Export;
    public Reporte jasper;

    public dlgArticulosMovil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        jasper = new Reporte();
        ckStockActionPerformed(null);
        txtBuscar.requestFocus();
        menubar.setVisible(false);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestor de Productos");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestor de Productos");
        }
    }

    public static void Renders() {
        try {
            dlgArticulosMovil.tbProductos.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal2());
            dlgArticulosMovil.tbProductos.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimalconPuntos());
            dlgArticulosMovil.tbProductos.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal2());
            dlgArticulosMovil.tbProductos.getColumnModel().getColumn(7).setCellRenderer(new RenderDecimal2());
            dlgArticulosMovil.tbProductos.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimal2());
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mbtnMmodificar = new javax.swing.JMenuItem();
        mbtnEliminar = new javax.swing.JMenuItem();
        grupoBotones = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        ckStock = new rojerusan.RSCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        btnExportar = new newscomponents.RSButtonBigIcon_new();
        menubar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoE = new javax.swing.JMenuItem();
        itemModificarE = new javax.swing.JMenuItem();
        itemEliminarE = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemOrdenC = new javax.swing.JMenuItem();
        itemOrdenN = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemNuevoE1 = new javax.swing.JMenuItem();

        mbtnMmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificarproducto - copia.png"))); // NOI18N
        mbtnMmodificar.setText("     Modificar");
        mbtnMmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnMmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mbtnMmodificar);

        mbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteproducto - copia.png"))); // NOI18N
        mbtnEliminar.setText("     Eliminar");
        mbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mbtnEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        panelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        panelImage2.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_search_black_20.png"))); // NOI18N
        jLabel3.setText("BUSCADOR DE PRODUCTO/S");

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        ckStock.setForeground(new java.awt.Color(17, 35, 46));
        ckStock.setText("Excluir productos con stock 0");
        ckStock.setColorCheck(new java.awt.Color(0, 102, 0));
        ckStock.setColorUnCheck(new java.awt.Color(255, 0, 0));
        ckStock.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ckStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckStock, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar)
                        .addComponent(ckStock, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jScrollPane1.setOpaque(false);

        tbProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tbProductos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tbProductos.setOpaque(false);
        tbProductos.setRowHeight(20);
        tbProductos.setShowGrid(true);
        tbProductos.setShowHorizontalLines(false);
        tbProductos.getTableHeader().setResizingAllowed(false);
        tbProductos.getTableHeader().setReorderingAllowed(false);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbProductosMousePressed(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 6));

        btnNuevo.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevo.setBorder(null);
        btnNuevo.setText("NUEVO");
        btnNuevo.setToolTipText("CREAR UN NUEVO PRODUCTO                        ");
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
        jPanel1.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(0, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("MODIFICAR");
        btnModificar.setToolTipText("MODIFICAR UN PRODUCTO SELECCIONADO");
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
        jPanel1.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setToolTipText("ELIMINAR UN PRODUCTO SELECCIONADO");
        btnEliminar.setBgHover(new java.awt.Color(0, 153, 153));
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
        jPanel1.add(btnEliminar);

        btnActualizar.setBackground(new java.awt.Color(0, 102, 102));
        btnActualizar.setBorder(null);
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setToolTipText("ACTUALIZAR LISTA DE PRODUCTOS");
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
        jPanel1.add(btnActualizar);

        panelImage1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 280, 56));

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
        panelImage1.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1159, 0, 20, 20));

        btnExportar.setBackground(new java.awt.Color(255, 255, 255));
        btnExportar.setBorder(null);
        btnExportar.setToolTipText("EXPORTAR INFORMACIÓN DE TABLA DE PRODUCTOS A EXCEL");
        btnExportar.setBgHover(new java.awt.Color(255, 255, 255));
        btnExportar.setFgIcon(new java.awt.Color(0, 102, 102));
        btnExportar.setFgIconHover(new java.awt.Color(0, 153, 153));
        btnExportar.setFocusPainted(false);
        btnExportar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnExportar.setIconTextGap(0);
        btnExportar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FILE_DOWNLOAD);
        btnExportar.setPixels(0);
        btnExportar.setSizeIcon(30.0F);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addComponent(jScrollPane1)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 1179, Short.MAX_VALUE)
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );

        menubar.setBackground(new java.awt.Color(255, 255, 255));
        menubar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jMenu1.setBorder(null);
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevoE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevoE.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_box_black_24.png"))); // NOI18N
        itemNuevoE.setText("CREAR UN NUEVO PRODUCTO                        ");
        itemNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevoE);

        itemModificarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificarE.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_black_24.png"))); // NOI18N
        itemModificarE.setText("MODIFICAR UN PRODUCTO SELECCIONADO");
        itemModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificarE);

        itemEliminarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminarE.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_delete_forever_black_24.png"))); // NOI18N
        itemEliminarE.setText("ELIMINAR UN PRODUCTO SELECCIONADO");
        itemEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemEliminarE);
        jMenu1.add(jSeparator4);

        itemOrdenC.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemOrdenC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_format_list_numbered_black_24.png"))); // NOI18N
        itemOrdenC.setText("ORDENAR TABLA DE PRODUCTOS POR ID");
        itemOrdenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenCActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenC);

        itemOrdenN.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemOrdenN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_sort_by_alpha_black_24.png"))); // NOI18N
        itemOrdenN.setText("ORDENAR TABLA DE PRODUCTOS POR DESCRIPCIÓN");
        itemOrdenN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenNActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenN);
        jMenu1.add(jSeparator2);

        itemExportar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_file_download_black_24.png"))); // NOI18N
        itemExportar.setText("EXPORTAR INFORMACIÓN DE TABLA DE PRODUCTOS A EXCEL");
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        jMenu1.add(itemExportar);
        jMenu1.add(jSeparator3);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_exit_to_app_black_24.png"))); // NOI18N
        itemSalir.setText("SALIR");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        menubar.add(jMenu1);

        jMenu2.setBorder(null);
        jMenu2.setText("Reporte");
        jMenu2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jMenu2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevoE1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevoE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itemNuevoE1.setText("Reporte de Productos con Stock Crítico");
        itemNuevoE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoE1ActionPerformed(evt);
            }
        });
        jMenu2.add(itemNuevoE1);

        menubar.add(jMenu2);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int number = tbProductos.rowAtPoint(p);
            ListSelectionModel modelos = tbProductos.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tbProductosMousePressed
    void nuevoArticulo() {
        dlgGestArticulosMovil gestArticulos = new dlgGestArticulosMovil(null, true);
        gestArticulos.setLocationRelativeTo(null);
        gestArticulos.Nuevo();
        gestArticulos.setVisible(true);

    }
    private void mbtnMmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnMmodificarActionPerformed
        // TODO add your handling code here:
        dlgGestArticulosMovil a = new dlgGestArticulosMovil(null, true);
        a.setLocationRelativeTo(null);
        controlArticuloMovil.aModifcar();
        dlgGestArticulosMovil.btnNuevo.setEnabled(false);
        dlgGestArticulosMovil.btnModificar.setEnabled(true);
        dlgGestArticulosMovil.btnGuardar.setEnabled(false);
        dlgGestArticulosMovil.btnCancelar.setEnabled(true);
        dlgGestArticulosMovil.txtCodInterno.requestFocus();
        a.modcboClasificacion();
        a.modcboUM();
        a.modcboImpuesto();
        a.setVisible(true);
    }//GEN-LAST:event_mbtnMmodificarActionPerformed
    void modArticulo() {
        int x = tbProductos.getSelectedRow();
        if (x < 0) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        } else {
            try {
                dlgGestArticulosMovil a = new dlgGestArticulosMovil(null, true);
                a.setLocationRelativeTo(null);
                controlArticuloMovil.aModifcar();
                dlgGestArticulosMovil.btnNuevo.setEnabled(false);
                dlgGestArticulosMovil.btnModificar.setEnabled(true);
                dlgGestArticulosMovil.btnGuardar.setEnabled(false);
                dlgGestArticulosMovil.btnCancelar.setEnabled(true);
                dlgGestArticulosMovil.txtCodInterno.requestFocus();
                a.modcboClasificacion();
                a.modcboUM();
                a.modcboImpuesto();
                a.setVisible(true);
            } catch (Exception e) {
                //Mensajes.error("Seleccione una fila de la tabla");     
            }
            tbProductos.clearSelection();
        }

    }

    void delArticulo() {
        try {
            int x = tbProductos.getSelectedRow();
            String desc = tbProductos.getValueAt(x, 3).toString();
            int rpta = Mensajes.confirmar("Desea realmente eliminar " + desc + " de la lista");
            if (rpta == 0) {
                controlArticuloMovil.delArticulo();
                if (ckStock.isSelected()) {
                    CabecerasTablas.ArticulosMovil(tbProductos);
                    CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                    controlArticuloMovil.listArticuloconStock(tbProductos);
                    Renders();
                } else {
                    CabecerasTablas.ArticulosMovil(tbProductos);
                    CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                    controlArticuloMovil.listArticulo(tbProductos);
                    Renders();
                }
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }
    private void mbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int x = tbProductos.getSelectedRow();
            String desc = tbProductos.getValueAt(x, 4).toString();
            int rpta = Mensajes.confirmar("Desea realmente eliminar " + desc + " de la lista");
            if (rpta == 0) {
                controlArticuloMovil.delArticulo();
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.listArticulo(tbProductos);
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_mbtnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        if (txtBuscar.getText().trim().length() == 0) {
            if (ckStock.isSelected()) {
                CabecerasTablas.ArticulosMovil(tbProductos);
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.listArticuloconStock(tbProductos);
                Renders();
            } else {
                CabecerasTablas.ArticulosMovil(tbProductos);
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.listArticulo(tbProductos);
                Renders();
            }
        }else {
            try {
                String cod = txtBuscar.getText();
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.filtrarGral(tbProductos, cod);
                Renders();
            } catch (Exception e) {
                System.out.println("Mensaje de Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                dlgGestArticulosMovil a = new dlgGestArticulosMovil(null, true);
                a.setLocationRelativeTo(null);
                controlArticuloMovil.aModifcar();
                //a.setTitle("Gestionar Productos");
                dlgGestArticulosMovil.btnNuevo.setEnabled(false);
                dlgGestArticulosMovil.btnModificar.setEnabled(true);
                dlgGestArticulosMovil.btnGuardar.setEnabled(false);
                dlgGestArticulosMovil.btnCancelar.setEnabled(true);
                dlgGestArticulosMovil.txtCodInterno.requestFocus();
                a.modcboClasificacion();
                a.modcboUM();
                a.modcboImpuesto();
                a.setVisible(true);
            } catch (Exception e) {
                Mensajes.error("No se pudo cagar informacion del Producto");

            }
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void itemModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemModificarEActionPerformed

    private void itemEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarActionPerformed(null);
    }//GEN-LAST:event_itemEliminarEActionPerformed

    private void itemOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenCActionPerformed
        // TODO add your handling code here:
        if (ckStock.isSelected()) {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticuloconStock(tbProductos);
            Renders();
        } else {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticulo(tbProductos);
            Renders();
        }

        // CabecerasTablas.limpiarTablasArticuloM(tbProductos);
        // controlArticuloMovil.listArticulo(tbProductos, "idproducto");
    }//GEN-LAST:event_itemOrdenCActionPerformed

    private void itemOrdenNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenNActionPerformed
        // TODO add your handling code here:
        if (ckStock.isSelected()) {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticuloconStock(tbProductos);
            Renders();
        } else {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticulo(tbProductos);
            Renders();
        }

        //CabecerasTablas.limpiarTablasArticuloM(tbProductos);
        //controlArticuloMovil.listArticulo(tbProductos, "descripcion");
    }//GEN-LAST:event_itemOrdenNActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed

        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tbProductos);
        } catch (IOException ex) {
            Logger.getLogger(dlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemSalirActionPerformed

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                dlgGestArticulosMovil a = new dlgGestArticulosMovil(null, true);
                a.setLocationRelativeTo(null);
                controlArticuloMovil.aModifcar();
                dlgGestArticulosMovil.btnNuevo.setEnabled(false);
                dlgGestArticulosMovil.btnModificar.setEnabled(true);
                dlgGestArticulosMovil.btnGuardar.setEnabled(false);
                dlgGestArticulosMovil.btnCancelar.setEnabled(true);
                dlgGestArticulosMovil.txtCodInterno.requestFocus();
                a.modcboClasificacion();
                a.modcboUM();
                a.modcboImpuesto();
                a.setVisible(true);
            } catch (Exception e) {
                //Mensajes.error("No se pudo cagar informacion del Producto" + e.getMessage());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtBuscar.requestFocus();
            txtBuscar.selectAll();
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
       /* if (txtBuscar.getText().trim().length() == 0) {
            if (ckStock.isSelected()) {
                CabecerasTablas.ArticulosMovil(tbProductos);
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.listArticuloconStock(tbProductos);
                Renders();
            } else {
                CabecerasTablas.ArticulosMovil(tbProductos);
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.listArticulo(tbProductos);
                Renders();
            }
        } else {
            try {
                String cod = txtBuscar.getText();
                CabecerasTablas.limpiarTablasArticuloM(tbProductos);
                controlArticuloMovil.filtrarGral(tbProductos, cod);
                Renders();
            } catch (Exception e) {
                System.out.println("Mensaje de Error: " + e.getMessage());
            }
            if (tbProductos.getRowCount() <= 0) {
                txtBuscar.requestFocus();
                txtBuscar.selectAll();
            } else {
                //tbProductos.requestFocus();
                tbProductos.getSelectionModel().setSelectionInterval(0, 0);
                tbProductos.requestFocus();
            }
        }*/
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tbProductos.getRowCount() <= 0) {
                txtBuscar.requestFocus();
                txtBuscar.selectAll();
            } else {
                //tbProductos.requestFocus();
                tbProductos.getSelectionModel().setSelectionInterval(0, 0);
                tbProductos.requestFocus();
            }
        }*/
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void itemNuevoE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoE1ActionPerformed
        // TODO add your handling code here:
        /* try {
            dlgReporteStockCritico rsc = new dlgReporteStockCritico(null, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/

        Mensajes.Sistema("La función: Reporte de Stock crítico se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        //
    }//GEN-LAST:event_itemNuevoE1ActionPerformed

    private void ckStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckStockActionPerformed
        // TODO add your handling code here:
        if (ckStock.isSelected()) {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticuloconStock(tbProductos);
            Renders();
        } else {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticulo(tbProductos);
            Renders();
        }
    }//GEN-LAST:event_ckStockActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevoArticulo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        modArticulo();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        delArticulo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (ckStock.isSelected()) {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticuloconStock(tbProductos);
            Renders();
        } else {
            CabecerasTablas.ArticulosMovil(tbProductos);
            CabecerasTablas.limpiarTablasArticuloM(tbProductos);
            controlArticuloMovil.listArticulo(tbProductos);
            Renders();
        }
        txtBuscar.setText("");
        txtBuscar.requestFocus();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tbProductos);
        } catch (IOException ex) {
            Logger.getLogger(dlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        } else {
            txtBuscar.requestFocus();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

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
            java.util.logging.Logger.getLogger(dlgArticulosMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgArticulosMovil dialog = new dlgArticulosMovil(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnActualizar;
    public static newscomponents.RSButtonBigIcon_new btnEliminar;
    public static newscomponents.RSButtonBigIcon_new btnExportar;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    private javax.swing.ButtonGroup buttonGroup1;
    public static rojerusan.RSCheckBox ckStock;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JMenuItem itemEliminarE;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemModificarE;
    private javax.swing.JMenuItem itemNuevoE;
    public javax.swing.JMenuItem itemNuevoE1;
    private javax.swing.JMenuItem itemOrdenC;
    private javax.swing.JMenuItem itemOrdenN;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem mbtnEliminar;
    private javax.swing.JMenuItem mbtnMmodificar;
    private javax.swing.JMenuBar menubar;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    public static javax.swing.JTable tbProductos;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
