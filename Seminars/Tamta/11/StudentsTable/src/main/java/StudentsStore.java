import java.util.ArrayList;
import java.util.List;

public class StudentsStore {
    List<Student> students;

    public StudentsStore() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> filter(Filter filter) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student: students) {
            if (filter.filter(student)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }


}
