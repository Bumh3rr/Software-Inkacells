package UI;

import Splash.SplashScreen;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JFrame;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class index extends JFrame {

    public index() {
        initComponents();
        initComponentsGUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbed_jPanel = new GUI.Tabbed.MaterialTabbed();
        jPanel_main1 = new UI.Panel.jPanel_main();
        jPanel_Nota1 = new UI.Panel.jPanel_Nota();
        jPanel_Control1 = new UI.Panel.jPanel_Control();
        jPanel_Config2 = new UI.Panel.jPanel_Config();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 232, 244));
        setMaximumSize(new java.awt.Dimension(12584, 72440));
        setMinimumSize(new java.awt.Dimension(1258, 720));

        jPanel1.setBackground(new java.awt.Color(231, 232, 244));

        jTabbed_jPanel.setToolTipText("");
        jTabbed_jPanel.setFont(new java.awt.Font("Overpass", 1, 15)); // NOI18N
        jTabbed_jPanel.addTab("Main", jPanel_main1);
        jTabbed_jPanel.addTab("   Agregar Nota   ", jPanel_Nota1);
        jTabbed_jPanel.addTab("   Control  ", jPanel_Control1);
        jTabbed_jPanel.addTab("   Configuraciones   ", jPanel_Config2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbed_jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbed_jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 733, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("UI.Flat");
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen(null,true).setVisible(true);
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private UI.Panel.jPanel_Config jPanel_Config2;
    private UI.Panel.jPanel_Control jPanel_Control1;
    private UI.Panel.jPanel_Nota jPanel_Nota1;
    private UI.Panel.jPanel_main jPanel_main1;
    public static GUI.Tabbed.MaterialTabbed jTabbed_jPanel;
    // End of variables declaration//GEN-END:variables

    private void initComponentsGUI() {
        Notifications.getInstance().setJFrame(this);
        GlassPanePopup.install(this);
    }
}
