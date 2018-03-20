package vue;

import java.time.LocalDate;
import java.util.Date;

import org.apache.catalina.logger.SystemOutLogger;

import model.Adherent;
import model.AppMai;
import model.AppVincent;
import model.Auteur;
import model.Editeur;
import model.Genre;
import model.Livre;
import model.Pret;

public class TestMain {

	public static void main(String[] args) {
		
	AppVincent managerVincent = new AppVincent();
	AppMai managerMai = new AppMai();
	LocalDate datePret = LocalDate.now();
	Date date = new Date(24 * 3600 * 1000 * datePret.toEpochDay());
	
	//instanciation des éléments:
	
	Auteur aut1 = new Auteur("EDITEUR", "editeur", "Français", 0);
	Editeur ed1 = new Editeur("Fahasa","CP","adr","ville"); 
	Genre g1 = new Genre("Ecchi");
	Livre l1 = new Livre("2-07-", "Java pour les nuls", "Français", 80f,2018, aut1.getNum(),g1.getNum(),ed1.getNum());
	Adherent a1 = new Adherent("Derieu","Vincent", "0631618521","ginius4@hotmail.com",93470, "3 rue des grands champs", "Coubron");
	
	Pret p1 = new Pret(l1,a1,date);
	
	System.out.println("");
	managerVincent.addGenre(g1);
	managerVincent.affichageDesGenres();
	
	System.out.println("Insertions");
	System.out.println("");
	System.out.println(managerMai.addAdherent(a1));
	System.out.println(managerMai.addAuteur(aut1));
	System.out.println(managerMai.addEditeur(ed1));
	
	System.out.println("liste Adh");
	managerMai.affichageAdherents();
	
	System.out.println("liste Auteurs");
	managerMai.affichageAuteurs();
	System.out.println("liste Editeurs");
	managerMai.affichageEditeurs();
	
	
	
	System.out.println("");
	managerVincent.addLivre(l1);
	managerVincent.affichageLivres();
	
	System.out.println("");
	System.out.println("affichage des livres par genre :");
	managerVincent.affichageLivresParGenre(g1);
	
	managerVincent.addPret(p1);
	System.out.println("");
	System.out.println("affichage des prets de l' adherent :"+a1.getNom());
	managerVincent.affichagePretAdherent(a1);

	System.out.println("");
	System.out.println("affichage des prets en cour :");
	managerVincent.affichagePretEnCour();
	
	System.out.println("");
	System.out.println("affichage des prets non rendu :");
	managerVincent.AffichagePretNonRendu();
	/*
	System.out.println("");
	System.out.println("affichage des prets en cour après remise du pret:");
	managerVincent.removePret(p1);
	managerVincent.affichagePretEnCour();

	System.out.println("");
	System.out.println("affichage des livres après remise après supression du livre :");
	managerVincent.removeLivre(l1);
	managerVincent.affichageLivres();
	
	System.out.println("");
	System.out.println("affichage des genres après supression du genre :");
	managerVincent.removeGenre(g1);
	managerVincent.affichageDesGenres();*/
	

	}

}
