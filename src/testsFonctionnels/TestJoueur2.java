package testsFonctionnels;


import items.*;
import items.Probleme.Type;
import jeu.Joueur;

public class TestJoueur2 {
	
	private static int Test_1() {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,60));
		j.deposer(new Borne(4,80));
		j.deposer(new Attaque(4,Type.ACCIDENT));
		j.deposer(new Botte(4,Type.ACCIDENT));
		
		return j.zoneDeJeu.donnerLimitationVitesse();
		
		
		
	}
	private static int Test_2() {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,60));
		j.deposer(new DebutLimite(50));
		return j.zoneDeJeu.donnerLimitationVitesse();
	
	}
	
	private static int Test_3() {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,60));
		j.deposer(new DebutLimite(1));
		j.deposer(new FinLimite(1));
		return j.zoneDeJeu.donnerLimitationVitesse();
	}
	
	private static int Test_4() {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,60));
		j.deposer(new Botte(1,Type.FEU));
		j.deposer(new DebutLimite(1));
		return j.zoneDeJeu.donnerLimitationVitesse();

	}
	
	
	public static void main(String[] args) {
		System.out.println("test getLimite");
		assert (Test_1()==200 );
		assert (Test_2()==50 );
		assert (Test_3()==200 );
		assert (Test_3()==200 );
		System.out.println("reussis");
	}


}
