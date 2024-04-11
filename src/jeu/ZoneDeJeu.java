package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import items.Attaque;
import items.Bataille;
import items.Borne;
import items.Botte;
import items.Carte;
import items.DebutLimite;
import items.FinLimite;
import items.Limite;
import items.Parade;
import items.Probleme.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimites ;
	private List<Bataille> pileBatailles ;
	private Collection<Borne> collecBornes;
	public NavigableSet<Botte> ensBottes;

	public ZoneDeJeu() {
		pileLimites= new ArrayList<>();
		pileBatailles= new ArrayList<>();
		collecBornes= new ArrayList<>();
		ensBottes= new TreeSet<>(
				new Comparator<Botte>() {
					public int compare(Botte b1, Botte b2) {
						return b1.compareTo(b2); 
						
					}
					
					
				});
	}
	
	
//	public void ajouter(Limite carte) {
//		pileLimites.add(carte);
//	}
//	public void ajouter(Bataille carte) {
//		pileBatailles.add(carte);
//	}
//	public void ajouter(Borne carte) {
//		collecBornes.add(carte);
//	}
//	public void ajouter(Botte carte) {
//		ensBottes.add(carte);
//	}
	
	public < T extends Carte> Carte derniereCarteListe(Collection<T> sabot) {
		Carte carte=null;
		for(Iterator<T> it= sabot.iterator();it.hasNext();) {
			carte=it.next();
			if( ! it.hasNext() ) {
				return carte;
			}
	} 
			return carte;
	
	}
	
	public boolean aBottePrioritaire () {
		return ensBottes.contains(Cartes.PRIORITAIRE);
	}
	
	public int donnerKmParcourus() {
		int kmParc=0;
		for(Iterator<Borne> it = collecBornes.iterator(); it.hasNext() ;  ) {
			kmParc+=it.next().getKm();
		}
		return kmParc;
	}
	
	public int donnerLimitationVitesse() {
		int limite=50;
		if (pileLimites.isEmpty() || derniereCarteListe(pileLimites).equals( new FinLimite(1)) 
				|| aBottePrioritaire()) {
			limite=200;
		}
				
		return limite;

	}
	
	public boolean estBloque() {
		boolean ok=true;
		boolean prioritaire=aBottePrioritaire();
		if ( pileBatailles.isEmpty() && 
				prioritaire) {
			return false;
		}
		Bataille carte=(Bataille) derniereCarteListe(pileBatailles);
		if( carte !=null && carte.equals(Cartes.FEU_VERT)) {
			return false;
		}
	
		if (carte !=null && carte.getClass()==Cartes.FEU_VERT.getClass()
				&& 
				prioritaire){
			return false;
		}
		else if (carte !=null && carte.equals(Cartes.FEU_ROUGE) 
				&& prioritaire ) {
			return false;
		}
		
		if (carte !=null && carte.getClass()==Cartes.FEU_ROUGE.getClass() && carte.getType()!=Type.FEU
				&& ensBottes.contains(new Botte(1,carte.getType())) && prioritaire) {
			return false;
		}
		
		return ok;

	}
	
	
	private boolean estDepotBatailleAutorise(Bataille carte) {
		if( ensBottes.contains(new Botte(1, carte.getType()))) {
			return false;
		}
		
		if ( carte instanceof Attaque ){
				Attaque carte2= (Attaque) carte;
				return ! estBloque() ;				}
		else {
			Parade Pcarte= (Parade) carte;	
			Bataille sommetB=(Bataille) derniereCarteListe(pileBatailles);
			if(Pcarte.equals(Cartes.FEU_VERT) ) {
				
				return sommetB==null || sommetB.equals(Cartes.FEU_ROUGE) ||
						( sommetB instanceof Parade &&  ! sommetB.equals(Cartes.FEU_VERT));
				

				}
			else {
				return (!(sommetB==null) && (sommetB instanceof Attaque && sommetB.getType() == carte.getType()));
					
					
				}
			}
				
			}
			
private boolean estDepotLimiteAutorise(Limite carte) {
		Limite sommetL=(Limite) derniereCarteListe(pileLimites);
		if( ! aBottePrioritaire() && donnerLimitationVitesse() == 50
				|| sommetL==null || sommetL instanceof FinLimite ) {
			return true; }
		if(carte instanceof FinLimite) {
			return ( ! aBottePrioritaire() && donnerLimitationVitesse() != 50);
		}
		
		return false;
		
	}
	
		
	
	
	
	protected boolean estDepotAutorise(Carte carte) {
		// carte : borne
		if(  carte instanceof Borne) {
			Borne BCarte= (Borne) carte;
			return !estBloque() && BCarte.getKm() <= donnerLimitationVitesse() && donnerKmParcourus() <= 1000;
			
			}
		//carte : botte		
		if ( carte instanceof Botte   ) {
			return true;
		}
		//carte = limitation
		if (carte instanceof Limite ) {
				return estDepotLimiteAutorise((Limite) carte);
		}
		//carte : bataille

		if( carte instanceof Bataille) {
			return estDepotBatailleAutorise( (Bataille) carte);
	
		}
		return false;

	}
	
public boolean deposer(Carte c) {
	if ( ! estDepotAutorise(c)) {
		return false;
	}
	if( c instanceof Borne) {
		collecBornes.add((Borne) c);
	}
	else if (c instanceof Botte) {
		Botte cB= (Botte) c;
		ensBottes.add((Botte) c);
		if(pileBatailles.contains(new Attaque(1, cB.getType()))) {
			pileBatailles.remove(new Attaque(1, cB.getType()));
		}
		}
	else if ( c instanceof Limite) {
		pileLimites.add((Limite) c);
	}
	else if (c instanceof Bataille) {
		pileBatailles.add((Bataille) c);
	}
	
	
	
	return true;

}
	
	
	
}
