package sourcePackage.exceptions;

public class JoueurNotFoundException extends Exception{
	
	/**************** les atributs *****************/
	
	private String message = "Le joueur n'existe pas";

	/*************** Les setters/gtters *************/
	public String getMessage(){
		return message;
	}
}
