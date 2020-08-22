package demo.domain.items.emberset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class EmberPants extends Gear{
	
	public EmberPants() {
		super("Pants","Ember Pants", 40, Rarity.RARE, Element.FIRE, new Stats(50,30));
	}
	
}
