package it.polito.tdp.sudoku.model;

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
	
	public int[][] prepare(int[][] matrice){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				scacchiera[i][j] = matrice[i][j];
			}
		}	
		//Stampa il sudoku nella console
		System.out.println("Scacchiera di partenza: ");
		  for(int x=0; x<9; x++){
			for(int y=0; y<9; y++){
				System.out.print(scacchiera[x][y]+" ");
			}
			System.out.print("\n");
		}
		solve(0, 0);
		return scacchiera;
	}
	
	public boolean solve (int x, int y) {
		int nextX = x;
		int nextY = y;
		//Per ogni numero disponibile, controllo se posso inserirlo in (x,y)
		if(scacchiera[x][y] == 0){
			for(int i=0; i<valori.length; i++){
				if(mossaValida(valori[i], x, y)){
					scacchiera[x][y] = valori[i];
					//Controllo se sono alla fine
					if (x == 8) {
						if (y == 8){
							return true;
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
						else{//Non è l'ultima colonna, prosegui alla colonna dopo
							nextX = x;
							nextY = y + 1;
						}
					}
					if(solve(nextX, nextY)){
						return true;
					}
				}
			}
			scacchiera[x][y] = 0;
			return false;
		}
		else{
			//Ho già un valore
			if (x == 8) {
				if (y == 8){
					return true;
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
				else{//Non è l'ultima colonna, prosegui alla riga dopo
					nextX = x;
					nextY = y + 1;
				}
			}
			if(solve(nextX, nextY)){
				return true;
			}
			else return false;
		}
	}
	
	public boolean mossaValida(int i, int x, int y){
		//Controllo se sulla riga ho lo stesso numero
		for(int c=0; c<9; c++){
			if(scacchiera[x][c] == i){
				return false;
			}
		}
		//Controllo sulla colonna
		for(int r=0; r<9; r++){
			if(scacchiera[r][y] == i){
				return false;
			}
		}
		//Controllo il quadrato di riferimento
		int latoX = 0;
		int latoY = 0;
		//Determino il quadrato in cui mi trovo
		if(x > 2){
			if(x > 5){
				latoX = 6;
			}
			else{
				latoX = 3;
			}
		}
		if(y > 2){
			if(y > 5){
				latoY = 6;
			}
			else{
				latoY = 3;
			}
		}
		//Controllo il quadrato
		for(int j=latoX; j < 10 && j < latoX+3; j++){
			for(int k=latoY; k < 10 && k < latoY+3; k++){
				if(scacchiera[j][k] == i){
					return false;
				}
			}
		}
		
		return true;
	}
	
	

}
