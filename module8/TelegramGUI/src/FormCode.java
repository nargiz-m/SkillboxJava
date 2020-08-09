import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCode {
    private JPanel rootPanel;
    private JPanel mainPanel;
    private JTextPane наДанныйНомерТелефонаTextPane;
    private JButton buttonContinue;
    private JLabel numberLabel;
    private JPasswordField passwordField1;

    public FormCode(JFrame frame) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormContacts formContacts = new FormContacts();
                frame.setContentPane(formContacts.getRootPanel());
                frame.getContentPane().revalidate();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setNumberLabel(String number) {
        numberLabel.setText(number);
    }
}
