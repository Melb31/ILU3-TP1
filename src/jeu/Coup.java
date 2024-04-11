package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import items.Attaque;
import items.Carte;
import items.Limite;

public class Coup {
 private Carte carte;
 private Joueur jCible;
public Coup(Carte carte, Joueur jCible) {
	
	this.carte = carte;
	this.jCible = jCible;
}
 
public boolean estValide(Joueur joueur) {
	if( carte instanceof Attaque|| carte instanceof Limite) {
		return joueur!=this.jCible && jCible.zoneDeJeu.estDepotAutorise(carte);
	}
	else {
		return joueur==jCible && joueur.zoneDeJeu.estDepotAutorise(carte);
	}

}



 
 
 
}
