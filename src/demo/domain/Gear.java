package demo.domain;

import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class Gear extends Item{
	
	private int power;
	private int level;
	private boolean isFound;
	private boolean isUpgraded;
	private boolean isMaxLevel;
	private Element element;
	private Stats stats;
	private int baseAttack;
	private int baseHP;
	private int basePower;
	private int attackBoost;
	private int hpBoost;
	
	public Gear(String id,String name,int power,Rarity rarity,Element element,Stats stats) {
		super(id, name, rarity);
		this.stats = stats;
		this.power = power;
		this.level = 1;
		this.element = element;
		this.isFound = false;
		this.isUpgraded = false;
		this.isMaxLevel = false;
		
		this.baseAttack = stats.getAttack();
		this.baseHP = stats.getHP();
		this.basePower = power;
		
		this.attackBoost = stats.getAttack();
		this.hpBoost = stats.getHP();
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int l) {
		this.level = l;
	}
	public int getAttackBoost() {
		return this.attackBoost;
	}
	public void setAttackBoost(int atkB) {
		this.attackBoost = atkB;
	}
	public int getHPBoost() {
		return this.hpBoost;
	}
	public void setHPBoost(int hpB) {
		this.hpBoost = hpB;
	}
	public int getPower() {
		return this.power;
	}
	public void setPower(int p) {
		this.power = p;
	}
	public Element getElement() {
		return this.element;
	}
	public void setElement(Element e) {
		this.element = e;
	}
	public Stats getStats() {
		return this.stats;
	}
	public void setStats(Stats s) {
		this.stats = s;
	}
	public String getID() {
		return super.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getSetID() {
		String[] parts = this.name.split(" ",3);
		if(parts.length == 3) {
			return parts[0] + " " + parts[1];
		}
		return parts[0];
	}
	public void setFound(boolean b) {
		this.isFound = b;
	}
	public boolean isFound() {
		return this.isFound;
	}
	public void setUpgraded(boolean b) {
		this.isUpgraded = b;
	}
	public boolean isUpgraded() {
		return this.isUpgraded;
	}
	public void setMaxLevel(boolean b) {
		this.isMaxLevel = b;
	}
	public boolean isMaxLevel() {
		return this.isMaxLevel;
	}
	public void upgrade() {
		if(this.rarity == Rarity.COMMON && this.level < 20) {
			this.level++;
			this.power += this.basePower;
			this.attackBoost += this.baseAttack;
			this.hpBoost += this.baseHP;
			this.stats.setAttack(this.attackBoost);
			this.stats.setHP(this.hpBoost);
			this.isUpgraded = true;
		}else if(this.rarity == Rarity.RARE && this.level < 50) {
			this.level++;
			this.power += this.basePower;
			this.attackBoost += this.baseAttack;
			this.hpBoost += this.baseHP;
			this.stats.setAttack(this.attackBoost);
			this.stats.setHP(this.hpBoost);
			this.isUpgraded = true;
		}else if(this.rarity == Rarity.LEGENDARY && this.level < 100) {
			this.level++;
			this.power += this.basePower;
			this.attackBoost += this.baseAttack;
			this.hpBoost += this.baseHP;
			this.stats.setAttack(this.attackBoost);
			this.stats.setHP(this.hpBoost);
			this.isUpgraded = true;
		}
		else {
			this.isMaxLevel = true;
			System.out.println("Gear is at max level");
		}
	}
	
	public void upgrade(int times) {
		this.level += times;
		this.power += (10 * times);
	}
	public void printDetails() {
		System.out.println("  " + this.toString() + ", " + this.level);
		System.out.print("    Element: " + this.element);
		System.out.println(this.stats);
		
	}
	public void printStats() {
		System.out.println(this.stats);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + power;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gear other = (Gear) obj;
		if (level != other.level)
			return false;
		if (power != other.power)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return this.name + ", " + super.rarity;
	}
}
