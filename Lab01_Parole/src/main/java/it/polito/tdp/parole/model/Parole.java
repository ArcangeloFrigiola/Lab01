package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.*;
import java.util.List;

public class Parole {
		
	LinkedList<String> listaParole = new LinkedList<String>();
	
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		
		LinkedList<String> listaParoleOrdinata = new LinkedList<String>(listaParole);
		Collections.sort(listaParoleOrdinata);
		return listaParoleOrdinata;
	}
	
	public void reset() {
		listaParole.clear();
	}

	public void cancellaParola(String p) {
		listaParole.remove(p);
	}

}
