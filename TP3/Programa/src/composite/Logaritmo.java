package composite;

public class Logaritmo implements Operacion{
	private double numero;
	
	public Logaritmo(double numero) {
		this.numero = numero;
	}

	@Override
	public double resolver() {
		return Math.log(numero);
	}

}
