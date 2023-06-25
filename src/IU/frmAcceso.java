package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.traerIP;
import Controladores.ControlLogeo;
import Controladores.controlPerfil;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.UnsupportedLookAndFeelException;

public final class frmAcceso extends javax.swing.JFrame {
    public frmAcceso() {
        initComponents();
        titulo();
        cargarIcono();
        try { 
            lblIP.setText("HOST IP : "+traerIP.getIP());
            lblHost.setText("HOST: "+traerIP.getHostname());
        } catch (Exception e) {
        }
        txtUsuario.requestFocus();
        
    }
    
    void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Bienvenido");
        }else{
            this.setTitle("Bienvendo a "+Software.getSoftware());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jPanel4 = new javax.swing.JPanel();
        lblHost = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new RSMaterialComponent.RSTextFieldMaterial();
        psPasword = new RSMaterialComponent.RSPasswordMaterial();
        btnEntrar = new newscomponents.RSButtonBigIcon_new();
        lblMensaje = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblIP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir1 = new newscomponents.RSButtonBigIcon_new();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(210, 229, 235));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHost.setForeground(new java.awt.Color(255, 255, 255));
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHost.setText("NOMBRE HOST");
        lblHost.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblHost.setVerifyInputWhenFocusTarget(false);
        jPanel4.add(lblHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 290, 25));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CONTRASEÑA");

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setColorMaterial(new java.awt.Color(0, 153, 153));
        txtUsuario.setDisabledTextColor(new java.awt.Color(0, 153, 153));
        txtUsuario.setDoubleBuffered(true);
        txtUsuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtUsuario.setPlaceholder("");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        psPasword.setForeground(new java.awt.Color(0, 0, 0));
        psPasword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psPasword.setColorMaterial(new java.awt.Color(0, 153, 153));
        psPasword.setDisabledTextColor(new java.awt.Color(0, 153, 153));
        psPasword.setDoubleBuffered(true);
        psPasword.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        psPasword.setPlaceholder("");
        psPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psPaswordActionPerformed(evt);
            }
        });
        psPasword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psPaswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psPaswordKeyTyped(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(0, 102, 102));
        btnEntrar.setBorder(null);
        btnEntrar.setBgHover(new java.awt.Color(0, 153, 153));
        btnEntrar.setFocusPainted(false);
        btnEntrar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnEntrar.setIconTextGap(0);
        btnEntrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.THUMB_UP);
        btnEntrar.setPixels(0);
        btnEntrar.setSizeIcon(35.0F);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Roboto Thin", 0, 11)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(psPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 74, 290, -1));

        panelImage1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 290, -1));

        jPanel5.setBackground(new java.awt.Color(4, 76, 76));

        lblIP.setBackground(new java.awt.Color(255, 255, 255));
        lblIP.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblIP.setForeground(new java.awt.Color(255, 255, 255));
        lblIP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP.setText("IP : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelImage1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 421, 310, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon.png"))); // NOI18N
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, 100));

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
        panelImage1.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 0, 15, 15));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LOGO-FACT-EXPRESS - 256.png"))); // NOI18N
        panelImage1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 290, 42));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        psPasword.requestFocus();
        psPasword.selectAll();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=10;
        if (txtUsuario.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void psPaswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPaswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEntrar.doClick();
        }
    }//GEN-LAST:event_psPaswordKeyPressed

    private void psPaswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPaswordKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=15;
        if (psPasword.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_psPaswordKeyTyped

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que cerrar el sistema?");
        if (rpta == 0) {
            //this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        try {
            ControlLogeo.logear();
            controlPerfil.perfil();
            this.dispose();
        } catch (Exception e) {
            txtUsuario.requestFocus();
            txtUsuario.selectAll();
            System.out.println("Error al cargar Principal: "+e.toString());
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void psPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psPaswordActionPerformed

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/icon.png"));
            setIconImage(icon);
            setVisible(true);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[])throws UnsupportedLookAndFeelException {
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
       java.util.logging.Logger.getLogger(frmAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
        //</editor-fold>
        
       //</editor-fold>
           

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmAcceso().setVisible(true);
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static newscomponents.RSButtonBigIcon_new btnEntrar;
    public static newscomponents.RSButtonBigIcon_new btnSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JLabel lblHost;
    public static javax.swing.JLabel lblIP;
    public static javax.swing.JLabel lblMensaje;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public static RSMaterialComponent.RSPasswordMaterial psPasword;
    public static RSMaterialComponent.RSTextFieldMaterial txtUsuario;
    // End of variables declaration//GEN-END:variables

}
