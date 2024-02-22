package testsFonctionnels;

import java.util.Iterator;

import items.Attaque;
import items.Botte;
import items.Carte;
import items.Parade;
import items.Probleme.Type;
import jeu.Sabot;

public class test {
	
	
	public static void main(String[] args) {
		Sabot sabot= new Sabot(110);
		sabot.ajouterFamilleCarte(new Attaque(3,Type.ACCIDENT));
		sabot.ajouterFamilleCarte(new Parade(Type.ACCIDENT,1));
		sabot.ajouterFamilleCarte(new Botte(1,Type.ACCIDENT));

		for(Iterator<Carte> iter=sabot.iterator();iter.hasNext();) {
			
			sabot.piocher();
		
	
			
		}

	}
}
