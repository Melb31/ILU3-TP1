package testsFonctionnels;

import jeu.Jeu;
import jeu.Joueur;

public class TestJeu {
 public static void main(String[] args) {
	Jeu jeu= new Jeu();
	Joueur j1=new Joueur("Emily");
	Joueur j2=new Joueur("Martin");
	jeu.inscrire(j1);
	jeu.inscrire(j2);
	System.out.println("Jouer inscrit");
	System.out.println(jeu.sabot.nbCartes);
	jeu.distribuerCartes();
	System.out.println(jeu.sabot.nbCartes);
	j1.afficherMain();
	j2.afficherMain();
	jeu.joueurTour();
	jeu.joueurTour();
	
}
}
