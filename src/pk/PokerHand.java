package pk;
import java.util.*;

/**
 * Created by Eric on 5/15/2017.
 */
public class PokerHand implements Comparable<PokerHand>{
    private ArrayList<Card> pokerhand;
    private int[] values;
    private String[] suits;
    private int handValue;
    private final int STRAIGHTFLUSH = 8;
    private final int FOUROFAKIND = 7;
    private final int FULLHOUSE = 6;
    private final int FLUSH = 5;
    private final int STRAIGHT = 4;
    private final int THREEOFAKIND = 3;
    private final int TWOPAIR = 2;
    private final int PAIR = 1;
    private final int HIGHCARD = 0;
    private int highcard;
    private int fullhousehigh;
    private int fullhouselow;
    private String flushsuit;
    private int highpair;
    private int lowpair;

    public PokerHand(ArrayList<Card> hand) {
        pokerhand = hand;
        values = cardValues();
        suits = cardSuits();


        Arrays.sort(values);
        Arrays.sort(suits);
        highcard = values[4];
        handValue = getHandValue();
    }

    public ArrayList<Card> cards() {
        return pokerhand;
    }

    private int[] cardValues(){
        int[] cv = new int[5];

        for (int i = 0; i < pokerhand.size(); i++) {
            cv[i] = pokerhand.get(i).getValue();
        }

        return cv;
    }

    private String[] cardSuits() {
        String[] cs = new String[5];

        for (int i = 0; i < pokerhand.size(); i++) {
            cs[i] = pokerhand.get(i).getSuit();
        }

        return cs;
    }

    public int getHandValue(){
        if(checkStraightFlush()){
            return STRAIGHTFLUSH;
        }else if(check4ofKind()){
            return FOUROFAKIND;
        }else if(checkFullHouse()){
            return FULLHOUSE;
        }else if(checkFlush()){
            return FLUSH;
        }else if(checkStraight()){
            return STRAIGHT;
        }else if(check3ofKind()){
            return THREEOFAKIND;
        }else if(check2Pair()){
            return TWOPAIR;
        }else if(checkPair()){
            return PAIR;
        }
        return HIGHCARD;
    }

    public String stringHandValue(){
        String valuestring = "";
        String highcardstring = "";
        String highpairstring = "";
        String lowpairstring = "";
        if(highcard >= 2 && highcard <= 10){
            highcardstring = Integer.toString(highcard);
        }else if(highcard == 11){
            highcardstring = "Jack";
        }else if(highcard == 12){
            highcardstring = "Queen";
        }else if(highcard == 13){
            highcardstring = "King";
        }else{
            highcardstring = "Ace";
        }

        if(highpair >= 2 && highpair <= 10){
            highpairstring = Integer.toString(highpair);
        }else if(highpair == 11){
            highpairstring = "Jack";
        }else if(highpair == 12){
            highpairstring = "Queen";
        }else if(highpair == 13){
            highpairstring = "King";
        }else{
            highpairstring = "Ace";
        }

        if(lowpair >= 2 && lowpair <= 10){
            lowpairstring = Integer.toString(lowpair);
        }else if(lowpair == 11){
            lowpairstring = "Jack";
        }else if(lowpair == 12){
            lowpairstring = "Queen";
        }else if(lowpair == 13){
            lowpairstring = "King";
        }else{
            lowpairstring = "Ace";
        }
        if(getHandValue() == STRAIGHTFLUSH){
            return "Straight Flush in " + flushsuit + " with High Card " + highcardstring;
        }else if(getHandValue() == FOUROFAKIND){
            return "Four of a Kind in " + highpairstring + "s";
        }else if(getHandValue() == FULLHOUSE){
            return "Full House: " + highpairstring + " over " + lowpairstring;
        }else if(getHandValue() == FLUSH){
            return "Flush in " + flushsuit;
        }else if(getHandValue() == STRAIGHT){
            return "Straight with High Card " + highcardstring;
        }else if(getHandValue() == THREEOFAKIND){
            return "Three of a Kind in " + highpairstring + "s";
        }else if(getHandValue() == TWOPAIR){
            return "Two Pair in " + highpairstring + "s and " + lowpairstring + "s";
        }else if(getHandValue() == PAIR){
            return "Pair of " + highpairstring + "s";
        }else if(getHandValue() == HIGHCARD){
            return "High Card " + highcardstring;
        }
        return "High Card";
    }


    public boolean checkFlush(){
        if((suits[0].equals(suits[1])) && (suits[0].equals(suits[2])) && (suits[0].equals(suits[3])) && (suits[0].equals(suits[4]))){
            flushsuit = suits[0];
            return true;
        }
        return false;
    }

    public boolean checkStraight(){
        boolean check = false;
        for(int x = 0; x < values.length - 1; x++){
            if(values[x] == values[x+1] - 1){
                check = true;
            }else{
                return false;
            }
        }
        return check;
    }

    public boolean checkStraightFlush(){
        if(checkFlush() && checkStraight()){
            return true;
        }
        return false;
    }

    public boolean check4ofKind(){
        for(int x = 0; x < values.length - 3; x++){
            if(values[x] == values[x+1] && values[x] == values[x+2] && values[x] == values[x+3]){
                highpair = values[x];
                return true;
            }
        }
        return false;
    }

    public boolean check3ofKind(){
        for (int x = 0; x < values.length - 2; x++) {
            if (values[x] == values[x + 1] && values[x] == values[x + 2]) {
                highpair = values[x];
                return true;
            }
        }
        return false;
    }
    public boolean checkPair(){
        for (int x = 0; x < values.length - 1; x++) {
            if (values[x] == values[x + 1]) {
                highpair = values[x];
                return true;
            }
        }
        return false;
    }

    public boolean check2Pair(){
        int count = 0;
        for (int x = 0; x < values.length - 1; x++) {
            if (values[x] == values[x + 1]) {
                count++;
                if(count == 2) {
                    highpair = values[4];
                    lowpair = values[2];
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkFullHouse(){
        if(values[0] == values[1] && values[0] == values[2]){
            if(values[3] == values[4]){
                highpair = values[0];
                lowpair = values[3];
                return true;
            }
        }else if(values[2] == values[3] && values[2] == values[4]){
            if(values[0] == values[1]) {
                highpair = values[2];
                lowpair = values[0];
                return true;
            }
        }
        return false;

    }

    public int compareTo(PokerHand ph){
        int firsthand = this.getHandValue();
        int secondhand = ph.getHandValue();

        if(firsthand > secondhand){
            return 1;
        }else if(secondhand > firsthand){
            return -1;
        }else if(firsthand == secondhand){
            for(int i = 4; i >= 0; i--){
                if(this.values[i] > ph.values[i]){
                    return 1;
                }else if(ph.values[i] > this.values[i]){
                    return -1;
                }
            }
        }
        return 0;
    }

    public String toString(){
        String result = "";
        result += pokerhand.get(0).toString();

        for (int i = 1; i < 5; i++) {
            result += ", "+ pokerhand.get(i).toString();
        }

        return result;
    }

}
