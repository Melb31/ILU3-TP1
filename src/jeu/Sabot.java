package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import items.Carte;

public class Sabot{
	public Carte[] cartes;
	public int nbCartes;
	private int capacite;
	private int nbrOpe=0;
	
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterator=0;
		private boolean nextEffectue=false;
		private int nbOpeRef=nbrOpe;
	
	public boolean hasNext() {
		return indiceIterator < nbCartes;
	}

	public Carte next() {
		Carte carte=null;
		if(hasNext()) {
			carte=cartes[indiceIterator];
			indiceIterator++;
			nextEffectue=true;
	
		}
		else {
			throw new NoSuchElementException();}
		
	return carte;}
	
	public void remove() {
		if(nbCartes < 1 || ! nextEffectue) {
			throw new IllegalStateException();		}
		
		if(!hasNext()) {
			cartes[indiceIterator]=null;
		}
		else {
		for(int i=indiceIterator-1; i  < nbCartes -1;i++) {
			cartes[i]=cartes[i+1];
			System.out.println("remplace");
			System.out.println(cartes[i]);
			System.out.println("par");
			System.out.println(cartes[i+1]);
		}

		}

		nbCartes--;
		nbrOpe++;
		nbOpeRef++;
		
	}
	private void verificationConcurrence() {
		if (nbrOpe!=nbOpeRef) {
			throw new ConcurrentModificationException();
		}}
	
	}
	
	
	public Sabot(int capacite) {
		cartes= new Carte[capacite];
		nbCartes=0;
		this.capacite=capacite;
	}
	
	private Boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes < capacite) {
			cartes[nbCartes]=carte;
			nbCartes++;
			nbrOpe++;
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
	
	
	public void piocher() {
		Iterator<Carte> iter= iterator();
		Carte carte=null;
		while(iter.hasNext()) {
			carte=iter.next();
		
		}
		System.out.println("Je pioche : "+ carte.toString());
		iter.remove();
		}



	

}
