package V3;

public class Main {

    public static void main(String[] args) {
        Node mul = new MultiplyOperation(new ValueNode(2.0), new ValueNode(3));
        Node sum = new SumOperation(mul, new ValueNode(1));
        System.out.println(mul.evaluate());
        System.out.println(mul);
        System.out.println(sum.evaluate());
        System.out.println(sum);
    }
}
