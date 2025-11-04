package com.michiStudios.michisoft.View.Seccions.PanelVendedor;

//Panel vendedor
import com.michiStudios.michisoft.Precenter.panelVendedorPrecenter;

//Paquetes adicionales
import java.util.Map;

/*
 * @author ROBERTO JIMENEZ
 */

public class panelRegisterVenta extends javax.swing.JPanel {
    private panelVendedorPrecenter panelVendedorPrecenter;
    
    public panelRegisterVenta(panelVendedorPrecenter panelVendedorPrecenter) {
        this.panelVendedorPrecenter = panelVendedorPrecenter;
        initComponents();
        cargarProductos();
    }
    
    private void actualizarInfoProducto() {
        String producto = (String) SelcProduct.getSelectedItem();
        if (producto != null) {
            String infoProducto = panelVendedorPrecenter.obtenerInformacionProducto(producto);
            PiezaMessage.setText(infoProducto);
        }
    }

    private void cargarProductos() {
        SelcProduct.removeAllItems();
        Map<String, String> productos = panelVendedorPrecenter.obtenerProductos();

        if (productos.isEmpty()) {
            PiezaMessage.setText("No hay productos disponibles");
            return;
        }
        for (String nombreProducto : productos.keySet()) {
            SelcProduct.addItem(nombreProducto);
        }
        if (SelcProduct.getItemCount() > 0) {
            actualizarInfoProducto();
        }
    }

    private void limpiarCamposCliente() {
        InputClientName.setText("");
        InputClientID.setText("");
        InputClientPhone.setText("");
        InputClientAdress.setText("");
        InputCantidad.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        SelcProduct = new javax.swing.JComboBox<>();
        InputCantidad = new javax.swing.JTextField();
        PiezaMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        InputClientName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        InputClientID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InputClientAdress = new javax.swing.JTextField();
        InputClientPhone = new javax.swing.JTextField();
        GenFacture = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(40, 88, 85));

        jPanel1.setBackground(new java.awt.Color(27, 71, 68));

        title2.setBackground(new java.awt.Color(255, 255, 255));
        title2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setText("Cantidad a Vender");

        SelcProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barranquilla", "Medellin", "Bogota" }));
        SelcProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelcProductActionPerformed(evt);
            }
        });

        InputCantidad.setBackground(new java.awt.Color(255, 255, 255));
        InputCantidad.setForeground(new java.awt.Color(51, 51, 51));
        InputCantidad.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCantidadActionPerformed(evt);
            }
        });

        PiezaMessage.setBackground(new java.awt.Color(255, 255, 255));
        PiezaMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PiezaMessage.setForeground(new java.awt.Color(255, 255, 255));
        PiezaMessage.setText("Cantidad Disponible");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PiezaMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(InputCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelcProduct, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(SelcProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PiezaMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto");

        jPanel2.setBackground(new java.awt.Color(27, 71, 68));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");

        InputClientName.setBackground(new java.awt.Color(255, 255, 255));
        InputClientName.setForeground(new java.awt.Color(51, 51, 51));
        InputClientName.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputClientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputClientNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Documento: ");

        InputClientID.setBackground(new java.awt.Color(255, 255, 255));
        InputClientID.setForeground(new java.awt.Color(51, 51, 51));
        InputClientID.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputClientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputClientIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion:");

        InputClientAdress.setBackground(new java.awt.Color(255, 255, 255));
        InputClientAdress.setForeground(new java.awt.Color(51, 51, 51));
        InputClientAdress.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputClientAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputClientAdressActionPerformed(evt);
            }
        });

        InputClientPhone.setBackground(new java.awt.Color(255, 255, 255));
        InputClientPhone.setForeground(new java.awt.Color(51, 51, 51));
        InputClientPhone.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputClientPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputClientPhoneActionPerformed(evt);
            }
        });

        GenFacture.setBackground(new java.awt.Color(40, 88, 85));
        GenFacture.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GenFacture.setForeground(new java.awt.Color(255, 255, 255));
        GenFacture.setText("Generar Factura");
        GenFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenFactureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenFacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(InputClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(InputClientAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputClientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {InputClientAdress, InputClientID, InputClientName, InputClientPhone});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputClientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputClientAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(GenFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Informacion del cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InputClientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputClientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputClientNameActionPerformed

    private void InputClientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputClientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputClientIDActionPerformed

    private void InputClientPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputClientPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputClientPhoneActionPerformed

    private void InputClientAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputClientAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputClientAdressActionPerformed

    private void GenFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenFactureActionPerformed
        String producto = (String) SelcProduct.getSelectedItem();
        String cantidadText = InputCantidad.getText().trim();
        String nombre = InputClientName.getText().trim();
        String documento = InputClientID.getText().trim();
        String telefono = InputClientPhone.getText().trim();
        String direccion = InputClientAdress.getText().trim();

        // Llamada al presentador
        panelVendedorPrecenter.procesarVenta(producto, cantidadText, nombre, documento, telefono, direccion);

        actualizarInfoProducto();
        limpiarCamposCliente();
    }//GEN-LAST:event_GenFactureActionPerformed

    private void InputCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCantidadActionPerformed

    private void SelcProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelcProductActionPerformed
        actualizarInfoProducto();
    }//GEN-LAST:event_SelcProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenFacture;
    private javax.swing.JTextField InputCantidad;
    private javax.swing.JTextField InputClientAdress;
    private javax.swing.JTextField InputClientID;
    private javax.swing.JTextField InputClientName;
    private javax.swing.JTextField InputClientPhone;
    private javax.swing.JLabel PiezaMessage;
    private javax.swing.JComboBox<String> SelcProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
}
