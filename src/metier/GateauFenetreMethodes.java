package metier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import dao.DAOGateauJDBC;
import dao.DAOIngredientJDBC;
import dao.DAORecetteJDBC;

public class GateauFenetreMethodes {

	DAOGateauJDBC gatJDBC = new DAOGateauJDBC();
	DAOIngredientJDBC ingJDBC = new DAOIngredientJDBC();
	DAORecetteJDBC recJDBC = new DAORecetteJDBC();


	private List<Gateau> listeGat = new ArrayList<Gateau>();
	private List<Ingredient> listeIng = new ArrayList<Ingredient>();
	private List<Instruction> listeInst = new ArrayList<Instruction>();


	//methodes

	//liste des gateaux et leur id
	public List<Gateau> listeGateaux(){
		try {
			listeGat = gatJDBC.selectAll();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeGat;

	}

	//liste des ingredients
	public List<Ingredient> listeIngredient(int idGat){
		Gateau g;
		try {
			g = gatJDBC.selectByID(idGat);
			//je recupere la recette du gateau
			Recette rec= g.getRecette();
			//je recupere la liste d'ingredients de cette recette
			listeIng = rec.getListIngre();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			listeIng.removeAll(listeIng);    // !!!!!!!!!!!!!!!!!!!!!!!!
			e.printStackTrace();
		}
		return listeIng;
	}

	//liste des ingredients
	public List<Instruction> listeInstruction(int idGat){
		Gateau g;
		try {
			g = gatJDBC.selectByID(idGat);
			//je recupere la recette du gateau
			Recette rec= g.getRecette();
			//je recupere la liste d'ingredients de cette recette
			listeInst = rec.getListInstr();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			listeInst.removeAll(listeInst);    // !!!!!!!!!!!!!!!!!!!!!!!!
			e.printStackTrace();
		}
		return listeInst;
	}

	//Image
	public ImageIcon newImg(int idGat) {
		ImageIcon newCake = new ImageIcon("images/newCake.png");
		Gateau g;
			 try {
				g = gatJDBC.selectByID(idGat);
				if(g.getUrl() != null) {
				URL url = new URL(g.getUrl());
				newCake = new ImageIcon(url);
				}
		
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return newCake;
	}
}
