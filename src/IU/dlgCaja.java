package IU;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Software;
import Componentes.validarCampos;
import Controladores.ControlCaja;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class dlgCaja extends javax.swing.JDialog {
static String UsuarioL="";
    
    public dlgCaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        UsuarioL=Login.getUsuarioLogueado();
        lbUsuario.setText(UsuarioL);
        lbFecha.setText(Fecha.formatoFechaFF(Fecha.fechaCorrecta()));
        lbHora.setText(Fecha.FormatoHoraSinSSString(Fecha.darHora()));
        btnIniciar.setVisible(false);
        txtCaInicial.requestFocus();
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Cargar valor inicial de la caja");
        }else{
            this.setTitle(Software.getSoftware()+" - Cargar valor inicial de la caja");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCaInicial = new javax.swing.JTextField();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 8, 44, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Hora:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 31, 44, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Usuario:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 55, -1, -1));

        lbFecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbFecha.setText("jLabel3");
        jPanel2.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 8, 189, -1));

        lbHora.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbHora.setText("jLabel5");
        jPanel2.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 31, 189, -1));

        lbUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbUsuario.setText("jLabel7");
        jPanel2.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 55, 189, -1));

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 40, 330, 80));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EFECTIVO BASE");

        txtCaInicial.setBackground(new java.awt.Color(17, 35, 46));
        txtCaInicial.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        txtCaInicial.setForeground(new java.awt.Color(255, 255, 255));
        txtCaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaInicial.setText("0");
        txtCaInicial.setBorder(null);
        txtCaInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCaInicial.setOpaque(false);
        txtCaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaInicialActionPerformed(evt);
            }
        });
        txtCaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCaInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCaInicialKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 127, 330, -1));

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setBorder(null);
        btnSalir.setBgHover(new java.awt.Color(255, 0, 0));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir.setIconTextGap(0);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setPixels(0);
        btnSalir.setSizeIcon(20.0F);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        Blanco.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 1, 23, 23));

        btnIniciar.setEnabled(false);
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        Blanco.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 5, 65, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿El monto con que se iniciara es el correcto?", "Iniciar Caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            ControlCaja.addCaja();
            this.dispose();
        }

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtCaInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaInicialKeyReleased
        // TODO add your handling code here:
        try {
            if (txtCaInicial.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtCaInicial.setText(df.format(Integer.valueOf(txtCaInicial.getText().trim().replace(".", "").replace(",", ""))));

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
    }//GEN-LAST:event_txtCaInicialKeyReleased

    private void txtCaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaInicialActionPerformed
        // TODO add your handling code here:
        try {
            if (txtCaInicial.getText().isEmpty()) {
                btnIniciar.setEnabled(false);
                txtCaInicial.setText("0");
                txtCaInicial.selectAll();
            } else if (Integer.parseInt(txtCaInicial.getText().replace(",", "").replace(".", "")) <= 0) {
                btnIniciar.setEnabled(false);
                txtCaInicial.setText("0");
                txtCaInicial.selectAll();
            } else {
                    btnIniciar.setEnabled(true);
                    btnIniciar.doClick();

            }
        } catch (NumberFormatException e) {
            txtCaInicial.setText("0");
            txtCaInicial.selectAll();
        }
        
    }//GEN-LAST:event_txtCaInicialActionPerformed

    private void txtCaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaInicialKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCaInicial);
    }//GEN-LAST:event_txtCaInicialKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(dlgCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgCaja dialog = new dlgCaja(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnIniciar;
    public static newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lbFecha;
    public static javax.swing.JLabel lbHora;
    public static javax.swing.JLabel lbUsuario;
    public static javax.swing.JTextField txtCaInicial;
    // End of variables declaration//GEN-END:variables
}
