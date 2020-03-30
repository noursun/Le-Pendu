package sourcePackage;

public abstract class Case {

	/**************** les atributs *****************/

	private char lettre;
	protected Mot mot;
	private int score;
	private boolean perdu;
	private boolean traite;
	private int malus;

	/****************    le constructeur *****************/

	public Case(char let,Mot mot){
		lettre = let;
		score = 0;
		perdu = false;
		traite = false;
		this.mot = mot;
		malus = 0;
	}

	/*************** Les setters/gtters *************/

	public void setTraite(boolean traite) {
		this.traite = traite;
	}

	public boolean isTraite() {
		return traite;
	}

	public char getLettre() {
		return lettre;
	}

	public void setPerdu(boolean perdu) {
		this.perdu = perdu;
	}

	public boolean isPerdu() {
		return perdu;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public abstract String getColor();

	public abstract int getCoeff();

	public abstract boolean calculScore(char let);

	public char[] aleaPropo(){
		return null;
	}

	public int getMalus() {
		return malus;
	}

	public void setMalus(int malus) {
		this.malus = malus;
	}

	/**************** Les methodes *****************/

	// Role: génère une case de type aléatoire

	public static Case aleaCase(char let,Mot mot){

		int i = (int) ( 197/Math.random() % 3);// générer un nombre aléatoir entre 0 et 2
		if(i == 0)
			return new MultiChance(let,mot); // 0 pour la case multichance
		if(i == 1)
			return new Proposition(let,mot); // 1 pour proposition
		return new ZeroChance(let,mot);      // 2 pour zerochance
	}
}