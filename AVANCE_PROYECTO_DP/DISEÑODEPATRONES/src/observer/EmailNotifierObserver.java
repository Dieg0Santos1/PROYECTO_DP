
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
}
