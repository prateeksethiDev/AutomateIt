package com.prac;

class Person{
	public void show(){
		System.out.println("Person show");
	}
}

class Student extends Person{
	public void show() {
		System.out.println("Student show");
		throw new RuntimeException("runtime exep");
	}
}

public class Test {
	
	public static void main(String[] args) {
		Student st = new Student();
		st.show();	
	}
}