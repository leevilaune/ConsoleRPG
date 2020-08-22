package demo.domain;

import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class Gear extends Item{
	
	private int power;
	private int level;
	private boolean isFound;
	private Element element;
	private Stats stats;
	private int attackBoost;
	private int hpBoost;
	
	public Gear(String id,String name,int power,Rarity rarity,Element element,Stats stats) {
		super(id, name, rarity);
		this.stats = stats;
		this.power = power;
		this.level = 1;
		this.element = element;
		this.isFound = false;
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
	public void setFound(boolean b) {
		this.isFound = b;
	}
	public boolean isFound() {
		return this.isFound;
	}
	public void upgrade() {
		this.level++;
		this.power += 10;
	}
	public void upgrade(int times) {
		this.level += times;
		this.power += (10 * times);
	}
	public void printDetails() {
		System.out.println("  " + this.toString());
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
