package main;

import java.sql.SQLException;
import java.util.List;

import dao.DAOGateauJDBC;
import metier.Gateau;

public class MarmiconMain {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//Exemple DAO
		DAOGateauJDBC daoG = new DAOGateauJDBC();
		//On récupère une liste de gateaux avec juste leur nom et id
		List<Gateau> listG = daoG.selectAll();
		//On affiche dans le menu Swing la liste des gateaux dispo
		//TODO AFFICHE
		//Simul un clic d'utilisateur sur un gateau de la liste :
		//Par exemple le gateau d'id 1
		Gateau gatSelect = daoG.selectByID(listG.get(1).getId());
		System.out.println(gatSelect.toString());
		//Test d'insertion d'un gateau :
		//PS on reprend le gateau selectionné au dessus c'est plus simple pour l'exempel
		daoG.insert(gatSelect);
	}

}
