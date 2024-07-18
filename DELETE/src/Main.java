import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/estudiantes";
        String usuario = "root";
        String password = "j.eduardo23";

        String sql = "DELETE FROM estudiantes WHERE Cedula_EST = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = DriverManager.getConnection(url, usuario, password);
        String cedula = "0338943111";
        try{
            System.out.println("Conexión con la base de datos");
            preparedStatement = connection.prepareStatement(sql);
            JOptionPane.showMessageDialog(null, "Eliminacion completa", null, JOptionPane.INFORMATION_MESSAGE);
            preparedStatement.setString(1, cedula);

            int filasEliminadas = preparedStatement.executeUpdate();
            if (filasEliminadas>0){
                System.out.println("El estudiante con cedula " + cedula + " se ha eliminado correctamente" );
            }else {
                System.out.println("No se ha encontrado ningun estudiante con cedula " + cedula);
            }


        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la base de datos");
            throw new RuntimeException(e);
        } finally {
            // Cerrar la conexión
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }
}