package dao;

import java.util.List;

import metier.Ingredient;

public interface DAOIngredient extends DAO<Ingredient, Integer>{
	public List<Ingredient> searchByName();
}
