package demo.combat.bots;

import demo.domain.Bot;

public class Siren extends Bot{

	public Siren(int id, int level) {
		super("Siren " + id, 100, 150, 50, level);
	}

}
