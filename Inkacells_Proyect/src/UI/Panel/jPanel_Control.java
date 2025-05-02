package UI.Panel;

import UI.CellRenderer.colorjTableStatus;
import UI.Notify;
import static UI.Panel.jPanel_NotaGlassPopup.date_entregadoLocal;
import static UI.Panel.jPanel_NotaGlassPopup.jTex_modelo;
import static UI.Panel.jPanel_NotaGlassPopup.jTex_reparacion;
import static UI.Panel.jPanel_NotaGlassPopup.texArea_observaciones;
import static UI.Panel.jPanel_main.*;
import static UI.Panel.model.AddNota.getMapKeyByValue;
import dao.BaseInkacells;
import static dao.BaseInkacells.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.NotaFilter;
import static model.Tecnico.listTecnicos;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;

public class jPanel_Control extends javax.swing.JPanel {

    private String tecnico;
    private String status;
    private String dispositivo;
    private String marca;
    private List<NotaFilter> searchByFilter;

    private final String ALL = "All";

    private DefaultTableModel model;
    private Object[] objetosTabla;

    public jPanel_Control() {
        initComponents();
        init();
        setListeners();
        addITems();
        eventClickTwoView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new GUI.Panel_gradiend.PanelGradient();
        scroll = new javax.swing.JScrollPane();
        table_control = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox_StatusControl = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_TecnicoControl = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_DispositivoControl = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_MarcaControl = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        button_serach = new GUI.Button_TexField.Button();
        button1 = new GUI.Button_TexField.Button();
        button2 = new GUI.Button_TexField.Button();

        setBackground(new java.awt.Color(231, 232, 244));

        panelGradient1.setPreferredSize(new java.awt.Dimension(1203, 479));
        panelGradient1.setRadius(20);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table_control.setFont(new java.awt.Font("Overpass", 0, 13)); // NOI18N
        table_control.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "ID", "Dispositivo", "Marca", "Modelo", "Tecnico", "Reparacion", "Precio", "Ganancia", "Fecha Recibido", "Fecha Entregado", "Status", "Entregado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_control.setRowHeight(40);
        scroll.setViewportView(table_control);
        if (table_control.getColumnModel().getColumnCount() > 0) {
            table_control.getColumnModel().getColumn(0).setMinWidth(50);
            table_control.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_control.getColumnModel().getColumn(0).setMaxWidth(80);
            table_control.getColumnModel().getColumn(1).setMinWidth(50);
            table_control.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_control.getColumnModel().getColumn(1).setMaxWidth(80);
            table_control.getColumnModel().getColumn(7).setMinWidth(70);
            table_control.getColumnModel().getColumn(7).setPreferredWidth(80);
            table_control.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        jComboBox_StatusControl.setMaximumRowCount(8);
        jComboBox_StatusControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Listo", "En Reparacion", "No quedo" }));

        jLabel3.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Status");

        jComboBox_TecnicoControl.setMaximumRowCount(8);
        jComboBox_TecnicoControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));

        jLabel1.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tecnico");

        jComboBox_DispositivoControl.setMaximumRowCount(8);
        jComboBox_DispositivoControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));

        jLabel4.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dispositivo");

        jComboBox_MarcaControl.setMaximumRowCount(8);
        jComboBox_MarcaControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));

        jLabel5.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Marca");

        button_serach.setForeground(new java.awt.Color(0, 0, 0));
        button_serach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/search.png"))); // NOI18N
        button_serach.setText("Buscar");
        button_serach.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button_serach.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button_serach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_serachActionPerformed(evt);
            }
        });

        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/reset.png"))); // NOI18N
        button1.setText("Reset");
        button1.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button1.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/note.png"))); // NOI18N
        button2.setText("Ver Nota");
        button2.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button2.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_TecnicoControl, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_StatusControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_DispositivoControl, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_MarcaControl, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(button_serach, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1209, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_TecnicoControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_StatusControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_DispositivoControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox_MarcaControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(button_serach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        model = (DefaultTableModel) table_control.getModel();
        objetosTabla = new Object[13];
        setRendererjTable();

        tecnico = jComboBox_TecnicoControl.getSelectedItem().toString();
        status = jComboBox_StatusControl.getSelectedItem().toString();
        dispositivo = jComboBox_DispositivoControl.getSelectedItem().toString();
        marca = jComboBox_MarcaControl.getSelectedItem().toString();
    }

    private void setListeners() {
        jComboBox_TecnicoControl.addActionListener(x -> {
            tecnico = jComboBox_TecnicoControl.getSelectedItem().toString();
            searchDispositivos();
        });
        jComboBox_StatusControl.addActionListener(x -> {
            status = jComboBox_StatusControl.getSelectedItem().toString();
            searchDispositivos();
        });
        jComboBox_DispositivoControl.addActionListener(x -> {
            dispositivo = jComboBox_DispositivoControl.getSelectedItem().toString();
            searchDispositivos();
        });
        jComboBox_MarcaControl.addActionListener(x -> {
            marca = jComboBox_MarcaControl.getSelectedItem().toString();
            searchDispositivos();
        });
    }

    public void addITems() {
        Thread threadCreateNote = new Thread(() -> {
            try {
                addTecnicosjCombox();
                addDispositvosjCombox();
                addMarcasjCombox();
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        });
        threadCreateNote.start();
        try {
            threadCreateNote.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void addTecnicosjCombox() {
        for (Map.Entry<Integer, String> entry : listTecnicos.entrySet()) {
            jComboBox_TecnicoControl.addItem(entry.getValue());
        }
    }

    private void addDispositvosjCombox() {
        List<String> dispositivos = BaseInkacells.getListTipoDispositivos();
        for (String dispositivo : dispositivos) {
            if (dispositivo != null) {
                jComboBox_DispositivoControl.addItem(dispositivo);
            }
        }
        jComboBox_DispositivoControl.addItem("Otro");
    }

    private void addMarcasjCombox() {
        List<String> dispositivos = BaseInkacells.getListMarca();
        for (String dispositivo : dispositivos) {
            if (dispositivo != null) {
                jComboBox_MarcaControl.addItem(dispositivo);
            }
        }
        jComboBox_MarcaControl.addItem("Otro");
    }


    private void button_serachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_serachActionPerformed
        searchDispositivos();
    }//GEN-LAST:event_button_serachActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        cleanItems();
        cleanTable();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
       viewNoteControl();
    }//GEN-LAST:event_button2ActionPerformed
    private void confirmChangesToTheNote() {
        acciones = new String[]{"Cancel", "Yes"};
        GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_ConfirmarNota("¿Confirmación de cambiar los Datos?"), "Corfirmation", acciones, (x, y) -> {
            if (y == 1) {
                String status = NOTA[12].toString();
                boolean entregado = (boolean) NOTA[17];
                String observaciones = texArea_observaciones.getText().toString();
                String reparacion = jTex_reparacion.getText().toString();
                String date_entregado = date_entregadoLocal;
                int id_Dispositivo = (int) NOTA[5];
                float precio = Float.parseFloat(NOTA[20].toString());
                float abono = Float.parseFloat(NOTA[18].toString());
                float ganancia = Float.parseFloat(NOTA[21].toString());
               int tecnico = getMapKeyByValue(listTecnicos, NOTA[16].toString());
               float refaccion = Float.parseFloat(NOTA[23].toString());
                String modelo = jTex_modelo.getText().toString();


                if (BaseInkacells.setDispositivoByIdDispositivo(status, entregado, id_Dispositivo, precio, abono, ganancia, date_entregado,tecnico,refaccion)) {
                    if (BaseInkacells.setObservacionAndReparacionByIdDispositivo(id_Dispositivo, observaciones, reparacion,modelo)) {
                        searchDispositivos();
                        x.closePopup();
                        Notify.NotifySucces("Se Actualizaron Correctamente");
                    }
                }
            } else {
                x.closePopup();
            }
        }), deault);
    }

    private Object[] getNotabySelect() {
        int selectedRow = table_control.getSelectedRow();

        if (selectedRow != -1) {
            int idSelect = (int) model.getValueAt(selectedRow, 1);
            return BaseInkacells.getAllDispositivo(idSelect);
        } else {
            Notify.NotifyWarning("Seleciona el Dispositivo");
        }
        return null;
    }

    private void filterByTecnico(String tecnico, List<NotaFilter> ListFilter) {
        List<NotaFilter> collect = ListFilter.stream().filter(x -> x.getNameTecnico().contains(tecnico)).collect(Collectors.toList());
        ListFilter.clear();
        ListFilter.addAll(collect);
    }

    private void filterByStatus(String status, List<NotaFilter> ListFilter) {
        List<NotaFilter> collect = ListFilter.stream().filter(x -> x.getStatusR().contains(status)).collect(Collectors.toList());
        ListFilter.clear();
        ListFilter.addAll(collect);
    }

    private void filterByDispositivo(String nombre, List<NotaFilter> ListFilter) {
        List<NotaFilter> collect = ListFilter.stream().filter(x -> x.getName().contains(nombre)).collect(Collectors.toList());
        ListFilter.clear();
        ListFilter.addAll(collect);
    }

    private void filterByMarca(String marca, List<NotaFilter> ListFilter) {
        List<NotaFilter> collect = ListFilter.stream().filter(x -> x.getMarca().contains(marca)).collect(Collectors.toList());
        ListFilter.clear();
        ListFilter.addAll(collect);
    }

    public void addDataTableToList(List<NotaFilter> list) {
        cleanTable();

        for (NotaFilter dispostivos : list) {
            objetosTabla[0] = dispostivos.getFolio();
            objetosTabla[1] = dispostivos.getId_Dispositivo();
            objetosTabla[2] = dispostivos.getName();
            objetosTabla[3] = dispostivos.getMarca();
            objetosTabla[4] = dispostivos.getModelo();
            objetosTabla[5] = dispostivos.getNameTecnico();
            objetosTabla[6] = dispostivos.getReparacion();
            objetosTabla[7] = "$" + dispostivos.getPrecio();
            objetosTabla[8] = "$" + dispostivos.getGanancia();
            objetosTabla[9] = dispostivos.getFecha_recibido() + " / " + dispostivos.getHora_recibido();
            objetosTabla[10] = dispostivos.getFecha_entregado();
            objetosTabla[11] = dispostivos.getStatusR();
            objetosTabla[12] = dispostivos.isEntregado();

            model.addRow(objetosTabla);
        }
    }

    private void cleanTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void cleanItems() {
        jComboBox_TecnicoControl.setSelectedIndex(0);
        jComboBox_StatusControl.setSelectedIndex(0);
        jComboBox_DispositivoControl.setSelectedIndex(0);
        jComboBox_MarcaControl.setSelectedIndex(0);

        tecnico = jComboBox_TecnicoControl.getSelectedItem().toString();
        status = jComboBox_StatusControl.getSelectedItem().toString();
        dispositivo = jComboBox_DispositivoControl.getSelectedItem().toString();
        marca = jComboBox_MarcaControl.getSelectedItem().toString();
    }

    private void setRendererjTable() {
        int index = 11;
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table_control.getColumnCount() - 2; i++) {
            table_control.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        table_control.getColumnModel().getColumn(index).setCellRenderer(new colorjTableStatus(index));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button1;
    private GUI.Button_TexField.Button button2;
    private GUI.Button_TexField.Button button_serach;
    private javax.swing.JComboBox<String> jComboBox_DispositivoControl;
    private javax.swing.JComboBox<String> jComboBox_MarcaControl;
    private javax.swing.JComboBox<String> jComboBox_StatusControl;
    public static javax.swing.JComboBox<String> jComboBox_TecnicoControl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private GUI.Panel_gradiend.PanelGradient panelGradient1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table_control;
    // End of variables declaration//GEN-END:variables

    private void searchDispositivos() {
        Thread threadCreateNote = new Thread(() -> {
            try {
                searchByFilter = getSearchByAll();
                if (tecnico.contains(ALL) && status.contains(ALL) && dispositivo.contains(ALL) && marca.contains(ALL)) {
                    addDataTableToList(searchByFilter);
                } else {
                    if (!tecnico.contains(ALL)) {
                        filterByTecnico(tecnico, searchByFilter);
                    }
                    if (!status.contains(ALL)) {
                        filterByStatus(status, searchByFilter);
                    }
                    if (!dispositivo.contains(ALL)) {
                        filterByDispositivo(dispositivo, searchByFilter);
                    }
                    if (!marca.contains(ALL)) {
                        filterByMarca(marca, searchByFilter);
                    }
                    addDataTableToList(searchByFilter);
                }
                System.out.println(tecnico + " " + status + " " + dispositivo + " " + marca);
            } catch (Exception e) {
                Notify.NotifyError("ERROR al Buscar");
            }
        });
        threadCreateNote.start();

        try {
            threadCreateNote.join();

        } catch (InterruptedException e) {
            Notify.NotifyError("ERROR se ha interrumpido la Busquecada de Datos");
            Thread.currentThread().interrupt();
        }
    }

    private void viewNoteControl() {
        Thread threadSearchID = new Thread(() -> {
            if (isNotEmpty(getNotabySelect())) {
                NOTA = getNotabySelect();
                acciones = new String[]{"Salir", "Guardas Cambios"};
                GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_NotaGlassPopup(), "Nota", acciones, (x, y) -> {
                    if (y == 1) {
                        confirmChangesToTheNote();
                    } else {
                        NOTA = null;
                        x.closePopup();
                    }
                }), deault);
            }
        });
        threadSearchID.start();    
    }

    
    private void eventClickTwoView() {
        table_control.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    viewNoteControl();
                }
            }
        });
    }
    
    
    
}
