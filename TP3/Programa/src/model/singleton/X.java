package model.singleton;

public class X extends Variable {

	private X(){ super(0); }
	
	private static X instancia;
	
	public static X getInstancia(){
		if (instancia == null) {
			instancia = new X();
		}
		return instancia;
	}
}
