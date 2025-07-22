
package observer;

public class EmailNotifierObserver implements Observer
{
    @Override
    public void update(String nombre, String apellidos, String grupo, String descripcion) 
    {
        // Simulación de envío de correo (en producción usarías JavaMail o similar)
        System.out.println("📧 Enviando email a coordinador del grupo " + grupo +
            " sobre la necesidad de " + nombre + " " + apellidos + ": " + descripcion);
    }

    @Override
    public void update(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
