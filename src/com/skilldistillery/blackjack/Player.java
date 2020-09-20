package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;

public class Player {
	
	protected BlackjackHand bJackHand;
	
	public Player() {
		bJackHand = new BlackjackHand();
				
	}
	public void addCardToHand(Card cardInPlay) {
		bJackHand.addCard(cardInPlay);
		bJackHand.getHandValue();
		//Separate bJackHand.getHandValue() from sysout after card. Create totalValue() to be able to 
		//Separate all of players value vs dealers value exposed. 
//		System.out.println(cardInPlay + " Your value is: " + bJackHand.getHandValue());
	}
	
	public void playerShowHand() {
		bJackHand.toString();
		System.out.println("Player 1" + bJackHand.toString() + "\nThe value is: " + bJackHand.getHandValue());
	}

}
