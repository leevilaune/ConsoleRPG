package demo.combat.bots;

import demo.domain.Bot;

public class EarthSpirit extends Bot{
	
	public EarthSpirit(int id, int level) {
		super("Earth Spirit " + id, 200, 50, 50, level);
	}
}
