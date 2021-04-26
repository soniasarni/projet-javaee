package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import beans.Stock;


public class StockDaoImpl implements IDAO<Stock> {

	Connection connect = SeConnecter.getConnection();
	@Override
	public void Update(Stock objet) {
		
			 PreparedStatement req1;
			 try {
				req1 = connect.prepareStatement("UPDATE stock set quantite =? where reference=?");
				req1.setInt(1,objet.getQuantite());
				req1.setString(2,objet.getReference());
				req1.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("unable to save the the product");
			}
		}
	public int recupQte(Stock objet) {
		int X=0;
	
		if(objet.getReference()!=null) {
			
			 try {
				PreparedStatement req2= connect.prepareStatement("SELECT quantite FROM stock WHERE reference=?");
				req2.setInt(1,objet.getQuantite());
				ResultSet rs2 = req2.executeQuery();
				while(rs2.next()) {
					Stock article2 = new Stock();
					
					article2.setId(rs2.getInt("id"));
					article2.setReference(rs2.getString("reference"));
					article2.setQuantite(rs2.getInt("quantite"));
					article2.setDateApprovisionnement(rs2.getDate("dateAprovisionnement"));
				    X =rs2.getInt("quantite");
				System.out.println();	
				}

			} catch (SQLException e1) {
					e1.printStackTrace();
			}
				
			}
	return X;
	} 

	@Override
	public boolean ajout(Stock objet) {
		recupQte(objet);
		
		boolean message= false; 
	   try {
			PreparedStatement req = connect.prepareStatement(
					"INSERT INTO stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
			req.setInt(1, objet.getQuantite());
			req.setString(2, objet.getReference());
			req.executeUpdate();
			System.out.println(objet.getReference()+ "Insertion OK");
		//SI LE PRODUIT EXISTE
       message=true;
		} catch (Exception e) {
			e.printStackTrace();
			 message=false;
		}
		return message;

	
	}
//////Liste des articles dans le stock
	public List<Stock> read() {
	List<Stock> listearticle = new ArrayList<Stock>();	
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM stock;");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				
				Stock article1 = new Stock();
				article1.setId(rs.getInt("id"));
				article1.setReference(rs.getString("reference"));
				article1.setQuantite(rs.getInt("quantite"));
				article1.setDateApprovisionnement(rs.getDate("dateApprovisionnement"));
				listearticle.add(article1);
			}
		System.out.println(listearticle);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("erreur");
		}
	return listearticle;
	}

@Override
	public List<Stock> getStockParMC(String mc) {
		List<Stock>produits=new ArrayList<Stock>();
		try {
			PreparedStatement pro = connect.prepareStatement("SELECT * FROM stock where  reference  LIKE ?");
			pro.setString(1,"%"+mc+"%");
			ResultSet rs = pro.executeQuery();
			while (rs.next()) {
				
				Stock artic =new Stock();
				artic.setId(rs.getInt("id"));
				artic.setQuantite(rs.getInt("quantite"));
				artic.setReference(rs.getString("reference"));
				artic.setDateApprovisionnement(rs.getDate("dateApprovisionnement"));
				produits.add(artic);
				
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		return produits;
	}

	
@Override
public void delete(Stock objet) {
	try {
		PreparedStatement req= connect.prepareStatement("DELETE FROM stock WHERE reference=?" );
		req.setString(1,objet.getReference());
		req.executeUpdate();
		System.out.println("delete OK");
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("Delete KO");
	}
	
	
}
		
	}


	
	



