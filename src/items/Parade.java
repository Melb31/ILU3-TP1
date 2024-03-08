package items;

public class Parade extends Bataille {

	public Parade(Type type, int numero) {
		super(numero,type);
	}
	
	public String toString() {
		String type=getType().toString();
		String str="Carte :";
		
		switch (type) {
		case "feu": {
			str+=type+" vert";
			return str;
		}
		case "essence":{
			str+=" remplissage d'"+type;
			return str;
		}
		case"accident":{
			str+=" reparation";
			return str;
		}
		default:{
			str+=" roue de secours";
			return str;
		}
	}
}}

