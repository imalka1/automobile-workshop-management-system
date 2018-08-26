package edu.ijse.automobile_workshop_management_system.utilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomizeTable extends DefaultTableCellRenderer {

    private Component component;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setForeground(Color.BLACK);
        component.setBackground(Color.WHITE);
        if (isSelected) {
            component.setBackground(new Color(255,191,5));
        }       
        return component;
    }
}
