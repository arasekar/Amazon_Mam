package com.basicscript.reusableintroduction;

public class JavaBasic {

	private static void voterLimit() throws Exception { 

		int age = 2;

		if (age >= 18) {
			System.out.println("they can vote");
		} else {
			throw new UserDefinedException("age limit execption");
		}

	}

	public static void main(String[] args) throws Throwable {  
		voterLimit();
	}
}
