package demo.domain;

public class Stats {
	
	private int attack;
	private int hp;
	
	public Stats(int atk, int hp) {
		this.attack = atk;
		this.hp = hp;
	}
	public void setAttack(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return this.attack;
	}
	public void setHP(int hp) {
		this.hp = hp;
	}
	public int getHP() {
		return this.hp;
	}
	public String toString() {
		return 	"\n    Attack:  " + this.attack + 
				"\n    Health:  " + this.hp;
	}
}
