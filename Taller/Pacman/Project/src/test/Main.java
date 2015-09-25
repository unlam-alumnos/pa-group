package test;
import javax.swing.JFrame;

/**
*
* @author fede
*/
public class Main extends JFrame {

  public Main(){
      add(new Board());
      setTitle("Loading Sprite"); // Titulo
      setSize(455,523); // Tamaño
      setDefaultCloseOperation(EXIT_ON_CLOSE); // Salir cuando apretamos el boton 'x'
      setLocationRelativeTo(null); // Centrar
      setVisible(true); // Visible
      setResizable(false); // No se puede resizear
  }

  public static void main(String[] args) {
      new Main();
  }

}