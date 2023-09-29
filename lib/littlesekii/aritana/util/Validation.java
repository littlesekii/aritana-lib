package lib.littlesekii.aritana.util;

public class Validation {

    public static boolean notBlank(String str) { return str.trim() != ""; }
	
	public static boolean notNull(Object obj) {	return obj != null;	}
	
	public static boolean notValid(Object obj) { 
		return 
			!notBlank(String.valueOf(obj)) 
			|| !notNull(obj);
	}

	public static boolean validCPF(String str) {

		boolean valid = false;

		if (str.length() == 11) {

			int firstDigit = Character.getNumericValue(str.charAt(9));
			int lastDigit =  Character.getNumericValue(str.charAt(10));
	
			//validate first digit
			int verifier = 0;
			for (int i = 1; i <= 9; i++)
				verifier += Character.getNumericValue(str.charAt(i - 1)) * i;

			verifier %= 11;

			verifier = (verifier == 10) ? 0 : verifier;

			if (firstDigit == verifier) {

				//validate last digit
				verifier = 0;
				for (int i = 0; i <= 10; i++) 
					verifier += Character.getNumericValue(str.charAt(i)) * ((i == 10) ? 0 : i);
				
				verifier %= 11;

				verifier = (verifier == 10) ? 0 : verifier;

				if (lastDigit == verifier) 
					valid = true;

			}

		} 

		return valid;
	}

}
