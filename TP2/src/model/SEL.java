package model;

import java.io.*;

public class SEL {

	private int dim;
	private MatrizMath coeficientes;
	private VectorMath terminosIndependientes;
	private VectorMath solucion;
	private double error;
	
	public SEL (String pathFile) {
		super();
		
		FileReader fr = null;
		try {
			File archivo = new File(pathFile);
			fr = new FileReader(archivo);

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String datos[];
			
			this.dim = Integer.parseInt(br.readLine());
			this.coeficientes = new MatrizMath(this.dim,this.dim);
			this.terminosIndependientes = new VectorMath(this.dim);
			this.solucion = null;
			this.error = 0;
			
			for (int i = 0; i < Math.pow(this.dim, 2); i++) {
				datos = br.readLine().split(" ");
				this.coeficientes.add(Integer.parseInt(datos[0]),
						Integer.parseInt(datos[1]),
						Double.parseDouble(datos[2]));
			}
			
			for (int i = 0; i < dim; i++){
				this.terminosIndependientes.add(Float.parseFloat(br.readLine()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void resolver(){
		
		try {
			MatrizMath mat_inversa = coeficientes.getInversa();
			solucion = mat_inversa.multiplicar(terminosIndependientes);
			error = terminosIndependientes.restar(coeficientes.multiplicar(solucion)).normaDos();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void escribirSalida(String pathFile){
		
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter(pathFile);
			pw = new PrintWriter(archivo);
			
			if (this.solucion != null) {
				pw.println(this.dim);
				for (int i = 0; i < this.solucion.getDim(); i++) {
					pw.println(this.solucion.getCoord(i));
				}
				pw.println(this.error);
			}else{
				pw.println("EL SISTEMA NO SE PUEDE CALCULAR, TIENE INFINITAS SOLUCIONES O NINGUNA.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != archivo)
					archivo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	public VectorMath getSolucion() {
		return solucion;
	}
	
	public static void generadorAleatorioSEL_Simples(int dimension) {
		// Por "Simple" entendemos coeficientes enteros entre 1 y 11 por ejemplo
		int i, j;
		FileWriter archivo = null;
		String nombre_salida = "SEL_" + String.valueOf(dimension) + "x" + String.valueOf(dimension) + ".in";
		
		try {
			archivo = new FileWriter(nombre_salida);

			@SuppressWarnings("resource")
			PrintWriter pw = new PrintWriter(archivo);

			pw.println(dimension);
			for (i = 0; i < dimension; i++) {
				for (j = 0; j < dimension; j++)
					// En este linea podria cambiarse el (int)(Math.random() * 11 + 1) 
					// por cualquier otra instruccion que genere numeros random double por ejemplo
					pw.println(i + " " + j + " " + (int)(Math.random() * 11 + 1));
			}
			for (i = 0; i < dimension; i++)
				pw.println((int)(Math.random() * 11 + 1));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null)
					archivo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
