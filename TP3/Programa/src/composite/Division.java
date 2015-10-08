package composite;

public class Division implements Operacion{
	
	private double dividendo;
	private double divisor;
	
	public Division(double dividendo, double divisor) {
		this.dividendo = dividendo;
		this.divisor = divisor;
	}

	@Override
	public double resolver() {
		return dividendo/divisor;
	}
	
}
