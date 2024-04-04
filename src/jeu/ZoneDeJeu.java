package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import items.Bataille;
import items.Borne;
import items.Botte;
import items.Carte;
import items.Limite;

public class ZoneDeJeu {
	public List<Limite> pileLimites= new ArrayList<Limite>();
	public List<Bataille> pileBatailles= new ArrayList<>();
	public Collection<Borne> collecBornes= new ArrayList<Borne>();
	public NavigableSet<Botte> ensBottes= new TreeSet<>();
	// jsp quoi mettre type
}
