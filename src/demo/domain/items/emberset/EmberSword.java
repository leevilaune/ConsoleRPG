package demo.domain.items.emberset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class EmberSword extends Gear{
	
	public EmberSword() {
		super("Weapon", "Ember Sword", 40, Rarity.RARE, Element.FIRE, new Stats(60,20));
	}
	
}