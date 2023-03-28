package V3;

import V3.OperationNode;

public class SumOperation extends OperationNode {

    public SumOperation(Node left, Node right) {
        super(left, right);
        operation = '+';
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
