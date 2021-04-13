package nz.ac.auckland.softeng281.a2;

import java.util.List;
import java.util.Random;

/**
 * you should change this class for TASK 2
 */
public class BotDealer extends Participant {

	private List<Participant> players;

	public BotDealer(String name, List<Participant> players) {
		super(name);
		this.players=players;


// ADDHERE

	}

	@Override
	public Action decideAction() {
		// TODO


		int playerOne = players.get(0).getCurrentHand().getScore();
		int botOne = players.get(1).getCurrentHand().getScore();
		int botTwo = players.get(2).getCurrentHand().getScore();
		int dealerScore = getCurrentHand().getScore();


//		if ((dealerScore>(playerOne+botOne+botTwo)/3)) {
//			return Action.HOLD;
//		}
		if (playerOne>21) {
			playerOne=0;
		}
		if (botOne>21) {
			botOne=0;
		}
		if (botTwo>21) {
			botTwo=0;
		}
		if (dealerScore>21) {
			dealerScore=0;
		}

		if (((playerOne+botOne)/2>dealerScore)||((playerOne+botTwo)/2>dealerScore)||((botTwo+botOne)/2>dealerScore)) {
			return Action.HIT;
		}
		else {
			return Action.HOLD;
		}

	}

	@Override
	/**
	 * do not touch this method
	 */
	public int makeABet() {
		// the Dealer doesn't bet so is always zero
		return 0;
	}
}
