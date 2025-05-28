package com.javaiqs;

public class ValidNumber {

	public boolean isNumber(String numberString) {
		try {
			Long.parseLong(numberString);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isValidPhoneNumber(String numberString) {
		return numberString.length() == 10 && isNumber(numberString);
	}

	public boolean isValidNumberRegex(String numberString) {
//		return numberString.matches("[0-9]+");
		return numberString.matches("(^-?\\d+)?\\.?\\d+$");
	}

	public boolean isValidPhoneNumberRegex(String numberString) {
//		return numberString.matches("[0-9]{10}");
		return numberString.matches("\\d{10}");
	}

	public static void main(String[] args) {
		ValidNumber validNumber = new ValidNumber();
		System.out.println("Valid Number : " + validNumber.isNumber("165432344A"));
		System.out.println("Valid Number : " + validNumber.isNumber("1654323"));
		System.out.println("Valid Number : " + validNumber.isNumber("16543239999999999"));

		System.out.println("Valid PhoneNumber : " + validNumber.isValidPhoneNumber("12334566789io"));
		System.out.println("Valid PhoneNumber : " + validNumber.isValidPhoneNumber("1234566789"));

		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("165432344A"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("1654323"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("16543239999999999"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("-120"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("-120.09"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("-777777.0"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("777777.785"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex(".7888"));
		System.out.println("Valid Number Regex: " + validNumber.isValidNumberRegex("."));

		System.out.println("Valid PhoneNumber Regex: " + validNumber.isValidPhoneNumberRegex("12334566789io"));
		System.out.println("Valid PhoneNumber Regex: " + validNumber.isValidPhoneNumberRegex("1234566789"));
		System.out.println("Valid PhoneNumber Regex: " + validNumber.isValidPhoneNumberRegex("12334"));
		System.out.println("Valid PhoneNumber Regex: " + validNumber.isValidPhoneNumberRegex("123456622789"));
	}

}
