package items;

public class Botte extends Probleme{

	public Botte(int numero, Type type) {
		super(numero,type);
	}
	public String toString() {
		String type=getType().toString();
		String str="Carte :";
		
		switch (type) {
		case "feu": {
			str+=type+" véhicule prioritaire";
		}
		case "essence":{
			str+=" citerne d'"+type;
		}
		case"accident":{
			str+=" as du volant";
		}
		default:{
			str+=" increvable";
		}
		return str;
	}
}
}
