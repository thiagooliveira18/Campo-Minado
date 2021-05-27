package com.campominado.application.util;

import java.util.Random;

public class Position {
	Random rnd = new Random();
	
	private int posi;
	private int posj;
	
	public Position() {

	}
	
	public void setPosi(int posi) {
		this.posi = posi;
	}

	public void setPosj(int posj) {
		this.posj = posj;
	}

	public int getPosi() {
		return posi;
	}
	
	public int getPosj() {
		return posj;
	}

	//Gera uma posição de 'i' aleatoria
	public int posi(int i) {
		i=rnd.nextInt(20);
		return i;
	}
	
	//Gera uma posição de 'j' aleatoria
	public int posj(int j) {
		j = rnd.nextInt(16);
		return j;
	}
	
	
}
