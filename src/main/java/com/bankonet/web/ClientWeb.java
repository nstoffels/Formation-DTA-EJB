/**
 * 
 */
package com.bankonet.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = req.getParameter("nom");
		clientservice.createClient(nom);
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);
			try(BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()))){//à l'interieur des try est défini les élèments plausible, le try fera le clause pour nous. on peut mettre plusieurs instructions dans la parenthèse.
				String id = req.getParameter("id");
				try{ 
					int i =Integer.valueOf(id); //valueOf a en cache des chiffres entre -127 et +128, on gagne donc un peu en perf vis à vis de parseInt
				} catch(NumberFormatException e){ 
						System.out.println(id+" ne peut pas être convertir en entier"); 
				}
				String data=br.readLine();
				System.out.println("entré dans le try avec "+id+" "+data);
			}
		}
		
	
	
	
	
}
