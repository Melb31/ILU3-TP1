package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import items.Bataille;
import items.Borne;
import items.Botte;
import items.Carte;
import items.FinLimite;
import items.Limite;
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
	
	
	public void ajouter(Limite carte) {
		pileLimites.add(carte);
	}
	public void ajouter(Bataille carte) {
		pileBatailles.add(carte);
	}
	public void ajouter(Borne carte) {
		collecBornes.add(carte);
	}
	public void ajouter(Botte carte) {
		ensBottes.add(carte);
	}
	
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
				|| ensBottes.contains(Cartes.PRIORITAIRE)) {
			limite=200;
		}
				
		return limite;

	}
	
	public boolean estBloque() {
		boolean ok=true;
		boolean prioritaire=ensBottes.contains(Cartes.PRIORITAIRE);
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
	
	
	private boolean estDepotAutorise(Carte carte) {
		//TODO
		return true;

	}
}
