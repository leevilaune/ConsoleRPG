package demo.domain.items.leafset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class LeafDaggers extends Gear{
	
	public LeafDaggers() {
		super("Weapon", "Leaf Daggers", 55, Rarity.LEGENDARY, Element.EARTH, new Stats(60,50));
	}
	
}
