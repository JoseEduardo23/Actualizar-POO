import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Form1 extends JFrame {
    public JButton Modificar;
    public JPanel MainPanel1;
    public JTextField NomM;
    public JTextField Nota1M;
    public JTextField Nota2M;
    public JTextField CIMod;
    public JTextField CedulaMOD;
    public JTextField NombreMod;
    public JTextField Nota1Mod;
    public JTextField Nota2Mod;
    public Container MainPanel;

    public Form1() {
        Modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes";
                String usuario = "root";
                String password = "j.eduardo23";

                String Cedula = CIMod.getText();
                String Nombre = NomM.getText();
                String Nota1 = Nota1M.getText();
                String Nota2 = Nota2M.getText();

                String sql = "UPDATE estudiantes SET Nombre_EST = ?, B1 = ?, B2 = ? WHERE Cedula_EST = ?";
                PreparedStatement preparedStatement = null;
                try{
                    Connection connection = DriverManager.getConnection(url, usuario, password);
                    System.out.println("Conexión con la base de datos");
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, Nombre);
                    preparedStatement.setDouble(2, Double.parseDouble((Nota1)));
                    preparedStatement.setDouble(3, Double.parseDouble(Nota2));
                    preparedStatement.setString(4, Cedula);

                    int a = preparedStatement.executeUpdate();
                    System.out.println("Se modificaron: " + a + " líneas");
                    JOptionPane.showMessageDialog(null, "Modificado exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
                    CedulaMOD.setText(Cedula);
                    NombreMod.setText(Nombre);
                    Nota1Mod.setText(Nota1);
                    Nota2Mod.setText(Nota2);

                    CIMod.setText("");
                    NomM.setText("");
                    Nota1M.setText("");
                    Nota2M.setText("");

                    Form2 form2 = new Form2();


                } catch (SQLException e2) {
                    System.out.println("No se pudo conectar con la base de datos");
                    throw new RuntimeException(e2);
                } finally {
                    // Cerrar la conexión
                    try {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                    } catch (SQLException e1) {
                        System.out.println(e1.getMessage());
                    }
                }
            }
        });
    }
}
