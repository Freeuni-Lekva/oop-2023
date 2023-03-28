package V2;

import java.security.InvalidParameterException;

public class OperationNode implements Node{
    private char operation;
    private Node left;
    private Node right;

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
        switch (operation){
            case '+': return left.evaluate() + right.evaluate();
            case '*': return left.evaluate() * right.evaluate();
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }
}
