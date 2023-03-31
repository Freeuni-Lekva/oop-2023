import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView {

    public SwingView() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);

        // panel for rendering input/output numbers
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField inputField = new JTextField();
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
        frame.setVisible(true);
    }

    private JButton addButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent.getActionCommand());
            }
        });
        return button;
    }

}


