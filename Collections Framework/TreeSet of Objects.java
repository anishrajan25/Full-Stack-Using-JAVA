import java.util.*;

class Card implements Comparable<Card> {
    String symbol;
    int number;
    
    public Card(String sym , int num) {
        this.symbol = sym;
        this.number = num;
    }
    
    @Override
    public int hashCode() {
        return symbol.hashCode();
    }
    @Override
    public String toString() {
        return "Symbol : " + symbol + ", Number : " + number +"\n"; 
    }
    @Override
    public boolean equals(Object ob) {
        Card tmp = (Card) ob;
        return this.symbol.equals(tmp.symbol);
    }
    @Override
    public int compareTo(Card ob) {
        return this.symbol.compareTo(ob.symbol);
    }
}
public class Main
{
	public static void main(String[] args) {
		Card c1 = new Card("a",1);
		Card c2 = new Card("a",2);
		Card c3 = new Card("a",7);
		Card c4 = new Card("d",6);
		Card c5 = new Card("c",2);
		Card c6 = new Card("d",1);
		Card c7 = new Card("c",1);
		Card c8 = new Card("b",2);
		TreeSet<Card> set = new TreeSet<>();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		set.add(c5);
		set.add(c6);
		set.add(c7);
		set.add(c8);
		System.out.println(set);
	}
}
