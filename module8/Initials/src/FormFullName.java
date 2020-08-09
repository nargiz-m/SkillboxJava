import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormFullName extends JFrame
{
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField patronymicField;
    private JPanel rootPanel;
    private JButton switchButton;
    private JPanel surnamePanel;
    private JPanel namePanel;
    private JPanel patronymicPanel;
    private JPanel buttonPanel;

    public FormFullName(JFrame frame) {
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormInitials formInitials = new FormInitials(frame);
                boolean hasPatronymic = true;

                if (surnameField.getText().equals("") || nameField.getText().equals("")) {
                    if (surnameField.getText().equals("") && nameField.getText().equals("")) {
                        JOptionPane.showMessageDialog(
                                rootPanel,
                                "Необходимо заполнить поля с фамилией и именем",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                    if (surnameField.getText().equals("") && !nameField.getText().equals("")) {
                        JOptionPane.showMessageDialog(
                                rootPanel,
                                "Необходимо заполнить поле с фамилией",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                    if (!surnameField.getText().equals("") && nameField.getText().equals("")) {
                        JOptionPane.showMessageDialog(
                                rootPanel,
                                "Необходимо заполнить поле с именем",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                else {
                    if (patronymicField.getText().equals("")) {
                        int option = JOptionPane.showConfirmDialog(
                                rootPanel,
                                "Уверены ли Вы в том, что не хотите установить отчество?",
                                "Пустое поле",
                                JOptionPane.YES_NO_OPTION
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            hasPatronymic = false;
                        }
                        else if (option == JOptionPane.NO_OPTION) {
                            patronymicField.grabFocus();
                        }
                    }
                    if (!hasPatronymic || !patronymicField.getText().equals("")) {
                        frame.setContentPane(formInitials.getRootPanel());
                        frame.getContentPane().revalidate();
                        String fullName = surnameField.getText() + " " + nameField.getText() + " " + patronymicField.getText();
                        formInitials.setInitials(fullName);
                        formInitials.setProgressBar(fullName.length());
                    }
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
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setPatronymic(String patronymic) {
        this.patronymicField.setText(patronymic);
    }

    public void setName(String name) {
        this.nameField.setText(name);
    }

    public void setSurname(String surname) {
        this.surnameField.setText(surname);
    }
}
