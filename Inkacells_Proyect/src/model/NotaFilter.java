
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class NotaFilter {
           public int folio;
           public int id_Dispositivo;
           public String name;
           public String marca;
           public String modelo;
           public String nameTecnico;
           public String reparacion;
           public float precio;
           public float ganancia;
           public String fecha_recibido;
           public String hora_recibido;
           public String fecha_entregado;
           public String statusR;
           public boolean entregado;
}
