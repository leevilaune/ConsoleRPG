package demo.domain.items.aquaticset;

import demo.domain.enums.Element;
import demo.domain.enums.Rarity;
import demo.domain.Gear;
import demo.domain.Stats;

public class AquaticBoots extends Gear{
	
	public AquaticBoots() {
		super("Boots", "Aquatic Boots", 40, Rarity.RARE, Element.WATER, new Stats(30,50));
	}
	
}
