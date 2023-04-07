import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    String[] header = {"first name", "last name", "year"};
    List<Student> students;

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public StudentTableModel() {
        students = new ArrayList<>();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        this.fireTableDataChanged(); // შეატყობინებს JTable-ს გადახატვის საჭიროების შესახებ.
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Student student = students.get(i);
        return switch (j) {
            case 0 -> student.getFirstName();
            case 1 -> student.getLastName();
            case 2 -> student.getYear();
            default -> throw new RuntimeException("Illegal column: " + j);
        };
    }
}