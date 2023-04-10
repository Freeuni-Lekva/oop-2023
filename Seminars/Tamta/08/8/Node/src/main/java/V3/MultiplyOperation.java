package V3;

public class MultiplyOperation extends OperationNode {

    public MultiplyOperation(Node left, Node right) {
        super(left, right);
        operation = '*';
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
