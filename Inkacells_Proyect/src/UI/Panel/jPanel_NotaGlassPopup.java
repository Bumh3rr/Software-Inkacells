package UI.Panel;

import UI.Notify;
import static UI.Panel.jPanel_AddGanacia.localDate_ganancia;
import static UI.Panel.model.AddNota.deaultStatus;
import static UI.Panel.jPanel_main.*;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import UI.VeryCampos;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.JOptionPane;
import model.byPresupuesto;

public class jPanel_NotaGlassPopup extends javax.swing.JPanel {

    public static final String statusNoquedo = "No quedo";
    public static final String statusListo = "Listo";
    public static final String statusEnReparacion = "En Reparacion";
    public static String date_entregadoLocal = "";
    private String acciones[];
    private DefaultOption deault;
    private VeryCampos very;
    private float ganancia = 0.0f;

    public jPanel_NotaGlassPopup() {
        initComponents();
        init();
        setListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        label_nameCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_Domicilio = new javax.swing.JLabel();
        label_fijo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_idDispositvo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_nameDispositivo = new javax.swing.JLabel();
        label_marca = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        label_imei = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        label_status = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        label_fecha_recibido = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel_precioRefaccion = new javax.swing.JLabel();
        label_abono = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        label_resta = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        radio_listo = new javax.swing.JRadioButton();
        radio_noquedo = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        label_movil = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        label_tecnico_recibido = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        label_tecnico_responsable = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        label_hora_recibido = new javax.swing.JLabel();
        label_idCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        button1 = new GUI.Button_TexField.Button();
        button2 = new GUI.Button_TexField.Button();
        radio_reparacion = new javax.swing.JRadioButton();
        jTex_reparacion = new javax.swing.JTextField();
        button_entregado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        texArea_observaciones = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        label_ganancia = new javax.swing.JLabel();
        button_changeTecnico = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTex_modelo = new javax.swing.JTextField();

        label_nameCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_nameCliente.setForeground(new java.awt.Color(0, 0, 0));
        label_nameCliente.setText("Pedro Sanchez");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Domicilio:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Telefono Fijo:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombre del Cliente:");

        label_Domicilio.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_Domicilio.setForeground(new java.awt.Color(0, 0, 0));
        label_Domicilio.setText("Hermenegildo Galeana");

        label_fijo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_fijo.setForeground(new java.awt.Color(0, 0, 0));
        label_fijo.setText("7421174311");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        label_idDispositvo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_idDispositvo.setForeground(new java.awt.Color(0, 0, 0));
        label_idDispositvo.setText("00001");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Dispositivo:");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Marca:");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ID:");

        label_nameDispositivo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_nameDispositivo.setForeground(new java.awt.Color(0, 0, 0));
        label_nameDispositivo.setText("Telefono");

        label_marca.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_marca.setForeground(new java.awt.Color(0, 0, 0));
        label_marca.setText("Samsung");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("IMEI / Serial:");

        label_imei.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_imei.setForeground(new java.awt.Color(0, 0, 0));
        label_imei.setText("6346323425345656");

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Observaciones:");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Reparación:");

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Modelo:");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Status:");

        label_status.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_status.setForeground(new java.awt.Color(0, 0, 0));
        label_status.setText("En Proceso");

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Fecha Recibido");

        label_fecha_recibido.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_fecha_recibido.setForeground(new java.awt.Color(0, 0, 0));
        label_fecha_recibido.setText("01-01-2024");

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Marcar como:");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Resta: $");

        label_total.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_total.setForeground(new java.awt.Color(0, 0, 0));
        label_total.setText("400.00");

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Precio Reparacion: $");

        jLabel_precioRefaccion.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel_precioRefaccion.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_precioRefaccion.setText("400.00");

        label_abono.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_abono.setForeground(new java.awt.Color(0, 0, 0));
        label_abono.setText("200.00");

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Abono: $");

        label_resta.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_resta.setForeground(new java.awt.Color(0, 0, 0));
        label_resta.setText("200.00");

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        buttonGroup1.add(radio_listo);
        radio_listo.setFont(new java.awt.Font("Overpass", 1, 13)); // NOI18N
        radio_listo.setForeground(new java.awt.Color(153, 255, 0));
        radio_listo.setText("Listo");

        buttonGroup1.add(radio_noquedo);
        radio_noquedo.setFont(new java.awt.Font("Overpass", 1, 13)); // NOI18N
        radio_noquedo.setForeground(new java.awt.Color(255, 51, 102));
        radio_noquedo.setText("No quedo");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Telefono Movil:");

        label_movil.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_movil.setForeground(new java.awt.Color(0, 0, 0));
        label_movil.setText("7421174311");

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Recibio:");

        label_tecnico_recibido.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_tecnico_recibido.setForeground(new java.awt.Color(0, 0, 0));
        label_tecnico_recibido.setText("Tecnico1");

        jLabel35.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Responsable:");

        label_tecnico_responsable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_tecnico_responsable.setForeground(new java.awt.Color(0, 0, 0));
        label_tecnico_responsable.setText("Tecnico2");

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Hora:");

        label_hora_recibido.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_hora_recibido.setForeground(new java.awt.Color(0, 0, 0));
        label_hora_recibido.setText("12-12-00");

        label_idCliente.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        label_idCliente.setForeground(new java.awt.Color(255, 102, 102));
        label_idCliente.setText("1");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("FOLIO:");

        button1.setBackground(new java.awt.Color(255, 168, 32));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Actualizar Precio");
        button1.setAMouseEntraFont(new java.awt.Color(51, 51, 51));
        button1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(106, 127, 193));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Agregar Ganancia");
        button2.setAMouseEntraFont(new java.awt.Color(51, 51, 51));
        button2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_reparacion);
        radio_reparacion.setFont(new java.awt.Font("Overpass", 1, 13)); // NOI18N
        radio_reparacion.setForeground(new java.awt.Color(102, 102, 0));
        radio_reparacion.setText("En Reparacion");

        jTex_reparacion.setBackground(new java.awt.Color(255, 255, 255));

        button_entregado.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        button_entregado.setForeground(new java.awt.Color(255, 255, 255));
        button_entregado.setText("Entregado");

        texArea_observaciones.setColumns(20);
        texArea_observaciones.setRows(5);
        jScrollPane2.setViewportView(texArea_observaciones);

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Ganancia: $");

        label_ganancia.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        label_ganancia.setForeground(new java.awt.Color(0, 0, 0));
        label_ganancia.setText("0.0");

        button_changeTecnico.setText("Cambiar");
        button_changeTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_changeTecnicoActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Precio Refacción: $");

        jTex_modelo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_ganancia))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button_entregado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_marca)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTex_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel15)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_tecnico_recibido)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel35)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_tecnico_responsable)
                            .addGap(18, 18, 18)
                            .addComponent(button_changeTecnico))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label_abono)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_resta))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_status))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTex_reparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_fecha_recibido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_hora_recibido))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radio_listo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radio_noquedo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radio_reparacion))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(label_fijo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_movil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_nameDispositivo)
                                .addComponent(label_idDispositvo)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_imei))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_Domicilio))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_idCliente)
                                .addComponent(label_nameCliente))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_precioRefaccion))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_idCliente)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nameCliente)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(label_Domicilio))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(label_movil))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_fijo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_idDispositvo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(label_nameDispositivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(label_marca)
                    .addComponent(jLabel19)
                    .addComponent(jTex_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(label_imei))
                .addGap(0, 0, 0)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTex_reparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(label_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(label_fecha_recibido)
                    .addComponent(jLabel24)
                    .addComponent(label_hora_recibido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(label_tecnico_recibido)
                    .addComponent(jLabel35)
                    .addComponent(label_tecnico_responsable)
                    .addComponent(button_changeTecnico))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(radio_listo)
                    .addComponent(radio_noquedo)
                    .addComponent(radio_reparacion))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(label_total)
                    .addComponent(jLabel29)
                    .addComponent(jLabel_precioRefaccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(label_abono)
                    .addComponent(jLabel26)
                    .addComponent(label_resta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(label_ganancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_entregado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            acciones = new String[]{"Cancelar", "Guardar"};
            GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_ChangePrecio(), "Cambio de Precio", acciones, (x, y) -> {
                if (y == 1) {
                    byPresupuesto presupuesto = very.verifyEmptyChangePresupuesto();
                    if (isNotEmpty(presupuesto)) {
                        NOTA[18] = presupuesto.getAbono();
                        NOTA[19] = presupuesto.getResta();
                        NOTA[20] = presupuesto.getTotal();
                        NOTA[23] = presupuesto.getPrecioRefaccion();
                        changePrecioView(NOTA);
                        x.closePopup();
                    }
                } else {
                    x.closePopup();
                }
            }), deault);

        } catch (Exception e) {
            Notify.NotifyError("Se Produjo un ERROR");
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        var entregado = (Boolean) NOTA[17];
        if (entregado) {
            openGanancia();
        } else {
            JOptionPane.showMessageDialog(this,
                    "El Dispositivo No Está como Entregado", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button_changeTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_changeTecnicoActionPerformed
        new jFrame_ChangeTecnico().setVisible(true);
    }//GEN-LAST:event_button_changeTecnicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button_TexField.Button button1;
    private GUI.Button_TexField.Button button2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_changeTecnico;
    private javax.swing.JButton button_entregado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_precioRefaccion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTextField jTex_modelo;
    public static javax.swing.JTextField jTex_reparacion;
    private javax.swing.JLabel label_Domicilio;
    private javax.swing.JLabel label_abono;
    private javax.swing.JLabel label_fecha_recibido;
    private javax.swing.JLabel label_fijo;
    private javax.swing.JLabel label_ganancia;
    private javax.swing.JLabel label_hora_recibido;
    private javax.swing.JLabel label_idCliente;
    private javax.swing.JLabel label_idDispositvo;
    private javax.swing.JLabel label_imei;
    private javax.swing.JLabel label_marca;
    private javax.swing.JLabel label_movil;
    private javax.swing.JLabel label_nameCliente;
    private javax.swing.JLabel label_nameDispositivo;
    private javax.swing.JLabel label_resta;
    private javax.swing.JLabel label_status;
    private javax.swing.JLabel label_tecnico_recibido;
    public static javax.swing.JLabel label_tecnico_responsable;
    private javax.swing.JLabel label_total;
    private javax.swing.JRadioButton radio_listo;
    private javax.swing.JRadioButton radio_noquedo;
    private javax.swing.JRadioButton radio_reparacion;
    public static javax.swing.JTextArea texArea_observaciones;
    // End of variables declaration//GEN-END:variables

    private void init() {
        very = new VeryCampos();

        if (isNotEmpty(NOTA)) {
            paint_JPanel(NOTA);
        } else {
            setVisible(false);
            return;
        }

        deault = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        jTex_reparacion.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Sin Reparación");
        jTex_reparacion.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:3,10,3,10;");

        jTex_modelo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Sin Modelo");
        jTex_modelo.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:3,10,3,10;");

        button_changeTecnico.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:3,10,3,10;");

    }

    private void paint_JPanel(Object[] objects) {
        label_idCliente.setText((String) objects[0]);
        label_nameCliente.setText((String) objects[1]);
        label_Domicilio.setText((String) objects[2]);
        label_movil.setText((String) objects[3]);
        label_fijo.setText((String) objects[4]);

        label_idDispositvo.setText(String.valueOf(objects[5]));
        label_nameDispositivo.setText((String) objects[6]);
        label_marca.setText((String) objects[7]);
        jTex_modelo.setText((String) objects[8]);
        label_imei.setText((String) objects[9]);
        texArea_observaciones.setText(objects[10].toString());

        jTex_reparacion.setText((String) objects[11]);
        label_status.setText((String) objects[12]);
        var status = (String) objects[12];
        label_fecha_recibido.setText((String) objects[13]);
        label_hora_recibido.setText((String) objects[14]);

        label_tecnico_recibido.setText(String.valueOf(objects[15]));
        label_tecnico_responsable.setText(String.valueOf(objects[16]));

        var entregado = (Boolean) objects[17];

        changePrecioView(objects);

        label_ganancia.setText(String.valueOf(NOTA[21]));
        jLabel_precioRefaccion.setText(String.valueOf(NOTA[23]));

        //Fecha Entrega
        date_entregadoLocal = objects[22].toString();
        changeStatus(status);
        changeEntregado(entregado);

    }

    private void changePrecioView(Object[] objects) {
        label_abono.setText(String.valueOf(objects[18]));
        label_resta.setText(String.valueOf(objects[19]));
        label_total.setText(String.valueOf(objects[20]));
        jLabel_precioRefaccion.setText(String.valueOf(objects[23]));
    }

    private void changeStatus(String status) {
        if (status.contains(statusListo)) {
            radio_listo.setSelected(true);
        } else if (status.contains(statusNoquedo)) {
            radio_noquedo.setSelected(true);
        } else if (status.contains(deaultStatus)) {
            radio_reparacion.setSelected(true);
        }
    }

    private void changeEntregado(Boolean entregado) {
        if (entregado) {
            button_entregado.setText("Entregado");
            button_entregado.setBackground(new Color(108, 179, 47));

        } else {
            button_entregado.setText("No Entregado");
            button_entregado.setBackground(new Color(255, 99, 71));
        }
    }

    public static void updateTecnicoResponsable() {
        label_tecnico_responsable.setText(String.valueOf(NOTA[16]));
    }

    private void setListeners() {
        button_entregado.addActionListener(w -> {

            if (!String.valueOf(NOTA[12]).contains(statusEnReparacion)) {
                ganancia = Float.valueOf(NOTA[21].toString());
                var entregado = !Boolean.valueOf(NOTA[17].toString());

                if (ganancia > 0 && !entregado) {
                    int opcion = Notify.JOptionPane_OK_CANCEL("La Ganacia se Perderá\nYa que el Dispositivo lo marcaste como No Entregado\n\n ¿Quieres Continuar?", this);
                    if (opcion == JOptionPane.OK_OPTION) {
                        NOTA[21] = 0.0f;
                        date_entregadoLocal = "";
                    } else {
                        return;
                    }

                }
                NOTA[17] = entregado;
                changeEntregado(entregado);
                label_ganancia.setText(String.valueOf(NOTA[21]));
            } else {
                String message = "No puedes Entregar un Dispositivo con el Status: En Reparacion";
                Notify.JOptionPaneWARNING(message, this);
            }

        });

        radio_listo.addActionListener(x -> {
            NOTA[12] = statusListo;
            label_status.setText(statusListo);
        });

        radio_noquedo.addActionListener(x -> {
            NOTA[12] = statusNoquedo;
            label_status.setText(statusNoquedo);
        });
        radio_reparacion.addActionListener(x -> {
            NOTA[12] = statusEnReparacion;
            label_status.setText(statusEnReparacion);
        });
    }

    private void openGanancia() {
        acciones = new String[]{"Cancelar", "Agregar"};
        GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_AddGanacia(), "Agregar Ganancia", acciones, (x, y) -> {
            if (y == 1) {
                ganancia = very.verifyEmptyGanacia();
                if (!Float.isNaN(ganancia)) {
                    NOTA[21] = ganancia;

                    if (isNotEmpty(localDate_ganancia)) {

                        date_entregadoLocal = !DateLocalToString(localDate_ganancia).isEmpty() ? DateLocalToString(localDate_ganancia) : "";

                    } else {
                        JOptionPane.showMessageDialog(this,
                                "No Puede haber Ganancia Si La fecha de Entrega es Nula: Ganancia $0.0", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        date_entregadoLocal = "";
                        NOTA[21] = 0.0f;
                    }
                    NOTA[22] = date_entregadoLocal;
                    paint_JPanel(NOTA);
                    Notify.NotifySucces("Se agrego Correctamente la Ganancia");
                    x.closePopup();
                }
            } else {
                x.closePopup();
            }
        }), deault);
    }

}
