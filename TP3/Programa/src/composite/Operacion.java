package composite;

public abstract class Operacion {
	protected double numero1;
	protected double numero2;
	
	public Operacion(double a, double b) {
		numero1 = a;
		numero2 = b;
	}

	public abstract double resolver();

	public double getNumero1() {
		return numero1;
	}

	public double getNumero2() {
		return numero2;
	}

}
