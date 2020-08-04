package sistGestionLogistica.dao;

import java.sql.SQLException;
import java.util.List;
import sistGestionLogistica.dominio.Camion;


public interface CamionDao {

	public Camion saveOrUpdate(Camion c) throws SQLException;
	public Camion buscarPorPatente(String patente) throws SQLException;
	public void borrar(Integer id) throws SQLException;
	public List<Camion> buscarTodos() throws SQLException;
}