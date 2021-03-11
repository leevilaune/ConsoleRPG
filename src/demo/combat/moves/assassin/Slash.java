package demo.combat.moves.assassin;

import demo.combat.moves.Attack;
import demo.domain.Move;
import demo.domain.Player;
import demo.domain.interfaces.Character;

public class Slash extends Attack implements Move{

	private int attackPower;
	
	public Slash(Player p) {
		super("Slash",
				(int)Math.round(p.getAttackPower()*1.3),
				p.getHealPower());
		this.attackPower = (int)Math.round(p.getAttackPower()*1.3);
	}
	@Override
	public String printDescription() {
		return "Slash - Deals 130% of your Attack Power";
	}
	@Override
	public void execute(Character c) {
		System.out.println("Assassin");
		System.out.println(this.attackPower);
		super.execute(c);
	}

}
