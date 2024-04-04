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
	
	
	private < T extends Carte> Carte derniereCarteListe(Collection<T> sabot) {
		Carte carte=null;
		for(Iterator<T> it= sabot.iterator();it.hasNext();) {
			carte=it.next();
			if( ! it.hasNext() ) {
				return carte;
			}
	} 
			return carte;
	
	}
	
	
	public < T extends Carte> Carte prendreCarte(Collection<T> sabot) {
		Carte carte=derniereCarteListe(sabot);
		donner(carte);
		return carte;

	}
	
	public void deposer(Borne borne) {
		zoneDeJeu.collecBornes.add(borne);

	}

	public void deposer(Botte botte) {
		zoneDeJeu.ensBottes.add(botte);

	}
	
	public void deposer(Limite limite) {
		zoneDeJeu.pileLimites.add(limite);

	}
	
	public void deposer(Bataille bataille) {
		zoneDeJeu.pileBatailles.add(bataille);
	}
	
	public int donnerKmParcourus() {
		int kmParc=0;
		Collection<Borne> collec=zoneDeJeu.collecBornes;
		for(Iterator<Borne> it = collec.iterator(); it.hasNext() ;  ) {
			kmParc+=it.next().getKm();
		}
		return kmParc;
	}
	
	public int donnerLimitationVitesse() {
		int limite=50;
		List<Limite> pileLimites=zoneDeJeu.pileLimites;
		if (pileLimites.isEmpty() || derniereCarteListe(pileLimites).equals( new FinLimite(1)) 
				|| zoneDeJeu.ensBottes.contains(new Botte(1, Type.FEU))) {
			limite=200;
		}
				
		return limite;

	}
	
	private boolean estBloque() {
		boolean ok=true;

		if ( zoneDeJeu.pileBatailles.isEmpty() && 
				zoneDeJeu.ensBottes.contains(new Botte(1, Type.FEU))) {
			ok=false;
		}
		else if(derniereCarteListe(zoneDeJeu.ensBottes).equals(new Parade(Type.FEU, 1))) {
			 ok=false;
		}
		else if (derniereCarteListe(zoneDeJeu.pileBatailles).equals(new Attaque(1, Type.FEU))
				&& 
				zoneDeJeu.ensBottes.contains(new Botte(1, Type.FEU))){
			ok=false;
		}
		// a finir il reste dernier
		
		
		
		
		return ok;

	}
	
}
