import java.util.List;

public interface StudentsDao {
    void add(Student st);
    void remove(Student st);
    List<Student> getAll();
}
