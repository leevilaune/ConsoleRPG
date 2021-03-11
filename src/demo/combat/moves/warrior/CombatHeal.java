package demo.combat.moves.warrior;

import demo.combat.moves.Heal;
import demo.domain.Move;
import demo.domain.Player;

public class CombatHeal extends Heal implements Move {

	public CombatHeal(Player p) {
		super("Combat Heal", p.getAttackPower(), p.getHealPower(), 2);
		// TODO Auto-generated constructor stub
	}
	
	public String printDescription() {
		return "Heal - heals you your Heal Power ammount";
	}
}
