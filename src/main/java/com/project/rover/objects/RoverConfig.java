package com.project.rover.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoverConfig {

	private List<Scenario> scenarios;
	
	private List<State> states;
	
	@JsonProperty("deploy-point")
	private Map<String, Integer> deployPoint = new HashMap<>();
	
	@JsonProperty("initial-battery")
	private int initialBattery;
	
	private List<InventoryItem> inventory = new ArrayList<>();

	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public Map<String, Integer> getDeployPoint() {
		return deployPoint;
	}

	public void setDeployPoint(Map<String, Integer> deployPoint) {
		this.deployPoint = deployPoint;
	}

	public int getInitialBattery() {
		return initialBattery;
	}

	public void setInitialBattery(int initialBattery) {
		this.initialBattery = initialBattery;
	}

	public List<InventoryItem> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryItem> inventory) {
		this.inventory = inventory;
	}
	
	
}
