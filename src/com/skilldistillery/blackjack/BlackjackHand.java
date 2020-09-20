package com.skilldistillery.blackjack;

import java.io.ObjectInputStream.GetField;

import com.skilldistillery.common.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21 && cards.size() == 2) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}

}
