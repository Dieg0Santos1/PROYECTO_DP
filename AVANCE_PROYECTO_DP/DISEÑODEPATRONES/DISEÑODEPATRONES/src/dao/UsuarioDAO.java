import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.ConexionBD;

public class UsuarioDAO {

    public boolean insertarUsuario(String nombre, String apellidos, String telefono, String direccion, String grupo, String descripcion) {
        Connection con = ConexionBD.getInstancia().getConexion();
        String sql = "INSERT INTO usuarios(nombre, apellidos, telefono, direccion, grupo, descripcion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, telefono);
            stmt.setString(4, direccion);
            stmt.setString(5, grupo);
            stmt.setString(6, descripcion);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }
}
