package demo.domain.items.emberset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class EmberBoots extends Gear{

	public EmberBoots() {
		super("Boots", "Ember Boots", 40, Rarity.RARE, Element.FIRE, new Stats(50,30));
	}
	
}