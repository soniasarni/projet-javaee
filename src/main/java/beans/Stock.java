package beans;
import java.util.Date;


public class Stock {
private int id; 	
private int quantite;
private String reference;
private Date dateApprovisionnement ;

public Stock() {
	super();
	
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
public Stock(int id) {
	// TODO Auto-generated constructor stub
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
@Override
public String toString() {
	return "Stock [id=" + id + ", quantite=" + quantite + ", reference=" + reference + ", dateApprovisionnement="
			+ dateApprovisionnement + "]";
}

}
