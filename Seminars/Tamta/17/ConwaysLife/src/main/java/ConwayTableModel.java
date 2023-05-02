import javax.swing.table.AbstractTableModel;

public class ConwayTableModel extends AbstractTableModel {
    private boolean[][] grid;
    public ConwayTableModel(boolean[][] grid){
        this.grid = grid;
    }

    public void setGrid(boolean[][] grid){
        this.grid = grid;
    }
    @Override
    public int getRowCount() {
        return grid.length;
    }

    @Override
    public int getColumnCount() {
        return grid[0].length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        return grid[i][j];
    }
}
