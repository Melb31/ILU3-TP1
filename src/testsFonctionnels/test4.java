package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

import items.Carte;
import items.JeuDeCartes;

public class test4 {

	
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListeCarte();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println(" liste melancer sans erreur ? " + Utils.veriferMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
		jeu.checkCount();
		
	}
}
