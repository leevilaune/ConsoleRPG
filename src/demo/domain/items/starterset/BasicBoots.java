package demo.domain.items.starterset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class BasicBoots extends Gear{
	
	public BasicBoots() {
		super("Boots", "Basic Boots", 20, Rarity.COMMON, Element.NONELEMENTAL, new Stats(20,20));
	}
}