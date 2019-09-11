import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FormNumber {
    private JPanel rootPanel;
    private JPanel mainPanel;
    private JButton closeButton;
    private JButton hideButton;
    private JTextPane textPane;
    private JTextField numberField;
    private JButton buttonContinue;
    private JPanel logoPanel;
    private JPanel phonePanel;
    private JPanel numberPanel;
    private BufferedImage background;
    private BufferedImage logo;
    private BufferedImage buttonBackground;
    private BufferedImage phone;

    public FormNumber(JFrame frame) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Color whiteColor = new Color(255, 255, 255);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor);
        numberPanel.setBorder(border);

        StyledDocument document = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        document.setParagraphAttributes(0, document.getLength(), center, false);

        try {
            background = ImageIO.read(new File("res/img/background.png"));
            logo = ImageIO.read(new File("res/img/logo.png"));
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));
            phone = ImageIO.read(new File("res/img/icon-phone.png"));

            hideButton.setIcon(new ImageIcon("res/img/icon-hide.png"));
            closeButton.setIcon(new ImageIcon("res/img/icon-close.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonContinue.addActionListener(e -> {
                FormCode formCode = new FormCode(frame);
                frame.setContentPane(formCode.getRootPanel());
                frame.getContentPane().revalidate();
                formCode.setNumberLabel("+7 " + numberField.getText());
        });

        hideButton.addActionListener(e -> {
                frame.setState(JFrame.ICONIFIED);
        });

        closeButton.addActionListener(e -> {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

        logoPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 18, 50, null);
            }
        };

        phonePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(phone, 0, 0, null);
            }
        };

        buttonContinue = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonBackground, 0, 0, null);

                g.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                g.drawString("ПРОДОЛЖИТЬ", 100, 35);
            }
        };

        numberField = new JTextField() {
            @Override
            public void setBorder(Border border) {
                //None
            }
        };
    }
}
