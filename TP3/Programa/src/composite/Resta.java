package composite;

public class Resta extends Operacion{

	public Resta(double i, double j) {
		super(i, j);
	}

	@Override
	public double resolver() {
		return numero1 - numero2;
	}
	
}
