package UI.Panel;

import UI.Notify;
import UI.CellRenderer.colorjTableStatus;
import static UI.Notify.NotifyError;
import static UI.Panel.jPanel_NotaGlassPopup.*;
import static UI.Panel.model.AddNota.getMapKeyByValue;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import dao.BaseInkacells;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Filter;
import model.NotaFilter;
import static model.Tecnico.listTecnicos;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;

public class jPanel_main extends javax.swing.JPanel {

    private float ganancia;
    private float gastos;

    private DefaultTableModel model;
    private Object[] objetosTabla;
    private LocalDate localDate;

    private List<NotaFilter> listFilter = null;
    public static Object[] NOTA = null;

    public static String acciones[];
    public static DefaultOption deault = new DefaultOption() {
        @Override
        public boolean closeWhenClickOutside() {
            return false;
        }
    };

    public jPanel_main() {
        initComponents();
        init();
        deaultListTableByDate();
        setListeners();
        updateGastosAndGanancia(localDate);
        addNotasAuto();
        eventClickTwoView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        glassIcon1 = new raven.glassmorphism.GlassIcon();
        glassIcon4 = new raven.glassmorphism.GlassIcon();
        glassIcon3 = new raven.glassmorphism.GlassIcon();
        panel = new GUI.Panel_gradiend.PanelGradient();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jTex_datetime = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        button_verNota = new GUI.Button_TexField.Button();
        txtSearch = new javax.swing.JTextField();
        button_imprimir = new GUI.Button_TexField.Button();
        button_ganancia = new GUI.Button_TexField.Button();
        reset_table = new GUI.Button_TexField.Button();
        panelGradient1 = new GUI.Panel_gradiend.PanelGradient();
        jLabel5 = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        crazyPanel3 = new raven.crazypanel.CrazyPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_ganancia = new javax.swing.JLabel();
        crazyPanel4 = new raven.crazypanel.CrazyPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_gastos = new javax.swing.JLabel();

        glassIcon1.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/GUI/icon/dollar.svg", 3.0f, 0, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"@background");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#0033ff"),
                new java.awt.geom.RoundRectangle2D.Double(2.0, 2.0, 10.0, 10.0, 5.0, 5.0),
                45.0f)
        ));

        glassIcon4.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/GUI/icon/dollar.svg", 3.0f, 0, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"@background");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#ff6666"),
                new java.awt.geom.RoundRectangle2D.Double(2.0, 2.0, 10.0, 10.0, 5.0, 5.0),
                45.0f)
        ));

        glassIcon3.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/GUI/icon/expense.svg", 3.0f, 0, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"@background");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#00cc00"),
                new java.awt.geom.RoundRectangle2D.Double(2.0, 2.0, 10.0, 10.0, 5.0, 5.0),
                45.0f)
        ));

        setBackground(new java.awt.Color(231, 232, 244));
        setMaximumSize(new java.awt.Dimension(125855, 72055));
        setMinimumSize(new java.awt.Dimension(1258, 720));
        setPreferredSize(new java.awt.Dimension(1258, 720));

        panel.setRadius(20);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setFont(new java.awt.Font("Overpass", 0, 13)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "ID", "Dispositivo", "Marca", "Modelo", "Tecnico", "Reparacion", "Precio $", "Ganancia", "Fecha Recibido", "Fecha Entregado", "Status", "Entregado"
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
        table.setRowHeight(40);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(80);
            table.getColumnModel().getColumn(1).setMinWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(80);
            table.getColumnModel().getColumn(2).setMinWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(30);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(30);
            table.getColumnModel().getColumn(7).setMinWidth(60);
            table.getColumnModel().getColumn(7).setPreferredWidth(80);
            table.getColumnModel().getColumn(7).setMaxWidth(80);
            table.getColumnModel().getColumn(8).setMinWidth(80);
            table.getColumnModel().getColumn(8).setPreferredWidth(80);
            table.getColumnModel().getColumn(8).setMaxWidth(80);
            table.getColumnModel().getColumn(9).setPreferredWidth(40);
            table.getColumnModel().getColumn(10).setPreferredWidth(30);
            table.getColumnModel().getColumn(11).setPreferredWidth(30);
            table.getColumnModel().getColumn(12).setMinWidth(90);
            table.getColumnModel().getColumn(12).setPreferredWidth(90);
            table.getColumnModel().getColumn(12).setMaxWidth(90);
        }

        jTex_datetime.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Overpass", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Date");

        button_verNota.setForeground(new java.awt.Color(0, 0, 0));
        button_verNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/note.png"))); // NOI18N
        button_verNota.setText("Ver Nota");
        button_verNota.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button_verNota.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button_verNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_verNotaActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Overpass", 0, 15)); // NOI18N

        button_imprimir.setForeground(new java.awt.Color(0, 0, 0));
        button_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/print.png"))); // NOI18N
        button_imprimir.setText("Imprimir");
        button_imprimir.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button_imprimir.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_imprimirActionPerformed(evt);
            }
        });

        button_ganancia.setForeground(new java.awt.Color(0, 0, 0));
        button_ganancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/money.png"))); // NOI18N
        button_ganancia.setText("Dispositivos Entregados");
        button_ganancia.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button_ganancia.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button_ganancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gananciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182)
                        .addComponent(button_verNota, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTex_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_ganancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_verNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTex_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        reset_table.setForeground(new java.awt.Color(0, 0, 0));
        reset_table.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/reset.png"))); // NOI18N
        reset_table.setText("Reset");
        reset_table.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        reset_table.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        reset_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_tableActionPerformed(evt);
            }
        });

        panelGradient1.setRadius(20);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Fecha: ");
        panelGradient1.add(jLabel5);
        jLabel5.setBounds(20, 10, 60, 23);

        label_fecha.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        label_fecha.setForeground(new java.awt.Color(51, 51, 51));
        label_fecha.setText("12-12-2002");
        panelGradient1.add(label_fecha);
        label_fecha.setBounds(90, 10, 94, 23);

        crazyPanel3.setBackground(new java.awt.Color(255, 255, 255));
        crazyPanel3.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +8"
            }
        ));
        crazyPanel3.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));

        jLabel4.setIcon(glassIcon3);
        crazyPanel3.add(jLabel4);

        jLabel6.setFont(new java.awt.Font("Overpass", 0, 14)); // NOI18N
        jLabel6.setText("Ganancia Total");
        crazyPanel3.add(jLabel6);

        label_total.setText("$0.0");
        crazyPanel3.add(label_total);

        crazyPanel2.setBackground(new java.awt.Color(255, 255, 255));
        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +8"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));
        crazyPanel2.setName(""); // NOI18N

        jLabel1.setIcon(glassIcon1);
        crazyPanel2.add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Overpass", 0, 14)); // NOI18N
        jLabel3.setText("Ganancia Sin Gastos");
        crazyPanel2.add(jLabel3);

        label_ganancia.setText("$0.0");
        crazyPanel2.add(label_ganancia);

        crazyPanel4.setBackground(new java.awt.Color(255, 255, 255));
        crazyPanel4.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +8"
            }
        ));
        crazyPanel4.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));

        jLabel7.setIcon(glassIcon4);
        crazyPanel4.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Overpass", 0, 14)); // NOI18N
        jLabel8.setText("Gastos");
        crazyPanel4.add(jLabel8);

        label_gastos.setText("$0.0");
        crazyPanel4.add(label_gastos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(crazyPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(crazyPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(crazyPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(868, 868, 868)
                                .addComponent(reset_table, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reset_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crazyPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(crazyPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(crazyPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_verNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_verNotaActionPerformed
        viewNote();
    }//GEN-LAST:event_button_verNotaActionPerformed

    private void button_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_imprimirActionPerformed
        Thread threadSearchID = new Thread(() -> {
            if (getFoliobyImprimir() != -1) {
                int folio = getFoliobyImprimir();
                acciones = new String[]{"Salir"};
                GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_print(folio), "Imprimir Ticket", acciones, (x, y) -> {
                    x.closePopup();
                }), deault);
            }
        });
        threadSearchID.start();
    }//GEN-LAST:event_button_imprimirActionPerformed

    private void button_gananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gananciaActionPerformed
        String dateStr = DateLocalToString(localDate);
        listFilter = BaseInkacells.getSearchByFilter(dateStr, Filter.DATE_ENTREGADO);
        if (isNotEmpty(listFilter)) {
            if (listFilter.size() != 0) {
                addDataTableToList(listFilter);
                txtSearch.setText("");
                updateGastosAndGanancia(localDate);
            } else {
                JOptionPane.showMessageDialog(this,
                        "No hay Dispositivos Entregados\n Fecha: " + DateLocalToString(localDate));
            }
        }
    }//GEN-LAST:event_button_gananciaActionPerformed

    private void reset_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_tableActionPerformed
        cleanCampos();
        deaultListTableByDate();
        updateGastosAndGanancia(localDate);
    }//GEN-LAST:event_reset_tableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button_ganancia;
    private GUI.Button_TexField.Button button_imprimir;
    private GUI.Button_TexField.Button button_verNota;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private raven.crazypanel.CrazyPanel crazyPanel3;
    private raven.crazypanel.CrazyPanel crazyPanel4;
    private raven.datetime.component.date.DatePicker datePicker;
    private raven.glassmorphism.GlassIcon glassIcon1;
    private raven.glassmorphism.GlassIcon glassIcon3;
    private raven.glassmorphism.GlassIcon glassIcon4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField jTex_datetime;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_ganancia;
    private javax.swing.JLabel label_gastos;
    private javax.swing.JLabel label_total;
    private GUI.Panel_gradiend.PanelGradient panel;
    private GUI.Panel_gradiend.PanelGradient panelGradient1;
    private GUI.Button_TexField.Button reset_table;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void init() {
        datePicker.setEditor(jTex_datetime);
        datePicker.setSelectedDate(LocalDate.now());
        localDate = datePicker.getSelectedDate();

        model = (DefaultTableModel) table.getModel();
        objetosTabla = new Object[13];
        setRendererjTable();

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search Folio ...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("GUI/icon/search.svg"));
        txtSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,15,5,15;"
                + "background:$Panel.background");
    }

    private void setListeners() {
        try {
            txtSearch.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    //...            
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                        String str = txtSearch.getText().strip().trim();
                        if (!str.isEmpty()) {
                            searchIDByCliente(str);
                        } else {
                            localDate = LocalDate.now();
                            datePicker.setSelectedDate(localDate);
                            deaultListTableByDate();
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //...
                }
            });

            datePicker.addDateSelectionListener((de) -> {
                localDate = datePicker.getSelectedDate();
                txtSearch.setText("");

                if (isNotEmpty(localDate)) {
                    String dateStr = DateLocalToString(localDate);
                    listFilter = BaseInkacells.getSearchByFilter(dateStr, Filter.DATE);
                    if (isNotEmpty(listFilter)) {
                        addDataTableToList(listFilter);
                    }
                } else {
                    datePicker.setSelectedDate(LocalDate.now());
                    localDate = datePicker.getSelectedDate();
                }
                updateGastosAndGanancia(localDate);
            });

        } catch (Exception e) {
            Notify.NotifyError("A ocurrido un ERROR");
        }
    }

    private void eventClickTwoView() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    viewNote();
                }
            }
        });
    }

    private void searchIDByCliente(String id) {
        Thread threadsearchID = new Thread(() -> {
            try {
                int idSearch = Integer.parseInt(id);
                listFilter = BaseInkacells.getSearchByFilter(String.valueOf(idSearch), Filter.iD_CLIENTE);
                if (isNotEmpty(listFilter)) {
                    addDataTableToList(listFilter);
                    Notify.NotifySucces("Se encontro Correctamente");
                } else {
                    Notify.NotifyError("Nose Encontro el ID");
                    cleanTable();
                }

            } catch (NumberFormatException e) {
                Notify.NotifyError("Solo se puede buscar por el ID");
            }
        });
        threadsearchID.start();
    }

    public void cleanTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private Object[] getNotabySelect() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int idSelect = (int) model.getValueAt(selectedRow, 1);
            return BaseInkacells.getAllDispositivo(idSelect);
        } else {
            Notify.NotifyWarning("Seleciona el Dispositivo");
        }
        return null;
    }

    private int getFoliobyImprimir() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            return (int) model.getValueAt(selectedRow, 0);
        } else {
            Notify.NotifyWarning("Seleciona el Dispositivo");
        }
        return -1;
    }

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
                float refaccion = Float.parseFloat(NOTA[23].toString());
                System.out.println("$:" + refaccion);
                int tecnico = getMapKeyByValue(listTecnicos, NOTA[16].toString());
                String modelo = jTex_modelo.getText().toString();

                if (BaseInkacells.setDispositivoByIdDispositivo(status, entregado, id_Dispositivo, precio, abono, ganancia, date_entregado, tecnico, refaccion)) {
                    if (BaseInkacells.setObservacionAndReparacionByIdDispositivo(id_Dispositivo, observaciones, reparacion, modelo)) {
                        updateGastosAndGanancia(localDate);
                        String str = txtSearch.getText().strip().trim();
                        if (!str.isEmpty()) {
                            searchIDByCliente(str);
                        } else {
                            deaultListTableByDate();
                        }
                        x.closePopup();
                        Notify.NotifySucces("Se Actualizaron Correctamente");
                    }
                }
            } else {
                x.closePopup();
            }
        }), deault);
    }

    public static <T> boolean isNotEmpty(T objeto) {
        return objeto != null;
    }

    private void addDataTableToList(List<NotaFilter> list) {
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

    public static String DatebyBarra() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return now.format(formatter);
    }

    public static String DateToStringByFilter(LocalDate now) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(formatter);
    }

    private void addNotasAuto() {
        Thread threadCreateNote = new Thread(() -> {
            try {
                var countA = BaseInkacells.getCountDispositivos();
                while (true) {
                    Thread.sleep(10000);

                    var countB = BaseInkacells.getCountDispositivos();
                    if (countB != countA) {
                        countA = countB;
                        deaultListTableByDate();
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

    private void deaultListTableByDate() {
        String dateStr = DateLocalToString(localDate);
        listFilter = BaseInkacells.getSearchByFilter(dateStr, Filter.DATE);
        if (isNotEmpty(listFilter)) {
            addDataTableToList(listFilter);
        }
    }

    public static String DateLocalToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }

    public static String Date() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(formatter);
    }

    public static String Time() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

    public static String DateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return now.format(formatter);
    }

    private void cleanCampos() {
        txtSearch.setText("");
        datePicker.setSelectedDate(LocalDate.now());
    }

    private void setRendererjTable() {
        int index = 11;
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount() - 2; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        table.getColumnModel().getColumn(index).setCellRenderer(new colorjTableStatus(index));

    }

    private void updateGastosAndGanancia(LocalDate date) {
        try {
            label_fecha.setText(DateLocalToString(date));
            ganancia = getGananciasByEntregados(date);
            gastos = getGastosByDate(date);
            if (!Float.isNaN(gastos) && !Float.isNaN(gastos)) {
                float total = (ganancia - gastos);
                label_ganancia.setText("$" + String.valueOf(ganancia));
                label_gastos.setText("$" + String.valueOf(gastos));
                label_total.setText("$" + String.valueOf(total));
            } else {
                NotifyError("ERROR en la Base de Datos");
            }
        } catch (Exception e) {
            NotifyError("Se produjo un ERROR al Calcular la Ganancia");
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

    private void viewNote() {
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

}
