package UI.Panel;

import UI.Notify;
import static UI.Panel.jPanel_Config.jCombox_impresorasEtiquetas;
import static UI.Panel.jPanel_main.isNotEmpty;
import dao.BaseInkacells;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.NotaEtiqueta;
import print.DispositivoAndNota;
import print.Print;

public class jPanel_GetDispositivo extends javax.swing.JPanel {

    private int idClientePrint;
    private DefaultTableModel model;
    private Object[] objetosTabla;

    public jPanel_GetDispositivo(int idCliente) {
        initComponents();
        this.idClientePrint = idCliente;
        init();
        addDispositivos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        separardor = new javax.swing.JSeparator();
        button1 = new GUI.Button_TexField.Button();
        jLabel1 = new javax.swing.JLabel();
        label_impresora = new javax.swing.JLabel();

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setFont(new java.awt.Font("Overpass", 0, 13)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Dispositivo", "Marca", "Modelo", "Reparacion", "Observacion", "Tecnico", "Precio", "Abono", "Fecha Recibido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        scroll.setViewportView(table);

        button1.setText("Imprimir Dispositivo");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Impresora a Imprimir:");

        label_impresora.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(397, 397, 397)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separardor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_impresora)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(separardor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(label_impresora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        Thread threadSearchID = new Thread(() -> {
            if (jCombox_impresorasEtiquetas.getSelectedItem() != null) {
                if (isNotEmpty(getNotabySelect())) {
                    if (BaseInkacells.existsCliente(idClientePrint)) {
                        imprimir(getNotabySelect(), idClientePrint);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Folio no Existe", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se Encontro el Dispositivo en la Base de Datos", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                        "No hay Impresoras Instaladas", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        });
        threadSearchID.start();
    }//GEN-LAST:event_button1ActionPerformed

    private List<DispositivoAndNota> getNotabySelect() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int idSelect = (int) model.getValueAt(selectedRow, 0);
            return BaseInkacells.getDispositivosAndNotasByDispositivo(idSelect);
        } else {
            Notify.NotifyWarning("Seleciona el Dispositivo");
        }
        return null;
    }

    public void imprimir(List<DispositivoAndNota> dispositivo, int folio) {
        Cliente cliente = BaseInkacells.getCliente(folio);
        String impresora = jCombox_impresorasEtiquetas.getSelectedItem().toString();
        if (impresora != null) {
            if (!impresora.isEmpty()) {
                Print print = new Print(folio, cliente, dispositivo, impresora);
                print.imprimir_TallerEtiqueta();
            } else {
                Notify.NotifyError("Error en la Impresora");
            }
        } else {
            Notify.NotifyWarning("Error en la Impresora");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_impresora;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSeparator separardor;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void init() {
        model = (DefaultTableModel) table.getModel();
        objetosTabla = new Object[10];

        if (jCombox_impresorasEtiquetas.getSelectedItem() != null) {
            String impresora = jCombox_impresorasEtiquetas.getSelectedItem().toString();
            label_impresora.setText(impresora);
        } else {
            label_impresora.setText("No hay Impresora Instalada");
        }

    }

    public void cleanTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void addDataTableToList(List<NotaEtiqueta> list) {
        cleanTable();

        for (NotaEtiqueta dispostivos : list) {
            objetosTabla[0] = dispostivos.getId_Dispositivo();
            objetosTabla[1] = dispostivos.getName();
            objetosTabla[2] = dispostivos.getMarca();
            objetosTabla[3] = dispostivos.getModelo();
            objetosTabla[4] = dispostivos.getReparacion();
            objetosTabla[5] = dispostivos.getObservacion();
            objetosTabla[6] = dispostivos.getNameTecnico();
            objetosTabla[7] = "$" + dispostivos.getPrecio();
            objetosTabla[8] = "$" + dispostivos.getAbono();
            objetosTabla[9] = dispostivos.getFecha_recibido() + " / " + dispostivos.getHora_recibido();

            model.addRow(objetosTabla);
        }
    }

    private void addDispositivos() {
        if (idClientePrint != -1) {
            List<NotaEtiqueta> disList = BaseInkacells.getSearchByEtiqueta(idClientePrint);
            if (isNotEmpty(disList)) {
                addDataTableToList(disList);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ocurrio un Error en al Encontrar los Dispositivos en la Base Data", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "El numero de Folio es Incorrecto", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

}
