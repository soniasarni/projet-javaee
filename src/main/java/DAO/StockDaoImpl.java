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
				e.printStackTrace();
				System.out.println("unable to save the the product");
			}
		}
	//recuperer la quantite d'une reference si elle existe
	public int recupQte(Stock objet) {
		int X=0;
	
		if(objet.getReference()!=null) {
			
			 try {
				PreparedStatement req2= connect.prepareStatement("SELECT quantite FROM stock WHERE reference=?");
				req2.setString(1,objet.getReference());
				System.out.println(req2);
				ResultSet rs2 = req2.executeQuery();
				while(rs2.next()) {
					Stock article2 = new Stock();
					article2.setQuantite(rs2.getInt("quantite"));
				    X =rs2.getInt("quantite");
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
		System.out.println(recupQte(objet));
		boolean message= false; 
		if(recupQte(objet) > 0) {
			//Si on a une quantité, je fais une mise à jour (Update)
			try {
			  PreparedStatement req = connect.prepareStatement(
						"UPDATE stock SET quantite =?, dateApprovisionnement=now() WHERE reference=?");
						//"Update stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
				req.setInt(1, objet.getQuantite()+recupQte(objet));
				req.setString(2, objet.getReference());
				
				System.out.println(req);
				req.executeUpdate();
				System.out.println(objet.getReference()+ "Insertion OK");
				
			//SI LE PRODUIT EXISTE
	       message=true;
			} catch (Exception e) {
				e.printStackTrace();
				 message=false;
			}
		}else {
			try {
				//Si la quantite ou la reference n'existe pas je fais un insert en BDD
			PreparedStatement req = connect.prepareStatement(
					"INSERT INTO stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
			req.setInt(1, objet.getQuantite());
			req.setString(2, objet.getReference());
			req.executeUpdate();
		//SI LE PRODUIT EXISTE
       message=true;
		} catch (Exception e) {
			e.printStackTrace();
			 message=false;
		}
		return message;

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
			System.out.println(pro);
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
		PreparedStatement req= connect.prepareStatement("DELETE * FROM stock WHERE reference=?" );
		req.setInt(1,objet.getQuantite());
		req.setString(2,objet.getReference());
		req.executeUpdate();
		System.out.println("delete OK");
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("Delete KO");
		}
	}
   
    @Override
    public boolean remove(Stock objet) {
	recupQte(objet);
	System.out.println(recupQte(objet));
	boolean message= false; 
	if(recupQte(objet) > objet.getQuantite()) {
		//Si on a une quantité, je fais une mise à jour (Update)
		try {
			System.out.println("DANS LE UPDATE");
		  
			PreparedStatement req = connect.prepareStatement(
					"UPDATE stock SET quantite =?, dateApprovisionnement=now() WHERE reference=?");
					//"Update stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
			req.setInt(1,recupQte(objet) - objet.getQuantite());
			req.setString(2, objet.getReference());
			
			System.out.println(req);
			req.executeUpdate();
			System.out.println(objet.getReference()+ "Insertion OK");
			
		}
		
	 catch (Exception e) {
		e.printStackTrace();
		 message=false;
	} 
	}
	return message;
	
	}

    }
	
	



