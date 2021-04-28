import java.sql.Connection;
import java.util.List;

import DAO.SeConnecter;
import DAO.StockDaoImpl;
import beans.Stock;

public class Test {

	public static void main(String[] args) {

				Connection connect = SeConnecter.getConnection();
				StockDaoImpl nSDao1 = new StockDaoImpl();
				List<Stock>prods=nSDao1.getStockParMC("#10");
				for(Stock pro:prods) {
					System.out.println();
				}
				
		
				
				
				
	}

}
