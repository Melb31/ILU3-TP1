package testsFonctionnels;

import items.Attaque;
import items.Borne;
import items.DebutLimite;
import items.FinLimite;
import items.Probleme.Type;

public class test2 {
	public static void main(String[] args) {
		Borne carte1=new Borne(3,5);
		FinLimite carte2=new FinLimite(4);
		System.out.println(carte1.equals(carte2));
		
		
	}
}
