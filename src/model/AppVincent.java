package model;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import modelEjb.GenreEjbRemote;
import modelEjb.LivreEjbRemote;
import modelEjb.PretEjbRemote;

public class AppVincent {

	private InitialContext context;
	private LivreEjbRemote leslivresbean = null;
	private GenreEjbRemote lesgenresbean = null;
	private PretEjbRemote lespretsbean = null;

	public AppVincent() {
		try {
			context = new InitialContext();
			leslivresbean = (LivreEjbRemote) context.lookup("GestionBibliotheque-ejb-LivreEjb");
			lesgenresbean = (GenreEjbRemote) context.lookup("GestionBibliotheque-ejb-GenreEjb");
			lespretsbean = (PretEjbRemote) context.lookup("GestionBibliotheque-ejb-PretEjb");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean ifExist(Livre l) {
		return leslivresbean.rechercheUnLivre(l);
	}

	public boolean ifExist(Genre genre) {
		return lesgenresbean.rechercheUnGenre(genre);
	}

	public boolean ifExist(Pret p) {
		return lespretsbean.rechercheUnPret(p);
	}
	
	///////////////////////// FONCTIONS ADD///////////////////////////

	public boolean addLivre(Livre livre) {
		boolean result = false;
		if (!ifExist(livre)) {
			Livre livr = leslivresbean.persistLivre(livre);
			result = true;
		}

		return result;
	}

	public Genre addGenre(Genre g) {
		//boolean result = false;
		Genre unGenre = null;
		if (!ifExist(g)) {
			unGenre = lesgenresbean.persistGenre(g);
			
			//result = true;
		}
		return unGenre;
	}

	public boolean addPret(Pret p) {
		boolean result = false;
		if (!ifExist(p)) {
			Pret pret = lespretsbean.persistPret(p);
			result = true;
		}

		return result;
	}

	///////////////////////// FONCTIONS REMOVE///////////////////////////

	public boolean removeLivre(Livre l) {
		if (ifExist(l)) {
			leslivresbean.removeLivre(l);
			return true;
		}

		return false;
	}

	public boolean removeGenre(Genre g) {
		if (ifExist(g)) {
			lesgenresbean.removeGenre(g);
			return true;
		}

		return false;
	}

	public boolean removePret(Pret p) {
		if (ifExist(p)) {
			lespretsbean.removePret(p);
			return true;
		}

		return false;
	}

	////////////////////////// LISTES//////////////////////////////////

	public void affichageLivres() {
		System.out.println("");
		System.out.println("liste des livres: ");
		System.out.println("********************************");
		List<Livre> liste = leslivresbean.getLivreFindAll();
		for (Livre unlivre : liste) {
			String param = "ISBN : " + unlivre.getIsbn() + " / TITRE : " + unlivre.getTitre() + " / PRIX : "
					+ unlivre.getPrix();
			System.out.println(param);
		}
	}

	public void affichageDesGenres() {
		System.out.println("");
		System.out.println("liste des genres: ");
		System.out.println("********************************");
		List<Genre> liste = lesgenresbean.getGenreFindAll();
		for (Genre unGenre : liste) {
			String param = "LIBELLE : " + unGenre.getLibelle();
			System.out.println(param);
		}
	}

	public void affichageLivresParGenre(Genre g) {
		System.out.println("");
		System.out.println("liste des livre pour genre : " + g.getLibelle());
		System.out.println("********************************");
		List<Livre> liste = lesgenresbean.getAllLivreByGenre(g);
		for (Livre unLivre : liste) {
			String param = "ISBN : " + unLivre.getIsbn() + " / TITRE : " + unLivre.getTitre() + " / PRIX : "
					+ unLivre.getPrix();
			System.out.println(param);

		}
	}

	public void affichagePretAdherent(Adherent a) {
		System.out.println("");
		System.out.println("liste des prets de l'adh�rent : " + a.getNom());
		System.out.println("********************************");
		List<Pret> liste = lespretsbean.recherchePretParAdherent(a);
		for (Pret unPret : liste) {
			String param = "LIVRE : " + unPret.getLivre().getTitre() + " / DATE_RETOUR : "
					+ unPret.getDateRetourPrevue();
			System.out.println(param);

		}
	}

	public void affichagePretEnCour() {
		System.out.println("");
		System.out.println("liste des prets en cour : ");
		System.out.println("********************************");
		List<Pret> liste = lespretsbean.getPretFindAll();
		for (Pret unPret : liste) {
			String param = "LIVRE : " + unPret.getLivre().getTitre() + " / DATE_RETOUR : "
					+ unPret.getDateRetourPrevue();
			System.out.println(param);

		}
	}

	public void AffichagePretNonRendu() {
		System.out.println("");
		System.out.println("liste des prets non rendu : ");
		System.out.println("********************************");
		List<Pret> liste = lespretsbean.listePretNomrendu();
		for (Pret unPret : liste) {
			String param = "LIVRE : " + unPret.getLivre().getTitre() + " / DATE_RETOUR : "
					+ unPret.getDateRetourPrevue();
			System.out.println(param);
		}
	}
	
	public Genre rechercheGenreParId(Genre genre) {
		Genre leGenre = lesgenresbean.rechercheUnGenreId(genre);
				
				return leGenre;
	}

}
