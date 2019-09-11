import javax.swing.*;
import java.awt.*;

public class Loader {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame();

                FormNumber form = new FormNumber(frame);
                frame.setContentPane(form.getRootPanel());

                frame.setUndecorated(true);
                frame.setResizable(false);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setSize(904, 636);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
