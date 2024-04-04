package testsFonctionnels;


import items.*;
import items.Probleme.Type;
import jeu.Joueur;

public class TestJoueur2 {
	
	private static void Test_1() {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,60));
		j.deposer(new Borne(4,80));
		j.deposer(new Botte(4,Type.ACCIDENT));
		int limit=j.donnerLimitationVitesse();
		System.out.println(limit);
		
		
		
	}
	private static void Test_2() {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,60));
		j.deposer(new DebutLimite(50));
		int limit=j.donnerLimitationVitesse();
		System.out.println(limit);
		
		
		
	}
	public static void main(String[] args) {
		Test_1();
		//Test_2();

	}


}
