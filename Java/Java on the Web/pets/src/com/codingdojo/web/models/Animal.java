package com.codingdojo.web.models;

public class Animal {
	protected String name;
	protected String breed;
	protected int weight;
	
	public Animal() {
		
	}
	
	public Animal(String name , String breed , int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}

	
	public String getName() {
		return this.name;
		
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public String getBreed() {
		return this.breed;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setBreed (String breed) {
		this.breed = breed;
	}
}
