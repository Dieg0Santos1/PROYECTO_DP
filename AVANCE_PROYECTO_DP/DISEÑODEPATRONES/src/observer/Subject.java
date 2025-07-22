
package observer;

public interface Subject 
{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String nombre, String apellidos, String grupo, String descripcion);
}
