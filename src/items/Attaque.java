package items;

public class Attaque extends Bataille {

	public Attaque(int num, Type type) {
		super(num,type);
	}
	
	public String toString() {
		String type=getType().toString();
		String str="Carte :";
		
		switch (type) {
		case "feu": {
			str+=type+" rouge";
			return str;
		}
		case "essence":{
			str+=" en panne d'"+type;
			return str;
		}
		case"accident":{
			str+=" accident";
			return str;
		}
		default:{
			str+=" crevaison";
			return str;
		}
	}
		

}


}
