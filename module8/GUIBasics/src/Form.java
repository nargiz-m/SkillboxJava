import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Form
{
    private JButton clickMeButton;
    private JPanel rootPanel;
    private JTextField textField;
    private JTextField textLength;
    private JTextField textFieldDialog;
    private JButton button1;
    private JRadioButton мужскойRadioButton;
    private JRadioButton женскийRadioButton;
    private BufferedImage background;


    public Form() {
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));

        try {
            background = ImageIO.read(new File("res/img/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int random = (int) Math.round(10 * Math.random());
                textField.setText(Integer.toString(random));
            }
        });
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clickMeButton.setBackground(Color.GREEN);
            }
        });
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int length = textField.getText().length();
                    textLength.setText(Integer.toString(length));
                }
            }
        });
        rootPanel.addKeyListener(new KeyAdapter() {
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        rootPanel,
                        "Вы уверены, что хотите отформатировать содержимое диска?"
                );
                if (option == JOptionPane.YES_OPTION) {
                    textFieldDialog.setText("Yes");
                }
//                JOptionPane.showMessageDialog(
//                        rootPanel,
//                        "Length " + textFieldDialog.getText().length(),
//                        "Text length",
//                        JOptionPane.ERROR_MESSAGE
//                );
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };
    }
}
