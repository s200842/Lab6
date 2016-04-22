package it.polito.tdp.sudoku.model;

import java.util.*;

import javafx.scene.control.Label;

public class SudokuSolver {
	
	private int[][] scacchiera;
	private int[] valori;
	
	public SudokuSolver(){
		//Inizializzo scacchiera vuota
		scacchiera = new int [9][9];
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				scacchiera[i][j] = 0;
			}
		}
		//Imposto i valori utilizzabili
		valori = new int[9];
		for(int i=0; i<9; i++){
			valori[i] = i+1;
		}
	}
	
	public int[][] prepare(List<Label> labelList){
		int k = 0;
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				scacchiera[i][j] = Integer.parseInt(labelList.get(k).getText());
				k ++;
			}
		}	
		//Stampa il sudoku nella console
		/*System.out.println("Scacchiera di partenza: ");
		  for(int x=0; x<9; x++){
			for(int y=0; y<9; y++){
				System.out.print(scacchiera[x][y]+" ");
			}
			System.out.print("\n");
		}*/
		if(nextCell(0, 0)){
			System.out.println("Bella");
		}
		return scacchiera;
	}
	
	public boolean nextCell(int x, int y) {
		int nextX = x;
		int nextY = y;
		int[] toCheck = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;

		for (int i = top - 1; i > 0; i--) {
			current = r.nextInt(i);
			tmp = toCheck[current];
			toCheck[current] = toCheck[i];
			toCheck[i] = tmp;
		}

		for (int i = 0; i < toCheck.length; i++) {
			if (legalMove(x, y, toCheck[i])) {
				scacchiera[x][y] = toCheck[i];
				if (x == 8) {
					if (y == 8){
						return true;// We're done! Yay!
					}
					else { //Ultima riga ma non ultima colonna
						nextX = x;
						nextY = y + 1;
					}
				} else {//Non sei all'ultima riga
					if(y == 8){ //Ultima colonna, passa alla riga dopo
						nextX = x+1;
						nextY = 0;
					}
					else{
						nextX = x;
						nextY = y + 1;
					}
					
				}
				if (nextCell(nextX, nextY))
					return true;
			}
		}
		scacchiera[x][y] = 0;
		return false;
	}
	
	private boolean legalMove(int x, int y, int current) {
		for (int i = 0; i < 9; i++) {
			if (current == scacchiera[x][i])
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (current == scacchiera[i][y])
				return false;
		}
		int cornerX = 0;
		int cornerY = 0;
		if (x > 2)
			if (x > 5)
				cornerX = 6;
			else
				cornerX = 3;
		if (y > 2)
			if (y > 5)
				cornerY = 6;
			else
				cornerY = 3;
		for (int i = cornerX; i < 10 && i < cornerX + 3; i++)
			for (int j = cornerY; j < 10 && j < cornerY + 3; j++)
				if (current == scacchiera[i][j])
					return false;
		return true;
	}
	
	

}
