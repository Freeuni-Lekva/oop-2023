package V3;

public class ValueNode extends Node{
    private final double value;

    public ValueNode(double value){
        this.value = value;
    }
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
