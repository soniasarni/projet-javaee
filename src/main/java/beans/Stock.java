package beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Stock {
private int id; 	
private int quantite;
private String reference;
private Date dateApprovisionnement ;
private List<Stock>produits=new ArrayList<>();



public List<Stock> getProduits() {
	return produits;
}
public void setProduits(List<Stock> produits) {
	this.produits = produits;
}
public Stock() {
	super();
	// TODO Auto-generated constructor stub
}
public Stock(int quantite, String reference, Date dateApprovisionnement) {
	super();
	
	this.quantite = quantite;
	this.reference = reference;
	this.dateApprovisionnement = dateApprovisionnement;
}
public Stock(int quantite, String reference) {
	super();
	this.quantite = quantite;
	this.reference = reference;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public Date getDateApprovisionnement() {
	return dateApprovisionnement;
}
public void setDateApprovisionnement(Date dateApprovisionnement) {
	this.dateApprovisionnement = dateApprovisionnement;
}

}
