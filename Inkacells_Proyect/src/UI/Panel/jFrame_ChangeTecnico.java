package UI.Panel;

import UI.Notify;
import static UI.Panel.jPanel_NotaGlassPopup.updateTecnicoResponsable;
import static UI.Panel.jPanel_main.NOTA;
import static UI.Panel.jPanel_main.isNotEmpty;
import java.util.Map;
import static model.Tecnico.listTecnicos;

public class jFrame_ChangeTecnico extends javax.swing.JFrame {

    public jFrame_ChangeTecnico() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new GUI.Panel_gradiend.PanelGradient();
        jComboBox_tecnicos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        label_tecnico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button1 = new GUI.Button_TexField.Button();
        button2 = new GUI.Button_TexField.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        panelGradient1.setBackground(new java.awt.Color(204, 204, 204));
        panelGradient1.setColorGradient(new java.awt.Color(204, 204, 204));
        panelGradient1.setRadius(25);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tecnico Responsable:");

        label_tecnico.setFont(new java.awt.Font("Overpass", 3, 16)); // NOI18N
        label_tecnico.setForeground(new java.awt.Color(51, 51, 51));
        label_tecnico.setText("Tecnico");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cambiar Tecnico Responsable:");

        button1.setText("Guardar");
        button1.setRippleColor(new java.awt.Color(255, 51, 51));
        button1.setShadowColor(new java.awt.Color(102, 102, 102));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("Cancelar");
        button2.setRippleColor(new java.awt.Color(255, 0, 0));
        button2.setShadowColor(new java.awt.Color(51, 51, 51));
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
                .addGap(24, 24, 24)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_tecnico)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox_tecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_tecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            String tecnico = jComboBox_tecnicos.getSelectedItem().toString();
            if (isNotEmpty(tecnico)) {
                if (!tecnico.isEmpty()) {
                    NOTA[16] = tecnico;
                    updateTecnicoResponsable();
                    setVisible(false);
                }
            }
        } catch (Exception e) {
            Notify.NotifyError("Ocurrio un ERROR al Guardar el Tecnico");
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_button2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrame_ChangeTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button1;
    private GUI.Button_TexField.Button button2;
    private javax.swing.JComboBox<String> jComboBox_tecnicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_tecnico;
    private GUI.Panel_gradiend.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables

    private void init() {
        if (isNotEmpty(NOTA)) {
            paint(NOTA);
        } else {
            setVisible(false);
            return;
        }
    }

    private void paint(Object[] objects) {
        label_tecnico.setText(String.valueOf(objects[16]));
        addTecnicosjCombox();
    }

    public void addTecnicosjCombox() {
        for (Map.Entry<Integer, String> entry : listTecnicos.entrySet()) {
            jComboBox_tecnicos.addItem(entry.getValue());
        }
    }

}
