package UI.Panel;

import UI.Notify;
import static UI.Panel.jPanel_Config.jCombox_impresoras;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import model.Selection;
import static UI.Panel.jPanel_main.*;
import dao.BaseInkacells;
import java.awt.HeadlessException;
import java.util.List;
import model.Cliente;
import static model.Selection.*;
import print.DispositivoAndNota;
import print.Print;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;

public class jPanel_print extends javax.swing.JPanel {

    private int idClientePrint;

    public jPanel_print(int idCliente) {
        initComponents();
        this.idClientePrint = idCliente;
        init();
        setListeners();
        getSelectRadio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        button_imprimir = new GUI.Button_TexField.Button();
        jRadio_cliente = new javax.swing.JRadioButton();
        jRadio_ambas = new javax.swing.JRadioButton();
        jRadio_taller = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        label_impresora = new javax.swing.JLabel();
        button_etiqueta = new GUI.Button_TexField.Button();

        button_imprimir.setText("Imprimir");
        button_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_imprimirActionPerformed(evt);
            }
        });

        radioGroup.add(jRadio_cliente);
        jRadio_cliente.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jRadio_cliente.setText("Cliente");

        radioGroup.add(jRadio_ambas);
        jRadio_ambas.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jRadio_ambas.setText("Ambas");

        radioGroup.add(jRadio_taller);
        jRadio_taller.setFont(new java.awt.Font("Overpass", 1, 14)); // NOI18N
        jRadio_taller.setText("Taller");

        jLabel1.setText("Impresora a Imprimir:");

        label_impresora.setText("...");

        button_etiqueta.setText("Imprimir Etiqueta");
        button_etiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_etiquetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jRadio_ambas)
                        .addGap(18, 18, 18)
                        .addComponent(jRadio_taller)
                        .addGap(18, 18, 18)
                        .addComponent(jRadio_cliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_impresora))
                            .addComponent(button_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadio_taller)
                    .addComponent(jRadio_cliente)
                    .addComponent(jRadio_ambas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_impresora))
                .addGap(18, 18, 18)
                .addComponent(button_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_imprimirActionPerformed
        try {
            Selection selectRadio = getSelectRadio();
            if (jCombox_impresoras.getSelectedItem() != null) {
                if (isNotEmpty(selectRadio)) {
                    int folio = 0;
                    if (idClientePrint != -1) {
                        folio = idClientePrint;
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "ERROR: Nose Puede Imprimir el Ticket", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (BaseInkacells.existsCliente(folio)) {

                        switch (selectRadio) {
                            case TALLER:
                                imprimir(folio, TALLER);
                                break;
                            case CLIENTE:
                                imprimir(folio, CLIENTE);
                                break;
                            case AMBAS:
                                imprimir(folio, AMBAS);
                                break;
                            default:
                                Notify.NotifyError("ERROR de Seleccion");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Folio no Existee", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione una Opcion ó Seleciona la Impresora", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay Impresoras Instaladas", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }

        } catch (HeadlessException e) {
            Notify.NotifyError("ERORR: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ERROR: No se Aceptan Letras", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button_imprimirActionPerformed

    private void button_etiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_etiquetaActionPerformed
        acciones = new String[]{"Salir"};
        GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_GetDispositivo(idClientePrint), "Imprimir Etiqueta", acciones, (x, y) -> {
            x.closePopup();
        }), deault);
    }//GEN-LAST:event_button_etiquetaActionPerformed

    public void imprimir(int folio, Selection selection) {
        Cliente cliente = BaseInkacells.getCliente(folio);
        List<DispositivoAndNota> dispositivoAndNotas = BaseInkacells.getDispositivosAndNotasByCliente(folio);
        String impresora = jCombox_impresoras.getSelectedItem().toString();
        if (impresora != null) {
            if (!impresora.isEmpty()) {
                Print print = new Print(folio, cliente, dispositivoAndNotas, impresora);
                switch (selection) {
                    case TALLER:
                        print.imprimir_Taller();
                        break;
                    case CLIENTE:
                        print.imprimir_Cliente();
                        break;
                    case AMBAS:
                        print.imprimir_Ambas();
                        break;
                    default:
                        Notify.NotifyError("ERROR");
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button_etiqueta;
    private GUI.Button_TexField.Button button_imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadio_ambas;
    private javax.swing.JRadioButton jRadio_cliente;
    private javax.swing.JRadioButton jRadio_taller;
    private javax.swing.JLabel label_impresora;
    private javax.swing.ButtonGroup radioGroup;
    // End of variables declaration//GEN-END:variables

    private Selection getSelectRadio() {
        ButtonModel selection = radioGroup.getSelection();
        if (selection != null) {
            if (selection.equals(jRadio_cliente.getModel())) {
                return Selection.CLIENTE;
            }
            if (selection.equals(jRadio_taller.getModel())) {
                return Selection.TALLER;
            }
            if (selection.equals(jRadio_ambas.getModel())) {
                return Selection.AMBAS;
            }
        }
        return null;
    }

    private void init() {
        button_etiqueta.setEnabled(false);
        if (jCombox_impresoras.getSelectedItem() != null) {
            String impresora = jCombox_impresoras.getSelectedItem().toString();
            label_impresora.setText(impresora);
        } else {
            label_impresora.setText("No hay Impresora Instalada");
        }
    }

    private void setListeners() {
        jRadio_ambas.addActionListener(x -> {
            button_etiqueta.setEnabled(false);
        });
        jRadio_cliente.addActionListener(x -> {
            button_etiqueta.setEnabled(false);
        });
        jRadio_taller.addActionListener(x -> {
            button_etiqueta.setEnabled(true);
        });
    }
}
