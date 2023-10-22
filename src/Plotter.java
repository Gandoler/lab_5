import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Plotter extends JFrame {


    public Plotter(File path) throws Exception {


        setTitle("Графики");
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width/2-400 ,dimension.height/2-400,800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent(path),BorderLayout.CENTER);
        jcp.setBackground(Color.gray);

        setLocationRelativeTo(null);
        setVisible(true);



    }





}
