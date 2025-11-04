package com.michiStudios.michisoft.View;

//Importar el Precentador del login
import com.michiStudios.michisoft.Precenter.loginPrecenter;

/*
 * @author ROBERTO JIMENEZ
 */

public class loginView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(loginView.class.getName());
    private loginPrecenter loginPrecenter;

    public loginView(loginPrecenter loginPrecenter) {
        this.loginPrecenter = loginPrecenter;
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        decoracion1 = new javax.swing.JLabel();
        decoracion2 = new javax.swing.JLabel();
        decoracion3 = new javax.swing.JLabel();
        decoracio4 = new javax.swing.JLabel();
        Contenedor = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        decoracionText = new javax.swing.JLabel();
        decoracionTextKey = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        InputUser = new javax.swing.JTextField();
        KeyLabel = new javax.swing.JLabel();
        InputKey = new javax.swing.JPasswordField();
        ButtomSend = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(40, 88, 85));
        fondo.setMaximumSize(new java.awt.Dimension(800, 600));
        fondo.setMinimumSize(new java.awt.Dimension(800, 600));
        fondo.setPreferredSize(new java.awt.Dimension(1020, 640));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo+Text.png"))); // NOI18N
        fondo.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        decoracion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Decoration1.png"))); // NOI18N
        fondo.add(decoracion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -160, 510, 480));

        decoracion2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Decoration2.png"))); // NOI18N
        fondo.add(decoracion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));

        decoracion3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Decoration3.png"))); // NOI18N
        fondo.add(decoracion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        decoracio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Decoration4.png"))); // NOI18N
        fondo.add(decoracio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, -1, -1));

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));

        title.setBackground(new java.awt.Color(40, 88, 85));
        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(40, 88, 85));
        title.setText("Ingresar");

        decoracionText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        decoracionText.setForeground(new java.awt.Color(255, 51, 51));
        decoracionText.setText("*");

        decoracionTextKey.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        decoracionTextKey.setForeground(new java.awt.Color(255, 51, 51));
        decoracionTextKey.setText("*");

        UserLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UserLabel.setText("Identificacion o correo");

        InputUser.setForeground(new java.awt.Color(51, 51, 51));
        InputUser.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUserActionPerformed(evt);
            }
        });

        KeyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KeyLabel.setText("Contraseña");

        InputKey.setForeground(new java.awt.Color(51, 51, 51));
        InputKey.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputKeyActionPerformed(evt);
            }
        });

        ButtomSend.setBackground(new java.awt.Color(40, 88, 85));
        ButtomSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtomSend.setForeground(new java.awt.Color(255, 255, 255));
        ButtomSend.setText("Entrar");
        ButtomSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtomSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(UserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decoracionText))
                    .addComponent(InputUser)
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(KeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(decoracionTextKey))
                    .addComponent(InputKey)
                    .addComponent(ButtomSend, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addGap(44, 44, 44))
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(title)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLabel)
                    .addComponent(decoracionText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyLabel)
                    .addComponent(decoracionTextKey, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputKey, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(ButtomSend, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        fondo.add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 510, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUserActionPerformed

    private void InputKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputKeyActionPerformed

    private void ButtomSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtomSendActionPerformed
       boolean res = loginPrecenter.Login(InputUser.getText(), InputKey.getPassword());
       if(res) this.setVisible(false);
    }//GEN-LAST:event_ButtomSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtomSend;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JPasswordField InputKey;
    private javax.swing.JTextField InputUser;
    private javax.swing.JLabel KeyLabel;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel decoracio4;
    private javax.swing.JLabel decoracion1;
    private javax.swing.JLabel decoracion2;
    private javax.swing.JLabel decoracion3;
    private javax.swing.JLabel decoracionText;
    private javax.swing.JLabel decoracionTextKey;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
