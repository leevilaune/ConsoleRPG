package demo.domain.items.leafset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class LeafBoots extends Gear{
	
	public LeafBoots() {
		super("Boots", "Leaf Boots", 55, Rarity.LEGENDARY, Element.EARTH, new Stats(55,55));
	}
	
}
