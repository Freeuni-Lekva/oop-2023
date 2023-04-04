public class CalcController implements InputListener{
    private CalcView view;
    private CalcBrain brain;

    public CalcController(CalcBrain brain, CalcView view) {
        this.brain = brain;
        this.view = view;
        view.registerInputListener(this);
        brain.registerDisplayListener(view);
    }

    public void start(){
        view.show();
    }

    @Override
    public void inputReceived(String input) {
        Character ch = input.charAt(0);
        if (Character.isDigit(ch)) {
            brain.pushDigit(input);
        } else if ("+-*/".contains(input)) {
            brain.pushOperation(input);
        } else if (ch == '=') {
            brain.evaluate();
        }
    }
}
