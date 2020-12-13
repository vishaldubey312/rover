package com.project.rover.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rover {

	private String is;
	
	private Performs performs;

	public String getIs() {
		return is;
	}

	public void setIs(String is) {
		this.is = is;
	}

	public Performs getPerforms() {
		return performs;
	}

	public void setPerforms(Performs performs) {
		this.performs = performs;
	}
	
}

class Performs {
	
	@JsonProperty("collect-sample")
	private PerformTask collectSample;
	
	@JsonProperty("item-usage")
	private PerformTask itemUsage;

	public PerformTask getCollectSample() {
		return collectSample;
	}

	public void setCollectSample(PerformTask collectSample) {
		this.collectSample = collectSample;
	}

	public PerformTask getItemUsage() {
		return itemUsage;
	}

	public void setItemUsage(PerformTask itemUsage) {
		this.itemUsage = itemUsage;
	}
}