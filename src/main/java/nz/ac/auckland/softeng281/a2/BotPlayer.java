package nz.ac.auckland.softeng281.a2;

import java.util.Random;

/**
 * you should change this class for TASK 1
 */
public class BotPlayer extends Participant {

	public BotPlayer(String name) {
		super(name);
	}
//	public int bet;

	@Override
	public Action decideAction() {
		// TODO
		int value = getCurrentHand().getScore();

		if (value<17)
			return Action.HIT;
		else
			return Action.HOLD;

//		wtf does this mean luv
//		return new Random().nextBoolean() ? Action.HIT : Action.HOLD; // FIXME
	}

	@Override
	public int makeABet() {
		int randomBet = (1+(int)(100.0 * Math.random()));
//		this.bet=randomBet;
		return randomBet; // FIXME
	}

//	public int getBet() {
//		return bet;
//	}
}
