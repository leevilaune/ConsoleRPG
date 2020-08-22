package demo.domain.items.leafset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class LeafChestplate extends Gear{
	
	public LeafChestplate() {
		super("Chestplate", "Leaf Chestplate", 55, Rarity.LEGENDARY, Element.EARTH, new Stats(30,80));
	}
	
}
