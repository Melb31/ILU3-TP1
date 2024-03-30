package jeu;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import items.Borne;
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
		Carte carte=null;
		for(ListIterator<Carte> it= sabot.listIterator();it.hasNext();) {
			it.next();
			if( ! it.hasNext() ) {
				carte=it.next();
				donner(carte);
				return carte;
			}
		}
		return carte;
	}
	
	public void deposer(Borne borne) {
		zoneDeJeu.collecBornes.add(borne);

	}
	
	public int donnerKmParcourus() {
		int kmParc=0;
		Collection<Borne> collec=zoneDeJeu.collecBornes;
		for(Iterator<Borne> it = collec.iterator(); it.hasNext() ;  ) {
			kmParc+=it.next().getKm();
		}
		return kmParc;
	}
	
}
