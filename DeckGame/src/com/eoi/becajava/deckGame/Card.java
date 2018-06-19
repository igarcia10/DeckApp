package com.eoi.becajava.deckGame;

public class Card {
	
	private int number;
	
	Suits suit;
	
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		switch(suit) {
		case 0:
			this.suit=Suits.Hearts;
			break;
		case 1:
			this.suit=Suits.Clubs;
			break;
		case 2:
			this.suit=Suits.Diamonds;
			break;
		case 3:
			this.suit=Suits.Spades;
			break;
		default:
			break;
		}

	}

	public Card(int number, int suit){
		this.number=number;
		setSuit(suit);
			}
	
	private enum Suits {
		Hearts, Clubs, Diamonds, Spades;
	}

	@Override
	public String toString() {
		
		return number+" of "+suit;
	}
	
	

}
