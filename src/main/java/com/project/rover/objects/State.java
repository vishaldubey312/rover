package com.project.rover.objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.rover.types.Action;

public class State {

	private String name;
	
	@JsonProperty("allowed-actions")
	private List<Action> allowedActions = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Action> getAllowedActions() {
		return allowedActions;
	}

	public void setAllowedActions(List<Action> allowedActions) {
		this.allowedActions = allowedActions;
	}
	
	
}
