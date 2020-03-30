package interfacePackage.scenePrincipale;

import sourcePackage.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;


public class JeuView{
	
	private  Jeux jeu;
	private final String img = "interfacePackage/images/debut.png";
	private ImageView debut;
	public JeuView(Stage stage,Session session){

		SessionView sessionV = new SessionView(session);
		stage.setTitle("Le Pendu");
		Group root = new Group();
		Scene scene = new Scene(root, 900, 660, new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
				new Stop[] {
						new Stop(0, Color.web("#33ffcc")), new Stop(1, Color.web("#ffffff"))
				}
		));
		debut = new ImageView(img);
		root.getChildren().add(sessionV);
		stage.setScene(scene);
		stage.show();
	}
	
}

