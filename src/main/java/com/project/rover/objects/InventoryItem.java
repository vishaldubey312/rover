package com.project.rover.objects;

import com.project.rover.types.InventoryType;

public class InventoryItem {
	
	private InventoryType type;

	private int quantity;

	private int priority;
	
	

	public InventoryItem() {
		super();
	}

	public InventoryItem(InventoryType type, int quantity, int priority) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.priority = priority;
	}

	public InventoryType getType() {
		return type;
	}

	public void setType(InventoryType type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
