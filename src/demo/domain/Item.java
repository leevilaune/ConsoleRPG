package demo.domain;

import demo.domain.enums.Rarity;

public class Item {
	
	protected String name;
	protected String id;
	protected Rarity rarity;
	
	public Item(String id, String name, Rarity rarity) {
		this.name = name;
		this.id = id;
		this.rarity = rarity;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public Rarity getRarity() {
		return this.rarity;
	}
	public void setRarity(Rarity r) {
		this.rarity = r;
	}
	
	public String toString() {
		return this.name;
	}
}
