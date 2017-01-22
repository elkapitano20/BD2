package exceptions;

public class LoginException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//Parameterless Constructor
		public LoginException() {}

		//Constructor that accepts a message
		public LoginException(String message)
		{
			super(message);
		}

}
