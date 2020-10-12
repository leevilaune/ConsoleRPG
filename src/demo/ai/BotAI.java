package demo.ai;

import demo.domain.Move;

import java.util.Random;

import demo.combat.moves.*;

public class BotAI {
	
	private Random random;
	private double dodgeChange;
	private int attackPower;
	private int healPower;
	private Heal heal;
	private Attack attack;
	
	public BotAI(int attackPower, int healPower, double dodgeChange) {
		this.random = new Random();
		this.dodgeChange = dodgeChange;
		this.attackPower = attackPower;
		this.healPower = healPower;
		this.attack = new Attack("Base Attack", this.attackPower, this.healPower);
		this.heal = new Heal(this.attackPower, this.healPower);
	}
	//method defininig which move to use
	public Move defineMove(int fullHP, int hp) {
		if(hp < (fullHP / 4)) {
			return this.heal;
		}
		return this.attack;
	}
	public boolean didDodge() {
		if(random.nextDouble() < this.dodgeChange) {
			return true;
		}
		return false;
	}
	public Heal getHeal() {
		return this.heal;
	}
	public void setHeal(Heal heal) {
		this.heal = heal;
	}
	public Attack getAttack() {
		return this.attack;
	}
	public void setAttack(Attack atk) {
		this.attack = atk;
	}
	public double getDodgeChange() {
		return this.dodgeChange;
	}
	public void setDodgeChange(double d) {
		this.dodgeChange = d;
	}
}
