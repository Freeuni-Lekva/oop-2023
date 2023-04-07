public class Main {
    public static void main(String[] args) {
        CalcView view = new SwingView();
        CalcBrain brain = new ArithmeticBrain();
        CalcController controller = new CalcController(brain, view);
        controller.start();
    }
}
