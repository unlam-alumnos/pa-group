package example2;

import javax.swing.*;
import java.util.*;

public class ControladorFantasmas
{
    private Fantasma ListaFantasmas[];
    private Random DireccionAleatoria = new Random();
    
    public ControladorFantasmas(int CantidadFantasmas, int PosicionXInicial, int PosicionYInicial, String LaberintoVirtual[][],int LargoImagenes, int AlturaImagenes)
    {
        ListaFantasmas = new Fantasma[CantidadFantasmas];
        
        for(int i = 0; i < ListaFantasmas.length; i++)
        {
            ListaFantasmas[i] = new Fantasma();
            ListaFantasmas[i].EstablecerPosicionInicial(PosicionXInicial, PosicionYInicial);
            ListaFantasmas[i].EstablecerLaberinto(LaberintoVirtual, LargoImagenes, AlturaImagenes);
        }
    }
    
    public void IniciarFantasmas()
    {
        for(int i = 0; i < ListaFantasmas.length; i++)
        {
            ListaFantasmas[i].MoverFantasma();
        }
    }
    
    public void VerificarFantasmasDetenidos()
    {
        for(int i = 0; i < ListaFantasmas.length; i++)
        {
            if(ListaFantasmas[i].ActorDetenido)
            {
                ListaFantasmas[i].CambiarDireccion(DireccionAleatoria.nextInt(4) + 1);
            }
        }
    }
    
    public int DevolverPosicionXFantasma(int IndiceFantasma){return ListaFantasmas[IndiceFantasma].PosicionX;}
    public int DevolverPosicionYFantasma(int IndiceFantasma){return ListaFantasmas[IndiceFantasma].PosicionY;}
    public ImageIcon DevolverImagenesFantasmas(int IndiceImagen){return ListaFantasmas[IndiceImagen].ObtenerImagen();}
}
