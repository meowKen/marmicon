package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import metier.Gateau;
import metier.Ingredient;
import metier.Instruction;
import metier.Recette;

public class DAOGateauJDBC implements DAOGateau{

	private Connection getConnection() throws SQLException {
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/marmicon?serverTimezone=UTC",properties);
		}
	public Gateau selectByID(Integer id)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		//Recupération gateau, sa recette et instructions
		PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT GA.id_gateau, GA.nom_gateau, GA.url_gateau, RE.id_recette, RE.temps_prep, INS.indication, INS.id_ordre "
				+ "FROM GATEAU AS GA INNER JOIN RECETTE AS RE ON GA.id_gateau = RE.id_gateau "
				+ "INNER JOIN INSTRUCTION AS INS ON RE.id_recette = INS.id_recette "
				+ "WHERE GA.id_gateau = ?");
		ps.setInt(1, id);
		ps.executeQuery();
		//Récupération des ingrédients de la recette
		ResultSet rs = ps.executeQuery();
		PreparedStatement ps2 = conn.prepareStatement("SELECT DISTINCT nom_ingredient, qte_ingredient FROM ingredient as ING "
				+ "INNER JOIN recette as RE ON ING.id_recette = RE.id_recette "
				+ "INNER JOIN gateau as GA ON GA.id_gateau=RE.id_gateau "
				+ "WHERE GA.id_gateau = ?");
		ps2.setInt(1, id);
		ResultSet rs2 = ps2.executeQuery();
		//On initilise les liste qu'il va y avoir dans la recette
		List<Ingredient> listIng = new ArrayList();
		List<Instruction> listInt = new ArrayList();
		String nomGateau = "";
		String tempsPrep = "";
		String urlGateau = "";
		//Ajout des ingrédients dans la liste d'ingrédients
		while(rs2.next()) {
			listIng.add(new Ingredient(rs2.getString("nom_ingredient"), rs2.getString("qte_ingredient")));
		}
		while(rs.next()) {
			listInt.add(new Instruction(rs.getInt("id_ordre"), rs.getString("indication")));
			tempsPrep = rs.getString("temps_prep");
			nomGateau = rs.getString("nom_gateau");
			urlGateau = rs.getString("url_gateau");
		}
		Recette rec = new Recette(tempsPrep, listIng, listInt);
		Gateau gat = new Gateau(nomGateau, rec, urlGateau);
		conn.close();
		return gat;
	}
	//Renvoie une liste de tout les gateaux de la base
	public List<Gateau> selectAll()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = getConnection();
		//Recupération gateau, sa recette et instructions
		PreparedStatement ps = conn.prepareStatement("SELECT id_gateau, nom_gateau, url_gateau FROM GATEAU");
		ResultSet rs = ps.executeQuery();
		List<Gateau> listGat = new ArrayList();
		while(rs.next()) {
			listGat.add(new Gateau(rs.getInt("id_gateau"), rs.getString("nom_gateau"), rs.getString("url_gateau")));
		}
		return listGat;
	}

	public void insert(Gateau gat) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		String reqInsert = "";
		//Insertion Gateau
		reqInsert = "INSERT INTO gateau(nom_gateau) VALUES ('"+gat.getNomGat().replaceAll("'", "\'")+"');";
		PreparedStatement ps = conn.prepareStatement(reqInsert);
		ps.executeUpdate();
		ps = conn.prepareStatement("SELECT DISTINCT LAST_INSERT_ID() as id_gateau FROM gateau");
		ResultSet rs = ps.executeQuery();
		int idGat = 0;
		if(rs.next())
		{
			idGat = rs.getInt("id_gateau");
		}
		//Insertion de la recette
		reqInsert = "INSERT INTO recette(id_gateau, temps_prep) VALUES ("+idGat+",'"+gat.getRecette().getTmpPrep()+"');";
		ps = conn.prepareStatement(reqInsert);
		ps.executeUpdate();
		ps = conn.prepareStatement("SELECT DISTINCT LAST_INSERT_ID() as id_recette FROM recette");
		rs = ps.executeQuery();
		int idRec = 0;
		if(rs.next())
		{
			idRec = rs.getInt("id_recette");
		}
		//Insertion des instructions
		reqInsert = "INSERT INTO instruction(id_recette, indication, id_ordre) VALUES (?,?,?)";
		ps = conn.prepareStatement(reqInsert);
		for (Instruction ins : gat.getRecette().getListInstr()) {
			ps.setInt(1, idRec);
			ps.setString(2, ins.getInstr());
			ps.setInt(3, ins.getIdOrdre());
			ps.addBatch();
			
		}
		ps.executeBatch();
		//Insertion des ingrédients :
		reqInsert = "INSERT INTO ingredient(nom_ingredient, qte_ingredient, id_recette) VALUES (?,?,?)";
		ps = conn.prepareStatement(reqInsert);
		for (Ingredient ing : gat.getRecette().getListIngre()) {
			ps.setString(1, ing.getNomIng());
			ps.setString(2, ing.getQteIng());
			ps.setInt(3, idRec);
			ps.addBatch();
		}
		ps.executeBatch();
	}

	public void update(Gateau obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Gateau obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


	public List<Gateau> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Retourne une liste de gateaux par recherche de noms
	public List<Gateau> searchByName(String search) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Connection conn = getConnection();
		//Recupération gateau, sa recette et instructions
		PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT GAT.id_gateau, nom_gateau, url_gateau FROM gateau as GAT "
                + " INNER JOIN recette as RE ON RE.id_gateau = GAT.id_gateau "
                + " INNER JOIN ingredient as ING ON RE.id_recette = ING.id_recette "
                + " WHERE nom_gateau LIKE ? OR ING.nom_ingredient LIKE ?;");
		ps.setString(1, '%'+search+'%');
		ps.setString(2, '%'+search+'%');

		ResultSet rs = ps.executeQuery();
		List<Gateau> listGat = new ArrayList();
		while(rs.next()) {
			listGat.add(new Gateau(rs.getInt("id_gateau"), rs.getString("nom_gateau"), rs.getString("url_gateau")));
		}
		return listGat;
	}

}
