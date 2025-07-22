
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class NecesidadDAO 
{
    private final Connection conexion;

    public NecesidadDAO(Connection conexion) 
    {
        this.conexion = conexion;
    }

    public boolean RegistrarNecesidadCommand(String nombre, String apellidos, String telefono, String direccion, String grupo, String descripcion) {
    try {
        String sql = "INSERT INTO necesidades (nombre_persona, apellidos, telefono, direccion, grupo_vulnerable, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellidos);
        ps.setString(3, telefono);
        ps.setString(4, direccion);
        ps.setString(5, grupo);
        ps.setString(6, descripcion);
        ps.executeUpdate();
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public void ControladorNecesidad(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void registrarNecesidad(String nombre, String apellidos, String telefono, String direccion, String grupo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<String[]> obtenerTodasLasNecesidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<String[]> buscarNecesidadesPorGrupo(String grupo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
