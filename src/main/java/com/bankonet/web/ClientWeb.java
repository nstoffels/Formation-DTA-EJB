/**
 * 
 */
package com.bankonet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ETY
 *
 */

@WebServlet ("/clients")
public class ClientWeb extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ClientService clientservice = new ClientService();
	//est remplacé par :
	@EJB public ClientService clientservice;
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter w = resp.getWriter();
		w.print("");
		//super.doGet(req, resp); //par défaut non supporté si non surchargé, ça appel l'implementation par défaut qui affiche l'erreur
		
		int i = 0;
		List<String> list = clientservice.getNomClient();
		for(String nom : list){
			++i;
			w.println("le client n° : "+i+" est "+nom);
		}
		}
	
}
