import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FormContacts {
    private JButton hideButton;
    private JButton closeButton;
    private JPanel rootPanel;
    private JButton profileButton;
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel listPanel;
    private JPanel searchPanel;
    private JPanel dialogPanel1;
    private JPanel onlinePicPanel;
    private JPanel lastLogPanel;
    private JPanel namePanel;
    private JTextPane андрейПетровTextPane;
    private JPanel lastMessagePanel;
    private JTextPane хорошоДоВстречиTextPane;
    private JPanel logoPanel;
    private JPanel searchIconPanel;
    private JTextField searchField;
    private JPanel chosenPicPanel;
    private JPanel picPanel;
    private JPanel onlinePicPanel1;
    private JPanel currentDialogPanel;
    private JPanel dialogPanel2;
    private JPanel dialogPanel3;
    private JPanel dialogPanel4;
    private JPanel plusPanel;
    private JButton plusButton;
    private JPanel contactPanel;
    private JPanel yourMessagePanel;
    private JButton editButton;
    private JPanel currentContactPicPanel;
    private JPanel currentMessagePanel;
    private JButton sendButton;
    private JTextPane textPane1;
    private JPanel converrsationPanel;
    private JPanel inTopPanel1;
    private JPanel inLeftfPanel1;
    private JPanel inBottomPanel1;
    private JPanel inMessagePanel1;
    private JPanel inMessageTimePanel1;
    private JPanel inTimePanel1;
    private JLabel inTimeLabel1;
    private JPanel inMessagePanel2;
    private JPanel inTopPanel2;
    private JPanel inLeftfPanel2;
    private JPanel inBottomPanel2;
    private JLabel inTimeLabel2;
    private JPanel inMessageTimePanel2;
    private JTextPane inMessageTextPane1;
    private JTextPane inMessageTextPane2;
    private JPanel outTopPanel1;
    private JPanel outBottomPanel1;
    private JPanel outRightPanel1;
    private JLabel outTimeLabel1;
    private JTextPane outMessageTextPane1;
    private JPanel inLinePanel1;
    private JPanel inLinePanel2;
    private JPanel outLinePanel1;
    private JPanel outMessagePanel1;
    private JPanel outMessageTimePanel1;
    private JPanel conversationPanel;
    private JButton testbutton1;
    private BufferedImage microLogo;
    private BufferedImage settıngs;
    private BufferedImage maskBlue;
    private BufferedImage mask;
    private BufferedImage maskOnline;
    private BufferedImage maskChosen;
    private BufferedImage maskChosenMini;
    private BufferedImage search;
    private BufferedImage currentMessage;
    private BufferedImage inTop;
    private BufferedImage inLeft;
    private BufferedImage inBottom;
    private BufferedImage outTop;
    private BufferedImage outRight;
    private BufferedImage outBottom;

    public FormContacts(JFrame frame) {
        JPanel glass = (JPanel) frame.getGlassPane();

        Color greyColor = new Color(214, 214, 214);
        Border borderDialog = BorderFactory.createMatteBorder(0, 0, 1, 0, greyColor);
        searchPanel.setBorder(borderDialog);
        dialogPanel1.setBorder(borderDialog);
        dialogPanel2.setBorder(borderDialog);
        dialogPanel3.setBorder(borderDialog);
        dialogPanel4.setBorder(borderDialog);

        Color blueColor = new Color(0, 179, 230);
        Border chosenBorder = BorderFactory.createMatteBorder(0, 0, 0, 3, blueColor);
        dialogPanel2.setBorder(chosenBorder);

        Border borderCurrentDialog = BorderFactory.createMatteBorder(0, 1, 0, 0, greyColor);
        currentDialogPanel.setBorder(borderCurrentDialog);

        Color pinkColor = new Color(240, 240, 240);
        Border contactBorder = BorderFactory.createMatteBorder(0, 1, 1, 0, pinkColor);
        contactPanel.setBorder(contactBorder);

        try {
            microLogo = ImageIO.read(new File("res/img/logo-micro.png"));
            search = ImageIO.read(new File("res/img/icon-search.png"));
            currentMessage = ImageIO.read(new File("res/img/yourMessage.png"));
            settıngs = ImageIO.read(new File("res/img/icon-settings.png"));

            maskBlue = ImageIO.read(new File("res/img/mask-blue-mini.png"));
            mask = ImageIO.read(new File("res/img/mask-gray.png"));
            maskOnline = ImageIO.read(new File("res/img/mask-gray-online.png"));
            maskChosen = ImageIO.read(new File("res/img/mask-white.png"));
            maskChosenMini = ImageIO.read(new File("res/img/mask-white-mini.png"));

            inTop = ImageIO.read(new File("res/img/message-in-top.png"));
            inLeft = ImageIO.read(new File("res/img/message-in-left.png"));
            inBottom = ImageIO.read(new File("res/img/message-in-bottom.png"));

            outTop = ImageIO.read(new File("res/img/message-out-top.png"));
            outRight = ImageIO.read(new File("res/img/message-out-right.png"));
            outBottom = ImageIO.read(new File("res/img/message-out-bottom.png"));

            hideButton.setIcon(new ImageIcon("res/img/icon-hide.png"));
            closeButton.setIcon(new ImageIcon("res/img/icon-close.png"));
            plusButton.setIcon(new ImageIcon("res/img/icon-plus.png"));
            editButton.setIcon(new ImageIcon("res/img/icon-edit.png"));
            sendButton.setIcon(new ImageIcon("res/img/button-send.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        hideButton.addActionListener(e -> {
                frame.setState(JFrame.ICONIFIED);
        });

        profileButton.addActionListener(e -> {
                glass.setVisible(true);
                glass.setLayout(new GridBagLayout());
                FormProfileSettings formProfileSettings = new FormProfileSettings(frame, glass);
                glass.add(formProfileSettings.getRootPanel());
        });

        plusButton.addActionListener(e -> {
                glass.setVisible(true);
                glass.setLayout(new GridBagLayout());
                FormContactAdding formContactAdding = new FormContactAdding(frame, glass);
                glass.add(formContactAdding.getRootPanel());
        });

        editButton.addActionListener(e -> {
                glass.setVisible(true);
                glass.setLayout(new GridBagLayout());
                FormContactEditing formContactEditing = new FormContactEditing(frame, glass);
                glass.add(formContactEditing.getRootPanel());
        });

        closeButton.addActionListener(e -> {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(microLogo, 30, 15, null);
            }
        };

        searchIconPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(search, 20, 0, null);
            }
        };

        currentMessagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(currentMessage, 0, 0, null);
            }
        };

        onlinePicPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskOnline, 15, 10, null);
            }
        };

        onlinePicPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskOnline, 15, 10, null);
            }
        };

        chosenPicPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskChosen, 15, 10, null);
            }
        };

        currentContactPicPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskChosenMini, 0, 0, null);
            }
        };

        picPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(mask, 15, 10, null);
            }
        };

        inLeftfPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inLeft, 0, inMessageTextPane1.getHeight()/2, null);
            }
        };

        inTopPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inTop, 7, 0, null);
            }
        };

        inBottomPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inBottom, 7, 0, null);
            }
        };

        inLeftfPanel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inLeft, 0, inMessageTextPane2.getHeight()/2, null);
            }
        };

        inTopPanel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inTop, 7, 0, null);
            }
        };

        inBottomPanel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inBottom, 7, 0, null);
            }
        };

        outRightPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(outRight, 0, outMessageTextPane1.getHeight()/2, null);
            }
        };

        outTopPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(outTop, 0, 0, null);
            }
        };

        outBottomPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(outBottom, 0, 0, null);
            }
        };

        profileButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskBlue, 0, 0, null);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                g.drawString("Михаил Карасёв", 35, 21);

                g.drawImage(settıngs, 158, 5, null);
            }
        };

        searchField = new JTextField() {
            @Override
            public void setBorder(Border border) {
                //None
            }
        };
    }
}
