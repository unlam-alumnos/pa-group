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
			//error = terminosIndependientes.restar(coeficientes.multiplicar(solucion)).normaDos();
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
			
			pw.println(this.solucion.getDim());
			
			if (this.solucion != null) {
				for (int i = 0; i < this.solucion.getDim(); i++) {
					pw.println(this.solucion.getCoord(i));
				}
				pw.println(this.error);
			}else{
				pw.println("ERROR");
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
}
