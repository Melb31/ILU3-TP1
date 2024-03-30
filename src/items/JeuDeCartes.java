package items;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import items.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {
    
    private List<Carte> listeCarte;
    private static Carte[]  typesDeCartes =   
        {new Botte(1,Type.ACCIDENT),new Botte(1,Type.ESSENCE),new Botte(1,Type.CREVAISON),
                          new Botte(1,Type.FEU),new Attaque(5,Type.FEU),new Attaque(3,Type.CREVAISON),
                          new Attaque(3,Type.ACCIDENT),new DebutLimite(4),new FinLimite(6),new Parade(Type.FEU,14),
                          new Parade(Type.ESSENCE,6),new Parade(Type.CREVAISON,6),new Parade(Type.ACCIDENT,6),
                          new Borne(10,25),new Borne(10,50),new Borne(10,75),new Borne(12,100),new Borne(4,200)};
    public JeuDeCartes() {
    
        listeCarte= new ArrayList<>();
        for(int i=0;i<typesDeCartes.length;i++) {
            
            Carte carte=typesDeCartes[i];
            
            for(int j=0; j < carte.getNombre(); j++) {
                listeCarte.add(carte);
            }
            
            listeCarte=Utils.melanger(listeCarte);
        }}
        
    
        
    public boolean checkCount() {
        for(int i=0; i < typesDeCartes.length;i++ ) {
            int nbCarteVoulu=typesDeCartes[i].getNombre();
            int nbCarte=0;
            for (ListIterator<Carte> iterator = listeCarte.listIterator(); iterator.hasNext();) {
                Carte carte =iterator.next();
                if (carte.equals(typesDeCartes[i])){
                    nbCarte++;
                }
                
            }
            if (nbCarte!=nbCarteVoulu) {
                return false;
            }
            
        }
        System.out.println("bien melangé");
        return true;
    }



	public List<Carte> getListeCarte() {
		return listeCarte;
	}
    
    
    
    
}
