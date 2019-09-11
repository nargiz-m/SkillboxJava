import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FormContactAdding {
    private JPanel rootPanel;
    private JButton hideButton;
    private JButton closeButton;
    private JPanel lowerPanel;
    private JPanel mainPanel;
    private JButton backButton;
    private JPanel namePanel;
    private JTextField nameField;
    private JPanel surnamePanel;
    private JTextField surnameField;
    private JButton buttonAdd;
    private JTextPane textPane;
    private JPanel phonePanel;
    private JTextField numberField;
    private JPanel numberPanel;
    private BufferedImage buttonBackground;
    private BufferedImage phone;

    public FormContactAdding(JFrame frame, JPanel glass) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Color transparentBlack = new Color(0, 0, 0, 220);
        mainPanel.setBackground(transparentBlack);
        lowerPanel.setBackground(transparentBlack);
        backButton.setBackground(transparentBlack);

        Color whiteColor = new Color(255, 255, 255);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor);
        numberPanel.setBorder(border);
        namePanel.setBorder(border);
        surnamePanel.setBorder(border);

        StyledDocument document = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        document.setParagraphAttributes(0, document.getLength(), center, false);

        nameField.setBorder(BorderFactory.createEmptyBorder());
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField.setCaretColor(Color.WHITE);

        surnameField.setBorder(BorderFactory.createEmptyBorder());
        surnameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        surnameField.setCaretColor(Color.WHITE);

        numberField.setBorder(BorderFactory.createEmptyBorder());
        numberField.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberField.setCaretColor(Color.WHITE);

        try {
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));
            phone = ImageIO.read(new File("res/img/icon-phone.png"));

            hideButton.setIcon(new ImageIcon("res/img/icon-hide.png"));
            closeButton.setIcon(new ImageIcon("res/img/icon-close.png"));
            backButton.setIcon(new ImageIcon("res/img/icon-back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        backButton.addActionListener(e -> {
                glass.remove(rootPanel);
                glass.setVisible(false);
        });

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
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

    private void createUIComponents() {
        phonePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(phone, 0, 0, null);
            }
        };

        buttonAdd = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonBackground, 0, 0, null);

                g.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                g.drawString("ДОБАВИТЬ", 100, 35);
            }
        };
    }
}
