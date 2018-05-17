package dao;

import java.sql.SQLException;
import java.util.List;

import metier.Gateau;

public interface DAOGateau extends DAO<Gateau, Integer>{
	public List<Gateau> getAll();
	public List<Gateau> searchByName(String search) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}
