package vue;

import java.time.LocalDate;
import java.util.Date;

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
	Editeur ed1 = 
	Genre g1 = new Genre("Ecchi");
	Livre l1 = new Livre("2-07-038692-6", "Java pour les nuls", "Français", 80f, (short)2018, aut1,g2,ed1);
	Adherent a1 = new Adherent("Derieu","Vincent", "0631618521","ginius4@hotmail.com",93470, "3 rue des grands champs", "Coubron");
	
	Pret p1 = new Pret(l1,a1,date);
	
	System.out.println("");
	managerVincent.addGenre(g1);
	managerVincent.affichageDesGenres();
	
	System.out.println("");
	managerMai.addAdherent(a1);
	managerMai.
	
	System.out.println("");
	managerVincent.addLivre(l1);
	managerVincent.affichageLivres();
	
	System.out.println("");
	System.out.println("affichage des livres par genre :");
	managerVincent.affichageLivresParGenre(g2);
/*	
	System.out.println("");
	System.out.println("affichage des prets de l' adherent :"+a1.getNom());
	managerVincent.addPret(p1, l1, a1);
	managerVincent.affichagePretAdherent(a1);
*/
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
*/	
	System.out.println("");
	System.out.println("affichage des livres après remise après supression du livre :");
	managerVincent.removeLivre(l1);
	managerVincent.affichageLivres();
	
	System.out.println("");
	System.out.println("affichage des genres après supression du genre :");
	managerVincent.removeGenre(g2);
	managerVincent.affichageDesGenres();
	

	}

}
