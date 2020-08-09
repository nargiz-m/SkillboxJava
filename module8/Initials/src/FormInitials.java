import javax.swing.*;
import java.awt.event.*;

public class FormInitials extends JFrame
{
    private JPanel rootPanel;
    private JTextField initialsField;
    private JButton switchButton;
    private JProgressBar progressBar;

    public FormInitials(JFrame frame) {
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormFullName formFullName = new FormFullName(frame);
                frame.setContentPane(formFullName.getRootPanel());
                frame.getContentPane().revalidate();
                String[] nameArray = initialsField.getText().split("\\s+");
                if (nameArray.length >= 1) {
                    formFullName.setSurname(nameArray[0]);
                }
                if (nameArray.length >= 2) {
                    formFullName.setName(nameArray[1]);
                }
                if (nameArray.length >= 3) {
                    formFullName.setPatronymic(nameArray[2]);
                }
            }
        });

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = switchButton.getInputMap(condition);
        ActionMap actionMap = switchButton.getActionMap();
        inputMap.put(keyStroke, keyStroke.toString());
        actionMap.put(keyStroke.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                switchButton.doClick();
            }
        });

        initialsField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int progress = 4 * initialsField.getText().length();
                progressBar.setValue(progress);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setInitials(String initials) {
        initialsField.setText(initials);
    }

    public void setProgressBar(int value) {
        progressBar.setValue(4 * value);
    }
}
