package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import items.Carte;

public class Sabot implements Iterator<Carte>{
	private Carte[] cartes;
	private int nbCartes;
	private int capacite;
	private int indiceIterator=0;
	private boolean nextEffectue=false;
	
	@Override
	public boolean hasNext() {
		return indiceIterator < nbCartes;
	}

	@Override
	public Carte next() {
		if(hasNext()) {
			Carte carte=cartes[indiceIterator];
			indiceIterator++;
			nextEffectue=true;
			return carte;
		}
		else {
			throw new NoSuchElementException();}
		}
	
	
	
	
	public Sabot(int capacite) {
		cartes= new Carte[capacite];
		nbCartes=0;
		this.capacite=capacite;
	}
	
	private Boolean estVide() {
		return nbCartes==0;
	}
	
	private void ajouterCarte(Carte carte) {
		if (nbCartes < capacite) {
			cartes[nbCartes]=carte;
			nbCartes++;
		}
		else {
			throw new  ArrayIndexOutOfBoundsException("Le sabot est plein");
		}
	}
	
	private void ajouterFamilleCarte(Carte carte) {
		int nb=carte.getNombre();
		for(int i=0; i<nb;i++) {
			ajouterCarte(carte);
		}
	}
	
	private void ajouterLesCartes(Carte[] cartesAjoutees) {
		for(int i=0;i < cartesAjoutees.length;i++) {
			ajouterCarte(cartesAjoutees[i]);
		}
	}



	

}
