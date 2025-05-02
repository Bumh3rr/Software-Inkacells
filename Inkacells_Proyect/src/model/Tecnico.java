package model;

import dao.BaseInkacells;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Tecnico {

    public static Map<Integer, String> listTecnicos = BaseInkacells.getListTecnicos();

    private String nombre;
}
