package jeu;

import items.Attaque;
import items.Botte;
import items.Carte;
import items.Parade;
import items.Probleme.Type;

public interface Cartes {
	public static final Carte PRIORITAIRE=new Botte(1,Type.FEU);
	public static final Carte FEU_ROUGE=new Attaque(1,Type.FEU);
	public static final Carte FEU_VERT=new Parade(Type.FEU,1);
}
