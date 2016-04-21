package it.polito.tdp.sudoku.model;

import java.util.*;

import javafx.scene.control.Label;

public class SudokuSolver {
	
	private Scacchiera layout;
	private List<Integer> valori;
	private List<Scacchiera> tutte;
	
	public SudokuSolver(){
		layout = new Scacchiera();
		tutte = new ArrayList<Scacchiera>();
		valori = new ArrayList<Integer>();
		for(int i=1; i<=9; i++){
			valori.add(i);
		}
	}
	
	public List<Scacchiera> prepare(List<Label> labelList){
		int i = 0;
		for(Posizione p : layout.getPosizioniValide()){
			layout.getScacchiera().put(p, Integer.parseInt(labelList.get(i).getText()));
			i ++;
		}
		//Stampa il sudoku nella console
		/*System.out.println(Scacchiera di partenza: ");
		 * for(int x=1; x<=9; x++){
			for(int y=1; y<=9; y++){
				System.out.print(layout.getScacchiera().get(new Posizione(x,y))+" ");
			}
			System.out.print("\n");
		}
		solve(layout, valori, 0);*/
		return tutte;
	}
	
	
	// Struttura di un algoritmo ricorsivo generico
	void recursive (/*... , level*/) {
		/*// E -- sequenza di istruzioni che vengono eseguite sempre
		// Da usare solo in casi rari (es. Ruzzle)
		doAlways();
		// A
		if (condizione di terminazione) {
			//doSomething;
			return;
		}
		// Potrebbe essere anche un while ()
		for () {
			// B
			generaNuovaSoluzioneParziale;
			if (filtro) { // C
				recursive (..., level + 1);
			}
			// D
			backtracking;
		}*/
	}
	
	public boolean mossaValida(int i, Posizione p, Scacchiera layout){
		int x = p.getX();
		int y = p.getY();
		//Controllo se sulla riga ho lo stesso numero
		for(int c=1; c<=9; c++){
			if(layout.getScacchiera().get(new Posizione(x, c)) == i){
				return false;
			}
		}
		//Controllo sulla colonna
		for(int r=1; r<=9; r++){
			if(layout.getScacchiera().get(new Posizione(r, y)) == i){
				return false;
			}
		}
		//Controllo il quadrato di riferimento
		if(x<=3){
			//Primo blocco orizzontale
			if(y<=3){
				//Primo quadrato
				for(int j=1; j<=3; j++){
					for(int k=1; k<=3; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
			else if(y>3 && y>=6){
				//secondo quadrato
				for(int j=1; j<=3; j++){
					for(int k=4; k<=6; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
			else{
				//Terzo quadrato
				for(int j=1; j<=3; j++){
					for(int k=7; k<=9; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
		}
		else if(x>3 && x<=6){
			//secondo blocco orizzontale
			if(y<=3){
				//Primo quadrato
				for(int j=4; j<=6; j++){
					for(int k=1; k<=3; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
			else if(y>3 && y>=6){
				//secondo quadrato
				for(int j=4; j<=6; j++){
					for(int k=4; k<=6; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
			else{
				//Terzo quadrato
				for(int j=4; j<=6; j++){
					for(int k=7; k<=9; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
		}
		else{
			//Terzo blocco orizzontale
			if(y<=3){
				//Primo quadrato
				for(int j=7; j<=9; j++){
					for(int k=1; k<=3; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
			else if(y>3 && y>=6){
				//secondo quadrato
				for(int j=7; j<=9; j++){
					for(int k=4; k<=6; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
			else{
				//Terzo quadrato
				for(int j=7; j<=9; j++){
					for(int k=7; k<=9; k++){
						if(layout.getScacchiera().get(new Posizione(j, k)) == i){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	

}
