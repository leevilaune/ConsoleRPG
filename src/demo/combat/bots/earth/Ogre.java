package demo.combat.bots.earth;

import demo.domain.Bot;

public class Ogre extends Bot{

	public Ogre(int id, int level) {
		super("Ogre" + id, 200, 50, 50, level);
	}
}
