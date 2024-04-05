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
			return str;
		}
		case "essence":{
			str+=" citerne d'"+type;
			return str;
		}
		case"accident":{
			str+=" as du volant";
			return str;
		}
		default:{
			str+=" increvable";
			return str;
		}
	}
}
		public int compareTo(Botte botte) {
			return this.toString().compareTo(botte.toString()); 
		}

}
