package com.campominado.application.util;

public class Board {
	private int[][] table = new int[10][8];
	private int nBomb;
	
	public int[][] getTable() {
		return table;
	}

	public void setTable(int[][] table) {
		this.table = table;
	}

	public int getnBomb() {
		return nBomb;
	}

	public void setnBomb(int nBomb) {
		this.nBomb = nBomb;
	}
}
