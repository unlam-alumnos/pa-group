package example2;

import javax.swing.*;

public class Fantasma extends Actor
{
    public Fantasma()
    {
        super.Imagen = new ImageIcon("Graficos/Enemigos/FantasmaRojo.gif");
    }
    public void VerificarCambiosDireccion(){}
    
    public void CambiarDireccion(int NuevaDireccion)
    {
         //1.Arriba   2.Abajo   3.Derecha   4.Izquierda
        CodigoDireccion = NuevaDireccion;
    }
    public void MoverFantasma(){MoverActor();}
}
