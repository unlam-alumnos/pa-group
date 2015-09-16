package model;

import java.util.Arrays;

import exception.DistDimException;

public class VectorMath {

	private int dim;
	private double[] coord;
	private int index;

	public VectorMath(int dim) {
		super();
		this.dim = dim;
		this.index = 0;
		this.coord = new double[this.dim];
	}

	public void add(double element) {
		this.coord[index] = element;
		index++;
	}

	public VectorMath sumar(VectorMath vec) throws DistDimException {
		if (dim != vec.dim)
			throw new DistDimException(" Distinta Dimension ");

		VectorMath aux = new VectorMath(dim);
		for (int i = 0; i < dim; i++)
			aux.add(this.coord[i] + vec.coord[i]);
		return aux;
	}

	public VectorMath restar(VectorMath vec) throws DistDimException {
		if (dim != vec.dim)
			throw new DistDimException(" Distinta Dimension ");

		VectorMath aux = new VectorMath(dim);
		for (int i = 0; i < dim; i++)
			aux.add(this.coord[i] - vec.coord[i]);
		return aux;
	}

	public VectorMath multiplicar(VectorMath vec) throws DistDimException {
		if (dim != vec.dim)
			throw new DistDimException(" Distinta Dimension ");

		VectorMath aux = new VectorMath(dim);
		for (int i = 0; i < dim; i++)
			aux.add(this.coord[i] * vec.coord[i]);
		return aux;
	}

	public VectorMath multiplicar(double real) {
		VectorMath aux = new VectorMath(dim);

		for (int i = 0; i < this.dim; i++) {
			aux.add(this.coord[i] * real);
		}
		return aux;
	}
	
	public VectorMath multiplicar(MatrizMath mat) {
		if (dim != mat.getColumnas())
			throw new DistDimException(" Distinta Dimension ");
		
		VectorMath aux = new VectorMath(dim);
		for (int f = 0; f < mat.getFilas(); f++) {
			double acum = 0;
			for (int c = 0; c < mat.getColumnas(); c++) {
				acum += this.coord[c] * mat.getCoordMatriz(f,c);
			}			
			aux.coord[f] = acum;
		}
		
		return aux;
	}

	public double normaUno() {
		double aux = 0;
		for (int i = 0; i < dim; i++) {
			if (coord[i] < 0)
				aux -= coord[i];
			else
				aux += coord[i];
		}
		return aux;
	}

	public double normaDos() {
		double aux = 0;
		for (int i = 0; i < dim; i++) {
			aux += Math.pow(coord[i], 2);
		}
		aux = Math.sqrt(aux);
		return aux;
	}

	public double normaInf() {
		double aux = 0;
		double may = 0;
		for (int i = 0; i < dim; i++) {
			aux = coord[i];
			if (aux < 0)
				aux = aux * (-1);
			if (aux > may)
				may = aux;
		}
		return may;
	}
	
	public VectorMath clone() {
		VectorMath aux = new VectorMath(dim);

		for (int i = 0; i < this.dim; i++) {
			aux.add(this.coord[i]);
		}
		return aux;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coord);
		result = prime * result + dim;
		result = prime * result + index;
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
		VectorMath other = (VectorMath) obj;
		if (!Arrays.equals(coord, other.coord))
			return false;
		if (dim != other.dim)
			return false;
		if (index != other.index)
			return false;
		for (int i = 0; i < this.dim; i++) {
			double diff = this.coord[i] - other.coord[i];
			if (Math.abs(diff) >= 100)
				return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		return Arrays.toString(coord);
	}

	public int getDim() {
		return dim;
	}

	public double getCoord(int i) {
		return coord[i];
	}
}
