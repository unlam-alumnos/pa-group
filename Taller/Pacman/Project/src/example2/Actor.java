package example2;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.*;


public class Actor
{
    protected ImageIcon Imagen;
    protected int PosicionX = 0;
    protected int PosicionY = 0;
    protected int Velocidad = 1;
    protected int CodigoDireccion = 3;    //1.Arriba   2.Abajo   3.Derecha   4.Izquierda
    protected boolean ActorDetenido = false; //Se coloca a true cuando se encuentra con una pare y no sabe a donde ir
    
    protected Rectangle LaberintoVirtual[][];
    
    protected boolean Arriba = false;
    protected boolean Abajo = false;
    protected boolean Derecha = false;
    protected boolean Izquierda = false;
    
    protected void EstablecerLaberinto(String Laberinto[][], int LargoImagenes, int AlturaImagenes)
    {
        LaberintoVirtual = new Rectangle[Laberinto.length][];
        
        for(int i = 0; i < Laberinto.length; i++)
        {
            LaberintoVirtual[i] = new Rectangle[Laberinto[i].length];
            
            for(int j = 0; j < Laberinto[i].length; j++)
            {
                if(!(Laberinto[i][j].equals("CA")))
                {
                    LaberintoVirtual[i][j] = new Rectangle(i*LargoImagenes,j*AlturaImagenes,LargoImagenes,AlturaImagenes);
                }
                else
                {
                    LaberintoVirtual[i][j] = null;
                }
            }
        }
    }
    
    protected void EstablecerPosicionInicial(int X, int Y)
    {
        PosicionX = X;
        PosicionY = Y;
    }
    protected void AumentarPosicionX(){PosicionX = PosicionX + Velocidad;}
    protected void DisminuirPosicionX(){PosicionX = PosicionX - Velocidad;}
    protected void AumentarPosicionY(){PosicionY = PosicionY + Velocidad;}
    protected void DisminuirPosicionY(){PosicionY = PosicionY - Velocidad;}
    protected void CambiarVelocidad(int NuevoValor){Velocidad = NuevoValor;}
    protected ImageIcon ObtenerImagen(){return Imagen;}
    protected boolean CambioDireccion = true;
    
    protected boolean VerificarParedes(int PosX, int PosY)
    {
        //Obtiene todas las paredes y compara si se intersectan con pacman
        Rectangle PosicionPacman = new Rectangle(PosX,PosY,Imagen.getIconWidth(), Imagen.getIconHeight());
        
        for(int i = 0; i < LaberintoVirtual.length; i++)
        {
            for(int j = 0; j < LaberintoVirtual[i].length; j++)
            {
                if(LaberintoVirtual[i][j] != null)
                {
                    if(PosicionPacman.intersects(LaberintoVirtual[i][j]))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    protected void MoverActor()
    {
        Timer BucleJuego = new Timer(15, new ActionListener()
        { 
            public void actionPerformed(ActionEvent e) 
            {
                MoverPosicionActor();
                
                if(Arriba)
                if(!VerificarParedes(PosicionX,PosicionY - Velocidad))
                {
                     CodigoDireccion = 1;
                     CambiarImagen();
                }
                if(Abajo)
                if(!VerificarParedes(PosicionX,PosicionY + Velocidad))
                {
                     CodigoDireccion = 2;
                     CambiarImagen();
                }
                if(Derecha)
                if(!VerificarParedes(PosicionX + Velocidad,PosicionY))
                {
                     CodigoDireccion = 3;
                     CambiarImagen();
                }
                if(Izquierda)
                if(!VerificarParedes(PosicionX - Velocidad, PosicionY))
                {
                     CodigoDireccion = 4;
                     CambiarImagen();
                }
             } 
        });
        BucleJuego.start();
    }
    
    private void MoverPosicionActor()
    {
        switch(CodigoDireccion)
        {
            case 1: //Arriba
            {
                if(!VerificarParedes(PosicionX,PosicionY - Velocidad))
                {
                    ActorDetenido = false;
                    DisminuirPosicionY();
                }
                else
                {
                    ActorDetenido = true;
                }
                break;
            }
            case 2: //Abajo
            {
                if(!VerificarParedes(PosicionX,PosicionY + Velocidad))
                {
                    ActorDetenido = false;
                    AumentarPosicionY();
                }
                else
                {
                    ActorDetenido = true;
                }
                break;
            }
            case 3: //Derecha
            {
                if(!VerificarParedes(PosicionX + Velocidad,PosicionY))
                {
                    ActorDetenido = false;
                    AumentarPosicionX();
                }
                else
                {
                    ActorDetenido = true;
                }

                break;
            }
            case 4: //Izquierda
            {
                if(!VerificarParedes(PosicionX - Velocidad, PosicionY))
                {
                    ActorDetenido = false;
                    DisminuirPosicionX();
                }
                else
                {
                    ActorDetenido = true;
                }
                break;
            }
        }
    }
    
    protected void CambiarImagen(){}
}
