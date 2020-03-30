package sourcePackage;

import java.util.*;

public class Session {

	/**************** les atributs *****************/

	private Joueur joueur;
	private Mot[] mots;
	static final int nbMot = 10;
	private int motCourant;
	private int score;
	private final int maxMotRate = 6;
	private int nbMotPerdu;
	private boolean perdu;
	private boolean finie;

	/**************** le constructeur *****************/

	public Session(Joueur joueur, String[] lignes) {
		this.joueur = joueur;
		score = 0;
		nbMotPerdu = 0;
		motCourant = -1;
		perdu = false;
		finie = false;
		mots = aleaMots(lignes);
	}



	/**************** Les methodes *****************/

	public boolean isPerdu() {
		return perdu;
	}

	public int getBestScore(){
		return joueur.getMielleurScore();
	}

	public int getNbMotPerdu() {
		return nbMotPerdu;
	}
	
	public int getScore() {
		return score;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	// Role: passe au mot suivant
	public Mot suivant() {
		
		if (motCourant != -1) {
			mots[motCourant].calculScore();
			this.score += mots[motCourant].getScore();
			System.out.print(score);
			if (mots[motCourant].isPerdu())
				nbMotPerdu++;
		}
		
		if (nbMotPerdu == 6) {
			perdu = true;
			finie = true;
		} else {
			motCourant++;
			if (motCourant == nbMot)
				finie = true;
			else
				return mots[motCourant];
		}
		return null;
	}

	// Role: g�n�re un tableau de mot al�atoire
	public Mot[] aleaMots(String[] lignes){
		int i;
		Mot[] mots = new Mot[nbMot];
		for(i=0 ; i < nbMot ; i++){
			mots[i]= Mot.toMot(lignes[i]);
			
		}
		return mots;
	}
}
