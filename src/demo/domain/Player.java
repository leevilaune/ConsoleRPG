package demo.domain;

import demo.domain.classes.Assassin;
import demo.domain.classes.Warrior;
import demo.domain.interfaces.Character;

public class Player implements Character {
	
	private String name;
	private int level;
	private Equipment equip;
	private int attackPower;
	private int healPower;
	private int maxHP;
	private int hp;
	private LevelingController lvlCtrl;
	private ClassController classCtrl;
	
	private int coins;
	
	private ClassBase classSlot;
	
	public Player(Equipment equip) {
		this.name = "Player";
		this.lvlCtrl = new LevelingController();
		this.level = lvlCtrl.getLevel();
		this.equip = equip;
		this.maxHP = 100000 + this.equip.getHPBoost() + (50*lvlCtrl.getLevel());
		this.hp = maxHP;
		this.attackPower = equip.getAttackBoost();
		this.healPower = this.maxHP / 2;
		this.coins = 0;
		this.classCtrl = new ClassController(this);
		this.classSlot = classCtrl.getPlayerClass("Warrior");
	}
	public int getLevel() {
		return this.getLevelingController().getLevel();
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
		//System.out.println("  Damage dealt " + this.attackPower + " to " + c.getName());
		classSlot.getAttack().execute(c);
	}
	public void block(Character c) {
		System.out.println("  Blocked");
		classSlot.getBlock().execute(c);
	}
	@Override
	public void heal() {
		if(this.hp + this.healPower > this.maxHP) {
			this.hp = this.maxHP;
		}else {
			this.hp += this.healPower;
		}
	}
	public void heal(int healPower) {
		if(this.hp + healPower > this.maxHP) {
			this.hp = this.maxHP;
		}else {
			this.hp += healPower;
		}
	}
	public void ultimate(Character c) {
		classSlot.getUltimate().execute(c);
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
		this.maxHP = equip.getHPBoost() + 10000;
		this.classSlot = classCtrl.getPlayerClass("Assassin");
	}
	public void resetHP() {
		this.hp = maxHP;
	}
	public int getAttackPower() {
		return this.attackPower;
	}
	public int getHealPower() {
		return this.healPower;
	}
	public void addXP(int xp) {
		this.lvlCtrl.addXP(xp);
	}
	public LevelingController getLevelingController() {
		return this.lvlCtrl;
	}
	public ClassBase getPlayerClass() {
		return this.classSlot;
	}
	public void setPlayerClass(ClassBase c) {
		this.classSlot = c;
	}
	
	public String info() {
		updateStats();
		return this.name + ", " + this.lvlCtrl.getLevel() +
				"\n---------------" +
				"\n  AttackPower: " + this.attackPower + 
				"\n  HealPower:   " + this.healPower + 
				"\n  Health:      " + this.hp +
				"\n  Experience:  " + this.lvlCtrl.getXP() + "/" + this.lvlCtrl.getXpForLevel();
	}
	@Override
	public String toString() {
		return this.name + ", " + this.level +
				"\n  AttackPower: " + this.attackPower + 
				"\n  HealPower:   " + this.healPower + 
				"\n  Health:      " + this.hp;
	}
}
