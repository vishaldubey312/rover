package com.project.rover.objects;

import com.project.rover.types.InventoryType;

public class PerformTask {

	private InventoryType type;
	
	private int qty;


	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public InventoryType getType() {
		return type;
	}

	public void setType(InventoryType type) {
		this.type = type;
	}
}
