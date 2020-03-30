package sourcePackage;


public class MultiChance extends Case implements Malus{
	
	/**************** les atributs *****************/
	
	private final int coeff = 1;
	private final int maxChances = 3;
	private int nbChanceRest ; 
	private final String color = "#00bfff";
	
	/****************    le constructeur *****************/
	
	public MultiChance(char let,Mot mot){
		super(let,mot);
		nbChanceRest = maxChances;
	}
	
	/**************** Les methodes *****************/
	public String getColor(){
		return color;
	}
	
	public int getCoeff() {
		return coeff;
	}
	
	
	// Role: calcule le score d'une case
	public boolean calculScore(char let){
		
		nbChanceRest --;
		
		if(getLettre() == let){ // si la r�ponce est juste
			setScore(getScore() + coeff);
			setTraite(true);
			mot.decNbLetNonTraites(); // on d�cr�monte le nombre de lettres non trait�es dans le mot
		}
		
		else{
			setScore(getScore() + malus()); // si la r�ponce est fausse
			if (nbChanceRest == 0){ // si il ne reste plus de chances
				setPerdu(true);
				mot.setPerdu(true);
				setTraite(true);
			}
		}
		return isTraite();
	}
	
	// Role: retourne le malus
	public  int malus(){
		if(mot.getNbCaseMultiPropo() > 5)
			return -1;
		return 0; // si le nombre des cases multiChances et propositions est inf�rieur � 6 pas de malus
	}
}
