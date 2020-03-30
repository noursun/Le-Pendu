package interfacePackage.scenePrincipale;

import java.util.Arrays;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ClavierView extends Parent {

	private ToucheView[][] lettres;
	private Rectangle rect;
	private char lettre;
	private MotView motV;

	
	/******************** Le constructeur ********************/
	
	public ClavierView(MotView motV) {

		lettre = '?';
		rect = new Rectangle(410, 130, Color.web("#ffffff"));
		rect.setStroke(Color.web("#cc6600"));
		rect.setStrokeWidth(1.5);
		rect.setArcHeight(30);
		rect.setArcWidth(30);
		this.getChildren().add(rect);
		lettres = new ToucheView[][] {
				{ new ToucheView('A', this), new ToucheView('B', this), new ToucheView('C', this),
						new ToucheView('D', this), new ToucheView('E', this), new ToucheView('F', this),
						new ToucheView('G', this), new ToucheView('H', this), new ToucheView('I', this),
						new ToucheView('J', this) },
				{ new ToucheView('K', this), new ToucheView('L', this), new ToucheView('M', this),
						new ToucheView('N', this), new ToucheView('O', this), new ToucheView('P', this),
						new ToucheView('Q', this), new ToucheView('R', this), new ToucheView('S', this),
						new ToucheView('T', this) },
				{ new ToucheView('U', this), new ToucheView('V', this), new ToucheView('W', this),
						new ToucheView('X', this), new ToucheView('Y', this), new ToucheView('Z', this) } };

		int i = 0, j = 0;
		for (ToucheView[] t : lettres) {
			for (ToucheView toucheView : t) {
				toucheView.setLayoutX(40 * j + 10);
				toucheView.setLayoutY(40 * i + 10);
				this.getChildren().add(toucheView);
				j++;
			}
			i++;
			if (i == 2)
				j = 2;
			else
				j = 0;
		}

		this.setTranslateX(100);
		this.setTranslateY(470);

		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if (lettre != '?') {
					motV.choix(lettre);
				}
			}
		});
	}

	/****************** Setter Getter *************/

	// retourner la lettre cliqued
	public char getLettre() {
		return lettre;
	}

	public void setLettre(char lettre) {
		this.lettre = lettre;
	}

	/********************** Les m�thodes *******************/
	
	// active toutes les touches du clavier
	public void activeAll() {
		for (ToucheView[] tt : lettres) {
			for (ToucheView t : tt)
				t.setActive(true);
		}
	}

	// active que les touches qui correspondent aux propositions
	public void activePropo(char[] propo) {

		for (ToucheView[] tt : lettres) {

			for (ToucheView t : tt) {
				if (Arrays.binarySearch(propo, t.getLet()) >= 0)
					t.setActive(true);
				else
					t.setActive(false);
			}
		}
	}

}
