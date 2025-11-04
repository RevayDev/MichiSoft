package com.michiStudios.michisoft.View.Seccions.PanelAdmin;

// Panel admin precentador
import com.michiStudios.michisoft.Precenter.panelAdminPrecenter;

//Paquetes adicionales
import javax.swing.table.DefaultTableModel;

/*
 * @author ROBERTO JIMENEZ
 */

public class PanelSucursales extends javax.swing.JPanel {

    private panelAdminPrecenter panelAdminPrecenter;
    private int fila;
    
    public PanelSucursales(panelAdminPrecenter panelAdminPrecenter) {
        this.panelAdminPrecenter = panelAdminPrecenter;
        initComponents();
        InfoSucursal.getSelectionModel().addListSelectionListener(e -> {
            fila = InfoSucursal.getSelectedRow();
            InputSucursal_Info.setEnabled(false);
            if (fila >= 0) { 
                InputSucursal_Info.setText(InfoSucursal.getValueAt(fila, 0).toString());
                InputSucursal_Info.setEnabled(true);
            }
        });
        actualizarTablaSucursales();
      
    }
    
    //actualizar datos de lista de sucursales disponibles
    private void actualizarTablaSucursales() {
        DefaultTableModel modelo = (DefaultTableModel) InfoSucursal.getModel();
        modelo.setRowCount(0); 

        for (String sucursal : panelAdminPrecenter.ReloadDataSucursal()) {
            int res[] = panelAdminPrecenter.GetSucursalInfo(sucursal);
            modelo.addRow(new Object[]{sucursal, res[0], res[1], res[2]});
       
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        PanelDeRegistro = new javax.swing.JPanel();
        Contenedor = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        SucursalLabel = new javax.swing.JLabel();
        InputSucursal = new javax.swing.JTextField();
        ButtomSend = new javax.swing.JToggleButton();
        PanelDeEditInfo = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        ContEdit = new javax.swing.JPanel();
        labeldentificacion = new javax.swing.JLabel();
        InputSucursal_Info = new javax.swing.JTextField();
        buttomDelete = new javax.swing.JToggleButton();
        buttomSave = new javax.swing.JToggleButton();
        TableInfoSucursale = new javax.swing.JScrollPane();
        InfoSucursal = new javax.swing.JTable();

        fondo.setBackground(new java.awt.Color(40, 88, 85));
        fondo.setPreferredSize(new java.awt.Dimension(1020, 550));

        PanelDeRegistro.setBackground(new java.awt.Color(40, 88, 85));

        Contenedor.setBackground(new java.awt.Color(27, 71, 68));

        title1.setBackground(new java.awt.Color(255, 255, 255));
        title1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("Crear Sucursal");

        SucursalLabel.setBackground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SucursalLabel.setForeground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setText("Nombre de sucursal");

        InputSucursal.setBackground(new java.awt.Color(255, 255, 255));
        InputSucursal.setForeground(new java.awt.Color(51, 51, 51));
        InputSucursal.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputSucursalActionPerformed(evt);
            }
        });

        ButtomSend.setBackground(new java.awt.Color(40, 88, 85));
        ButtomSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtomSend.setForeground(new java.awt.Color(255, 255, 255));
        ButtomSend.setText("Crear Sucursal");
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
                .addGap(22, 22, 22)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtomSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InputSucursal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ContenedorLayout.createSequentialGroup()
                        .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SucursalLabel)
                            .addComponent(title1))
                        .addGap(0, 133, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(title1)
                .addGap(18, 18, 18)
                .addComponent(SucursalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtomSend, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        PanelDeEditInfo.setBackground(new java.awt.Color(27, 71, 68));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Informacion");

        ContEdit.setBackground(new java.awt.Color(27, 71, 68));

        labeldentificacion.setBackground(new java.awt.Color(255, 255, 255));
        labeldentificacion.setForeground(new java.awt.Color(255, 255, 255));
        labeldentificacion.setText("Nombre de Sucursal");

        InputSucursal_Info.setBackground(new java.awt.Color(255, 255, 255));
        InputSucursal_Info.setForeground(new java.awt.Color(0, 0, 0));
        InputSucursal_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputSucursal_InfoActionPerformed(evt);
            }
        });

        buttomDelete.setBackground(new java.awt.Color(255, 51, 51));
        buttomDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttomDelete.setForeground(new java.awt.Color(255, 255, 255));
        buttomDelete.setText("Eliminar Sucursal");
        buttomDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomDeleteActionPerformed(evt);
            }
        });

        buttomSave.setBackground(new java.awt.Color(40, 88, 85));
        buttomSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttomSave.setForeground(new java.awt.Color(255, 255, 255));
        buttomSave.setText("Guardar Cambios");
        buttomSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContEditLayout = new javax.swing.GroupLayout(ContEdit);
        ContEdit.setLayout(ContEditLayout);
        ContEditLayout.setHorizontalGroup(
            ContEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContEditLayout.createSequentialGroup()
                        .addComponent(labeldentificacion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttomDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttomSave, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(InputSucursal_Info))
                .addContainerGap())
        );
        ContEditLayout.setVerticalGroup(
            ContEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContEditLayout.createSequentialGroup()
                .addComponent(labeldentificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputSucursal_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttomSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(buttomDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelDeEditInfoLayout = new javax.swing.GroupLayout(PanelDeEditInfo);
        PanelDeEditInfo.setLayout(PanelDeEditInfoLayout);
        PanelDeEditInfoLayout.setHorizontalGroup(
            PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDeEditInfoLayout.setVerticalGroup(
            PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout PanelDeRegistroLayout = new javax.swing.GroupLayout(PanelDeRegistro);
        PanelDeRegistro.setLayout(PanelDeRegistroLayout);
        PanelDeRegistroLayout.setHorizontalGroup(
            PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeRegistroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDeEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelDeRegistroLayout.setVerticalGroup(
            PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeRegistroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelDeEditInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        TableInfoSucursale.setBackground(new java.awt.Color(255, 255, 255));

        InfoSucursal.setBackground(new java.awt.Color(255, 255, 255));
        InfoSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sucursal", "Administradores", "Vendedores", "Cantidad de Piezas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableInfoSucursale.setViewportView(InfoSucursal);
        if (InfoSucursal.getColumnModel().getColumnCount() > 0) {
            InfoSucursal.getColumnModel().getColumn(0).setResizable(false);
            InfoSucursal.getColumnModel().getColumn(1).setResizable(false);
            InfoSucursal.getColumnModel().getColumn(2).setResizable(false);
            InfoSucursal.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(PanelDeRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TableInfoSucursale, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDeRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TableInfoSucursale)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InputSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputSucursalActionPerformed

    private void ButtomSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtomSendActionPerformed
       panelAdminPrecenter.AgregarSucursal(InputSucursal.getText());
       actualizarTablaSucursales();
    }//GEN-LAST:event_ButtomSendActionPerformed

    private void InputSucursal_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputSucursal_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputSucursal_InfoActionPerformed

    private void buttomDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomDeleteActionPerformed
         panelAdminPrecenter.DeleteSucursal(InputSucursal_Info.getText());
         actualizarTablaSucursales();
         InputSucursal_Info.setText("");
    }//GEN-LAST:event_buttomDeleteActionPerformed

    private void buttomSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomSaveActionPerformed

        panelAdminPrecenter.EditSucursal(InfoSucursal.getValueAt(fila, 0).toString(), InputSucursal_Info.getText());
        actualizarTablaSucursales();
        InputSucursal_Info.setText("");
    }//GEN-LAST:event_buttomSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtomSend;
    private javax.swing.JPanel ContEdit;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JTable InfoSucursal;
    private javax.swing.JTextField InputSucursal;
    private javax.swing.JTextField InputSucursal_Info;
    private javax.swing.JPanel PanelDeEditInfo;
    private javax.swing.JPanel PanelDeRegistro;
    private javax.swing.JLabel SucursalLabel;
    private javax.swing.JScrollPane TableInfoSucursale;
    private javax.swing.JToggleButton buttomDelete;
    private javax.swing.JToggleButton buttomSave;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel labeldentificacion;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
