package com.eoi.becajava.deckGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	
	
	
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public Deck() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<12; j++) {
				if(j+1!=8 && j+1!=9) {
					deck.add(new Card(j+1,i));
				}
			}
		}
	}
	
	public Deck(Object o) {
		
	}
	
	public void showDeck() {
		for (Card card : deck) {
			System.out.println(card.toString());
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card takeCard() {
		Card card = null;
		
		card=deck.get(0);
		deck.remove(0);
		
		return card;
	}

}
