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

public class FormCode {
    private JPanel rootPanel;
    private JButton hideButton;
    private JButton closeButton;
    private JLabel numberLabel;
    private JTextPane textPane;
    private JPasswordField passwordField;
    private JButton buttonContinue;
    private JPanel mainPanel;
    private JPanel logoPanel;
    private JPanel codePanel;
    private JPanel lockPanel;
    private BufferedImage background;
    private BufferedImage miniLogo;
    private BufferedImage buttonBackground;
    private BufferedImage iconLock;

    public FormCode(JFrame frame) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Color whiteColor = new Color(255, 255, 255);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor);
        codePanel.setBorder(border);

        StyledDocument document = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        document.setParagraphAttributes(0, document.getLength(), center, false);

        try {
            background = ImageIO.read(new File("res/img/background.png"));
            miniLogo = ImageIO.read(new File("res/img/logo-mini.png"));
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));
            iconLock = ImageIO.read(new File("res/img/icon-lock.png"));

            hideButton.setIcon(new ImageIcon("res/img/icon-hide.png"));
            closeButton.setIcon(new ImageIcon("res/img/icon-close.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonContinue.addActionListener(e -> {
                FormRegistration formRegistration = new FormRegistration(frame);
                frame.setContentPane(formRegistration.getRootPanel());
                frame.getContentPane().revalidate();
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

    public void setNumberLabel(String numberLabel) {
        this.numberLabel.setText(numberLabel);
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
                g.drawImage(miniLogo, 3, 34, null);
            }
        };

        lockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconLock, 0, 0, null);
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

        passwordField = new JPasswordField() {
            @Override
            public void setBorder(Border border) {
                //None
            }
        };
    }
}
