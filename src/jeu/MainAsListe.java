package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import items.Carte;

public class MainAsListe implements IMain{
	private List<Carte> liste;
	
	public MainAsListe() {
		 liste=new ArrayList<>();
	}
	
	
	public Iterator<Carte> iterator() {
		return liste.listIterator();
	}


	public void prendre(Carte object) {
		liste.add(object);
		
	}

	public void jouer(Carte carte) {
		assert (liste.contains(carte));
		liste.remove(carte);

		
	}
	
	@Override
	public String toString() {
		return liste.toString();
	}
	


}
