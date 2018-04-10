package Pishti;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PishtiTable extends Application{
    private int[] cardNum = {1,0,0,0,0,0,0,0,0,0,1,0,0,
                             1,0,0,0,0,0,0,0,0,0,1,0,0,
                             1,0,0,0,0,0,0,0,0,3,1,0,0,
                             1,2,0,0,0,0,0,0,0,0,1,0,0};
    private ImageView[] cards = {new ImageView("Pishti/card/1.png"),new ImageView("Pishti/card/2.png"),
    new ImageView("Pishti/card/3.png"), new ImageView("Pishti/card/4.png"), new ImageView("Pishti/card/5.png"),
    new ImageView("Pishti/card/6.png"), new ImageView("Pishti/card/7.png"), new ImageView("Pishti/card/8.png"),
    new ImageView("Pishti/card/9.png"), new ImageView("Pishti/card/10.png"),new ImageView("Pishti/card/11.png"),
    new ImageView("Pishti/card/12.png"),new ImageView("Pishti/card/13.png"),new ImageView("Pishti/card/14.png"),
    new ImageView("Pishti/card/15.png"),new ImageView("Pishti/card/16.png"),new ImageView("Pishti/card/17.png"),
    new ImageView("Pishti/card/18.png"),new ImageView("Pishti/card/19.png"),new ImageView("Pishti/card/20.png"),
    new ImageView("Pishti/card/21.png"),new ImageView("Pishti/card/22.png"),new ImageView("Pishti/card/23.png"),
    new ImageView("Pishti/card/24.png"),new ImageView("Pishti/card/25.png"),new ImageView("Pishti/card/26.png"),
    new ImageView("Pishti/card/27.png"),new ImageView("Pishti/card/28.png"),new ImageView("Pishti/card/29.png"),
    new ImageView("Pishti/card/30.png"),new ImageView("Pishti/card/31.png"),new ImageView("Pishti/card/32.png"),
    new ImageView("Pishti/card/33.png"),new ImageView("Pishti/card/34.png"),new ImageView("Pishti/card/35.png"),
    new ImageView("Pishti/card/36.png"),new ImageView("Pishti/card/37.png"),new ImageView("Pishti/card/38.png"),
    new ImageView("Pishti/card/39.png"),new ImageView("Pishti/card/40.png"),new ImageView("Pishti/card/41.png"),
    new ImageView("Pishti/card/42.png"),new ImageView("Pishti/card/43.png"),new ImageView("Pishti/card/44.png"),
    new ImageView("Pishti/card/45.png"),new ImageView("Pishti/card/46.png"),new ImageView("Pishti/card/47.png"),
    new ImageView("Pishti/card/48.png"),new ImageView("Pishti/card/49.png"),new ImageView("Pishti/card/50.png"),
    new ImageView("Pishti/card/51.png"),new ImageView("Pishti/card/52.png"),};

    private ArrayList<Integer> cardsDealt= new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        ImageView cardBacks1 = new ImageView("Pishti/card/b2fv.png");
        ImageView cardBacks2= new ImageView("Pishti/card/b2fv.png");
        ImageView cardBacks3 = new ImageView("Pishti/card/b2fv.png");
        ImageView cardBacks4 = new ImageView("Pishti/card/b2fv.png");

        Scene scene = new Scene(borderPane, 440,410,Color.GREEN);
        
          TextField tfMessage = new TextField("Player");
        tfMessage.setEditable(false);
        tfMessage.setStyle("-fx-text-fill: Blue");
        tfMessage.setFont(Font.font("Times",14));
        tfMessage.setAlignment(); //where to place text field

        TextField tfMessage2 = new TextField("Opponant");
        tfMessage2.setEditable(false);
        tfMessage2.setStyle("-fx-text-fill: Red");
        tfMessage2.setFont(Font.font("Times",14));
        tfMessage2.setAlignment(); //where to place text field


        HBox hBoxTop = new HBox();
        HBox hBoxBottom = new HBox();
        StackPane stackPane = new StackPane();

        borderPane.setCenter(stackPane);

        hBoxTop.getChildren().addAll(cardBacks1,cardBacks2,cardBacks3,cardBacks4);
        hBoxTop.setAlignment(Pos.CENTER_RIGHT);
        hBoxTop.setSpacing(10);
        borderPane.setTop(hBoxTop);

        Player player = new Player(cardsDealt);
        ArrayList<Integer> playersHand = player.getHand();
        for(int i=0; i<playersHand.size();i++) {
           int place = playersHand.get(i);
           hBoxBottom.getChildren().add(cards[place]);
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
                hBoxBottom.getChildren().add(0,new Rectangle(72,50,Color.TRANSPARENT));
            }
        });
        hBoxBottom.getChildren().get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(1));
                hBoxBottom.getChildren().add(1,new Rectangle(72,50,Color.TRANSPARENT));
            }
        });
        hBoxBottom.getChildren().get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(2));
                hBoxBottom.getChildren().add(2,new Rectangle(72,50,Color.TRANSPARENT));

            }
        });
        hBoxBottom.getChildren().get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stackPane.getChildren().add(hBoxBottom.getChildren().get(3));
                hBoxBottom.getChildren().add(3,new Rectangle(72,50,Color.TRANSPARENT));
            }
        });
    }
}
