import DAO.StudentDAO;
import bean.Course;
import bean.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test_4");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Tamtapass");

        StudentDAO studentDAO = new StudentDAO(basicDataSource);
        List<Student> students = studentDAO.getStudents();
        List<Course> student_1_courses = studentDAO.getStudentCourses(1);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println("\nStudents");
        for (Student student: students) {
            System.out.println(student);
            System.out.println(gson.toJson(student));
        }

        System.out.println("\nStudent id=1's courses:");
        for (Course course: student_1_courses) {
            System.out.println(course);
            System.out.println(gson.toJson(course));
        }

        System.out.println("\nStudent with id=3:");
        System.out.println(gson.toJson(studentDAO.getStudentById(3)));

        System.out.println(studentDAO.bla("1; drop table student_courses;"));

    }
}
