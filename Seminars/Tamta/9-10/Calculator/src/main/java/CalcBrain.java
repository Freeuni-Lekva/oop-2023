public interface CalcBrain {
    void pushDigit(String digit);
    void pushOperation(String operation);
    void evaluate();
    void registerDisplayListener(DisplayListener displayListener);

}
