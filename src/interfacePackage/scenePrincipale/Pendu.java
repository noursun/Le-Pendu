package interfacePackage.scenePrincipale;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pendu extends Parent {
	
	private final String[] pendu = new String[]{"interfacePackage/images/pendu0.png","interfacePackage/images/pendu1.png","interfacePackage/images/pendu2.png","interfacePackage/images/pendu3.png","interfacePackage/images/pendu4.png", "interfacePackage/images/pendu5.png"};
	private ImageView imgPendu;
	
	/**************** le constructeur ************************/
	public Pendu(){
		imgPendu = new ImageView();
		this.getChildren().add(imgPendu);
		this.setTranslateX(220);
		this.setTranslateY(50);
	}

	// choisit l'image � afficher selon le nombre des mot perdus
	public void setPendu(int nbMotPerdu){
		if(nbMotPerdu != 0)
			imgPendu.setImage(new Image(pendu[nbMotPerdu - 1]));
	}
}
