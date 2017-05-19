package pk;
import org.junit.Test;
import static junit.framework.Assert.*;
import java.util.*;
/**
 * Created by Eric on 5/15/2017.
 */
public class PokerHandTest{
    private ArrayList<Card> straightFlushCards;
    private ArrayList<Card> fourOfAKindCards;
    private ArrayList<Card> fullHouseCards;
    private ArrayList<Card> flushCards;
    private ArrayList<Card> straightCards;
    private ArrayList<Card> threeOfAKindCards;
    private ArrayList<Card> twoPairCards;
    private ArrayList<Card> pairCards;
    private ArrayList<Card> highCardCards;

    private PokerHand straightFlush;
    private PokerHand fourOfAKind;
    private PokerHand fullHouse;
    private PokerHand flush;
    private PokerHand straight;
    private PokerHand threeOfAKind;
    private PokerHand twoPair;
    private PokerHand pair;
    private PokerHand highCard;

    public PokerHandTest(){

        highCardCards = new ArrayList<Card>();
        pairCards = new ArrayList<Card>();
        twoPairCards = new ArrayList<Card>();
        threeOfAKindCards = new ArrayList<Card>();
        straightCards = new ArrayList<Card>();
        flushCards = new ArrayList<Card>();
        fullHouseCards = new ArrayList<Card>();
        fourOfAKindCards = new ArrayList<Card>();
        straightFlushCards = new ArrayList<Card>();

        //creates different hands that contain each of the outcomes
        highCardCards.add(new Card('3', 'C'));
        highCardCards.add(new Card('4', 'S'));
        highCardCards.add(new Card('8', 'H'));
        highCardCards.add(new Card('9', 'D'));
        highCardCards.add(new Card('A', 'S'));

        pairCards.add(new Card('4', 'C'));
        pairCards.add(new Card('4', 'S'));
        pairCards.add(new Card('8', 'H'));
        pairCards.add(new Card('9', 'D'));
        pairCards.add(new Card('A', 'S'));

        twoPairCards.add(new Card('4', 'C'));
        twoPairCards.add(new Card('4', 'S'));
        twoPairCards.add(new Card('9', 'H'));
        twoPairCards.add(new Card('9', 'D'));
        twoPairCards.add(new Card('A', 'S'));

        threeOfAKindCards.add(new Card('4', 'C'));
        threeOfAKindCards.add(new Card('4', 'S'));
        threeOfAKindCards.add(new Card('4', 'H'));
        threeOfAKindCards.add(new Card('9', 'D'));
        threeOfAKindCards.add(new Card('A', 'S'));

        straightCards.add(new Card('4', 'C'));
        straightCards.add(new Card('5', 'S'));
        straightCards.add(new Card('6', 'H'));
        straightCards.add(new Card('7', 'D'));
        straightCards.add(new Card('8', 'S'));

        flushCards.add(new Card('3', 'C'));
        flushCards.add(new Card('4', 'C'));
        flushCards.add(new Card('8', 'C'));
        flushCards.add(new Card('9', 'C'));
        flushCards.add(new Card('A', 'C'));

        fullHouseCards.add(new Card('4', 'C'));
        fullHouseCards.add(new Card('4', 'S'));
        fullHouseCards.add(new Card('8', 'H'));
        fullHouseCards.add(new Card('8', 'D'));
        fullHouseCards.add(new Card('8', 'S'));

        fourOfAKindCards.add(new Card('4', 'C'));
        fourOfAKindCards.add(new Card('4', 'S'));
        fourOfAKindCards.add(new Card('4', 'H'));
        fourOfAKindCards.add(new Card('4', 'D'));
        fourOfAKindCards.add(new Card('A', 'S'));

        straightFlushCards.add(new Card('4', 'S'));
        straightFlushCards.add(new Card('5', 'S'));
        straightFlushCards.add(new Card('6', 'S'));
        straightFlushCards.add(new Card('7', 'S'));
        straightFlushCards.add(new Card('8', 'S'));

        highCard = new PokerHand(highCardCards);
        pair = new PokerHand(pairCards);
        twoPair = new PokerHand(twoPairCards);
        threeOfAKind = new PokerHand(threeOfAKindCards);
        straight = new PokerHand(straightCards);
        flush = new PokerHand(flushCards);
        fullHouse = new PokerHand(fullHouseCards);
        fourOfAKind = new PokerHand(fourOfAKindCards);
        straightFlush = new PokerHand(straightFlushCards);
    }
    @Test
    public void testPair() {
        assertEquals(true, pair.checkPair());
        assertEquals(false, highCard.checkPair());
    }
    @Test
    public void testTwoPair(){
        assertEquals(true, twoPair.check2Pair());
        assertEquals(false, highCard.check2Pair());

    }
    @Test
    public void test3ofKind(){
        assertEquals(true, threeOfAKind.check3ofKind());
        assertEquals(false, highCard.check3ofKind());

    }
    @Test
    public void testStraight(){
        assertEquals(true, straight.checkStraight());
        assertEquals(false, highCard.checkStraight());

    }
    @Test
    public void testFlush(){
        assertEquals(true, flush.checkFlush());
        assertEquals(false, highCard.checkFlush());

    }
    @Test
    public void testFullHouse(){
        assertEquals(true, fullHouse.checkFullHouse());
        assertEquals(false, highCard.checkFullHouse());

    }
    @Test
    public void test4ofKind(){
        assertEquals(true, fourOfAKind.check4ofKind());
        assertEquals(false, highCard.check4ofKind());

    }
    @Test
    public void testStraightFlush(){
        assertEquals(true, straightFlush.checkStraightFlush());
        assertEquals(false, highCard.checkStraightFlush());

    }
    @Test
    public void testCompareTo(){
        assertEquals(0, twoPair.compareTo(twoPair));
        assertEquals(-1, threeOfAKind.compareTo(fourOfAKind));
        assertEquals(1, fullHouse.compareTo(flush));
    }
}
