package jeu;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

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
	
	public void prendre(Carte carte) {
		main.prendre(carte);

	}
	
	

	
	
	public < T extends Carte> Carte prendreCarte(Collection<T> sabot) {
		Carte carte=zoneDeJeu.derniereCarteListe(sabot);
		prendre(carte);
		return carte;

	}
	
//	public void deposer(Borne borne) {
//		zoneDeJeu.ajouter(borne);
//
//	}
//
//	public void deposer(Botte botte) {
//		zoneDeJeu.ajouter(botte);
//
//	}
//	
//	public void deposer(Limite limite) {
//		zoneDeJeu.ajouter(limite);
//
//	}
//	
//	public void deposer(Bataille bataille) {
//		zoneDeJeu.ajouter(bataille);
//	}
	
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coupsPossibles = new HashSet<>();
		for(Iterator<Joueur> it= participants.iterator();it.hasNext();) {
			Joueur jCible=it.next();
			for(Iterator<Carte> it2= main.iterator();it2.hasNext();) {
				Carte carte=it2.next();
				Coup coup=new Coup(carte,jCible);
				if (coup.estValide(this)) {
					coupsPossibles.add(coup);
					
				}	
			}
		}		
		return coupsPossibles;
		
	}
	
	public Set<Coup> coupsDefausse() {
		Set<Coup> coupsDefausses = new HashSet<>();
		for(Iterator<Carte> it= main.iterator();it.hasNext();) {
			coupsDefausses.add(new Coup(it.next(),null));
				
		}
		return coupsDefausses;
	}
	
	public boolean deposer(Carte c) {
		return zoneDeJeu.deposer(c);
	}
	
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);

	}
	
	
    private static Coup extraireCoupHasard(Set<Coup> setC) {
        Random random=new Random();
        int r=random.nextInt(setC.size());
        Coup c=null;
        for(Iterator<Coup> it=setC.iterator();it.hasNext() && r >=0;) {
        	c=it.next();
        	r--;
        }
        return c;
    }
	
	
	
	public Coup choisirCoup( Set<Joueur> participants  ) {
		Set<Coup> coupsPossibles= coupsPossibles(participants);
		Coup choixC=null;
		
		if( ! coupsPossibles.isEmpty()) {	
			choixC=extraireCoupHasard(coupsPossibles);
		}
		
		else {
			choixC=extraireCoupHasard(coupsDefausse());
			
		}

		return choixC;
	}
	public void afficherMain() {
		System.out.println("Main joueur :" + main);
		
	}
	
}
