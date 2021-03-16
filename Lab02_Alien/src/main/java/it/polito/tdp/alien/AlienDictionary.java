package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private List <Word> dizionario;
	
	public AlienDictionary() {
		dizionario = new ArrayList<Word>();
	}
	public void clearDictionary () {
		dizionario.clear();
	}
	
	public void addWord(String alien, String trans) {
		Word w = new Word(alien);
		w.setTranslation(trans);
		if (dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslation(trans);
			return;
		}
		dizionario.add(w);
	
	}
	public String translateWord (String alienWord) {
		Word w = new Word(alienWord);
		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		return null;	
	}
}
