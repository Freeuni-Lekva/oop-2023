import javax.swing.*;

public class SwingView {
    ConwayTableModel model;
    public SwingView(boolean[][] grid){
        model = new ConwayTableModel(grid);
        JTable table = new ConwayTable(model);

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(table);
    }

    public void updateView(){
        model.fireTableDataChanged();
    }
}
