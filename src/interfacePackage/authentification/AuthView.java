package interfacePackage.authentification;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class AuthView {
    private Label label;
    private Button newPsudo;
    private Button startPlay;
    private TextField psudoInput;
    private Scene scene;

    public AuthView(Stage primaryStage){
        Group root = new Group();
        primaryStage.setTitle("Authentification");
        scene = new Scene(root, 890, 650, new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                new Stop[] {
                        new Stop(0, Color.web("#33ffcc")), new Stop(1, Color.web("#ffffff"))
                }
        ));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setLayoutX(330);
        grid.setLayoutY(220);

        label=new Label("Psudonyme");
        GridPane.setMargin(label, new Insets(0, 0, 0, 45));
        GridPane.setConstraints(label,0,0);

        psudoInput = new TextField();
        psudoInput.setMinSize(230,40);
        psudoInput.setMaxSize(230,40);
        GridPane.setConstraints(psudoInput,0,1);


        startPlay = new Button("Commencer");
        GridPane.setMargin(startPlay, new Insets(0, 0, 0, 55));
        GridPane.setConstraints(startPlay,0,2);

        newPsudo = new Button("Nouveau");
        GridPane.setMargin(newPsudo, new Insets(10, 0, 0, 67));
        GridPane.setConstraints(newPsudo,0,5);

        grid.getChildren().addAll(label,psudoInput,newPsudo,startPlay);


        //clouds
        ImageView cloud0 = new ImageView(new Image("interfacePackage/images/cloudV0.png"));
        cloud0.setLayoutX(255);
        cloud0.setLayoutY(500);
        ImageView cloud1 = new ImageView(new Image("interfacePackage/images/cloudV1.png"));
        cloud1.setLayoutX(155);
        cloud1.setLayoutY(380);
        ImageView cloud2 = new ImageView(new Image("interfacePackage/images/cloudV2.png"));
        cloud2.setLayoutX(705);
        cloud2.setLayoutY(380);
        ImageView cloud01 = new ImageView(new Image("interfacePackage/images/cloudV1.png"));
        cloud01.setLayoutX(605);
        cloud01.setLayoutY(480);
        ImageView loginBack = new ImageView(new Image("interfacePackage/images/login.png"));
        loginBack.setLayoutX(230);
        loginBack.setLayoutY(130);
        ImageView logo = new ImageView(new Image("interfacePackage/images/logo.png"));
        logo.setLayoutX(365);
        logo.setLayoutY(-30);

        root.getChildren().addAll(logo,cloud0,cloud1,cloud2,cloud01,loginBack,grid);

        String css = AuthView.class.getResource("authStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Button getNewPsudo() {
        return newPsudo;
    }

    public Button getStartPlay() {
        return startPlay;
    }

    public TextField getPsudoInput() {
        return psudoInput;
    }
}
