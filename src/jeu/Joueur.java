package jeu;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import items.Attaque;
import items.Bataille;
import items.Borne;
import items.Botte;
import items.Carte;
import items.FinLimite;
import items.Limite;
import items.Parade;
import items.Probleme.Type;

public class Joueur {
	private String nom;
	public ZoneDeJeu zoneDeJeu;
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
	
	

	
	
	public < T extends Carte> Carte prendreCarte(Collection<T> sabot) {
		Carte carte=zoneDeJeu.derniereCarteListe(sabot);
		donner(carte);
		return carte;

	}
	
	public void deposer(Borne borne) {
		zoneDeJeu.ajouter(borne);

	}

	public void deposer(Botte botte) {
		zoneDeJeu.ajouter(botte);

	}
	
	public void deposer(Limite limite) {
		zoneDeJeu.ajouter(limite);

	}
	
	public void deposer(Bataille bataille) {
		zoneDeJeu.ajouter(bataille);
	}
	

	
}
