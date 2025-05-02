package UI.Panel;

import UI.Panel.model.AddNota;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import dao.BaseInkacells;
import java.util.List;
import java.util.Map;
import static model.Tecnico.listTecnicos;
import static UI.Panel.jPanel_main.*;
import static UI.Panel.model.AddNota.idClienteRecycle;
import static UI.VeryCampos.moveFocusEnter;

public class jPanel_Nota extends javax.swing.JPanel {

    private AddNota addNota;

    public jPanel_Nota() {
        initComponents();
        init();
        setListeners();
        addITems();
    }

    private void init() {
        label_Resta.setVisible(false);
        label_valueResta.setVisible(false);
        button_cancel.setVisible(false);
    }

    private void setListeners() {

        jTex_Abono.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //...            
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {

                    if (!jTex_Abono.getText().isEmpty() && !jTex_Precio.getText().isEmpty()) {
                        float precio = Float.parseFloat(removerComillas(jTex_Precio.getText()));
                        float abono = Float.parseFloat(removerComillas(jTex_Abono.getText()));
                        label_Resta.setVisible(true);
                        label_valueResta.setVisible(true);
                        label_valueResta.setText(String.valueOf(precio - abono));
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //...
            }
        });
        moveFocusEnter();
        setFormatNumber(jTex_Precio);
        setFormatNumber(jTex_Abono);
    }

    public static void addITems() {

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

    private void setFormatNumber(JFormattedTextField jFormatted) {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();

        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(null);
        numberFormatter.setMaximum(Integer.MAX_VALUE);

        jFormatted.setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
    }

    public static String removerComillas(String str) {
        return str.replace(",", "");
    }

    public static void addTecnicosjCombox() {

        for (Map.Entry<Integer, String> entry : listTecnicos.entrySet()) {
            jComboBox_TecnicoRecibe.addItem(entry.getValue());
            jComboBox_Respomsable.addItem(entry.getValue());
        }
        jComboBox_TecnicoRecibe.addItem("Invitado");
    }

    public static void addDispositvosjCombox() {
        List<String> dispositivos = BaseInkacells.getListTipoDispositivos();
        for (String dispositivo : dispositivos) {
            if (dispositivo != null) {
                jComboBox_dispositivo.addItem(dispositivo);
            }
        }
        jComboBox_dispositivo.addItem("Otro");
    }

    public static void addMarcasjCombox() {

        List<String> dispositivos = BaseInkacells.getListMarca();
        for (String dispositivo : dispositivos) {
            if (dispositivo != null) {
                jComboBox_marca.addItem(dispositivo);
            }
        }
        jComboBox_marca.addItem("Otro");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new GUI.Panel_gradiend.PanelGradient();
        button_save = new GUI.Button_TexField.Button();
        button_cancel = new GUI.Button_TexField.Button();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Jtex_Name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTex_Domicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTex_TelMovil = new javax.swing.JFormattedTextField();
        jTex_TelFijo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_dispositivo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_marca = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTex_modelo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTex_imei = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Observaciones = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jTex_falla = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox_TecnicoRecibe = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox_Respomsable = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTex_Precio = new javax.swing.JFormattedTextField();
        jTex_PrecioRefaccion = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jTex_Abono = new javax.swing.JFormattedTextField();
        label_Resta = new javax.swing.JLabel();
        label_valueResta = new javax.swing.JLabel();

        setBackground(new java.awt.Color(231, 232, 244));

        panelGradient1.setRadius(20);

        button_save.setForeground(new java.awt.Color(0, 0, 0));
        button_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/save2.png"))); // NOI18N
        button_save.setText(" Save");
        button_save.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button_save.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_cancel.setForeground(new java.awt.Color(0, 0, 0));
        button_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/cancel.png"))); // NOI18N
        button_cancel.setText(" Cancel");
        button_cancel.setAMouseEntraFont(new java.awt.Color(80, 80, 80));
        button_cancel.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        crazyPanel1.setBackground(new java.awt.Color(255, 255, 255));
        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "",
                "",
                "showClearButton:true;JTextField.placeholderText=Nombre del Cliente",
                "",
                "showClearButton:true;JTextField.placeholderText=Domicilio",
                "",
                "showClearButton:true;JTextField.placeholderText=Movil",
                "showClearButton:true;JTextField.placeholderText=Fijo",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "showClearButton:true;JTextField.placeholderText=Modelo del Dispositivo",
                "",
                "showClearButton:true;JTextField.placeholderText=IMEI del Dispositivo",
                "",
                "",
                "",
                "showClearButton:true;JTextField.placeholderText=Falla a Reparar",
                "",
                "",
                "",
                "",
                "",
                "",
                "showClearButton:true;JTextField.placeholderText=Costo Reparación",
                "showClearButton:true;JTextField.placeholderText=Costo Refacción",
                "",
                "showClearButton:true;JTextField.placeholderText=0.00"
            }
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap 2,fillx,insets 25",
            "[grow 0,trail]15[fill]",
            "",
            new String[]{
                "wrap,al lead",
                "",
                "",
                "",
                "",
                "",
                "split 2",
                "",
                "span 2,grow 1",
                "wrap,al lead",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "wrap,al lead",
                "",
                "split 2",
                "",
                "",
                "",
                "",
                "",
                ""
            }
        ));

        jLabel1.setFont(new java.awt.Font("Overpass", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Detalles del Cliente");
        crazyPanel1.add(jLabel1);

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre");
        crazyPanel1.add(jLabel2);
        crazyPanel1.add(Jtex_Name);

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Dirección");
        crazyPanel1.add(jLabel4);
        crazyPanel1.add(JTex_Domicilio);

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Telefonos");
        crazyPanel1.add(jLabel5);

        try {
            jTex_TelMovil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        crazyPanel1.add(jTex_TelMovil);
        crazyPanel1.add(jTex_TelFijo);
        crazyPanel1.add(jSeparator1);

        jLabel6.setFont(new java.awt.Font("Overpass", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Dispositivo");
        crazyPanel1.add(jLabel6);

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tipo de Dispositivo");
        crazyPanel1.add(jLabel7);

        jComboBox_dispositivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Dispositivo" }));
        crazyPanel1.add(jComboBox_dispositivo);

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Marca");
        crazyPanel1.add(jLabel8);

        jComboBox_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la Marca" }));
        crazyPanel1.add(jComboBox_marca);

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Modelo");
        crazyPanel1.add(jLabel9);
        crazyPanel1.add(jTex_modelo);

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("IMEI / SERIAL");
        crazyPanel1.add(jLabel10);
        crazyPanel1.add(jTex_imei);

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Observaciones");
        crazyPanel1.add(jLabel11);

        jTextArea_Observaciones.setColumns(20);
        jTextArea_Observaciones.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Observaciones);

        crazyPanel1.add(jScrollPane1);

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Falla Aparente");
        crazyPanel1.add(jLabel12);
        crazyPanel1.add(jTex_falla);

        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Recibe");
        crazyPanel1.add(jLabel13);

        jComboBox_TecnicoRecibe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        crazyPanel1.add(jComboBox_TecnicoRecibe);

        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Tecnico Responsable");
        crazyPanel1.add(jLabel14);

        jComboBox_Respomsable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tecnico" }));
        crazyPanel1.add(jComboBox_Respomsable);

        jLabel3.setFont(new java.awt.Font("Overpass", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Presupuesto");
        crazyPanel1.add(jLabel3);

        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Precio $");
        crazyPanel1.add(jLabel15);

        jTex_Precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        crazyPanel1.add(jTex_Precio);

        jTex_PrecioRefaccion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        crazyPanel1.add(jTex_PrecioRefaccion);

        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Abono $");
        crazyPanel1.add(jLabel16);

        jTex_Abono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        crazyPanel1.add(jTex_Abono);

        label_Resta.setForeground(new java.awt.Color(51, 51, 51));
        label_Resta.setText("Resta $");
        crazyPanel1.add(label_Resta);

        label_valueResta.setForeground(new java.awt.Color(51, 51, 51));
        label_valueResta.setText("0.0");
        crazyPanel1.add(label_valueResta);

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                        .addComponent(button_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        jTex_Precio.requestFocusInWindow();
        jTex_Abono.requestFocusInWindow();
        button_save.requestFocusInWindow();
        addNota = new AddNota();
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        if (isNotEmpty(addNota)) {
            addNota.jPanel_NumFolio(idClienteRecycle);
            cleanCliente();
            cleanAll();
        }
    }//GEN-LAST:event_button_cancelActionPerformed

    public static void cleanAll() {
        jComboBox_dispositivo.setSelectedIndex(0);
        jComboBox_marca.setSelectedIndex(0);
        jTex_modelo.setText("");
        jTex_imei.setText("");
        jTextArea_Observaciones.setText("");
        jTex_falla.setText("");
        jComboBox_Respomsable.setSelectedIndex(0);
        jComboBox_TecnicoRecibe.setSelectedIndex(0);
        jTex_Precio.setValue(null);
        jTex_Abono.setValue(null);
        jTex_PrecioRefaccion.setText("");
        label_valueResta.setVisible(false);
        label_Resta.setVisible(false);
    }

    public static void cleanCliente() {
        Jtex_Name.setText("");
        JTex_Domicilio.setText("");
        jTex_TelMovil.setText("");
        jTex_TelFijo.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField JTex_Domicilio;
    public static javax.swing.JTextField Jtex_Name;
    public static GUI.Button_TexField.Button button_cancel;
    public static GUI.Button_TexField.Button button_save;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    public static javax.swing.JComboBox<String> jComboBox_Respomsable;
    public static javax.swing.JComboBox<String> jComboBox_TecnicoRecibe;
    public static javax.swing.JComboBox<String> jComboBox_dispositivo;
    public static javax.swing.JComboBox<String> jComboBox_marca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JFormattedTextField jTex_Abono;
    public static javax.swing.JFormattedTextField jTex_Precio;
    public static javax.swing.JFormattedTextField jTex_PrecioRefaccion;
    public static javax.swing.JTextField jTex_TelFijo;
    public static javax.swing.JFormattedTextField jTex_TelMovil;
    public static javax.swing.JTextField jTex_falla;
    public static javax.swing.JTextField jTex_imei;
    public static javax.swing.JTextField jTex_modelo;
    public static javax.swing.JTextArea jTextArea_Observaciones;
    public static javax.swing.JLabel label_Resta;
    public static javax.swing.JLabel label_valueResta;
    private GUI.Panel_gradiend.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables

}
