package interfacePackage.scenePrincipale;

import sourcePackage.*;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CaseView extends Parent {

	private Rectangle rect;
	private Text lettre;
	private final String colorT = "#9acd32";
	private final String colorF = "#ff0000";
	private MotView motV;
	private Case cc;
	private int num;

	public CaseView(Case c, int num, MotView motV) {

		cc = c;
		this.num = num;
		this.motV = motV;
		rect = new Rectangle(30, 30, Color.web(cc.getColor()));
		rect.setStroke(Color.WHITE);
		rect.setStrokeWidth(2.5);
		rect.setArcHeight(7.5);
		rect.setArcWidth(7.5);
		lettre = new Text("?");
		lettre.setFont(new Font("Comic Sans MS", 18));
		lettre.setFill(Color.WHITE);
		lettre.setX(9);
		lettre.setY(20);
		this.getChildren().add(rect);
		this.getChildren().add(lettre);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if (!cc.isTraite() && (motV.getEnCours() == -1)) {
					motV.setEnCours(num);
					rect.setStroke(Color.web(c.getColor()));
					rect.setFill(Color.web("#ffffcc"));
					lettre.setText("");
					lettre.setFill(Color.web(c.getColor()));
					if(cc.getCoeff() == 2)
						motV.getPropo(cc.aleaPropo());
					else
						motV.getAll();
				}
			}
		});
	}

	/******************* Setter Getter ********************/

	// calculer le score
	public void setLettre(char let) {
		lettre.setText(Character.toString(let));
		boolean traite = cc.calculScore(let);
		if (traite) {
			if (cc.isPerdu()) {
				rect.setStroke(Color.web(colorF));
				lettre.setText(Character.toString(cc.getLettre()));
				lettre.setFill(Color.web(colorF));
			} else {
				motV.setEnCours(-1);
				rect.setStroke(Color.web(colorT));
				lettre.setText(Character.toString(cc.getLettre()));
				lettre.setFill(Color.web(colorT));
			}
		}
	}

	/******************** Les m�thodes *************************/
	
	// afficher la case 
	public void afficher(boolean perdu) {

		rect.setFill(Color.web("#ffffcc"));
		if (perdu) {
			rect.setStroke(Color.web(colorF));
			lettre.setText(Character.toString(cc.getLettre()));
			lettre.setFill(Color.web(colorF));
		} else {
			rect.setStroke(Color.web(colorT));
			lettre.setText(Character.toString(cc.getLettre()));
			lettre.setFill(Color.web(colorT));
		}

	}
}
