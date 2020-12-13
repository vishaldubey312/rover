package com.project.rover.objects;

import java.util.List;

public class Scenario {

	private String name;
	
	private List<ScenarioCondition> conditions;
	
	private List<Rover> rover;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ScenarioCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<ScenarioCondition> conditions) {
		this.conditions = conditions;
	}

	public List<Rover> getRover() {
		return rover;
	}

	public void setRover(List<Rover> rover) {
		this.rover = rover;
	}
	
	
}
