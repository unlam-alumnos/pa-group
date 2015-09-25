package test.model;

public class Circulo implements Comparable<Circulo>{
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return 2 * radio;
	}

	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}
	
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}

	public double getRadio() {
		return radio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (Double.doubleToLongBits(radio) != Double
				.doubleToLongBits(other.radio))
			return false;
		return true;
	}

	@Override
	public int compareTo(Circulo other) {
		if (this.getArea() > other.getArea()) {
			return 1;
		}else if (this.getArea() < other.getArea()) {
			return -1;
		}else{
			return 0;
		}
	}
}
