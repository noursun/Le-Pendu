package interfacePackage.scenePrincipale;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BarreScoreView extends Parent{
	
	private final String imagePath = "interfacePackage/images/barre.png";
	private int bestScore;
	private int scoreSession;
	private int numMot;
	private Text titre1, valeur1;
	private Text titre2, valeur2;
	private Text titre3, valeur3;

	public BarreScoreView(int bestScore) {
		this.bestScore = bestScore;
		this.scoreSession = 0;
		this.numMot = 1;
		ImageView imageView = new ImageView(imagePath);
		titre1 = new Text("Best score");
		titre1.setFont(new Font("Comic Sans MS", 18));
		titre1.setFill(Color.MEDIUMVIOLETRED);
		titre1.setX(50);
		titre1.setY(70);
		valeur1 = new Text(Integer.toString(bestScore));
		valeur1.setFont(new Font("Comic Sans MS", 18));
		valeur1.setFill(Color.MEDIUMVIOLETRED);
		valeur1.setX(75);
		valeur1.setY(95);
		titre2 = new Text("Score session");
		titre2.setFont(new Font("Comic Sans MS", 18));
		titre2.setFill(Color.MEDIUMVIOLETRED);
		titre2.setX(45);
		titre2.setY(165);
		valeur2 = new Text(Integer.toString(0));
		valeur2.setFont(new Font("Comic Sans MS", 18));
		valeur2.setFill(Color.MEDIUMVIOLETRED);
		valeur2.setX(75);
		valeur2.setY(185);
		titre3 = new Text("/10");
		titre3.setFont(new Font("Comic Sans MS", 18));
		titre3.setFill(Color.MEDIUMVIOLETRED);
		titre3.setX(100);
		titre3.setY(265);
		valeur3 = new Text(Integer.toString(1));
		valeur3.setFont(new Font("Comic Sans MS", 18));
		valeur3.setFill(Color.MEDIUMVIOLETRED);
		valeur3.setX(83);
		valeur3.setY(265);
		this.getChildren().add(imageView);
		this.getChildren().add(titre1);
		this.getChildren().add(valeur1);
		this.getChildren().add(titre2);
		this.getChildren().add(valeur2);
		this.getChildren().add(titre3);
		this.getChildren().add(valeur3);
		this.setTranslateX(710);
		this.setTranslateY(20);

	}
	
	/******************** Les m�thodes *************************/
	
	// mettre � jour le score
	public void upDateScore(int scoreSession){
		valeur2.setText(Integer.toString(scoreSession));
	}
	
	// mettre � jour le num du mot
	public void upDateNumMot(){
		numMot++;
		valeur3.setText(Integer.toString(numMot));
	}
}
