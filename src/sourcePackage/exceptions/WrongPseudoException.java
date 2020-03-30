package sourcePackage.exceptions;

public class WrongPseudoException extends Exception{
	
	/**************** les atributs *****************/
	
	private String message = "Pseudo forme non acceptable";

	/*************** Les setters/gtters *************/
	public String getMessage(){
		return message;
	}
}
