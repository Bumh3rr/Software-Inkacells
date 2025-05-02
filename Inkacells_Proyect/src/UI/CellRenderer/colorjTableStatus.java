package UI.CellRenderer;

import static UI.Panel.jPanel_NotaGlassPopup.*;
import static UI.Panel.model.AddNota.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class colorjTableStatus extends DefaultTableCellRenderer {

    private int index;

    public colorjTableStatus(int index) {
        this.index = index;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (String.valueOf(table.getValueAt(row, index)).contains(deaultStatus)) {
            this.setForeground(new Color(255, 165, 0));
        } else if (String.valueOf(table.getValueAt(row, index)).contains(statusListo)) {
            this.setForeground(new Color(153, 255, 0));
        } else if (String.valueOf(table.getValueAt(row, index)).contains(statusNoquedo)) {
            this.setForeground(new Color(255, 51, 102));
        }
        this.setHorizontalAlignment(SwingConstants.CENTER);

        Component tab = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        tab.setFont(new Font("Overpass", Font.BOLD, 13));

        return tab;
    }

}
