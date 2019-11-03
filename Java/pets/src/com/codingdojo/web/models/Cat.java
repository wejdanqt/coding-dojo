package com.codingdojo.web.models;

public class Cat extends Animal implements pet{
	public Cat() {
		
	}
	public Cat (String name , String breed, int wieght) {
		super(name , breed , wieght);
	}
	
	
	public String showAffection() {
		return this.name + " is looked at you :)";
	}

}
