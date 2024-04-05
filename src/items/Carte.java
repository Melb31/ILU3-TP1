package items;

public abstract class Carte {
	private int nombre;
	protected Carte(int nombre) {
		this.nombre=nombre;
	}
	public int getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if(obj == null) {
			return false;
		}

		return obj.getClass()==getClass();}


}
