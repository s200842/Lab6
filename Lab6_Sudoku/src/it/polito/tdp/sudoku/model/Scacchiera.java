package it.polito.tdp.sudoku.model;

import java.util.*;

public class Scacchiera {
	
	private Map<Posizione, Integer> scacchiera;
	private List<Posizione> posizioniValide;
	
	public Scacchiera(){
		scacchiera = new HashMap<Posizione, Integer>();
		posizioniValide = new ArrayList<Posizione>();
		for(int x=1; x<=9; x++){
			for(int y=1; y<=9; y++){
				Posizione p = new Posizione(x, y);
				posizioniValide.add(p);
				scacchiera.put(p, 0);
			}
		}
	}
	
	public Map<Posizione, Integer> getScacchiera() {
		return scacchiera;
	}

	public List<Posizione> getPosizioniValide() {
		return posizioniValide;
	}

}
