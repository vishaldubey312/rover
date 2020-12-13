package com.project.rover.types;

public enum Action {
	MOVE("move"), COLLECT_SAMPLE("collect-sample");
	
	private String value;
	
	private Action(String value) {
		this.value = value;
	}
	
	private String getValue() {
		return this.value;
	}
}
