import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ConwayTable extends JTable {
    public ConwayTable(AbstractTableModel model) {
        super(model);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        boolean val = (boolean) getValueAt(row, column);
        if (val) {
            c.setForeground(Color.BLUE);
            c.setBackground(Color.BLUE);
        }
        else {
            c.setForeground(Color.WHITE);
            c.setBackground(Color.WHITE);
        }
        return c;
    }
}

