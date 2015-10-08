package composite;

public class Potenciacion extends Operacion{

	public Potenciacion(double i, double j) {
		super(i, j);
	}

	@Override
	public double resolver() {
		return Math.pow(numero1, numero2);
	}
	
}
