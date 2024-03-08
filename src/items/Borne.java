package items;

import java.util.Objects;

public class Borne extends Carte {
	private int km;
	public Borne(int num, int km) {
		super(num);
		this.km=km;
	}

	public int getKm() {
		return km;
		
	}
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Borne carte=(Borne) obj;
			return carte.getKm()==km ;
		}
		return false;
	}

}
