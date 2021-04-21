package DAO;

import java.util.List;

import beans.Stock;

public interface IDAO<T> {
	public boolean ajout(T objet);
	public  List<Stock>  read();


}
