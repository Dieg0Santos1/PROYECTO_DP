
package observer;

public interface Observer 
{
    void update(String nombre, String apellidos, String grupo, String descripcion);

    public void update(String[] datos);
}
