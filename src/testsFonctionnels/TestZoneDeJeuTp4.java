package testsFonctionnels;

import items.*;
import items.Probleme.Type;
import jeu.*;


public class TestZoneDeJeuTp4 {
	public static void main(String args[]) {
//        ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
//        zoneDeJeu.deposer(Cartes.FEU_ROUGE);
//        System.out.println("bloqu� ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(Cartes.PRIORITAIRE);
//        System.out.println("bloqu� ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Attaque(0, Type.ACCIDENT));
//        System.out.println("bloqu� ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Botte(0, Type.ACCIDENT));
//        System.out.println("bloqu� ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Attaque(0, Type.ESSENCE));
//        System.out.println("bloqu� ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Parade(0, Type.ESSENCE));
//        System.out.println("bloqu� ? "+zoneDeJeu.estBloque());
		
	
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		System.out.println("Deposer carte Feu rouge");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(Cartes.FEU_ROUGE));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte attaque - accident");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Attaque(0, Type.ACCIDENT)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte botte - accident");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Botte(0, Type.ACCIDENT)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte Feu vert");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(Cartes.FEU_VERT));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte attaque - essence");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Attaque(0, Type.ESSENCE)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte parade - essence");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Parade(Type.ESSENCE, 0)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte Feu vert");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(Cartes.FEU_VERT));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 100");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte limite - 50");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new DebutLimite(0)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 100");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 25");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Borne(0, 25)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte fin limite - 50");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new FinLimite(0)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 100");
		System.out.println("depot ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqu� ? " + zoneDeJeu.estBloque());
	}

}
