package demo.combat.moves;

import demo.domain.Move;
import demo.domain.interfaces.Character;

public class Heal implements Move{
	
	private int attackPower;
	private int healPower;
	
	public Heal(int attackPower, int healPower) {
		this.attackPower = attackPower;
		this.healPower = healPower;
	}

	@Override
	public void printDescription() {
		System.out.println("Heal - heals you your heal power ammount");
		
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
	
}
