package UI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import raven.toast.Notifications;

public  class   Notify {

    public static void NotifySucces(String str) {
        Notifications.getInstance().show(Notifications.Type.SUCCESS,
                Notifications.Location.TOP_RIGHT, "SUCCESS: " + str);
    }

    public static void NotifyInfo(String str) {
        Notifications.getInstance().show(Notifications.Type.INFO,
                Notifications.Location.TOP_RIGHT, "INFO: " + str);
    }

    public static void NotifyError(String str) {
        Notifications.getInstance().show(Notifications.Type.ERROR,
                Notifications.Location.TOP_RIGHT, "ERROR: " + str);
    }

    public static void NotifyWarning(String str) {
        Notifications.getInstance().show(Notifications.Type.WARNING,
                Notifications.Location.TOP_RIGHT, "WARNING: " + str);
    }
    public static void JOptionPaneSucces(String str, JPanel context) {
        JOptionPane.showMessageDialog(context, "SUCCESS: " + str,
                "Mensaje SUCCESS",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void JOptionPaneError(String str, JPanel context) {
        JOptionPane.showMessageDialog(context, "ERROR: " + str,
                "Mensaje ERROR",JOptionPane.ERROR_MESSAGE);
    }
    public static void JOptionPaneWARNING(String str, JPanel context) {
        JOptionPane.showMessageDialog(context, "WARNING: " + str,
                "Mensaje WARNING",JOptionPane.WARNING_MESSAGE);
    }
    public static int JOptionPane_OK_CANCEL(String str, JPanel context) {
       return JOptionPane.showConfirmDialog(context, "WARNING: " + str,
                "Mensaje WARNING",JOptionPane.OK_CANCEL_OPTION);
    }

}
