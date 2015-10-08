package composite;

public class Suma implements Operacion{
	private double numero1;
	private double numero2;
		
	public Suma(double numero1, double numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	@Override
	public double resolver() {
		return numero1 + numero2;
	}

}
