package demo.combat.bots;

import demo.domain.Bot;

public class GenericBot extends Bot{

	public GenericBot(int id) {
		super("Generic Bot " + id, 99, 100, 100, 2);
	}
}
