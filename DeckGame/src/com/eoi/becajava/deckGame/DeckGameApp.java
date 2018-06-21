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
		System.out.println("\nWhat do you want to do?\n\n1 - Shuffle\n2 - Next card\n3 - Cards left\n4 - Take n cards\n5 - Show stack\n6 - Show deck\n7 - Quit");
		try {
			dispatchMenu(sc.nextInt());
		} catch (EmptyDeckException e) {
			System.out.println(e.getMessage());
			showMenu();
		}
	}

	static void createDeck()	{
		deck = new Deck();
	}
	
	static void dispatchMenu(int option) throws EmptyDeckException {
		int quit=0;
		
		switch(option) {
		case 1:
			deck.shuffle();
			System.out.println("Deck shuffled.\n");
			break;
		case 2:
			getCards(1);
			break;
		case 3:
			cardsLeft();
			break;
		case 4:
			System.out.println("How many cards do you want?");
			getCards(sc.nextInt());
			break;
		case 5:
			stack.showDeck();
			break;
		case 6:
			deck.showDeck();
			break;
		case 7:
			System.out.println("Good bye!");
			quit=1;
			break;
		}
		if(quit==0) {
			showMenu();
		}
	}
	
	static void cardsLeft() {
		System.out.printf("You have %s cards left in the main deck.\n", deck.getDeck().size());
	}
	
	static void getCards(int n) throws EmptyDeckException {
		Card card=null;
		
		if(deck.getDeck().size()<n) {
			throw new EmptyDeckException("You don't have enough cards left.");
		}else {
			
			if(n==1) {
				card=deck.takeCard();
				stack.getDeck().add(card);
				
				System.out.printf("Next card was the %s\n", card.toString());
			}else {
				List<Card> sublist = deck.getDeck().subList(0, n);
				
				System.out.println("Next cards were :\n");
				for (Card nextCard : sublist) {
					System.out.println(nextCard.toString());
				}
				
				stack.getDeck().addAll(sublist);
				deck.getDeck().removeAll(sublist);
			}
			
		}
	}

}
