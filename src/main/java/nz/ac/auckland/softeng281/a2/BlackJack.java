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

		// Task 2
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
			// Task 2
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

			//
			double playerGain=-player.makeABet();

			if (playerScore>21) {
				playerScore=0;
			}
			if (dealerScore>21) {
				dealerScore=0;
			}
			if ((playerScore==21)&&(dealerScore==playerScore)){
				System.out.println(player.getName() + " wins");

				//adding code for summing up the bets
				playerGain=playerGain+player.makeABet()*1.5;
			}
			if (playerScore>dealerScore) {
				System.out.println(player.getName() + " wins");
				// adding code for summing bets
			}
			if (playerScore==21) {
				System.out.println(player.getName() + " wins");
				//adding code for summing up the bets
				playerGain=playerGain+player.makeABet()*1.5;
			}


		}
	}



	public void printPlayerHighestGain() {
		// TODO Task 4

//		getHands() returns a list of Hands, you have to just scan the list, you can use a for loop 

//		getScore()
//		int playerOneBet=players.get(2).makeABet();
//
//		players.get(2).getHands().get(0).getScore();

//		The most important thing to recognise with this task is that the Participant class – and thus all the players – have a list of all the hands that that player has played.
//
//		Another key thing to recognise is that the length of the list in all players/dealer is the same. This makes sense as they all have all participated the same number of rounds. So for every hand played (in the list of Hands), you could possibly compare the player's hand and the dealer's hand to see if they win against the dealer or not.
//
//				As Hands have a bet property that tells us the amount the bot/player bet on a particular hand, it makes sense for us to keep track of the amount of chips that the player has won – where the player wins, add it to the "balance"; where the player loses; subtract.
//
//				Hopefully this helps a little

//		if
//		dealer.b
//		System.out.println("The player with the highest gain is: " + name + " with " + totalGain + " chips"); // UNCOMMENT AND KEEPTHIS
	}
}
