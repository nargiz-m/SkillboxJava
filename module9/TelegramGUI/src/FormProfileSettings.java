import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FormProfileSettings {

    private JPanel rootPanel;
    private JButton hideButton;
    private JButton closeButton;
    private JPanel lowerPanel;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton exitButton;
    private JLabel phoneLabel;
    private JPanel namePanel;
    private JTextField nameField;
    private JPanel surnamePanel;
    private JTextField surnameField;
    private JButton buttonSave;
    private BufferedImage buttonBackground;

    public FormProfileSettings(JFrame frame, JPanel glass) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Color transparentBlack = new Color(0, 0, 0, 220);
        mainPanel.setBackground(transparentBlack);
        lowerPanel.setBackground(transparentBlack);
        backButton.setBackground(transparentBlack);
        exitButton.setBackground(transparentBlack);

        Color whiteColor = new Color(255, 255, 255);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor);
        namePanel.setBorder(border);
        surnamePanel.setBorder(border);

        try {
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));

            hideButton.setIcon(new ImageIcon("res/img/icon-hide.png"));
            closeButton.setIcon(new ImageIcon("res/img/icon-close.png"));
            backButton.setIcon(new ImageIcon("res/img/icon-back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Font font = exitButton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        exitButton.setFont(font.deriveFont(attributes));
        mainPanel.addComponentListener(new ComponentAdapter() {
        });

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        backButton.addActionListener(e -> {
                glass.remove(rootPanel);
                glass.setVisible(false);
        });

        closeButton.addActionListener(e -> {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });

        hideButton.addActionListener(e -> {
                frame.setState(JFrame.ICONIFIED);
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void createUIComponents() {
        buttonSave = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonBackground, 0, 0, null);

                g.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                g.drawString("СОХРАНИТЬ", 110, 35);
            }
        };

        nameField = new JTextField() {
            @Override
            public void setBorder(Border border) {
                //None
            }
        };

        surnameField = new JTextField() {
            @Override
            public void setBorder(Border border) {
                //None
            }
        };

    }
}
