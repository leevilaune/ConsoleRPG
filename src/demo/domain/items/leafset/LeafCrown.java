package demo.domain.items.leafset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class LeafCrown extends Gear{
	
	public LeafCrown() {
		super("Helmet", "Leaf Crown", 55, Rarity.LEGENDARY, Element.EARTH, new Stats(55,55));
	}
	
}
