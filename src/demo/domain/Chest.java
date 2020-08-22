package demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chest {
	
	private Random random;
	private String name;
	private List<Gear> dropPoolCommons;
	private List<Gear> dropPoolRares;
	private List<Gear> dropPoolLegendaries;
	private double commonDropChance;
	private double rareDropChance;
	private double legendaryDropChance;
	
	public Chest(String name, double cdc, double rdc, double ldc) {
		this.name = name;
		this.random = new Random();
		this.commonDropChance = cdc;
		this.rareDropChance = rdc;
		this.legendaryDropChance = ldc;
		this.dropPoolCommons = new ArrayList<>();
		this.dropPoolRares = new ArrayList<>();
		this.dropPoolLegendaries = new ArrayList<>();
	}
	public void setCommonDropPool(List<Gear> dP) {
		this.dropPoolCommons = dP;
	}
	public void setRareDropPool(List<Gear> dP) {
		this.dropPoolRares = dP;
	}
	public void setLegendaryDropPool(List<Gear> dP) {
		this.dropPoolLegendaries = dP;
	}
	public Gear open() {
		return this.randomizeDrop();
	}
	private Gear randomizeDrop() {
		if(this.random.nextDouble() <= this.legendaryDropChance) {
			return this.dropPoolLegendaries.get(this.random.nextInt(this.dropPoolLegendaries.size()));
		}
		if(this.random.nextDouble() <= this.rareDropChance) {
			return this.dropPoolRares.get(this.random.nextInt(this.dropPoolRares.size()));
		}
		if(this.random.nextDouble() <= this.commonDropChance) {
			return this.dropPoolCommons.get(this.random.nextInt(this.dropPoolCommons.size()));
		}
		return null;
		
	}
	public String toString() {
		return this.name;
	}
}
