
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

    public void registrar(String nombre, String apellidos, String grupo, String descripcion) {
        dao.registrarNecesidad(nombre, apellidos, grupo, descripcion);
        notifyObservers(nombre, apellidos, grupo, descripcion);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String nombre, String apellidos, String grupo, String descripcion) {
        for (Observer o : observers) {
            o.update(nombre, apellidos, grupo, descripcion);
        }
    }
}
