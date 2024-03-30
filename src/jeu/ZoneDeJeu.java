package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import items.Borne;
import items.Carte;

public class ZoneDeJeu {
	public List<Carte> pileLimites= new ArrayList<Carte>();
	public List<Carte> pileBatailles= new ArrayList<Carte>();
	public Collection<Borne> collecBornes= new ArrayList<Borne>();
	public NavigableSet<Carte> ensBottes= new TreeSet<Carte>();
	
}
