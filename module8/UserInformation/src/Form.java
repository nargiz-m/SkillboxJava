import javax.swing.*;

public class Form {
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton нажмиНаМеняButton;

    public Form(){
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
