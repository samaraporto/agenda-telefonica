package agenda;

public class AgendaCheiaException extends Exception{
	@Override
	public String getMessage() {
		return "A agenda já está cheia!";
	}

}
