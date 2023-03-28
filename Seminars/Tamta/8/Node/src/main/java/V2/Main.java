package V2;

public class Main {

    public static void main(String[] args) {
        Node mul = new OperationNode('*', 2.0, 3.0);
        Node c = new ValueNode(1.0);
        Node sum = new OperationNode('+', mul, c);

        System.out.println(sum.evaluate());
        System.out.println(sum);

    }
}
