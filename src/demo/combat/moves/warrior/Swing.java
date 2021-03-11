package demo.combat.moves.warrior;

import demo.combat.moves.Attack;
import demo.domain.Move;
import demo.domain.Player;
import demo.domain.interfaces.Character;
import java.lang.String;

public class Swing extends Attack implements Move{

	private int attackPower;
	
	public Swing(Player p) {
		super("Swing",
				(int)Math.round(p.getAttackPower()*1.1),
				p.getHealPower());
		this.attackPower = (int)Math.round(p.getAttackPower()*1.1);
	}
	@Override
	public String printDescription() {
		return "Swing - attack which deals 110% of your Attack Power";
	}
	@Override
	public void execute(Character c) {
		System.out.println("Warrior");
		System.out.println(this.attackPower);
		super.execute(c);
	}
}
