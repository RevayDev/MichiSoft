package com.michiStudios.michisoft.View.Seccions.PanelAdmin;


// Panel admin precentador
import com.michiStudios.michisoft.Precenter.panelAdminPrecenter;

//Paquetes adicionales
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * @author ROBERTO JIMENEZ
 */

public class PanelPiezaControllers extends javax.swing.JPanel {
    private panelAdminPrecenter panelAdminPrecenter;
    private int fila;
    
    public PanelPiezaControllers(panelAdminPrecenter panelAdminPrecenter) {
        initComponents();
        this.panelAdminPrecenter = panelAdminPrecenter;
        /*
        Esta funcin de selector (addActionListener) fue ayuda de una IA,
        que ayudo a poder enviar sucursal y mostrar depende de la seleccion.
        */
        InfoPieza.getSelectionModel().addListSelectionListener(e -> {
            fila = InfoPieza.getSelectedRow();
            if (fila >= 0) { 
                InputPiezaID_Info.setText(InfoPieza.getValueAt(fila, 0).toString());
                InputPiezaID_Info.setEnabled(false);
                InputNombrePieza_Info.setText(InfoPieza.getValueAt(fila, 1).toString());
                InputPice_Edit.setText(InfoPieza.getValueAt(fila, 2).toString());
                cantidadPiezas_Edit.setText(InfoPieza.getValueAt(fila, 3).toString());
                SelcSucursal_Info.setSelectedItem(InfoPieza.getValueAt(fila, 4).toString());
            }
        });
        actualizarTablaPiezas();
        reloadDataInfo();
    }
    
    // Precargar datos
    private void actualizarTablaPiezas() {
        DefaultTableModel modelo = (DefaultTableModel) InfoPieza.getModel();
        modelo.setRowCount(0);
        ArrayList<ArrayList<String>> data = panelAdminPrecenter.GetInfoPiezas();

        for (ArrayList<String> fila : data) {
            int cantidad = Integer.parseInt(fila.get(3));
            if (cantidad > 0) {
                double precio = Double.parseDouble(fila.get(2));
                modelo.addRow(new Object[]{fila.get(0), fila.get(1), precio,  cantidad,  fila.get(4)});
            }
        }
    }
    
    //Recarga Menu de seleccion
    public void reloadDataInfo(){
        SelcSucursal.removeAllItems();
        SelcSucursal_Info.removeAllItems();
        SelcSucursal_Info.setEnabled(false);
        InputPiezaID_Info.setEnabled(false);
        for (String sucursal : panelAdminPrecenter.ReloadDataSucursal()) {
            if (sucursal != null){
                SelcSucursal.addItem(sucursal);
                SelcSucursal_Info.addItem(sucursal);
                SelcSucursal_Info.setEnabled(true);
            }
        }
        SelcSucursal.addItem("TODAS");
        SelcSucursal_Info.addItem("TODAS");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        PanelDeRegistro = new javax.swing.JPanel();
        Contenedor = new javax.swing.JPanel();
        tittle = new javax.swing.JLabel();
        IDPiezaLabel = new javax.swing.JLabel();
        InputPiezaID = new javax.swing.JTextField();
        CantidadLabel = new javax.swing.JLabel();
        NombrePieza = new javax.swing.JLabel();
        InputNombrePieza = new javax.swing.JTextField();
        PrecioLabel = new javax.swing.JLabel();
        InputPice = new javax.swing.JTextField();
        ContCantidad = new javax.swing.JPanel();
        menosPieza = new javax.swing.JButton();
        numberPieza = new javax.swing.JTextField();
        maxPieza = new javax.swing.JButton();
        SucursalLabel = new javax.swing.JLabel();
        SelcSucursal = new javax.swing.JComboBox<>();
        ButtomSend = new javax.swing.JToggleButton();
        TableInfoPiezas = new javax.swing.JScrollPane();
        InfoPieza = new javax.swing.JTable();
        PanelDeEditInfo = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        EditCont1 = new javax.swing.JPanel();
        labeldentificacion = new javax.swing.JLabel();
        InputPiezaID_Info = new javax.swing.JTextField();
        labelCantidadPieza = new javax.swing.JLabel();
        contCantidadPiezas_Edit = new javax.swing.JPanel();
        menosCantidad_Edit = new javax.swing.JButton();
        cantidadPiezas_Edit = new javax.swing.JTextField();
        maxCantidadPieza_Edit = new javax.swing.JButton();
        buttomDelete = new javax.swing.JToggleButton();
        EditCont2 = new javax.swing.JPanel();
        labeldentificacion1 = new javax.swing.JLabel();
        InputNombrePieza_Info = new javax.swing.JTextField();
        labellCantidad = new javax.swing.JLabel();
        InputPice_Edit = new javax.swing.JTextField();
        labelSucursal = new javax.swing.JLabel();
        SelcSucursal_Info = new javax.swing.JComboBox<>();
        buttomSave = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(1020, 550));

        fondo.setBackground(new java.awt.Color(40, 88, 85));
        fondo.setPreferredSize(new java.awt.Dimension(1020, 569));

        PanelDeRegistro.setBackground(new java.awt.Color(40, 88, 85));

        Contenedor.setBackground(new java.awt.Color(27, 71, 68));

        tittle.setBackground(new java.awt.Color(255, 255, 255));
        tittle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tittle.setForeground(new java.awt.Color(255, 255, 255));
        tittle.setText("Agregar Pieza");

        IDPiezaLabel.setBackground(new java.awt.Color(255, 255, 255));
        IDPiezaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IDPiezaLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDPiezaLabel.setText("ID de pieza (8 caracteres)");

        InputPiezaID.setForeground(new java.awt.Color(51, 51, 51));
        InputPiezaID.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputPiezaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPiezaIDActionPerformed(evt);
            }
        });

        CantidadLabel.setBackground(new java.awt.Color(255, 255, 255));
        CantidadLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CantidadLabel.setForeground(new java.awt.Color(255, 255, 255));
        CantidadLabel.setText("Cantidad");

        NombrePieza.setBackground(new java.awt.Color(255, 255, 255));
        NombrePieza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NombrePieza.setForeground(new java.awt.Color(255, 255, 255));
        NombrePieza.setText("Nombre de la pieza");

        InputNombrePieza.setForeground(new java.awt.Color(51, 51, 51));
        InputNombrePieza.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputNombrePieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNombrePiezaActionPerformed(evt);
            }
        });

        PrecioLabel.setBackground(new java.awt.Color(255, 255, 255));
        PrecioLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PrecioLabel.setForeground(new java.awt.Color(255, 255, 255));
        PrecioLabel.setText("Precio de la pieza");

        InputPice.setForeground(new java.awt.Color(51, 51, 51));
        InputPice.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputPice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPiceActionPerformed(evt);
            }
        });

        ContCantidad.setBackground(new java.awt.Color(27, 71, 68));

        menosPieza.setBackground(new java.awt.Color(40, 88, 85));
        menosPieza.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menosPieza.setForeground(new java.awt.Color(255, 255, 255));
        menosPieza.setText("-");
        menosPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosPiezaActionPerformed(evt);
            }
        });

        numberPieza.setText("10");
        numberPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberPiezaActionPerformed(evt);
            }
        });

        maxPieza.setBackground(new java.awt.Color(40, 88, 85));
        maxPieza.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maxPieza.setForeground(new java.awt.Color(255, 255, 255));
        maxPieza.setText("+");
        maxPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxPiezaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContCantidadLayout = new javax.swing.GroupLayout(ContCantidad);
        ContCantidad.setLayout(ContCantidadLayout);
        ContCantidadLayout.setHorizontalGroup(
            ContCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContCantidadLayout.createSequentialGroup()
                .addComponent(menosPieza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberPieza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxPieza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContCantidadLayout.setVerticalGroup(
            ContCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContCantidadLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(ContCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContCantidadLayout.createSequentialGroup()
                        .addComponent(maxPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(ContCantidadLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(menosPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numberPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SucursalLabel.setBackground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SucursalLabel.setForeground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setText("Sucursal agregar");

        SelcSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        SelcSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelcSucursalActionPerformed(evt);
            }
        });

        ButtomSend.setBackground(new java.awt.Color(27, 71, 68));
        ButtomSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtomSend.setForeground(new java.awt.Color(255, 255, 255));
        ButtomSend.setText("Agregar");
        ButtomSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtomSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombrePieza)
                    .addComponent(InputNombrePieza, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(CantidadLabel)
                    .addComponent(IDPiezaLabel)
                    .addComponent(InputPiezaID, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(tittle)
                    .addComponent(SelcSucursal, 0, 300, Short.MAX_VALUE)
                    .addComponent(SucursalLabel)
                    .addComponent(ContCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtomSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrecioLabel)
                    .addComponent(InputPice, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDPiezaLabel)
                .addGap(4, 4, 4)
                .addComponent(InputPiezaID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NombrePieza)
                .addGap(4, 4, 4)
                .addComponent(InputNombrePieza, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(PrecioLabel)
                .addGap(4, 4, 4)
                .addComponent(InputPice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CantidadLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SucursalLabel)
                .addGap(4, 4, 4)
                .addComponent(SelcSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtomSend, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout PanelDeRegistroLayout = new javax.swing.GroupLayout(PanelDeRegistro);
        PanelDeRegistro.setLayout(PanelDeRegistroLayout);
        PanelDeRegistroLayout.setHorizontalGroup(
            PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeRegistroLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelDeRegistroLayout.setVerticalGroup(
            PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeRegistroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        TableInfoPiezas.setBackground(new java.awt.Color(255, 255, 255));

        InfoPieza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Valor", "Cantidad", "Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableInfoPiezas.setViewportView(InfoPieza);
        if (InfoPieza.getColumnModel().getColumnCount() > 0) {
            InfoPieza.getColumnModel().getColumn(0).setResizable(false);
            InfoPieza.getColumnModel().getColumn(1).setResizable(false);
            InfoPieza.getColumnModel().getColumn(2).setResizable(false);
            InfoPieza.getColumnModel().getColumn(3).setResizable(false);
            InfoPieza.getColumnModel().getColumn(4).setResizable(false);
        }

        PanelDeEditInfo.setBackground(new java.awt.Color(27, 71, 68));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Informacion");

        EditCont1.setBackground(new java.awt.Color(27, 71, 68));

        labeldentificacion.setBackground(new java.awt.Color(255, 255, 255));
        labeldentificacion.setForeground(new java.awt.Color(255, 255, 255));
        labeldentificacion.setText("ID de pieza");

        InputPiezaID_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPiezaID_InfoActionPerformed(evt);
            }
        });

        labelCantidadPieza.setBackground(new java.awt.Color(255, 255, 255));
        labelCantidadPieza.setForeground(new java.awt.Color(255, 255, 255));
        labelCantidadPieza.setText("Cantidad");

        contCantidadPiezas_Edit.setBackground(new java.awt.Color(27, 71, 68));

        menosCantidad_Edit.setBackground(new java.awt.Color(40, 88, 85));
        menosCantidad_Edit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menosCantidad_Edit.setForeground(new java.awt.Color(255, 255, 255));
        menosCantidad_Edit.setText("-");
        menosCantidad_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosCantidad_EditActionPerformed(evt);
            }
        });

        cantidadPiezas_Edit.setText("10");
        cantidadPiezas_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadPiezas_EditActionPerformed(evt);
            }
        });

        maxCantidadPieza_Edit.setBackground(new java.awt.Color(40, 88, 85));
        maxCantidadPieza_Edit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maxCantidadPieza_Edit.setForeground(new java.awt.Color(255, 255, 255));
        maxCantidadPieza_Edit.setText("+");
        maxCantidadPieza_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxCantidadPieza_EditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contCantidadPiezas_EditLayout = new javax.swing.GroupLayout(contCantidadPiezas_Edit);
        contCantidadPiezas_Edit.setLayout(contCantidadPiezas_EditLayout);
        contCantidadPiezas_EditLayout.setHorizontalGroup(
            contCantidadPiezas_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contCantidadPiezas_EditLayout.createSequentialGroup()
                .addComponent(menosCantidad_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadPiezas_Edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxCantidadPieza_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contCantidadPiezas_EditLayout.setVerticalGroup(
            contCantidadPiezas_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contCantidadPiezas_EditLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(contCantidadPiezas_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contCantidadPiezas_EditLayout.createSequentialGroup()
                        .addComponent(maxCantidadPieza_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(contCantidadPiezas_EditLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(menosCantidad_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cantidadPiezas_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        buttomDelete.setBackground(new java.awt.Color(255, 51, 51));
        buttomDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttomDelete.setForeground(new java.awt.Color(255, 255, 255));
        buttomDelete.setText("Eliminar ");
        buttomDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditCont1Layout = new javax.swing.GroupLayout(EditCont1);
        EditCont1.setLayout(EditCont1Layout);
        EditCont1Layout.setHorizontalGroup(
            EditCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InputPiezaID_Info)
            .addGroup(EditCont1Layout.createSequentialGroup()
                .addComponent(labelCantidadPieza, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(211, 211, 211))
            .addComponent(contCantidadPiezas_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttomDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EditCont1Layout.createSequentialGroup()
                .addComponent(labeldentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EditCont1Layout.setVerticalGroup(
            EditCont1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditCont1Layout.createSequentialGroup()
                .addComponent(labeldentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(InputPiezaID_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelCantidadPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contCantidadPiezas_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(buttomDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        EditCont2.setBackground(new java.awt.Color(27, 71, 68));

        labeldentificacion1.setBackground(new java.awt.Color(255, 255, 255));
        labeldentificacion1.setForeground(new java.awt.Color(255, 255, 255));
        labeldentificacion1.setText("Nombre Pieza");

        InputNombrePieza_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNombrePieza_InfoActionPerformed(evt);
            }
        });

        labellCantidad.setBackground(new java.awt.Color(255, 255, 255));
        labellCantidad.setForeground(new java.awt.Color(255, 255, 255));
        labellCantidad.setText("Precio");

        InputPice_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPice_EditActionPerformed(evt);
            }
        });

        labelSucursal.setBackground(new java.awt.Color(255, 255, 255));
        labelSucursal.setForeground(new java.awt.Color(255, 255, 255));
        labelSucursal.setText("Sucursal");

        SelcSucursal_Info.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        SelcSucursal_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelcSucursal_InfoActionPerformed(evt);
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

        javax.swing.GroupLayout EditCont2Layout = new javax.swing.GroupLayout(EditCont2);
        EditCont2.setLayout(EditCont2Layout);
        EditCont2Layout.setHorizontalGroup(
            EditCont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InputNombrePieza_Info)
            .addComponent(buttomSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EditCont2Layout.createSequentialGroup()
                .addComponent(labeldentificacion1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(EditCont2Layout.createSequentialGroup()
                .addGroup(EditCont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputPice_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(labellCantidad))
                .addGap(24, 24, 24)
                .addGroup(EditCont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditCont2Layout.createSequentialGroup()
                        .addComponent(labelSucursal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(SelcSucursal_Info, 0, 152, Short.MAX_VALUE)))
        );
        EditCont2Layout.setVerticalGroup(
            EditCont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditCont2Layout.createSequentialGroup()
                .addComponent(labeldentificacion1)
                .addGap(6, 6, 6)
                .addComponent(InputNombrePieza_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EditCont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSucursal)
                    .addComponent(labellCantidad))
                .addGap(6, 6, 6)
                .addGroup(EditCont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelcSucursal_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputPice_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(buttomSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelDeEditInfoLayout = new javax.swing.GroupLayout(PanelDeEditInfo);
        PanelDeEditInfo.setLayout(PanelDeEditInfoLayout);
        PanelDeEditInfoLayout.setHorizontalGroup(
            PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                        .addComponent(EditCont1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(EditCont2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(title))
                .addGap(18, 18, 18))
        );
        PanelDeEditInfoLayout.setVerticalGroup(
            PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditCont2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditCont1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(PanelDeRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TableInfoPiezas)
                        .addGap(1, 1, 1))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(PanelDeEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDeRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TableInfoPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDeEditInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InputPiezaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPiezaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPiezaIDActionPerformed

    private void SelcSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelcSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelcSucursalActionPerformed

    private void ButtomSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtomSendActionPerformed
      panelAdminPrecenter.AgregarPieza(InputPiezaID.getText(), InputNombrePieza.getText(), Double.parseDouble(InputPice.getText()) , SelcSucursal.getSelectedItem().toString(), Integer.parseInt(numberPieza.getText()));
      actualizarTablaPiezas();
    }//GEN-LAST:event_ButtomSendActionPerformed

    private void InputPiezaID_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPiezaID_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPiezaID_InfoActionPerformed

    private void buttomSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomSaveActionPerformed
       panelAdminPrecenter.EditarPieza(InputPiezaID_Info.getText(), InputNombrePieza_Info.getText(), Double.parseDouble(InputPice_Edit.getText()), SelcSucursal_Info.getSelectedItem().toString(),  Integer.parseInt(cantidadPiezas_Edit.getText()));
       actualizarTablaPiezas();
    }//GEN-LAST:event_buttomSaveActionPerformed

    private void buttomDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomDeleteActionPerformed
        panelAdminPrecenter.DeletePieza(InputPiezaID_Info.getText(), SelcSucursal_Info.getSelectedItem().toString());
        actualizarTablaPiezas();
    }//GEN-LAST:event_buttomDeleteActionPerformed

    private void menosCantidad_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosCantidad_EditActionPerformed
       String texto = cantidadPiezas_Edit.getText();
       int valor;
       try {
           valor = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            valor = 10;
        }
        if (valor > 0) {
            valor--;
        }
        cantidadPiezas_Edit.setText(String.valueOf(valor));

    }//GEN-LAST:event_menosCantidad_EditActionPerformed

    private void maxCantidadPieza_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxCantidadPieza_EditActionPerformed
       String texto = cantidadPiezas_Edit.getText();
       int valor;
       try {
           valor = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            valor = 0;
        }
        valor++;
        cantidadPiezas_Edit.setText(String.valueOf(valor));

           
    }//GEN-LAST:event_maxCantidadPieza_EditActionPerformed

    private void cantidadPiezas_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadPiezas_EditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadPiezas_EditActionPerformed

    private void menosPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosPiezaActionPerformed
       String texto = numberPieza.getText();
       int valor;
       try {
           valor = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            valor = 10;
        }
        if (valor > 0) {
            valor--;
        }
        numberPieza.setText(String.valueOf(valor));

    }//GEN-LAST:event_menosPiezaActionPerformed

    private void numberPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberPiezaActionPerformed

    private void maxPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxPiezaActionPerformed
       String texto = numberPieza.getText();
       int valor;
       try {
           valor = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            valor = 10;
        }
        valor++;
        numberPieza.setText(String.valueOf(valor));

    }//GEN-LAST:event_maxPiezaActionPerformed

    private void InputNombrePiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNombrePiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNombrePiezaActionPerformed

    private void InputNombrePieza_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNombrePieza_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNombrePieza_InfoActionPerformed

    private void InputPiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPiceActionPerformed

    private void SelcSucursal_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelcSucursal_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelcSucursal_InfoActionPerformed

    private void InputPice_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPice_EditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPice_EditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtomSend;
    private javax.swing.JLabel CantidadLabel;
    private javax.swing.JPanel ContCantidad;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JPanel EditCont1;
    private javax.swing.JPanel EditCont2;
    private javax.swing.JLabel IDPiezaLabel;
    private javax.swing.JTable InfoPieza;
    private javax.swing.JTextField InputNombrePieza;
    private javax.swing.JTextField InputNombrePieza_Info;
    private javax.swing.JTextField InputPice;
    private javax.swing.JTextField InputPice_Edit;
    private javax.swing.JTextField InputPiezaID;
    private javax.swing.JTextField InputPiezaID_Info;
    private javax.swing.JLabel NombrePieza;
    private javax.swing.JPanel PanelDeEditInfo;
    private javax.swing.JPanel PanelDeRegistro;
    private javax.swing.JLabel PrecioLabel;
    private javax.swing.JComboBox<String> SelcSucursal;
    private javax.swing.JComboBox<String> SelcSucursal_Info;
    private javax.swing.JLabel SucursalLabel;
    private javax.swing.JScrollPane TableInfoPiezas;
    private javax.swing.JToggleButton buttomDelete;
    private javax.swing.JToggleButton buttomSave;
    private javax.swing.JTextField cantidadPiezas_Edit;
    private javax.swing.JPanel contCantidadPiezas_Edit;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel labelCantidadPieza;
    private javax.swing.JLabel labelSucursal;
    private javax.swing.JLabel labeldentificacion;
    private javax.swing.JLabel labeldentificacion1;
    private javax.swing.JLabel labellCantidad;
    private javax.swing.JButton maxCantidadPieza_Edit;
    private javax.swing.JButton maxPieza;
    private javax.swing.JButton menosCantidad_Edit;
    private javax.swing.JButton menosPieza;
    private javax.swing.JTextField numberPieza;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tittle;
    // End of variables declaration//GEN-END:variables
}
