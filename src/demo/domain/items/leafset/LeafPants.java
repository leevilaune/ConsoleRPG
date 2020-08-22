package demo.domain.items.leafset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class LeafPants extends Gear{
	
	public LeafPants() {
		super("Pants", "Leaf Pants", 55, Rarity.LEGENDARY, Element.EARTH, new Stats(40,70));
	}
	
}
