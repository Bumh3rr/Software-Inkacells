package UI.Panel;

import UI.Notify;
import com.sun.tools.javac.Main;
import dao.BaseInkacells;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Tecnico;
import print.Print;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

public class jPanel_Config extends javax.swing.JPanel {

    public jPanel_Config() {
        initComponents();
        init();
        addjComboxImpresoras();
        addjComboxImpresorasEtiquetas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTex_key = new javax.swing.JTextField();
        button_AddKey = new javax.swing.JButton();
        button_test = new javax.swing.JButton();
        panelGradient1 = new GUI.Panel_gradiend.PanelGradient();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtex_texnicoAdd = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel_impresoras = new GUI.Panel_gradiend.PanelGradient();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCombox_impresoras = new javax.swing.JComboBox<>();
        jPanel_impresoras1 = new GUI.Panel_gradiend.PanelGradient();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCombox_impresorasEtiquetas = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(231, 232, 244));

        jPanel1.setBackground(new java.awt.Color(231, 232, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Key By Impresora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Insert Key:");

        button_AddKey.setText("Agregar");
        button_AddKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AddKeyActionPerformed(evt);
            }
        });

        button_test.setText("Test");
        button_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_testActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTex_key, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_AddKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_test)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTex_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_AddKey)
                    .addComponent(button_test))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelGradient1.setRadius(20);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Agregar Tecnico");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre:");

        jButton2.setText("Agregar Tecnico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGradient1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2))
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtex_texnicoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(44, 44, 44))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtex_texnicoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel_impresoras.setRadius(20);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Selecionar Impresora");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Impresora:");

        javax.swing.GroupLayout jPanel_impresorasLayout = new javax.swing.GroupLayout(jPanel_impresoras);
        jPanel_impresoras.setLayout(jPanel_impresorasLayout);
        jPanel_impresorasLayout.setHorizontalGroup(
            jPanel_impresorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_impresorasLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_impresorasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCombox_impresoras, 0, 129, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );
        jPanel_impresorasLayout.setVerticalGroup(
            jPanel_impresorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_impresorasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(jPanel_impresorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombox_impresoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_impresoras1.setRadius(20);

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Selecionar Impresora Etiqueta");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Impresora:");

        jCombox_impresorasEtiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombox_impresorasEtiquetasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_impresoras1Layout = new javax.swing.GroupLayout(jPanel_impresoras1);
        jPanel_impresoras1.setLayout(jPanel_impresoras1Layout);
        jPanel_impresoras1Layout.setHorizontalGroup(
            jPanel_impresoras1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_impresoras1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_impresoras1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCombox_impresorasEtiquetas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );
        jPanel_impresoras1Layout.setVerticalGroup(
            jPanel_impresoras1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_impresoras1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel_impresoras1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombox_impresorasEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_impresoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_impresoras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel_impresoras1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_impresoras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        button_test.setEnabled(false);
    }

    private void button_AddKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddKeyActionPerformed
        String text = jTex_key.getText().toString();
        if (!text.isEmpty()) {
            if (BaseInkacells.setKeyImpresora(text)) {
                JOptionPane.showMessageDialog(this, "Se agrego Correctamente la Key", "Mensaje Success", JOptionPane.INFORMATION_MESSAGE);
                button_test.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campo Vacio", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_button_AddKeyActionPerformed

    private void button_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_testActionPerformed

        String impresora = jCombox_impresoras.getSelectedItem().toString();
        if (impresora != null) {
            if (!impresora.isEmpty()) {
                new Print(0, null, null, impresora).test();
            }
        } else {
            Notify.NotifyWarning("No hay Impresora Conectadas");
        }
    }//GEN-LAST:event_button_testActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String tecnico = jtex_texnicoAdd.getText().toString();
        if (!tecnico.isEmpty()) {
            int idTecnico = BaseInkacells.addTecnicoBD(new Tecnico(tecnico));
            if (idTecnico != -1) {
                MessageAlerts.getInstance().showMessage("Tecnico Agregado", tecnico + "\nSe registro correctamente\n Reinicia para Visualizar Cambios", MessageAlerts.MessageType.SUCCESS, MessageAlerts.CLOSED_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if (i == MessageAlerts.CLOSED_OPTION) {
                            pc.closePopup();
                        }
                    }
                });
            }
        } else {
            Notify.NotifyError("El campo esta Vacio");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCombox_impresorasEtiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombox_impresorasEtiquetasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombox_impresorasEtiquetasActionPerformed

    
    private void addjComboxImpresoras() {
        try {
            String[] impresoras = Print.getImpresoras();
            for (String impresora : impresoras) {
                if (impresora.toLowerCase().startsWith("t")) {
                    jCombox_impresoras.addItem(impresora);
                }
            }
        } catch (Exception e) {
            Notify.NotifyWarning("No hay Impresoras Instaladas");
        }
    }

    private void addjComboxImpresorasEtiquetas() {
        try {
            String[] impresoras = Print.getImpresoras();
            for (String impresora : impresoras) {
                if (impresora.toLowerCase().startsWith("e")) {
                    jCombox_impresorasEtiquetas.addItem(impresora);
                }
            }
        } catch (Exception e) {
            Notify.NotifyWarning("No hay Impresoras Instaladas");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_AddKey;
    private javax.swing.JButton button_test;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox<String> jCombox_impresoras;
    public static javax.swing.JComboBox<String> jCombox_impresorasEtiquetas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private GUI.Panel_gradiend.PanelGradient jPanel_impresoras;
    private GUI.Panel_gradiend.PanelGradient jPanel_impresoras1;
    private javax.swing.JTextField jTex_key;
    private javax.swing.JTextField jtex_texnicoAdd;
    private GUI.Panel_gradiend.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables

}
