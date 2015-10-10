package model.singleton;

public class Y extends Variable {

	private Y(){ super(0); }
	
	private static Y instancia;
	
	public static Y getInstancia(){
		if (instancia == null) {
			instancia = new Y();
		}
		return instancia;
	}
}
