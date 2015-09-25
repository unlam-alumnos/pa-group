package test;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
*
* @author fede
*/
public class Board extends JPanel {
  private Image image;

  public Board(){
      ImageIcon ii = new ImageIcon(this.getClass().getResource("sprite.png"));
      image = ii.getImage();
  }

  @Override
  public void paint(Graphics g){
      Graphics2D g2d = (Graphics2D)g; // Convertimos a g de Graphics a Graphics2D
      g2d.drawImage(image, 0, 0, this); // Lleno
      //g2d.drawImage(image, -455, 0, this); // Vacio
  }
}