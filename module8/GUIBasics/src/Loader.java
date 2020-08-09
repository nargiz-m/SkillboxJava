import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loader
{
    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame();

        Form form = new Form();
        frame.setContentPane(form.getRootPanel());

        frame.setUndecorated(true);
        //frame.setResizable(false);

//        frame.setLayout(new FlowLayout());
//        JButton button = new JButton();
//        button.setText("Click me!");
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.getContentPane().setBackground(Color.red);
//            }
//        });
//        frame.add(button);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(400, 300);
        frame.setLocation(dimension.width/2-frame.getSize().width/2, dimension.height/2-frame.getSize().height/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("GUI Basics");
        frame.setVisible(true);
    }
}
