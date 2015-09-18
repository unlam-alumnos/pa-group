package model;

public class Fantasma extends Personaje{
	
	private boolean bloqueado;
	
	public Fantasma() {
		super();
		this.bloqueado = false;
	}

	public void moverse(){
		
	}
	
	public void comer(Personaje pacman){
		
	}
	
	public void comer(Fruta fruta){
		
	}
	
	public void morir(){
		
	}
	
	public void chocar(){
		this.bloqueado = true;
	}
}
