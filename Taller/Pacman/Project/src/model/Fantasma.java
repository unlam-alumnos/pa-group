package model;

public class Fantasma extends Personaje{
	
	private boolean bloqueado;
	private int victimas;
	
	public Fantasma() {
		super();
		this.bloqueado = false;
	}

	public void moverse(){
		
	}
	
	public void comer(Personaje pacman){
		
		victimas++;
	}
	
	public void comer(Fruta fruta){
		
	}
	
	public void morir(){
		
	}
	
	public void chocar(){
		this.bloqueado = true;
	}
}
