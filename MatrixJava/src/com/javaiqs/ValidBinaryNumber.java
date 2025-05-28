package com.javaiqs;

public class ValidBinaryNumber {

	public boolean isValidBinary(String number) {
		return number.matches("[01]+");
	}

	public boolean isValidBinary(int number) {
		boolean isBinary = true;
		while(number != 0) {
			if (number%10 > 1) {
				isBinary =  false;
				break;
			} 
			number = number/10;
		}
		
		return isBinary;
	}
	
	public boolean isValidBin(int number) {
		try {
			Integer.parseInt(String.valueOf(number), 2);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		ValidBinaryNumber binaryNumber = new ValidBinaryNumber();
		
		System.out.println("IsBinary:"+binaryNumber.isValidBinary("111111110000"));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary("111111110000111111111111111111110000000000000"));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary("111111111122200000089760000000"));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary("0000010"));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary("010"));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(1000020000));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(77777777));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(1010100001));
		System.out.println("-----------------------------------");
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(010));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(000000101));
		System.out.println("-----------------------------------");
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(0));
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(1));
		
		System.out.println("-----------------------------------");
		System.out.println("IsBinary:"+binaryNumber.isValidBin(1000020000));
		System.out.println("IsBinary:"+binaryNumber.isValidBin(77777777));
		System.out.println("IsBinary:"+binaryNumber.isValidBin(1010100001));
		System.out.println("-----------------------------------");
		System.out.println("IsBinary:"+binaryNumber.isValidBin(0010));
		System.out.println("-----------------------------------");
		System.out.println("IsBinary:"+binaryNumber.isValidBinary(1));
		
		System.out.println(010%10);
	}

}
