package com.eoi.becajava.deckGame;

import java.util.List;
import java.util.Scanner;

public class DeckGameApp {
	
	private static Deck deck;
	private static Deck stack = new Deck(null);
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		createDeck();
		
		showMenu();
		

	}
	
	private static void showMenu() {
		System.out.println("\nWhat do you want to do?\n1 - Shuffle\n2 - Next card\n3 - Cards left\n4 - Take n cards\n5 - Show stack\n6 - Show deck");
		try {
			dispatchMenu(sc.nextInt());
		} catch (EmptyDeckException e) {
			e.printStackTrace();
		}
	}

	static void createDeck()	{
		deck = new Deck();
	}
	
	static void dispatchMenu(int option) throws EmptyDeckException {
		switch(option) {
		case 1:
			deck.shuffle();
			System.out.println("Deck shuffled.\n");//TODO Exception emptyDeck;
			break;
		case 2:
			getCards(1);//TODO Exception emptyDeck
			break;
		case 3:
			cardsLeft();
			break;
		case 4:
			System.out.println("How many cards do you want?");
			getCards(sc.nextInt());
			break;
		case 5:
			stack.showDeck();//TODO Exception emptyDeck
			break;
		case 6:
			deck.showDeck();//TODO Exception emptyDeck
			break;
		}
		showMenu();
	}
	
	static void cardsLeft() {
		System.out.printf("You have %s cards left in the main deck.\n", deck.getDeck().size());
	}
	
	static void getCards(int n) {
		Card card=null;
		
		if(n==1) {
			card=deck.takeCard();
			stack.getDeck().add(card);
			
			System.out.printf("Next card was the %s\n", card.toString());
		}else {
			List<Card> sublist = deck.getDeck().subList(0, n);
			
			stack.getDeck().addAll(sublist);
			deck.getDeck().removeAll(sublist);
		}
	}

}
