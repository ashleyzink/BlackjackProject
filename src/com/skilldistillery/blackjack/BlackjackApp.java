package com.skilldistillery.blackjack;

public class BlackjackApp {
	private Player player1;
	private Dealer dealer;

	public static void main(String[] args) {
		BlackjackApp blackjackApp = new BlackjackApp();
		blackjackApp.launch();
	}

	private void launch() {
		player1 = new Player();
		// Msg to player for input when they sit down
		dealer = new Dealer();
		startNewGame();
		player1.playerShowHand();
		dealer.showDealerUpCard();
		checkforBlackJack();
		
//		dealer.dealerShowHand();

	}

	private void checkforBlackJack() {
		if (player1.bJackHand.isBlackjack() && dealer.bJackHand.isBlackjack()) {
			dealer.dealerShowHand();
			System.out.println("You and Dealer both have Blackjack! Push!");
		} else if (player1.bJackHand.isBlackjack()) {
			System.out.println("Blackjack!! You won!!");
		} else if (dealer.bJackHand.isBlackjack()) {
			dealer.dealerShowHand();
			System.out.println("Dealer has Blackjack! You lose!");
		}
	}

	private void startNewGame() {
		dealer.shuffle();
		initialDeal();
	}

	private void initialDeal() {
		dealer.dealACard(player1);
		dealer.dealACard(dealer);
		dealer.dealACard(player1);
		dealer.dealACard(dealer);
	}

}
