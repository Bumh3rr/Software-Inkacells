package UI.Panel;

public class jPanel_ConfirmarNota extends javax.swing.JPanel {

    public jPanel_ConfirmarNota(String str) {
        initComponents();
        jLabel_confimar.setText(str);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_confimar = new javax.swing.JLabel();

        jLabel_confimar.setFont(new java.awt.Font("Overpass", 1, 18)); // NOI18N
        jLabel_confimar.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_confimar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_confimar.setText("¿Deseas Crear Esta Nota?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_confimar, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_confimar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_confimar;
    // End of variables declaration//GEN-END:variables
}
