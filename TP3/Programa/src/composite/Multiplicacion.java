package composite;

public class Multiplicacion extends Operacion{

	public Multiplicacion(double i, double j) {
		super(i, j);
	}

	@Override
	public double resolver() {
		return numero1 * numero2;
	}

}
