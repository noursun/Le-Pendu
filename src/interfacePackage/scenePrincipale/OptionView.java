package interfacePackage.scenePrincipale;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OptionView extends Parent {

	private final String voicePath = "interfacePackage/images/voice.png";
	private final String noVoicePath = "interfacePackage/images/noVoice.png";
	private final String musicPath = "interfacePackage/images/music.png";
	private final String noMusicPath = "interfacePackage/images/noMusic.png";
	private Rectangle rectV;
	private Rectangle rectM;

	public OptionView() {
		rectV = new Rectangle(39, 39, Color.MEDIUMVIOLETRED);
		rectV.setStroke(Color.MEDIUMVIOLETRED);
		rectV.setStrokeWidth(2);
		rectV.setArcHeight(15);
		rectV.setArcWidth(15);
		rectV.setX(0);
		rectV.setY(0);
		rectM = new Rectangle(39, 39, Color.MEDIUMVIOLETRED);
		rectM.setStroke(Color.MEDIUMVIOLETRED);
		rectM.setStrokeWidth(2);
		rectM.setArcHeight(15);
		rectM.setArcWidth(15);
		rectM.setX(49);
		rectM.setY(0);
		ImageView imgVoice = new ImageView(voicePath);
		imgVoice.setX(2);
		imgVoice.setY(2);
		ImageView imgMusic = new ImageView(musicPath);
		imgMusic.setX(51);
		imgMusic.setY(2);
		this.getChildren().add(rectV);
		this.getChildren().add(rectM);
		this.getChildren().add(imgMusic);
		this.getChildren().add(imgVoice);
		this.setTranslateX(10);
		this.setTranslateY(10);

		imgVoice.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rectV.setStroke(Color.WHITE);
			}
		});

		imgVoice.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rectV.setStroke(Color.MEDIUMVIOLETRED);
			}
		});

		imgVoice.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				String url = imgVoice.getImage().impl_getUrl();
				if (url.equals(voicePath))
					imgVoice.setImage(new Image(noVoicePath));
				else
					imgVoice.setImage(new Image(voicePath));
			}
		});

		imgMusic.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rectM.setStroke(Color.WHITE);
			}
		});

		imgMusic.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				rectM.setStroke(Color.MEDIUMVIOLETRED);
			}
		});

		imgMusic.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				String url = imgMusic.getImage().impl_getUrl();
				if (url.equals(musicPath))
					imgMusic.setImage(new Image(noMusicPath));
				else
					imgMusic.setImage(new Image(musicPath));
			}
		});

	}
}
