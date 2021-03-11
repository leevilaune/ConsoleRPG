package demo.combat.moves;

import java.util.List;

import demo.domain.Move;
import demo.domain.Player;
import demo.domain.interfaces.Character;

public class Attack implements Move{

	private String name;
	
	private int attackPower;
	private int healPower;
	
	private Player p;
	
	public Attack(String name, int attackPower, int healPower) {
		this.name = name;
		this.attackPower = attackPower;
		this.healPower = healPower;
	}
	public void setPlayer(Player p) {
		this.p = p;
	}
	@Override
	public String printDescription() {
		return "Attack - basic attack which deals 100% of your attack power";
		
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
		System.out.println("  Damage dealt " + this.attackPower + " to " + c.getName());
		c.setHP(c.getHP()-this.attackPower);
	}
	@Override
	public String getType() {
		return "Attack";
	}
	public String toString() {
		return this.name;
	}
	@Override
	public int getTurnsUntilUse() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void waitATurn() {
		// TODO Auto-generated method stub
		
	}
	
}
