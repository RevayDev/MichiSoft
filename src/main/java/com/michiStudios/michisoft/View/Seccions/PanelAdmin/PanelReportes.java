package com.michiStudios.michisoft.View.Seccions.PanelAdmin;

//Panel admin precentador
import com.michiStudios.michisoft.Precenter.panelAdminPrecenter;

//Paquetes adicionales
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/*
 * @author ROBERTO JIMENEZ
 */

public class PanelReportes extends javax.swing.JPanel {
    private panelAdminPrecenter panelAdminPrecenter;
    
    public PanelReportes(panelAdminPrecenter panelAdminPrecenter) {
        initComponents();
        this.panelAdminPrecenter = panelAdminPrecenter;
        reloadDataInfo();
    }
    
    //Cargador de datos
    public void reloadDataInfo(){
        SelcSucursal_Esta.removeAllItems();
        SelecSucursal_Invetario.removeAllItems();
        SelcPiezaID.removeAllItems();
        
        for (String sucursal : panelAdminPrecenter.ReloadDataSucursal()) {
            if (sucursal != null){
                SelcSucursal_Esta.addItem(sucursal);
                SelecSucursal_Invetario.addItem(sucursal);
            }
        }
        
        ArrayList<ArrayList<String>> Data = panelAdminPrecenter.ReloadDataItems();
        ArrayList<String> name = Data.get(0);
        ArrayList<String> ids = Data.get(1);
        
        for (int i = 0; i< Data.get(0).size(); i++) {
            if(ids.get(i) != null){
               SelcPiezaID.addItem(name.get(i)+ " - " + ids.get(i));
            }  
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        EstadisticaSucursal = new javax.swing.JLabel();
        ContEstadisticaSucursal = new javax.swing.JPanel();
        SucursalLabel = new javax.swing.JLabel();
        SelcSucursal_Esta = new javax.swing.JComboBox<>();
        PiezaMessageMax = new javax.swing.JLabel();
        PiezaMessageMin = new javax.swing.JLabel();
        DispSucursal = new javax.swing.JLabel();
        ContDispSucursal = new javax.swing.JPanel();
        CodigoPiezaLabel = new javax.swing.JLabel();
        SelcPiezaID = new javax.swing.JComboBox<>();
        TableInfoDisp = new javax.swing.JScrollPane();
        TablaInfoDispSucursales = new javax.swing.JTable();
        Inventario = new javax.swing.JLabel();
        ContInventario = new javax.swing.JPanel();
        SelecSucursal_Invetario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TableInfoInventario = new javax.swing.JScrollPane();
        TableInfoInventario_Sucursal = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1020, 640));

        Fondo.setBackground(new java.awt.Color(40, 88, 85));
        Fondo.setPreferredSize(new java.awt.Dimension(1020, 640));

        EstadisticaSucursal.setBackground(new java.awt.Color(255, 255, 255));
        EstadisticaSucursal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EstadisticaSucursal.setForeground(new java.awt.Color(255, 255, 255));
        EstadisticaSucursal.setText("Maximo y Minimo por Sucursal");

        ContEstadisticaSucursal.setBackground(new java.awt.Color(27, 71, 68));

        SucursalLabel.setBackground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setForeground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setText("Sucursal");

        SelcSucursal_Esta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barranquilla", "Medellin", "Bogota" }));
        SelcSucursal_Esta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelcSucursal_EstaActionPerformed(evt);
            }
        });

        PiezaMessageMax.setBackground(new java.awt.Color(255, 255, 255));
        PiezaMessageMax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PiezaMessageMax.setForeground(new java.awt.Color(255, 255, 255));
        PiezaMessageMax.setText("Pieza con mas unidades: {PiezaMax} - {CantidadMax}");

        PiezaMessageMin.setBackground(new java.awt.Color(255, 255, 255));
        PiezaMessageMin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PiezaMessageMin.setForeground(new java.awt.Color(255, 255, 255));
        PiezaMessageMin.setText("Pieza con menor unidades: {PiezaMin} - {CantidadMin}");

        javax.swing.GroupLayout ContEstadisticaSucursalLayout = new javax.swing.GroupLayout(ContEstadisticaSucursal);
        ContEstadisticaSucursal.setLayout(ContEstadisticaSucursalLayout);
        ContEstadisticaSucursalLayout.setHorizontalGroup(
            ContEstadisticaSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContEstadisticaSucursalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ContEstadisticaSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PiezaMessageMin)
                    .addComponent(PiezaMessageMax)
                    .addComponent(SucursalLabel)
                    .addComponent(SelcSucursal_Esta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        ContEstadisticaSucursalLayout.setVerticalGroup(
            ContEstadisticaSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContEstadisticaSucursalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(SucursalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelcSucursal_Esta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PiezaMessageMax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PiezaMessageMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        DispSucursal.setBackground(new java.awt.Color(255, 255, 255));
        DispSucursal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DispSucursal.setForeground(new java.awt.Color(255, 255, 255));
        DispSucursal.setText("Disponivilidad por Sucursal");

        ContDispSucursal.setBackground(new java.awt.Color(27, 71, 68));

        CodigoPiezaLabel.setBackground(new java.awt.Color(255, 255, 255));
        CodigoPiezaLabel.setForeground(new java.awt.Color(255, 255, 255));
        CodigoPiezaLabel.setText("Codigo de la Pieza");

        SelcPiezaID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item1", "Item2", "Item3" }));
        SelcPiezaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelcPiezaIDActionPerformed(evt);
            }
        });

        TablaInfoDispSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sucursal", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableInfoDisp.setViewportView(TablaInfoDispSucursales);
        if (TablaInfoDispSucursales.getColumnModel().getColumnCount() > 0) {
            TablaInfoDispSucursales.getColumnModel().getColumn(0).setResizable(false);
            TablaInfoDispSucursales.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout ContDispSucursalLayout = new javax.swing.GroupLayout(ContDispSucursal);
        ContDispSucursal.setLayout(ContDispSucursalLayout);
        ContDispSucursalLayout.setHorizontalGroup(
            ContDispSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContDispSucursalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ContDispSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodigoPiezaLabel)
                    .addComponent(TableInfoDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(SelcPiezaID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        ContDispSucursalLayout.setVerticalGroup(
            ContDispSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContDispSucursalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CodigoPiezaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelcPiezaID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TableInfoDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Inventario.setBackground(new java.awt.Color(255, 255, 255));
        Inventario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Inventario.setForeground(new java.awt.Color(255, 255, 255));
        Inventario.setText("Inventario");

        ContInventario.setBackground(new java.awt.Color(27, 71, 68));

        SelecSucursal_Invetario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barranquilla", "Medellin", "Bogota" }));
        SelecSucursal_Invetario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecSucursal_InvetarioActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sucursal");

        TableInfoInventario_Sucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Pieza", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableInfoInventario.setViewportView(TableInfoInventario_Sucursal);
        if (TableInfoInventario_Sucursal.getColumnModel().getColumnCount() > 0) {
            TableInfoInventario_Sucursal.getColumnModel().getColumn(0).setResizable(false);
            TableInfoInventario_Sucursal.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout ContInventarioLayout = new javax.swing.GroupLayout(ContInventario);
        ContInventario.setLayout(ContInventarioLayout);
        ContInventarioLayout.setHorizontalGroup(
            ContInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContInventarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ContInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableInfoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(SelecSucursal_Invetario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        ContInventarioLayout.setVerticalGroup(
            ContInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContInventarioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelecSucursal_Invetario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TableInfoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(DispSucursal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(EstadisticaSucursal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ContDispSucursal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ContEstadisticaSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(385, 385, 385))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(ContInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Inventario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EstadisticaSucursal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(ContEstadisticaSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DispSucursal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContDispSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ContInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void SelcSucursal_EstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelcSucursal_EstaActionPerformed
        /*
        Esta funcin de selector (addActionListener) fue ayuda de una IA,
        que ayudo a poder enviar sucursal y mostrar depende de la seleccion.
        */
        SelcSucursal_Esta.addActionListener(e -> {
            String[] res = panelAdminPrecenter.MaxAndMinPiezas(SelcSucursal_Esta.getSelectedItem().toString());
            PiezaMessageMax.setText("Piezas con mayor unidades: " + res[0] + " - " + (Integer.parseInt(res[1]) == 0 ? "Ninguno" : res[1]));
            PiezaMessageMin.setText("Piezas con menor unidades: " + res[2] + " - " + (Integer.parseInt(res[3]) == 0 ? "Ninguno" : res[3]));
    
        });
  
    }//GEN-LAST:event_SelcSucursal_EstaActionPerformed

    private void SelcPiezaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelcPiezaIDActionPerformed
        /*
        Esta funcin de selector (addActionListener) fue ayuda de una IA,
        que ayudo a poder enviar sucursal y mostrar depende de la seleccion.
        */
        SelcPiezaID.addActionListener(e -> {
            String piezaSeleccionada = (String) SelcPiezaID.getSelectedItem();
        
            DefaultTableModel modelo = (DefaultTableModel) TablaInfoDispSucursales.getModel();
            modelo.setRowCount(0); 
    
            ArrayList<ArrayList<String>> inventario = panelAdminPrecenter.getPiezaID(piezaSeleccionada);
            ArrayList<String> sucursales = inventario.get(0);
            ArrayList<String> cantidades = inventario.get(1);

            for (int i = 0; i < sucursales.size(); i++) {
                modelo.addRow(new Object[]{sucursales.get(i), cantidades.get(i)});
            }

        });

    }//GEN-LAST:event_SelcPiezaIDActionPerformed

    private void SelecSucursal_InvetarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecSucursal_InvetarioActionPerformed
        /*
        Esta función de selector (addActionListener) fue ayuda de una IA,
        que ayudó a poder enviar sucursal y mostrar dependiendo de la selección.
        */
        SelecSucursal_Invetario.addActionListener(e -> {
            try {
                String sucursalSeleccionada = (String) SelecSucursal_Invetario.getSelectedItem();

                if (sucursalSeleccionada == null || sucursalSeleccionada.trim().isEmpty()) {
                    return;
                }

                DefaultTableModel modelo = (DefaultTableModel) TableInfoInventario_Sucursal.getModel();
                modelo.setRowCount(0); 

                ArrayList<ArrayList<String>> inventario = panelAdminPrecenter.getInventarioSucursal(sucursalSeleccionada);  

                if (inventario != null && inventario.size() >= 2) { 
                    ArrayList<String> productos = inventario.get(0);
                    ArrayList<String> cantidades = inventario.get(1);

                    if (productos != null && cantidades != null && 
                        productos.size() > 0 && cantidades.size() > 0) {


                        int minSize = Math.min(productos.size(), cantidades.size());

                        for (int i = 0; i < minSize; i++) {
                            try {

                                if (productos.get(i) != null && cantidades.get(i) != null) {
                                    modelo.addRow(new Object[]{
                                        productos.get(i), 
                                        Integer.valueOf(cantidades.get(i))
                                    });
                                }
                            } catch (NumberFormatException ex) {

                                modelo.addRow(new Object[]{productos.get(i), cantidades.get(i)});
                            }
                        } 
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }//GEN-LAST:event_SelecSucursal_InvetarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodigoPiezaLabel;
    private javax.swing.JPanel ContDispSucursal;
    private javax.swing.JPanel ContEstadisticaSucursal;
    private javax.swing.JPanel ContInventario;
    private javax.swing.JLabel DispSucursal;
    private javax.swing.JLabel EstadisticaSucursal;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Inventario;
    private javax.swing.JLabel PiezaMessageMax;
    private javax.swing.JLabel PiezaMessageMin;
    private javax.swing.JComboBox<String> SelcPiezaID;
    private javax.swing.JComboBox<String> SelcSucursal_Esta;
    private javax.swing.JComboBox<String> SelecSucursal_Invetario;
    private javax.swing.JLabel SucursalLabel;
    private javax.swing.JTable TablaInfoDispSucursales;
    private javax.swing.JScrollPane TableInfoDisp;
    private javax.swing.JScrollPane TableInfoInventario;
    private javax.swing.JTable TableInfoInventario_Sucursal;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
