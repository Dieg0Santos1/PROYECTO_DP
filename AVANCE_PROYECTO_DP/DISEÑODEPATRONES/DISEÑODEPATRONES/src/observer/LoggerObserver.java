
package observer;

public class LoggerObserver implements Observer
{
    @Override
    public void update(String nombre, String apellidos, String grupo, String descripcion) 
    {
        System.out.println("🗒️ Registro: " + nombre + " " + apellidos + " [" + grupo + "] - " + descripcion);
    }

    @Override
    public void update(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
