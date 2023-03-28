package V3;

public abstract class OperationNode extends Node{
    char operation;
    Node left;
    Node right;

    public OperationNode(Node left, Node right){
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }
}
