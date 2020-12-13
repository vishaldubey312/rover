package com.project.rover.types;

public enum Direction {

	UP("up"),
	DOWN("down"),
	LEFT("left"),
	RIGHT("right");
	
	private String value;
	
	private Direction(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
