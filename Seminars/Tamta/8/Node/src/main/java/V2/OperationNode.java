package V2;

public class OperationNode implements Node{
    private final char operation;
    private final Node left;
    private final Node right;

    public OperationNode(char op, Node left, Node right){
        if (!("+*".contains(op + ""))) {
            throw new IllegalArgumentException();
        }
        operation = op;
        this.left = left;
        this.right = right;
    }

    public OperationNode(char op, double left, double right){
        this(op, new ValueNode(left), new ValueNode(right));
    }

    @Override
    public double evaluate() {
        return switch (operation) {
            case '+' -> left.evaluate() + right.evaluate();
            case '*' -> left.evaluate() * right.evaluate();
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }
}
