package demo.combat.moves;

import demo.domain.Move;
import demo.domain.interfaces.Character;

public class Heal implements Move{
	
	private String name;
	
	private int attackPower;
	private int healPower;
	
	private int turnsForNextUse;
	private int totalTurns;
	
	public Heal(String name, int attackPower, int healPower, int turns) {
		this.name = name;
		this.attackPower = attackPower;
		this.healPower = healPower;
		
		this.turnsForNextUse = turns;
		this.totalTurns = turns;
	}

	@Override
	public String printDescription() {
		return "Heal - heals you your Heal Power ammount";
		
	}

	@Override
	public int getAttack() {
		return this.attackPower;
	}

	@Override
	public void setAttack() {

	}

	@Override
	public int getHeal() {
		return this.healPower;
	}

	@Override
	public void setHeal() {

	}

	@Override
	public void execute(Character c) {
		c.setHP(c.getHP() + this.healPower);
	}
	@Override
	public String getType() {
		return "Heal";
	}

	@Override
	public void waitATurn() {
		System.out.println("  " + this.turnsForNextUse + " Left until next ultimate");
		this.turnsForNextUse -= 1;
	}
	@Override
	public int getTurnsUntilUse() {
		return this.turnsForNextUse;
	}
}
