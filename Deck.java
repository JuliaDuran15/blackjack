import java.util.ArrayList;
import java.util.Random;

public class Deck {
    //intancia variavel
    private ArrayList<Card> cards;
    //construtor
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck(){
        //gera cartas

        for(Suit cardSuit: Suit.values()){
            for(Value cardValue: Value.values()){
                //adicionarnova carta
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    public String toString(){
        String cardListOutput = "";

        for(Card aCard : this.cards){
            cardListOutput += "\n" + aCard.toString();
        }
        return cardListOutput;
    }

    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();

        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for(int i=0; i < originalSize; i++){
            //gera index randomico 
            randomCardIndex = random.nextInt((this.cards.size()-1 -0)+1)+0;
            tmpDeck.add(this.cards.get(randomCardIndex));
            //reove from origin
            this.cards.remove(randomCardIndex);
        }

        this.cards = tmpDeck;
    }
    
    
    public void removeCard(int i){
        this.cards.remove(i);
    }
    
    public Card getCard(int i){
        return this.cards.get(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);

    }

}
