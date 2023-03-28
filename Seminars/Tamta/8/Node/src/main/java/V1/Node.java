package V1;

import java.security.InvalidParameterException;

public class Node {
    private double value;
    private char operation;
    private Node left;
    private Node right;

    public Node(double value) {
        this.value = value;
        operation = '$';
    }

    public Node(char op, Node left, Node right){
        operation = op;
        this.left = left;
        this.right = right;
    }

    public Node(char op, double left, double right){
        this(op, new Node(left), new Node(right));
    }

    public double evaluate(){
        switch (operation) {
            case '$': return value;
            case '+': return left.evaluate() + right.evaluate();
            case '*': return left.evaluate() * right.evaluate();
            case '-': return left.evaluate() - right.evaluate();
            case '/': return left.evaluate() / right.evaluate();
            default: throw new InvalidParameterException();
        }
    }

    @Override
    public String toString(){
        if (operation == '$') {
            return "(" + Double.toString(value) + ")";
        }

        if (!("+-*/".contains(operation + ""))) {
            throw new InvalidParameterException();
        }

        return "(" + left.toString() + operation + right.toString() + ")";

    }

}
