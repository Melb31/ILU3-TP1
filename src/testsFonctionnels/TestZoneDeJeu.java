package testsFonctionnels;

import items.Attaque;
import items.Botte;
import items.Parade;
import items.Probleme.Type;
import jeu.Cartes;
import jeu.Joueur;

public class TestZoneDeJeu {
	
	public static void main(String[] args) {
		Joueur j= new Joueur("Emily");
		j.deposer((Attaque) Cartes.FEU_ROUGE);
		System.out.println(j.zoneDeJeu.estBloque());
		j.deposer((Botte) Cartes.PRIORITAIRE);
		System.out.println(j.zoneDeJeu.estBloque());
		j.deposer(new Attaque(1,Type.ACCIDENT));
		System.out.println(j.zoneDeJeu.estBloque());
		j.deposer(new Parade(Type.ACCIDENT,1));
		System.out.println(j.zoneDeJeu.estBloque());
		j.deposer(new Attaque(1,Type.ESSENCE));
		System.out.println(j.zoneDeJeu.estBloque());
		j.deposer(new Parade(Type.ESSENCE,1));
		System.out.println(j.zoneDeJeu.estBloque());
		j.zoneDeJeu.ensBottes.clear();
		System.out.println(j.zoneDeJeu.estBloque());
		j.deposer((Parade) Cartes.FEU_VERT);
		System.out.println(j.zoneDeJeu.estBloque());
	}
}
