package IU;

import Componentes.Mensajes;
import Componentes.Software;
import java.awt.Toolkit;

public final class dlgAyuda extends javax.swing.JDialog {

    public dlgAyuda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        informacion();
        cargarIcono();
        jLabel13.setText(System.getenv("COMPUTERNAME"));
        jLabel14.setText(System.getProperty("user.name"));
        jLabel15.setText(System.getenv("PROCESSOR_IDENTIFIER"));
        jLabel16.setText(System.getProperty("os.name"));
        jLabel17.setText(System.getProperty("java.version"));
    }
    
    final void informacion(){
        if(Software.getVersion().equals("null")){
            lbVersion.setText("0");
        }else{
            lbVersion.setText(Software.getVersion());
        }
        if(Software.getDesarrollador().equals("null")){
            lbDesarrollador.setText("Desarrollador: No especificado");
        }else{
            lbDesarrollador.setText("Desarrollador: "+Software.getDesarrollador());
        }
        if(Software.getProfesion().equals("null")){
            lbProfesion.setText("Título: No especificado");
        }else{
            lbProfesion.setText(Software.getProfesion());
        }
        if(Software.getCorreo().equals("null")){
            lbcorreo.setText("Correo: No especificado");
        }else{
            lbcorreo.setText("Correo: "+Software.getCorreo());
        }
        if(Software.getTelefono().equals("null")){
            lbCelular.setText("Celular: No especificado");
        }else{
            lbCelular.setText("Celular: "+Software.getTelefono());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbDesarrollador = new javax.swing.JLabel();
        lbProfesion = new javax.swing.JLabel();
        lbcorreo = new javax.swing.JLabel();
        lbCelular = new javax.swing.JLabel();
        lbVersion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbCompu = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbProcesador = new javax.swing.JLabel();
        lbSO = new javax.swing.JLabel();
        lbJava = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del Sistema");
        setUndecorated(true);
        setResizable(false);

        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jPanel2.setOpaque(false);

        lbDesarrollador.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDesarrollador.setText("Lic. Emanuel M. Sosa Vera");

        lbProfesion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbProfesion.setText("Analista de Sistemas Informaticos");

        lbcorreo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbcorreo.setText("Direccion de Correo:");

        lbCelular.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbCelular.setText("Celular:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDesarrollador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(lbCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbDesarrollador)
                .addGap(1, 1, 1)
                .addComponent(lbProfesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbcorreo)
                .addGap(3, 3, 3)
                .addComponent(lbCelular)
                .addGap(6, 6, 6))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 185, 405, -1));

        lbVersion.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbVersion.setForeground(new java.awt.Color(255, 255, 255));
        lbVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVersion.setText("2021 - V1.5.0");
        jPanel1.add(lbVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 162, 380, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Soluciones efectivas y de calidad a tu alcance!");
        jLabel1.setOpaque(true);
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 250, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 34)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tm_services - 256.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 290, 110));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 17, 380, 160));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 415, 280));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setOpaque(false);

        lbCompu.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbCompu.setText("Computadora :");

        lbUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbUsuario.setText("Usuario :");

        lbProcesador.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbProcesador.setText("Procesador :");

        lbSO.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbSO.setText("S.O. :");

        lbJava.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbJava.setText("Version de Java :");

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel13.setText("jLabel6");

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel14.setText("jLabel7");

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel15.setText("jLabel8");

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel16.setText("jLabel9");

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel17.setText("jLabel10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCompu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbProcesador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbJava, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCompu)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProcesador)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSO)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbJava)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Blanco.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 320, 415, -1));

        rSButtonIconUno1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonIconUno1.setBackgroundHover(new java.awt.Color(255, 0, 0));
        rSButtonIconUno1.setForegroundText(new java.awt.Color(0, 0, 0));
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        rSButtonIconUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno1ActionPerformed(evt);
            }
        });
        Blanco.add(rSButtonIconUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 0, 25, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonIconUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_rSButtonIconUno1ActionPerformed

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
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgAyuda dialog = new dlgAyuda(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCompu;
    private javax.swing.JLabel lbDesarrollador;
    private javax.swing.JLabel lbJava;
    private javax.swing.JLabel lbProcesador;
    private javax.swing.JLabel lbProfesion;
    private javax.swing.JLabel lbSO;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbVersion;
    private javax.swing.JLabel lbcorreo;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    // End of variables declaration//GEN-END:variables
}
