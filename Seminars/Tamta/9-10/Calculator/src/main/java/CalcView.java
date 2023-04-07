public interface CalcView extends DisplayListener{
    void show();

    void registerInputListener(InputListener inputListener);

    void fireInputReceived(String input);
}
