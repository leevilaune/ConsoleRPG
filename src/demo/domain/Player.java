package demo.domain;

public class Player implements Character {
	
	private Equipment equip;
	private int attackPower;
	private int healPower;
	private int maxHP;
	private int hp;
	
	public Player(Equipment equip) {
		this.equip = equip;
		this.maxHP = 1000 + this.equip.getHPBoost();
		this.hp = maxHP;
		this.attackPower = equip.getAttackBoost();
		this.healPower = this.maxHP / 2;
	}
	public Equipment getEquipment() {
		return this.equip;
	}
	public void setEquipment(Equipment equip) {
		this.equip = equip;
	}
	@Override
	public void setHP(int hp) {
		this.hp = hp;
	}
	@Override
	public void attack(Character c) {
		this.attackPower = equip.getAttackBoost();
		System.out.println("  Damage dealt " + this.attackPower + " to " + c);
		c.setHP(c.getHP()-this.attackPower);
	}
	@Override
	public void heal() {
		this.hp += this.healPower;
	}
	@Override
	public int getHP() {
		return this.hp;
	}
	public void resetHP() {
		this.hp = maxHP;
	}
	@Override
	public String toString() {
		return "Player" + 
				"\n  AttackPower: " + this.attackPower + 
				"\n  HealPower:   " + this.healPower + 
				"\n  Health:      " + this.hp;
	}
}
