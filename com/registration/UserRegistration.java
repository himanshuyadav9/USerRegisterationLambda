package com.registration;

import java.util.Scanner;
import java.util.regex.Pattern;

@FunctionalInterface
interface IValidateFunction{
	 boolean validate(String x);
}
public class UserRegistration  {
	IValidateFunction isValidFirstName = (x) -> {
		String firstNamePattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern pattern = Pattern.compile(firstNamePattern);
		boolean result = pattern.matcher(x).matches();
		if (result == true) {
			System.out.println("Valid FirstName");;
		}
		else
			try {
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.INVALID_FIRSTNAME,
						"Invalid First Name");
			} catch (UserRegistrationException e) {
				e.printStackTrace();
			}
		return result;
	};
	
	IValidateFunction isValidLastName = (x) -> {
		String lastNamePattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern pattern = Pattern.compile(lastNamePattern);
		boolean result = pattern.matcher(x).matches();
		if (result == true)
			System.out.println("Valid Last Name");
			else	
			try {
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.INVALID_LASTNAME,
						"Invalid Last Name");
			} catch (UserRegistrationException e) {
				e.printStackTrace();
			}
			
		return result;
	};
 
	IValidateFunction isValidEmail = (x) -> {
		String emailPattern = "^[a-z]{1,}([.]?[-]?[+]?[a-z0-9]{1,})?[@]{1}[a-z0-9]{1,}[.]{1}[a-z]{2,4}([.]?[a-z]{2,4})?$";
		Pattern pattern = Pattern.compile(emailPattern);
		boolean result = pattern.matcher(x).matches();
		if (result == true)
			System.out.println("Valid Email");
		else
			try {
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.INVALID_EMAIL, "Invalid Email");
			} catch (UserRegistrationException e) {
				e.printStackTrace();
			}
		return result;
	};

	IValidateFunction isValidPhoneNumber = (x) -> {
		String phoneNumberPattern  = "^[+]?[0-9]{2}[ ][0-9]{10}$";
		Pattern pattern = Pattern.compile(phoneNumberPattern);
		boolean result = pattern.matcher(x).matches();
		if (result == true)
		System.out.println("Valid Phone Number");
		else
			try {
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.INVALID_MOBILENUMBER,
						"Invalid Mobile number");
			} catch (UserRegistrationException e) {
				e.printStackTrace();
			}
		return result;
	};

	IValidateFunction isValidPassword = (x) -> {
		String passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?!(?:.*[!@#$%^&*]){2})[a-zA-Z0-9!@#$%^&*]{8,}$";
		Pattern pattern = Pattern.compile(passwordPattern);
		boolean result = pattern.matcher(x).matches();
		if (result == true)
			return result;
		else
			try {
				throw new UserRegistrationException(UserRegistrationException.ExceptionType.INVALID_PASSWORD,
						"Invalid Password");
			} catch (UserRegistrationException e ) {
				e.printStackTrace();
			}
		return result;
	};

	public static void main(String[] args) throws UserRegistrationException {

		UserRegistration user = new UserRegistration();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to User Registration System ");
		System.out.println("Enter First Name");
		String firstName = scanner.nextLine();
		user.isValidFirstName.validate(firstName);
		
		System.out.println("Enter Last Name");
		String lastName = scanner.nextLine();
		user.isValidLastName.validate(lastName);
	
		System.out.println("Enter Email");
		String email = scanner.nextLine();
		user.isValidEmail.validate(email);
		System.out.println("Enter Mobile Number");
		String mobile = scanner.nextLine();
		user.isValidPhoneNumber.validate(mobile);
		System.out.println("Enter Password");
		String password = scanner.nextLine();
		user.isValidPassword.validate(password); 
	}

}
    

		
