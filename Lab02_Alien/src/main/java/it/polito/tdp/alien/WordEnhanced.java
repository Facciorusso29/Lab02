package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	private String alienWord;
	private List <String> translation;
	
	public String getAlienWord() {
		return alienWord;
		
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		String r="";
		for(String s: translation)
			r+=s+"\n";
		if(r.equals(""))
			return null;
			else 
				return r;
	}

	public void setTranslation (String translation) {

			if( !this.translation.contains(translation)) {
				this.translation.add(translation);
			}
		
	}
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translation= new ArrayList<>();
	}
	public boolean compareWild (String w) {
		if(this.alienWord.matches(w))
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
	
	
	
}
