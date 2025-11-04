package com.michiStudios.michisoft.View.Seccions.PanelVendedor;

// Panel Vendedor
import com.michiStudios.michisoft.Precenter.panelVendedorPrecenter;

//Paquetes adicionales
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelInventario extends javax.swing.JPanel {
   
    private panelVendedorPrecenter panelVendedorPrecenter;
    
    public panelInventario(panelVendedorPrecenter panelVendedorPrecenter) {
        this.panelVendedorPrecenter = panelVendedorPrecenter;
        initComponents();
        actualizarTablaInventario();
    }
    
    private void actualizarTablaInventario() {
       DefaultTableModel modelo = (DefaultTableModel) TableInventarioSucursal.getModel();
       modelo.setRowCount(0);
       Object[] res =  panelVendedorPrecenter.getInventarioSucursal();
       ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>) res[0];
       String SucursalSelcTxt = (String) res[1];
       
       ArrayList<String> ids = data.get(0);
       ArrayList<String> nombres = data.get(1);
       ArrayList<String> cantidades = data.get(2);
       ArrayList<String> precios = data.get(3);

       for (int i = 0; i < ids.size(); i++) {
           int cantidad = Integer.parseInt(cantidades.get(i));
           if (cantidad > 0) {
               modelo.addRow(new Object[]{
                   ids.get(i),
                   nombres.get(i),
                   cantidad,
                   Double.parseDouble(precios.get(i))
               });
  
           }
       }
       SucursalSelc.setText("Sucursal: " + SucursalSelcTxt);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InventarioLabe = new javax.swing.JLabel();
        TableInventario = new javax.swing.JScrollPane();
        TableInventarioSucursal = new javax.swing.JTable();
        SucursalSelc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(40, 88, 85));

        InventarioLabe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InventarioLabe.setForeground(new java.awt.Color(255, 255, 255));
        InventarioLabe.setText("Inventario");

        TableInventarioSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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
        TableInventarioSucursal.setMaximumSize(new java.awt.Dimension(5, 5));
        TableInventario.setViewportView(TableInventarioSucursal);
        if (TableInventarioSucursal.getColumnModel().getColumnCount() > 0) {
            TableInventarioSucursal.getColumnModel().getColumn(0).setResizable(false);
            TableInventarioSucursal.getColumnModel().getColumn(1).setResizable(false);
            TableInventarioSucursal.getColumnModel().getColumn(2).setResizable(false);
            TableInventarioSucursal.getColumnModel().getColumn(3).setResizable(false);
        }

        SucursalSelc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SucursalSelc.setForeground(new java.awt.Color(255, 255, 255));
        SucursalSelc.setText("Sucursal: {Sucursal}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InventarioLabe, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addGap(840, 840, 840))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SucursalSelc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TableInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(InventarioLabe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(SucursalSelc)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InventarioLabe;
    private javax.swing.JLabel SucursalSelc;
    private javax.swing.JScrollPane TableInventario;
    private javax.swing.JTable TableInventarioSucursal;
    // End of variables declaration//GEN-END:variables
}
