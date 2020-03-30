package sourcePackage;


public class ZeroChance extends Case{
	
	/**************** les atributs *****************/
	
	private final int coeff = 3;
	private final String color = "#c71585";
	
	/****************    le constructeur *****************/
	
	public ZeroChance(char let,Mot mot){
		super(let,mot);
	}
	
	public String getColor(){
		return color;
	}
	/**************** Les methodes *****************/
	
	public int getCoeff() {
		return coeff;
	}
	
	// Role: calcule le score d'une case
	public boolean calculScore(char let){
		
		setTraite(true);
		mot.decNbLetNonTraites();
		if(getLettre() == let)
			setScore(coeff);
		else{
			setPerdu(true);
			mot.setPerdu(true);
		}
		return isTraite();
	}
}
