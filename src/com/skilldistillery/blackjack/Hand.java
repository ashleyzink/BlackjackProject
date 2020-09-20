package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.common.cards.Card;

public abstract class Hand {
	
	protected List<Card> cards;
	
	public Hand() {
		this.cards = new ArrayList<Card>();
	}

	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	public void addCard (Card card) {
		cards.add(card);		
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" hand: ");
		builder.append(cards);
//		builder.append("]");
		return builder.toString();
	}
	

}
