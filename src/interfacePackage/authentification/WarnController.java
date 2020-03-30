package interfacePackage.authentification;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class WarnController {
    private Stage primaryStage;
    private Scene scene;
    private Button button;
    public WarnController(Stage stage,String message) {
        primaryStage = stage;
        BorderPane root= new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #33ffcc, #ffffff)");
        primaryStage.setTitle("Erreur");
        scene = new Scene(root, 450, 200);
        VBox vBox = new VBox(30);
        vBox.setStyle("-fx-alignment: center;");

        Label label = new Label(message);
        button = new Button("OK");
        vBox.getChildren().addAll(label,button);

        root.setCenter(vBox);
        String css = AuthView.class.getResource("warnStyle.css").toExternalForm();
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
        }
        );
    }
}
