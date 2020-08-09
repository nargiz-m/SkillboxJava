import javax.swing.*;
import java.awt.*;

public class Loader
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        Form form = new Form();
        frame.setContentPane(form.getRootPanel());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Initials");
        frame.setVisible(true);
    }
}
