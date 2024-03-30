package jeu;

import java.util.List;
import java.util.ListIterator;

import items.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	MainAsListe main;
	public Joueur(String nom) {
		this.nom=nom;
		zoneDeJeu=new ZoneDeJeu();
		main=new MainAsListe();
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		Joueur j2=(Joueur) obj;
		return j2.getNom()==nom;
	}
	
	@Override
	public String toString() {
		
		return nom;
	}
	
	private void donner(Carte carte) {
		main.prendre(carte);

	}
	
	private Carte prendreCarte(List<Carte> sabot) {
		if ( sabot.size()==0) {
			return null;
		}
		for(ListIterator<Carte> it= sabot.listIterator()) {
			
		}
		return ;

	}
}
