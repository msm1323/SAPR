package preprcssr;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Render implements TableCellRenderer {
    public static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
    double ultimateVoltage;

    public Render(double d) {
        ultimateVoltage = d;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        double voltage = Double.valueOf(table.getModel().getValueAt(row, 3).toString());
        if (Math.abs(voltage) >= ultimateVoltage) {
            c.setBackground(Color.RED);
        } else {
            c.setBackground(table.getBackground());
        }
        return c;
    }
}