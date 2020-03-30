package interfacePackage.menuPrincipale;

import interfacePackage.Main;
import interfacePackage.authentification.AuthView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sourcePackage.Session;

import static interfacePackage.Main.primaryStage;

public class MenuController {

    private Scene scene;
    private Session session;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    public MenuController(Stage primaryStage, Session session) {
        this.session = session;
        BorderPane root= new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #33ffcc, #ffffff)");
        primaryStage.setTitle("Menu Principale");
        scene = new Scene(root, 900, 660);
        VBox vBox = new VBox(25);
        vBox.setStyle("-fx-alignment: center;");

        ImageView logo = new ImageView(new Image("interfacePackage/images/logo.png"));

        Label label = new Label("Menu du pendu");
        button = new Button("Commencer");
        button1 = new Button("Aide");
        button2= new Button("Scores");
        button3= new Button("Quiter");
        vBox.getChildren().addAll(logo,label,button,button1,button2,button3);
        root.setCenter(vBox);
        String css = AuthView.class.getResource("../menuPrincipale/menuStyle.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void control(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                commencer();
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aideMoi();
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //scoreScene
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });
    }
    public void commencer(){
        Main.showScenePrincipale(session);
    }
    public void aideMoi(){
        Main.showAide();
    }
}
