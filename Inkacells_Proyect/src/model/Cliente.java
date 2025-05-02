
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Cliente {
    private String nombre;
    private String domicilio;
    private String movil;    
    private String fijo;    
}
