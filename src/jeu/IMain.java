package jeu;

import java.util.Iterator;
import items.Carte;

public interface IMain {
	public Iterator<Carte> iterator();
	public void prendre(Carte carte);
	public void jouer(Carte carte);
}
