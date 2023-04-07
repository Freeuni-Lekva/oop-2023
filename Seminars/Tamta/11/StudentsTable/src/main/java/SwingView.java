import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView {

    JFrame frame;
    StudentsStore store;
    StudentTableModel model;
    public SwingView(StudentsStore store) {
        frame = new JFrame();
        this.store = store;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel createPanel = new JPanel(new GridLayout(2, 4));
        JTextField firstNameField = new JTextField("first name");
        JTextField lastNameField = new JTextField("last name");
        JTextField yearField = new JTextField("year");
        JButton create = new JButton("create");

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("create");
                // create Student
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String year = yearField.getText();
                Student student = new Student(firstName, lastName, Integer.parseInt(year));
                // add student to db
                store.addStudent(student);
                // update view
                model.setStudents(store.getStudents());
            }
        });

        JTextField firstNameFilterField = new JTextField();
        JTextField lastNameFilterField = new JTextField();
        JTextField yearFilterField = new JTextField();
        JButton filter = new JButton("filter");

        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("filter");
            }
        });

        createPanel.add(firstNameField);
        createPanel.add(lastNameField);
        createPanel.add(yearField);
        createPanel.add(create);
        createPanel.add(firstNameFilterField);
        createPanel.add(lastNameFilterField);
        createPanel.add(yearFilterField);
        createPanel.add(filter);

        mainPanel.add(createPanel, BorderLayout.NORTH);

        frame.add(mainPanel);
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTable table = new JTable();
        model = new StudentTableModel();
        table.setModel(model);
        model.setStudents(store.getStudents()); // თუ დასაწყისშივე გვყავს ბაზაში სტუდენტები ჩასმული. მათ გამოსაჩენად საჭიროა ეს ხაზი

        JPanel tablePanel = new JPanel(new BorderLayout());

        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        mainPanel.add(tablePanel);


    }

    public void show(){
        frame.setVisible(true);
    }
}
