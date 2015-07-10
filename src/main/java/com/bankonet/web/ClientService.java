package com.bankonet.web;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class ClientService{

    /**
     * 
     * @return
     */
    public List<String> getNomClient(){
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpatp02");
    	EntityManager em=emf.createEntityManager();
    	
    	String texteQuery1 = "Select c.nom from Client as c";//le deux point signale une valeur
		Query query1 = em.createQuery(texteQuery1);
		List<String> listEmployes1 = (List<String>)query1.getResultList();

    	return listEmployes1;
    }



}
