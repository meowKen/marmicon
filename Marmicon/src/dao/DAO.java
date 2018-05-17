package dao;

import java.sql.SQLException;
import java.util.List;


public interface DAO <T,K> {
	
			
	    public T selectByID(K id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
		
	    public List<T> selectAll() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
				
		public void insert(T obj) throws SQLException, ClassNotFoundException;
		
		public void update(T obj) throws SQLException, ClassNotFoundException;
		
		public void delete(T obj) throws ClassNotFoundException, SQLException;

				
			
	}

