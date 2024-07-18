import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Form1().MainPanel1);
        frame.setSize(800, 600);
        frame.setPreferredSize(new Dimension(800, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}