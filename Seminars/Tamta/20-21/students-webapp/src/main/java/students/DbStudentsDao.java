package students;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DbStudentsDao implements StudentsDao{
    private final BasicDataSource dataSource;

    public DbStudentsDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Student st) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into students (student_id, idnumber, firstname, lastname) " +
                    "values (?, ?, ?, ?)");
            int id = new Random().nextInt(100);
            statement.setInt(1, id);
            statement.setString(2, "111111" + id);
            statement.setString(3, st.getFirstName());
            statement.setString(4, st.getLastName());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Student st) {

    }

    @Override
    public List<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("select * from students");
            while (result.next()) {
                Student student = new Student(
                        result.getString("firstname"),
                        result.getString("lastname"),
                        10
                );
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

}
