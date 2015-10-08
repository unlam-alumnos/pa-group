package composite;

public class Potenciacion implements Operacion{
	private double base;
	private double exponente;
	
	public Potenciacion(double base, double exponente) {
		this.base = base;
		this.exponente = exponente;
	}


	@Override
	public double resolver() {
		return Math.pow(base, exponente);
	}
	
}
