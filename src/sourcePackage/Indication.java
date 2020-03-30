package sourcePackage;


public class Indication {
	
	/**************** les atributs *****************/
	
	private TypeIndic typeIndic;
	private String indication;
	private final int Coeff;
	
	/****************    le constructeur *****************/
	
	public Indication(String typeIndic,String indication){
		this.typeIndic = TypeIndic.valueOf(typeIndic);
		this.indication = indication;
		Coeff = this.typeIndic.ordinal() +1;
	}
	
	/*************** Les setters/gtters *************/
	
	public int getCoeff() {
		return Coeff;
	}
	
	public String toString(){
		return typeIndic + " : "+ indication + ".";
	}
}
