package vue;

import java.time.LocalDate;
import java.util.Date;

import model.AppVincent;
import model.Genre;
import model.Livre;
import model.Pret;

public class TestMain {

	public static void main(String[] args) {
		
	AppVincent managerVincent = new AppVincent();
	LocalDate datePret = LocalDate.now();
	Date date = new Date(24 * 3600 * 1000 * datePret.toEpochDay());
	
	LocalDate dateRetour = LocalDate.now().plusWeeks(3);
	Date date2 = new Date(24 * 3600 * 1000 * dateRetour.toEpochDay());
	
	//instanciation des éléments:
	
	Livre l1 = new Livre("2-07-038692-6", "Java pour les nuls", "Français", 80f, (short)2018);
	Genre g1 = new Genre("Ecchi");
	Pret p1 = new Pret(date, date2, null);

	}

}
