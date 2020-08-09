import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loader
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        FormFullName formFullName = new FormFullName(frame);
        frame.setContentPane(formFullName.getRootPanel());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Initials");
        frame.setVisible(true);
    }
}
