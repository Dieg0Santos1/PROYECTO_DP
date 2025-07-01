
package command;

import dao.NecesidadDAO;

public class RegistrarNecesidadCommand implements Command
{
    private NecesidadDAO dao;
    private String descripcion;

    public RegistrarNecesidadCommand(NecesidadDAO dao, String descripcion) 
    {
        this.dao = dao;
        this.descripcion = descripcion;
    }

    @Override
    public void execute() {
        dao.ControladorNecesidad(descripcion);
    }
}
