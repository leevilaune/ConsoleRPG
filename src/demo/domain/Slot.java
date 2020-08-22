package demo.domain;

public class Slot {
	
	private Gear gear;
	private String name;
	
	public Slot(String name) {
		this.gear = null;
		this.name = name;
	}
	public int getPower() {
		return this.gear.getPower();
	}
	public void setGear(Gear g) {
		this.gear = g;
	}
	public Gear getGear() {
		return this.gear;
	}
	public int getHPBoost() {
		return this.gear.getHPBoost();
	}
	public int getAttackBoost() {
		return this.gear.getAttackBoost();
	}
	public String toString() {
		return this.name + ": " + this.gear;
	}
}
