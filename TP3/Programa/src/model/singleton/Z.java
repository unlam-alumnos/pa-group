package model.singleton;

public class Z extends Variable {

	private Z(){ super(0); }
	
	private static Z instancia;
	
	public static Z getInstancia(){
		if (instancia == null) {
			instancia = new Z();
		}
		return instancia;
	}
}
