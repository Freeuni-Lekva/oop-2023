public class Main {

    public static void main(String[] args) {
        StudentsStore store = new StudentsStore();
        SwingView view = new SwingView(store);
        view.show();
    }
}
