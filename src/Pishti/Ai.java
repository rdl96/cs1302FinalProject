package Pishti;

import java.util.ArrayList;

public class Ai implements Game {
    private int score;
    private ArrayList<Integer> currentHand= new ArrayList<>();
    private ArrayList<Integer> alreadyPlayed = new ArrayList<>();
    private int currentHandSize = 3;

    public Ai (){
        score = 0;
    }
    public void newHand(ArrayList cardsDealt){
        {

            for(int i =0; i<4;i++){
                int cardNum = (int) (Math.random()*52);

                if(!currentHand.contains(cardNum)&&!cardsDealt.contains(cardNum)) {
                    currentHand.add(cardNum);
                }
                else{i--;}
            }
        }
    }

    @Override
    public ArrayList getHand() {
        return currentHand;
    }


    public int turn(int[] cardnum, int currentCard){
        if (currentHandSize == 0){
            currentHandSize = 3;
        }
        int card = (int) (Math.random() * 4 );

        Boolean turner = false;

        for (int i= 0; i < currentHandSize; i++){
            if (currentCard == cardnum[currentHand.get(i)]){
                return cardnum[currentHand.get(i)];
            }
        }

        while (!turner) {
            if ((cardnum[currentHand.get(card)] == 11 && currentHand.size() > 1)) {
                card = (int) (Math.random() * 4 );

                turner = false;
            }
            else{
                currentHandSize--;
                alreadyPlayed.add(currentHand.get(card));
                turner = true;
            }
        }
        return card;
    }

}
