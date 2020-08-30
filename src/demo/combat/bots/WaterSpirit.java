package demo.combat.bots;

import demo.domain.Bot;

public class WaterSpirit extends Bot{
	public WaterSpirit(int id, int level) {
		super("Water Spirit " + id, 175, 50, 75, level);
	}
}
