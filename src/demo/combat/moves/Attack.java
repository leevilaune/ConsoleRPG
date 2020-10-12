package demo.combat.moves;

import java.util.List;

import demo.domain.Move;
import demo.domain.interfaces.Character;

public class Attack implements Move{

	private String name;
	
	private int attackPower;
	private int healPower;
	
	public Attack(String name, int attackPower, int healPower) {
		this.name = name;
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
	
	public String toString() {
		return this.name;
	}
	
}
