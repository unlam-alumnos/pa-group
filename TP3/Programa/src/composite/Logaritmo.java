package composite;

public class Logaritmo extends Operacion{

	public Logaritmo(double i, double j) {
		super(i, j);
	}

	@Override
	public double resolver() {
		if (numero1 == Math.E) {
			return Math.log(numero2);
		}else{
			return Math.log10(numero2);
		}
		
	}

}
