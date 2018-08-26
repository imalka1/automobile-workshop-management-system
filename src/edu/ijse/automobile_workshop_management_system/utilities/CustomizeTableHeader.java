package edu.ijse.automobile_workshop_management_system.utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomizeTableHeader extends DefaultTableCellRenderer {

    private Component component;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setForeground(new Color(132,132,132));
        component.setBackground(new Color(58,58,58));
        component.setFont(new Font("Neuropol X Rg", 1, 16));
        return component;
    }
}
