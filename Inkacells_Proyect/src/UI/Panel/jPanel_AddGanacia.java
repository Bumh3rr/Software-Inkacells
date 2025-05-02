package UI.Panel;

import UI.Notify;
import static UI.Panel.jPanel_main.NOTA;
import java.time.LocalDate;

public class jPanel_AddGanacia extends javax.swing.JPanel {

    public static LocalDate localDate_ganancia;

    public jPanel_AddGanacia() {
        initComponents();
        init();
        setListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePickerGananica = new raven.datetime.component.date.DatePicker();
        jTex_ganacia = new GUI.Button_TexField.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_precio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTex_DateGanancia = new javax.swing.JFormattedTextField();
        reset = new javax.swing.JButton();

        jLabel1.setText("Ganacia:");

        jLabel2.setText("Precio de la Reparación:");

        label_precio.setText("$ ...");

        jLabel3.setText("Fecha Ganacia & Entregado:");

        reset.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_precio)
                    .addComponent(jTex_ganacia, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jTex_DateGanancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(label_precio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTex_ganacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTex_DateGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static raven.datetime.component.date.DatePicker datePickerGananica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JFormattedTextField jTex_DateGanancia;
    public static GUI.Button_TexField.TextField jTex_ganacia;
    private javax.swing.JLabel label_precio;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            Float precio = Float.valueOf(NOTA[20].toString());
            Float refaccion = Float.valueOf(NOTA[23].toString());
            float gananciaEstimada = (precio-refaccion);
            label_precio.setText(String.valueOf(precio));
            jTex_ganacia.setText(String.valueOf(gananciaEstimada));

            datePickerGananica.setEditor(jTex_DateGanancia);
            datePickerGananica.setSelectedDate(LocalDate.now());
            datePickerGananica.setEditorIcon(null);
            localDate_ganancia = null;

        } catch (NumberFormatException e) {
            Notify.NotifyError("Se Produjo un ERROR");
        }
    }

    private void setListeners() {
        datePickerGananica.addDateSelectionListener((de) -> {
            localDate_ganancia = datePickerGananica.getSelectedDate();
            datePickerGananica.isCloseAfterSelected();
        });

        reset.addActionListener(x -> {
            datePickerGananica.setSelectedDate(LocalDate.now());
            localDate_ganancia = datePickerGananica.getSelectedDate();
        });

    }
}
