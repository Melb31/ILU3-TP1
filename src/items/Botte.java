package items;

import java.util.HashMap;
import java.util.Map;

public class Botte extends Probleme{
	Map<Type, String> stringValue(){ new HashMap<>();
	stringValue.put(Type.FEU, "Véhicule prioritaire");
	stringValue.put(Type.ESSENCE, "Citerne d'essence");
	stringValue.put(Type.ACCIDENT, "As du volant");
	stringValue.put(Type.CREVAISON, "Increvable"); };
	
	
	
	public Botte(int numero, Type type) {
		super(numero,type);
	}

	public String toString() {
		return stringValue.get(getType());
	}
	
	
	
	
		public int compareTo(Botte botte) {
			return this.toString().compareTo(botte.toString()); 
		}

}
