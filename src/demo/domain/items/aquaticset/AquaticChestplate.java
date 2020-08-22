package demo.domain.items.aquaticset;

import demo.domain.enums.Element;
import demo.domain.enums.Rarity;
import demo.domain.Gear;
import demo.domain.Stats;

public class AquaticChestplate extends Gear{
	
	public AquaticChestplate() {
		super("Chestplate", "Aquatic Plate", 40, Rarity.RARE, Element.WATER, new Stats(20,60));
	}
	
}
