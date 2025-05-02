package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Nota {

    private String status;
    private String fecha_recibido;
    private String hora_recibido;
    private String fecha_entregado;
    private String tecnicoRecibio;
    private boolean entregado;
    private float precio;
    private float resta;
    private float abono;
    private float ganancia;
    private float precio_refaccion;


}
