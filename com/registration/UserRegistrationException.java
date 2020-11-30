package com.registration;

public class UserRegistrationException extends Exception {
	enum ExceptionType{
		 INVALID_FIRSTNAME, INVALID_LASTNAME, INVALID_EMAIL, INVALID_MOBILENUMBER, INVALID_PASSWORD
	}
	private ExceptionType type;
	public ExceptionType getType() {
		return this.type;
	}
   UserRegistrationException(ExceptionType type,String message){
	   super(message);
	   this.type=type;
   }
}
