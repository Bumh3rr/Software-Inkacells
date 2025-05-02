package UI.Panel.model;

import UI.Notify;
import UI.Panel.jPanel_ConfirmarNota;
import static UI.Panel.jPanel_main.Date;
import static UI.Panel.jPanel_main.Time;
import static UI.Panel.jPanel_Nota.*;
import UI.Panel.jPanel_print;
import UI.VeryCampos;
import dao.BaseInkacells;
import java.util.Map;
import model.Cliente;
import model.Dispositivo;
import model.Nota;
import static model.Tecnico.listTecnicos;
import model.byPresupuesto;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import raven.popup.component.SimplePopupBorder;

public class AddNota {

    private String acciones[];
    private DefaultOption deault;
    private VeryCampos verify;
    private Cliente cliente;
    private Dispositivo dispositivo;
    private byPresupuesto presupueso;
    public static final String deaultStatus = "En Reparacion";
    public static int idClienteRecycle = -1;

    public AddNota() {
        deault = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        verify = new VeryCampos();
        cliente = null;
        dispositivo = null;
        presupueso = null;
        confirmacionDatos();
    }

    public static <T> boolean isNotEmpty(T objeto) {
        return objeto != null;
    }

    private void confirmacionDatos() {
        acciones = new String[]{"Cancelar", "Crear Nota"};
        GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_ConfirmarNota("¿Confirmacion de los Datos?"), "Confirmation", acciones, (x, y) -> {
            if (y == 1) {
                confirm(x);
            } else {
                x.closePopup();
            }
        }), deault);
    }

    private void confirm(PopupController x) {
        cliente = verify.verifyIsEmptyCliente();
        dispositivo = verify.verifyIsEmptyDispositivo();
        presupueso = verify.verifyIsEmptyPresupuesto();
        if (isNotEmpty(cliente)) {
            if (isNotEmpty(dispositivo)) {
                if (isNotEmpty(presupueso)) {
                    boolean respuesta = waitNoteCreate(cliente, dispositivo, presupueso);
                    if (respuesta) {
                        x.closePopup();
                        notifyRespuestaNota(respuesta);
                    } else {
                        x.closePopup();
                        notifyRespuestaNota(respuesta);
                    }

                }
            }

        }
    }

    private void addOtroDispositivoCliente() {
        acciones = new String[]{"No", "Si"};

        GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_ConfirmarNota("Agregar Otro Dispositivo Para El Mismo Cliente"), "ADD DISPOSITVO AL MISMO CLIENTE", acciones, (x, y) -> {
            if (y == 1) {
                x.closePopup();
                button_cancel.setVisible(true);
                cleanAll();

            } else {
                x.closePopup();
                jPanel_NumFolio(idClienteRecycle);
                button_cancel.setVisible(false);
                cleanCliente();
                cleanAll();
            }
        }), deault);
    }

    public void jPanel_NumFolio(int idClienteFolio) {
        idClienteRecycle = -1;
        MessageAlerts.getInstance().showMessage("Numero Folio: " + idClienteFolio, "¿Quieres Imprimir los Tickets?", MessageAlerts.MessageType.SUCCESS, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
            @Override
            public void action(PopupController pc, int i) {
                if (i == MessageAlerts.YES_OPTION) {
                    acciones = new String[]{"Exit"};
                    GlassPanePopup.showPopup(new SimplePopupBorder(new jPanel_print(idClienteFolio), "Print", acciones, (x, y) -> {
                        if (y == 0) {
                            x.closePopup();
                        }
                        x.closePopup();
                    }), deault);
                }
            }
        });

    }

    private boolean waitNoteCreate(Cliente objCliente, Dispositivo objDispositivo, byPresupuesto objPresupuesto) {
        Thread threadCreateNote = new Thread(() -> {
            try {

                int idCliente = (idClienteRecycle != -1) ? idClienteRecycle : BaseInkacells.addClienteBD(objCliente);
                idClienteRecycle = idCliente;

                int idDispositivo = BaseInkacells.addDispositivoBD(objDispositivo, idCliente);

                //Saber el ID del Tecnico Responsable
                int idTecnicoResponsable = getMapKeyByValue(listTecnicos, (String) objDispositivo.getTecnicoRespon());

                //Add Nota
                String fecha_recibido = Date();
                String hora_recibido = Time();
                Nota nota = new Nota(deaultStatus, fecha_recibido, hora_recibido, "", objDispositivo.getTecnicoRecibe(), false, objPresupuesto.getTotal(), objPresupuesto.getResta(), objPresupuesto.getAbono(), 0.0f,objPresupuesto.getPrecioRefaccion());
                BaseInkacells.addNotaBD(nota, idDispositivo, idTecnicoResponsable);

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
        threadCreateNote.start();

        try {
            threadCreateNote.join();
            return true;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;

    }

    private void notifyRespuestaNota(boolean respuesta) {
        var result = respuesta ? "Se Creo Correctamente la Nota" : "Se produjo un ERROR en la creacion de la Nota";
        if (respuesta) {
            Notify.NotifySucces(result);
            addOtroDispositivoCliente();
        } else {
            Notify.NotifyError(result);
        }
    }

    public static int getMapKeyByValue(Map<Integer, String> map, String search) {
        int id = 0;
        if (map.containsValue(search)) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (search.contains(entry.getValue())) {
                    id = entry.getKey();
                    break;
                }
            }
        }
        return id;
    }
}
