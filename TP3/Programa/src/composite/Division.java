package composite;

public class Division extends Operacion{

	public Division(double i, double j) {
		super(i, j);
	}

	@Override
	public double resolver() {
		return numero1/numero2;
	}
	
}
