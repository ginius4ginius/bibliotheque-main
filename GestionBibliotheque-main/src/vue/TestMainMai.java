package vue;

import model.Adherent;
import model.AppMai;

public class TestMainMai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppMai controleurMai = new AppMai();
		
		
		
		controleurMai.affichageAdherents();
		Adherent adh1 = new Adherent("Titi","toto","0123456789","toto@gmail.com",92000,"rue Anciennes Mairies","Nanterre");
		System.out.println(controleurMai.ifExist(adh1));
		System.out.println(controleurMai.addAdherent(adh1));
		
		
		
		
		
	}

}
