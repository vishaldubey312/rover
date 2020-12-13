package com.project.rover.types;

public enum InventoryType {
	WATER_SAMPLE("water-sample", 2),
	ROCK_SAMPLE("rock-sample", 3),
	STORM_SHIELD("storm-shield", 1);
	
	private String value;
	private int priority;
	
	private InventoryType(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	public String getValue() {
		return value;
	}
	
	public int getPriority() {
		return priority;
	}

}
