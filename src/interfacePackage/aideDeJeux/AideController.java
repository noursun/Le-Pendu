package interfacePackage.aideDeJeux;

import interfacePackage.authentification.AuthView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Created by Amusing Biko on 13/05/2017.
 */
public class AideController {
    private Stage primaryStage;
    private Scene scene;
    private Button button;
    public AideController(Stage stage) {
        primaryStage = stage;
        BorderPane root= new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #33ffcc, #ffffff)");
        primaryStage.setTitle("Aide");
        scene = new Scene(root, 400, 450);
        VBox vBox = new VBox(30);
        vBox.setStyle("-fx-alignment: center;");

        Label labela = new Label("Aide");
        labela.setId("aide");
        Label label = new Label("Le type des cases");
        label.setId("titre");
        button = new Button("OK");

        Ellipse circle = new Ellipse(0, 0, 20, 20);
        circle.setStyle("-fx-fill: #c71585");
        Label color = new Label("Zero chance");
        HBox hBox = new HBox(circle,color);
        hBox.setStyle("-fx-alignment: center;");
        Ellipse circle1 = new Ellipse(0, 0, 20, 20);
        circle1.setStyle("-fx-fill: #00bfff");
        Label color1 = new Label("Multi chance");
        HBox hBox1 = new HBox(circle1,color1);
        hBox1.setStyle("-fx-alignment: center;");
        Ellipse circle2 = new Ellipse(0, 0, 20, 20);
        circle2.setStyle("-fx-fill: #ff4500");
        Label color2 = new Label("Propositions");
        HBox hBox2 = new HBox(circle2,color2);
        hBox2.setStyle("-fx-alignment: center;");
        vBox.getChildren().addAll(labela,label,hBox,hBox1,hBox2,button);
        root.setCenter(vBox);
        String css = AuthView.class.getResource("../aideDeJeux/aideSyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void control(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });
    }
}
