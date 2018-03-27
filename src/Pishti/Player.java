package Pishti;


import java.util.ArrayList;

public class Player implements Game {
    private  int score = 0;
    private ArrayList<Integer> currentHand= new ArrayList<>();

    public Player(ArrayList cardsDealt){
        score = 0;
        for(int i =0; i<4;i++){
            int cardNum = (int) (Math.random()*52);

            if(!currentHand.contains(cardNum)&&!cardsDealt.contains(cardNum)) {
                currentHand.add(cardNum);
            }
            else{i--;}
        }
    }
    @Override
    public void newHand(ArrayList cardsDealt) {
        currentHand.clear();
        for(int i =0; i<4;i++){
            int cardNum = (int) (Math.random()*52);

            if(!currentHand.contains(cardNum)&&!cardsDealt.contains(cardNum)) {
                currentHand.add(cardNum);
            }
            else{i--;}
        }

    }

    @Override
    public ArrayList getHand() {
        return currentHand;
    }
}
