package hw03;
import java.util.*;
public class Prog1 {
	private IntQueue deck= new IntQueue(52);		//initializing a queue of capacity 52
	private IntStack player1= new IntStack(3);		//initializing a stack of capacity 3 for player1
	private IntStack player2= new IntStack(3);		//initializing a stack of capacity 3 for player2
	private String suits[]= {"Club","Diamond","Heart","Spades"};	//suits according to their priority
	private String ranks[]= {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
	private int arr[]= new int[52];					//''array for holding the values and then shuffling
	
	//creating an ordered deck of 52 cards 
	public void create_cards() {
		for(int i=0; i<52; i++) {
			arr[i]= i;
		}
	}
	
	//shuffling the ordered deck
	public void shuffle() {
		Random rand= new Random();
		for (int i=0; i<arr.length-1; i++) {
		    int k = rand.nextInt(arr.length);
		    int temp = arr[i];
		    arr[i] = arr[k];
		    arr[k] = temp;
		}
	}
	
	//creating a shuffled deck and inserting the values in a queue
	public void create_deck() {
		for(int i=0; i<52; i++) {
			deck.enQueue(arr[i]);		//this deck will be used for distributing the cards to players
		}
	}
	
	//distributing 3 cards to each player from the deck
	public void redistribute() {
		for(int i=1; i<=3; i++) {
			player1.push(deck.deQueue());		//pushing the card dequeued onto the player1 stack
			player2.push(deck.deQueue());		//pushing the card dequeued onto the player2 stack
		}
		System.out.println("Player1 cards ");
		player1.show();
		System.out.println("Player2 cards ");
		player2.show();
	}
	
	//taking out cards from each players stack and comparing them in order to get a winner
	public void draw_cards() {
		int p1win_count=0;		//saves the count of wins for player1 
		int p2win_count=0;		//saves the count of wins for player2
		for(int i=0; i<3; i++) {
			int p1 = player1.pop();
			int p2 = player2.pop();
			int p1suit= p1/13;
			int p1rank= p1%13;
			int p2suit= p2/13;
		    int p2rank= p2%13;
		    System.out.println("Player1 card: "+ranks[p1rank-1]+" of "+suits[p1suit]);
		    System.out.println("Player2 card: "+ranks[p2rank-1]+" of "+suits[p2suit]);
		    if(p1rank == p2rank) {				//if rank of both cards are same then we will compare the suits priority
		    	if(p1suit > p2suit) {
		    		p1win_count++;
		    		System.out.println("player1 wins this set");
		    		// pushing back both the cards in the original deck
		    		deck.enQueue(p1);			
		    		deck.enQueue(p2);
		    	}
		    	else {
		    		p2win_count++;
		    		System.out.println("player2 wins this set");
		    		// pushing back both the cards in the original deck
		    		deck.enQueue(p1);
		    		deck.enQueue(p2);
		    	}
		    }
		    else if(p1rank > p2rank) {
		    	System.out.println("player1 wins this set");
		    	p1win_count++;
		    	// pushing back both the cards in the original deck
		    	deck.enQueue(p1);
	    		deck.enQueue(p2);
		    }
		    else {
		    	p2win_count++;
		    	System.out.println("player2 wins this set");
		    	// pushing back both the cards in the original deck
		    	deck.enQueue(p1);
	    		deck.enQueue(p2);
		    }
		}
	    
		//comparing the number of wins out of 3 sets and deciding the winner of the match
	    if(p1win_count > p2win_count)
	    	System.out.println("\nPLAYER1 WINS the MATCH\n");
	    else
	    	System.out.println("\nPLAYER2 WINS the MATCH\n");
	}
	
	//Main method
	public static void main(String[] args) {
		Prog1 ob= new Prog1();
		ob.create_cards();
		ob.shuffle();
		ob.create_deck();
		System.out.println("Shuffled Deck:");				//Printing the shuffled deck used for distributing the cards
		ob.deck.show();
		ob.redistribute();
		ob.draw_cards();
	}
}
