package interfacePackage.scenePrincipale;

import sourcePackage.*;
import javafx.scene.Parent;

public class SessionView extends Parent {

	private MotView motV;
	private ClavierView clavierV;
	private Pendu pendu;
	private OptionView optionV;
	private Home home;
	private BarreScoreView barreV;
	private Session session;

	/************************* Le constructeur ************************/
	
	public SessionView(Session session) {

		this.session = session;
		motV = new MotView(session.suivant(), this);
		clavierV = new ClavierView(motV);
		home = new Home(session);
		optionV = new OptionView();
		barreV = new BarreScoreView(session.getBestScore());
		pendu = new Pendu();
		this.getChildren().add(pendu);
		this.getChildren().add(motV);
		this.getChildren().add(barreV);
		this.getChildren().add(home);
		this.getChildren().add(optionV);
		this.getChildren().add(clavierV);

	}

	
	/***************** gettres and setters ****************************/
	
	public void setMotV(MotView motV) {
		this.motV = motV;
	}

	public ClavierView getClavierV() {
		return clavierV;
	}

	public Session getSession() {
		return session;
	}

	/***********************   Les m�thodes   *************************/
	
	public Mot suivant() {
		Mot m = session.suivant();
		pendu.setPendu(session.getNbMotPerdu());
		barreV.upDateScore(session.getScore());
		return m;
	}

	public void updateMotV(Mot mot) {
		if (mot != null) {
			this.getChildren().remove(motV);
			this.getChildren().remove(clavierV);
			motV = new MotView(mot, this);
			this.getChildren().add(motV);
			clavierV = new ClavierView(motV);
			this.getChildren().add(clavierV);
			barreV.upDateNumMot();
		}
	}	
}
