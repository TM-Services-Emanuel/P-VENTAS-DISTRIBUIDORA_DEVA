package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlProveedor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public final class dlgProveedores extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    clsExportarExcel Export;
    public dlgProveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.proveedor(tablaProveedores);
        controlProveedor.listProveedor(tablaProveedores);
        cbkBuscarActionPerformed(null);
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestionar proveedores");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestionar proveedores");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemPModificarP = new javax.swing.JMenuItem();
        itemPEliminarP = new javax.swing.JMenuItem();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jPanel3 = new javax.swing.JPanel();
        btnNuevoP = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        btnActualizar = new newscomponents.RSButtonBigIcon_new();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        cbkBuscar = new javax.swing.JCheckBox();
        btnExportar = new newscomponents.RSButtonBigIcon_new();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        jPopupMenu1.setLabel("Opciones");

        itemPModificarP.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editUser15.png"))); // NOI18N
        itemPModificarP.setText("     Modificar");
        itemPModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPModificarPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPModificarP);

        itemPEliminarP.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteUser15 (2).png"))); // NOI18N
        itemPEliminarP.setText("     Eliminar");
        itemPEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPEliminarPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPEliminarP);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1079, 0, 20, 20));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 6));

        btnNuevoP.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevoP.setBorder(null);
        btnNuevoP.setText("NUEVO");
        btnNuevoP.setToolTipText("CREAR UN NUEVO PRODUCTO                        ");
        btnNuevoP.setBgHover(new java.awt.Color(0, 153, 153));
        btnNuevoP.setFocusPainted(false);
        btnNuevoP.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnNuevoP.setIconTextGap(0);
        btnNuevoP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevoP.setPixels(0);
        btnNuevoP.setSizeIcon(40.0F);
        btnNuevoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevoP);

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
        jPanel3.add(btnModificar);

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
        jPanel3.add(btnEliminar);

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
        jPanel3.add(btnActualizar);

        Oscuro.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 280, 56));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 75));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBuscar.setEnabled(false);
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
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 5, 692, 23));

        cbkBuscar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        cbkBuscar.setSelected(true);
        cbkBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cbkBuscar.setOpaque(false);
        cbkBuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        cbkBuscar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cbkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(cbkBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 5, -1, -1));

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
        jPanel2.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 24, 31));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_search_black_20.png"))); // NOI18N
        jLabel3.setText("BUSCADOR DE PROVEEDORES");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, 23));

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 77, 1098, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        tablaProveedores.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProveedores.setGridColor(new java.awt.Color(204, 204, 204));
        tablaProveedores.setRowHeight(18);
        tablaProveedores.setShowGrid(true);
        tablaProveedores.setShowVerticalLines(false);
        tablaProveedores.getTableHeader().setResizingAllowed(false);
        tablaProveedores.getTableHeader().setReorderingAllowed(false);
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProveedoresMousePressed(evt);
            }
        });
        tablaProveedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaProveedoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 110, 1098, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String cod = txtBuscar.getText();
        CabecerasTablas.limpiarTablas(tablaProveedores);
        controlProveedor.filProveedor(tablaProveedores, cod);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tablaProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt))
        {
            Point p = evt.getPoint();
            int number = tablaProveedores.rowAtPoint(p);
            ListSelectionModel modelos = tablaProveedores.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tablaProveedoresMousePressed

    private void itemPModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPModificarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPModificarPActionPerformed

    private void itemPEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPEliminarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPEliminarPActionPerformed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
        {
            try {
                dlgGestProveedor prov = new dlgGestProveedor(null, true);
                prov.setLocationRelativeTo(null);
                controlProveedor.aModificar();
                prov.setTitle("Modificación de Proveedor");
                dlgGestProveedor.btnModificar.setEnabled(true);
                dlgGestProveedor.btnGuardar.setEnabled(false);
                dlgGestProveedor.btnNuevo.setEnabled(false);
                dlgGestProveedor.btnCancelar.setEnabled(true);
                prov.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No se pudo cargar información del proveedor");
        }
        }
    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void cbkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkBuscarActionPerformed
        // TODO add your handling code here:
        habilitarbusqueda();
    }//GEN-LAST:event_cbkBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtBuscar.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaProveedores.requestFocus();
            int r=tablaProveedores.getRowCount ();
            tablaProveedores.changeSelection ( tablaProveedores.getRowCount ()-r, 5, false, false );
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void tablaProveedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProveedoresKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                dlgGestProveedor prov = new dlgGestProveedor(null, true);
                prov.setLocationRelativeTo(null);
                controlProveedor.aModificar();
                prov.setTitle("Modificación de Proveedor");
                dlgGestProveedor.btnModificar.setEnabled(true);
                dlgGestProveedor.btnGuardar.setEnabled(false);
                dlgGestProveedor.btnNuevo.setEnabled(false);
                dlgGestProveedor.btnCancelar.setEnabled(true);
                prov.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No se pudo cargar información del proveedor");
        }
        }
    }//GEN-LAST:event_tablaProveedoresKeyPressed

    private void tablaProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaProveedoresMouseEntered

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            try {
                //cargarComboBox.cargar(dlgGestArticulos.cbProveedor, "SELECT pro_codigo, pro_razonsocial, pro_indicador FROM proveedor WHERE pro_indicador='S'");
                //dlgGestArticulos.cbProveedor.requestFocus();
                //cargarComboBox.cargar(dlgSalidaMercaderia.cbProveedor, "SELECT pro_codigo, pro_razonsocial, pro_indicador FROM proveedor WHERE pro_indicador='S'");
                
            } catch (Exception e) {
            }
        this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tablaProveedores);
        } catch (IOException ex) {
            Logger.getLogger(dlgProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnNuevoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPActionPerformed
        // TODO add your handling code here:
        dlgGestProveedor prov = new dlgGestProveedor(null, true);
        prov.setLocationRelativeTo(null);
        prov.setTitle("Agregar Proveedor");
        prov.setVisible(true);
    }//GEN-LAST:event_btnNuevoPActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestProveedor prov = new dlgGestProveedor(null, true);
                prov.setLocationRelativeTo(null);
                controlProveedor.aModificar();
                prov.setTitle("Modificación de Proveedor");
                dlgGestProveedor.btnModificar.setEnabled(true);
                dlgGestProveedor.btnGuardar.setEnabled(false);
                dlgGestProveedor.btnNuevo.setEnabled(false);
                dlgGestProveedor.btnCancelar.setEnabled(true);
                prov.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tablaProveedores.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlProveedor.delProveedor();
                    CabecerasTablas.limpiarTablas(tablaProveedores);
                    controlProveedor.listProveedor(tablaProveedores);
                }
            } catch (Exception e) {
                //Mensajes.informacion("Seleccione un fila de la tabla");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String cod = txtBuscar.getText();
        CabecerasTablas.limpiarTablas(tablaProveedores);
        controlProveedor.filProveedor(tablaProveedores, cod);
        txtBuscar.setText("");
        txtBuscar.requestFocus();
    }//GEN-LAST:event_btnActualizarActionPerformed

    void habilitarbusqueda(){
        if(cbkBuscar.isSelected()){
            txtBuscar.setEnabled(true);
            txtBuscar.requestFocus();
        }else{
            txtBuscar.setEnabled(false);
            txtBuscar.setText("");
            CabecerasTablas.limpiarTablas(tablaProveedores);
            controlProveedor.listProveedor(tablaProveedores);
        }
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
            java.util.logging.Logger.getLogger(dlgProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgProveedores dialog = new dlgProveedores(new javax.swing.JFrame(), true);
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
    public static newscomponents.RSButtonBigIcon_new btnActualizar;
    public static newscomponents.RSButtonBigIcon_new btnEliminar;
    public static newscomponents.RSButtonBigIcon_new btnExportar;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevoP;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    private javax.swing.JCheckBox cbkBuscar;
    private javax.swing.JMenuItem itemPEliminarP;
    private javax.swing.JMenuItem itemPModificarP;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaProveedores;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
