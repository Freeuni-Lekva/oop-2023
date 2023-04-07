public class Main {

    public static void main(String[] args) {
        Student student = new Student("bacho", "kartsivadze", 3);
        StudentsStore store = new StudentsStore();
        store.addStudent(student);
        SwingView view = new SwingView(store);
        view.show();
    }
}
