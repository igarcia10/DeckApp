package com.eoi.becajava.deckGame;

public class EmptyDeckException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void printStackTrace() {
		
		System.out.println("The deck is empty.");
	}
	
	

}
