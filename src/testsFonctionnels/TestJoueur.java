package testsFonctionnels;

import items.Borne;
import jeu.Joueur;

public class TestJoueur {
	public static void main(String[] args) {
		Joueur j= new Joueur("melissa");
		j.deposer(new Borne(4,40));
		j.deposer(new Borne(4,120));
		j.deposer(new Borne(4,30));
		j.deposer(new Borne(4,10));
		j.deposer(new Borne(4,10));
		System.out.println("Nombre de km :"+ j.donnerKmParcourus());
	}
}
