package nz.ac.auckland.softeng281.a2;

import java.util.Random;

/**
 * you should change this class for TASK 1
 */
public class BotPlayer extends Participant {

	public BotPlayer(String name) {
		super(name);
	}

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
//		will this do between 0 incl and 100 excl?
		int randomInt = (1+(int)(100.0 * Math.random()));
		return randomInt; // FIXME
	}
}