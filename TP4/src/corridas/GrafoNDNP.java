package corridas;

import generadores.Grafo;
import generadores.MatrizSimetrica;

import java.io.File;
import java.io.PrintWriter;

import algoritmos.ColoreoMatula;
import algoritmos.ColoreoSecuencialAleatorio;
import algoritmos.ColoreoWelshPowell;

public class GrafoNDNP {
	
	
	public static void main(String[] args) {

		final int[] vecColoreoMatula = new int[500];
		final int[] vecColoreoSecAleatorio = new int[500];
		final int[] vecColoreoWelshPowell = new int[500];
		final int tamanoVectorColores = 500;
		
		File salida1= new File("SalidaMatula.out");
		File salida2= new File("SalidaSecuencialAleatorio.out");
		File salida3= new File("SalidaWelshPowell.out");
		
		ColoreoMatula matula = null;
		ColoreoSecuencialAleatorio secuencialAleatorio = null;
		ColoreoWelshPowell welshPowell = null;
		
		//DECLARAMOS LOS VECTORES DE CANTIDAD DE COLORES y los seteamos en 0
		for (int i = 0; i < tamanoVectorColores; i++) {
		
			vecColoreoMatula[i] = 0;
			vecColoreoSecAleatorio[i] = 0;
			vecColoreoWelshPowell[i] = 0;

		}
		
		int cantMenorColoresMatula = tamanoVectorColores;
		int cantMenorColoresSecAleatorio = tamanoVectorColores;
		int cantMenorColoresWelshPowell = tamanoVectorColores;
		
		int matulaCantColores=0;
		int secAleatorioCantColores=0;
		int welshPowellCantColores=0;

		
		//HACEMOS LAS 10000 CORRIDAS
		int cantCorridas = 2500;
		
		
		for (int i = 1; i <= cantCorridas; i++) {

			//generamos el grafo (Hay que hacer 3 corridas variando el %de Adyacencia)
			
			
			Grafo g1 = new Grafo();
			g1.grafoDadoNYPorcentajeAdy(600, 40);
			
			
			//coloreamos usando los 3 algoritmos
			MatrizSimetrica matrizAdyacencia = new MatrizSimetrica(g1.getCantNodos());
			matrizAdyacencia.setCantAristas(g1.getCantAristas());
			matrizAdyacencia.setVector(g1.getMatrizAdy());
			
			matula = new ColoreoMatula(g1,matrizAdyacencia);
			secuencialAleatorio = new ColoreoSecuencialAleatorio (g1,matrizAdyacencia);
			welshPowell = new ColoreoWelshPowell (g1,matrizAdyacencia);

			
			matula.resolver();
			secuencialAleatorio.resolver();
			welshPowell.resolver();
			
			matulaCantColores = matula.getCantidadColores();
			secAleatorioCantColores = secuencialAleatorio.getCantidadColores();
			welshPowellCantColores = welshPowell.getCantidadColores();
			
			//Actualizamos los vectores de cantidad de colores de cada algoritmo
			vecColoreoMatula[matulaCantColores]++;
			vecColoreoSecAleatorio[secAleatorioCantColores]++;
			vecColoreoWelshPowell[welshPowellCantColores]++;
			
			//Imprimimos en pantalla el numero de corrida actual
			System.out.println(i);
			
			
			
			//Vemos si este fue el mejor caso de Matula, y lo guardamos
			if(matulaCantColores<cantMenorColoresMatula)
			{
				matula.generarArchivoSalida(salida1);
				g1.guardarGrafo("EntradaMatula.in");
				cantMenorColoresMatula = matulaCantColores;
				
			}
			//Vemos si este fue el mejor caso de Secuencial Aleatorio, y lo guardamos
			if(secAleatorioCantColores<cantMenorColoresSecAleatorio)
			{
				secuencialAleatorio.generarArchivoSalida(salida2);
				g1.guardarGrafo("EntradaSecuencialAleatorio.in");
				cantMenorColoresSecAleatorio = secAleatorioCantColores;
				
			}
			//Vemos si este fue el mejor caso de Welsh Powell, y lo guardamos
			if(welshPowellCantColores<cantMenorColoresWelshPowell)
			{
				welshPowell.generarArchivoSalida(salida3);
				g1.guardarGrafo("EntradaWelshPowell.in");
				cantMenorColoresWelshPowell = welshPowellCantColores;
				
			}

		}
		
		
		
		//Despues de hacer las 10000 corridas, grabamos los vectores de cantidad de colores
		File archivoMatula = null;
		PrintWriter pwMatula = null;
		File archivoSecAle = null;
		PrintWriter pwSecAle = null;
		File archivoWelshPowell = null;
		PrintWriter pwWelshPowell = null;

		try {
			archivoMatula = new File("vecColoreoMatula_10000.txt");
			pwMatula = new PrintWriter(archivoMatula);
			archivoSecAle = new File("vecColoreoSecuencialAleatorio_10000.txt");
			pwSecAle = new PrintWriter(archivoSecAle);
			archivoWelshPowell = new File("vecColoreoWelshPowell_10000.txt");
			pwWelshPowell = new PrintWriter(archivoWelshPowell);
			
			
			
			//Grabamos la primer linea (cantNodos, cantColores, cantAristas, %Ady, gradoMax, gradoMin)
			pwMatula.println(matula.getCantidadNodos() + " " + matula.getCantidadColores()+ " " + matula.getCantidadAristas()+ " " + matula.getPorcentajeAdyacencia() + " " + matula.getMaximoGrado() + " " + matula.getMinimoGrado());
			pwWelshPowell.println(secuencialAleatorio.getCantidadNodos() + " " + secuencialAleatorio.getCantidadColores()+ " " + secuencialAleatorio.getCantidadAristas()+ " " + secuencialAleatorio.getPorcentajeAdyacencia() + " " + secuencialAleatorio.getMaximoGrado() + " " + secuencialAleatorio.getMinimoGrado());
			pwSecAle.println(welshPowell.getCantidadNodos() + " " + welshPowell.getCantidadColores()+ " " + welshPowell.getCantidadAristas()+ " " + welshPowell.getPorcentajeAdyacencia() + " " + welshPowell.getMaximoGrado() + " " + welshPowell.getMinimoGrado());
			
			
			//grabamos el vector de cantidad de colores              REVISAR CONDICION DEL FOR!!!
			for (int i = 0; i < tamanoVectorColores; i++) {
				pwMatula.println(i + "	" + vecColoreoMatula[i]);				
				pwWelshPowell.println(i + "	" + vecColoreoWelshPowell[i]);
				pwSecAle.println(i + "	" + vecColoreoSecAleatorio[i]);
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pwMatula.close();
				pwSecAle.close();
				pwWelshPowell.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			

		}

	}
	
}

