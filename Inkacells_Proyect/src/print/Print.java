package print;

import UI.Notify;
import static UI.Panel.jPanel_main.*;
import dao.BaseInkacells;
import java.io.IOException;
import java.util.List;
import model.Cliente;

public class Print {

    private int folio;
    private Cliente cliente;
    private List<DispositivoAndNota> dispositivoAndNotas;
    private ConectorPluginV3 conectorPluginV3;
    private String licencia;
    private String impresora;

    public Print(int folio, Cliente cliente, List<DispositivoAndNota> dispositivoAndNotas, String impresora) {
        this.folio = folio;
        this.cliente = cliente;
        this.dispositivoAndNotas = dispositivoAndNotas;
        this.impresora = impresora;
        this.conectorPluginV3 = null;
        this.licencia = obtenerLicencia();
    }

    public void imprimir_Ambas() {
        Thread threadCreateNote = new Thread(() -> {
            try {
                imprimir_Cliente();
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
        threadCreateNote.start();
        try {
            threadCreateNote.join();
            imprimir_Taller();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean imprimir_Taller() {
        conectorPluginV3 = new ConectorPluginV3(ConectorPluginV3.URL_PLUGIN_POR_DEFECTO, licencia);

        conectorPluginV3.Iniciar()
                .DeshabilitarElModoDeCaracteresChinos()
                .Feed(1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EstablecerTamanoFuente(1, 2)
                .TextoSegunPaginaDeCodigos(1, "cp850", "TICKET DEL TALLER\n")
                .Feed(2)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_IZQUIERDA)
                .EstablecerTamanoFuente(1, 1)
                .EscribirTexto("Fecha: " + Date() + " " + Time() + "\n")
                .EscribirTexto("Atendio: " + getRecibio() + "\n")
                .EscribirTexto("Folio: " + folio)
                .Feed(1)
                .EscribirTexto("Cliente: " + cliente.getNombre() + "\n")
                .EscribirTexto("Direccion: " + cliente.getDomicilio() + "\n")
                .EscribirTexto(getNumerosTelCliente())
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EscribirTexto("-------------------------------\n")
                .TextoSegunPaginaDeCodigos(2, "cp850", "DISPOSITIVOS")
                .Feed(1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_IZQUIERDA)
                .EscribirTexto(getDispositivosClienteByTaller())
                .Feed(1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_DERECHA)
                .EscribirTexto("Total: $" + Total() + "\n")
                .EscribirTexto("SubTotal: " + subTotal())
                .Feed(2)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EscribirTexto("Listo: " + "_____" + " No quedo: " + "_____\n")
                .Feed(1)
                .EscribirTexto("Razon: " + "________________________\n")
                .Feed(1)
                .EscribirTexto("_______________________________\n")
                .Feed(4)
                .Corte(1)
                .Pulso(48, 60, 120);

        try {
            conectorPluginV3.imprimirEn(impresora);
            Notify.NotifySucces("Imprimiendo los Ticket Cliente");
            return true;
        } catch (Exception e) {
            Notify.NotifyError("Huvo un ERROR al Imprimir: " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean imprimir_Cliente() {
        conectorPluginV3 = new ConectorPluginV3(ConectorPluginV3.URL_PLUGIN_POR_DEFECTO, licencia);

        conectorPluginV3.Iniciar()
                .DeshabilitarElModoDeCaracteresChinos()
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .Feed(1)
                .EstablecerTamanoFuente(2, 2)
                .TextoSegunPaginaDeCodigos(1, "cp850", "INKACELLS\n")
                .EstablecerTamanoFuente(1, 1)
                .EscribirTexto("Taller de Reparacion\n")
                .EscribirTexto("De\n")
                .EscribirTexto("Celulares\n")
                .EscribirTexto("Calle H. Galeana Col. Centro\n")
                .EscribirTexto("Tecpan de Galeana; Gro\n")
                .TextoSegunPaginaDeCodigos(2, "cp850", "Tel. 742-425-1712")
                .Feed(1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EscribirTexto("-------------------------------\n")
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_IZQUIERDA)
                .EscribirTexto("Fecha: " + Date() + " " + Time() + "\n")
                .EscribirTexto("Atendio: " + getRecibio() + "\n")
                .EscribirTexto("Folio: " + folio)
                .Feed(1)
                .EscribirTexto("Cliente: " + cliente.getNombre() + "\n")
                .EscribirTexto("Direccion: " + cliente.getDomicilio() + "\n")
                .EscribirTexto(getNumerosTelCliente())
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EscribirTexto("-------------------------------\n")
                .TextoSegunPaginaDeCodigos(2, "cp850", "DISPOSITIVOS")
                .Feed(1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_IZQUIERDA)
                .EscribirTexto(getDispositivosCliente())
                .Feed(1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_DERECHA)
                .EscribirTexto("Total: $" + Total() + "\n")
                .EscribirTexto("SubTotal: " + subTotal())
                .Feed(4)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EscribirTexto("_______________________\n")
                .EscribirTexto("Firma de Entregado")
                .Feed(2)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .EstablecerTamanoFuente(1, 1)
                .EscribirTexto("LA GARANTIA NO ES VALIDA EN EQUIPOS MOJADOS NI GOLPEADOS\n")
                .EscribirTexto("GARANTIA Y REPARACION 15 DIAS EXEPTO DISPLAY O MAL USO EN PARTES REPARADAS\n")
                .Feed(1)
                .TextoSegunPaginaDeCodigos(2, "cp850", "¡Gracias por su Preferencia!\n")
                .Feed(3)
                .Corte(1)
                .Pulso(48, 60, 120);

        try {
            conectorPluginV3.imprimirEn(impresora);
            Notify.NotifySucces("Imprimiendo los Ticket Cliente");
            return true;
        } catch (Exception e) {
            Notify.NotifyError("Huvo un ERROR al Imprimir: " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean test() {
        ConectorPluginV3 conector = new ConectorPluginV3(ConectorPluginV3.URL_PLUGIN_POR_DEFECTO, licencia);

        conector.Iniciar()
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_CENTRO)
                .Feed(1)
                .EscribirTexto("ESTE ES UN TEST\n")
                .Feed(5)
                .Corte(1)
                .Pulso(48, 60, 120);

        try {
            conector.imprimirEn(impresora);
            Notify.NotifySucces("Imprimiendo Test");
            return true;
        } catch (Exception e) {
            Notify.NotifyError("Huvo un ERROR al Imprimir: " + e.getLocalizedMessage());
            return false;
        }
    }

    private String getNumerosTelCliente() {
        String str = "";
        if (cliente.getMovil() != null) {
            if (!cliente.getMovil().isEmpty()) {
                str += "Tel. Movil " + cliente.getMovil() + "\n";
            }
        }
        if (cliente.getFijo() != null) {
            if (!cliente.getFijo().isEmpty()) {
                str += "Tel. Fijo " + cliente.getFijo() + "\n";
            }
        }

        if (str.isEmpty()) {
            str = "Tel. - - - -\n ";
        }
        return str;
    }

    private String getDispositivosCliente() {
        String str = "";
        for (DispositivoAndNota dispositivoAndNota : dispositivoAndNotas) {
            str += dispositivoAndNota.getMarca() + " " + dispositivoAndNota.getModelo() + "\n";
            str += "Reparacion: " + dispositivoAndNota.getReparacion() + "\n";
            str += "Precio: $" + dispositivoAndNota.getPrecio() + " Abono: $" + dispositivoAndNota.getAbono() + "\n";
            str += "____________________________" + "\n";
        }
        return str;
    }

    public static String[] getImpresoras() {
        String[] impresoras;
        try {
            impresoras = ConectorPluginV3.obtenerImpresoras();
            return impresoras;
        } catch (IOException | InterruptedException e) {
            System.out.println("Error obteniendo impresoras: " + e.getMessage());
        }
        return null;
    }

    private String getRecibio() {
        try {
            String recibio = dispositivoAndNotas.get(0).getRecibio();
            return recibio;

        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    private String obtenerLicencia() {
        if (!BaseInkacells.getKeyImpresora().isEmpty()) {
            return BaseInkacells.getKeyImpresora();
        }
        return "";
    }

    private float calcularSubTotal() {
        float sum = 0.0f;
        for (DispositivoAndNota dis : dispositivoAndNotas) {
            sum += dis.getResta();
        }
        return sum;
    }

    private String subTotal() {
        float sub = calcularSubTotal();
        if (sub > 0) {
            return "$" + String.valueOf(sub);
        } else {
            var precio = 0.0f;
            for (DispositivoAndNota dis : dispositivoAndNotas) {
                precio += dis.getPrecio();
            }
            if (precio > 0) {
                return "PAGADO";
            } else {
                return "PENDIENTE";
            }
        }

    }

    private float Total() {
        float sum = 0.0f;
        for (DispositivoAndNota dis : dispositivoAndNotas) {
            sum += dis.getPrecio();
        }
        return sum;
    }

    private String getDispositivosClienteByTaller() {
        String str = "";
        for (DispositivoAndNota dispositivoAndNota : dispositivoAndNotas) {
            str += "Tecnico Responsable: " + dispositivoAndNota.getResponsable() + "\n";
            str += "Dispositivo: " + dispositivoAndNota.getDispositivo() + "\n";
            str += "Marca: " + dispositivoAndNota.getMarca() + "\n";
            str += "Modelo: " + dispositivoAndNota.getModelo() + "\n";
            str += "Reparacion: " + dispositivoAndNota.getReparacion() + "\n";
            str += "Observaciones:\n" + dispositivoAndNota.getObservacion() + "\n";
            str += "Precio: $" + dispositivoAndNota.getPrecio() + " Abono: $" + dispositivoAndNota.getAbono() + "\n";
            str += "____________________________" + "\n";
        }
        return str;
    }

    public boolean imprimir_TallerEtiqueta() {
        conectorPluginV3 = new ConectorPluginV3(ConectorPluginV3.URL_PLUGIN_POR_DEFECTO, licencia);

        conectorPluginV3.Iniciar()
                .DeshabilitarElModoDeCaracteresChinos()
                .EstablecerTamanoFuente(1, 1)
                .EstablecerAlineacion(ConectorPluginV3.ALINEACION_IZQUIERDA)
                .EstablecerTamanoFuente(1, 1)
                .EscribirTexto("Folio: " + folio + "  Cliente: " + cliente.getNombre() + "\n")
                .EscribirTexto(getNumerosTelClienteByTaller() + "\n")
                .EscribirTexto(getDispositivosClienteByTallerEtiqueta())
                .Corte(1)
                .Pulso(48, 60, 120);

        try {
            conectorPluginV3.imprimirEn(impresora);
            Notify.NotifySucces("Imprimiendo los Ticket Cliente");
            return true;
        } catch (Exception e) {
            Notify.NotifyError("Huvo un ERROR al Imprimir: " + e.getLocalizedMessage());
            return false;
        }
    }

    private String getDispositivosClienteByTallerEtiqueta() {
        String str = "";
        for (DispositivoAndNota dispositivoAndNota : dispositivoAndNotas) {
            str += "Tecnico: " + dispositivoAndNota.getResponsable() + "\n";
            str += "Marca: " + dispositivoAndNota.getMarca() + " ";
            str += "Modelo: " + dispositivoAndNota.getModelo() + "\n";
            str += "Reparacion: " + dispositivoAndNota.getReparacion() + "\n";
            str += "Observaciones: " + dispositivoAndNota.getObservacion() + "\n";
            str += "Precio: $" + dispositivoAndNota.getPrecio() + " Abono: $" + dispositivoAndNota.getAbono() + "\n";
        }
        return str;
    }

    private String getNumerosTelClienteByTaller() {
        String str = "";
        if (cliente.getMovil() != null) {
            if (!cliente.getMovil().isEmpty()) {
                str += "Tel. Movil " + cliente.getMovil() + " ";
            }
        }
        if (cliente.getFijo() != null) {
            if (!cliente.getFijo().isEmpty()) {
                str += "Tel. Fijo " + cliente.getFijo();
            }
        }

        if (str.isEmpty()) {
            str = "Tel. - - - -";
        }
        return str;
    }

}
