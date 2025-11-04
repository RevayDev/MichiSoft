package com.michiStudios.michisoft.View.Seccions.PanelVendedor;

//Panel Vendedor
import com.michiStudios.michisoft.Precenter.panelVendedorPrecenter;

//Paquetes adicionales
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelEquipo extends javax.swing.JPanel {
    private panelVendedorPrecenter panelVendedorPrecenter;
    
    public panelEquipo(panelVendedorPrecenter panelVendedorPrecenter ) {
        this.panelVendedorPrecenter = panelVendedorPrecenter;
        initComponents();
        actualizarTablaIEquipo();
    }
    private void actualizarTablaIEquipo() {
       DefaultTableModel modelo = (DefaultTableModel) InfoUser.getModel();
       modelo.setRowCount(0);
       Object[] res =  panelVendedorPrecenter.getEquipo();
       ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>) res[0];
       String SucursalSelcTxt = (String) res[1];
       
       for (ArrayList<String> fila : data) {
                modelo.addRow(new Object[]{fila.get(0), fila.get(1), fila.get(2)
            });
        }
       
       SucursalSelc.setText("Sucursal: " + SucursalSelcTxt);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EquipoLabe = new javax.swing.JLabel();
        TableInfoUsers = new javax.swing.JScrollPane();
        InfoUser = new javax.swing.JTable();
        SucursalSelc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(40, 88, 85));

        EquipoLabe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        EquipoLabe.setForeground(new java.awt.Color(255, 255, 255));
        EquipoLabe.setText("Lista de tu equipo");

        TableInfoUsers.setBackground(new java.awt.Color(255, 255, 255));

        InfoUser.setBackground(new java.awt.Color(255, 255, 255));
        InfoUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre completo", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableInfoUsers.setViewportView(InfoUser);
        if (InfoUser.getColumnModel().getColumnCount() > 0) {
            InfoUser.getColumnModel().getColumn(0).setResizable(false);
            InfoUser.getColumnModel().getColumn(1).setResizable(false);
            InfoUser.getColumnModel().getColumn(2).setResizable(false);
        }

        SucursalSelc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SucursalSelc.setForeground(new java.awt.Color(255, 255, 255));
        SucursalSelc.setText("Sucursal: {Sucursal}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SucursalSelc, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addComponent(EquipoLabe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TableInfoUsers)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(EquipoLabe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableInfoUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(SucursalSelc)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EquipoLabe;
    private javax.swing.JTable InfoUser;
    private javax.swing.JLabel SucursalSelc;
    private javax.swing.JScrollPane TableInfoUsers;
    // End of variables declaration//GEN-END:variables
}
