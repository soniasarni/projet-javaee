package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import beans.Stock;
import net.proteanit.sql.DbUtils;

public class StockDaoImpl implements IDAO<Stock> {
	Connection connect = SeConnecter.getConnection();

	@Override
	public boolean ajout(Stock objet) {
		boolean message= false; 
		try {
			PreparedStatement req = connect.prepareStatement(
					"INSERT INTO stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
			req.setInt(1, objet.getQuantite());
			req.setString(2, objet.getReference());
			req.executeUpdate();
			System.out.println(objet.getReference()+ "Insertion OK");
       message=true;
		} catch (Exception e) {
			e.printStackTrace();
			 message=false;
		}
		return message;

	
	}
//////Liste des articles dans le stock
	public List<Stock> read() {
	List<Stock> listearticle = new ArrayList<>();	
//		
//		try {
//			PreparedStatement req = connect.prepareStatement("SELECT * FROM stock");
//			
//			ResultSet rs = req.executeQuery();
//			
//			while(rs.next()) {
//				Stock article1 = new Stock();
//				
//				article1.setId(rs.getInt("id"));
//				article1.setReference(rs.getString("reference"));
//				article1.setQuantite(rs.getInt("quantite"));
//				article1.setDateApprovisionnement(rs.getDate("dateAprovisionnement"));
//
//				listearticle.add(article1);
//			}
//		System.out.println(listearticle);
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Insertion KO - KO - KO");
//		}
	return listearticle;
	}
//


}
