package demo.domain.items.breezeset;

import demo.domain.Gear;
import demo.domain.Stats;
import demo.domain.enums.Element;
import demo.domain.enums.Rarity;

public class BreezeBoots extends Gear {
	
	public BreezeBoots() {
		super("Boots", "Breeze Boots", 35, Rarity.RARE, Element.AIR, new Stats(40,30));
	}
}	
