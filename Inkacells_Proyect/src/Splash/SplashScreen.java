package Splash;

import dao.Conexion;
import java.awt.Color;
import javax.swing.JDialog;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SplashScreen extends javax.swing.JDialog {

    public SplashScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(new Color(221, 221, 221));
        //  To disable key Alt+F4 to close dialog
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel = new Splash.CurvesPanel();
        jLabel1 = new javax.swing.JLabel();
        bar = new Splash.ProgressBarCustom();
        label_status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/SRC/logo_inkacells.png"))); // NOI18N

        label_status.setForeground(new java.awt.Color(30, 30, 30));
        label_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_status.setText("Status");

        javax.swing.GroupLayout curvesPanelLayout = new javax.swing.GroupLayout(curvesPanel);
        curvesPanel.setLayout(curvesPanelLayout);
        curvesPanelLayout.setHorizontalGroup(
            curvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(curvesPanelLayout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, curvesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_status, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        curvesPanelLayout.setVerticalGroup(
            curvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_status)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (true) {
//                    if (isInternetAvailable()) {
                        doTask("Connect To Database ...", 10);
                        conectarBaseData();
                        doTask("Successful Connection...", 20);
                        doTask("Open Pligin ...", 80);
//                        ejecutarPligin();
//                    ejecutarPligin();
                        doTask("Done ...", 100);
                        dispose();
                        curvesPanel.stop();    //  To Stop animation
                    } else {
                        try {
                            doTask("No hay Acceso a Internet ...", 10);
                            curvesPanel.stop();    //  To Stop animation
                            Thread.sleep(7000);
                            System.exit(0);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }//GEN-LAST:event_formWindowOpened

    private void doTask(String taskName, int progress) throws Exception {
        label_status.setText(taskName);
        Thread.sleep(500); //  For Test
        bar.setValue(progress);
    }

    private void conectarBaseData() {
        try {
            if (Conexion.conectarMySQL() == null) {
                label_status.setText("ERROR Al conectarse ala Base de Datos ó Excediste el Limite de Dispositivos");
                Thread.sleep(7000);
                System.exit(0);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean isInternetAvailable() {
        try (Socket socket = new Socket()) {
            SocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53); // Google DNS
            socket.connect(socketAddress, 1500);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void ejecutarPligin() {
        try {
            String pathToExe = "Plugin\\plugin_v3.4.0_prod_64.exe";
            // Ejecuta el archivo .exe
            Process proceso = Runtime.getRuntime().exec(pathToExe);

            // Espera a que el proceso termine
            if (proceso.waitFor() != 1) {
                label_status.setText("ERROR al ejecutar el Plugin");
            }
        } catch (IOException | InterruptedException e) {
            label_status.setText("ERROR al ejecutar el Plugin");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SplashScreen dialog = new SplashScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Splash.ProgressBarCustom bar;
    private Splash.CurvesPanel curvesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_status;
    // End of variables declaration//GEN-END:variables
}
