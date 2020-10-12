package demo.domain;

import demo.domain.enums.Rarity;

public class Material extends Item{

	private int amount;
	
	public Material(String id, String name, Rarity rarity) {
		super(id, name, rarity);
		this.amount = 1;
	}
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int a) {
		this.amount = a;
	}
	
	public void use(int a) {
		if(this.amount - a < 0) {
			System.out.println("You don't have enough " + this.name);
		}else {
			this.amount -= a;
		}
	}
	@Override
	public String toString() {
		if(amount <= 1) {
			return this.name;
		}else {
			return this.name + ", " + this.amount;
		}
	}
}
