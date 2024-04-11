package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import items.Carte;
import items.JeuDeCartes;

public class Jeu {
	private Set<Joueur> ensJoueurs;
	private Sabot sabot;
	
	public Jeu(JeuDeCartes jeu) {
		ensJoueurs=new HashSet<>();
		remplirSabot(jeu);
	}
	
	
	
	private void inscrire(Joueur joueur) {
		ensJoueurs.add(joueur);

	}
	
	private void remplirSabot(JeuDeCartes jeu) {
		
		List<Carte> ttLesCartes= jeu.getListeCarte();
		sabot=new Sabot(ttLesCartes.size());
		for(Iterator<Carte> it= ttLesCartes.iterator(); it.hasNext();) {
		sabot.ajouterCarte(it.next());}

	}
	
	private void distribuerCartes() {
		for( int i=0; i< 6;i++) {
			for(Iterator<Carte> it =sabot.iterator();it.hasNext();) {
				
			}
		}
	}
}
