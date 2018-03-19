package model;

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
	public boolean ifNotExist(Adherent adh) {
		return lesadherentsbean.rechercherAdherent(adh);
	}
	
	// ADD
	public boolean addAdherent(Adherent adh) {
		if (ifNotExist(adh)) {
			lesadherentsbean.persistAdherent(adh);
			return true;
		}
		return false;
			
	}
	
	// REMOVE
	public boolean removeAdherent(Adherent adh) {
		if(ifNotExist(adh)) {
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
		
		if(ifNotExist(adh)) {
			lesadherentsbean.updateAdherentAdr(adh, adrRue, adrCP, adrVille);
			return true;
		}
		return false;
	}
	
	// LIST Adhérents
	
	
}
