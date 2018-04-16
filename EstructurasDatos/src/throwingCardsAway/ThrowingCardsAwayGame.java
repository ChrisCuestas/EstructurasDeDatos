package throwingCardsAway;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.Queue;

public class ThrowingCardsAwayGame {

	Queue<Integer> deck;
	Queue<Integer> discardedCards;
	
	public ThrowingCardsAwayGame() {
		this.deck = new Queue<Integer>();
		this.discardedCards = new Queue<Integer>();
	}

	public void play(int n) {
		for(int i=1; i<n+1; i++) {
			this.deck.insert(i,-1);
		}
		while(deck.getSize()>1) {
			this.discardedCards.enqueue(this.deck.dequeue(),-1);
			this.deck.insert(this.deck.dequeue(),-1);
		}
	}
	
	public String getDiscardedCards(){
		String discardedCards = "Discarded cards: ";
		while(!this.discardedCards.isEmpty()) {
			discardedCards += this.discardedCards.dequeue();
			if(this.discardedCards.getSize()!=0) discardedCards +=", ";
		}
		return discardedCards;
	}
	
	public String getRemainingCard() {
		String remainingCard = "Remaining card: ";
		remainingCard += this.deck.dequeue();
		return remainingCard;
	}
	
	public static void main(String[] args) {
		ThrowingCardsAwayGame th;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			while(n!=0) {
				th= new ThrowingCardsAwayGame();
				th.play(n);
				bw.write(th.getDiscardedCards() + "\n");
				bw.write(th.getRemainingCard() + "\n");
				bw.flush();
				n = Integer.parseInt(br.readLine());
			}
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
