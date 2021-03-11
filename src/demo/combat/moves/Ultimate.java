package demo.combat.moves;

import demo.domain.Move;
import demo.domain.interfaces.Character;
import demo.domain.Player;

public class Ultimate implements Move{

	private String name;
	
	private int attackPower;
	private int healPower;
	
	private Player player;
	
	private int turnsForNextUse;
	private int totalTurns;
	
	public Ultimate(String name, int attackPower, int healPower, Player p, int turns) {
		this.name = name;
		this.attackPower = attackPower;
		this.healPower = healPower;
		this.player = p;
		this.turnsForNextUse = turns;
		this.totalTurns = turns;
	}
	
	@Override
	public String printDescription() {
		return "Ultimate";
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Character c) {
		if(this.turnsForNextUse == 0) {
			player.updateStats();
			c.setHP(c.getHP()-(this.attackPower));
			player.heal(this.healPower);
			System.out.println("  Damage dealt " + this.attackPower + " to " + c.getName());
			System.out.println("  and Healed " + this.healPower);
			this.turnsForNextUse = totalTurns;
		}else {
			waitATurn();
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Ultimate";
	}
	@Override
	public void waitATurn() {
		System.out.println("  " + this.turnsForNextUse + " Left until next ultimate");
		this.turnsForNextUse -= 1;
	}
	@Override
	public int getTurnsUntilUse() {
		// TODO Auto-generated method stub
		return this.turnsForNextUse;
	}

}
