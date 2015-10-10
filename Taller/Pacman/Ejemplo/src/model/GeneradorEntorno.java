package model;


import javax.swing.*;
import java.awt.event.*;

public class GeneradorEntorno extends JFrame implements KeyListener{
    
    private final int PosicionXInicioFantasmas = 160;
    private final int PosicionYInicioFantasmas = 140;
    
    private int CantidadFantasmas = 1;
    private Laberinto LaberintoVirtual = new Laberinto();
    private JLabel[][] LaberintoGrafico = new JLabel[LaberintoVirtual.DevolverCantidadFilasLaberinto()][LaberintoVirtual.DevolverCantidadColumnasLaberinto(0)];
    private Usuario Pacman = new Usuario();
    private ControladorFantasmas ControlFantasmas;
    private JLabel ImagenesFantasmas[];
    private JLabel Usuario = new JLabel();
    private boolean PartidaTerminada = false;
    
    public GeneradorEntorno(int CantidadFantasmasNivel)
    {
        CantidadFantasmas = CantidadFantasmasNivel;
        
        setTitle("PACMAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        
        addKeyListener(this);
        
        //Genera los fantasmas e inicializa el controlador de los fantasmas
        CargarFantasmas();
        
        //Carga el Usuario
        CargarUsuario();
        
        //Genera el laberinto grafico a partir del Laberinto virtual
        GenerarLaberintoGrafico();
        
        /*
        this.requestFocus();
        try{Thread.sleep(1000);
        }catch(Exception e){}
        */
        EmpezarPartida();
    }
    
    private void CargarFantasmas()
    {
        ControlFantasmas = new ControladorFantasmas(CantidadFantasmas,PosicionXInicioFantasmas,PosicionYInicioFantasmas,LaberintoVirtual.DevolverLaberinto(),LaberintoVirtual.DevolverLargoImagenes(),LaberintoVirtual.DevolverAlturaImagenes());
        ImagenesFantasmas = new JLabel[CantidadFantasmas];
        
        for(int i = 0; i < CantidadFantasmas; i++)
        {
            ImagenesFantasmas[i] = new JLabel();
            ImagenesFantasmas[i].setIcon(ControlFantasmas.DevolverImagenesFantasmas(i));
            add(ImagenesFantasmas[i]);
        }
        for(int i = 0; i < CantidadFantasmas; i++)
        {
            ImagenesFantasmas[i].setBounds(PosicionXInicioFantasmas,PosicionYInicioFantasmas,ControlFantasmas.DevolverImagenesFantasmas(i).getIconWidth(),ControlFantasmas.DevolverImagenesFantasmas(i).getIconHeight());
            ImagenesFantasmas[i].validate();
        }
    }
    
    private void GenerarLaberintoGrafico()
    {
        for(int i = 0; i < LaberintoVirtual.DevolverCantidadFilasLaberinto(); i++)
        {
            for(int j = 0; j < LaberintoVirtual.DevolverCantidadColumnasLaberinto(i); j++)
            {
                LaberintoGrafico[i][j] = new JLabel();
                add(LaberintoGrafico[i][j]);
            	LaberintoGrafico[i][j].setIcon(new ImageIcon("Graficos/Laberinto/Laberinto GIF/" + LaberintoVirtual.DeolverCodigoImagenMatriz(i, j) + ".gif"));
            }
        }
        for(int i = 0; i < LaberintoVirtual.DevolverCantidadFilasLaberinto(); i++)
        {
            for(int j = 0; j < LaberintoVirtual.DevolverCantidadColumnasLaberinto(i); j++)
            {
            	LaberintoGrafico[i][j].setBounds(i*LaberintoVirtual.DevolverLargoImagenes(), j*LaberintoVirtual.DevolverAlturaImagenes(), LaberintoVirtual.DevolverLargoImagenes(), LaberintoVirtual.DevolverAlturaImagenes());
                LaberintoGrafico[i][j].validate();
            }
        }
    }
    
    private void CargarUsuario()
    {
        //Añade el Usuario al laberinto
        Pacman.EstablecerPosicionInicial(60, 80);
        Pacman.EstablecerLaberinto(LaberintoVirtual.DevolverLaberinto(), LaberintoVirtual.DevolverLargoImagenes(), LaberintoVirtual.DevolverAlturaImagenes());
        
        //Carga las posiciones del usuario
        Usuario.setIcon(Pacman.ObtenerImagen());
        Usuario.setBounds(Pacman.PosicionX,Pacman.PosicionY,20,20);
        add(Usuario);
        Usuario.validate();
    }
    
    public void EmpezarPartida()
    {
        Pacman.MoverPacman();
        ControlFantasmas.IniciarFantasmas();
        
        while(!PartidaTerminada)        //Bucle Principal
        {
            //Pinta el usuario
            Usuario.setIcon(Pacman.Imagen);
            Usuario.setBounds(Pacman.PosicionX,Pacman.PosicionY,20,20);
            Usuario.repaint();
            
            //Pinta los fantasmas y verifica si están detenidos, si lo están cambia su dirección
            for(int i = 0; i < CantidadFantasmas; i++)
            {
                ImagenesFantasmas[i].setBounds(ControlFantasmas.DevolverPosicionXFantasma(i),ControlFantasmas.DevolverPosicionYFantasma(i),ControlFantasmas.DevolverImagenesFantasmas(i).getIconWidth(),ControlFantasmas.DevolverImagenesFantasmas(i).getIconHeight());
            }
            
            ControlFantasmas.VerificarFantasmasDetenidos();
        }
    }
    
    ///////////////////////////////////////////////////
    //EVENTOS KEYLISTENER PARA LA ESCUCHA DEL TECLADO//
    ///////////////////////////////////////////////////
    
    public void keyTyped(KeyEvent e)
    {
        
    }
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case 37: //Izquierda
            {
                Pacman.Izquierda = false;
                break;
            }
            case 38: //Arriba
            {
                Pacman.Arriba = false;
                break;
            }
            case 39: //Derecha
            {
                Pacman.Derecha = false;
                break;
            }
            case 40: //Abajo
            {
                Pacman.Abajo = false;
                break;
            }
        }
    }
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case 37: //Izquierda
            {
                Pacman.Izquierda = true;
                break;
            }
            case 38: //Arriba
            {
                Pacman.Arriba = true;
                break;
            }
            case 39: //Derecha
            {
                Pacman.Derecha = true;
                break;
            }
            case 40: //Abajo
            {
                Pacman.Abajo = true;
                break;
            }
        }
    }
}