package demo.domain.classes;

import demo.combat.moves.assassin.*;
import demo.combat.moves.warrior.*;
import demo.domain.ClassBase;
import demo.domain.Move;
import demo.domain.Player;

public class Assassin extends ClassBase {

	public Assassin(Player p) {
		super("Assassin",
				new Slash(p),
				new Shielding(p),
				new CombatHeal(p),
				new Stab(p));
	}

}
