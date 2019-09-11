import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FormContactEditing {
    private JPanel rootPanel;
    private JButton hideButton;
    private JButton closeButton;
    private JPanel lowerPanel;
    private JPanel mainPanel;
    private JButton backButton;
    private JPanel numberPanel;
    private JPanel picPanel;
    private JTextField fullNameField;
    private JPanel JPanel;
    private JButton buttonSave;
    private JButton deleteButton;
    private BufferedImage buttonBackground;
    private BufferedImage mask;

    public FormContactEditing(JFrame frame, JPanel glass) {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Color transparentBlack = new Color(0, 0, 0, 220);
        mainPanel.setBackground(transparentBlack);
        lowerPanel.setBackground(transparentBlack);
        deleteButton.setBackground(transparentBlack);
        backButton.setBackground(transparentBlack);


        try {
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));
            mask = ImageIO.read(new File("res/img/mask-dark-gray-big.png"));

            hideButton.setIcon(new ImageIcon("res/img/icon-hide.png"));
            closeButton.setIcon(new ImageIcon("res/img/icon-close.png"));
            backButton.setIcon(new ImageIcon("res/img/icon-back.png"));
            deleteButton.setIcon(new ImageIcon("res/img/icon-trash.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Color whiteColor = new Color(255, 255, 255);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, whiteColor);
        numberPanel.setBorder(border);

        Border deleteBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(247, 77, 78));
        deleteButton.setBorder(deleteBorder);

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

    private void createUIComponents() {
        buttonSave = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonBackground, 0, 0, null);

                g.setFont(new Font("Segoe UI", Font.PLAIN, 22));
                g.drawString("СОХРАНИТЬ", 100, 35);
            }
        };

        fullNameField = new JTextField() {
            @Override
            public void setBorder(Border border) {
                //None
            }
        };
    }
}
