/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package lunarlanderapplication;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author stipanmadzar
 */
public class LunarLanderApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        VBox root = new VBox(50);
        VBox box1 = new VBox();
        VBox box2 = new VBox(5);
        Image img1 = new Image("lunar_lander.png");
        Image img2 = new Image("lunar_surface.png");
        ImageView lander = new ImageView(img1);
        ImageView surface = new ImageView(img2);
        surface.setFitHeight(285);
        surface.setFitWidth(400);
        lander.setFitHeight(75);
        lander.setFitWidth(100);
        box1.getChildren().addAll(surface, lander);
        box1.setAlignment(Pos.CENTER);
        box1.setMargin(lander, new Insets(-100, 0, 0, 0));
        Label label1 = new Label("Press key s to start lifting off and press key r to re-start again.");
        Label label2 = new Label("Move the mouse and click to move the lunar lander.");
        Label label3 = new Label("Move the mouse over the lunar lander to glow it.");
        box2.setPadding(new Insets(0, 0, 0, 15));
        box2.getChildren().addAll(label1, label2, label3);
        root.getChildren().addAll(box1, box2);
        
        double landerX = 200.0;
        double landerY = 185.0;
        
        Scene scene = new Scene(root, 400, 390);
        scene.getStylesheets().add("styles.css");
        
        scene.setOnKeyPressed(event -> {
            
            if(event.getCode() == KeyCode.S) {
                 TranslateTransition ttrans = new TranslateTransition(new Duration(2000), lander);
                 ttrans.setToX(0.0);
                 ttrans.setToY(-265.0);
                 ttrans.play();
            }
            if(event.getCode() == KeyCode.R) {
                 TranslateTransition itrans = new TranslateTransition(new Duration(2000), lander);
                 itrans.setFromX(-150.0);
                 itrans.setFromY(0.0);
                 itrans.setToX(0.0);
                 itrans.setToY(0.0);
                 itrans.play();
            }
        });
        
        scene.setOnMouseClicked(event -> {
            double x = event.getSceneX() - landerX;
            double y = event.getSceneY() - landerY;
            TranslateTransition etrans = new TranslateTransition(new Duration(2000), lander);   
            etrans.setToX(x);
            etrans.setToY(y);
            etrans.play();  
        });
        
        lander.setOnMouseEntered(event -> {
            Glow glow = new Glow();
            glow.setLevel(0.8);
            lander.setEffect(glow);
        });
        
        lander.setOnMouseExited(event -> {
            lander.setEffect(null);
        });
        
        primaryStage.setTitle("Catching key and mouse events!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
