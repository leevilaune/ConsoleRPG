package demo.ai;

import demo.domain.Move;
import demo.combat.moves.*;

public class BotAI {
	
	private int attackPower;
	private int healPower;
	private Heal heal;
	private Attack attack;
	
	public BotAI(int attackPower, int healPower) {
		this.attackPower = attackPower;
		this.healPower = healPower;
		this.attack = new Attack(this.attackPower, this.healPower);
		this.heal = new Heal(this.attackPower, this.healPower);
	}
	//method defininig which move to use
	public Move defineMove(int fullHP, int hp) {
		double hpPercent = hp / fullHP;
		if(hp < (fullHP / 4)) {
			System.out.println("healed");
			return this.heal;
		}
		System.out.println(hpPercent);
		return this.attack;
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
}
