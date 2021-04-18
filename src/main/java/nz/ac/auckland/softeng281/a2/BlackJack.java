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

            //
//			double playerGain=-player.makeABet();

            if (playerScore > 21) {
                playerScore = 0;
            }
            if (dealerScore > 21) {
                dealerScore = 0;
            }
            if ((playerScore == 21) && (dealerScore == playerScore)) {
                System.out.println(player.getName() + " wins");

                //adding code for summing up the bets
//				playerGain=playerGain+player.makeABet()*1.5;
            }
            if (playerScore > dealerScore) {
                System.out.println(player.getName() + " wins");
                // adding code for summing bets
//				playerGain=playerGain+player.makeABet();
            }
            if (playerScore == 21) {
                System.out.println(player.getName() + " wins");
                //adding code for summing up the bets
//				playerGain=playerGain+player.makeABet()*1.5;
            }


        }
    }

//    public void printPlayerHighestGain() {
//        Participant highest = players.get(0);
//
//        for (Participant player : players) {
//            if (highest.getTotalGain() > player.getTotalGain()) highest = highest;
//            else highest = player;
//        }
//
//        System.out.println("The player with the highest gain is: " + highest.getName() + " with " + highest.getTotalGain() + " chips");
////
//
//    }

    //helper method
    public double getPlayerGain(int playerScore, int dealerScore, double bet) {

        double playerGain = -bet;

        if (playerScore > 21) {
            playerScore = 0;
        }
        if (dealerScore > 21) {
            dealerScore = 0;
        }
        if ((playerScore == 21) && (dealerScore == playerScore)) {

            //adding code for summing up the bets
            playerGain = playerGain + bet * 1.5;
        }
        if (playerScore > dealerScore) {
            // adding code for summing bets
            playerGain = playerGain + bet;
        }
        if (playerScore == 21) {
            //adding code for summing up the bets
            playerGain = playerGain + bet * 1.5;
        }

        return playerGain;
    }

    public void printPlayerHighestGain() {
        // TODO Task 4
        double[] playerGains = {0, 0, 0};

        int handsPlayed = dealer.getHands().size();
        String[] names = {"Player1", "Bot1", "Bot2"};
        String winner = names[1];
        int x = 0;


        for (int c = 0; c < handsPlayed; c++) {
            x = 0;

            for (Participant player : players) {

                int playerScore = player.getHands().get(c).getScore();
                int dealerScore = dealer.getHands().get(c).getScore();

                //
                double bet = - player.getHands().get(c).getBet();

                playerGains[x] = playerGains[x] + getPlayerGain(playerScore, dealerScore, bet);
                x++;
            }

        }
        double[] playerGainsCopy = playerGains;

        double temp;
        for (int i = 0; i <= playerGains.length; i++) {
            for (int j = i + 1; j < playerGains.length; j++) {
                if (playerGains[i] > playerGains[j]) {
                    temp = playerGains[i];
                    playerGains[i] = playerGains[j];
                    playerGains[j] = temp;
                }
            }
        }
        double highestGain = playerGains[playerGains.length - 1];

        for (int i = 0; i < 3; i++) {
            if (playerGainsCopy[i] == highestGain) {
                winner = names[i];
            }
        }
        System.out.println("The player with the highest gain is: " + winner + " with " + highestGain + " chips");
    }
}