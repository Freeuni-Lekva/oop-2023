package V3;

import V3.OperationNode;

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
