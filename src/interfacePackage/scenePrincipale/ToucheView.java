package interfacePackage.scenePrincipale;

import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ToucheView extends Parent {

	private Rectangle rect;
	private Text lettre;
	private ClavierView clavierV;
	private char let;

	/******************* le constructeur ***************************/
	
	public ToucheView(char let, ClavierView clavierV) {

		this.let = let;
		this.clavierV = clavierV;
		rect = new Rectangle(30, 30, Color.web("#ffffcc"));
		rect.setStroke(Color.web("#cc6600"));
		rect.setStrokeWidth(2.5);
		rect.setArcHeight(5);
		rect.setArcWidth(5);
		lettre = new Text(Character.toString(let));
		lettre.setFont(new Font("Comic Sans MS", 18));
		lettre.setFill(Color.web("#cc6600"));
		lettre.setX(7);
		lettre.setY(22);

		this.getChildren().add(rect);
		this.getChildren().add(lettre);
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rect.setFill(Color.web("#33ffcc"));
			}
		});

		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rect.setFill(Color.web("#ffffcc"));
			}
		});

		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rect.setFill(Color.web("#ffff00"));
				clavierV.setLettre(let);
			}
		});
	}

	/************************* getters and setters *********************/
	public char getLet() {
		return let;
	}

	public void setActive(boolean a) {
		if (a) {
			lettre.setText(Character.toString(let));
			rect.setFill(Color.web("#ffffcc"));
			rect.setStroke(Color.web("#cc6600"));
		} else {
			lettre.setText(" ");
			rect.setFill(Color.web("#99ffff"));
			rect.setStroke(Color.web("#99ffff"));
		}
		this.setDisable(!a);
	}

}
