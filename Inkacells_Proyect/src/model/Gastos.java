
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Gastos {
    private String fecha;
    private float precio;
    private String razon;
    private int id;
}
