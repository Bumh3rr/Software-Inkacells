package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Dispositivo {
   
    private String dispositivo;
    private String marca;
    private String modelo;
    private String imei_serial;
    private String reparacion;
    private String observacion;
    private String tecnicoRecibe;
    private String tecnicoRespon;


}
