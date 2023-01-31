package com.basicscript.reusableintroduction1;

public class Base4 {
	public static void main(String[] args) {
		Base3 a = new Base3();
		System.out.println(a.getA());
		a.setA(89);
		System.out.println(a.getA());
	}
}
