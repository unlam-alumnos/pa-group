package composite;

public class Suma extends Operacion{

	public Suma(double i, double j) {
		super(i, j);
	}

	@Override
	public double resolver() {
		return numero1 + numero2;
	}

}
