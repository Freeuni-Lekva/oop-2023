package V3;

public class Main {

    public static void main(String[] args) {
        Node a = new SumOperation( new ValueNode(1.0), new ValueNode(3));
        System.out.println(a.evaluate());
        System.out.println(a);
    }
}
