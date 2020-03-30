package interfacePackage.finDeJeux;

import interfacePackage.Main;
import interfacePackage.authentification.AuthView;
import interfacePackage.scenePrincipale.Home;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import sourcePackage.Jeux;
import sourcePackage.Joueur;
import sourcePackage.Session;

import static interfacePackage.Main.primaryStage;

/**
 * Created by Amusing Biko on 14/05/2017.
 */
public class ResultatController {

    private Scene scene;
    private Session session;
    Label gover;
    Label resultat;
    Label meilleur;
    Label actuel;
    Button sauv;
    Button reessayer;
    Label sauvResult;
    public ResultatController(Stage primaryStage, Session session) {
        this.session = session;
        Group root = new Group();
        primaryStage.setTitle("Game Over");
        scene = new Scene(root, 890, 650, new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                new Stop[] {
                        new Stop(0, Color.web("#33ffcc")), new Stop(1, Color.web("#ffffff"))
                }
        ));

        VBox vBox = new VBox(20);
        vBox.setStyle("-fx-alignment: center;");
        vBox.setLayoutX(280);
        vBox.setLayoutY(180);

        gover = new Label("Game Over");
        gover.setId("gameOver");
        resultat = (session.isPerdu()) ?  new Label("You Lose"): new Label("You Win");
        resultat.setId("resultat");
        actuel = new Label("Votre Score: "+session.getScore());
        meilleur = new Label("Meilleur Score: "+session.getBestScore());
        sauvResult = new Label("Votre score est souvrardee");
        sauvResult.setVisible(false);

        HBox hBox = new HBox(20);
        hBox.setStyle("-fx-alignment: center;");
        sauv = new Button("Sauvgarder");
        reessayer = new Button("Reessayer");
        hBox.getChildren().addAll(sauv,reessayer);

        vBox.getChildren().addAll(gover,resultat,actuel,meilleur,hBox,sauvResult);

        //home
        Home home = new Home(session);

        //logo
        ImageView logo = new ImageView(new Image("interfacePackage/images/logo.png"));
        logo.setLayoutX(365);
        logo.setLayoutY(-30);

        root.getChildren().addAll(logo,vBox,home);
        String css = AuthView.class.getResource("../finDeJeux/resultatStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void control(){
        sauv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                sauvgarder();
            }
        });
        reessayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                reessayer();
            }
        });
    }

    public void reessayer(){
        int score = session.getScore();
        int mScore = session.getBestScore();
        if (score > mScore) {
            session.getJoueur().setMielleurScore(score);
            Jeux.suvgarderMeilleurScore(session.getJoueur());
        }
        Session newSession = new Session(session.getJoueur(), Jeux.aleaLignes("mots.txt"));
        Main.showScenePrincipale(newSession);
    }

    public void sauvgarder(){
        Jeux.suvgarderScore(session);
        sauvResult.setVisible(true);
    }
}
