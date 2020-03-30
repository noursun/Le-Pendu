package sourcePackage.exceptions;

public class ExistingPseudoException extends Exception{
	
	/**************** les atributs *****************/
	
	private String message = "Joueur existant ! ";
	
	/*************** Les setters/gtters *************/

	public String getMessage(){
		return message;
	}
}
