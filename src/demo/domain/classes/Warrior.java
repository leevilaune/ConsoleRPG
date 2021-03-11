package demo.domain.classes;

import demo.combat.moves.warrior.*;
import demo.domain.ClassBase;
import demo.domain.Player;

public class Warrior extends ClassBase{
	
	public Warrior(Player p) {
		super("Warrior", 
				new Swing(p),
				new Shielding(p),
				new CombatHeal(p),
				new Stab(p));
	}
}
