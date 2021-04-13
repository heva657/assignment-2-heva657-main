package nz.ac.auckland.softeng281.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * you should change this class for TASK 1, 2, 3, 4.
 */
public class BlackJack {

	private List<Participant> players;
	private Participant dealer;

	public BlackJack() {
		players = new ArrayList<>();



		// FIXME Task 2
		players.add(new HumanPlayer("Player1"));
		players.add(new BotPlayer("Bot1"));
		players.add(new BotPlayer("Bot2"));
		dealer = new BotDealer("Dealer", players);
	}

	// getter setter for testing purposes
	public List<Participant> getPlayers() {
		return players;
	}

	public Participant getDealer() {
		return dealer;
	}

	public void setPlayers(List<Participant> players) {
		this.players = players;
	}

	public void setDealer(Participant dealer) {
		this.dealer = dealer;
	}

	public static void main(String[] args) {
		BlackJack game = new BlackJack();
		game.start();
	}

	protected void start() {
		Utils.printBlackJack();
		// create a new deck of cards
		Deck deck = new Deck();
		String result;
		do {
			for (Participant player : players) {
				player.play(deck);
			}
			// ADDHERE Task 2
			dealer.play(deck);
			checkWinner();
			System.out.println("Do you want to play again?");
			result = Utils.scanner.next();
			while (!result.equals("yes") && !result.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				result = Utils.scanner.next();
			}
		} while (result.equals("yes"));
		printPlayerHighestGain();
	}

	public void checkWinner() {
		// TODO Task 3
		for (Participant player : players) { // KEEPTHIS
			// ADDHERE
			int playerScore = player.getCurrentHand().getScore();
			int dealerScore = dealer.getCurrentHand().getScore();

			if (playerScore>21) {
				playerScore=0;
			}
			if (dealerScore>21) {
				dealerScore=0;
			}
			if ((playerScore==21)&&(dealerScore==playerScore)){
				System.out.println(player.getName() + " wins");
			}
			if (playerScore>dealerScore) {
				System.out.println(player.getName() + " wins");
			}
//			else if ()

		}
	}

	public void printPlayerHighestGain() {
		// TODO Task 4
		// System.out.println("The player with the highest gain is: " + name + " with "
		// + totalGain + " chips"); // UNCOMMENT AND KEEPTHIS
	}
}
