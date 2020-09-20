package com.skilldistillery.blackjack;

import java.util.Collections;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Deck;

public class Dealer extends Player{
	
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
		bJackHand = new BlackjackHand();
				
	}
	
	public void shuffle() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public void dealACard(Player player) {
		Card cardInPlay = deck.drawCard();
		player.addCardToHand(cardInPlay);
	}
	
	public void dealerShowHand() {
		System.out.println("Dealer" + bJackHand.toString() + "\nThe value is: " + bJackHand.getHandValue());
	}
	
	public void showDealerUpCard() {
		System.out.println("Dealer hand: [1 card down, " + bJackHand.cards.get(1) + "] " 
				+ "\nThe value is: " + bJackHand.cards.get(1).getValue());
	}
	
	
	

}
