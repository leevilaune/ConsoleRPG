package demo.domain;

import demo.ai.BotAI;

public class Bot implements Character{
	
	private String name;
	private BotAI ai;
	private int attackPower;
	private int healPower;
	private int hp;
	private int fullHP;
	private int level;
	
	public Bot(String name, int fullHP, int attackPower,int healPower, int level) {
		this.level = level;
		this.name = name;
		this.attackPower = (attackPower * level) / 2;
		this.healPower = (healPower * level) / 4;
		this.fullHP = (fullHP * level) / 2;
		this.hp = this.fullHP;
		this.ai = new BotAI(this.attackPower, this.healPower);
	}

	public void makeMove(Player p) {
		Move m = ai.defineMove(fullHP, hp);
		if(m.getType().equals("Attack")) {
			m.execute(p);	
		}else {
			m.execute(this);
		}
	}
	public String getName() {
		return this.name;
	}
	public void setHP(int hp) {
		this.hp = hp;
	}

	public void setLevel(int i) {
		this.level = i;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	@Override
	public void attack(Character c) {
		c.setHP(c.getHP() - attackPower);
	}

	@Override
	public void heal() {
		
	}
	
	@Override
	public int getHP() {
		return this.hp;
	}
	@Override
	public String toString() {
		return this.name + " - " + this.level + 
				"\n  AttackPower: " + this.attackPower + 
				"\n  HealPower:   " + this.healPower + 
				"\n  Health:      " + this.hp;
	}

	
}
