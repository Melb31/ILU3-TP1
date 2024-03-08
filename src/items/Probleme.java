package items;

public abstract class Probleme extends Carte {
	
	public enum Type {
	FEU("feu"), ESSENCE("essence"), CREVAISON("crevaison"),
	ACCIDENT("accident");  
	private String nom;
	private Type(String nom) {
		this.nom=nom;
	}
	
	public String toString() {

		return nom;
	}
	
	}
	
	private Type type;
	
	protected Probleme(int numero, Type t) {
		super(numero);
		type=t;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Probleme carte=(Probleme) obj;
				return carte.getType()==getType();
		}
		return false;
	}

}
