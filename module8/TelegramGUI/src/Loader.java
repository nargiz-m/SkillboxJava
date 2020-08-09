import javax.swing.*;
import java.awt.*;

public class Loader {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        FormNumber formNumber = new FormNumber(frame);
        frame.setContentPane(formNumber.getRootPanel());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Initials");
        frame.setVisible(true);
    }
}
