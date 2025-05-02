package UI.Panel;
import UI.Notify;
import static UI.Panel.jPanel_main.NOTA;

public class jPanel_ChangePrecio extends javax.swing.JPanel {
    public jPanel_ChangePrecio() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTex_precioChange = new GUI.Button_TexField.TextField();
        jTex_abonoChange = new GUI.Button_TexField.TextField();
        jLabel_precio = new javax.swing.JLabel();
        jLabel_abono = new javax.swing.JLabel();
        jTex_refaccionChange = new GUI.Button_TexField.TextField();
        jLabel_abono1 = new javax.swing.JLabel();

        jLabel_precio.setText("Precio: $");

        jLabel_abono.setText("Abono: $");

        jLabel_abono1.setText("Refacción: $");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_abono1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTex_refaccionChange, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel_abono)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTex_abonoChange, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel_precio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTex_precioChange, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTex_precioChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_precio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_abono)
                    .addComponent(jTex_abonoChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_abono1)
                    .addComponent(jTex_refaccionChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_abono;
    private javax.swing.JLabel jLabel_abono1;
    private javax.swing.JLabel jLabel_precio;
    public static GUI.Button_TexField.TextField jTex_abonoChange;
    public static GUI.Button_TexField.TextField jTex_precioChange;
    public static GUI.Button_TexField.TextField jTex_refaccionChange;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {

            Float abono = Float.valueOf(NOTA[18].toString());
            Float precio = Float.valueOf(NOTA[20].toString());
            Float refaccion = Float.valueOf(NOTA[23].toString());
            jTex_precioChange.setText(String.valueOf(precio));
            jTex_abonoChange.setText(String.valueOf(abono));
            jTex_refaccionChange.setText(String.valueOf(refaccion));
            
        } catch (NumberFormatException e) {
            Notify.NotifyError("Se Produjo un ERROR");
        }
    }
}
