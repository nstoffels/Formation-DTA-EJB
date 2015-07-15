package com.bankonet.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;

  
  private String nom;
  /**
   * Constructeur vide
   */
  public Client() {
  }
  
  
	
  public Client(int iD) {
	super();
	ID = iD;
}



public Client(String nom) {
	super();
	this.nom = nom;
}



public void getId(Integer ID) {
    this.ID=ID;
  }

/**
 * @return the iD
 */
public int getID() {
	return ID;
}

/**
 * @param iD the iD to set
 */
public void setID(int iD) {
	ID = iD;
}

/**
 * @return the nom
 */
public String getNom() {
	return nom;
}

/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}
	
  

}
