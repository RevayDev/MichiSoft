package com.michiStudios.michisoft.View.Seccions.PanelAdmin;

// Panel admin precentador
import com.michiStudios.michisoft.Precenter.panelAdminPrecenter;

//Paquete adicionales
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/*
 * @author ROBERTO JIMENEZ
 */

public class PanelUsers extends javax.swing.JPanel {
    private panelAdminPrecenter panelAdminPrecenter;
    private int fila;
    
    public PanelUsers(panelAdminPrecenter panelAdminPrecenter) {
        initComponents();
        this.panelAdminPrecenter = panelAdminPrecenter;
        reloadDataInfo();
        
        /*
        Esta funcin de selector (addActionListener) fue ayuda de una IA,
        que ayudo a poder enviar sucursal y mostrar depende de la seleccion.
        */
        InfoUser.getSelectionModel().addListSelectionListener(e -> {
            fila = InfoUser.getSelectedRow();
            if (fila >= 0) { 
                InputUserID_Info.setText(InfoUser.getValueAt(fila, 0).toString());
                InputUserName_Info.setText(InfoUser.getValueAt(fila, 1).toString());
                SelcSucursal_Info.setSelectedItem(InfoUser.getValueAt(fila, 2).toString());
                RolUser_Info.setSelectedItem(InfoUser.getValueAt(fila, 3).toString());
            }
            
            RolUser_Info.setEnabled(false);
            InputUserID_Info.setEnabled(false);
        });
        actualizarTablaUsuarios();
    }
    
    //Actualizar lista de usuarios
    private void actualizarTablaUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) InfoUser.getModel();
        modelo.setRowCount(0); 
        ArrayList<ArrayList<String>> data = panelAdminPrecenter.GetUsurarios();
 
        for (ArrayList<String> fila : data) {
                modelo.addRow(new Object[]{fila.get(0), fila.get(1), fila.get(2), fila.get(3) 
            });
        }
    }
    
    //Actualizar los selectores  
    public void reloadDataInfo(){
        SelcSucursal.removeAllItems();
        SelcSucursal_Info.removeAllItems();
        for (String sucursal : panelAdminPrecenter.ReloadDataSucursal()) {
            if (sucursal != null){
                SelcSucursal.addItem(sucursal);
                SelcSucursal_Info.addItem(sucursal);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        PanelDeRegistro = new javax.swing.JPanel();
        Contenedor = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        InputUserID = new javax.swing.JTextField();
        UserLabel1 = new javax.swing.JLabel();
        InputUserName = new javax.swing.JTextField();
        CorreoLabel = new javax.swing.JLabel();
        inputCoreo = new javax.swing.JTextField();
        KeyLabel = new javax.swing.JLabel();
        InputKey = new javax.swing.JPasswordField();
        RolLabel = new javax.swing.JLabel();
        RolUser = new javax.swing.JComboBox<>();
        SucursalLabel = new javax.swing.JLabel();
        SelcSucursal = new javax.swing.JComboBox<>();
        ButtomSend = new javax.swing.JToggleButton();
        TableInfoUsers = new javax.swing.JScrollPane();
        InfoUser = new javax.swing.JTable();
        PanelDeEditInfo = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labeldentificacion = new javax.swing.JLabel();
        InputUserID_Info = new javax.swing.JTextField();
        buttomDelete = new javax.swing.JToggleButton();
        RolUser_Info = new javax.swing.JComboBox<>();
        labelRol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        InputUserName_Info = new javax.swing.JTextField();
        labelSucursal = new javax.swing.JLabel();
        SelcSucursal_Info = new javax.swing.JComboBox<>();
        buttomSave = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(1020, 550));

        fondo.setBackground(new java.awt.Color(40, 88, 85));
        fondo.setPreferredSize(new java.awt.Dimension(1020, 550));

        PanelDeRegistro.setBackground(new java.awt.Color(40, 88, 85));

        Contenedor.setBackground(new java.awt.Color(27, 71, 68));

        title1.setBackground(new java.awt.Color(255, 255, 255));
        title1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("Crear Perfil");

        UserLabel.setBackground(new java.awt.Color(255, 255, 255));
        UserLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel.setText("Identificacion (10 digitos)");

        InputUserID.setBackground(new java.awt.Color(255, 255, 255));
        InputUserID.setForeground(new java.awt.Color(51, 51, 51));
        InputUserID.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUserIDActionPerformed(evt);
            }
        });

        UserLabel1.setBackground(new java.awt.Color(255, 255, 255));
        UserLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UserLabel1.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel1.setText("Nombre");

        InputUserName.setBackground(new java.awt.Color(255, 255, 255));
        InputUserName.setForeground(new java.awt.Color(51, 51, 51));
        InputUserName.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUserNameActionPerformed(evt);
            }
        });

        CorreoLabel.setBackground(new java.awt.Color(255, 255, 255));
        CorreoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CorreoLabel.setForeground(new java.awt.Color(255, 255, 255));
        CorreoLabel.setText("Correo");

        inputCoreo.setBackground(new java.awt.Color(255, 255, 255));
        inputCoreo.setForeground(new java.awt.Color(0, 0, 0));

        KeyLabel.setBackground(new java.awt.Color(255, 255, 255));
        KeyLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KeyLabel.setForeground(new java.awt.Color(255, 255, 255));
        KeyLabel.setText("Contraseña (minimo de 8 caracteres)");

        InputKey.setBackground(new java.awt.Color(255, 255, 255));
        InputKey.setForeground(new java.awt.Color(51, 51, 51));
        InputKey.setSelectionColor(new java.awt.Color(40, 88, 85));
        InputKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputKeyActionPerformed(evt);
            }
        });

        RolLabel.setBackground(new java.awt.Color(255, 255, 255));
        RolLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RolLabel.setForeground(new java.awt.Color(255, 255, 255));
        RolLabel.setText("Rol");

        RolUser.setBackground(new java.awt.Color(255, 255, 255));
        RolUser.setForeground(new java.awt.Color(0, 0, 0));
        RolUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));
        RolUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolUserActionPerformed(evt);
            }
        });

        SucursalLabel.setBackground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SucursalLabel.setForeground(new java.awt.Color(255, 255, 255));
        SucursalLabel.setText("Sucursal");

        SelcSucursal.setBackground(new java.awt.Color(255, 255, 255));
        SelcSucursal.setForeground(new java.awt.Color(0, 0, 0));
        SelcSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        ButtomSend.setBackground(new java.awt.Color(40, 88, 85));
        ButtomSend.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtomSend.setForeground(new java.awt.Color(255, 255, 255));
        ButtomSend.setText("Crear Perfil");
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
                .addGap(22, 22, 22)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputUserID)
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(InputUserName)
                        .addGap(2, 2, 2))
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(inputCoreo)
                        .addGap(5, 5, 5))
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addComponent(ButtomSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(ContenedorLayout.createSequentialGroup()
                        .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserLabel)
                            .addComponent(UserLabel1)
                            .addComponent(CorreoLabel)
                            .addComponent(KeyLabel)
                            .addComponent(title1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorLayout.createSequentialGroup()
                        .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputKey)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorLayout.createSequentialGroup()
                                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RolLabel)
                                    .addComponent(RolUser, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SucursalLabel)
                                    .addComponent(SelcSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5)))
                .addGap(27, 27, 27))
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UserLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CorreoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(KeyLabel)
                .addGap(3, 3, 3)
                .addComponent(InputKey, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RolLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SucursalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RolUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelcSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(ButtomSend, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout PanelDeRegistroLayout = new javax.swing.GroupLayout(PanelDeRegistro);
        PanelDeRegistro.setLayout(PanelDeRegistroLayout);
        PanelDeRegistroLayout.setHorizontalGroup(
            PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeRegistroLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelDeRegistroLayout.setVerticalGroup(
            PanelDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeRegistroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        TableInfoUsers.setBackground(new java.awt.Color(255, 255, 255));

        InfoUser.setBackground(new java.awt.Color(255, 255, 255));
        InfoUser.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Nombre completo", "Sucursal", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        TableInfoUsers.setViewportView(InfoUser);

        PanelDeEditInfo.setBackground(new java.awt.Color(27, 71, 68));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Informacion");

        jPanel1.setBackground(new java.awt.Color(27, 71, 68));

        labeldentificacion.setBackground(new java.awt.Color(255, 255, 255));
        labeldentificacion.setForeground(new java.awt.Color(255, 255, 255));
        labeldentificacion.setText("Intentificacion");

        InputUserID_Info.setBackground(new java.awt.Color(255, 255, 255));
        InputUserID_Info.setForeground(new java.awt.Color(0, 0, 0));
        InputUserID_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUserID_InfoActionPerformed(evt);
            }
        });

        buttomDelete.setBackground(new java.awt.Color(255, 51, 51));
        buttomDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttomDelete.setForeground(new java.awt.Color(255, 255, 255));
        buttomDelete.setText("Eliminar Perfil");
        buttomDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomDeleteActionPerformed(evt);
            }
        });

        RolUser_Info.setBackground(new java.awt.Color(255, 255, 255));
        RolUser_Info.setForeground(new java.awt.Color(0, 0, 0));
        RolUser_Info.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));

        labelRol.setBackground(new java.awt.Color(255, 255, 255));
        labelRol.setForeground(new java.awt.Color(255, 255, 255));
        labelRol.setText("Rol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputUserID_Info)
                    .addComponent(buttomDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(RolUser_Info, 0, 237, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labeldentificacion)
                        .addComponent(labelRol)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labeldentificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUserID_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(labelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RolUser_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttomDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(27, 71, 68));

        labelName.setBackground(new java.awt.Color(255, 255, 255));
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setText("Nombre");

        InputUserName_Info.setBackground(new java.awt.Color(255, 255, 255));
        InputUserName_Info.setForeground(new java.awt.Color(0, 0, 0));
        InputUserName_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUserName_InfoActionPerformed(evt);
            }
        });

        labelSucursal.setBackground(new java.awt.Color(255, 255, 255));
        labelSucursal.setForeground(new java.awt.Color(255, 255, 255));
        labelSucursal.setText("Sucursal");

        SelcSucursal_Info.setBackground(new java.awt.Color(255, 255, 255));
        SelcSucursal_Info.setForeground(new java.awt.Color(0, 0, 0));
        SelcSucursal_Info.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        buttomSave.setBackground(new java.awt.Color(40, 88, 85));
        buttomSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttomSave.setForeground(new java.awt.Color(255, 255, 255));
        buttomSave.setText("Guardar Cambios");
        buttomSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttomSave, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
            .addComponent(SelcSucursal_Info, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InputUserName_Info)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUserName_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSucursal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelcSucursal_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(buttomSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelDeEditInfoLayout = new javax.swing.GroupLayout(PanelDeEditInfo);
        PanelDeEditInfo.setLayout(PanelDeEditInfoLayout);
        PanelDeEditInfoLayout.setHorizontalGroup(
            PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title))
                .addGap(59, 59, 59)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        PanelDeEditInfoLayout.setVerticalGroup(
            PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeEditInfoLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDeEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(PanelDeRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableInfoUsers)
                    .addComponent(PanelDeEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDeRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TableInfoUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PanelDeEditInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
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

    private void InputUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUserIDActionPerformed

    private void InputUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUserNameActionPerformed

    private void InputKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputKeyActionPerformed

    private void RolUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RolUserActionPerformed

    private void ButtomSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtomSendActionPerformed
      panelAdminPrecenter.AddUsuario(InputUserName.getText(), InputUserID.getText(), inputCoreo.getText(), InputKey.getPassword(), SelcSucursal.getSelectedItem().toString(), RolUser.getSelectedItem().toString());
      actualizarTablaUsuarios();
    }//GEN-LAST:event_ButtomSendActionPerformed

    private void InputUserID_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUserID_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUserID_InfoActionPerformed

    private void InputUserName_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUserName_InfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUserName_InfoActionPerformed

    private void buttomSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomSaveActionPerformed
      panelAdminPrecenter.EditUsuario(InputUserID_Info.getText(), InputUserName_Info.getText(), SelcSucursal_Info.getSelectedItem().toString(), RolUser_Info.getSelectedItem().toString() );
      actualizarTablaUsuarios();
    }//GEN-LAST:event_buttomSaveActionPerformed

    private void buttomDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomDeleteActionPerformed
       panelAdminPrecenter.DeleteUsuario(InputUserID_Info.getText(),RolUser_Info.getSelectedItem().toString());
       actualizarTablaUsuarios();
    }//GEN-LAST:event_buttomDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtomSend;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JLabel CorreoLabel;
    private javax.swing.JTable InfoUser;
    private javax.swing.JPasswordField InputKey;
    private javax.swing.JTextField InputUserID;
    private javax.swing.JTextField InputUserID_Info;
    private javax.swing.JTextField InputUserName;
    private javax.swing.JTextField InputUserName_Info;
    private javax.swing.JLabel KeyLabel;
    private javax.swing.JPanel PanelDeEditInfo;
    private javax.swing.JPanel PanelDeRegistro;
    private javax.swing.JLabel RolLabel;
    private javax.swing.JComboBox<String> RolUser;
    private javax.swing.JComboBox<String> RolUser_Info;
    private javax.swing.JComboBox<String> SelcSucursal;
    private javax.swing.JComboBox<String> SelcSucursal_Info;
    private javax.swing.JLabel SucursalLabel;
    private javax.swing.JScrollPane TableInfoUsers;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel UserLabel1;
    private javax.swing.JToggleButton buttomDelete;
    private javax.swing.JToggleButton buttomSave;
    private javax.swing.JPanel fondo;
    private javax.swing.JTextField inputCoreo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelSucursal;
    private javax.swing.JLabel labeldentificacion;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
