package model;

import javax.swing.*;


public class Usuario extends Actor
{
    public Usuario()
    {
        super.Imagen = new ImageIcon("Graficos/Pacman/PacmanDerecha.gif");
    }
    public void MoverPacman()
    {
        MoverActor();
    }
    
    @Override
    public void CambiarImagen()
    {
        switch(CodigoDireccion)
        {
            case 1:{Imagen = null; Imagen = new ImageIcon("Graficos/Pacman/PacmanArriba.gif"); break;}
            case 2:{Imagen = null; Imagen = new ImageIcon("Graficos/Pacman/PacmanAbajo.gif"); break;}
            case 3:{Imagen = null; Imagen = new ImageIcon("Graficos/Pacman/PacmanDerecha.gif"); break;}
            case 4:{Imagen = null; Imagen = new ImageIcon("Graficos/Pacman/PacmanIzquierda.gif"); break;}
        }
    }
}
