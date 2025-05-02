package UI.Panel;

import UI.Notify;
import static UI.Notify.*;
import static UI.Panel.jPanel_main.*;
import UI.VeryCampos;
import dao.BaseInkacells;
import java.time.LocalDate;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Filter;
import model.Gastos;
import model.NotaFilter;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;

public class jPanel_Ganancia extends javax.swing.JPanel {

    private LocalDate localDate;
    private DefaultTableModel model_Dispositivos;
    private DefaultTableModel model_Gastos;
    private Object[] objetosTablaDispositivos;
    private Object[] objetosTablaGatos;
    private float ganancia;
    private float gastos;
    private List<NotaFilter> listFilter = null;
    private List<Gastos> listGastos = null;
    private VeryCampos verify;

    public jPanel_Ganancia() {
        initComponents();
        init();
        setListeners();
        addAllTables(DateLocalToString(localDate));
        setRenderCentrerTable();
        autoDispositivosAndGatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        panelGradient1 = new GUI.Panel_gradiend.PanelGradient();
        scroll = new javax.swing.JScrollPane();
        table_Dispositivos = new javax.swing.JTable();
        jTex_datetime = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Gastos = new javax.swing.JTable();
        panelGradient2 = new GUI.Panel_gradiend.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_gastos = new javax.swing.JLabel();
        label_ganancia = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        button1 = new GUI.Button_TexField.Button();
        button2 = new GUI.Button_TexField.Button();
        button4 = new GUI.Button_TexField.Button();

        setBackground(new java.awt.Color(231, 232, 244));

        panelGradient1.setRadius(25);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table_Dispositivos.setFont(new java.awt.Font("Overpass", 0, 13)); // NOI18N
        table_Dispositivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Dispositivo", "Marca", "Modelo", "Tecnico", "Reparacion", "Ganancia", "Fecha Recibido", "Fecha Entregado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Dispositivos.setRowHeight(40);
        scroll.setViewportView(table_Dispositivos);
        if (table_Dispositivos.getColumnModel().getColumnCount() > 0) {
            table_Dispositivos.getColumnModel().getColumn(0).setMinWidth(50);
            table_Dispositivos.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_Dispositivos.getColumnModel().getColumn(0).setMaxWidth(70);
            table_Dispositivos.getColumnModel().getColumn(1).setMinWidth(100);
            table_Dispositivos.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_Dispositivos.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTex_datetime.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Overpass", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Date");

        table_Gastos.setFont(new java.awt.Font("Overpass", 1, 15)); // NOI18N
        table_Gastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Precio", "Razon", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Gastos.setRowHeight(40);
        table_Gastos.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(table_Gastos);
        if (table_Gastos.getColumnModel().getColumnCount() > 0) {
            table_Gastos.getColumnModel().getColumn(0).setMinWidth(80);
            table_Gastos.getColumnModel().getColumn(0).setPreferredWidth(80);
            table_Gastos.getColumnModel().getColumn(0).setMaxWidth(80);
            table_Gastos.getColumnModel().getColumn(2).setMinWidth(50);
            table_Gastos.getColumnModel().getColumn(2).setPreferredWidth(50);
            table_Gastos.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        panelGradient2.setRadius(25);

        jLabel1.setFont(new java.awt.Font("Overpass", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CORTE");

        jLabel3.setFont(new java.awt.Font("Overpass", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ganancia Sin Gastos: $");

        jLabel4.setFont(new java.awt.Font("Overpass", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Gastos: $");

        jLabel5.setFont(new java.awt.Font("Overpass", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ganancia Total: $");

        label_gastos.setFont(new java.awt.Font("Overpass", 1, 21)); // NOI18N
        label_gastos.setForeground(new java.awt.Color(153, 0, 0));
        label_gastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_gastos.setText("0.0");

        label_ganancia.setFont(new java.awt.Font("Overpass", 1, 21)); // NOI18N
        label_ganancia.setForeground(new java.awt.Color(0, 0, 153));
        label_ganancia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_ganancia.setText("0.0");

        label_total.setFont(new java.awt.Font("Overpass", 1, 22)); // NOI18N
        label_total.setForeground(new java.awt.Color(51, 153, 0));
        label_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_total.setText("0.0");

        javax.swing.GroupLayout panelGradient2Layout = new javax.swing.GroupLayout(panelGradient2);
        panelGradient2.setLayout(panelGradient2Layout);
        panelGradient2Layout.setHorizontalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient2Layout.createSequentialGroup()
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_gastos)
                    .addComponent(label_ganancia)
                    .addComponent(label_total))
                .addGap(160, 160, 160))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradient2Layout.setVerticalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(label_ganancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_gastos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(label_total))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Overpass", 1, 26)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DISPOSITIVOS ENTREGADOS");

        jLabel10.setFont(new java.awt.Font("Overpass", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("GASTOS");

        button1.setText("Agregar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("Eliminar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button4.setForeground(new java.awt.Color(0, 0, 0));
        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/reset.png"))); // NOI18N
        button4.setText("Actualizar");
        button4.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button4.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 411, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(242, 242, 242)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTex_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelGradient2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTex_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        acciones = new String[]{"Salir", "Agregar"};
        GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_addGasto(), "Agregar Gasto", acciones, (x, y) -> {
            if (y == 1) {
                if (addGasto()) {
                    NotifySucces("Se Agrego Correctamente");
                    x.closePopup();
                    updateGastosAndGanancia(localDate);
                }
            } else {
                x.closePopup();
            }

        }), deault);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (getSelectGasto() != 0) {
            Notify.NotifySucces("Se Elimino correctamente el Gasto");
            updateGastosAndGanancia(localDate);
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        localDate = LocalDate.now();
        datePicker.setSelectedDate(localDate);
        updateGastosAndGanancia(localDate);
    }//GEN-LAST:event_button4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button1;
    private GUI.Button_TexField.Button button2;
    private GUI.Button_TexField.Button button4;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jTex_datetime;
    private javax.swing.JLabel label_ganancia;
    private javax.swing.JLabel label_gastos;
    private javax.swing.JLabel label_total;
    private GUI.Panel_gradiend.PanelGradient panelGradient1;
    private GUI.Panel_gradiend.PanelGradient panelGradient2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table_Dispositivos;
    private javax.swing.JTable table_Gastos;
    // End of variables declaration//GEN-END:variables

    private void init() {
        datePicker.setEditor(jTex_datetime);
        datePicker.setSelectedDate(LocalDate.now());
        localDate = datePicker.getSelectedDate();

        objetosTablaGatos = new Object[3];
        objetosTablaDispositivos = new Object[9];
        model_Dispositivos = (DefaultTableModel) table_Dispositivos.getModel();
        model_Gastos = (DefaultTableModel) table_Gastos.getModel();

        ganancia = 0.0f;
        gastos = 0.0f;

        verify = new VeryCampos();
    }

    private void cleanTableDispositivos() {
        while (model_Dispositivos.getRowCount() > 0) {
            model_Dispositivos.removeRow(0);
        }
    }

    private void cleanTableGatos() {
        while (model_Gastos.getRowCount() > 0) {
            model_Gastos.removeRow(0);
        }
    }

    private void addDataTableDispositivos(List<NotaFilter> list) {
        cleanTableDispositivos();

        for (NotaFilter dispostivos : list) {
            objetosTablaDispositivos[0] = dispostivos.getFolio();
            objetosTablaDispositivos[1] = dispostivos.getName();
            objetosTablaDispositivos[2] = dispostivos.getMarca();
            objetosTablaDispositivos[3] = dispostivos.getModelo();
            objetosTablaDispositivos[4] = dispostivos.getNameTecnico();
            objetosTablaDispositivos[5] = dispostivos.getReparacion();
            objetosTablaDispositivos[6] = "$" + dispostivos.getGanancia();
            objetosTablaDispositivos[7] = dispostivos.getFecha_recibido() + " / " + dispostivos.getHora_recibido();
            objetosTablaDispositivos[8] = dispostivos.getFecha_entregado();

            model_Dispositivos.addRow(objetosTablaDispositivos);
        }
    }

    private void addDataTableGastos(List<Gastos> list) {
        cleanTableGatos();

        for (Gastos gastos : list) {
            objetosTablaGatos[0] = "$" + gastos.getPrecio();
            objetosTablaGatos[1] = gastos.getRazon();
            objetosTablaGatos[2] = gastos.getId();

            model_Gastos.addRow(objetosTablaGatos);
        }
    }

    private float getGananciasByEntregados(LocalDate dateEntregado) {
        float get = Float.NaN;
        try {
            get = BaseInkacells.getGananciasFilterDateEntrega(DateLocalToString(dateEntregado));
            return get;
        } catch (Exception e) {
            return Float.NaN;
        }
    }

    private float getGastosByDate(LocalDate date) {
        float get = Float.NaN;
        try {
            get = BaseInkacells.getGastosByDate(DateLocalToString(date));
            return get;
        } catch (Exception e) {
            return Float.NaN;
        }
    }

    private void setListeners() {
        datePicker.addDateSelectionListener((de) -> {
            localDate = datePicker.getSelectedDate();

            if (!isNotEmpty(localDate)) {
                datePicker.setSelectedDate(LocalDate.now());
                localDate = datePicker.getSelectedDate();
            }
            updateGastosAndGanancia(localDate);
        });
    }

    private void autoDispositivosAndGatos() {
        Thread threadCreateNote = new Thread(() -> {
            try {
                var countA = BaseInkacells.getCountDispositivos();
                while (true) {
                    Thread.sleep(10000);

                    var countB = BaseInkacells.getCountDispositivos();
                    if (countB != countA) {
                        countA = countB;
                        updateGastosAndGanancia(localDate);

                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getLocalizedMessage());
            }
        });
        threadCreateNote.start();
    }

    private void setRenderCentrerTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table_Dispositivos.getColumnCount(); i++) {
            table_Dispositivos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < table_Gastos.getColumnCount(); i++) {
            table_Gastos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void updateGastosAndGanancia(LocalDate date) {
        try {
            ganancia = getGananciasByEntregados(localDate);
            gastos = getGastosByDate(localDate);
            if (!Float.isNaN(gastos) && !Float.isNaN(gastos)) {
                float total = (ganancia - gastos);
                label_ganancia.setText(String.valueOf(ganancia));
                label_gastos.setText(String.valueOf(gastos));
                label_total.setText(String.valueOf(total));
                addAllTables(DateLocalToString(date));
            } else {
                NotifyError("ERROR en la Base de Datos");
            }

        } catch (Exception e) {
            NotifyError("Se produjo un ERROR al Calcular la Ganancia");

        }
    }

    private void addAllTables(String dateToString) {
        listFilter = BaseInkacells.getSearchByFilter(dateToString, Filter.DATE_ENTREGADO);
        listGastos = BaseInkacells.getGastos(dateToString);
        if (isNotEmpty(listFilter)) {
            addDataTableDispositivos(listFilter);
        }
        if (isNotEmpty(listGastos)) {
            addDataTableGastos(listGastos);
        }

    }

    private boolean addGasto() {
        Gastos gasto;
        try {
            gasto = verify.verifyEmptyGastos();
            if (isNotEmpty(gasto)) {
                gasto.setFecha(DateLocalToString(localDate));
                if (BaseInkacells.addGastosBD(gasto) != -1) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPaneError("Ocurrio un ERROR al Agregar el Gasto", this);
            return false;
        }
        return false;
    }

    private int getSelectGasto() {
        int selectedRow = table_Gastos.getSelectedRow();

        if (selectedRow != -1) {
            int id = (int) model_Gastos.getValueAt(selectedRow, 2);
            return BaseInkacells.deleteGastoByID(id);
        } else {
            Notify.NotifyWarning("Seleciona el Dispositivo");
        }
        return 0;
    }
}
