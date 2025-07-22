package controlador;

import java.util.ArrayList;
import java.util.List;
import dao.NecesidadDAO;
import modelo.ConexionBD;
import observer.Observer;
import observer.Subject;
import observer.LoggerObserver;
import observer.EmailNotifierObserver;

public class ControladorNecesidad implements Subject {
    private final NecesidadDAO dao;
    private final List<Observer> observers = new ArrayList<>();

    public ControladorNecesidad() {
        dao = new NecesidadDAO(ConexionBD.getInstancia().getConexion());

        // Observadores que reaccionan al registrar una necesidad
        addObserver(new LoggerObserver());
        addObserver(new EmailNotifierObserver());
    }

    // Método antiguo (opcional si aún se usa en otra parte)
    public void registrar(String nombre, String apellidos, String grupo, String descripcion) {
        registrar(nombre, apellidos, "", "", grupo, descripcion);
    }

    // ✅ Método principal actualizado — ahora retorna si fue exitoso
    public boolean registrar(String nombre, String apellidos, String telefono, 
                             String direccion, String grupo, String descripcion) {
        // Validación básica de campos obligatorios
        if (nombre == null || nombre.trim().isEmpty() || 
            apellidos == null || apellidos.trim().isEmpty()) {
            System.err.println("Nombre y apellidos son campos obligatorios.");
            return false;
        }

        boolean exito = dao.RegistrarNecesidadCommand(nombre, apellidos, telefono, direccion, grupo, descripcion);

        if (exito) {
            notifyObservers(nombre, apellidos, telefono, direccion, grupo, descripcion);
        }

        return exito;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // ✅ Método único para notificar observadores con cualquier cantidad de datos
    public void notifyObservers(String... datos) {
        for (Observer o : observers) {
            o.update(datos);
        }
    }

    // ✅ Métodos de consulta
    public List<String[]> listarNecesidades() {
        return dao.obtenerTodasLasNecesidades();
    }

    public List<String[]> buscarPorGrupo(String grupo) {
        return dao.buscarNecesidadesPorGrupo(grupo);
    }

    @Override
    public void notifyObservers(String nombre, String apellidos, String grupo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
