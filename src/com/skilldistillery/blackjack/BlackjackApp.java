package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Player player1;
	private Dealer dealer;
	private Player winner = null;

	public static void main(String[] args) {
		BlackjackApp blackjackApp = new BlackjackApp();
		blackjackApp.launch();
	}

	private void launch() {
		player1 = new Player("Player 1");
		dealer = new Dealer("Dealer");
		startNewGame();
		player1.playerShowHand();
		dealer.showDealerUpCard();
		checkforBlackJack();
		if (winner == null) {
			playerTurn(player1);
		}
		if (winner == null) {
			dealerTurn(dealer);
		}
		checkForWinner();

	}

	private void checkForWinner() {
		if (winner != null) {
			System.out.println(winner + " Wins!!");
		}
		else {
			if (player1.bJackHand.getHandValue() > dealer.bJackHand.getHandValue()) {
				System.out.println("Player Wins!! House Loses!!");
			}
			else if (dealer.bJackHand.getHandValue() > player1.bJackHand.getHandValue()) {
				System.out.println("Sorry! Player Loses! House Wins!");
			}
			else {
				System.out.println("Player Pushes with House");
			}
		}
	}

	private void dealerTurn(Dealer dealer) {
		dealer.dealerShowHand();
		while (dealer.bJackHand.getHandValue() < 17) {
			System.out.println("Dealer hits!");
			dealer.dealACard(dealer);
			dealer.dealerShowHand();
		}
		if (dealer.bJackHand.getHandValue() > 17 && dealer.bJackHand.getHandValue() < 21) {
			System.out.println("I have over 17, so I'll stay");
		}
		if (checkForBust(dealer)) {
			winner = player1;
		}
	}

	private void playerTurn(Player player) {
		Scanner userInput = new Scanner(System.in);
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Please select your option: \n1.) Hit \n2.) Stay");
			String selection = userInput.next().toLowerCase();
			switch (selection) {
			case "1":
			case "hit":
				dealer.dealACard(player);
				player.playerShowHand();
				if (checkForBust(player)) {
					winner = dealer;
					keepGoing = false;
				}
				break;
			case "2":
			case "stay":
				keepGoing = false;
				break;
			}
		}
	}

	private boolean checkForBust(Player player) {
		if (player.bJackHand.isBust()) {
			System.out.println(player + " Bust! Game Over!");
			return true;
		}
		return false;
	}

	private void checkforBlackJack() {
		if (player1.bJackHand.isBlackjack() && dealer.bJackHand.isBlackjack()) {
			dealer.dealerShowHand();
			System.out.println("You and Dealer both have Blackjack! Push!");
		} else if (player1.bJackHand.isBlackjack()) {
			System.out.println("Blackjack!! You won!!");
			winner = player1;
		} else if (dealer.bJackHand.isBlackjack()) {
			dealer.dealerShowHand();
			System.out.println("Dealer has Blackjack! You lose!");
			winner = dealer;
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
