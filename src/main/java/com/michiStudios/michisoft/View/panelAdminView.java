package com.michistudios.michisoft.View;

// Panel Admin
import com.michiStudios.michisoft.View.Seccions.PanelAdmin.*;
import com.michiStudios.michisoft.Precenter.panelAdminPrecenter;

// Paquetes adicionales
import java.awt.BorderLayout;
import javax.swing.JPanel;


/*
 * @author ROBERTO JIMENEZ
 */

public class panelAdminView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(panelAdminView.class.getName());
    private  panelAdminPrecenter panelAdminPrecenter;
    
    public panelAdminView(panelAdminPrecenter panelAdminPrecenter) {
        this.panelAdminPrecenter = panelAdminPrecenter;
        initComponents();
        InitContent();
    }
    
    // Renderizacio inicial
    private void InitContent(){
        PanelUsers UsuariosView = new PanelUsers(panelAdminPrecenter);
        UsuariosView.setSize(1020, 550);
        UsuariosView.setLocation(0,0);
        
        content.removeAll(); 
        content.add(UsuariosView, BorderLayout.CENTER); 
        content.revalidate();
        content.repaint(); 
    }
    
    // Renderizacion custom
    private void  ShowContent(JPanel panel){
        panel.setSize(1020, 550);
        panel.setLocation(0,0);
        
        content.removeAll(); 
        content.add(panel, BorderLayout.CENTER);
        content.revalidate(); 
        content.repaint(); 
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        nav = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        Seeccion = new javax.swing.JLabel();
        Admin = new javax.swing.JLabel();
        Usuarios = new javax.swing.JToggleButton();
        Sucursales = new javax.swing.JToggleButton();
        Piezas = new javax.swing.JToggleButton();
        Configuracion = new javax.swing.JToggleButton();
        ButoomExit = new javax.swing.JToggleButton();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 620));

        fondo.setBackground(new java.awt.Color(40, 88, 85));

        nav.setBackground(new java.awt.Color(40, 88, 85));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo+Text.png"))); // NOI18N

        Seeccion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Seeccion.setForeground(new java.awt.Color(255, 255, 255));
        Seeccion.setText("Seccion:");

        Admin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Admin.setForeground(new java.awt.Color(88, 184, 177));
        Admin.setText("ADMIN");

        Usuarios.setBackground(new java.awt.Color(28, 62, 60));
        Usuarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Usuarios.setForeground(new java.awt.Color(255, 255, 255));
        Usuarios.setText("Usuarios");
        Usuarios.setBorder(null);
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });

        Sucursales.setBackground(new java.awt.Color(28, 62, 60));
        Sucursales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sucursales.setForeground(new java.awt.Color(255, 255, 255));
        Sucursales.setText("Reportes");
        Sucursales.setBorder(null);
        Sucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SucursalesActionPerformed(evt);
            }
        });

        Piezas.setBackground(new java.awt.Color(28, 62, 60));
        Piezas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Piezas.setForeground(new java.awt.Color(255, 255, 255));
        Piezas.setText("Piezas");
        Piezas.setBorder(null);
        Piezas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiezasActionPerformed(evt);
            }
        });

        Configuracion.setBackground(new java.awt.Color(28, 62, 60));
        Configuracion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Configuracion.setForeground(new java.awt.Color(255, 255, 255));
        Configuracion.setText("Sucursales");
        Configuracion.setBorder(null);
        Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionActionPerformed(evt);
            }
        });

        ButoomExit.setBackground(new java.awt.Color(40, 88, 85));
        ButoomExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButoomExit.setForeground(new java.awt.Color(255, 255, 255));
        ButoomExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icons/Exit.png"))); // NOI18N
        ButoomExit.setBorder(null);
        ButoomExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoomExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navLayout = new javax.swing.GroupLayout(nav);
        nav.setLayout(navLayout);
        navLayout.setHorizontalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Seeccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Admin)
                .addGap(26, 26, 26)
                .addComponent(Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Sucursales, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Piezas, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(ButoomExit)
                .addGap(19, 19, 19))
        );
        navLayout.setVerticalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navLayout.createSequentialGroup()
                .addGroup(navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Sucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Piezas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ButoomExit))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Admin)
                            .addComponent(Seeccion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(nav, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
      ShowContent(new PanelSucursales(panelAdminPrecenter));
    }//GEN-LAST:event_ConfiguracionActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        ShowContent(new PanelUsers(panelAdminPrecenter));
    }//GEN-LAST:event_UsuariosActionPerformed

    private void SucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SucursalesActionPerformed
       ShowContent(new PanelReportes(panelAdminPrecenter));
    }//GEN-LAST:event_SucursalesActionPerformed

    private void PiezasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiezasActionPerformed
       ShowContent(new PanelPiezaControllers(panelAdminPrecenter));
    }//GEN-LAST:event_PiezasActionPerformed

    private void ButoomExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoomExitActionPerformed
       boolean res = panelAdminPrecenter.ExitPanel();
       if(res) this.setVisible(false);
    }//GEN-LAST:event_ButoomExitActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin;
    private javax.swing.JToggleButton ButoomExit;
    private javax.swing.JToggleButton Configuracion;
    private javax.swing.JToggleButton Piezas;
    private javax.swing.JLabel Seeccion;
    private javax.swing.JToggleButton Sucursales;
    private javax.swing.JToggleButton Usuarios;
    private javax.swing.JPanel content;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel nav;
    // End of variables declaration//GEN-END:variables
}
