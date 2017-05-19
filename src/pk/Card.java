package pk;

/**
 * Created by Eric on 5/15/2017.
 */
public class Card implements Comparable<Card> {
    private int value;
    private String suit;

    public Card(char v, char s){
        if(v == '2'){
            value = 2;
        }else if(v == '3'){
            value = 3;
        }else if(v == '4'){
            value = 4;
        }
        else if(v == '5'){
            value = 5;
        }
        else if(v == '6'){
            value = 6;
        }
        else if(v == '7'){
            value = 7;
        }
        else if(v == '8'){
            value = 8;
        }
        else if(v == '9'){
            value = 9;
        }
        else if(v == 'T'){
            value = 10;
        }
        else if(v == 'J'){
            value = 11;
        }else if(v == 'Q'){
            value = 12;
        }else if(v == 'K'){
            value = 13;
        }else if(v == 'A'){
            value = 14;
        }

        if(s == 'C'){
            suit = "Clubs";
        }else if(s == 'H'){
            suit = "Hearts";
        }else if(s == 'D'){
            suit = "Diamonds";
        }else if(s == 'S'){
            suit = "Spades";
        }
    }

    public String getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public String stringValue(){
        String valuestring = "";

        switch(value){
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return "?";
        }

    }

    public String toString() {
        return stringValue() + " of " + getSuit();
    }

    public boolean equals(Card c) {
        boolean result = false;

        if (this.getValue() == c.getValue()) {
            result = true;
        }

        return result;
    }

    public int compareTo(Card c) {
        int result = 0;

        if (this.getValue() > c.getValue()) {
            result = 1;
        } else if (c.getValue() > this.getValue()) {
            result = -1;
        }

        return result;
    }


}
