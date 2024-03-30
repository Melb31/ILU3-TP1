package jeu;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import items.Carte;

public class MainAsListe implements IMain{
	private List<Carte> liste;
	public Iterator<Carte> iterator() {
		return liste.listIterator();
	}


	public void prendre(Carte carte) {
		liste.add(carte);
		
	}

	public void jouer(Carte carte) {
		assert ( ! liste.contains(carte));
		liste.remove(carte);

		
	}

}
