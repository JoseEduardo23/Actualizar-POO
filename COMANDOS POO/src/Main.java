import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/estudiantes";
        String usuario = "root";
        String password = "j.eduardo23";

        String sql = "UPDATE estudiantes SET B1 = ? WHERE Cedula_EST = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = DriverManager.getConnection(url, usuario, password);
        try{
            System.out.println("Conexión con la base de datos");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 17);
            preparedStatement.setString(2, "0338943111");

            int a = preparedStatement.executeUpdate();
            System.out.println("Se modificaron: " + a + " líneas");

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