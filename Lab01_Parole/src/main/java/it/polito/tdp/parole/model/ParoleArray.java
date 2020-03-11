package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.*;
import java.util.List;

public class ParoleArray {

	ArrayList<String> listaParole = new ArrayList<String>();

	public ParoleArray() {
		// TODO
	}

	public void addParola(String p) {
		listaParole.add(p);
	}

	public List<String> getElenco() {

		ArrayList<String> listaParoleOrdinata = new ArrayList<String>(listaParole);
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
