import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.ConexionBD;

public class RecursoDAO {

    public boolean insertarRecurso(String tipo, String nombre, int cantidad, String direccionEntrega) {
        Connection con = ConexionBD.getInstancia().getConexion();
        String sql = "INSERT INTO recursos(tipo, nombreRecurso, cantidad, direccionEntrega) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.setString(2, nombre);
            stmt.setInt(3, cantidad);
            stmt.setString(4, direccionEntrega);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar recurso: " + e.getMessage());
            return false;
        }
    }
}
