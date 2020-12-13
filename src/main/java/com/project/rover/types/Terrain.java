package com.project.rover.types;

public enum Terrain {
	DIRT("dirt"),
	WATER("water"),
	ROCK("rock"),
	SAND("sand");
	
	private String value;
	
	private Terrain(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
