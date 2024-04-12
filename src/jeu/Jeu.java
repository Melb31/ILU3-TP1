package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import items.Carte;
import items.JeuDeCartes;

public class Jeu {
	private Set<Joueur> ensJoueurs;
	public Sabot sabot;
	
	public Jeu() {
		ensJoueurs=new HashSet<>();
		remplirSabot(new JeuDeCartes() );
	}
	
	
	
	public void inscrire(Joueur joueur) {
		ensJoueurs.add(joueur);

	}
	
	private void remplirSabot(JeuDeCartes jeu) {
		
		List<Carte> ttLesCartes= jeu.getListeCarte();
		sabot=new Sabot(ttLesCartes.size());
		for(Iterator<Carte> it= ttLesCartes.iterator(); it.hasNext();) {
		sabot.ajouterCarte(it.next());}

	}
	
	public void distribuerCartes() {
		for( int i=0; i< 6;i++) {
			for(Iterator<Joueur> itJoueur =ensJoueurs.iterator();itJoueur.hasNext();) {
				itJoueur.next().prendre( sabot.piocher());
			}
		}
	}
	
	public void joueurTour() {
		System.out.println("\nDebut du tour");
		for(Iterator<Joueur> itJoueur =ensJoueurs.iterator();itJoueur.hasNext();){
			Joueur actJ=itJoueur.next();
			Carte pioche=sabot.piocher();
			actJ.prendre(pioche);
			System.out.println("\nJoueur "+actJ + " a pioche " + pioche);
			System.out.println("dans sa main :" + actJ.main);
			Coup c=actJ.choisirCoup(ensJoueurs);
			Carte carteC=c.getCarte();
			actJ.retirerDeLaMain(carteC);
			Joueur jCible=c.getjCible();
			
			if(jCible==null) {
				sabot.ajouterCarte(carteC);
				System.out.println("poser la carte "+ carteC+ " dans la pioche");
			}
			else {
				jCible.deposer(carteC);
				System.out.println("poser la carte "+ carteC+ "dans la zone de jeu de " +
				jCible);
			} }
		System.out.println("Fin du tour\n");
			} 
	}
		
	

