import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormNumber {
    private JPanel rootPanel;
    private JTextField numberField;
    private JPanel mainPanel;
    private JButton buttonContinue;
    private JTextPane введитеКодСтраныИTextPane;

    public FormNumber(JFrame frame) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCode formCode = new FormCode(frame);
                frame.setContentPane(formCode.getRootPanel());
                frame.getContentPane().revalidate();
                formCode.setNumberLabel(numberField.getText());
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
