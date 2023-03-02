package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.IAdminDao;
import dao.IAdminImp;
import dao.IClientImpDao;
import dao.IClientImpl;
import dao.ICommandeFrDao;
import dao.ICommandeFrImp;
import dao.IConteneurDao;
import dao.IConteneurImp;
import dao.IDemLocationImp;
import dao.IDemLocationImpDao;
import dao.IDepotImpl;
import dao.IDepotImplDao;
import dao.IFournisseurImp;
import dao.IFournisseurImpDao;
import dao.SendEmail;
import entities.Admin;
import entities.Client;
import entities.CommandeFr;
import entities.Conteneur;
import entities.DemLocation;
import entities.Depot;
import entities.Fournisseur;
import java.sql.Date;
public class ControleurServlet extends HttpServlet {
private IConteneurDao metier;
private IClientImpDao metierClient;	
private IFournisseurImpDao metierFournisseur;
private IDepotImplDao metierDepot;
private IDemLocationImpDao metierDemande;
private IConteneurDao metierConteneur;
private IAdminDao metierAdmin;
private ICommandeFrDao metierDemandeFr;

ConteneurModel model = new ConteneurModel();
@Override
public void init() throws ServletException {
	metierDemandeFr = new ICommandeFrImp();
	metier =new IConteneurImp();
	metierClient= new IClientImpl();
	metierFournisseur= new IFournisseurImp();
	metierDepot= new IDepotImpl();
	metierDemande = new IDemLocationImp();
	metierConteneur = new IConteneurImp();
	metierAdmin = new IAdminImp();	
}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	if(request.getServletPath().equals("/subscribe.php")){	 
		 if(request.getParameter("register").equals("register"))
			{ 		
			    Client Cl = new Client();
				Cl.setNom(request.getParameter("first_name"));
				Cl.setPrenom(request.getParameter("last_name"));
				Cl.setEmail(request.getParameter("email"));
				Cl.setAdresse(request.getParameter("adresse"));
				Cl.setTel(request.getParameter("tel"));
				Cl.setFax(request.getParameter("fax"));
				Cl.setPassword(request.getParameter("password"));
		    	model.setCl(metierClient.save(Cl));
		    	request.setAttribute("model", model);
				request.getRequestDispatcher("Home.jsp").forward(request, response); 
				System.out.println("Here :" + request.getParameter("adresse"));
		}	 
	 }
	 if(request.getServletPath().equals("/connection.php")){
		 
		 if(request.getParameter("email").equals("dridi"))
		 {
			 if(metierAdmin.login(request.getParameter("email"), request.getParameter("password"))==true){
	        	 Admin c= metierAdmin.getAdmin(request.getParameter("email"), request.getParameter("password"));
		    	System.out.println("Hey");
	        	 model.setAdmin(c);
		    	 request.setAttribute("model", model);
		    	 request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response); 		    	 
		        }
		 }
		 else
		     if(metierClient.login1(request.getParameter("email"), request.getParameter("password"))==true){
		    	 Client c= metierClient.getClient(request.getParameter("email"), request.getParameter("password"));
		    	 System.out.println(request.getParameter("password"));
		    	 model.setCl(c);
		    	 request.setAttribute("model", model);
		    	 request.getRequestDispatcher("Home.jsp").forward(request, response); 	 
		     }
		     else  request.getRequestDispatcher("Login.jsp").forward(request, response);  
	 }
	}	
@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conteneur c = new Conteneur();
		 model.setC(c);
		 request.setAttribute("model", model);
		 if(request.getServletPath().equals("/Retour_consultation.php")){  
			 List<Conteneur> conteneurs = metier.ConteneurAll();
			 model.setConteneurs(conteneurs);
			 request.setAttribute("model", model);//Retour_consultation.php
			 request.getRequestDispatcher("consulter_louer.jsp").forward(request,response);
		 }
		 // home admin
		 if(request.getServletPath().equals("/admin_home.php")){
			 request.getRequestDispatcher("admin.jsp").forward(request, response);	 
		 }
		 // home admin 
		 //home client 
		 if(request.getServletPath().equals("/client_home.php")){
			 request.getRequestDispatcher("client.jsp").forward(request, response);	 
		 }
		 /// client home 
		 //deconnexion admin
		 if(request.getServletPath().equals("/Deconnexion.php")){
			 request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
		 }
		 // deconnexion admin 
		 // deconnexion client
		 if(request.getServletPath().equals("/client_Deconnexion.php")){
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		 //deconnexion client
		 // partie conteneur
		 // ajouter un conteneur
		 if(request.getServletPath().equals("/Ajouter.php")){
			 request.getRequestDispatcher("AjoutContenaire.jsp").forward(request, response);
		 }
		 if(request.getServletPath().equals("/insert.php")){
		 if(request.getParameter("save").equals("Save"))
			{ 		
			    request.setAttribute("model", model);
			    c.setId_depot(Integer.parseInt(request.getParameter("iddepot")));
				c.setType(request.getParameter("type"));		
				c.setLargeur(Double.parseDouble(request.getParameter("largeur")));
				c.setHauteur( Double.parseDouble(request.getParameter("hauteur")));
				c.setLongueur( Double.parseDouble(request.getParameter("longueur")));
				c.setLargeur_porte(Double.parseDouble(request.getParameter("largeur_porte")));
				c.setHauteur_porte(Double.parseDouble(request.getParameter("hauteur_porte")));
				c.setLongueur_porte( Double.parseDouble(request.getParameter("longueur_porte")));
				c.setPoids(Double.parseDouble(request.getParameter("poids")));
				c.setCapacite(Double.parseDouble(request.getParameter("capacite")));
				c.setPrix( Double.parseDouble(request.getParameter("prix")));
				metier.save(c);
				model.setC(c);
				List<Conteneur> conteneurs = metier.ConteneurAll();
				model.setConteneurs(conteneurs);
				request.setAttribute("model", model);
				request.getRequestDispatcher("consulter_admin.jsp").forward(request, response);
			}
		 }
		 if(request.getServletPath().equals("/consulter.php")){
				 List<Conteneur> conteneurs = metier.ConteneurAll();
				 model.setConteneurs(conteneurs);
				 request.setAttribute("model", model);
				 request.getRequestDispatcher("consulter_admin.jsp").forward(request, response);	
			}
		 //supprimer un conteneur
		 if(request.getServletPath().equals("/suprimer.php")){
			 metier.deleteConteneur(Integer.parseInt(request.getParameter("id")));
			 List<Conteneur> conteneurs = metier.ConteneurAll();
			 model.setConteneurs(conteneurs);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("consulter_admin.jsp").forward(request, response);
		 }
		 //editer un conteneur 
		 if(request.getServletPath().equals("/Editer.php")){
			 Conteneur c1 = metier.getConteneur(Integer.parseInt(request.getParameter("id")));
			 model.setC(c1);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("ModificationConteneur.jsp").forward(request, response); 
		 }
		 if(request.getServletPath().equals("/annuler.php")){
			 request.getRequestDispatcher("insert.jsp").forward(request, response);
		 }
	
		 if(request.getServletPath().equals("/update_conteneur.php")){
			 if(request.getParameter("modifier").equals("updateit")){
				 Conteneur d = new Conteneur();
				 d.setId(Integer.parseInt(request.getParameter("id")));
				 d.setId_depot(Integer.parseInt(request.getParameter("id_depot")));
				 d.setType(request.getParameter("type"));
				 d.setLargeur(Double.parseDouble(request.getParameter("largeur")));
				 d.setHauteur(Double.parseDouble(request.getParameter("hauteur")));
				 d.setLongueur(Double.parseDouble(request.getParameter("longueur")));
				 d.setLargeur_porte(Double.parseDouble(request.getParameter("largeur_porte")));
				 d.setHauteur_porte(Double.parseDouble(request.getParameter("hauteur_porte")));
				 d.setLongueur_porte(Double.parseDouble(request.getParameter("longueur_porte")));
                 d.setPoids(Double.parseDouble(request.getParameter("Poids")));
                 d.setCapacite(Double.parseDouble(request.getParameter("Capacite")));
                 d.setPrix(Double.parseDouble(request.getParameter("Prix")));
                 System.out.println(d.toString());
				 model.setC(metier.update(d));
				 List<Conteneur> conteneurs = metier.ConteneurAll();
				 model.setConteneurs(conteneurs);
				 request.setAttribute("model", model);
				 request.getRequestDispatcher("consulter_admin.jsp").forward(request, response); 
			 }
			 else {
				if(request.getParameter("Annuler_conteneur").equals("stornieren")){
					 System.out.println(request.getParameter("annuler"));
					 List<Conteneur> conteneurs = metier.ConteneurAll();
					 model.setConteneurs(conteneurs);
					 request.setAttribute("model", model);
					 request.getRequestDispatcher("consulter_admin.jsp").forward(request, response);	
			 }
			 }
		 }		 		 
		 // fin admin conteneur
		 if(request.getServletPath().equals("/consulter_list.php")){
			 List<Conteneur> conteneurs = metier.ConteneurAll();
			 model.setConteneurs(conteneurs);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("consulter_list.jsp").forward(request, response); 
		 }
		 if(request.getServletPath().equals("/consulter_louer.php")){
			 List<Conteneur> conteneurs = metier.ConteneurAll();
			 model.setConteneurs(conteneurs);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("CreationDemande.jsp").forward(request, response);
		 }
		 if(request.getServletPath().equals("/louer.php")){
			 Conteneur cn= metier.getConteneur(Integer.parseInt(request.getParameter("id")));
			  model.setC(cn);
			  request.setAttribute("model", model);
			  request.getRequestDispatcher("LouerContenaire.jsp").forward(request, response);	 
		    }
		    
		 
		 //fin partie client 
		 
		 if(request.getServletPath().equals("/insert_fr.php")){
			 if(request.getParameter("save").equals("save")){
				 Fournisseur fr = new  Fournisseur();
				 fr.setNom(request.getParameter("nom"));
				 fr.setPrenom(request.getParameter("prenom"));
				 fr.setAdresse(request.getParameter("adresse"));
				 fr.setEmail(request.getParameter("email"));
				 fr.setTel(request.getParameter("tel"));
				 fr.setFax(request.getParameter("fax"));
				 metierFournisseur.save(fr);
				 request.getRequestDispatcher("admin_insert_fr.jsp").forward(request, response);	 
			 }	 
		 }
		 if(request.getServletPath().equals("/suprimer_four.php")){
			 metierFournisseur.deleteFournisseur(Integer.parseInt(request.getParameter("id")));
			 List<Fournisseur> fournisseur=metierFournisseur.FournisseurAll(); 
			 model.setFournisseurs(fournisseur);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_fr_list.jsp").forward(request, response); 
		 }
		 if(request.getServletPath().equals("/edit_four.php")){
			 Fournisseur fr = metierFournisseur.getFournisseur(Integer.parseInt(request.getParameter("id")));
			 model.setFr(fr);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_edit_fr.jsp").forward(request, response); 
		 }
		 if(request.getServletPath().equals("/update_fr.php")){
			 if(request.getParameter("modifier").equals("modifier")){
				 Fournisseur fr = new Fournisseur();
				 fr.setId_fournisseur(Integer.parseInt(request.getParameter("id")));
				 fr.setNom(request.getParameter("nom"));
				 fr.setPrenom(request.getParameter("prenom"));
				 fr.setEmail(request.getParameter("email"));
				 fr.setAdresse(request.getParameter("adresse"));
				 fr.setTel(request.getParameter("tel"));
				 fr.setFax(request.getParameter("fax"));
				 metierFournisseur.update(fr);
				 System.out.println("fr=="+fr.toString());
				 List<Fournisseur> fournisseurs = metierFournisseur.FournisseurAll();
				 model.setFournisseurs(fournisseurs); 
				 request.setAttribute("model", model);
				 request.getRequestDispatcher("admin_fr_list.jsp").forward(request, response);
			 }			 
		 }
		 if(request.getServletPath().equals("/envoyer_demande.php")){
			 Fournisseur fournisseur = metierFournisseur.getFournisseur(Integer.parseInt(request.getParameter("id")));
			 model.setFr(fournisseur);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_demandeFr.jsp").forward(request, response);
		 }
		 if(request.getServletPath().equals("/envoyer_demande_fr.php")){
			 if(request.getParameter("envoyer").equals("envoyer")){
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				SendEmail c5 = new SendEmail(request.getParameter("emailClient"),"Bachlor Company","Typ :"+request.getParameter("typeConteneur")+"\n"+
			                                                                                        "Menge :"+request.getParameter("quantite")+"\n"+
						                                                                             "Adresse :"+request.getParameter("adresse")+"\n"+
			                                                                                        "Postleitzahl:"+request.getParameter("codePostal")+"\n"+
						                                                                             "Stadt:"+request.getParameter("ville"));
				CommandeFr d = new CommandeFr(request.getParameter("typeConteneur"),Integer.parseInt(request.getParameter("quantite"))
						,request.getParameter("adresse"),request.getParameter("codePostal"),request.getParameter("ville"));
				d.setFournisseur(metierFournisseur.getFournisseur(Integer.parseInt(request.getParameter("idFournisseur"))));
			    metierDemandeFr.save(d);
				request.getRequestDispatcher("client_validation.jsp").forward(request, response);
			 }
		 }
         
//////////////////////////////////////////////////////////////////////////////////////////////	 
		 //debut de la partie de gestion du depot
		 // consulter les depots
		 if(request.getServletPath().equals("/consulter_depot.php")){
			 List<Depot> listDepots =metierDepot.DepotAll();
			 model.setDepots(listDepots);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_depot_liste.jsp").forward(request, response);
	     }
		 // Ajout de debot
		 if(request.getServletPath().equals("/depot_chemin.php")){
			 request.getRequestDispatcher("AjoutDepot.jsp").forward(request, response);
		 } 
		 if(request.getServletPath().equals("/insert_depot.php")){
			 if(request.getParameter("save").equals("save")){
				 Depot d = new Depot();
				 d.setNb_place(Integer.parseInt(request.getParameter("nbPlace")));
				 d.setAdresse(request.getParameter("adresse"));
				 d.setVille(request.getParameter("ville"));
				 d.setCode_postal(request.getParameter("codePostal"));
				 model.setDep(metierDepot.save(d));
				 List<Depot> depots = metierDepot.DepotAll();
			     model.setDepots(depots);
				request.setAttribute("model", model);
				 request.getRequestDispatcher("admin_depot_liste.jsp").forward(request, response);	 
			 }	 
		 }
		 //Editer depot
		 if(request.getServletPath().equals("/update_depot.php")){
			 if(request.getParameter("modifier").equals("modifierDepot")){
				 Depot d = new Depot();
				 d.setId_depot(Integer.parseInt(request.getParameter("id")));
				 d.setNb_place(Integer.parseInt(request.getParameter("nbrPlace")));
				 d.setAdresse(request.getParameter("adresse"));
				 d.setVille(request.getParameter("ville"));
				 d.setCode_postal(request.getParameter("codePostal"));
				 metierDepot.update(d);
				 List<Depot> listDepots = metierDepot.DepotAll();
				 model.setDepots(listDepots);
				 request.setAttribute("model", model);
				 request.getRequestDispatcher("admin_depot_liste.jsp").forward(request, response); 
			 } 
		 }
		 if(request.getServletPath().equals("/update_depot.php")){
			 if(request.getParameter("annuler").equals("Stornieren")){
				 List<Depot> listDepots =metierDepot.DepotAll();
				 model.setDepots(listDepots);
				 request.setAttribute("model", model);
				 request.getRequestDispatcher("admin_depot_liste.jsp").forward(request, response);
			 }
		 }
		 if(request.getServletPath().equals("/edit_depot.php")){
			 Depot d = metierDepot.getDepot(Integer.parseInt(request.getParameter("id")));
			 model.setDep(d);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("ModfificationDepot.jsp").forward(request, response); 
		 }
		 // Supprimer depot 
		 if(request.getServletPath().equals("/suprimer_depot.php")){
			 metierDepot.deleteDepot(Integer.parseInt(request.getParameter("id")));
			 List<Depot> listDepots =  metierDepot.DepotAll();
	         model.setDepots(listDepots);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_depot_liste.jsp").forward(request, response);	 
		 }
		 // fin de la partie de gestion du depot
/////////////////////////////////////////////////////////////////////////////////////////////		 
		 // debut de la partie de gestion du client 
		 if(request.getServletPath().equals("/consulter_client.php")){
			 List<Client> clients = metierClient.ClientAll();
			 model.setClients(clients);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("consulter_cl.jsp").forward(request, response); 
		 }
		 if(request.getServletPath().equals("/supprimer.php")){
			 metierClient.deleteClient(Integer.parseInt(request.getParameter("id")));
			 List <Client> clients = metierClient.ClientAll();
			 model.setClients(clients);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("consulter_cl.jsp").forward(request, response);
         }
		 if(request.getServletPath().equals("/Editer1.php")){
			 Client p = new Client(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("adresse")
					 ,request.getParameter("tel"),request.getParameter("fax"),request.getParameter("password"));
			 p.setId(Integer.parseInt(request.getParameter("id")));
			 model.setCl(p);
			 request.getRequestDispatcher("ModifierClient.jsp").forward(request, response);
		 }
		 if(request.getServletPath().equals("/update_client.php")){
			    Client p = new Client();
			    p.setId(Integer.parseInt(request.getParameter("id")));
			    p.setNom(request.getParameter("nom")); 
				p.setPrenom(request.getParameter("prenom"));
				p.setAdresse( request.getParameter("adresse"));
				p.setEmail( request.getParameter("email"));
				p.setTel(request.getParameter("tel"));
				p.setFax(request.getParameter("fax"));
				p.setPassword(request.getParameter("password"));
			    metierClient.update(p);
				model.setCl(p);				
				model.setClients(metierClient.ClientAll());
				request.setAttribute("model", model);				
				request.getRequestDispatcher("consulter_cl.jsp").forward(request, response);
		 } 
		 // Fin de la partie de la gestion de client 	 
/////////////////////////////////////////////////////////////////////////////////////////////			
		 //demande de location partie client
		if(request.getServletPath().equals("/envoyer.php")){
			 if(request.getParameter("envoyer").equals("Senden")){
				 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				 try {
					 DemLocation d = new DemLocation(new java.sql.Date(Calendar.getInstance().getTime().getTime()),
								new java.sql.Date(format.parse(request.getParameter("dateDebut")).getTime()),
								new java.sql.Date(format.parse(request.getParameter("dateFin")).getTime()),
								Integer.parseInt(request.getParameter("quantite")), request.getParameter("adresse"),
								request.getParameter("codePostal"), request.getParameter("ville"));
					 d.setClient(metierClient.getClient(Integer.parseInt(request.getParameter("idClient"))));
					 d.setConteneur(metierConteneur.getConteneur(Integer.parseInt(request.getParameter("idConteneur"))));
					 metierDemande.save(d);
					 
					 request.getRequestDispatcher("SuccessPage.jsp").forward(request, response);		 
				} catch (ParseException e) {
					e.printStackTrace();
				}
			 }
		 }
		//////// partie admin demande de location 
		 if(request.getServletPath().equals("/consulter_demande.php")){
			 List<DemLocation> demandes = metierDemande.DemLocationAll();
			 model.setDemandes(demandes);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_consulter_demande.jsp").forward(request, response);	
		}
		 if(request.getServletPath().equals("/suprimer_dem_location.php")){
			 metierDemande.deleteDemLocation(Integer.parseInt(request.getParameter("id")));
			 List <DemLocation> demandes = metierDemande.DemLocationAll();
			 model.setDemandes(demandes);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("admin_consulter_demande.jsp").forward(request, response);
         }
		 if(request.getServletPath().equals("/edit_dem_Location.php")){
			 DemLocation s = metierDemande.getDemLocation(Integer.parseInt(request.getParameter("id")));
	     	 s.setId_demande(Integer.parseInt(request.getParameter("id")));
			 model.setDemande(s);
			 request.setAttribute("model", model);
			 request.getRequestDispatcher("ModificationDemande.jsp").forward(request, response);
		 }
		 if(request.getServletPath().equals("/update_dem_location.php")){
			 if(request.getParameter("modifier").equals("modifier")){
				 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				 DemLocation dm = new DemLocation();		
				 dm.setId_demande(Integer.parseInt(request.getParameter("id")));
				 dm.setId_client(Integer.parseInt(request.getParameter("id_client_id")));
				 dm.setId_conteneur(Integer.parseInt(request.getParameter("Id_conteneur")));				
				 try {
					dm.setDate_demande_loc(new java.sql.Date(format.parse(request.getParameter("date_demande")).getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					dm.setDate_debut_loc(new java.sql.Date(format.parse(request.getParameter("date_debut")).getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					dm.setDate_fin_loc(new java.sql.Date(format.parse(request.getParameter("date_fin")).getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 dm.setQuantite(Integer.parseInt(request.getParameter("lott")));
				 dm.setAdresse_livraison(request.getParameter("adresse"));
				 dm.setCode_postal(request.getParameter("codepostal"));
				 dm.setVille(request.getParameter("ville"));
				 metierDemande.update(dm);
				 List<DemLocation> demandes = metierDemande.DemLocationAll();
				 model.setDemandes(demandes);
				 request.setAttribute("model", model);
				 request.getRequestDispatcher("admin_consulter_demande.jsp").forward(request, response); 
			 } 
		 }

     }
}