package Pishti;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PishtiTable extends Application{
    private int[] cardvalue = {1,0,0,0,0,0,0,0,0,0,1,0,0,
            1,0,0,0,0,0,0,0,0,0,1,0,0,
            1,0,0,0,0,0,0,0,0,3,1,0,0,
            1,2,0,0,0,0,0,0,0,0,1,0,0};
    private Image[] cards = {new Image("Pishti/card/1.png"),new Image("Pishti/card/2.png"),
            new Image("Pishti/card/3.png"), new Image("Pishti/card/4.png"), new Image("Pishti/card/5.png"),
            new Image("Pishti/card/6.png"), new Image("Pishti/card/7.png"), new Image("Pishti/card/8.png"),
            new Image("Pishti/card/9.png"), new Image("Pishti/card/10.png"),new Image("Pishti/card/11.png"),
            new Image("Pishti/card/12.png"),new Image("Pishti/card/13.png"),new Image("Pishti/card/14.png"),
            new Image("Pishti/card/15.png"),new Image("Pishti/card/16.png"),new Image("Pishti/card/17.png"),
            new Image("Pishti/card/18.png"),new Image("Pishti/card/19.png"),new Image("Pishti/card/20.png"),
            new Image("Pishti/card/21.png"),new Image("Pishti/card/22.png"),new Image("Pishti/card/23.png"),
            new Image("Pishti/card/24.png"),new Image("Pishti/card/25.png"),new Image("Pishti/card/26.png"),
            new Image("Pishti/card/27.png"),new Image("Pishti/card/28.png"),new Image("Pishti/card/29.png"),
            new Image("Pishti/card/30.png"),new Image("Pishti/card/31.png"),new Image("Pishti/card/32.png"),
            new Image("Pishti/card/33.png"),new Image("Pishti/card/34.png"),new Image("Pishti/card/35.png"),
            new Image("Pishti/card/36.png"),new Image("Pishti/card/37.png"),new Image("Pishti/card/38.png"),
            new Image("Pishti/card/39.png"),new Image("Pishti/card/40.png"),new Image("Pishti/card/41.png"),
            new Image("Pishti/card/42.png"),new Image("Pishti/card/43.png"),new Image("Pishti/card/44.png"),
            new Image("Pishti/card/45.png"),new Image("Pishti/card/46.png"),new Image("Pishti/card/47.png"),
            new Image("Pishti/card/48.png"),new Image("Pishti/card/49.png"),new Image("Pishti/card/50.png"),
            new Image("Pishti/card/51.png"),new Image("Pishti/card/52.png"),};

    private int[] cardNum = {1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13};

    private ArrayList<Integer> cardsDealt= new ArrayList<>();

    HBox hBoxTop = new HBox();
    HBox hBoxBottom = new HBox();
    StackPane stackPane = new StackPane();
    Player player;
    Ai ai;

    int bottomCard;
    Pane deckPane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        newGame();
        BorderPane borderPane = new BorderPane();
        ImageView cardBacks1 = new ImageView("Pishti/card/b2fv.png");
        ImageView cardBacks2= new ImageView("Pishti/card/b2fv.png");
        ImageView cardBacks3 = new ImageView("Pishti/card/b2fv.png");
        ImageView cardBacks4 = new ImageView("Pishti/card/b2fv.png");

        HBox deckHBox = new HBox(new ImageView(cards[bottomCard]),new ImageView("Pishti/card/b2fv.png"),new ImageView("Pishti/card/b2fv.png"),
                new ImageView("Pishti/card/b2fv.png"));
        deckHBox.setSpacing(-60);
        deckHBox.setAlignment(Pos.CENTER_LEFT);

        deckPane.getChildren().add(deckHBox);

        borderPane.setLeft(deckPane);

        Scene scene = new Scene(borderPane, 440,410,Color.GREEN);




        borderPane.setCenter(stackPane);

        hBoxTop.getChildren().addAll(cardBacks1,cardBacks2,cardBacks3,cardBacks4);
        hBoxTop.setAlignment(Pos.CENTER_RIGHT);
        hBoxTop.setSpacing(10);
        borderPane.setTop(hBoxTop);


        ArrayList<Integer> playersHand = player.getHand();
        ArrayList<Integer> aisHand = ai.getHand();
        for(int i=0; i<playersHand.size();i++) {
            int place = playersHand.get(i);
            hBoxBottom.getChildren().add(new ImageView(cards[place]));
            cardsDealt.add(place);
        }
        hBoxBottom.setAlignment(Pos.CENTER_RIGHT);
        hBoxBottom.setSpacing(10);

        borderPane.setBottom(hBoxBottom);

        primaryStage.setScene(scene);
        primaryStage.show();

        hBoxBottom.getChildren().get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(0));
                hBoxBottom.getChildren().add(0, new Rectangle(72, 50, Color.TRANSPARENT));
                int aiTurn = ai.turn(cardNum,cardNum[playersHand.get(0)]);

                hBoxTop.getChildren().remove(aiTurn);
                hBoxTop.getChildren().add(aiTurn, new Rectangle(72,50,Color.TRANSPARENT));
                stackPane.getChildren().add(new ImageView(cards[aisHand.get(aiTurn)]));
            }
        });
        hBoxBottom.getChildren().get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(1));
                hBoxBottom.getChildren().add(1,new Rectangle(72,50,Color.TRANSPARENT));
                int aiTurn = ai.turn(cardNum,cardNum[playersHand.get(1)]);
                hBoxTop.getChildren().remove(aiTurn);
                hBoxTop.getChildren().add(aiTurn, new Rectangle(72,50,Color.TRANSPARENT));
                stackPane.getChildren().add(new ImageView(cards[aisHand.get(aiTurn)]));
            }
        });
        hBoxBottom.getChildren().get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(2));
                hBoxBottom.getChildren().add(2,new Rectangle(72,50,Color.TRANSPARENT));
                int aiTurn = ai.turn(cardNum,cardNum[playersHand.get(2)]);

                hBoxTop.getChildren().remove(aiTurn);
                hBoxTop.getChildren().add(aiTurn, new Rectangle(72,50,Color.TRANSPARENT));
                stackPane.getChildren().add(new ImageView(cards[aisHand.get(aiTurn)]));
            }
        });
        hBoxBottom.getChildren().get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(3));
                hBoxBottom.getChildren().add(3,new Rectangle(72,50,Color.TRANSPARENT));
                int aiTurn = ai.turn(cardNum,cardNum[playersHand.get(3)]);

                hBoxTop.getChildren().remove(aiTurn);
                hBoxTop.getChildren().add(aiTurn, new Rectangle(72,50,Color.TRANSPARENT));
                stackPane.getChildren().add(new ImageView(cards[aisHand.get(aiTurn)]));
            }
        });
    }
    public void newGame(){
        cardsDealt.clear();
        bottomCard = (int)(Math.random()*52);
        while (cardNum[bottomCard]==11){
            bottomCard = (int)(Math.random()*52);
        }
        cardsDealt.add(bottomCard);
        player = new Player();
        ai = new Ai();
        ai.newHand(cardsDealt);
        player.newHand(cardsDealt);

    }
}
