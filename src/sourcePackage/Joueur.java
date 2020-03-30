package sourcePackage;


public class Joueur {
	
	/**************** les atributs *****************/
	
	private String pseudonyme;
	private int mielleurScore;
	private final int minLenght = 4;

	/****************    le constructeur *****************/
	
	public Joueur(String ps, int mScore) {
		this.pseudonyme = ps;
		this.mielleurScore = mScore;
	}



	/*************** Les setters/gtters *************/

	public String getPseudonyme() {
		return pseudonyme;
	}
	public int getMielleurScore() {
		return mielleurScore;
	}
	public void setMielleurScore(int mielleurScore) {
		this.mielleurScore = mielleurScore;
	}
	/**************** Les methodes *****************/
	
	// Role: v�rifie si le pseudonyme est valide ie s'il commence pas une lettre et si sa taille d�passe 3 chars
	public static boolean testPseudo(String ps) {
		if (ps.length() >= 4){
			if(Character.isAlphabetic(ps.charAt(0)))
				return true;
		}

		return false;
	}

}
