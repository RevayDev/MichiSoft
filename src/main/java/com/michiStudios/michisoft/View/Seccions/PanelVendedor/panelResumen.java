package com.michiStudios.michisoft.View.Seccions.PanelVendedor;

//Panel vendedor
import com.michiStudios.michisoft.Precenter.panelVendedorPrecenter;

//Paquetes adicionales
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelResumen extends javax.swing.JPanel {
    private panelVendedorPrecenter panelVendedorPrecenter;
    
    public panelResumen(panelVendedorPrecenter panelVendedorPrecenter) {
        this.panelVendedorPrecenter = panelVendedorPrecenter;
        initComponents();
        actualizarTablaAgotandoce();
        actualizarResumen();
    }
    
    public void actualizarTablaAgotandoce(){
        DefaultTableModel modelo = (DefaultTableModel) TableInfoAgotada.getModel();
        modelo.setRowCount(0); 
        
        ArrayList<ArrayList<String>> inventario = panelVendedorPrecenter.getPiezaAgotada();
        ArrayList<String> sucursales = inventario.get(0);
        ArrayList<String> cantidades = inventario.get(1);

        for (int i = 0; i < sucursales.size(); i++) {
             modelo.addRow(new Object[]{sucursales.get(i), cantidades.get(i)});
        }
    }
    
    public void actualizarResumen(){
        String[] Data = panelVendedorPrecenter.getInfoResume();
        MessageSucural.setText("Sucursal: " + Data[0]);
        MessagePiezas.setText("Piezas: " + Data[1]);
        MessageClientes.setText("Clientes: " + Data[2]);
        MessageInventario.setText("Inventario Neto: " + Data[3]);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgotandoceLabel = new javax.swing.JLabel();
        TableInfoPiezaAgotada = new javax.swing.JScrollPane();
        TableInfoAgotada = new javax.swing.JTable();
        InformacionLabel = new javax.swing.JLabel();
        ContResumen = new javax.swing.JPanel();
        MessageSucural = new javax.swing.JLabel();
        MessagePiezas = new javax.swing.JLabel();
        MessageClientes = new javax.swing.JLabel();
        MessageInventario = new javax.swing.JLabel();
        RegistroRecienteLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(40, 88, 85));

        AgotandoceLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AgotandoceLabel.setForeground(new java.awt.Color(255, 255, 255));
        AgotandoceLabel.setText("Apunto de agotarce (menos de 30 unidades)");

        TableInfoAgotada.setModel(new javax.swing.table.DefaultTableModel(
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
        TableInfoPiezaAgotada.setViewportView(TableInfoAgotada);

        InformacionLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InformacionLabel.setForeground(new java.awt.Color(255, 255, 255));
        InformacionLabel.setText("Informacion de la sucursal");

        ContResumen.setBackground(new java.awt.Color(27, 71, 68));

        MessageSucural.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MessageSucural.setForeground(new java.awt.Color(255, 255, 255));
        MessageSucural.setText("Sucursal: {Sucursal Name}");

        MessagePiezas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MessagePiezas.setForeground(new java.awt.Color(255, 255, 255));
        MessagePiezas.setText("Piezas: {Number Piezas}");

        MessageClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MessageClientes.setForeground(new java.awt.Color(255, 255, 255));
        MessageClientes.setText("Clientes: {Number Clients}");

        MessageInventario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MessageInventario.setForeground(new java.awt.Color(255, 255, 255));
        MessageInventario.setText("Inventario Neto: {Number Piezas}");

        javax.swing.GroupLayout ContResumenLayout = new javax.swing.GroupLayout(ContResumen);
        ContResumen.setLayout(ContResumenLayout);
        ContResumenLayout.setHorizontalGroup(
            ContResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContResumenLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ContResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContResumenLayout.createSequentialGroup()
                        .addComponent(MessageClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))
                    .addComponent(MessageInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ContResumenLayout.createSequentialGroup()
                        .addComponent(MessagePiezas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(95, 95, 95))
                    .addGroup(ContResumenLayout.createSequentialGroup()
                        .addComponent(MessageSucural, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70))))
        );
        ContResumenLayout.setVerticalGroup(
            ContResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContResumenLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(MessageSucural, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessagePiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MessageClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MessageInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        RegistroRecienteLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RegistroRecienteLabel.setForeground(new java.awt.Color(255, 255, 255));
        RegistroRecienteLabel.setText("Registros recientes");

        jPanel1.setBackground(new java.awt.Color(27, 71, 68));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proximamente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableInfoPiezaAgotada)
                    .addComponent(AgotandoceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InformacionLabel)
                    .addComponent(RegistroRecienteLabel)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ContResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InformacionLabel)
                    .addComponent(AgotandoceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ContResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(RegistroRecienteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TableInfoPiezaAgotada))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgotandoceLabel;
    private javax.swing.JPanel ContResumen;
    private javax.swing.JLabel InformacionLabel;
    private javax.swing.JLabel MessageClientes;
    private javax.swing.JLabel MessageInventario;
    private javax.swing.JLabel MessagePiezas;
    private javax.swing.JLabel MessageSucural;
    private javax.swing.JLabel RegistroRecienteLabel;
    private javax.swing.JTable TableInfoAgotada;
    private javax.swing.JScrollPane TableInfoPiezaAgotada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
