package demo.combat.moves;

import java.util.List;

import demo.domain.Character;
import demo.domain.Move;

public class Attack implements Move{

	private int attackPower;
	private int healPower;
	
	public Attack(int attackPower, int healPower) {
		this.attackPower = attackPower;
		this.healPower = healPower;
	}
	
	@Override
	public void printDescription() {
		System.out.println("Attack - basic attack which deals 100% of your attack power");
		
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
		//	
	}

	@Override
	public void execute(Character c) {
		c.setHP(c.getHP()-this.attackPower);
	}
	@Override
	public String getType() {
		return "Attack";
	}
	
}
