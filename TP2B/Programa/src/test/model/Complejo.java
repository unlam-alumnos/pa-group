package test.model;

public class Complejo implements Comparable<Complejo>{

	public static int num = 1;

	private double real;
	private double imaginario;

	public Complejo() {
		this(0, 0);
	}

	public Complejo(double real, double imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}

	public Complejo(Complejo c1) {
		this.real = c1.real;
		this.imaginario = c1.imaginario;
	}

	public Complejo sumar(Complejo c) {
		double real = this.real + c.getReal();
		double imaginario = this.imaginario + c.getImaginario();
		return new Complejo(real, imaginario);
	}

	public Complejo sumar(double real) {
		return sumar(new Complejo(real, 0));
	}

	public Complejo restar(Complejo c) {
		double real = this.real - c.getReal();
		double imaginario = this.imaginario - c.getImaginario();
		return new Complejo(real, imaginario);
	}

	public Complejo restar(double real) {
		return sumar(new Complejo(real * -1, 0));
	}

	public Complejo multiplicar(Complejo c) {
		double real = (this.real * c.getReal() - this.imaginario * c.getImaginario());
		double imaginario = (this.real * c.getImaginario() + this.imaginario * c.getReal());
		return new Complejo(real, imaginario);
	}

	public Complejo multiplicar(double real) {
		return multiplicar(new Complejo(real, 1));
	}

	public Complejo dividir(Complejo c) {
		double real = (this.real * c.getReal() + this.imaginario * c.getImaginario())
				/ (Math.pow(c.getReal(), 2) + Math.pow(c.getImaginario(), 2));
		double imaginario = (this.imaginario * c.getReal() - this.real * c.getImaginario())
				/ (Math.pow(c.getReal(), 2) + Math.pow(c.getImaginario(), 2));
		return new Complejo(real, imaginario);
	}

	public Complejo dividir(double real) {
		return dividir(new Complejo(real, 1));
	}

	public double modulo() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
	}

	@Override
	public String toString() {
		return "(" + real + ", " + imaginario + "i)";
	}

	public static void mostrar() {
		mostrar("Nada");
	}

	public static void mostrar(String string) {
		System.out.println(string);
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginario() {
		return imaginario;
	}

	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
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
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(imaginario) != Double.doubleToLongBits(other.imaginario))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}

	@Override
	public int compareTo(Complejo c2) {
		if(this.modulo() == c2.modulo()) {
			return 0;
		}else if(this.modulo() < c2.modulo()) {
			return -1;
		}else {
			return 1;
		}
	}
	/*
	 * Implemento la interfaz "Comparable"
	 * Interfaz: contrato donde estan definidos los metodos (primitivas) a ser implementados por las clases que la implementen.
	 * "Comparable" es utilizado para ordenar arrays, lists, etc.
	 * Debo implementar el metodo compareTo() y luego desde el main llamo al metodo Arrays.sort(array);
	 * */
	
}
