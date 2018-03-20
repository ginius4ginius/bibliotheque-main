package model;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import modelEjb.AdherentEjbRemote;
import modelEjb.AuteurEjbRemote;
import modelEjb.EditeurEjbRemote;

public class AppMai {
	
	private InitialContext context;
	private AdherentEjbRemote lesadherentsbean = null;
	private AuteurEjbRemote lesauteursbean = null;
	private EditeurEjbRemote lesediteursbean = null;
	
	public AppMai() {
		try {
			context = new InitialContext();
			lesadherentsbean = (AdherentEjbRemote) context.lookup("GestionBibliotheque-ejb-AdherentEjb");
			lesauteursbean = (AuteurEjbRemote) context.lookup("GestionBibliotheque-ejb-AuteurEjb");
			lesediteursbean = (EditeurEjbRemote) context.lookup("GestionBibliotheque-ejb-EditeurEjb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	///////////////----- ADHERENTS----/////////////////
	// 
	public boolean ifExist(Adherent adh) {
		return lesadherentsbean.rechercherAdherent(adh);
	}
	
	// ADD
	public boolean addAdherent(Adherent adh) {
		if (!ifExist(adh)) {
			lesadherentsbean.persistAdherent(adh);
			return true;
		}
		return false;
			
	}
	
	// REMOVE
	public boolean removeAdherent(Adherent adh) {
		if(!ifExist(adh)) {
			lesadherentsbean.removeAdherent(adh);
			return true;
		}
		return false;
	}
	
	// UPDATE 1
	public boolean updateAdherent(Adherent adh) {
		String adrRue = "";
		int adrCP = 0;
		String adrVille = "";
		
		if(!ifExist(adh)) {
			lesadherentsbean.updateAdherentAdr(adh, adrRue, adrCP, adrVille);
			return true;
		}
		return false;
	}
	
	// LIST Adhérents
	public void affichageAdherents() {
		System.out.println("");
		System.out.println("liste des adhérents : ");
		System.out.println("********************************");
		List<Adherent> listeAdh = lesadherentsbean.getAdherentFindAll();
		for(Adherent unAdh:listeAdh) {
			System.out.println(unAdh.getNum()+" "+unAdh.getNom()+" "+unAdh.getPrenom()+" "+" "+unAdh.getAdrRue()+" "+unAdh.getAdrCP()+" "+unAdh.getAdrVille());
		}
	}
	
	/////////------Auteurs------////
	public boolean ifExist(Auteur auteur) {
		return lesauteursbean.rechercherUnAuteur(auteur);
	}
	
	// ADD
	public boolean addAuteur(Auteur auteur) {
		if (!ifExist(auteur)) {
			lesauteursbean.persistAuteur(auteur);
			return true;
		}
		return false;
			
	}	
	
	// LIST
	public void affichageAuteurs() {
		System.out.println("");
		System.out.println("liste des auteurs : ");
		System.out.println("********************************");
		List<Auteur> listeAuteur = lesauteursbean.getAuteurFindAll();
		for(Auteur unAuteur:listeAuteur) {
			System.out.println(unAuteur.getNum()+" "+unAuteur.getNom()+" "+unAuteur.getPrenom()+" "+" "+unAuteur.getNationalite());
		}
	}
	
	//////////-------Editeurs---------////////
	public boolean ifExist(Editeur edit) {
		return lesediteursbean.rechercherUnEditeur(edit);
	}
	// ADD
	public boolean addEditeur(Editeur edit) {
		if (!ifExist(edit)) {
			lesediteursbean.persistEditeur(edit);
			return true;
		}
		return false;
			
	}	
	
	// LIST
	public void affichageEditeurs() {
		System.out.println("");
		System.out.println("liste des éditeurs : ");
		System.out.println("********************************");
		List<Editeur> listeEdit = lesediteursbean.getEditeurFindAll();
		for(Editeur unEdit:listeEdit) {
			System.out.println(unEdit.getNum()+" "+unEdit.getNom());
		}
	}
}
