package interfacePackage.scenePrincipale;

import interfacePackage.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sourcePackage.Jeux;
import sourcePackage.Joueur;
import sourcePackage.Session;

public class Home extends Parent{
	
	private final String imagePath = "interfacePackage/images/Home.png";
	private Session session;
	public Home(Session session){
		this.session = session;
		ImageView imageView = new ImageView(imagePath);
		imageView.setLayoutX(730);
		imageView.setLayoutY(525);
		imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int score = session.getScore();
				int mScore = session.getBestScore();
				if (score > mScore) {
					session.getJoueur().setMielleurScore(score);
					sauvgarderMeilleurScore(session.getJoueur());
				}
				Session newSession = new Session(session.getJoueur(), Jeux.aleaLignes("mots.txt"));
				Main.showMenuPrincipale(session);
			}
		});
		this.getChildren().add(imageView);
		imageView.setOnMouseEntered(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				imageView.setLayoutX(730);
				imageView.setLayoutY(510);
			}
		});
		imageView.setOnMouseExited(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				imageView.setLayoutX(730);
				imageView.setLayoutY(525);
			}
		});
	}
	public void sauvgarderMeilleurScore(Joueur joueur){
		Jeux.suvgarderMeilleurScore(joueur);
	}
}
