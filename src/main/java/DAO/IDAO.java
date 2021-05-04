package DAO;

import java.util.List;

import beans.Stock;

public interface IDAO<T> {
	public boolean ajout(T objet);
	public void Update(Stock objet);
	public  List<Stock> read();
	public List<Stock> getStockParMC(String mc);
	public void delete(Stock objet);
	public boolean remove(Stock objet);
	List<Stock>recuperer(int id);
 
void modifier(int quantite, String reference);
void modifier(Stock article);
	
}
