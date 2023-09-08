public class Blackjack {

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        //criante deck de cartas
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        

    }
}