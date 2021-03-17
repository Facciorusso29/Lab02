package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	//private List <Word> dizionario;
	private List <WordEnhanced> dizionario;
	public AlienDictionary() {
		//dizionario = new ArrayList<Word>();
		dizionario = new ArrayList<WordEnhanced>();
	}
	public void clearDictionary () {
		dizionario.clear();
	}
	
	/*public void addWord(String alien, String trans) {
		Word w = new Word(alien);
		w.setTranslation(trans);
		if (dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslation(trans);
			return;
		}
		dizionario.add(w);
	
	}*/
	public void addWord(String alien, String trans) {
		WordEnhanced w = new WordEnhanced (alien);
		if (dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslation(trans);
			return;
		}
		w.setTranslation(trans);
		dizionario.add(w);
	
	}
	/*public String translateWord (String alienWord) {
		Word w = new Word(alienWord);
		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		return null;	
	}*/
	public String translateWord (String alienWord) {
		WordEnhanced w = new WordEnhanced (alienWord);
		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		return null;	
	}
	public String translateWordWildCard (String alienWord) {
		alienWord=alienWord.replace("?", ".");

		String s = "";

		for (WordEnhanced w : dizionario) {
			if (w.compareWild(alienWord)) {
				
				s+=w.getTranslation();
			}
		}
		
		if (s.equals(""))
			return null;
		else
			return s;
	}
}
