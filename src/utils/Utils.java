package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import items.Carte;
import jeu.Sabot;

public class Utils {
    public static Carte extraire(List<Carte> liste) {
        Random randomNumbers=new Random();
        int r=randomNumbers.nextInt(liste.size());
        return liste.remove(r);
    }
    
    public static Carte extraire2(List<Carte> liste) {
        Random randomNumbers=new Random();
        int r=randomNumbers.nextInt(liste.size());
        for(ListIterator<Carte> it=liste.listIterator(); it.hasNext() && (r > 0);) {
            it.next();
        }
        return liste.remove(r);
    }
    
    public static List<Carte> melanger(List<Carte> liste) {
        List<Carte> newListe=new ArrayList<>();
        while( ! liste.isEmpty()) {
            newListe.add(extraire(liste));
            
        }
        return newListe;
    }
    
    public static boolean veriferMelange(List<Carte> liste1,List<Carte> liste2) {
        for(ListIterator<Carte> it=liste1.listIterator(); it.hasNext();) {
        	Carte carte=it.next();
        	if (Collections.frequency(liste1,carte)==Collections.frequency(liste2,carte)) {
        		return true;
        	}
        	
        }
        return false; 
    }
    
    public static List<Carte> rassembler(List<Carte> l) {
		List<Carte> newListe= new ArrayList<Carte>();
		for(ListIterator<Carte> it=l.listIterator(); it.hasNext();) {
			Carte carte=it.next();
			if (Collections.frequency(newListe, carte)==0) {
				for(int i=0; i < Collections.frequency(l,carte);i++){
					newListe.add(carte);
				}
			}
        	
        		}
		return newListe;
		}
    
    public static boolean verifierRassemblement(List<Carte> l) {

		for(ListIterator<Carte> it=l.listIterator(); it.hasNext();) {
        	Carte carte=it.next();

        	while (it.hasNext() && it.next().equals(carte) ) {

        			}

        	for(ListIterator<Carte> it2=l.subList(it.nextIndex()-1,l.size()-1).listIterator();
        			it2.hasNext();) {
        		if ( carte==it2.next()) {
 
        			return false;
        		}
        	}

		}
		return true;

		}
    

}