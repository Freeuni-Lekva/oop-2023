import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView implements CalcView, DisplayListener{
    InputListener inputListener;
    JFrame frame;
    JTextField inputField;
    public SwingView() {
        frame = new JFrame();
        frame.setSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);

        // panel for rendering input/output numbers
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setEditable(false);
        inputPanel.add(inputField);

        // digits buttons
        JPanel digitsPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 0; i < 10; i++) {
            digitsPanel.add(addButton("" + i));
        }
        digitsPanel.add(addButton("."));
        digitsPanel.add(addButton("="));

        // commands buttons
        JPanel commandsPanel = new JPanel(new GridLayout(4, 1));
        String[] commands = {"+", "-", "*", "/"};
        for (String command: commands) {
            commandsPanel.add(addButton(command));
        }

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(digitsPanel, BorderLayout.CENTER);
        frame.add(commandsPanel, BorderLayout.EAST);
    }

    private JButton addButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent.getActionCommand());
                fireInputReceived(actionEvent.getActionCommand());
            }
        });
        return button;
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void registerInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    @Override
    public void fireInputReceived(String input) {
        inputListener.inputReceived(input);
    }


    @Override
    public void displayChanged(String display) {
        inputField.setText(display);
    }
}


