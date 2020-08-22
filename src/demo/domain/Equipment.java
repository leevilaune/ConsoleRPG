package demo.domain;

import demo.domain.items.starterset.*;

public class Equipment {
	
	private Slot weaponSlot;
	private Slot helmetSlot;
	private Slot chestplateSlot;
	private Slot pantsSlot;
	private Slot bootsSlot;
	
	public Equipment() {
		
		this.weaponSlot = new Slot("Weapon");
		this.helmetSlot = new Slot("Helmet");
		this.chestplateSlot = new Slot("Chestplate");
		this.pantsSlot = new Slot("Pants");
		this.bootsSlot = new Slot("Boots");
		
		this.setInitialEquipment();
		
	}
	private void setInitialEquipment() {
		this.weaponSlot.setGear(new AdventurerSword());
		this.chestplateSlot.setGear(new BasicChestplate());
		this.helmetSlot.setGear(new BasicHelmet());
		this.pantsSlot.setGear(new BasicPants());
		this.bootsSlot.setGear(new BasicBoots());
	}
	public int getTotalPower() {
		int totPower = 0;
		totPower += this.weaponSlot.getPower();
		totPower += this.helmetSlot.getPower();
		totPower += this.chestplateSlot.getPower();
		totPower += this.pantsSlot.getPower();
		totPower += this.bootsSlot.getPower();
		
		return totPower;
	}
	public int getHPBoost() {
		int hpBoost = 0;
		hpBoost += this.weaponSlot.getHPBoost();
		hpBoost += this.helmetSlot.getHPBoost();
		hpBoost += this.chestplateSlot.getHPBoost();
		hpBoost += this.pantsSlot.getHPBoost();
		hpBoost += this.bootsSlot.getHPBoost();
		return hpBoost;
	}
	public int getAttackBoost() {
		int attackBoost = 0;
		attackBoost += this.weaponSlot.getAttackBoost();
		attackBoost += this.helmetSlot.getAttackBoost();
		attackBoost += this.chestplateSlot.getAttackBoost();
		attackBoost += this.pantsSlot.getAttackBoost();
		attackBoost += this.bootsSlot.getAttackBoost();
		return attackBoost;
	}
	public void setWeapon(Gear g) {
		if(g.getID().equals("Weapon")) {
			this.weaponSlot.setGear(g);
		}else {
			System.out.println("Gear doesnt fit in this slot");
		}
	}
	public Gear getWeapon() {
		return this.weaponSlot.getGear();
	}
	public void setHelmet(Gear g) {
		if(g.getID().equals("Helmet")) {
			this.helmetSlot.setGear(g);
		}else {
			System.out.println("Gear doesnt fit in this slot");
		}
	}
	public Gear getHelmet() {
		return this.helmetSlot.getGear();
	}
	public void setChestplate(Gear g) {
		if(g.getID().equals("Chestplate")) {
			this.chestplateSlot.setGear(g);
		}else {
			System.out.println("Gear doesnt fit in this slot");
		}
	}
	public Gear getChestplate() {
		return this.chestplateSlot.getGear();
	}
	public void setPants(Gear g) {
		if(g.getID().equals("Pants")) {
			this.pantsSlot.setGear(g);
		}else {
			System.out.println("Gear doesnt fit in this slot");
		}
	}
	public Gear getPants() {
		return this.pantsSlot.getGear();
	}
	public void setBoots(Gear g) {
		if(g.getID().equals("Boots")) {
			this.bootsSlot.setGear(g);
		}else {
			System.out.println("Gear doesnt fit in this slot");
		}
	}
	public Gear getBoots() {
		return this.bootsSlot.getGear();
	}
	public void printEquipment() {
		System.out.println("--Equipment--");
		System.out.println(this.weaponSlot);
		System.out.println(this.helmetSlot);
		System.out.println(this.chestplateSlot);
		System.out.println(this.pantsSlot);
		System.out.println(this.bootsSlot);
		System.out.println("Power:  " + this.getTotalPower());
		System.out.println("Attack: " + this.getAttackBoost());
		System.out.println("HP:     " + this.getHPBoost());
	}
}
