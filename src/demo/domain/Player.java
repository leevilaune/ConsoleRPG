package demo.domain;

public class Player implements Character {
	
	private String name;
	private Equipment equip;
	private int attackPower;
	private int healPower;
	private int maxHP;
	private int hp;
	
	private int coins;
	
	public Player(Equipment equip) {
		this.name = "Player";
		this.equip = equip;
		this.maxHP = 1000 + this.equip.getHPBoost();
		this.hp = maxHP;
		this.attackPower = equip.getAttackBoost();
		this.healPower = this.maxHP / 2;
		this.coins = 0;
	}
	public Equipment getEquipment() {
		return this.equip;
	}
	public void setEquipment(Equipment equip) {
		this.equip = equip;
	}
	public void setCoins(int c) {
		this.coins = c;
	}
	public int getCoins() {
		return this.coins;
	}
	public void awardCoins(int c) {
		this.coins += c;
	}
	@Override
	public void attack(Character c) {
		System.out.println("  Damage dealt " + this.attackPower + " to " + c.getName());
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
	@Override
	public void setHP(int hp) {
		this.hp = hp;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	public void updateStats() {
		this.attackPower = equip.getAttackBoost();
		this.maxHP += equip.getHPBoost();
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
