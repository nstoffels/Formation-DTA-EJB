package com.bankonet.web;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bankonet.model.Client;

/**
 * @author ETY
 *
 */
@Stateless
public class ClientService{

	@PersistenceContext(unitName="banko") private EntityManager em;
    /**
     * 
     * @return
     */
    public List<String> getNomClient(){
    	
    	
    	
    	String texteQuery1 = "Select c.nom from Client as c";//le deux point signale une valeur
		Query query1 = em.createQuery(texteQuery1);
		List<String> listEmployes1 = (List<String>)query1.getResultList();
		
		
		
    	return listEmployes1;
    }
    
    /**
     * 
     * @param nom
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createClient(String nom){

    	Client nouveau = new Client(nom);
    	em.persist(nouveau);	
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modifierClient(int id, String nom){
    	String texteQuery1 = "Select c.nom from Client as c";//le deux point signale une valeur
		Query query1 = em.createQuery(texteQuery1);
		List<String> listEmployes1 = (List<String>)query1.getResultList();
		
		//for()
    }

}
