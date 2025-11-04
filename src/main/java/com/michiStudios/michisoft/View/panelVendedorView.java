package com.michiStudios.michisoft.View;

// panel de Vendedor
import com.michiStudios.michisoft.Precenter.panelVendedorPrecenter;
import com.michiStudios.michisoft.View.Seccions.PanelVendedor.*;

// Paquetes adicionales
import java.awt.BorderLayout;
import javax.swing.JPanel;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelVendedorView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(panelVendedorView.class.getName());
    private  panelVendedorPrecenter panelVendedorPrecenter;
    
    public panelVendedorView(panelVendedorPrecenter panelVendedorPrecenter) {
        this.panelVendedorPrecenter = panelVendedorPrecenter;
        initComponents();
        InitContent();
    }
    
    //Renderizacion inicial
    private void InitContent(){
        panelRegisterVenta panelRegisterVenta = new panelRegisterVenta(panelVendedorPrecenter);
        panelRegisterVenta.setSize(1020, 550);
        panelRegisterVenta.setLocation(0,0);
        
        content.removeAll();
        content.add(panelRegisterVenta, BorderLayout.CENTER);
        content.revalidate();
        content.repaint(); 
    }
    
    //Renderizacion custom
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
        RegisterVenta = new javax.swing.JToggleButton();
        Inventario = new javax.swing.JToggleButton();
        Equipo = new javax.swing.JToggleButton();
        Resumen = new javax.swing.JToggleButton();
        ButoomExit = new javax.swing.JToggleButton();
        Seeccion = new javax.swing.JLabel();
        Admin = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 620));

        fondo.setBackground(new java.awt.Color(40, 88, 85));

        nav.setBackground(new java.awt.Color(40, 88, 85));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo+Text.png"))); // NOI18N

        RegisterVenta.setBackground(new java.awt.Color(28, 62, 60));
        RegisterVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegisterVenta.setForeground(new java.awt.Color(255, 255, 255));
        RegisterVenta.setText("Registrar");
        RegisterVenta.setBorder(null);
        RegisterVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterVentaActionPerformed(evt);
            }
        });

        Inventario.setBackground(new java.awt.Color(28, 62, 60));
        Inventario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Inventario.setForeground(new java.awt.Color(255, 255, 255));
        Inventario.setText("Inventario");
        Inventario.setBorder(null);
        Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioActionPerformed(evt);
            }
        });

        Equipo.setBackground(new java.awt.Color(28, 62, 60));
        Equipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Equipo.setForeground(new java.awt.Color(255, 255, 255));
        Equipo.setText("Equipo");
        Equipo.setBorder(null);
        Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipoActionPerformed(evt);
            }
        });

        Resumen.setBackground(new java.awt.Color(28, 62, 60));
        Resumen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Resumen.setForeground(new java.awt.Color(255, 255, 255));
        Resumen.setText("Resumen");
        Resumen.setBorder(null);
        Resumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumenActionPerformed(evt);
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

        Seeccion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Seeccion.setForeground(new java.awt.Color(255, 255, 255));
        Seeccion.setText("Seccion:");

        Admin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Admin.setForeground(new java.awt.Color(88, 184, 177));
        Admin.setText("VENTA");

        javax.swing.GroupLayout navLayout = new javax.swing.GroupLayout(nav);
        nav.setLayout(navLayout);
        navLayout.setHorizontalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Seeccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegisterVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Equipo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Resumen, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ButoomExit)
                .addGap(17, 17, 17))
        );
        navLayout.setVerticalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navLayout.createSequentialGroup()
                .addGroup(navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Admin)
                            .addComponent(Seeccion)))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(RegisterVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Resumen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ButoomExit)))
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

    private void ResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumenActionPerformed
       ShowContent(new panelResumen(panelVendedorPrecenter));
    }//GEN-LAST:event_ResumenActionPerformed

    private void RegisterVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterVentaActionPerformed
        ShowContent(new panelRegisterVenta(panelVendedorPrecenter));
    }//GEN-LAST:event_RegisterVentaActionPerformed

    private void InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioActionPerformed
      ShowContent(new panelInventario(panelVendedorPrecenter));
    }//GEN-LAST:event_InventarioActionPerformed

    private void EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipoActionPerformed
      ShowContent(new panelEquipo(panelVendedorPrecenter));
    }//GEN-LAST:event_EquipoActionPerformed

    private void ButoomExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoomExitActionPerformed
      boolean res =  panelVendedorPrecenter.ExitPanel();
      if(res) this.setVisible(false);
    }//GEN-LAST:event_ButoomExitActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin;
    private javax.swing.JToggleButton ButoomExit;
    private javax.swing.JToggleButton Equipo;
    private javax.swing.JToggleButton Inventario;
    private javax.swing.JToggleButton RegisterVenta;
    private javax.swing.JToggleButton Resumen;
    private javax.swing.JLabel Seeccion;
    private javax.swing.JPanel content;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel nav;
    // End of variables declaration//GEN-END:variables
}
