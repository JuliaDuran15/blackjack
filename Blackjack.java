import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        Scanner userInput = new Scanner(System.in);

        int amountOfPlayers;
        //quantos jogadores
        do{
        System.out.println("How many playwers? (OBS: must be in between 2 and 5)");
        amountOfPlayers = userInput.nextInt();
        }while(amountOfPlayers<2 && amountOfPlayers>5);

        //criante deck de cartas
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        
        
        //start dealing 
        //da ao jogador 2 cartas iniciais
        playerDeck.draw(playingDeck);
        playerDeck.draw(playingDeck);

        //delaer ganha cartas
        dealerDeck.draw(playingDeck);
        dealerDeck.draw(playingDeck);

        while(true){
            System.out.print("Your hand");
            System.out.print(playerDeck.toString());
            System.out.println("\nYour deck is valued at: " + playerDeck.cardsValue());

            //dealer hand
            System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [hidden]");
            
            //oq o jogador que fazer?
            System.out.println("Would you like to (1)Hit or (2)Stand?");
            int response = userInput.nextInt();

            //caso quera mais um"
            if(response==1){
                playerDeck.draw(playingDeck);
                System.out.println("You draw a "+ playerDeck.getCard(playerDeck.deckSize()-1).toString());
                //-1 um para obter o index correto
                //se atingiu limite
                if(playerDeck.cardsValue()>21){
                    System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue() + "You lost the game!");
                }
            }

            if(response==2){
                break;
            }
        }

        //cartas do dealer/mesa
        System.out.println("Dealer Cards: " + dealerDeck.toString());
        //compara pontuacao
        if(dealerDeck.cardsValue()>playerDeck.cardsValue()){
            System.out.println("Dealer beats you! You've lost!");
        }
        while(dealerDeck.cardsValue()<17){
            dealerDeck.draw(playingDeck);
            System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
        }
        //total do dealer
        System.out.println("Desler hands value: " + dealerDeck.cardsValue());

        if(dealerDeck.cardsValue()>21){
            System.out.println("Dealer busts");
            if((dealerDeck.cardsValue()>playerDeck.cardsValue()) && playerDeck.cardsValue()>21){
                System.out.println("Booth busts! But player WON!");
            }
            else if((dealerDeck.cardsValue()<playerDeck.cardsValue()) && playerDeck.cardsValue()>21){
                System.out.println("Booth busts! But dealer WON!");
            }
        }

        if(playerDeck.cardsValue()==dealerDeck.cardsValue()){
            System.out.println("---Push---");
        }

        if((playerDeck.cardsValue()>dealerDeck.cardsValue()) && playerDeck.cardsValue()<21){
            System.out.println("Player wins the game!");
        }

    playerDeck.moveAllToDeck(playingDeck);
    dealerDeck.moveAllToDeck(playingDeck);
    System.out.println("Wants to play again? Yes(1) No(2): ");
    }

    
}