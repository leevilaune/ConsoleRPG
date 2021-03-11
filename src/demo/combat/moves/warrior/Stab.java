package demo.combat.moves.warrior;

import demo.combat.moves.Ultimate;
import demo.domain.Move;
import demo.domain.Player;
import demo.domain.interfaces.Character;

public class Stab extends Ultimate implements Move{

	public Stab(Player p) {
		super("Stab",
				(int)Math.round(p.getAttackPower()*2.5),
				p.getHealPower(), p, 4);
	}
	@Override
	public String printDescription() {
		return "Stab - deals 250% of your Attack Power";
	}
}
