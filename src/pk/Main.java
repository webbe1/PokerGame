package pk;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter game data: ");
        //runs over each line for all the seperate games
        while(reader.hasNextLine()) {

            String player1 = "";
            String player2 = "";
            String game = "";
            String[] gamedata;
            ArrayList<Card> p1cards = new ArrayList<Card>();
            ArrayList<Card> p2cards = new ArrayList<Card>();
            PokerHand p1hand;
            PokerHand p2hand;

            game = reader.nextLine();
            gamedata = game.split(" "); //puts string into string array to separate
            player1 = gamedata[0].replace(":", ""); //player 1 name, removes the colon
            player2 = gamedata[7].replace(":", ""); //player 2 name, removes the colon
            //adds cards to player 1s hand
            p1cards.add(new Card(gamedata[1].charAt(0), gamedata[1].charAt(1)));
            p1cards.add(new Card(gamedata[2].charAt(0), gamedata[2].charAt(1)));
            p1cards.add(new Card(gamedata[3].charAt(0), gamedata[3].charAt(1)));
            p1cards.add(new Card(gamedata[4].charAt(0), gamedata[4].charAt(1)));
            p1cards.add(new Card(gamedata[5].charAt(0), gamedata[5].charAt(1)));
            //adds cards to player 2s hand
            p2cards.add(new Card(gamedata[8].charAt(0), gamedata[8].charAt(1)));
            p2cards.add(new Card(gamedata[9].charAt(0), gamedata[9].charAt(1)));
            p2cards.add(new Card(gamedata[10].charAt(0), gamedata[10].charAt(1)));
            p2cards.add(new Card(gamedata[11].charAt(0), gamedata[11].charAt(1)));
            p2cards.add(new Card(gamedata[12].charAt(0), gamedata[12].charAt(1)));
            //creates the hands
            p1hand = new PokerHand(p1cards);
            p2hand = new PokerHand(p2cards);
            //checks for winner
            if (p1hand.compareTo(p2hand) > 0) {
                System.out.println(player1 + " wins! With " + p1hand.stringHandValue());
            } else if (p1hand.compareTo(p2hand) < 0) {
                System.out.println(player2 + " wins! With " + p2hand.stringHandValue());
            } else {
                System.out.println("It's a tie");
            }
        }reader.close();




    }
}
