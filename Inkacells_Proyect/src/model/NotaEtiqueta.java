
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class NotaEtiqueta {
           public int id_Dispositivo;
           public String name;
           public String marca;
           public String modelo;
           public String reparacion;
           public String observacion;
           public String nameTecnico;
           public float precio;
           public float abono;
           public String fecha_recibido;
           public String hora_recibido;
}
