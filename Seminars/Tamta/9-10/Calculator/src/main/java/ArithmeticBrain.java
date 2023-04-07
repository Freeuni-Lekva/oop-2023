public class ArithmeticBrain implements CalcBrain{
    private String prevNumber;
    private String curNumber;
    private char op;

    private DisplayListener displayListener;

    public ArithmeticBrain() {
        this.prevNumber = "";
        this.curNumber = "";
    }

    @Override
    public void pushDigit(String digit) {
        if (op == '=' && prevNumber.equals("")) { // თუ ბოლოს ტოლობის ოპერაციას დააჭირეს, შემდეგ ციფრზე დაჭერა არსებულ რიცხვს უნდა ანულებდეს
            prevNumber = curNumber;
            curNumber = "";
        }
        curNumber += digit;
        fireDisplayChanged(curNumber);
    }

    @Override
    public void pushOperation(String operation) {
        prevNumber = curNumber;
        curNumber = "";
        op = operation.charAt(0);
    }

    @Override
    public void evaluate() {
        double first = getDouble(prevNumber);
        double second = getDouble(curNumber);
        double result = 0;
        switch (op) {
            case '+': result = first + second; break;
            case '-': result = first - second; break;
            case '*': result = first * second; break;
            case '/': {
                if (second == 0){
                    throw new IllegalStateException("Division by 0");
                }
                result = first / second;
            } break;
            default:
                throw new IllegalStateException("Unexpected value: " + op);
        }
        String resultStr = Double.toString(result);
        op = '=';
        prevNumber = "";
        curNumber = resultStr;
        fireDisplayChanged(resultStr);
    }
    @Override
    public void registerDisplayListener(DisplayListener displayListener){
        this.displayListener = displayListener;
    }

    public void fireDisplayChanged(String display){
        displayListener.displayChanged(display);
    }

    private double getDouble(String num){
        if (num.equals("")) {
            return 0;
        }
        return Double.parseDouble(num);
    }
}
