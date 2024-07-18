import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes";
        String usuario = "root";
        String Password = "j.eduardo23";

        String sql = "INSERT INTO estudiantes where Cedula_EST, Nombre_EST, B1, B2) Values(?,?,?,?)";
            try (Connection connection = DriverManager.getConnection(url, usuario, Password)) {
                System.out.println("Coneccion con la base de datos");


        } catch (SQLException e) {
                System.out.println("No se pudo conectar con la base de datos");
                throw new RuntimeException(e);
            }
    }
}