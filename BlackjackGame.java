import java.util.Scanner;

public class BlackjackGame {
 
    private Player[] players;
    Scanner userInput = new Scanner(System.in);

    public void initializeGame(){

		System.out.println("===============Welcome to Blackjack!===============");
		System.out.println("");
		System.out.println("  BLACKJACK RULES: ");
		System.out.println("	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("	-The players cards are added up for their total.");
		System.out.println("	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
		System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("	-If the player total equals the dealer total, it is a Push and the hand ends."); 
		System.out.println("");
		System.out.println("");
		
        
        int users;
        
        String names;

		do {
			System.out.print("How many people are playing (1-6)? ");
			users = userInput.nextInt();
			

		} while (users > 5 || users < 0);

        players = new Player[users];
        for (int i = 0; i < users; i++) {
			System.out.print("What is player " + (i + 1) + "'s name? ");
			names =userInput.next();
			players[i] = new Player();
			players[i].setName(names);
		}
        

}
}