package UI;

import static UI.Panel.jPanel_ChangePrecio.*;
import static UI.Panel.jPanel_Nota.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.Cliente;
import model.Dispositivo;
import static UI.Panel.jPanel_ChangePrecio.jTex_precioChange;
import static UI.Panel.jPanel_AddGanacia.jTex_ganacia;
import static UI.Panel.jPanel_addGasto.*;
import model.Gastos;
import model.byPresupuesto;

public class VeryCampos {

    public Cliente verifyIsEmptyCliente() {
        String name = Jtex_Name.getText();
        String domicilio = JTex_Domicilio.getText();
        String movil = jTex_TelMovil.getText().toString();
        String fijo = jTex_TelFijo.getText().toString();

        if (!name.isEmpty()) {
            return new Cliente(name, domicilio, movil, fijo);
        }
        Notify.NotifyWarning("El campo Nombre del Cliente esta vació");
        return null;
    }

    public Dispositivo verifyIsEmptyDispositivo() {

        isCheckCombox(jComboBox_dispositivo, "Selecione el Dispositivo");
        isCheckCombox(jComboBox_marca, "Selecione la Marca");
        isCheckCombox(jComboBox_TecnicoRecibe, "Selecione el Tecnico que lo Recibe");
        isCheckCombox(jComboBox_Respomsable, "Selecione el Tecnico que lo que se hace responsable del Dispositivo");

        if (isSelectCombox(jComboBox_dispositivo)
                && isSelectCombox(jComboBox_marca)
                && isSelectCombox(jComboBox_TecnicoRecibe)
                && isSelectCombox(jComboBox_Respomsable)) {

            String dispositivo = jComboBox_dispositivo.getSelectedItem().toString();
            String marca = jComboBox_marca.getSelectedItem().toString();
            String modelo = jTex_modelo.getText().strip().trim();
            String imei_serial = jTex_imei.getText().strip();
            String reparacion = jTex_falla.getText();
            String observacion = jTextArea_Observaciones.getText();
            String tecnicoRecibe = jComboBox_TecnicoRecibe.getSelectedItem().toString();
            String tecnicoRespon = jComboBox_Respomsable.getSelectedItem().toString();

            return new Dispositivo(dispositivo, marca, modelo, imei_serial, reparacion, observacion, tecnicoRecibe, tecnicoRespon);
        }
        return null;
    }

    public byPresupuesto verifyIsEmptyPresupuesto() {
        try {
            isCheckjTexFlied(jTex_Precio, "Precio");
            isCheckjTexFlied(jTex_PrecioRefaccion, "Precio Refacción");
            isCheckjTexFlied(jTex_Abono, "Abono");

            float total = isEmptyFloat(jTex_Precio.getText().strip());
            float abono = isEmptyFloat(jTex_Abono.getText().strip());
            float precioRefaccion = isEmptyFloat(jTex_PrecioRefaccion.getText().strip());

            if (!Float.isNaN(total) && !Float.isNaN(abono) && !Float.isNaN(precioRefaccion)) {
                float resta = (total - abono);
                return new byPresupuesto(abono, resta, total, precioRefaccion);
            }
            return null;

        } catch (Exception e) {
            return null;
        }
    }

    public byPresupuesto verifyEmptyChangePresupuesto() {
        try {
            isCheckjTexFlied(jTex_precioChange, "Precio");
            isCheckjTexFlied(jTex_abonoChange, "Abono");
            isCheckjTexFlied(jTex_refaccionChange, "Precio Refacción");

            float total = isEmptyFloat(jTex_precioChange.getText().strip());
            float abono = isEmptyFloat(jTex_abonoChange.getText().strip());
            float precioRefaccion = isEmptyFloat(jTex_refaccionChange.getText().strip());

            if (!Float.isNaN(total) && !Float.isNaN(abono) && !Float.isNaN(abono)) {
                float resta = (total - abono);
                return new byPresupuesto(abono, resta, total,precioRefaccion);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Gastos verifyEmptyGastos() {
        try {
            isCheckjTexFlied(jTex_precioDelGasto, "Precio del Gasto");

            if (!jTex_precioDelGasto.getText().isEmpty()) {
                float gasto = isEmptyFloat(jTex_precioDelGasto.getText().strip());

                if (!Float.isNaN(gasto)) {
                    String razon = jTex_razon.getText().strip();
                    if (!razon.isEmpty()) {
                        return new Gastos("", gasto, razon, 0);
                    } else {
                        Notify.NotifyWarning("El Campo del Razon esta vació");
                    }
                } else {
                    Notify.NotifyError("No se Aceptan Letras en el Precio del Gasto");
                }
            } else {
                Notify.NotifyWarning("El Campo " + "Precio del Gasto" + " es Incorrecto");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public float verifyEmptyGanacia() {
        try {
            isCheckjTexFliedGanancia(jTex_ganacia, "Ganacia");

            float ganacia = isEmptyFloat(jTex_ganacia.getText().strip());
            if (!Float.isNaN(ganacia)) {
                return ganacia;
            }
        } catch (Exception e) {
            return Float.NaN;
        }
        return Float.NaN;
    }

    private void isCheckCombox(JComboBox box, String str) {
        if (box.getSelectedIndex() == 0) {
            Notify.NotifyWarning(str);
        }
    }

    private boolean isSelectCombox(JComboBox box) {
        return box.getSelectedIndex() != 0;
    }

    private float isEmptyFloat(String text) {
        float result = 0.0f;
        if (!text.isEmpty()) {
            result = Float.parseFloat(removerComillas(text));
            if (result < 0) {
                return Float.NaN;
            }
        }
        return result;
    }

    private void isCheckjTexFlied(JTextField text, String str) {
        try {
            var mony = text.getText();
            if (!mony.isEmpty()) {
                Float value = Float.valueOf(removerComillas(text.getText()));
                if (value < 0) {
                    Notify.NotifyWarning("El Campo " + str + " es Incorrecto debe ser mayor a cero");
                }
            }
        } catch (NumberFormatException e) {
            Notify.NotifyWarning("El Campo " + str + " es Incorrecto");
        }
    }

    private void isCheckjTexFliedGanancia(JTextField text, String str) {
        try {
            var mony = text.getText();
            if (!mony.isEmpty()) {
                Float.valueOf(removerComillas(text.getText()));
            }
        } catch (NumberFormatException e) {
            Notify.NotifyWarning("El Campo " + str + " es Incorrecto");
        }
    }

    public static void moveFocusEnter() {
        Jtex_Name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTex_Domicilio.requestFocus();
                }
            }
        });

        JTex_Domicilio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTex_TelMovil.requestFocus();
                }
            }
        });

        jTex_TelMovil.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTex_TelFijo.requestFocus();
                }
            }
        });

        jTex_modelo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTex_imei.requestFocus();
                }
            }
        });

        jTex_imei.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTextArea_Observaciones.requestFocus();
                }
            }
        });

        jTex_falla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTex_Precio.requestFocus();
                }
            }
        });

        jTex_Precio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTex_Abono.requestFocus();
                }
            }
        });

    }

}
