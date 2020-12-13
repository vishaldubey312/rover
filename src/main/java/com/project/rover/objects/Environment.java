package com.project.rover.objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.rover.types.Terrain;

public class Environment {
	
	private int temperature;
	private int humidity;
	
	@JsonProperty("solar-flare")
	private boolean solarFlare;
	
	private boolean storm;
	
	@JsonProperty("area-map")
	private Terrain[][] areaMap = new Terrain[][]{};

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public boolean isSolarFlare() {
		return solarFlare;
	}

	public void setSolarFlare(boolean solarFlare) {
		this.solarFlare = solarFlare;
	}

	public boolean isStorm() {
		return storm;
	}

	public void setStorm(boolean storm) {
		this.storm = storm;
	}

	public Terrain[][] getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(Terrain[][] areaMap) {
		this.areaMap = areaMap;
	}
	
	
}
