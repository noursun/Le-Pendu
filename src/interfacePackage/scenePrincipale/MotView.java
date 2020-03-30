package interfacePackage.scenePrincipale;

import interfacePackage.Main;
import sourcePackage.*;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MotView extends Parent {

	private Text indication;
	private CaseView[] lettres;
	private int enCours; // l'indice de la case encours
	private SessionView sessionV;
	private Mot mot;
	private Suivant suivant;

	/******************** Le constructeur **********************/
	
	public MotView(Mot mot, SessionView sessionV) {

		this.mot = mot;
		this.sessionV = sessionV;
		lettres = new CaseView[mot.getMot().length()];
		enCours = -1;
		indication = new Text(mot.getIndication());
		indication.setFont(new Font("Comic Sans MS", 20));
		indication.setFill(Color.web("#cc6600"));
		indication.setX(0);
		indication.setY(0);
		this.getChildren().add(indication);

		int i;
		for (i = 0; i < lettres.length; i++) {
			lettres[i] = new CaseView(mot.getCaseAt(i), i, this);
			lettres[i].setLayoutX(i * 40);
			lettres[i].setLayoutY(25);
			this.getChildren().add(lettres[i]);
		}
		suivant = new Suivant(i * 40 + 20, 23);
		suivant.setVisible(false);
		this.getChildren().add(suivant);
		this.setTranslateX(110);
		this.setTranslateY(390);

	}

	class Suivant extends Parent {

		private Circle cercle;
		private final String suivant = "interfacePackage/images/suivant.png";
		private ImageView suiv;

		public Suivant(int x, int y) {
			cercle = new Circle(x + 18, y + 18, 20, Color.web("#ffcc66"));
			cercle.setStroke(Color.MEDIUMVIOLETRED);
			cercle.setStrokeWidth(1);
			suiv = new ImageView(suivant);
			suiv.setLayoutX(x);
			suiv.setLayoutY(y);
			this.getChildren().add(cercle);
			this.getChildren().add(suiv);

			this.setOnMouseEntered(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					cercle.setStroke(Color.WHITE);
					cercle.setStrokeWidth(2);
				}
			});

			this.setOnMouseExited(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					cercle.setStroke(Color.MEDIUMVIOLETRED);
					cercle.setStrokeWidth(1);
				}
			});
		}
	}

	/*************** Setter Getter **********************/

	public int getEnCours() {
		return enCours;
	}

	public void setEnCours(int enCours) {
		this.enCours = enCours;
	}

	/******************* Les m�thodes ******************************/
	
	// passe la lettre choisi � la case. Fait les traitements n�cessaires dans le cas ou le mot et trait�, perdu...
	public void choix(char let) {

		if (enCours != -1) {
			lettres[enCours].setLettre(let);
			if (this.mot.isTraite() == true) {
				Mot m = sessionV.suivant();
				
				if (m != null) {
					suivant.setVisible(true);
					suivant.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							sessionV.updateMotV(m);
						}
					});
				}
				else {
					suivant.setVisible(true);
					suivant.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							Main.showResultat(sessionV.getSession());
						}
					});
				}
				afficher(mot.isPerdu());
			}
		}
	}

	// affiche tout le mot en prenant en considiration le cas perdu ou pas
	public void afficher(boolean perdu) {
		int i;
		for (i = 0; i < lettres.length; i++) {
			lettres[i].afficher(perdu);
		}
	}
	
	public void getPropo(char[] propo){
		sessionV.getClavierV().activePropo(propo);
	}
	
	public void getAll(){
		sessionV.getClavierV().activeAll();
	}
}
