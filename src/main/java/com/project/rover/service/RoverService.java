package com.project.rover.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.rover.exception.RoverException;
import com.project.rover.objects.DirectionObject;
import com.project.rover.objects.Environment;
import com.project.rover.objects.InventoryItem;
import com.project.rover.objects.RoverConfig;
import com.project.rover.types.Direction;
import com.project.rover.types.InventoryType;
import com.project.rover.types.Terrain;

@Service
public class RoverService {

	private Environment environment;
	
	private RoverConfig roverConfig;
	
	private Map<String, Integer> location = new HashMap<>();
	
	private int battery;
	
	private boolean immobile = false;
	
	public void configureEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public Environment modifyEnvironment(Map<String, Object> property) throws RoverException {
		if(property.containsKey("temperature")) {
			this.environment.setTemperature((int)property.get("temperature"));
		}
		if(property.containsKey("humidity")) {
			this.environment.setHumidity((int)property.get("humidity"));
		}
		if(property.containsKey("area-map")) {
			this.environment.setAreaMap((Terrain[][])property.get("area-map"));
		}
		if(property.containsKey("solar-flare")) {
			this.environment.setSolarFlare((boolean)property.get("solar-flare"));
		}
		if(property.containsKey("storm")) {
			this.environment.setStorm((boolean)property.get("storm"));
			if(this.environment.isStorm()) {
				this.immobile = true;
				if(this.roverConfig.getInventory().stream().filter(item-> item.getType().equals(InventoryType.STORM_SHIELD)).count() == 0) {
					throw new RoverException("Rover Dead");
				}
				this.roverConfig.getInventory().removeIf(item -> item.getType().equals(InventoryType.STORM_SHIELD));
			} else {
				this.immobile = false;
			}
		}
		return this.environment;
	}
	
	public void configureRover(RoverConfig config) {
		this.roverConfig = config;
		this.location = config.getDeployPoint();
		this.battery = config.getInitialBattery();
		
	}
	
	public RoverConfig moveRover(DirectionObject directionObj) throws RoverException {
		int row = location.get("row");
		int column = location.get("column");
		Terrain previousTerrain = this.environment.getAreaMap()[row][column];
		if(immobile) {
			throw new RoverException("Cannot move during a storm");
		} 
		switch (directionObj.getDirection()) {
		case UP:
			if(row > 1) {				
				row--;
			} else {
				throw new RoverException("Can move only within mapped area");
			}
			break;
		case DOWN:
			if(row < this.environment.getAreaMap().length) {				
				row++;
			} else {
				throw new RoverException("Can move only within mapped area");
			}
			break;
		case LEFT:
			if(column > 1) {				
				column--;
			} else {
				throw new RoverException("Can move only within mapped area");
			}
			break;
		case RIGHT:
			if(column < this.environment.getAreaMap()[row].length) {				
				column++;
			} else {
				throw new RoverException("Can move only within mapped area");
			}
			break;
		default:
			break;
		}
		
		Terrain latestTerrain = this.environment.getAreaMap()[row][column];
		
		if(previousTerrain.equals(Terrain.DIRT) && latestTerrain.equals(Terrain.WATER)) {
			this.roverConfig.getInventory().add(new InventoryItem(InventoryType.WATER_SAMPLE, 2, 2));
		}
		
		battery--;
		this.location.put("row", row);
		this.location.put("column", column);
		
		return this.roverConfig;
	}
	
	
	public Map<String, Object> roverStatus() {
		int row = location.get("row");
		int column = location.get("column");
		
		Map<String, Object> envMap = new HashMap<>();
		envMap.put("temperature", this.environment.getTemperature());
		envMap.put("humidity", this.environment.getHumidity());
		envMap.put("solar-flare", this.environment.isSolarFlare());
		envMap.put("storm", this.environment.isStorm());
		envMap.put("terrain", this.environment.getAreaMap()[row][column]);
		
		Map<String, Object> roverMap = new HashMap<>();
		roverMap.put("location", this.location);
		roverMap.put("battery", this.battery);
		roverMap.put("inventory", this.roverConfig.getInventory());
		
		Map<String, Object> finalMap = new HashMap<>();
		finalMap.put("rover", roverMap);
		finalMap.put("environment", envMap);
		
		return finalMap;
	}
	
}
