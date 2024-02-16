package items;

public class DebutLimite extends Limite{

	public DebutLimite(int num) {
		super(num);
	}
	
	@Override
	public String toString() {
		String str="Vitesse limitée à 50 km";
		return str;
	}
}
