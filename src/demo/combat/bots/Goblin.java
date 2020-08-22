package demo.combat.bots;

import demo.domain.Bot;

public class Goblin extends Bot {
	
	public Goblin(int id, int level) {
		super("Goblin " + id, 100, 100, 100, level);
	}
	
}
